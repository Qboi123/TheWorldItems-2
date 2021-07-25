//Deobfuscated with https://github.com/PetoPetko/Minecraft-Deobfuscator3000 using mappings "mcp_snapshot-20171003-1.12"!

/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.command.ICommand
 *  net.minecraft.command.ICommandSender
 *  net.minecraft.entity.Entity
 *  net.minecraft.server.MinecraftServer
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.common.event.FMLServerStartingEvent
 */
package mod.mcreator;

import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.Entity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class mcreator_cmdLightning extends theworlditems2.ModElement {
    @Override
    public void serverLoad(FMLServerStartingEvent event) {
        event.registerServerCommand(new CommandHandler());
    }

    public static class CommandHandler
    implements ICommand {
        public int compareTo(ICommand c) {
            return this.getName().compareTo(c.getName());
        }

        public boolean checkPermission(MinecraftServer server, ICommandSender var1) {
            return true;
        }

        public List getAliases() {
            return new ArrayList();
        }

        public List getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args, BlockPos pos) {
            return new ArrayList();
        }

        public boolean isUsernameIndex(String[] string, int index) {
            return true;
        }

        public String getName() {
            return "lightning";
        }

        public String getUsage(ICommandSender var1) {
            return "/lightning <x> <y> <z>";
        }

        public void execute(MinecraftServer server, ICommandSender sender, String[] cmd) {
            int x = sender.getPosition().getX();
            int y = sender.getPosition().getY();
            int z = sender.getPosition().getZ();
            Entity entity = sender.getCommandSenderEntity();
            if (entity != null) {
                World world = entity.world;
                HashMap cmdparams = new HashMap();
                int[] index = new int[]{0};
                Arrays.stream(cmd).forEach(param -> {
                    cmdparams.put(Integer.toString(index[0]), param);
                    index[0] = index[0] + 1;
                });
                HashMap<String, Object> $_dependencies = new HashMap<String, Object>();
                $_dependencies.put("cmdparams", cmdparams);
                $_dependencies.put("world", world);
                mcreator_cmdLightningEvent.executeProcedure($_dependencies);
            }
        }
    }
}

