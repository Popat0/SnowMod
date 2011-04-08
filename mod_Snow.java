package net.minecraft.src;
// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

import net.minecraft.client.Minecraft;
import net.minecraft.src.modoptionsapi.*;
import org.lwjgl.input.Keyboard;

public class mod_Snow extends BaseMod
{
	public static ModMappedMultiOption SnowMode;
	public static ModSliderOption SnowRate;
	public static ModSliderOption SnowPerTick;
	private static ModOptions snow;
	
    public mod_Snow()
    {	
		ModOptions snow = new ModOptions("Snow Options");
		
		Integer keys[]  = {0,1,2};
		String values[] = {"Off", "Cold Biomes", "Everywhere"};
		
		SnowMode = new ModMappedMultiOption("Snowfall");
		for(int x = 0; x < keys.length; x++) {
			SnowMode.addValue(keys[x], values[x]);
		}
		
		SnowRate = new ModSliderOption("Snow Speed", 1, 15);
		SnowPerTick = new ModSliderOption("Blocks placed", 1, 30);
		SnowPerTick.setGlobalValue(SnowPerTick.getFloatValue(6));
		SnowRate.setGlobalValue(SnowRate.getFloatValue(4));
		
		snow.addOption(SnowPerTick);
		snow.addOption(SnowRate);
		snow.addOption(SnowMode);
    	
    	System.out.printf("SnowMod v0.6 by CJ - Loaded.\n");
		System.out.printf("Snow Proba = %d\n", SnowRate.getIntValue());
		System.out.printf("Snow Per Tick = %d\n\n", SnowPerTick.getIntValue());
		
		snow.loadValues();
		ModOptionsAPI.addMod(snow);
    }

    public String Version()
    {
        return "SnowMod v0.6 for MC 1.4_01";
    }
}
