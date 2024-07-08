package net.succ.succsmod.villager;

import com.google.common.collect.ImmutableSet;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.succ.succsmod.SuccsMod;
import net.succ.succsmod.block.ModBlocks;

public class ModVillagers {
    public static final DeferredRegister<PoiType> POI_TYPES =
            DeferredRegister.create(ForgeRegistries.POI_TYPES, SuccsMod.MOD_ID);

    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS =
            DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS, SuccsMod.MOD_ID);

    public static final RegistryObject<PoiType> GEM_CUTTER_POI = POI_TYPES.register("gem_cutter_poi",
            () -> new PoiType(ImmutableSet.copyOf(ModBlocks.GEM_POLISHING_TABLE.get().getStateDefinition().getPossibleStates()),
                    1,1));

    public static final RegistryObject<VillagerProfession> GEM_CUTTER = VILLAGER_PROFESSIONS.register("gem_cutter",
            () -> new VillagerProfession("gem_cutter", x -> x.get() == GEM_CUTTER_POI.get(), x -> x.get() == GEM_CUTTER_POI.get(), ImmutableSet.of(), ImmutableSet.of(),
                    SoundEvents.VILLAGER_WORK_CLERIC));

    public static void register(IEventBus eventBus) {
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }
}
