/**
 * Copyright (c) Nulla Development Group, 2014-2015
 * ����Ʒ��Ȩ��Nulla���������С�
 * Developed by Kanbe-Kotori.
 * ����Ʒ�� Kanbe-Kotori������
 * This project is open-source, and it is distributed under
 * the terms of GNU General Public License. You can modify
 * and distribute freely as long as you follow the license.
 * ����Ŀ��һ����Դ��Ŀ������ѭGNUͨ�ù�����ȨЭ�顣
 * �����ո�Э�������£����������ɴ������޸ġ�
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