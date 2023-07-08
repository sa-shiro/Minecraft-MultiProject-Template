package com.example.examplemod;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("unused")
@Mod(ExampleMod.MOD_ID)
public class ExampleMod {
    public static final String MOD_ID = "example_mod";
    public static final Logger LOG = LoggerFactory.getLogger(MOD_ID);
    
    // Creates a Forge Registry so you can register your stuff
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);
    
    // Registering Blocks & Items
    public static final RegistryObject<Block> EXAMPLE_BLOCK = BLOCKS.register("a_example_block", () -> new Block(BlockBehaviour.Properties.of()));
    public static final RegistryObject<Item> EXAMPLE_BLOCK_ITEM = ITEMS.register("a_example_block", () -> new BlockItem(EXAMPLE_BLOCK.get(), new Item.Properties()));
    
    private static final IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
    
    // Use this method to initialize your mod
    public ExampleMod() {
        LOG.info(String.format("Hello from: %s", MOD_ID));
        // This method must be fired BEFORE you register the registries to the event bus, or it won't work
        eventBus.addListener(ExampleMod::register);
        BLOCKS.register(eventBus);
        ITEMS.register(eventBus);
    }
    
    // you can use the Registry Event to register stuff, however
    // this is not recommended, use RegistryObject<?> instead!
    private static void register(RegisterEvent event) {
        // This check is required in order to not register duplicates
        if (event.getRegistryKey() == BLOCKS.getRegistryKey()) {
            Block block = new Block(BlockBehaviour.Properties.of());
            BLOCKS.register("example_block", () -> block);
            ITEMS.register("example_block", () -> new BlockItem(block, new Item.Properties()));
            
            LOG.info("Successfully registered a example block!");
        }
    }
}