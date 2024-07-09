package com.tom.createores.data;

import net.minecraft.data.DataGenerator;

import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import com.simibubi.create.foundation.ponder.PonderLocalization;

import com.tom.createores.CreateOreExcavation;
import com.tom.createores.cc.TurtleUpgradeData;
import com.tom.createores.client.ClientRegistration;

@Mod.EventBusSubscriber(modid = CreateOreExcavation.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {

	@SubscribeEvent
	public static void gatherData(GatherDataEvent event) {
		DataGenerator generator = event.getGenerator();
		generator.addProvider(event.includeServer(), new COERecipes(generator.getPackOutput()));
		generator.addProvider(event.includeServer(), new TurtleUpgradeData(generator.getPackOutput()));
		if(event.includeClient()) {
			ClientRegistration.register();
			PonderLocalization.provideRegistrateLang(CreateOreExcavation.registrate());
		}
	}
}
