package com.github.wolfiewaffle.blockhardness.events;

import com.github.wolfiewaffle.blockhardness.config.ConfigManager;

import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class BlockHardnessHook {

	@SubscribeEvent
	public void onBreakSpeed(PlayerEvent.BreakSpeed event) {

		// Return if 1 or 0 hardness
		if (ConfigManager.hardnessMultiplier == 1.0D) {
			return;
		}

		// Null check
		if ((event.getEntityPlayer() != null) && (event.getPos() != null)) {
			event.setNewSpeed(event.getOriginalSpeed() / (float) ConfigManager.hardnessMultiplier);
		}
	}

}
