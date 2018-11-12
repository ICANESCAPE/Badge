package me.alchemy.badge;

import me.alchemy.badge.command.BadgeCommand;
import me.alchemy.badge.dto.Data;
import me.alchemy.badge.file.Config;
import me.alchemy.badge.util.ListenerUtil;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author SCT_Alchemy
 * @date 2018/11/11 10:21 AM
 */

public class Badge extends JavaPlugin {

    private static Badge instance;

    @Override
    public void onEnable() {
        instance = this;
        ListenerUtil.register();
        Bukkit.getPluginCommand("badge").setExecutor(new BadgeCommand());
        warn("&a加载成功");
        Config.reload();
    }

    @Override
    public void onDisable() {

    }

    public static Badge getInstance() { return instance; }

    public static String info(String msg) { return ChatColor.translateAlternateColorCodes('&', msg); }

    public static void warn(String msg) { Bukkit.getConsoleSender().sendMessage(info(msg)); }

}
