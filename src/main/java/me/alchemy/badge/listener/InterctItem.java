package me.alchemy.badge.listener;

import me.alchemy.badge.file.Config;
import me.alchemy.badge.gui.GuiBuilder;
import me.alchemy.badge.util.BasicUtil;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

/**
 * @author SCT_Alchemy
 * @date 2018/11/11 1:18 PM
 */

public class InterctItem implements Listener {

    @EventHandler
    public void onClick(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        ItemStack item = e.getItem();
        if(e.getAction().equals(Action.LEFT_CLICK_AIR) && item.isSimilar(BasicUtil.toItem(Config.getChest()))) {
            GuiBuilder.open(player);
        } else {
            return;
        }
    }
}
