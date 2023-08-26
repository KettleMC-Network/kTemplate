# ☕ kTemplate

## 📝 Description
A template for creating a spigot, paper or paper-legacy plugin.

No need to set up gradle, maven or anything else. Just clone this repository and start coding.

## 📦 Setup
1. Clone this repository
2. Open the project in your IDE
3. Edit the gradle.properties file to your liking
4. Start coding

## ⚙ Settings
When using this project it shouldn't be required to edit the build.gradle.

Repositories and dependencies can be added using the repositories.gradle or the dependencies.gradle, while spigot/paper can be added using the settings.

The gradle.properties file contains the following settings:
```properties
# Details about the plugin
pluginName = KettleMC-Example
pluginVersion = 1.0.0
pluginAuthor = KettleMC
pluginWebsite = https://kettlemc.net
pluginMain = net.kettlemc.example.Main
pluginDescription = Awesome plugin allowing for stuff!
pluginApiVersion = 1.13

# Insert the version you want to compile against, leave empty if not needed.
# Make sure to include the correct version name including things like RO.1-SNAPSHOT.
# Spigot: 1.8 - 1.20.1
# Paper: 1.17 - 1.20.1
# Paper Legacy: 1.9.4 - 1.16.5
# Velocity: 1.0.0 - 4.0.0
# BungeeCord: 1.4.7 - 1.20
spigotVersion = 1.8.8-R0.1-SNAPSHOT
paperVersion =
paperLegacyVersion =
velocityVersion =
bungeeVersion =

# JASKL settings (https://github.com/Almighty-Satan/JASKL)
# If you want to use JASKL, insert the version and implementation here.
# If you don't want to use JASKL, leave at least one of the options empty.
# If JASKL should be shadowed into the JAR file, enable jasklShadow.
jasklVersion = 1.4.0
jasklImplementation = hocon
jasklShadow = false

# Gradle settings
projectGroup = net.kettlemc
javaSourceVersion = 8
javaTargetVersion = 8
generateSourcesJar = true
generateJavadocJar = true
# org.gradle.java.home=C:/Program Files/Eclipse Adoptium/jdk-17.0.2.8-hotspot
```

## ➕ Additional Information
As this template has been created for KettleMC.net, most of the settings are already set up for KettleMC.net. If you want to use this template for your own project, you should change the settings to your liking.

By default, the plugin contains JASKL, a library for creating configuration files. If you don't want to use JASKL, simply disable it in the gradle.properties file.