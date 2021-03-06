//Deobfuscated with https://github.com/PetoPetko/Minecraft-Deobfuscator3000 using mappings "mcp_snapshot-20171003-1.12"!

/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.renderer.block.model.ModelResourceLocation
 *  net.minecraft.creativetab.CreativeTabs
 *  net.minecraft.inventory.EntityEquipmentSlot
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemArmor
 *  net.minecraft.item.ItemArmor$ArmorMaterial
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
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;

public class mcreator_bastaltArmor extends theworlditems2.ModElement {
    public static Item helmet;
    public static Item body;
    public static Item legs;
    public static Item boots;

    @Override
    public void load(FMLInitializationEvent event) {
        if (event.getSide() == Side.CLIENT) {
            Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(helmet, 0, new ModelResourceLocation("theworlditems2:bastaltarmorhelmet", "inventory"));
            Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(body, 0, new ModelResourceLocation("theworlditems2:bastaltarmorbody", "inventory"));
            Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(legs, 0, new ModelResourceLocation("theworlditems2:bastaltarmorlegs", "inventory"));
            Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(boots, 0, new ModelResourceLocation("theworlditems2:bastaltarmorboots", "inventory"));
        }
        helmet.setCreativeTab(CreativeTabs.COMBAT);
        body.setCreativeTab(CreativeTabs.COMBAT);
        legs.setCreativeTab(CreativeTabs.COMBAT);
        boots.setCreativeTab(CreativeTabs.COMBAT);
    }

    static {
        ItemArmor.ArmorMaterial enuma = EnumHelper.addArmorMaterial("BASTALTARMOR", "basaltarmor", 76, new int[]{4, 5, 6, 4}, 17, null, 0.9f);
        helmet = new ItemArmor(enuma, 0, EntityEquipmentSlot.HEAD).setUnlocalizedName("bastaltarmorhelmet");
        helmet.setMaxStackSize(1);
        body = new ItemArmor(enuma, 0, EntityEquipmentSlot.CHEST).setUnlocalizedName("bastaltarmorbody");
        body.setMaxStackSize(1);
        legs = new ItemArmor(enuma, 0, EntityEquipmentSlot.LEGS).setUnlocalizedName("bastaltarmorlegs");
        legs.setMaxStackSize(1);
        boots = new ItemArmor(enuma, 0, EntityEquipmentSlot.FEET).setUnlocalizedName("bastaltarmorboots");
        boots.setMaxStackSize(1);
        helmet.setRegistryName("bastaltarmorhelmet");
        ForgeRegistries.ITEMS.register(helmet);
        body.setRegistryName("bastaltarmorbody");
        ForgeRegistries.ITEMS.register(body);
        legs.setRegistryName("bastaltarmorlegs");
        ForgeRegistries.ITEMS.register(legs);
        boots.setRegistryName("bastaltarmorboots");
        ForgeRegistries.ITEMS.register(boots);
    }
}

