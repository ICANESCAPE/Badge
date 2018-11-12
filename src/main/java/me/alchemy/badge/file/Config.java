package me.alchemy.badge.file;

import lombok.Getter;
import me.alchemy.badge.Badge;
import me.alchemy.badge.dto.Data;
import org.inventivetalent.itembuilder.util.FileUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author SCT_Alchemy
 * @date 2018/11/11 10:25 AM
 */

public class Config extends FileUtil {

    private static Config config;

    @Getter private static List<Data> data = new ArrayList<>();

    public Config() {super(Badge.getInstance(), "config.yml"); }
    public static void reload() { config = new Config(); }

    @Override
    public void check() {

    }

  /*  @Getter
    public static int size = config.getInt("size");

    @Getter
    public static String chest = config.getString("chest");

    @Getter
    public static String guiname = config.getString("name");*/

  public static int getSize() { return config.getInt("size"); }

  public static String getChest() { return config.getString("chest"); }

  public static String getGuiname() { return config.getString("name"); }

  public static String getEquip() { return config.getString("equip"); }

  public static String getKong() { return config.getString("kong"); }

  public static String getHelmet() { return config.getString("helmet"); }

  public static String getChestplate() { return config.getString("chestplate"); }

  public static String getLeg() { return config.getString("leg"); }

  public static String getBoot() { return config.getString("boot"); }

}
