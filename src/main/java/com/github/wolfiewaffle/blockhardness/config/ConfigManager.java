package com.github.wolfiewaffle.blockhardness.config;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

public class ConfigManager {

	public static ConfigManager instance;

	public static double hardnessMultiplier;

	public static void loadConfig(Configuration configuration) {
		instance = new ConfigManager(configuration);
	}

	public final Configuration config;

	public ConfigManager(Configuration configuration) {
		this.config = configuration;

		Property p_hardnessMultiplier = configuration.get("General", "hardnessMultiplier", 2.0);

		configuration.load();

		hardnessMultiplier = p_hardnessMultiplier.getDouble();

		boolean anyDefault = !p_hardnessMultiplier.wasRead();
		// anyDefault = anyDefault || !p_aonther.wasRead();

		if (anyDefault) {
			configuration.save();
		}
	}

}
