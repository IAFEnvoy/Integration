# Integration

This is a library mod to help other mods make integration easier.

This mod is based on loaders' api, not Minecraft's. So it can run on any versions if the loader supported.

## How to use

- Use `maven { url "https://maven.kessokuteatime.work/releases" }`. for more info,
  see https://maven.kessokuteatime.work/#/releases/com/iafenvoy/integration
- Use `maven { url "https://jitpack.io" }`. for more info, see https://jitpack.io/#IAFEnvoy/Integration

## Core APIs

- `IntegrationExecutor`: Safely run integration code only when target mod loaded.
- `EntryPointManager`: Customizable entry points based on Annotation (Forge/NeoForge) and EntryPoint (Fabric).

## Examples

### Integration with `example-mod`

```java
IntegrationExecutor.runWhenLoad("example-mod",()->()->{
        //Your code here.
        });
```

### Customize entry point

```java

@EntryPointProvider(slug = "example-mod")
public class ExampleModIntegration implements IntegrationEntryPoint {
    //Your code here
}
```

```json5
//fabric.mod.json
{
  //Other parts
  "entrypoints": {
    "example-mod": [
      "xxx.ExampleModIntegration"
    ]
  },
}
```

Get this entrypoint:

```java
EntryPointManager.getEntryPoints("example-mod");
```