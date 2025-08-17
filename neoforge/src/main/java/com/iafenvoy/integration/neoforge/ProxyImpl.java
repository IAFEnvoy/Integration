package com.iafenvoy.integration.neoforge;

import com.iafenvoy.integration.entrypoint.EntryPointProvider;
import com.iafenvoy.integration.entrypoint.IntegrationEntryPoint;
import com.iafenvoy.integration.util.ReflectUtil;
import net.neoforged.fml.ModList;
import net.neoforged.neoforgespi.language.ModFileScanData;
import org.objectweb.asm.Type;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public final class ProxyImpl {
    private static final List<IntegrationEntryPoint> ENTRY_POINTS;

    public static boolean isModLoaded(String modId) {
        return ModList.get().isLoaded(modId);
    }

    public static <T extends IntegrationEntryPoint> List<T> collectEntryPoints(String slug, Class<T> clazz) {
        List<T> list = new LinkedList<>();
        for (IntegrationEntryPoint entryPoint : ENTRY_POINTS) {
            Class<? extends IntegrationEntryPoint> c = entryPoint.getClass();
            if (!clazz.isAssignableFrom(c)) continue;
            EntryPointProvider annotation = c.getAnnotation(EntryPointProvider.class);
            if (annotation != null && annotation.slug().equals(slug)) list.add(clazz.cast(entryPoint));
        }
        return list;
    }

    static {
        ENTRY_POINTS = ModList.get()
                .getAllScanData()
                .stream()
                .map(scanData -> scanData.getAnnotations()
                        .stream()
                        .filter(x -> x.annotationType().equals(Type.getType(EntryPointProvider.class)))
                        .map(ModFileScanData.AnnotationData::memberName)
                        .map(ReflectUtil::getClassUnsafely)
                        .filter(Objects::nonNull)
                        .map(ReflectUtil::constructUnsafely)
                        .filter(x -> x instanceof IntegrationEntryPoint)
                        .map(IntegrationEntryPoint.class::cast)
                        .toList())
                .reduce(new ArrayList<>(), ReflectUtil::combine);
    }
}
