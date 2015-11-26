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
import net.minecraftforge.common.ForgeHooks;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class ReDraw_HUD_Armor {
	
	@SubscribeEvent
	public void ReDraw_Armor(RenderGameOverlayEvent.Pre event) {
		if(event.type == ElementType.ARMOR) {
	    	event.setCanceled(true);
	    	Minecraft mc = Minecraft.getMinecraft();
	    	int width = event.resolution.getScaledWidth();
	    	int height = event.resolution.getScaledHeight();
	    	int armor = ForgeHooks.getTotalArmorValue(Minecraft.getMinecraft().thePlayer);
	    	int maxarmor = 20;
    
	    	if (armor != 0) {  
	    		int goalwidth = width / 2 - 91;
		        int goalheight = height - 49;
		        
		        if (Helper.getHUDPositionX(Helper.getPlayer(), "Armor") != 0) {
		        	goalwidth = (int) (width * Helper.getHUDPositionX(Helper.getPlayer(), "Armor")) - 45;
		        }
		        
		        if (Helper.getHUDPositionY(Helper.getPlayer(), "Armor") != 0) {
		        	goalheight = (int) (height * Helper.getHUDPositionY(Helper.getPlayer(), "Armor"));
		        }
	    		
	    		int length = 90 * armor / maxarmor;
	    		Gui.drawRect(goalwidth, goalheight, goalwidth + 90, goalheight + 9, 0x7F000000);
	    		Gui.drawRect(goalwidth, goalheight, goalwidth + length, goalheight + 9, 0x7FAFAFAF);

	    		String ap = "Armor: " + armor + " / " + maxarmor;
	    		FontRenderer fontRenderer = mc.fontRenderer;
	    		fontRenderer.drawStringWithShadow(ap, goalwidth, goalheight, 0xFFFFFF);
	    		fontRenderer.drawString("", 0, 0, 0xFFFFFF);	//初始化撞钛鸡       
	    	}
	    	
	    	mc.renderEngine.bindTexture(Gui.icons);
		}
	}

}
