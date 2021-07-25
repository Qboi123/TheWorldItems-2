//Deobfuscated with https://github.com/PetoPetko/Minecraft-Deobfuscator3000 using mappings "mcp_snapshot-20171003-1.12"!

/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.creativetab.CreativeTabs
 *  net.minecraft.item.ItemStack
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package mod.mcreator;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class mcreator_objects3D extends theworlditems2.ModElement {
    public static CreativeTabs tab = new CreativeTabs("tabobjects3d"){

        @SideOnly(value=Side.CLIENT)
        public ItemStack getTabIconItem() {
            return new ItemStack(mcreator_samsungLaptop.block, 1);
        }

        @SideOnly(value=Side.CLIENT)
        public boolean hasSearchBar() {
            return false;
        }
    };
}

