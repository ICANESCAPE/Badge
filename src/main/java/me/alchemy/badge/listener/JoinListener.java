package me.alchemy.badge.listener;

import me.alchemy.badge.file.Config;
import me.alchemy.badge.util.BasicUtil;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * @author SCT_Alchemy
 * @date 2018/11/12 9:20 PM
 */

public class JoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        if (player.getInventory().getItem(8) == null || !player.getInventory().getItem(8).isSimilar(BasicUtil.toItem(Config.getChest()))) {
            player.getInventory().setItem(8, BasicUtil.toItem(Config.getChest()));
        } else {
            return;
        }
    }
}
