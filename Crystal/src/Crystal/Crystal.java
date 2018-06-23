package Crystal;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import Crystal.Command.Teleport;
import Crystal.Listener.Teleport_Listener;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Crystal extends JavaPlugin {
	public static File file = new File("plugins/Crystal/warps.yml");
	public static FileConfiguration data = YamlConfiguration.loadConfiguration(file);
	@SuppressWarnings("deprecation")
	public ItemStack crystal = new ItemStack(Material.INK_SACK, 1, (short) DyeColor.LIGHT_BLUE.getDyeData());
	public ItemStack next = new ItemStack(Material.ARROW), back = new ItemStack(Material.ARROW);
	public static Inventory warps1, warps2, warps3, warps4, warps5, warps6, warps7, warps8, warps9, warps10;

	@Override
	public void onEnable() {
		warps1 = Bukkit.getServer().createInventory(null, 54, "�ǰe�M��Ĥ@��");
		warps2 = Bukkit.getServer().createInventory(null, 54, "�ǰe�M��ĤG��");
		warps3 = Bukkit.getServer().createInventory(null, 54, "�ǰe�M��ĤT��");
		warps4 = Bukkit.getServer().createInventory(null, 54, "�ǰe�M��ĥ|��");
		warps5 = Bukkit.getServer().createInventory(null, 54, "�ǰe�M��Ĥ���");
		warps6 = Bukkit.getServer().createInventory(null, 54, "�ǰe�M��Ĥ���");
		warps7 = Bukkit.getServer().createInventory(null, 54, "�ǰe�M��ĤC��");
		warps8 = Bukkit.getServer().createInventory(null, 54, "�ǰe�M��ĤK��");
		warps9 = Bukkit.getServer().createInventory(null, 54, "�ǰe�M��ĤE��");
		warps10 = Bukkit.getServer().createInventory(null, 54, "�ǰe�M��ĤQ��");
		getCommandExecutor();
		setupFile();
		inventory();
		registerEvents();
		setup();
	}

	public void getCommandExecutor() {
		this.getCommand("tc").setExecutor(new Teleport(this));
	}

	public void registerEvents() {
		this.getServer().getPluginManager().registerEvents(new Teleport_Listener(this), this);
	}

	public void setupFile() {
		if (!file.exists()) {
			try {
				file.getParentFile().mkdirs();
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void inventory() {
		back = new ItemStack(Material.ARROW);
		ItemMeta bm;
		bm = back.getItemMeta();
		bm.setDisplayName(ChatColor.GOLD + "�W�@��");
		back.setItemMeta(bm);

		ItemMeta nm;
		nm = next.getItemMeta();
		nm.setDisplayName(ChatColor.GOLD + "�U�@��");
		next.setItemMeta(nm);

		ItemMeta cm;
		cm = crystal.getItemMeta();
		cm.setDisplayName(ChatColor.GREEN + "�ǰe����");
		ArrayList<String> lore = new ArrayList<>();
		lore.add("�i�ǰe����w�a�I�A�î��Ӥ@�Ӥ����C");
		cm.setLore(lore);
		crystal.setItemMeta(cm);

		int size = data.getKeys(false).size();
		if (size > 45) {
			warps1.setItem(53, next);
			if (size > 45 * 2) {
				warps2.setItem(45, back);
				warps2.setItem(53, next);
				if (size > 45 * 3) {
					warps3.setItem(45, back);
					warps3.setItem(53, next);
					if (size > 45 * 4) {
						warps5.setItem(45, back);
						warps5.setItem(53, next);
						if (size > 45 * 5) {
							warps6.setItem(45, back);
							warps6.setItem(53, next);
							if (size > 45 * 6) {
								warps7.setItem(45, back);
								warps7.setItem(53, next);
								if (size > 45 * 7) {
									warps7.setItem(45, back);
									warps7.setItem(53, next);
									if (size > 45 * 8) {
										warps8.setItem(45, back);
										warps8.setItem(53, next);
										if (size > 45 * 9) {
											warps9.setItem(45, back);
											warps9.setItem(53, next);
											if (size > 45 * 10) {
												warps10.setItem(45, back);
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}

	public static void setup() {
		for (int i = 0; i < data.getKeys(false).size(); i++) {
			String name = data.getKeys(false).toArray()[i].toString();
			List<String> lore = data.getStringList(name + ".description");
			Inventory type = warps1;
			if (i > 45) {
				type = warps2;
				i -= 45;
				if (i > 90) {
					type = warps3;
					i -= 45;
					if (i > 135) {
						type = warps4;
						i -= 45;
						if (i > 180) {
							type = warps5;
							i -= 45;
							if (i > 225) {
								type = warps6;
								i -= 45;
								if (i > 270) {
									type = warps7;
									i -= 45;
									if (i > 315) {
										type = warps8;
										i -= 45;
										if (i > 360) {
											type = warps9;
											i -= 45;
											if (i > 405) {
												type = warps10;
												i -= 45;
											}
										}
									}
								}
							}
						}
					}
				}
			}
			Teleport.addMaterial(type, i, name, lore);
		}
	}
}
