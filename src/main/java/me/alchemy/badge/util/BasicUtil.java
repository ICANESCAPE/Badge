package me.alchemy.badge.util;

import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;
import org.sct.core.file.FileTool;

/**
 * @author SCT_Alchemy
 * @date 2018/11/11 1:10 PM
 */

public class BasicUtil {

    public static ItemStack toItem(String item) {
        return FileTool.getItem(item);
    }

    public static String info(String msg) { return ChatColor.translateAlternateColorCodes('&', msg); }
}
