package com.iafenvoy.integration;

import com.iafenvoy.integration.entrypoint.IntegrationEntryPoint;
import dev.architectury.injectables.annotations.ExpectPlatform;

import java.util.List;

public class Proxy {
    @ExpectPlatform
    public static boolean isModLoaded(String modId) {
        throw new AssertionError("This method should be replaced by Architectury.");
    }

    @ExpectPlatform
    public static <T extends IntegrationEntryPoint> List<T> collectEntryPoints(String slug, Class<T> clazz) {
        throw new AssertionError("This method should be replaced by Architectury.");
    }
}
