package com.tom.createores.client;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

import com.simibubi.create.foundation.ponder.ElementLink;
import com.simibubi.create.foundation.ponder.SceneBuilder;
import com.simibubi.create.foundation.ponder.SceneBuildingUtil;
import com.simibubi.create.foundation.ponder.element.InputWindowElement;
import com.simibubi.create.foundation.ponder.element.WorldSectionElement;
import com.simibubi.create.foundation.utility.Pointing;

import com.tom.createores.CreateOreExcavation;

public class PonderScenes {

	public static void oreFinder(SceneBuilder scene, SceneBuildingUtil util) {
		scene.title("find_ores", "Find ore veins using the Vein Finder");
		scene.configureBasePlate(0, 0, 9);
		scene.scaleSceneView(.65f);
		scene.setSceneOffsetY(-1);

		ElementLink<WorldSectionElement> groundElement =
				scene.world.showIndependentSection(util.select.fromTo(0, 0, 1, 8, 0, 9), Direction.UP);

		BlockPos ground = util.grid.at(5, 0, 5);
		BlockPos drill = util.grid.at(5, 2, 5);

		scene.overlay.showText(60)
		.attachKeyFrame()
		.text("Use an Ore Vein Finder to locate ores")
		.pointAt(util.vector.blockSurface(ground, Direction.WEST))
		.placeNearTarget();
		scene.idle(60);

		scene.overlay.showControls(new InputWindowElement(util.vector.topOf(ground), Pointing.DOWN).rightClick()
				.withItem(new ItemStack(CreateOreExcavation.VEIN_FINDER_ITEM.get())), 30);

		scene.idle(10);

		scene.overlay.showText(50)
		.text("Found: Nothing")
		.pointAt(util.vector.blockSurface(ground, Direction.WEST))
		.placeNearTarget();
		scene.idle(50);

		scene.world.moveSection(groundElement, util.vector.of(12, 0, 0), 40);
		scene.idle(15);
		scene.world.hideIndependentSection(groundElement, null);

		scene.idle(15);

		groundElement = scene.world.showIndependentSection(util.select.fromTo(0, 0, 1, 8, 0, 9), null);
		scene.world.moveSection(groundElement, util.vector.of(-8, 0, 0), 0);
		scene.world.moveSection(groundElement, util.vector.of(8, 0, 0), 40);

		scene.idle(40);

		scene.overlay.showControls(new InputWindowElement(util.vector.topOf(ground), Pointing.DOWN).rightClick()
				.withItem(new ItemStack(CreateOreExcavation.VEIN_FINDER_ITEM.get())), 30);

		scene.idle(10);

		scene.overlay.showText(50)
		.text("Found: Copper Ore")
		.pointAt(util.vector.blockSurface(ground, Direction.WEST))
		.placeNearTarget();
		scene.idle(60);

		scene.overlay.showText(70)
		.attachKeyFrame()
		.text("Place a Drilling Machine or a Fluid Extractor to harvest the resources")
		.pointAt(util.vector.blockSurface(ground, Direction.WEST))
		.placeNearTarget();
		scene.idle(20);

		scene.world.showSection(util.select.fromTo(3, 1, 4, 5, 2, 6), Direction.DOWN);
		scene.world.setKineticSpeed(util.select.position(4, 1, 4), 0);
		scene.idle(60);

		scene.overlay.showText(40)
		.text("Put in a Drill")
		.pointAt(util.vector.blockSurface(drill, Direction.WEST))
		.placeNearTarget();
		scene.idle(10);

		scene.overlay.showControls(new InputWindowElement(util.vector.topOf(drill), Pointing.DOWN).rightClick()
				.withItem(new ItemStack(CreateOreExcavation.NORMAL_DRILL_ITEM.get())), 30);
		scene.idle(30);

		scene.overlay.showText(70)
		.attachKeyFrame()
		.text("The machines require Rotational Force to operate")
		.pointAt(util.vector.blockSurface(util.grid.at(5, 0, 2), Direction.WEST))
		.placeNearTarget();
		scene.idle(20);

		scene.world.showSection(util.select.fromTo(4, 1, 0, 4, 1, 3), Direction.DOWN);
		scene.world.showSection(util.select.position(5, 0, 0), Direction.NORTH);
		scene.idle(20);
		scene.world.setKineticSpeed(util.select.position(4, 1, 4), -32);
		scene.idle(40);

		scene.overlay.showText(70)
		.attachKeyFrame()
		.text("Extract the results")
		.pointAt(util.vector.blockSurface(util.grid.at(2, 1, 5), Direction.WEST))
		.placeNearTarget();
		scene.idle(20);

		scene.world.showSection(util.select.fromTo(0, 1, 5, 2, 2, 5), Direction.DOWN);
		scene.world.showSection(util.select.fromTo(2, 1, 6, 2, 1, 10), Direction.DOWN);
		scene.world.showSection(util.select.position(1, 0, 10), Direction.SOUTH);

		scene.idle(40);
		scene.world.flapFunnel(util.grid.at(2, 2, 5), true);
		scene.world.createItemOnBelt(util.grid.at(2, 1, 5), Direction.EAST, new ItemStack(Items.RAW_COPPER));

		scene.idle(60);

		scene.overlay.showText(70)
		.attachKeyFrame()
		.text("Some ore veins require drilling fluid")
		.pointAt(util.vector.blockSurface(util.grid.at(6, 1, 5), Direction.WEST))
		.placeNearTarget();
		scene.idle(10);

		scene.rotateCameraY(70);
		scene.idle(10);

		scene.world.showSection(util.select.fromTo(6, 1, 5, 7, 1, 10), Direction.DOWN);
		scene.world.showSection(util.select.position(6, 0, 10), Direction.SOUTH);

		scene.idle(60);
	}
}
