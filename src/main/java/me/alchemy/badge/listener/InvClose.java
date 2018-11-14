package me.alchemy.badge.listener;

import lombok.Getter;

import me.alchemy.badge.file.Config;
import me.alchemy.badge.util.BasicUtil;
import me.alchemy.badge.util.DataUtil;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import org.sct.fv.loreattribute.api.AttributeApi;
import org.sct.fv.loreattribute.dto.Attribute;

import java.util.HashMap;
import java.util.Map;

/**
 * @author SCT_Alchemy
 * @date 2018/11/11 1:05 PM
 */

public class InvClose implements Listener {

    @Getter
    private static Map<String, Attribute> attributeMap = new HashMap<>();

    @EventHandler
    public void onClose(InventoryCloseEvent e) {

        Player player = (Player) e.getPlayer();
        Inventory inventory = e.getInventory();
        ItemStack helmet, chestplate, legging, boots;
        Attribute attribute = AttributeApi.calcutePlayerAttribute(player);

        if(e.getInventory().getName().contains(Config.getGuiname())) {
            /* 首先获取四个位置的道具 */
            helmet = inventory.getItem(Integer.parseInt(Config.getEquip().split(",")[0]));
            chestplate = inventory.getItem(Integer.parseInt(Config.getEquip().split(",")[1]));
            legging = inventory.getItem(Integer.parseInt(Config.getEquip().split(",")[2]));
            boots = inventory.getItem(Integer.parseInt(Config.getEquip().split(",")[3]));

            if(helmet != null && helmet.isSimilar(BasicUtil.toItem(Config.getHelmet()))) {
                DataUtil.setPlayerInfo(player.getName(), "helmet", Config.getHelmet());
                attribute = AttributeApi.calculate(attribute, AttributeApi.getAttributeFromItem(helmet));
            } else {
                player.sendMessage(BasicUtil.info("&c这个物品不是头盔饰品，不作计算"));
                DataUtil.setPlayerInfo(player.getName(), "helmet", null);
                if(helmet != null) {
                    player.getInventory().addItem(new ItemStack[] { helmet } );
                }
            }
            if(chestplate != null && chestplate.isSimilar(BasicUtil.toItem(Config.getChestplate()))) {
                DataUtil.setPlayerInfo(player.getName(), "chestplate", Config.getChestplate());
                attribute = AttributeApi.calculate(attribute, AttributeApi.getAttributeFromItem(chestplate));
            } else {
                player.sendMessage(BasicUtil.info("&c这个物品不是胸甲饰品，不作计算"));
                DataUtil.setPlayerInfo(player.getName(), "chestplate", null);
                if(chestplate != null) {
                    player.getInventory().addItem(new ItemStack[] { chestplate } );
                }
            }
            if(legging != null && legging.isSimilar(BasicUtil.toItem(Config.getLeg()))) {
                DataUtil.setPlayerInfo(player.getName(), "leg", Config.getLeg());
                attribute = AttributeApi.calculate(attribute, AttributeApi.getAttributeFromItem(legging));
            } else {
                DataUtil.setPlayerInfo(player.getName(), "leg", null);
                player.sendMessage(BasicUtil.info("&c这个物品不是护腿饰品或者为空，不作计算"));
                if(legging != null) {
                    player.getInventory().addItem(new ItemStack[] { legging } );
                }
            }
            if(boots != null && boots.isSimilar(BasicUtil.toItem(Config.getBoot()))) {
                DataUtil.setPlayerInfo(player.getName(), "boot", Config.getBoot());
                attribute = AttributeApi.calculate(attribute, AttributeApi.getAttributeFromItem(boots));
            } else {
                player.sendMessage(BasicUtil.info("&c这个物品为空或者不是护腿饰品，不作计算"));
                DataUtil.setPlayerInfo(player.getName(), "boot", null);
                if(legging != null) {
                    player.getInventory().addItem(new ItemStack[] { boots } );
                }
            }
            attributeMap.put(player.getName(), attribute);
            player.sendMessage(BasicUtil.info("&a记录完成"));
        }
    }
}
