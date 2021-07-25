//Deobfuscated with https://github.com/PetoPetko/Minecraft-Deobfuscator3000 using mappings "mcp_snapshot-20171003-1.12"!

/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockFlower
 *  net.minecraft.block.BlockFlower$EnumFlowerColor
 *  net.minecraft.block.BlockFlower$EnumFlowerType
 *  net.minecraft.block.SoundType
 *  net.minecraft.block.state.IBlockState
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.renderer.block.model.ModelResourceLocation
 *  net.minecraft.creativetab.CreativeTabs
 *  net.minecraft.init.Items
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemBlock
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.NonNullList
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 *  net.minecraft.world.gen.feature.WorldGenFlowers
 *  net.minecraftforge.fml.common.event.FMLInitializationEvent
 *  net.minecraftforge.fml.common.event.FMLPreInitializationEvent
 *  net.minecraftforge.fml.common.registry.ForgeRegistries
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 *  net.minecraftforge.registries.IForgeRegistryEntry
 */
package mod.mcreator;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenFlowers;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Objects;
import java.util.Random;

public class mcreator_achileaCaronatioGold extends theworlditems2.ModElement {
    public static Block block = new BlockCustomFlower().setHardness(0.11f).setResistance(2.0f).setLightLevel(0.0f).setUnlocalizedName("achileacaronatiogold");

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        block.setRegistryName("achileacaronatiogold");
        ForgeRegistries.BLOCKS.register(block);
        ForgeRegistries.ITEMS.register(new ItemBlock(block).setRegistryName(Objects.requireNonNull(block.getRegistryName())));
    }

    @Override
    public void load(FMLInitializationEvent event) {
        if (event.getSide() == Side.CLIENT) {
            Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation("theworlditems2:achileacaronatiogold", "inventory"));
        }
    }

    @Override
    public void generateSurface(World world, Random random, int chunkX, int chunkZ) {
        for (int i = 0; i < 1; ++i) {
            int l6 = chunkX + random.nextInt(16) + 8;
            int i11 = random.nextInt(128);
            int l14 = chunkZ + random.nextInt(16) + 8;
            new WorldGenFlowers((BlockFlower)block, BlockFlower.EnumFlowerType.DANDELION).generate(world, random, new BlockPos(l6, i11, l14));
        }
    }

    public static class BlockCustomFlower
    extends BlockFlower {
        public BlockCustomFlower() {
            this.setSoundType(SoundType.GROUND);
            this.setCreativeTab(CreativeTabs.DECORATIONS);
        }

        public BlockFlower.EnumFlowerColor getBlockType() {
            return BlockFlower.EnumFlowerColor.YELLOW;
        }

        @SideOnly(value=Side.CLIENT)
        public void getSubBlocks(CreativeTabs tab, NonNullList<ItemStack> list) {
            for (BlockFlower.EnumFlowerType blockflower$enumflowertype : BlockFlower.EnumFlowerType.getTypes(this.getBlockType())) {
                list.add(new ItemStack(this, 1, blockflower$enumflowertype.getMeta()));
            }
        }

        public int quantityDropped(Random random) {
            return 2;
        }

        public Item getItemDropped(IBlockState state, Random rand, int fortune) {
            return new ItemStack(Items.DYE, 1, 11).getItem();
        }
    }
}

