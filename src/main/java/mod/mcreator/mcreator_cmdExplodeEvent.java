//Deobfuscated with https://github.com/PetoPetko/Minecraft-Deobfuscator3000 using mappings "mcp_snapshot-20171003-1.12"!

/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.World
 */
package mod.mcreator;

import net.minecraft.world.World;

import java.util.HashMap;

public class mcreator_cmdExplodeEvent extends theworlditems2.ModElement {
    public static void executeProcedure(HashMap<String, Object> dependencies) {
        if (dependencies.get("cmdparams") == null) {
            System.err.println("Failed to load dependency cmdparams for procedure cmdExplodeEvent!");
            return;
        }
        if (dependencies.get("world") == null) {
            System.err.println("Failed to load dependency world for procedure cmdExplodeEvent!");
            return;
        }
        final HashMap cmdparams = (HashMap)dependencies.get("cmdparams");
        World world = (World)dependencies.get("world");
        double x = 0.0;
        double y = 0.0;
        double z = 0.0;
        double power = 0.0;
        x = new Object(){

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
        }.getText());
        y = new Object(){

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
                String param = (String)cmdparams.get("1");
                if (param != null) {
                    return param;
                }
                return "";
            }
        }.getText());
        z = new Object(){

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
                String param = (String)cmdparams.get("2");
                if (param != null) {
                    return param;
                }
                return "";
            }
        }.getText());
        power = new Object(){

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
                String param = (String)cmdparams.get("2");
                if (param != null) {
                    return param;
                }
                return "";
            }
        }.getText());
        world.createExplosion(null, (int)x, (int)y, (int)z, (float)power, true);
    }
}

