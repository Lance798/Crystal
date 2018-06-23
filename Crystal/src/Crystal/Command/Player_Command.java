package Crystal.Command;

import Crystal.Crystal;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Player_Command implements CommandExecutor {

    Crystal main;
    File file;
    FileConfiguration data;
    Set warp_list;
    public Inventory warps1, warps2, warps3, warps4, warps5, warps6, warps7, warps8, warps9, warps10;

    public Player_Command(Crystal main) {
        this.main = main;
        this.file = main.file;
        this.data = main.data;
        this.warp_list = main.warp_list;
        warps1 = main.warps1;
        warps2 = main.warps2;
        warps3 = main.warps3;
        warps4 = main.warps4;
        warps5 = main.warps5;
        warps6 = main.warps6;
        warps7 = main.warps7;
        warps8 = main.warps8;
        warps9 = main.warps9;
        warps10 = main.warps10;
    }

    void addData(double x, double y, double z, String world, String name, List description) {
        data.addDefault(name, true);
        data.set(name + ".name", name);
        data.set(name + ".description", description);
        data.set(name + ".x", x);
        data.set(name + ".y", y);
        data.set(name + ".z", z);
        data.set(name + ".world", world);
        try {
            data.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addMaterial(Inventory inv, int Slot, String name, List lore) {
        ItemStack item = new ItemStack(Material.INK_SACK, 1, (short) DyeColor.LIGHT_BLUE.getDyeData());
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);

        meta.setLore(lore);
        item.setItemMeta(meta);
        inv.setItem(Slot, item);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("test")) {
            Player player = (Player) sender;
            player.sendMessage("begin");
            for (int i = 1; i <= 55; i++) {
                String name = "test" + i;
                ArrayList<String> Lore = new ArrayList();
                Lore.add("test");
                addData(1, 1, 1, "world", name, Lore);
                player.sendMessage(name);
            }
            main.inventory();
        }
        if (cmd.getName().equalsIgnoreCase("tc")) {
            Player player = (Player) sender;
            if (args.length < 1) {
                if (player.hasPermission("TeleportCrystal.help")) {
                    player.sendMessage(ChatColor.YELLOW + "==========" + ChatColor.GOLD + "TeleportCrystal" + ChatColor.YELLOW + "==========");
                    player.sendMessage(ChatColor.GOLD + "指令列表：");
                    player.sendMessage(ChatColor.GOLD + "  /tc help - 顯示所有指令。");
                    player.sendMessage(ChatColor.GOLD + "  /tc create <名稱> <敘述> - 創建新的傳送點。");
                    player.sendMessage(ChatColor.GOLD + "  /tc remove <名稱> - 刪除一傳送點");
                    player.sendMessage(ChatColor.GOLD + "  /tc give - 給予傳送水晶。");
                    player.sendMessage(ChatColor.GOLD + "  /tc menu 顯示傳送列表。");
                    player.sendMessage(ChatColor.GOLD + "  /tc set <傳送點名稱> - 設置偵測玩家是否經過該點之位置。");
                    return false;
                } else {
                    player.sendMessage(ChatColor.RED + "你沒有權限!");
                    return false;
                }
            }
            switch (args[0]) {
                case "help":
                    if (player.hasPermission("TeleportCrystal.help")) {
                        player.sendMessage(ChatColor.YELLOW + "==========" + ChatColor.GOLD + "TeleportCrystal" + ChatColor.YELLOW + "==========");
                        player.sendMessage(ChatColor.GOLD + "指令列表：");
                        player.sendMessage(ChatColor.GOLD + "  /tc help - 顯示所有指令。");
                        player.sendMessage(ChatColor.GOLD + "  /tc create <名稱> <敘述> - 創建新的傳送點。");
                        player.sendMessage(ChatColor.GOLD + "  /tc remove <名稱> - 刪除一傳送點");
                        player.sendMessage(ChatColor.GOLD + "  /tc give - 給予傳送水晶。");
                        player.sendMessage(ChatColor.GOLD + "  /tc menu 顯示傳送列表。");
                        player.sendMessage(ChatColor.GOLD + "  /tc set <傳送點名稱> - 設置偵測玩家是否經過該點之位置。");
                        break;

                    } else {
                        player.sendMessage(ChatColor.RED + "你沒有權限!");
                        break;
                    }
                case "create":
                    if (player.hasPermission("TeleportCrystal.create")) {
                        if (args.length >= 3) {
                            Inventory type = warps1;
                            int size = data.getKeys(false).size();
                            if (size > 45) {
                                type = warps2;
                                size = size - 45;
                                if (size > 45 * 2) {
                                    type = warps3;
                                    size = size - 45;
                                    if (size > 45 * 3) {
                                        type = warps4;
                                        size = size - 45;
                                        if (size > 45 * 4) {
                                            type = warps5;
                                            size = size - 45;
                                            if (size > 45 * 5) {
                                                type = warps6;
                                                size = size - 45;
                                                if (size > 45 * 6) {
                                                    type = warps7;
                                                    size = size - 45;
                                                    if (size > 45 * 7) {
                                                        type = warps8;
                                                        size = size - 45;
                                                        if (size > 45 * 8) {
                                                            type = warps9;
                                                            size = size - 45;
                                                            if (size > 45 * 9) {
                                                                type = warps10;
                                                                size = size - 45;
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }

                            ArrayList<String> lore = new ArrayList();
                            Location location = player.getLocation();
                            double x, y, z;
                            String world = location.getWorld().getName();
                            x = location.getX();
                            y = location.getY();
                            z = location.getZ();
                            String name = args[1];
                            for (int i = 2; i < args.length; i++) {
                               lore.add(args[i]);
                            }
                            addMaterial(type, size, name, lore);
                            addData(x, y, z, world, name, lore);
                            main.inventory();
                        } else {
                            player.sendMessage(ChatColor.RED + "格式錯誤!");
                        }
                    } else {
                        player.sendMessage(ChatColor.RED + "你沒有權限!");
                        break;
                    }
                    break;
                case "give":
                    if (player.hasPermission("TeleportCrystal.give")) {
                        player.getInventory().addItem(main.crystal);
                        break;
                    } else {
                        player.sendMessage(ChatColor.RED + "你沒有權限!");
                        break;
                    }
                case "remove":
                    if (player.hasPermission("TeleportCrystal.remove")) {
                        if (data.contains(args[1])) {
                            data.set(args[1], null);
                            try {
                                data.save(file);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            player.sendMessage(ChatColor.GOLD + "成功刪除!");
                            ItemStack item = new ItemStack(Material.INK_SACK, 1, (short) DyeColor.LIGHT_BLUE.getDyeData());
                            ItemMeta meta = item.getItemMeta();
                            meta.setDisplayName(args[1]);
                            meta.setLore(data.getStringList(args[1] + ".description"));

                            item.setItemMeta(meta);
                            warps1.removeItem(item);
                            warps2.removeItem(item);
                            warps3.removeItem(item);
                            warps4.removeItem(item);
                            warps5.removeItem(item);
                            warps6.removeItem(item);
                            warps7.removeItem(item);
                            warps8.removeItem(item);
                            warps9.removeItem(item);
                            warps10.removeItem(item);
                            break;
                        } else {
                            player.sendMessage(ChatColor.RED + "刪除失敗!");
                            break;
                        }
                    } else {
                        player.sendMessage(ChatColor.RED + "你沒有權限!");
                        break;
                    }
                case "menu":
                    if (player.hasPermission("TeleportCrystal.menu")) {
                        player.openInventory(warps1);
                        break;
                    } else {
                        player.sendMessage(ChatColor.RED + "你沒有權限!");
                        break;
                    }
            }
        }
        return false;
    }
}
