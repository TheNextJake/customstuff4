package cubex2.cs4;

import cubex2.cs4.api.ContentRegistry;
import cubex2.cs4.api.CustomStuffPlugin;
import cubex2.cs4.data.ContentRegistryImpl;
import cubex2.cs4.util.PluginHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.discovery.ASMDataTable;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.io.File;
import java.util.List;

@Mod(modid = CustomStuff4.ID, name = CustomStuff4.NAME, version = CustomStuff4.VERSION)
public class CustomStuff4
{
    public static final String ID = "customstuff4";
    public static final String NAME = "Custom Stuff 4";
    public static final String VERSION = "0.0.1";

    private final ContentRegistry contentRegistry = new ContentRegistryImpl();
    private List<CustomStuffPlugin> plugins;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        initPlugins(event.getAsmData());

        File configDir = event.getModConfigurationDirectory();
        File modsDir = new File(configDir.getParent(), "mods");

        ModLoader.initMods(modsDir);
    }

    private void initPlugins(ASMDataTable asmDataTable)
    {
        plugins = PluginHelper.getPluginInstances(asmDataTable);
        plugins.forEach(plugin -> plugin.registerContentType(contentRegistry));
    }
}
