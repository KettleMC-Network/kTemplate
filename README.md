# ☕ kTemplate

## 📝 Description

A template for creating a spigot, paper or paper-legacy plugin.

No need to set up gradle, maven or anything else. Just clone this repository and start coding.

## 📦 Setup

1. Clone this repository
2. Open the project in your IDE
3. Edit the [gradle.properties](gradle.properties) file to your liking
4. Start coding

## ⚙ Settings

When using this project it shouldn't be required to edit the build.gradle.

### Spigot Fork and Version

To specify the version of Spigot or Paper you want to use, edit the `pluginApi` or `minecraftVersion` in the [gradle.properties](gradle.properties) file.
Supported plugin APIs are:

- `spigot`
- `paperspigot` (1.7, 1.8)
- `paper-legacy` (1.9-1.16)
- `paper` (1.17+)
- `purpur`
- `bungeecord`
- `velocity`.

If you want to specify a custom version outside the default versions, specify it directly.
If you want to use a plugin API not listed here, simply unset the properties and use [repositories.gradle](repositories.gradle) or the [dependencies.gradle](dependencies.gradle).
Make sure to set the `javaTargetVersion`/`javaSourceVersion` to a fitting version for the plugin API you are using.

### Dependencies

Repositories and dependencies can be added using the [repositories.gradle](repositories.gradle) or the [dependencies.gradle](dependencies.gradle).

A new internal dependency can be shaded into the final JAR by adding it as a `internal` dependency in the [dependencies.gradle](dependencies.gradle) file.
Using the `shadowJar` task, the dependency will be shaded into the final JAR file.
The dependencies will be relocated to the `net.kettlemc.lib` package by default.

Some default dependencies can be set using the [gradle.properties](gradle.properties) file.
This includes [JASKL](https://github.com/Almighty-Satan/JASKL) and [SLAMS](https://github.com/Almighty-Satan/SLAMS) as well as [kCommon](https://github.com/KettleMC-Network/kCommon).

### Plugin Metadata

The plugin metadata can be set in the [gradle.properties](gradle.properties) file.
The following properties are available:

```properties
pluginName=KettleMC-Example
pluginVersion=1.0.0
pluginAuthor=KettleMC
pluginWebsite=https://kettlemc.net
pluginMain=net.kettlemc.example.Plugin
pluginDescription=Awesome plugin allowing for stuff!
pluginApiVersion=1.13
```