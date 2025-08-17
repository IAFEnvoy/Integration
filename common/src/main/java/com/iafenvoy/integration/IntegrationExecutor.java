package com.iafenvoy.integration;

import java.util.Optional;
import java.util.function.Supplier;

public final class IntegrationExecutor {
    public static void runWhenLoad(String modId, Supplier<Runnable> supplier) {
        if (Proxy.isModLoaded(modId)) supplier.get().run();
    }

    public static <T> Optional<T> getWhenLoad(String modId, Supplier<Supplier<T>> supplier) {
        return Proxy.isModLoaded(modId) ? Optional.ofNullable(supplier.get().get()) : Optional.empty();
    }

    public static <T> T getWhenLoad(String modId, Supplier<Supplier<T>> supplier, T defaultValue) {
        return getWhenLoad(modId, supplier).orElse(defaultValue);
    }
}
