//Deobfuscated with https://github.com/PetoPetko/Minecraft-Deobfuscator3000 using mappings "mcp_snapshot-20171003-1.12"!

/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.Maps
 *  com.google.common.collect.Sets
 *  com.google.gson.JsonDeserializationContext
 *  com.google.gson.JsonObject
 *  net.minecraft.advancements.CriteriaTriggers
 *  net.minecraft.advancements.ICriterionTrigger
 *  net.minecraft.advancements.ICriterionTrigger$Listener
 *  net.minecraft.advancements.PlayerAdvancements
 *  net.minecraft.advancements.critereon.AbstractCriterionInstance
 *  net.minecraft.entity.player.EntityPlayerMP
 *  net.minecraft.util.ResourceLocation
 *  net.minecraftforge.fml.common.event.FMLInitializationEvent
 */
package mod.mcreator;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.advancements.ICriterionTrigger;
import net.minecraft.advancements.PlayerAdvancements;
import net.minecraft.advancements.critereon.AbstractCriterionInstance;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import java.util.Map;
import java.util.Set;

public class mcreator_chatForFirst extends theworlditems2.ModElement {
    public static final CustomAdvancementTrigger trigger = new CustomAdvancementTrigger();

    @Override
    public void load(FMLInitializationEvent event) {
        CriteriaTriggers.register((ICriterionTrigger)trigger);
    }

    public static class CustomAdvancementTrigger
    implements ICriterionTrigger {
        private final Map<PlayerAdvancements, Listeners> listeners = Maps.newHashMap();

        public void addListener(PlayerAdvancements playerAdvancementsIn, ICriterionTrigger.Listener listener) {
            Listeners listeners = this.listeners.get(playerAdvancementsIn);
            if (listeners == null) {
                listeners = new Listeners(playerAdvancementsIn);
                this.listeners.put(playerAdvancementsIn, listeners);
            }
            listeners.add(listener);
        }

        public void removeListener(PlayerAdvancements playerAdvancementsIn, ICriterionTrigger.Listener listener) {
            Listeners listeners = this.listeners.get(playerAdvancementsIn);
            if (listeners != null) {
                listeners.remove(listener);
                if (listeners.listeners.isEmpty()) {
                    this.listeners.remove(playerAdvancementsIn);
                }
            }
        }

        public void removeAllListeners(PlayerAdvancements playerAdvancementsIn) {
            this.listeners.remove(playerAdvancementsIn);
        }

        public ResourceLocation getId() {
            return new ResourceLocation("chatforfirst");
        }

        public Instance deserializeInstance(JsonObject json, JsonDeserializationContext context) {
            return new Instance(this.getId());
        }

        public void triggerAdvancement(EntityPlayerMP parPlayer) {
            Listeners listeners = this.listeners.get(parPlayer.getAdvancements());
            if (listeners != null) {
                listeners.triggerAdvancement(parPlayer);
            }
        }

        static class Listeners {
            PlayerAdvancements playerAdvancements;
            Set<ICriterionTrigger.Listener> listeners = Sets.newHashSet();

            public Listeners(PlayerAdvancements playerAdvancementsIn) {
                this.playerAdvancements = playerAdvancementsIn;
            }

            public void triggerAdvancement(EntityPlayerMP player) {
                for (ICriterionTrigger.Listener listener1 : this.listeners) {
                    listener1.grantCriterion(this.playerAdvancements);
                }
            }

            public void add(ICriterionTrigger.Listener listener) {
                this.listeners.add(listener);
            }

            public void remove(ICriterionTrigger.Listener listener) {
                this.listeners.remove(listener);
            }
        }

        public static class Instance
        extends AbstractCriterionInstance {
            public Instance(ResourceLocation triggerID) {
                super(triggerID);
            }
        }
    }
}

