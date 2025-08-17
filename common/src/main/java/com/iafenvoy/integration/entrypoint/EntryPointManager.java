package com.iafenvoy.integration.entrypoint;

import com.iafenvoy.integration.Proxy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class EntryPointManager {
    private static final Map<String, List<? extends IntegrationEntryPoint>> ENTRY_POINTS = new HashMap<>();

    public static List<IntegrationEntryPoint> getEntryPoints(String slug) {
        return getEntryPoints(slug, IntegrationEntryPoint.class);
    }

    @SuppressWarnings("unchecked")
    public static <T extends IntegrationEntryPoint> List<T> getEntryPoints(String slug, Class<T> clazz) {
        return (List<T>) ENTRY_POINTS.computeIfAbsent(slug, s -> Proxy.collectEntryPoints(slug, clazz));
    }
}
