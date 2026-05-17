package me.hsgamer.bettergui.menusillyfixes.fix;

import io.github.projectunified.minelib.plugin.base.Loadable;
import me.hsgamer.bettergui.menusillyfixes.MenuSillyFixes;
import me.hsgamer.hscore.bukkit.gui.BukkitGUIDisplay;
import org.bukkit.Bukkit;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;

public class UpdateInventoryOnClose implements Loadable, Listener {
    private final MenuSillyFixes addon;

    public UpdateInventoryOnClose(MenuSillyFixes addon) {
        this.addon = addon;
    }

    @Override
    public void enable() {
        Bukkit.getPluginManager().registerEvents(this, addon.getPlugin());
    }

    @Override
    public void disable() {
        HandlerList.unregisterAll(this);
    }

    @EventHandler
    public void onClose(InventoryCloseEvent event) {
        Inventory inventory = event.getInventory();
        if (inventory.getHolder() instanceof BukkitGUIDisplay) {
            HumanEntity humanEntity = event.getPlayer();
            if (humanEntity instanceof Player) {
                ((Player) humanEntity).updateInventory();
            }
        }
    }
}
