package com.x4mok.xem.world.biome;

import com.x4mok.xem.XEM;
import com.x4mok.xem.block.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.ISurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class ModConfiguredSurfaceBuilders {

    public static ConfiguredSurfaceBuilder<?> MAHOGANY_SURFACE = register("mahogany_surface",
            SurfaceBuilder.DEFAULT.configured(new SurfaceBuilderConfig(
                    Blocks.GRASS.defaultBlockState(),
                    Blocks.DIRT.defaultBlockState(),
                    Blocks.DIRT.defaultBlockState()
            )));

    public static ConfiguredSurfaceBuilder<?> END_GRASSY_SURFACE = register("end_grassy_surface",
            SurfaceBuilder.DEFAULT.configured(new SurfaceBuilderConfig(
                    ModBlocks.ENDGRASS.get().defaultBlockState(), // CHANGE TO ENDGRASS
                    Blocks.END_STONE.defaultBlockState(),
                    Blocks.END_STONE.defaultBlockState()
            )));


    private  static <SC extends ISurfaceBuilderConfig>ConfiguredSurfaceBuilder<SC> register(String name, ConfiguredSurfaceBuilder<SC> csb) {
        return WorldGenRegistries.register(WorldGenRegistries.CONFIGURED_SURFACE_BUILDER, new ResourceLocation(XEM.MODID, name), csb);
    }

}
