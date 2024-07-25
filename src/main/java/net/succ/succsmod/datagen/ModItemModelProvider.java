package net.succ.succsmod.datagen;

// Import statements for necessary classes from Minecraft, Forge, and SuccsMod
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.succ.succsmod.SuccsMod;
import net.succ.succsmod.block.ModBlocks;
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
        simpleItem(ModItems.DIRTY_ATHERIUM);
        simpleItem(ModItems.ROCK_CANDY);
        simpleItem(ModItems.ROCK);
        simpleItem(ModItems.GOLD_HANDLE);
        simpleItem((ModItems.RUBY));
        simpleItem((ModItems.DIRTY_RUBY));
        simpleItem((ModItems.DIRTY_SAPPHIRE));
        simpleItem((ModItems.SAPPHIRE));
        simpleItem((ModItems.DIRTY_SUNSTONE));
        simpleItem((ModItems.SUNSTONE));
        simpleItem((ModItems.GARLIC));
        simpleItem((ModItems.GARLIC_BREAD));

        simpleItem((ModItems.RING_OF_RUBY));
        simpleItem((ModItems.RING_OF_SAPPHIRE));
        simpleItem((ModItems.RING_OF_SUNSTONE));
        simpleItem((ModItems.RING_OF_ATHERIUM));

        //simpleItem((ModItems.ATHERIUM_HELMET));
       // simpleItem((ModItems.ATHERIUM_CHESTPLATE));
       // simpleItem((ModItems.ATHERIUM_LEGGINGS));
       // simpleItem((ModItems.ATHERIUM_BOOTS));

        // Register models for handheld items
        handheldItem(ModItems.ATHERIUM_SWORD);
        handheldItem(ModItems.ATHERIUM_PICKAXE);
        handheldItem(ModItems.ATHERIUM_AXE);
        handheldItem(ModItems.ATHERIUM_SHOVEL);
        handheldItem(ModItems.ATHERIUM_HOE);
        handheldItem(ModItems.ATHERIUM_HAMMER);
        handheldItem(ModItems.ATHERIUM_PAXEL);

        handheldItem(ModItems.RUBY_SWORD);
        handheldItem(ModItems.RUBY_PICKAXE);
        handheldItem(ModItems.RUBY_AXE);
        handheldItem(ModItems.RUBY_SHOVEL);
        handheldItem(ModItems.RUBY_HOE);
        handheldItem(ModItems.RUBY_HAMMER);
        handheldItem(ModItems.RUBY_PAXEL);

        handheldItem(ModItems.SAPPHIRE_SWORD);
        handheldItem(ModItems.SAPPHIRE_PICKAXE);
        handheldItem(ModItems.SAPPHIRE_AXE);
        handheldItem(ModItems.SAPPHIRE_SHOVEL);
        handheldItem(ModItems.SAPPHIRE_HOE);
        handheldItem(ModItems.SAPPHIRE_HAMMER);
        handheldItem(ModItems.SAPPHIRE_PAXEL);

        handheldItem(ModItems.SUNSTONE_SWORD);
        handheldItem(ModItems.SUNSTONE_PICKAXE);
        handheldItem(ModItems.SUNSTONE_AXE);
        handheldItem(ModItems.SUNSTONE_SHOVEL);
        handheldItem(ModItems.SUNSTONE_HOE);
        handheldItem(ModItems.SUNSTONE_HAMMER);
        handheldItem(ModItems.SUNSTONE_PAXEL);

        complexBlock(ModBlocks.GEM_POLISHING_TABLE.get());

    }

    private ItemModelBuilder complexBlock(Block block){
        return withExistingParent(ForgeRegistries.BLOCKS.getKey(block).getPath(), new ResourceLocation(SuccsMod.MOD_ID,
                "block/" + ForgeRegistries.BLOCKS.getKey(block).getPath()));
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
