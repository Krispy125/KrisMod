package net.krispy.krismod.item;

import net.krispy.krismod.KrisMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(KrisMod.MOD_ID);

    public static final DeferredItem<Item> CORNDOG_CAT = ITEMS.register("corndog_cat",
            () -> new Item(new Item.Properties().setId(ResourceKey.create(Registries.ITEM,
                    ResourceLocation.parse("krismod:corndog_cat")))));
    public static final DeferredItem<Item> CORNDOG_CAT_RAW = ITEMS.register("corndog_cat_raw",
            () -> new Item(new Item.Properties().setId(ResourceKey.create(Registries.ITEM,
                    ResourceLocation.parse("krismod:corndog_cat_raw")))));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
