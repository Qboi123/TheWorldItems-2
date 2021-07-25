//Deobfuscated with https://github.com/PetoPetko/Minecraft-Deobfuscator3000 using mappings "mcp_snapshot-20171003-1.12"!

/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.world.World
 */
package mod.mcreator;

import net.minecraft.entity.Entity;
import net.minecraft.world.World;

import java.util.HashMap;

public class mcreator_cmdSwitchDimensionProcedure extends theworlditems2.ModElement {
    public static void executeProcedure(HashMap<String, Object> dependencies) {
        if (dependencies.get("entity") == null) {
            System.err.println("Failed to load dependency entity for procedure cmdSwitchDimensionProcedure!");
            return;
        }
        if (dependencies.get("cmdparams") == null) {
            System.err.println("Failed to load dependency cmdparams for procedure cmdSwitchDimensionProcedure!");
            return;
        }
        if (dependencies.get("world") == null) {
            System.err.println("Failed to load dependency world for procedure cmdSwitchDimensionProcedure!");
            return;
        }
        Entity entity = (Entity)dependencies.get("entity");
        final HashMap cmdparams = (HashMap)dependencies.get("cmdparams");
        World world = (World)dependencies.get("world");
        if (!(entity.isRiding() || entity.isBeingRidden() || world.isRemote)) {
            entity.changeDimension(new Object(){

                int convert(String s) {
                    try {
                        return Integer.parseInt(s.trim());
                    }
                    catch (Exception exception) {
                        return 0;
                    }
                }
            }.convert(new Object(){

                public String getText() {
                    String param = (String)cmdparams.get("0");
                    if (param != null) {
                        return param;
                    }
                    return "";
                }
            }.getText()));
        }
    }
}

