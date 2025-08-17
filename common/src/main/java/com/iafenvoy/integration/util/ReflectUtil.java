package com.iafenvoy.integration.util;

import com.iafenvoy.integration.Integration;
import org.jetbrains.annotations.Nullable;

import java.lang.reflect.Constructor;
import java.util.List;

public class ReflectUtil {
    @Nullable
    public static Class<?> getClassUnsafely(String name) {
        try {
            return Class.forName(name);
        } catch (ReflectiveOperationException e) {
            Integration.LOGGER.error("Failed to get class", e);
            return null;
        }
    }

    @Nullable
    public static <V> V constructUnsafely(Class<V> cls) {
        try {
            Constructor<V> constructor = cls.getDeclaredConstructor();
            constructor.setAccessible(true);
            return constructor.newInstance();
        } catch (ReflectiveOperationException e) {
            Integration.LOGGER.error("Failed to construct object");
            return null;
        }
    }

    public static <T> List<T> combine(List<T> l1, List<T> l2) {
        l1.addAll(l2);
        return l1;
    }
}
