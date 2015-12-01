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

public class ReDraw_HUD_Food {
	
	@SubscribeEvent
	public void ReDraw_Food(RenderGameOverlayEvent.Pre event) {
		if(event.type == ElementType.FOOD) {
			if (Helper.isUnDraw(Helper.getPlayer(), "Food")) {
				return ;
			}
			
	    	event.setCanceled(true);
	    	Minecraft mc = Minecraft.getMinecraft();
	    	int width = event.resolution.getScaledWidth();
	    	int height = event.resolution.getScaledHeight();
	    	int hunger = Minecraft.getMinecraft().thePlayer.getFoodStats().getFoodLevel();
	    	int maxhunger = 20;
	    	
	    	int goalwidth = width / 2;
	        int goalheight = height - 39;
	        
	        if (Helper.getHUDPositionX(Helper.getPlayer(), "Food") != 0) {
	        	goalwidth = (int) (width * Helper.getHUDPositionX(Helper.getPlayer(), "Food")) - 45;
	        }
	        
	        if (Helper.getHUDPositionY(Helper.getPlayer(), "Food") != 0) {
	        	goalheight = (int) (height * Helper.getHUDPositionY(Helper.getPlayer(), "Food"));
	        }
     
	    	int length = 90 * hunger / maxhunger;
	    	Gui.drawRect(goalwidth, goalheight, goalwidth + 90, goalheight + 9, 0x7F000000);
	    	Gui.drawRect(goalwidth, goalheight, goalwidth + length, goalheight + 9, 0x7F7F3F00);

	    	String hup = "Hunger: " + hunger + " / " + maxhunger;
	    	FontRenderer fontRenderer = mc.fontRenderer;
	    	int color = 0xFFFFFF;
	        if (hunger <= maxhunger * 0.25) {color = 0xFF0000;}
	        else if (hunger <= maxhunger * 0.5) {color = 0xFFFF00;}
	        else if (hunger > maxhunger) {color = 0x00FF00;}
	    	fontRenderer.drawStringWithShadow(hup, goalwidth, goalheight, color);
	    	fontRenderer.drawString("", 0, 0, 0xFFFFFF);	//初始化撞钛鸡    
	    	
	    	mc.renderEngine.bindTexture(Gui.icons);
	    }
	}

}
