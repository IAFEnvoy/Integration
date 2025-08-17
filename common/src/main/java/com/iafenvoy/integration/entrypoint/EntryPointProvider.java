package com.iafenvoy.integration.entrypoint;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface EntryPointProvider {
    String slug();
}
