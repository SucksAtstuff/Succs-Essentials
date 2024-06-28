package net.succ.succsmod.datagen;

// Import statements for necessary classes from Minecraft, Forge, and SuccsMod
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.succ.succsmod.SuccsMod;
import net.succ.succsmod.item.ModItems;

public class ModItemModelProvider extends ItemModelProvider {

    // Constructor for ModItemModelProvider, takes PackOutput and ExistingFileHelper as parameters
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, SuccsMod.MOD_ID, existingFileHelper);
    }

    // Override method to register item models
    @Override
    protected void registerModels() {
        // Register models for simple items
        simpleItem(ModItems.ATHERIUM);
        simpleItem(ModItems.ROCK_CANDY);
        simpleItem(ModItems.GOLD_HANDLE);
        simpleItem((ModItems.RUBY));

        // Register models for handheld items
        handheldItem(ModItems.ATHERIUM_SWORD);
        handheldItem(ModItems.ATHERIUM_PICKAXE);
        handheldItem(ModItems.ATHERIUM_AXE);
        handheldItem(ModItems.ATHERIUM_SHOVEL);
        handheldItem(ModItems.ATHERIUM_HOE);

        handheldItem(ModItems.RUBY_SWORD);
        handheldItem(ModItems.RUBY_PICKAXE);
        handheldItem(ModItems.RUBY_AXE);
        handheldItem(ModItems.RUBY_SHOVEL);
        handheldItem(ModItems.RUBY_HOE);
    }

    // Helper method to create a simple item model
    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated"))
                .texture("layer0", new ResourceLocation(SuccsMod.MOD_ID, "item/" + item.getId().getPath()));
    }

    // Helper method to create a handheld item model
    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld"))
                .texture("layer0", new ResourceLocation(SuccsMod.MOD_ID, "item/" + item.getId().getPath()));
    }
}
