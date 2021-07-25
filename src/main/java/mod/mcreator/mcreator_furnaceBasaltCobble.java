//Deobfuscated with https://github.com/PetoPetko/Minecraft-Deobfuscator3000 using mappings "mcp_snapshot-20171003-1.12"!

/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.init.Blocks
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.crafting.Ingredient
 *  net.minecraft.util.ResourceLocation
 *  net.minecraftforge.fml.common.event.FMLInitializationEvent
 *  net.minecraftforge.fml.common.registry.GameRegistry
 */
package mod.mcreator;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class mcreator_furnaceBasaltCobble extends theworlditems2.ModElement {
    @Override
    public void load(FMLInitializationEvent event) {
        ItemStack recStack = new ItemStack(Blocks.FURNACE, 1);
        Object[] recipe = new Object[]{"012", "3 5", "678", Character.valueOf('0'), Ingredient.fromStacks(new ItemStack[]{new ItemStack(mcreator_basaltCobble.block, 1)}), Character.valueOf('1'), Ingredient.fromStacks(new ItemStack[]{new ItemStack(mcreator_basaltCobble.block, 1)}), Character.valueOf('2'), Ingredient.fromStacks(new ItemStack[]{new ItemStack(mcreator_basaltCobble.block, 1)}), Character.valueOf('3'), Ingredient.fromStacks(new ItemStack[]{new ItemStack(mcreator_basaltCobble.block, 1)}), Character.valueOf('5'), Ingredient.fromStacks(new ItemStack[]{new ItemStack(mcreator_basaltCobble.block, 1)}), Character.valueOf('6'), Ingredient.fromStacks(new ItemStack[]{new ItemStack(mcreator_basaltCobble.block, 1)}), Character.valueOf('7'), Ingredient.fromStacks(new ItemStack[]{new ItemStack(mcreator_basaltCobble.block, 1)}), Character.valueOf('8'), Ingredient.fromStacks(new ItemStack[]{new ItemStack(mcreator_basaltCobble.block, 1)})};
        GameRegistry.addShapedRecipe(new ResourceLocation("theworlditems2:furnacebasaltcobble"), new ResourceLocation("custom"), recStack, recipe);
    }
}

