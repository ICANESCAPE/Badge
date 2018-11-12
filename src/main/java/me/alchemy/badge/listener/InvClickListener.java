package me.alchemy.badge.listener;

import me.alchemy.badge.file.Config;
import me.alchemy.badge.util.BasicUtil;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

/**
 * @author SCT_Alchemy
 * @date 2018/11/12 11:48 PM
 */

public class InvClickListener implements Listener {
    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if(e.getWhoClicked() instanceof Player) {
            Player player = (Player) e.getWhoClicked();
            ItemStack item = e.getCurrentItem();
            int slot = e.getSlot();
            if(!item.isSimilar(BasicUtil.toItem(Config.getBoot())) ||
            !item.isSimilar(BasicUtil.toItem(Config.getHelmet())) ||
            !item.isSimilar(BasicUtil.toItem(Config.getChestplate())) ||
            !item.isSimilar(BasicUtil.toItem(Config.getLeg()))) {
                e.setCancelled(true);
            }
        }
    }
}
