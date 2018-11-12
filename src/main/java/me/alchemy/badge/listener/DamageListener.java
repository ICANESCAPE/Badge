package me.alchemy.badge.listener;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import org.sct.fv.loreattribute.api.AttributeApi;
import org.sct.fv.loreattribute.dto.Attribute;
import org.sct.fv.loreattribute.file.Message;
import org.sct.fv.loreattribute.util.BasicUtil;
import org.sct.fv.loreattribute.util.MethodsUtil;

/**
 * @author SCT_Alchemy
 * @date 2018/11/12 10:21 PM
 */

public class DamageListener implements Listener {

    @EventHandler(priority = EventPriority.LOWEST)
    public void onDamage(EntityDamageByEntityEvent e) {

        if(e.getDamager() instanceof Player) {
            Player damager = (Player) e.getDamager();
            LivingEntity entity = (LivingEntity) e.getEntity();
            double damage = e.getDamage();

            Attribute DamagerAttribute = AttributeApi.calculate(InvClose.getAttributeMap().get(damager.getName()));

            damage += (double) DamagerAttribute.getDamage() * (1.0 + (double) DamagerAttribute.getCritical()/100.0);

            if(DamagerAttribute.getRealattack() >= 0 && e.getEntity() instanceof Player) {
                ((Player) e.getEntity()).setHealth(((Player) e.getEntity()).getHealth() - DamagerAttribute.getRealattack());
                damager.sendMessage(BasicUtil.getMessage(Message.getRealAttack()));
            }
            if(MethodsUtil.isSeckill(DamagerAttribute)) {
                entity.setHealth(0);
                damager.sendMessage(BasicUtil.getMessage(Message.getSecKill()));
            }
            entity.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, DamagerAttribute.getIcy(), 5));
            entity.addPotionEffect(new PotionEffect(PotionEffectType.POISON, DamagerAttribute.getPoison(), 5));
            entity.setFireTicks(DamagerAttribute.getFire() * 20);
            e.setDamage(damage);
        }
    }
}
