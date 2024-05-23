package chips.punish;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class Punish extends JavaPlugin {

    @Override
    public void onEnable() {
        Objects.requireNonNull(getCommand("punish")).setExecutor(new punishCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
