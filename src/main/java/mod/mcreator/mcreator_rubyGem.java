//Deobfuscated with https://github.com/PetoPetko/Minecraft-Deobfuscator3000 using mappings "mcp_snapshot-20171003-1.12"!

/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.state.IBlockState
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.renderer.block.model.ModelResourceLocation
 *  net.minecraft.creativetab.CreativeTabs
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraftforge.fml.common.event.FMLInitializationEvent
 *  net.minecraftforge.fml.common.registry.ForgeRegistries
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.registries.IForgeRegistryEntry
 */
package mod.mcreator;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;

public class mcreator_rubyGem extends theworlditems2.ModElement {
    public static Item block = new ItemCustom();

    @Override
    public void load(FMLInitializationEvent event) {
        if (event.getSide() == Side.CLIENT) {
            Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(block, 0, new ModelResourceLocation("theworlditems2:rubygem", "inventory"));
        }
    }

    public static class ItemCustom
    extends Item {
        public ItemCustom() {
            this.setMaxDamage(0);
            this.maxStackSize = 48;
            this.setUnlocalizedName("rubygem");
            this.setRegistryName("rubygem");
            this.setCreativeTab(CreativeTabs.MISC);
            ForgeRegistries.ITEMS.register(this);
        }

        public int getItemEnchantability() {
            return 0;
        }

        public int getMaxItemUseDuration(ItemStack par1ItemStack) {
            return 0;
        }

        public float getDestroySpeed(ItemStack par1ItemStack, IBlockState par2Block) {
            return 1.0f;
        }

        public boolean canHarvestBlock(IBlockState state, ItemStack stack) {
            return true;
        }
    }
}

