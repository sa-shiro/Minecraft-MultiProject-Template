# Minecraft Multi Project Template

This project is a Template to manage multiple *Minecraft Forge/Fabric Projects* of ***ANY*** version

The Template contains examples for all supported major Minecraft Versions for Forge (1.12.2 - 1.20.1) using the latest ForgeGradle Version.

## Getting Started

- clone this repo
- if needed, delete all modules from `modules/` and the import statement from `settings.gradle` you don't need
- uncomment the modules you need (the import of `example_module` is enabled by default)
- open / import this project in IntelliJ IDEA (eclipse has not been tested and may cause issues!)
- edit `gradle.properties` to your needs

Alternatively you can delete all modules from `modules/` and start from scratch using the `example_module`, simply copy and rename it and change `MODULE_NAME/settings.gradle` to your needs  
(for <= 1.16.5 copy the version u want instead as buildscript is slightly different)

### Additional info:

There is no need to touch `mods.toml` and `pack.mcmeta` as all attributes are defined in `MODULE_NAME/gradle.properties` unless required  
(Forge Data Generation task may fail if run manually because of `pack.mcmeta`, for it to run properly execute the `genIntellijRuns` and run the Data Generator using IntelliJ instead of the task)
