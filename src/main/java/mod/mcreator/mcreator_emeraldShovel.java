//Deobfuscated with https://github.com/PetoPetko/Minecraft-Deobfuscator3000 using mappings "mcp_snapshot-20171003-1.12"!

/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.renderer.block.model.ModelResourceLocation
 *  net.minecraft.creativetab.CreativeTabs
 *  net.minecraft.item.Item
 *  net.minecraft.item.Item$ToolMaterial
 *  net.minecraft.item.ItemSpade
 *  net.minecraft.item.ItemStack
 *  net.minecraftforge.common.util.EnumHelper
 *  net.minecraftforge.fml.common.event.FMLInitializationEvent
 *  net.minecraftforge.fml.common.registry.ForgeRegistries
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.registries.IForgeRegistryEntry
 */
package mod.mcreator;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;

import java.util.HashMap;
import java.util.Set;

public class mcreator_emeraldShovel extends theworlditems2.ModElement {
    public static Item block;

    @Override
    public void load(FMLInitializationEvent event) {
        if (event.getSide() == Side.CLIENT) {
            Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(block, 0, new ModelResourceLocation("theworlditems2:emeraldshovel", "inventory"));
        }
    }

    static {
        Item.ToolMaterial enumt = EnumHelper.addToolMaterial("EMERALDSHOVEL", 1, 120, 4.0f, 5.0f, 2);
        block = new ItemSpade(enumt){

            public Set<String> getToolClasses(ItemStack stack) {
                HashMap<String, Integer> ret = new HashMap<String, Integer>();
                ret.put("spade", 1);
                return ret.keySet();
            }
        }.setUnlocalizedName("emeraldshovel");
        block.setRegistryName("emeraldshovel");
        block.setCreativeTab(CreativeTabs.TOOLS);
        ForgeRegistries.ITEMS.register(block);
    }
}

