package chips.punish;

import dev.triumphteam.gui.builder.item.ItemBuilder;
import dev.triumphteam.gui.guis.Gui;
import dev.triumphteam.gui.guis.GuiItem;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import java.time.Duration;

import static org.bukkit.Bukkit.getPlayer;
import static org.bukkit.Bukkit.getServer;

public class gui implements Listener {
    public static void punishMenu(Player player, String[] args) {
        Gui gui = Gui.gui()
                .title(Component.text("§b§lPUNISH §8- §f" + args[0]))
                .rows(5)
                .disableAllInteractions()
                .create();
        GuiItem guiBorder = ItemBuilder.from(Material.LIGHT_BLUE_STAINED_GLASS_PANE)
                .name(Component.text("")).asGuiItem();
        gui.getFiller().fillBorder(guiBorder);
        GuiItem guiPlayer = ItemBuilder.skull().owner(Bukkit.getOfflinePlayer(args[0]))
                .name(Component.text("§f" + args[0]))
                .lore(Component.text("§7Her ser du mulighederne for at straffe §f" + args[0] + "§7.")).asGuiItem();
        gui.setItem(4, guiPlayer);
        GuiItem guiKick = ItemBuilder.from(Material.PUFFERFISH)
                .name(Component.text("§6§lKICK"))
                .lore(Component.text("§7Tryk her for at kicke §f" + args[0] + "§7.")).asGuiItem(event -> {
                    punishKick(player, args);
                });
        gui.setItem(20, guiKick);
        GuiItem guiMute = ItemBuilder.from(Material.APPLE)
                .name(Component.text("§a§lMUTE"))
                .lore(Component.text("§7Tryk her for at mute §f" + args[0] + "§7.")).asGuiItem(event -> {
                    punishMute(player, args);
                });
        gui.setItem(22, guiMute);
        GuiItem guiBan = ItemBuilder.from(Material.WOODEN_AXE)
                .name(Component.text("§4§lBAN"))
                .lore(Component.text("§7Tryk her for at banne §f" + args[0] + "§7.")).asGuiItem(event -> {
                    punishBan(player, args);
                });
        gui.setItem(24, guiBan);
        GuiItem guiClose = ItemBuilder.from(Material.BARRIER)
                .name(Component.text("§4§lLUK"))
                .lore(Component.text("§7Tryk her for at lukke menuen.")).asGuiItem(event -> {
                    player.closeInventory();
                });
        gui.setItem(40, guiClose);
        gui.open(player);
    }
    public static void punishKick(Player player, String[] args) {
        Gui gui = Gui.gui()
                .title(Component.text("§6§lKICK §8- §f" + args[0]))
                .rows(5)
                .disableAllInteractions()
                .create();
        GuiItem guiBorder = ItemBuilder.from(Material.ORANGE_STAINED_GLASS_PANE)
                .name(Component.text("")).asGuiItem();
        gui.getFiller().fillBorder(guiBorder);
        GuiItem guiPlayer = ItemBuilder.skull().owner(Bukkit.getOfflinePlayer(args[0]))
                .name(Component.text("§f" + args[0]))
                .lore(Component.text("§7Her ser du mulighederne for at kicke §f" + args[0] + "§7.")).asGuiItem();
        gui.setItem(4, guiPlayer);
        GuiItem guiKick1 = ItemBuilder.from(Material.IRON_INGOT)
                .name(Component.text("§6§lKICK"))
                .lore(Component.text("§7Grund: Irriterende Opførsel")).asGuiItem(event -> {
                    player.closeInventory();
                    OfflinePlayer p = getServer().getOfflinePlayer(args[0]);
                    if(p.isOnline()){
                        getPlayer(args[0]).kickPlayer("§7Kicked for \"§fIrriterende Opførsel§7\".");
                        Bukkit.broadcastMessage("§6§lKICK §8- §7Spilleren §f" + args[0] + " §7 blev kicket med grunden \"§fIrriterende Opførsel§7\".");
                    }
                    else {
                        player.sendMessage("§6§lKICK §8- §7Spilleren \"§f" + args[0] + "§7\" er ikke online.");
                    }
                });
        gui.setItem(20, guiKick1);
        GuiItem guiKick2 = ItemBuilder.from(Material.COPPER_INGOT)
                .name(Component.text("§6§lKICK"))
                .lore(Component.text("§7Grund: Provokerende Opførsel")).asGuiItem(event -> {
                    player.closeInventory();
                    OfflinePlayer p = getServer().getOfflinePlayer(args[0]);
                    if(p.isOnline()){
                        getPlayer(args[0]).kickPlayer("§7Kicked for \"§fProvokerende Opførsel§7\".");
                        Bukkit.broadcastMessage("§6§lKICK §8- §7Spilleren §f" + args[0] + " §7 blev kicket med grunden \"§fProvokerende Opførsel§7\".");
                    }
                    else {
                        player.sendMessage("§6§lKICK §8- §7Spilleren \"§f" + args[0] + "§7\" er ikke online.");
                    }
                });
        gui.setItem(21, guiKick2);
        GuiItem guiKick3 = ItemBuilder.from(Material.GOLD_INGOT)
                .name(Component.text("§6§lKICK"))
                .lore(Component.text("§7Grund: Upassende Opførsel")).asGuiItem(event -> {
                    player.closeInventory();
                    OfflinePlayer p = getServer().getOfflinePlayer(args[0]);
                    if(p.isOnline()){
                        getPlayer(args[0]).kickPlayer("§7Kicked for \"§fUpassende Opførsel§7\".");
                        Bukkit.broadcastMessage("§6§lKICK §8- §7Spilleren §f" + args[0] + " §7 blev kicket med grunden \"§fUpassende Opførsel§7\".");
                    }
                    else {
                        player.sendMessage("§6§lKICK §8- §7Spilleren \"§f" + args[0] + "§7\" er ikke online.");
                    }
                });
        gui.setItem(22, guiKick3);
        GuiItem guiKick4 = ItemBuilder.from(Material.DIAMOND)
                .name(Component.text("§6§lKICK"))
                .lore(Component.text("§7Grund: Står i vejen")).asGuiItem(event -> {
                    player.closeInventory();
                    OfflinePlayer p = getServer().getOfflinePlayer(args[0]);
                    if(p.isOnline()){
                        getPlayer(args[0]).kickPlayer("§7Kicked for \"§fStår i vejen§7\".");
                        Bukkit.broadcastMessage("§6§lKICK §8- §7Spilleren §f" + args[0] + " §7 blev kicket med grunden \"§fStår i vejen§7\".");
                    }
                    else {
                        player.sendMessage("§6§lKICK §8- §7Spilleren \"§f" + args[0] + "§7\" er ikke online.");
                    }
                });
        gui.setItem(23, guiKick4);
        GuiItem guiKick5 = ItemBuilder.from(Material.EMERALD)
                .name(Component.text("§6§lKICK"))
                .lore(Component.text("§7Grund: Andet")).asGuiItem(event -> {
                    player.closeInventory();
                    OfflinePlayer p = getServer().getOfflinePlayer(args[0]);
                    if(p.isOnline()){
                        getPlayer(args[0]).kickPlayer("§7Kicked for \"§fAndet§7\".");
                        Bukkit.broadcastMessage("§6§lKICK §8- §7Spilleren §f" + args[0] + " §7 blev kicket med grunden \"§fAndet§7\".");
                    }
                    else {
                        player.sendMessage("§6§lKICK §8- §7Spilleren \"§f" + args[0] + "§7\" er ikke online.");
                    }
                });
        gui.setItem(24, guiKick5);
        GuiItem guiClose = ItemBuilder.from(Material.BARRIER)
                .name(Component.text("§4§lTILBAGE"))
                .lore(Component.text("§7Tryk her for at gå tilbage til menuen.")).asGuiItem(event -> {
                    punishMenu(player, args);
                });
        gui.setItem(40, guiClose);
        gui.open(player);
    }
    public static void punishMute(Player player, String[] args) {
        Gui gui = Gui.gui()
                .title(Component.text("§a§lMUTE §8- §f" + args[0]))
                .rows(5)
                .disableAllInteractions()
                .create();
        GuiItem guiBorder = ItemBuilder.from(Material.LIME_STAINED_GLASS_PANE)
                .name(Component.text("")).asGuiItem();
        gui.getFiller().fillBorder(guiBorder);
        GuiItem guiPlayer = ItemBuilder.skull().owner(Bukkit.getOfflinePlayer(args[0]))
                .name(Component.text("§f" + args[0]))
                .lore(Component.text("§7Her ser du mulighederne for at mute §f" + args[0] + "§7.")).asGuiItem();
        gui.setItem(4, guiPlayer);
        GuiItem guiMute1 = ItemBuilder.from(Material.COOKED_BEEF)
                .name(Component.text("§a§lMUTE"))
                .lore(Component.text("§7Grund: Sprog"),Component.text("§7Tid: 30 minutter")).asGuiItem();
        gui.setItem(20, guiMute1);
        GuiItem guiMute2 = ItemBuilder.from(Material.COOKED_MUTTON)
                .name(Component.text("§a§lMUTE"))
                .lore(Component.text("§7Grund: Groft Sprog"),Component.text("§7Tid: 6 timer")).asGuiItem();
        gui.setItem(21, guiMute2);
        GuiItem guiMute3 = ItemBuilder.from(Material.COOKED_RABBIT)
                .name(Component.text("§a§lMUTE"))
                .lore(Component.text("§7Grund: Irriteremde Adfærd"),Component.text("§7Tid: 15 minutter")).asGuiItem();
        gui.setItem(22, guiMute3);
        GuiItem guiMute4 = ItemBuilder.from(Material.COOKED_CHICKEN)
                .name(Component.text("§a§lMUTE"))
                .lore(Component.text("§7Grund: Reklame"),Component.text("§7Tid: Permanent"),Component.text("§7Info: Send et billede til mod+")).asGuiItem();
        gui.setItem(23, guiMute4);
        GuiItem guiMute5 = ItemBuilder.from(Material.COOKED_PORKCHOP)
                .name(Component.text("§a§lMUTE"))
                .lore(Component.text("§7Grund: Andet")).asGuiItem();
        gui.setItem(24, guiMute5);
        GuiItem guiClose = ItemBuilder.from(Material.BARRIER)
                .name(Component.text("§4§lTILBAGE"))
                .lore(Component.text("§7Tryk her for at gå tilbage til menuen.")).asGuiItem(event -> {
                    punishMenu(player, args);
                });
        gui.setItem(40, guiClose);
        gui.open(player);
    }
    public static void punishBan(Player player, String[] args) {
        Gui gui = Gui.gui()
                .title(Component.text("§4§lBAN §8- §f" + args[0]))
                .rows(5)
                .disableAllInteractions()
                .create();
        GuiItem guiBorder = ItemBuilder.from(Material.RED_STAINED_GLASS_PANE)
                .name(Component.text("")).asGuiItem();
        gui.getFiller().fillBorder(guiBorder);
        GuiItem guiPlayer = ItemBuilder.skull().owner(Bukkit.getOfflinePlayer(args[0]))
                .name(Component.text("§f" + args[0]))
                .lore(Component.text("§7Her ser du mulighederne for at banne §f" + args[0] + "§7.")).asGuiItem();
        gui.setItem(4, guiPlayer);
        GuiItem guiBan1 = ItemBuilder.from(Material.SPIDER_EYE)
                .name(Component.text("§4§lBAN"))
                .lore(Component.text("§7Grund: Hack"),Component.text("§7Tid: 30 dage")).asGuiItem();
        gui.setItem(20, guiBan1);
        GuiItem guiBan2 = ItemBuilder.from(Material.REDSTONE)
                .name(Component.text("§4§lBAN"))
                .lore(Component.text("§7Grund: Opførsel"),Component.text("§7Tid: 3 dage")).asGuiItem();
        gui.setItem(21, guiBan2);
        GuiItem guiBan3 = ItemBuilder.from(Material.COPPER_INGOT)
                .name(Component.text("§4§lBAN"))
                .lore(Component.text("§7Grund: Reklame"),Component.text("§7Tid: Permanent")).asGuiItem();
        gui.setItem(22, guiBan3);
        GuiItem guiBan4 = ItemBuilder.from(Material.END_PORTAL_FRAME)
                .name(Component.text("§4§lBAN"))
                .lore(Component.text("§7Grund: Forsøg på crash/grief"),Component.text("§7Tid: Permanent")).asGuiItem();
        gui.setItem(23, guiBan4);
        GuiItem guiBan5 = ItemBuilder.from(Material.RED_GLAZED_TERRACOTTA)
                .name(Component.text("§4§lBAN"))
                .lore(Component.text("§7Grund: Andet")).asGuiItem();
        gui.setItem(24, guiBan5);
        GuiItem guiClose = ItemBuilder.from(Material.BARRIER)
                .name(Component.text("§4§lTILBAGE"))
                .lore(Component.text("§7Tryk her for at gå tilbage til menuen.")).asGuiItem(event -> {
                    punishMenu(player, args);
                });
        gui.setItem(40, guiClose);
        gui.open(player);
    }
}