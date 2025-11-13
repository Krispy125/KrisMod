package net.krispy.krismod.item;

import net.krispy.krismod.KrisMod;
import net.krispy.krismod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, KrisMod.MOD_ID);

    public static final Supplier<CreativeModeTab> CORNDOG_CAT_TAB = CREATIVE_MODE_TAB.register("corndog_cat_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.CORNDOG_CAT.get()))
                    .title(Component.translatable("creativetab.krismod.corndog_cat_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                      output.accept(ModItems.CORNDOG_CAT);
                      output.accept(ModItems.CORNDOG_CAT_RAW);
                    }).build());

    public static final Supplier<CreativeModeTab> CORNDOG_CAT_BLOCK_TAB = CREATIVE_MODE_TAB.register("corndog_cat_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.CORNDOG_CAT_BLOCK.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(KrisMod.MOD_ID, "corndog_cat_tab"))
                    .title(Component.translatable("creativetab.krismod.corndog_cat_blocks"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.CORNDOG_CAT_BLOCK);
                        output.accept(ModBlocks.CORNDOG_CAT_RAW_BLOCK);
                    }).build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
