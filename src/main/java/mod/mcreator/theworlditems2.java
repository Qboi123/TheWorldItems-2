//Deobfuscated with https://github.com/PetoPetko/Minecraft-Deobfuscator3000 using mappings "mcp_snapshot-20171003-1.12"!

/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.item.ItemStack
 *  net.minecraft.world.World
 *  net.minecraft.world.chunk.IChunkProvider
 *  net.minecraft.world.gen.IChunkGenerator
 *  net.minecraftforge.client.model.obj.OBJLoader
 *  net.minecraftforge.fml.common.IFuelHandler
 *  net.minecraftforge.fml.common.IWorldGenerator
 *  net.minecraftforge.fml.common.Mod
 *  net.minecraftforge.fml.common.Mod$EventHandler
 *  net.minecraftforge.fml.common.Mod$Instance
 *  net.minecraftforge.fml.common.SidedProxy
 *  net.minecraftforge.fml.common.event.FMLInitializationEvent
 *  net.minecraftforge.fml.common.event.FMLPreInitializationEvent
 *  net.minecraftforge.fml.common.event.FMLServerStartingEvent
 *  net.minecraftforge.fml.common.network.IGuiHandler
 *  net.minecraftforge.fml.common.network.NetworkRegistry
 *  net.minecraftforge.fml.common.registry.GameRegistry
 *  net.minecraftforge.fml.relauncher.Side
 */
package mod.mcreator;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.fml.common.IFuelHandler;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SuppressWarnings({"deprecation", "unused"})
@Mod(modid="theworlditems2", version="1.4.1", acceptedMinecraftVersions="[1.12.2]")
public class theworlditems2 implements IFuelHandler, IWorldGenerator {
    public static final String MODID = "theworlditems2";
    public static final String VERSION = "1.4.1";
    @SidedProxy(clientSide="mod.mcreator.ClientProxytheworlditems2", serverSide="mod.mcreator.CommonProxytheworlditems2")
    public static CommonProxytheworlditems2 proxy;
    @Mod.Instance(value="theworlditems2")
    public static theworlditems2 instance;
    public static final List<ModElement> elements;

