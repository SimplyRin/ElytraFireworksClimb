package net.simplyrin.elytrafireworksclimb;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;

import lombok.var;

/**
 * Created by SimplyRin on 2022/06/10.
 */
public class ElytraFireworksClimb extends JavaPlugin implements Listener {
	
	@Override
	public void onEnable() {
		this.getServer().getPluginManager().registerEvents(this, this);
	}
	
	@EventHandler
	public void onInteract(PlayerInteractEvent event) {
		var action = event.getAction();
		
		if (!action.equals(Action.RIGHT_CLICK_BLOCK)) {
			return;
		}
		
		var player = event.getPlayer();
		
		if (!player.isSneaking()) {
			return;
		}
		
		if (!player.isOnGround()) {
			return;
		}
		
		var inventory = player.getInventory();
		
		if (!(inventory.getItemInMainHand() != null && inventory.getItemInMainHand().getType().equals(Material.FIREWORK_ROCKET))) {
			return;
		}
		
		if (inventory.getChestplate() != null && inventory.getChestplate().getType().equals(Material.ELYTRA)) {
			player.setVelocity(new Vector(0, 1, 0));
		}
	}

}
