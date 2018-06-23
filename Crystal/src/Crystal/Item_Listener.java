package Crystal;

import org.bukkit.*;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.File;

public class Item_Listener implements Listener {
    Crystal plugin;
    public Inventory warps1, warps2, warps3, warps4, warps5, warps6, warps7, warps8, warps9, warps10;
    ItemStack Teleport_crystal, back, next;
    FileConfiguration data;
    File file;

    public Item_Listener(Crystal crystal) {
        this.plugin = crystal;
        back = plugin.back;
        next = plugin.next;
        file = plugin.file;
        Teleport_crystal = plugin.crystal;
        data = plugin.data;
        warps1 = plugin.warps1;
        warps2 = plugin.warps2;
        warps3 = plugin.warps3;
        warps4 = plugin.warps4;
        warps5 = plugin.warps5;
        warps6 = plugin.warps6;
        warps7 = plugin.warps7;
        warps8 = plugin.warps8;
        warps9 = plugin.warps9;
        warps10 = plugin.warps10;
    }

    @EventHandler
    public void ClickCrystal(InventoryClickEvent event) {
        ItemStack item;
        String name;
        Player player = (Player) event.getWhoClicked();
        item = event.getCurrentItem();
//        player.sendMessage(item.getType().name());
        Inventory inventory = event.getClickedInventory();
        if (inventory.getName().startsWith("傳送清單第") && item != null && item.getType() != Material.AIR) {
            ItemMeta meta = item.getItemMeta();
            name = meta.getDisplayName();
            if (event.getClick() == ClickType.RIGHT || event.getClick() == ClickType.LEFT) {
                event.setCancelled(true);
                if (item.equals(back)) {
                    player.closeInventory();
                    if (inventory.getName().endsWith("第二頁")) {
                        player.openInventory(warps1);
                    }
                    if (inventory.getName().endsWith("第三頁")) {
                        player.openInventory(warps2);
                    }
                    if (inventory.getName().endsWith("第四頁")) {
                        player.openInventory(warps3);
                    }
                    if (inventory.getName().endsWith("第五頁")) {
                        player.openInventory(warps4);
                    }
                    if (inventory.getName().endsWith("第六頁")) {
                        player.openInventory(warps5);
                    }
                    if (inventory.getName().endsWith("第七頁")) {
                        player.openInventory(warps6);
                    }
                    if (inventory.getName().endsWith("第八頁")) {
                        player.openInventory(warps7);
                    }
                    if (inventory.getName().endsWith("第九頁")) {
                        player.openInventory(warps8);
                    }
                    if (inventory.getName().endsWith("第十頁")) {
                        player.openInventory(warps9);
                    }
                }

                if (item.equals(next)) {
                    player.closeInventory();
                    if (inventory.getName().endsWith("第一頁")) {
                        player.openInventory(warps2);
                    }
                    if (inventory.getName().endsWith("第二頁")) {
                        player.openInventory(warps3);
                    }
                    if (inventory.getName().endsWith("第三頁")) {
                        player.openInventory(warps4);
                    }
                    if (inventory.getName().endsWith("第四頁")) {
                        player.openInventory(warps5);
                    }
                    if (inventory.getName().endsWith("第五頁")) {
                        player.openInventory(warps6);
                    }
                    if (inventory.getName().endsWith("第六頁")) {
                        player.openInventory(warps7);
                    }
                    if (inventory.getName().endsWith("第七頁")) {
                        player.openInventory(warps8);
                    }
                    if (inventory.getName().endsWith("第八頁")) {
                        player.openInventory(warps9);
                    }
                    if (inventory.getName().endsWith("第九頁")) {
                        player.openInventory(warps10);
                    }
                }

                if (item.getType().name().contains("INK_SACK")) {
                    event.setCancelled(true);
                    double x = data.getDouble(name + ".x");
                    double y = data.getDouble(name + ".y");
                    double z = data.getDouble(name + ".z");
                    World world = plugin.getServer().getWorld(data.getString(name + ".world"));
                    player.closeInventory();
                    player.teleport(new Location(world, x, y, z));
                    player.setBedSpawnLocation(player.getLocation(), true);
                    player.sendMessage(ChatColor.GOLD + "正在傳送...");
                    player.sendMessage(ChatColor.GOLD + "已抵達[" + name + "]");
                    player.spawnParticle(Particle.ENCHANTMENT_TABLE, player.getLocation(), 100);
                    player.getInventory().removeItem(Teleport_crystal);
                    player.sendMessage(ChatColor.GOLD + "傳送成功!");
                }
            }
        }
    }

    @EventHandler
    public void PlayerClickCrystal(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (player.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(Teleport_crystal.getItemMeta().getDisplayName()) &&
                player.getItemInHand().getItemMeta().getLore().equals(Teleport_crystal.getItemMeta().getLore()) &&
                player.getItemInHand().getType().equals(Teleport_crystal.getType())) {
            player.openInventory(warps1);
        }
    }
}
