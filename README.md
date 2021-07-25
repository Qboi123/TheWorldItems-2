# The World Items 2

*Note: I used a decompiler to decompile the project because I haven't the code anymore.*  
This mod adds different types of blocks and items. At the moment there's only basalt, aquamarine, ruby, mountain
crystal, armor, tools and weapons. My intention was to also add armor and more items, a dimension, biomes and
structures.

## My other Mods

Take a look at my other mod:
[Master Weapons](https://github.com/QTechCommunity/MasterWeapons).

## Credits

* Pylo - MCreator for the creator I used originally: https://mcreator.net/
* Subwoofer - Some Structures: https://www.planetminecraft.com/project/111-structure_block-saves-to-share-nbt/

## License

This mod is under the Creative Commons Zero license. You can use the resources, and code in any way you want.

## Disclaimer

This is a mod I created a long time ago. I was just learning how modding works. By that, the mod was using a mod creator
created. (See credits for the mod creator)
If you want start making your own mod, check this site for info how to create your own mod as a starter.

## Source installation information for modders

This code follows the Minecraft Forge installation methodology. It will apply some small patches to the vanilla MCP
source code, giving you and access to some data and functions you need to build a successful mod.

Note also that the patches are against `unrenamed` MCP source code (aka SRG-names) built - this means that you will not
be able to read them directly against normal code.

Source pack installation information:

### Standalone source installation

**Step 1**: Open your command-line and browse to the folder where you extracted the zip file.

**Step 2**: Once you have a command window up in the folder that the downloaded material placed was, type:  
Windows: `gradlew setupDecompWorkspace`  
Linux/macOS: `./gradlew setupDecompWorkspace`

**Step 3**: After all that finished, you're left with a choice. For eclipse, run `gradlew eclipse` (`./gradlew eclipse`
if you are on Mac/Linux)

If you prefer to use IntelliJ, steps are a little different.
1. Open IDEA, and import project.
2. Select your build.gradle file and have it import.
3. Once it's finished you must close IntelliJ and run the following command:

`gradlew genIntellijRuns` (`./gradlew genIntellijRuns` if you are on Mac/Linux)

**Step 4**: The final step is to open Eclipse and switch your workspace to /eclipse/ (if you use IDEA, it should
automatically start on your project)

If at any point you are missing libraries in your IDE, or you've run into problems you can
run `gradlew --refresh-dependencies` to refresh the local cache. `gradlew clean` to reset everything {this does not
affect your code} and then start the process again.

<!--Should it still not work, refer to #ForgeGradle on EsperNet for more information about the gradle environment.-->

Tip:
If you do not care about seeing Minecraft's source code you can replace `setupDecompWorkspace` with one of the
following:  
`setupDevWorkspace`: Will patch, deobfuscated, and gather required assets to run minecraft. In the other hand it won't
generate human-readable source code.  
`setupCIWorkspace`: Same as Dev but will not download any assets. This is useful in build servers as it is the fastest
because it does the least work.

Tip:
When using Decomp workspace, the Minecraft source code isn't added to your workspace editable. Minecraft is then like a
normal Library treated. Sources are there for documentation and research purposes and usually can be accessed under
the 'referenced libraries' section of your IDE.

### Forge source installation

MinecraftForge ships with this code and installs it as part of the forge installation process, no further action is on
your part required.
