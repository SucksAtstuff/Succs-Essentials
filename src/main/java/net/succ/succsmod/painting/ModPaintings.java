package net.succ.succsmod.painting;

import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.succ.succsmod.SuccsMod;

public class ModPaintings {
    public static final DeferredRegister<PaintingVariant> PAINTING_VARIANTS =
            DeferredRegister.create(ForgeRegistries.PAINTING_VARIANTS, SuccsMod.MOD_ID);

    public static final RegistryObject<PaintingVariant> THEOMONTY = PAINTING_VARIANTS.register("theomonty",
            () -> new PaintingVariant(64, 32));

    public static final RegistryObject<PaintingVariant> KURGERBING = PAINTING_VARIANTS.register("kurgerbing",
            () -> new PaintingVariant(16, 32));

    public static final RegistryObject<PaintingVariant> THEOMONTY_SCREAM = PAINTING_VARIANTS.register("theomonty_scream",
            () -> new PaintingVariant(64, 64));

    public static void register(IEventBus eventBus){
        PAINTING_VARIANTS.register(eventBus);
    }
}
