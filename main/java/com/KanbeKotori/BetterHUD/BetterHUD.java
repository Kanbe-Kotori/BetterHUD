/**
 * Copyright (c) Nulla Development Group, 2014-2015
 * 本作品版权由Nulla开发组所有。
 * Developed by Kanbe-Kotori.
 * 本作品由 Kanbe-Kotori开发。
 * This project is open-source, and it is distributed under
 * the terms of GNU General Public License. You can modify
 * and distribute freely as long as you follow the license.
 * 本项目是一个开源项目，且遵循GNU通用公共授权协议。
 * 在遵照该协议的情况下，您可以自由传播和修改。
 * http://www.gnu.org/licenses/gpl.html
 */
package com.KanbeKotori.BetterHUD;

import com.KanbeKotori.BetterHUD.Events.*;

import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;

@Mod(modid = BetterHUD.MODID, version = BetterHUD.VERSION)
public class BetterHUD {
    public static final String MODID = "BetterHUD";
    public static final String VERSION = "2.2";
    
    @EventHandler
    public void init(FMLInitializationEvent event) {
    	FMLCommonHandler.instance().bus().register(new KeyListener());
		ClientRegistry.registerKeyBinding(KeyListener.openGUI);
    	
    	MinecraftForge.EVENT_BUS.register(new ReDraw_HUD_Air());
    	MinecraftForge.EVENT_BUS.register(new ReDraw_HUD_Armor());
    	MinecraftForge.EVENT_BUS.register(new ReDraw_HUD_Food());
    	MinecraftForge.EVENT_BUS.register(new ReDraw_HUD_Health());
    }
    
}