//Deobfuscated with https://github.com/PetoPetko/Minecraft-Deobfuscator3000 using mappings "mcp_snapshot-20171003-1.12"!

/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.SoundType
 *  net.minecraft.block.material.Material
 *  net.minecraft.block.state.IBlockState
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.renderer.block.model.ModelResourceLocation
 *  net.minecraft.creativetab.CreativeTabs
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemBlock
 *  net.minecraft.util.BlockRenderLayer
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.IBlockAccess
 *  net.minecraft.world.World
 *  net.minecraft.world.gen.feature.WorldGenMinable
 *  net.minecraftforge.fml.common.event.FMLInitializationEvent
 *  net.minecraftforge.fml.common.event.FMLPreInitializationEvent
 *  net.minecraftforge.fml.common.registry.ForgeRegistries
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 *  net.minecraftforge.registries.IForgeRegistryEntry
 */
package mod.mcreator;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Objects;
import java.util.Random;

public class mcreator_amethistOre extends theworlditems2.ModElement {
    public static Block block = new BlockCustom().setHardness(5.15f).setResistance(14.0f).setLightLevel(0.0f).setUnlocalizedName("amethistore").setLightOpacity(255).setCreativeTab(CreativeTabs.BUILDING_BLOCKS);

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        block.setHarvestLevel("pickaxe", 5);
        block.setRegistryName("amethistore");
        ForgeRegistries.BLOCKS.register(block);
        ForgeRegistries.ITEMS.register(new ItemBlock(block).setRegistryName(Objects.requireNonNull(block.getRegistryName())));
    }

    @Override
    public void load(FMLInitializationEvent event) {
        if (event.getSide() == Side.CLIENT) {
            Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation("theworlditems2:amethistore", "inventory"));
        }
    }

    @Override
    public void generateSurface(World world, Random random, int chunkX, int chunkZ) {
        for (int i = 0; i < 6; ++i) {
            int x = chunkX + random.nextInt(16);
            int y = random.nextInt(57) + 10;
            int z = chunkZ + random.nextInt(16);
            new WorldGenMinable(block.getDefaultState(), 4).generate(world, random, new BlockPos(x, y, z));
        }
    }

    @SuppressWarnings("deprecation")
    public static class BlockCustom
    extends Block {
        private final boolean red = false;

        public BlockCustom() {
            super(Material.ROCK);
            this.setSoundType(SoundType.STONE);
        }

        @SideOnly(value=Side.CLIENT)
        public BlockRenderLayer getBlockLayer() {
            return BlockRenderLayer.SOLID;
        }

        public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
            return new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 1.0, 1.0);
        }

        public int tickRate(World world) {
            return 10;
        }

        public int quantityDropped(Random random) {
            return 1;
        }

        public int getWeakPower(IBlockState state, IBlockAccess baccess, BlockPos pos, EnumFacing side) {
            return this.red ? 15 : 0;
        }

        public int getStrongPower(IBlockState state, IBlockAccess baccess, BlockPos pos, EnumFacing side) {
            return this.red ? 15 : 0;
        }
    }
}

