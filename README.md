# Integration

This is a library mod to help other mods make integration easier.

## Core APIs

- `IntegrationExecutor`: Safely run integration code only when target mod loaded.
- `EntryPointManager`: Customizable entry points based on Annotation (Forge/NeoForge) and EntryPoint (Fabric).

## Examples

### Integration with `example-mod`

```
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

```
EntryPointManager.getEntryPoints("example-mod");
```