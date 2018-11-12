package me.alchemy.badge.util;

import me.alchemy.badge.Badge;
import me.alchemy.badge.listener.InvClose;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

/**
 * @author SCT_Alchemy
 * @date 2018/11/11 9:20 PM
 */

public class ListenerUtil {

    public static void register() {
        register(new InvClose());
    }
    private static void register(Listener listener) {
        Bukkit.getPluginManager().registerEvents(listener, Badge.getInstance());
    }
}
