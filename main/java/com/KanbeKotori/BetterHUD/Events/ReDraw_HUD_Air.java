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
package com.KanbeKotori.BetterHUD.Events;

import com.KanbeKotori.BetterHUD.Helper;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.*;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class ReDraw_HUD_Air {
	
	@SubscribeEvent
	public void ReDraw_Air(RenderGameOverlayEvent.Pre event) {
		if(event.type == ElementType.AIR) {
	    	event.setCanceled(true);
	    	Minecraft mc = Minecraft.getMinecraft();
	    	int width = event.resolution.getScaledWidth();
	    	int height = event.resolution.getScaledHeight();
	    	int air = Minecraft.getMinecraft().thePlayer.getAir();
	    	int maxair = 300;
     
	    	if (air < 300) {
	    		int goalwidth = width / 2;
		        int goalheight = height - 49;
		        
		        if (Helper.getHUDPositionX(Helper.getPlayer(), "Air") != 0) {
		        	goalwidth = (int) (width * Helper.getHUDPositionX(Helper.getPlayer(), "Air")) - 45;
		        }
		        
		        if (Helper.getHUDPositionY(Helper.getPlayer(), "Air") != 0) {
		        	goalheight = (int) (height * Helper.getHUDPositionY(Helper.getPlayer(), "Air"));
		        }
		        
	    		int length = 90 * air / maxair;
	    		Gui.drawRect(goalwidth, goalheight, goalwidth + 90, goalheight + 9, 0x7F000000);
	    		Gui.drawRect(goalwidth, goalheight, goalwidth + length, goalheight + 9, 0x7F0000FF);

	    		String hup = "Air: " + air + " / " + maxair;
	    		FontRenderer fontRenderer = mc.fontRenderer;
	    		fontRenderer.drawStringWithShadow(hup, goalwidth, goalheight, 0xFFFFFF);
	    		fontRenderer.drawString("", 0, 0, 0xFFFFFF);	//初始化撞钛鸡    
	    	}
	    	
	    	mc.renderEngine.bindTexture(Gui.icons);
	    }
		
	}

}
