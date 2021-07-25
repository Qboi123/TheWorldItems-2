//Deobfuscated with https://github.com/PetoPetko/Minecraft-Deobfuscator3000 using mappings "mcp_snapshot-20171003-1.12"!

/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.state.IBlockState
 *  net.minecraft.init.Blocks
 *  net.minecraft.util.Mirror
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.Rotation
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.ChunkPos
 *  net.minecraft.world.World
 *  net.minecraft.world.WorldServer
 *  net.minecraft.world.biome.Biome
 *  net.minecraft.world.gen.structure.template.PlacementSettings
 *  net.minecraft.world.gen.structure.template.Template
 */
package mod.mcreator;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraft.world.gen.structure.template.Template;

import java.util.Random;

public class mcreator_gateEnd extends theworlditems2.ModElement {
    @Override
    public void generateSurface(World world, Random random, int i2, int k2) {
        if (random.nextInt(1000000) + 1 <= 5000) {
            boolean blockCriteria;
            int j;
            int k;
            int i;
            block10: {
                int height;
                i = i2 + random.nextInt(16) + 8;
                k = k2 + random.nextInt(16) + 8;
                for (height = 255; height > 0 && world.isAirBlock(new BlockPos(i, height, k)); --height) {
                }
                j = height - 1;
                IBlockState blockAt = world.getBlockState(new BlockPos(i, j + 1, k));
                blockCriteria = false;
                IBlockState require = Blocks.SAND.getStateFromMeta(0);
                try {
                    if (blockAt.getBlock() == require.getBlock() && blockAt.getBlock().getMetaFromState(blockAt) == require.getBlock().getMetaFromState(require)) {
                        blockCriteria = true;
                    }
                }
                catch (Exception e) {
                    if (blockAt.getBlock() != require.getBlock()) break block10;
                    blockCriteria = true;
                }
            }
            if (!blockCriteria) {
                return;
            }
            boolean biomeCriteria = false;
            Biome biome = world.getBiome(new BlockPos(i, j, k));
            if (Biome.REGISTRY.getNameForObject(biome).getResourcePath().equals("desert")) {
                biomeCriteria = true;
            }
            if (!biomeCriteria) {
                return;
            }
            if (world.isRemote) {
                return;
            }
            Template template = ((WorldServer)world).getStructureTemplateManager().getTemplate(world.getMinecraftServer(), new ResourceLocation("theworlditems2", "ld_portal_001_end"));
            if (template == null) {
                return;
            }
            BlockPos spawnTo = new BlockPos(i, j, k);
            IBlockState iblockstate = world.getBlockState(spawnTo);
            world.notifyBlockUpdate(spawnTo, iblockstate, iblockstate, 3);
            template.addBlocksToWorldChunk(world, spawnTo, new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setReplacedBlock(null).setIgnoreStructureBlock(false).setIgnoreEntities(false));
        }
    }
}

