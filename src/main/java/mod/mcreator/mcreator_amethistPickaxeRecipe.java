//Deobfuscated with https://github.com/PetoPetko/Minecraft-Deobfuscator3000 using mappings "mcp_snapshot-20171003-1.12"!

/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.init.Items
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.crafting.Ingredient
 *  net.minecraft.util.ResourceLocation
 *  net.minecraftforge.fml.common.event.FMLInitializationEvent
 *  net.minecraftforge.fml.common.registry.GameRegistry
 */
package mod.mcreator;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class mcreator_amethistPickaxeRecipe extends theworlditems2.ModElement {
    @Override
    public void load(FMLInitializationEvent event) {
        ItemStack recStack = new ItemStack(mcreator_amethistPickaxe.block, 1);
        Object[] recipe = new Object[]{"012", " 4 ", " 7 ", '0', Ingredient.fromStacks(new ItemStack(mcreator_amethist.block, 1)), '1', Ingredient.fromStacks(new ItemStack(mcreator_amethist.block, 1)), '2', Ingredient.fromStacks(new ItemStack(mcreator_amethist.block, 1)), '4', Ingredient.fromStacks(new ItemStack(Items.STICK, 1)), '7', Ingredient.fromStacks(new ItemStack(Items.STICK, 1))};
        GameRegistry.addShapedRecipe(new ResourceLocation("theworlditems2:amethistpickaxerecipe"), new ResourceLocation("custom"), recStack, recipe);
    }
}

