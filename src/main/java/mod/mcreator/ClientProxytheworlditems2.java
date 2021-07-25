/*
 * Decompiled with CFR 0.150.
 */
package mod.mcreator;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Objects;

public class ClientProxytheworlditems2 extends CommonProxytheworlditems2 {
    @Override
    public void registerRenderers(theworlditems2 instance) {
        theworlditems2.elements.forEach(theworlditems2.ModElement::registerRenderers);
    }

    public void registerBlockModel(Block block) {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0,
                new ModelResourceLocation(Objects.requireNonNull(block.getRegistryName()),"inventory"));
    }

    public void registerItemModel(Item item) {
        ModelLoader.setCustomModelResourceLocation(item, 0,
                new ModelResourceLocation(Objects.requireNonNull(item.getRegistryName()),"inventory"));
    }

    @SubscribeEvent
    public void registerModels(ModelRegistryEvent event) {
        registerBlockModel(mcreator_achileaCaronatioGold.block);
        registerItemModel(mcreator_amethist.block);
        registerItemModel(mcreator_amethistArmor.helmet);
        registerItemModel(mcreator_amethistArmor.body);
        registerItemModel(mcreator_amethistArmor.legs);
        registerItemModel(mcreator_amethistArmor.boots);
        registerItemModel(mcreator_amethistAxe.block);
        registerItemModel(mcreator_amethistHoe.block);
        registerBlockModel(mcreator_amethistOre.block);
        registerItemModel(mcreator_amethistPickaxe.block);
        registerItemModel(mcreator_amethistShovel.block);
        registerItemModel(mcreator_amethistSword.block);
        registerItemModel(mcreator_aquamarine.block);
//        registerItemModel(mcreator_aquamarineArmor.helmet);
//        registerItemModel(mcreator_aquamarineArmor.body);
//        registerItemModel(mcreator_aquamarineArmor.legs);
//        registerItemModel(mcreator_aquamarineArmor.boots);
        registerItemModel(mcreator_aquamarineAxe.block);
        registerItemModel(mcreator_aquamarineHoe.block);
        registerBlockModel(mcreator_aquamarineOre.block);
        registerItemModel(mcreator_aquamarinePickaxe.block);
        registerItemModel(mcreator_aquamarineShovel.block);
        registerItemModel(mcreator_aquamarineSword.block);
        registerBlockModel(mcreator_basalt.block);
//        registerItemModel(mcreator_basaltArmor.helmet);
//        registerItemModel(mcreator_basaltArmor.body);
//        registerItemModel(mcreator_basaltArmor.legs);
//        registerItemModel(mcreator_basaltArmor.boots);
        registerItemModel(mcreator_basaltAxe.block);
        registerItemModel(mcreator_basaltHoe.block);
        registerBlockModel(mcreator_basaltCobble.block);
        registerItemModel(mcreator_basaltPickaxe.block);
//        registerItemModel(mcreator_basaltShovel.block);
        registerItemModel(mcreator_basaltSword.block);
//        registerBlockModel(mcreator_emerald.block);
//        registerItemModel(mcreator_emeraldArmor.helmet);
//        registerItemModel(mcreator_emeraldArmor.body);
//        registerItemModel(mcreator_emeraldArmor.legs);
//        registerItemModel(mcreator_emeraldArmor.boots);
//        registerItemModel(mcreator_emeraldAxe.block);
        registerItemModel(mcreator_emeraldHoe.block);
//        registerBlockModel(mcreator_emeraldOre.block);
        registerItemModel(mcreator_emeraldPickaxe.block);
        registerItemModel(mcreator_emeraldShovel.block);
        registerItemModel(mcreator_emeraldSword.block);
        registerItemModel(mcreator_mountianCrystal.block);
        registerItemModel(mcreator_mountianCrystalArmor.helmet);
        registerItemModel(mcreator_mountianCrystalArmor.body);
        registerItemModel(mcreator_mountianCrystalArmor.legs);
        registerItemModel(mcreator_mountianCrystalArmor.boots);
        registerItemModel(mcreator_mountianCrystalAxe.block);
//        registerItemModel(mcreator_mountianCrystalHoe.block);
        registerBlockModel(mcreator_mountianCrystalOre.block);
        registerItemModel(mcreator_mountianCrystalPickaxe.block);
        registerItemModel(mcreator_mountianCrystalShovel.block);
        registerItemModel(mcreator_mountianCrystalSword.block);
        registerItemModel(mcreator_rubyGem.block);
        registerItemModel(mcreator_rubyArmor.helmet);
        registerItemModel(mcreator_rubyArmor.body);
        registerItemModel(mcreator_rubyArmor.legs);
        registerItemModel(mcreator_rubyArmor.boots);
        registerItemModel(mcreator_rubyAxe.block);
        registerItemModel(mcreator_rubyHoe.block);
        registerBlockModel(mcreator_rubyOre.block);
        registerItemModel(mcreator_rubyPickaxe.block);
        registerItemModel(mcreator_rubyShovel.block);
        registerItemModel(mcreator_rubySickle.block);
        registerItemModel(mcreator_rubySword.block);
    }
}
