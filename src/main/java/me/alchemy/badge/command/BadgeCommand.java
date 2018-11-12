package me.alchemy.badge.command;

import me.alchemy.badge.gui.GuiBuilder;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * @author SCT_Alchemy
 * @date 2018/11/11 11:33 AM
 */

public class BadgeCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            if(args[0].equalsIgnoreCase("open")) {
                GuiBuilder.open(player);
            }
        }
        return false;
    }
}
