package com.ruinscraft.townie.bukkit;

import com.ruinscraft.townie.api.ITownie;
import com.ruinscraft.townie.api.TConfig;
import com.ruinscraft.townie.classic.TownieClassic;
import org.bukkit.plugin.java.JavaPlugin;

public class TowniePlugin extends JavaPlugin {

    private ITownie townie;

    @Override
    public void onLoad() {
        TConfig tConfig = new TConfig();
        // TODO: load config from file

        townie = new TownieClassic(tConfig);
    }

    @Override
    public void onEnable() {
        townie.enable();
    }

    @Override
    public void onDisable() {
        townie.disable();
    }

}