    public int getBurnTime(ItemStack fuel) {
        for (ModElement element : elements) {
            int ret = element.addFuel(fuel);
            if (ret == 0) continue;
            return ret;
        }
        return 0;
    }

    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        int f_chunkX = chunkX * 16;
        int f_chunkZ = chunkZ * 16;
        if (world.provider.getDimension() == -1) {
            elements.forEach(element -> element.generateNether(world, random, f_chunkX, f_chunkZ));
        }
        if (world.provider.getDimension() == 0) {
            elements.forEach(element -> element.generateSurface(world, random, f_chunkX, f_chunkZ));
        }
    }

    @Mod.EventHandler
    public void load(FMLInitializationEvent event) {
        GameRegistry.registerFuelHandler(this);
        GameRegistry.registerWorldGenerator(this, 5);
        NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
        elements.forEach(element -> element.load(event));
        proxy.registerRenderers(this);
    }

    @Mod.EventHandler
    public void serverLoad(FMLServerStartingEvent event) {
        elements.forEach(element -> element.serverLoad(event));
    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        if (event.getSide() == Side.CLIENT) {
            OBJLoader.INSTANCE.addDomain(MODID);
        }
        elements.forEach(element -> {
            ModElement.instance = instance;
            element.preInit(event);
        });
    }

    static {
        elements = new ArrayList<>();
        elements.add(new mcreator_basalt());
        elements.add(new mcreator_basaltCobble());
        elements.add(new mcreator_basaltSmelt());
        elements.add(new mcreator_furnaceBasalt());
        elements.add(new mcreator_furnaceBasaltCobble());
        elements.add(new mcreator_bastaltArmor());
        elements.add(new mcreator_rubyOre());
        elements.add(new mcreator_rubyGem());
        elements.add(new mcreator_rubyAxe());
        elements.add(new mcreator_rubyHoe());
        elements.add(new mcreator_rubySword());
        elements.add(new mcreator_rubyPickaxe());
        elements.add(new mcreator_rubyShovel());
        elements.add(new mcreator_rubySickle());
        elements.add(new mcreator_rubyBlock());
        elements.add(new mcreator_diamondSickle());
        elements.add(new mcreator_achileaCaronatioGold());
        elements.add(new mcreator_aquamarineOre());
        elements.add(new mcreator_mountianCrystalOre());
        elements.add(new mcreator_amethistOre());
        elements.add(new mcreator_aquamarineSword());
        elements.add(new mcreator_mountianCrystalSword());
        elements.add(new mcreator_amethistSword());
        elements.add(new mcreator_amethistArmor());
        elements.add(new mcreator_rubyArmor());
        elements.add(new mcreator_mountianCrystalArmor());
        elements.add(new mcreator_mountianCrystalShovel());
        elements.add(new mcreator_amethistShovel());
        elements.add(new mcreator_aquamarineShovel());
        elements.add(new mcreator_mountianCrystalPickaxe());
        elements.add(new mcreator_amethistPickaxe());
        elements.add(new mcreator_aquamarinePickaxe());
        elements.add(new mcreator_mountianCrystalAxe());
        elements.add(new mcreator_amethistAxe());
        elements.add(new mcreator_aquamarineAxe());
        elements.add(new mcreator_moutianCrystalHoe());
        elements.add(new mcreator_amethistHoe());
        elements.add(new mcreator_aquamarineHoe());
        elements.add(new mcreator_mountianCrystal());
        elements.add(new mcreator_amethist());
        elements.add(new mcreator_aquamarine());
        elements.add(new mcreator_mountianCrystalSwordRecipe());
        elements.add(new mcreator_amethistSwordRecipe());
        elements.add(new mcreator_aquamarineSwordRecipe());
        elements.add(new mcreator_mountianCrystalShovelRecipe());
        elements.add(new mcreator_amethistShovelRecipe());
        elements.add(new mcreator_aquamarineShovelRecipe());
        elements.add(new mcreator_mountianCrystalPickaxeRecipe());
        elements.add(new mcreator_amethistPickaxeRecipe());
        elements.add(new mcreator_aquamarinePickaxeRecipe());
        elements.add(new mcreator_mountianCrystalAxeRecipe());
        elements.add(new mcreator_amethistAxeRecipe());
        elements.add(new mcreator_aquamarineAxeRecipe());
        elements.add(new mcreator_mountianCrystalHoeRecipe());
        elements.add(new mcreator_amethistHoeRecipe());
        elements.add(new mcreator_aquamarineHoeRecipe());
        elements.add(new mcreator_basaltSword());
        elements.add(new mcreator_basaltshovel());
        elements.add(new mcreator_basaltPickaxe());
        elements.add(new mcreator_basaltAxe());
        elements.add(new mcreator_basaltHoe());
        elements.add(new mcreator_basaltSwordRecipe());
        elements.add(new mcreator_basaltShovelRecipe());
        elements.add(new mcreator_basaltPickaxeRecipe());
        elements.add(new mcreator_basaltAxeRecipe());
        elements.add(new mcreator_basaltHoeRecipe());
        elements.add(new mcreator_basaltSwordRecipeC());
        elements.add(new mcreator_basaltShovelRecipeC());
        elements.add(new mcreator_basaltPickaxeRecipeC());
        elements.add(new mcreator_basaltAxeRecipeC());
        elements.add(new mcreator_basaltHoeRecipeC());
        elements.add(new mcreator_emeraldSword());
        elements.add(new mcreator_emeraldShovel());
        elements.add(new mcreator_emeraldPickaxe());
        elements.add(new mcreator_emerladAxe());
        elements.add(new mcreator_emeraldHoe());
        elements.add(new mcreator_emeraldSwordRecipe());
        elements.add(new mcreator_emeraldShovelRecipe());
        elements.add(new mcreator_emeraldPickaxeRecipe());
        elements.add(new mcreator_emeraldAxeRecipe());
        elements.add(new mcreator_emeraldHoeRecipe());
        elements.add(new mcreator_chatForFirst());
        elements.add(new mcreator_letsChatEvent());
        elements.add(new mcreator_cmdExplodeEvent());
        elements.add(new mcreator_cmdExplode());
        elements.add(new mcreator_cmdLightningEvent());
        elements.add(new mcreator_cmdLightning());
        elements.add(new mcreator_cmdSwitchDimensionProcedure());
        elements.add(new mcreator_cmdChangeDimension());
        elements.add(new mcreator_roadBlockDark());
        elements.add(new mcreator_roadBlockLight());
        elements.add(new mcreator_roadBlockFine());
        elements.add(new mcreator_roadBlockWhite());
        elements.add(new mcreator_roadBlockYellow());
        elements.add(new mcreator_roadBlockRed());
        elements.add(new mcreator_roadBlockGreen());
        elements.add(new mcreator_roadBlockBlue());
        elements.add(new mcreator_iPhone());
        elements.add(new mcreator_samsungLaptop());
        elements.add(new mcreator_antenna());
        elements.add(new mcreator_gateEnd());
        elements.add(new mcreator_gateHell());
        elements.add(new mcreator_objects3D());
        elements.add(new mcreator_beamerPhase1());
        elements.add(new mcreator_beamerPhase2());
        elements.add(new mcreator_beamerPhase3());
        elements.add(new mcreator_beamerPhase4());
        elements.add(new mcreator_oldWoods());
    }

    public static class ModElement {
        public static Object instance;

        public void load(FMLInitializationEvent event) {
        }

        public void generateNether(World world, Random random, int chunkX, int chunkZ) {
        }

        public void generateSurface(World world, Random random, int chunkX, int chunkZ) {
        }

        public void serverLoad(FMLServerStartingEvent event) {
        }

        public void preInit(FMLPreInitializationEvent event) {
        }

        public void registerRenderers() {
        }

        public int addFuel(ItemStack fuel) {
            return 0;
        }
    }

    public static class GuiHandler
    implements IGuiHandler {
        public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
            return null;
        }

        public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
            return null;
        }
    }
}

