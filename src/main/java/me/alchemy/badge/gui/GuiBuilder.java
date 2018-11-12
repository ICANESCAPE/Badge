package me.alchemy.badge.gui;

import me.alchemy.badge.file.Config;
import me.alchemy.badge.util.BasicUtil;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.sct.core.Core;

/**
 * @author SCT_Alchemy
 * @date 2018/11/11 11:54 AM
 */

public class GuiBuilder {

    private static Inventory inventory;
    private static ItemStack air = new ItemStack(Material.AIR);

    public static void open(Player player) {
        inventory = Bukkit.createInventory(null, Config.getSize(), Config.getGuiname());
        for(int i = 0; i < Config.getSize(); i++) {
            if(i == Integer.parseInt(Config.getEquip().split(",")[0]) ||
                    i == Integer.parseInt(Config.getEquip().split(",")[1]) ||
                    i == Integer.parseInt(Config.getEquip().split(",")[2]) ||
                    i == Integer.parseInt(Config.getEquip().split(",")[3])) {

            } else {
                inventory.setItem(i, BasicUtil.toItem(Config.getKong()));
            }
        }
        player.openInventory(inventory);
    }
}
