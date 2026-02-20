package xyz.bitsquidd.scaffold;

import io.papermc.paper.plugin.loader.PluginClasspathBuilder;
import io.papermc.paper.plugin.loader.PluginLoader;

@SuppressWarnings("UnstableApiUsage")
public class ScaffoldPluginLoader implements PluginLoader {
    @Override
    public void classloader(PluginClasspathBuilder classpathBuilder) {
        // Default bootstrap method, does nothing.
    }

}
