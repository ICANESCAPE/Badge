package me.alchemy.badge.listener;

import me.alchemy.badge.file.Config;
import me.alchemy.badge.util.DataUtil;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

/**
 * @author SCT_Alchemy
 * @date 2018/11/11 1:05 PM
 */

public class InvClose implements Listener {

    @EventHandler
    public void onClose(InventoryCloseEvent e) {
        Player player = (Player) e.getPlayer();
        Inventory inventory = e.getInventory();
        ItemStack helmet, chestplate, legging, boots;
        if(e.getInventory().getName().contains(Config.getGuiname())) {
            /* 首先获取四个位置的道具 */
            helmet = inventory.getItem(Integer.parseInt(Config.getEquip().split(",")[0]));
            chestplate = inventory.getItem(Integer.parseInt(Config.getEquip().split(",")[1]));
            legging = inventory.getItem(Integer.parseInt(Config.getEquip().split(",")[2]));
            boots = inventory.getItem(Integer.parseInt(Config.getEquip().split(",")[3]));



        }
    }
}
