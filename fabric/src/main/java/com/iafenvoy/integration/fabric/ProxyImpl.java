package com.iafenvoy.integration.fabric;

import com.iafenvoy.integration.entrypoint.IntegrationEntryPoint;
import net.fabricmc.loader.api.FabricLoader;

import java.util.List;

public class ProxyImpl {
    public static boolean isModLoaded(String modId) {
        return FabricLoader.getInstance().isModLoaded(modId);
    }

    public static <T extends IntegrationEntryPoint> List<T> collectEntryPoints(String slug, Class<T> clazz) {
        return FabricLoader.getInstance().getEntrypoints(slug, clazz);
    }
}
