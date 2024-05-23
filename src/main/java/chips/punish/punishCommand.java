package chips.punish;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class punishCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length < 1) {
            Player p = (Player) sender;
            p.sendMessage("§c§lFEJL §8- §7Forkert brug: /punish [spiller]");
        } else {
            gui.punishMenu((Player) sender, args);
        }
        return true;

    }
}
