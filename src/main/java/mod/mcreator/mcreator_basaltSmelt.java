/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.item.ItemStack
 *  net.minecraftforge.fml.common.event.FMLInitializationEvent
 *  net.minecraftforge.fml.common.registry.GameRegistry
 */
package mod.mcreator;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class mcreator_basaltSmelt extends theworlditems2.ModElement {
    @Override
    public void load(FMLInitializationEvent event) {
        ItemStack smeltStack = new ItemStack(mcreator_basalt.block, 1);
        GameRegistry.addSmelting(new ItemStack(mcreator_basaltCobble.block, 1), smeltStack, 1.0f);
    }
}

