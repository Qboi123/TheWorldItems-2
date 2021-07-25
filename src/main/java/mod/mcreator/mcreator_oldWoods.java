//Deobfuscated with https://github.com/PetoPetko/Minecraft-Deobfuscator3000 using mappings "mcp_snapshot-20171003-1.12"!

/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.state.IBlockState
 *  net.minecraft.entity.monster.EntityCreeper
 *  net.minecraft.entity.monster.EntityEnderman
 *  net.minecraft.entity.monster.EntitySkeleton
 *  net.minecraft.entity.monster.EntitySlime
 *  net.minecraft.entity.monster.EntitySpider
 *  net.minecraft.entity.monster.EntityWitch
 *  net.minecraft.entity.passive.EntityDonkey
 *  net.minecraft.entity.passive.EntityMooshroom
 *  net.minecraft.entity.passive.EntityMule
 *  net.minecraft.entity.passive.EntityPig
 *  net.minecraft.entity.passive.EntitySheep
 *  net.minecraft.init.Blocks
 *  net.minecraft.util.Mirror
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.Rotation
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.ChunkPos
 *  net.minecraft.world.World
 *  net.minecraft.world.WorldServer
 *  net.minecraft.world.biome.Biome
 *  net.minecraft.world.biome.Biome$BiomeProperties
 *  net.minecraft.world.biome.Biome$SpawnListEntry
 *  net.minecraft.world.gen.feature.WorldGenAbstractTree
 *  net.minecraft.world.gen.structure.template.PlacementSettings
 *  net.minecraft.world.gen.structure.template.Template
 *  net.minecraftforge.common.BiomeDictionary
 *  net.minecraftforge.common.BiomeDictionary$Type
 *  net.minecraftforge.common.BiomeManager
 *  net.minecraftforge.common.BiomeManager$BiomeEntry
 *  net.minecraftforge.common.BiomeManager$BiomeType
 *  net.minecraftforge.fml.common.event.FMLInitializationEvent
 *  net.minecraftforge.fml.common.registry.ForgeRegistries
 *  net.minecraftforge.registries.IForgeRegistryEntry
 */
package mod.mcreator;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.passive.*;
import net.minecraft.init.Blocks;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraft.world.gen.structure.template.Template;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

import java.util.Random;

public class mcreator_oldWoods extends theworlditems2.ModElement {
    public static BiomeGenCustom biome;

    @Override
    public void load(FMLInitializationEvent event) {
        ForgeRegistries.BIOMES.register(biome);
        BiomeDictionary.addTypes(biome, BiomeDictionary.Type.FOREST);
        BiomeManager.addSpawnBiome(biome);
        BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(biome, 8));
    }

    static {
        Biome.BiomeProperties properties = new Biome.BiomeProperties("oldWoods");
        properties.setRainfall(1.0f);
        properties.setBaseHeight(0.1f);
        properties.setHeightVariation(0.2f);
        properties.setTemperature(1.0f);
        biome = new BiomeGenCustom(properties);
    }

    @SuppressWarnings("ConstantConditions")
    static class CustomTree
    extends WorldGenAbstractTree {
        CustomTree() {
            super(false);
        }

        public boolean generate(World world, Random par2Random, BlockPos pos) {
            if (world.isRemote) {
                return false;
            }
            Template template = ((WorldServer)world).getStructureTemplateManager().getTemplate(world.getMinecraftServer(), new ResourceLocation("theworlditems2", "extra_dark_oak"));
            if (template == null) {
                return false;
            }
            Block ground = world.getBlockState(pos).getBlock();
            Block ground2 = world.getBlockState(pos.add(0, -1, 0)).getBlock();
            if (ground != Blocks.GRASS.getDefaultState().getBlock() && ground != Blocks.DIRT.getDefaultState().getBlock() && ground2 != Blocks.GRASS.getDefaultState().getBlock() && ground2 != Blocks.DIRT.getDefaultState().getBlock()) {
                return false;
            }
            Rotation rotation = Rotation.NONE;
            int rot = par2Random.nextInt(3);
            if (rot == 0) {
                rotation = Rotation.NONE;
            } else if (rot == 1) {
                rotation = Rotation.CLOCKWISE_90;
            } else if (rot == 2) {
                rotation = Rotation.CLOCKWISE_180;
            } else if (rot == 3) {
                rotation = Rotation.COUNTERCLOCKWISE_90;
            }
            Mirror mirror = Mirror.NONE;
            int mir = par2Random.nextInt(2);
            if (mir == 0) {
                mirror = Mirror.NONE;
            } else if (mir == 1) {
                mirror = Mirror.LEFT_RIGHT;
            } else if (mir == 2) {
                mirror = Mirror.FRONT_BACK;
            }
            BlockPos placeTo = pos.add(template.getSize().getX() / -2, 0, template.getSize().getZ() / -2);
            IBlockState iblockstate = world.getBlockState(placeTo);
            world.notifyBlockUpdate(placeTo, iblockstate, iblockstate, 3);
            template.addBlocksToWorldChunk(world, placeTo, new PlacementSettings().setRandom(par2Random).setRotation(rotation).setMirror(mirror).setChunk(null).setReplacedBlock(null).setIgnoreStructureBlock(false).setIgnoreEntities(false));
            return true;
        }

        protected boolean canGrowInto(Block blockType) {
            return super.canGrowInto(blockType);
        }

        public void generateSaplings(World worldIn, Random random, BlockPos pos) {
        }

        protected void setDirtAt(World worldIn, BlockPos pos) {
        }

        public boolean isReplaceable(World world, BlockPos pos) {
            return true;
        }
    }

    static class BiomeGenCustom
    extends Biome {
        public BiomeGenCustom(Biome.BiomeProperties properties) {
            super(properties);
            this.setRegistryName("oldWoods");
            this.topBlock = Blocks.GRASS.getDefaultState();
            this.fillerBlock = Blocks.DIRT.getDefaultState();
            this.decorator.generateFalls = false;
            this.decorator.treesPerChunk = 4;
            this.decorator.flowersPerChunk = 17;
            this.decorator.grassPerChunk = 256;
            this.decorator.deadBushPerChunk = 0;
            this.decorator.mushroomsPerChunk = 5;
            this.decorator.bigMushroomsPerChunk = 0;
            this.decorator.reedsPerChunk = 1;
            this.decorator.cactiPerChunk = 0;
            this.decorator.sandPatchesPerChunk = 3;
            this.decorator.gravelPatchesPerChunk = 1;
            this.spawnableMonsterList.clear();
            this.spawnableCreatureList.clear();
            this.spawnableWaterCreatureList.clear();
            this.spawnableCaveCreatureList.clear();
            this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityPig.class, 40, 1, 5));
            this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityCreeper.class, 40, 1, 5));
            this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityEnderman.class, 40, 1, 5));
            this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntitySpider.class, 40, 1, 5));
            this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntitySlime.class, 40, 1, 5));
            this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntitySkeleton.class, 40, 1, 5));
            this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityWitch.class, 40, 1, 5));
            this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntitySheep.class, 40, 1, 5));
            this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityMooshroom.class, 40, 1, 5));
            this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityDonkey.class, 40, 1, 5));
            this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityMule.class, 40, 1, 5));
        }

        public WorldGenAbstractTree getRandomTreeFeature(Random rand) {
            return new CustomTree();
        }
    }
}

