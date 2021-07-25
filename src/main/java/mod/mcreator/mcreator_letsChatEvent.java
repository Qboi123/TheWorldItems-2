//Deobfuscated with https://github.com/PetoPetko/Minecraft-Deobfuscator3000 using mappings "mcp_snapshot-20171003-1.12"!

/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayerMP
 *  net.minecraftforge.common.MinecraftForge
 *  net.minecraftforge.event.ServerChatEvent
 *  net.minecraftforge.fml.common.event.FMLInitializationEvent
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 */
package mod.mcreator;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.HashMap;

public class mcreator_letsChatEvent extends theworlditems2.ModElement {
    public static void executeProcedure(HashMap<String, Object> dependencies) {
        if (dependencies.get("entity") == null) {
            System.err.println("Failed to load dependency entity for procedure letsChatEvent!");
            return;
        }
        Entity entity = (Entity)dependencies.get("entity");
        if (!mcreator_VarListtheworlditems2.ChatAlready) {
            mcreator_VarListtheworlditems2.ChatAlready = true;
            if (entity instanceof EntityPlayerMP) {
                mcreator_chatForFirst.trigger.triggerAdvancement((EntityPlayerMP)entity);
            }
        }
    }

    @SubscribeEvent
    public void onChat(ServerChatEvent event) {
        EntityPlayerMP entity = event.getPlayer();
        int i = (int)entity.posX;
        int j = (int)entity.posY;
        int k = (int)entity.posZ;
        HashMap<String, Object> dependencies = new HashMap<String, Object>();
        dependencies.put("x", i);
        dependencies.put("y", j);
        dependencies.put("z", k);
        dependencies.put("world", entity.world);
        dependencies.put("entity", entity);
        dependencies.put("text", event.getMessage());
        mcreator_letsChatEvent.executeProcedure(dependencies);
    }

    @Override
    public void load(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(this);
    }
}

