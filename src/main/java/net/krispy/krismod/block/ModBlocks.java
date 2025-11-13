package net.krispy.krismod.block;

import net.krispy.krismod.KrisMod;
import net.krispy.krismod.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(KrisMod.MOD_ID);

    public static final DeferredBlock<Block> CORNDOG_CAT_BLOCK = registerBlock("corndog_cat_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.COPPER)
                    .setId(ResourceKey.create(
                            Registries.BLOCK,
                            ResourceLocation.fromNamespaceAndPath(KrisMod.MOD_ID, "corndog_cat_block")
                    ))));
    public static final DeferredBlock<Block> CORNDOG_CAT_RAW_BLOCK = registerBlock("corndog_cat_raw_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.COPPER)
                    .setId(ResourceKey.create(
                            Registries.BLOCK,
                            ResourceLocation.fromNamespaceAndPath(KrisMod.MOD_ID, "corndog_cat_raw_block")
                    ))));


    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()
                .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(
                        KrisMod.MOD_ID, name)
                ))));
    }


    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
