package com.github.wolfiewaffle.blockhardness;

import com.github.wolfiewaffle.blockhardness.config.ConfigManager;
import com.github.wolfiewaffle.blockhardness.events.BlockHardnessHook;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = "wafflesblockhardness", name = "Waffle's Block Hardness", version = "1.0", guiFactory = "com.github.wolfiewaffle.blockhardness.config.ModGuiFactory")
public class BlockHardness {

	@Mod.Instance("wafflesblockhardness")
	public static BlockHardness instance;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		ConfigManager.loadConfig(new Configuration(event.getSuggestedConfigurationFile()));
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
	}

	@SuppressWarnings("deprecation")
	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(new BlockHardnessHook());
		FMLCommonHandler.instance().bus().register(new BlockHardnessHook());
	}

}
