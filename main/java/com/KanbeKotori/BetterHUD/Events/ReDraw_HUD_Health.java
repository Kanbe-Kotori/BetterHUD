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
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class ReDraw_HUD_Health {
	
	@SubscribeEvent
	public void ReDraw_Health(RenderGameOverlayEvent.Pre event) {
		if(event.type == ElementType.HEALTH) {
	    	event.setCanceled(true);
	    	Minecraft mc = Minecraft.getMinecraft();
	        int width = event.resolution.getScaledWidth();
	        int height = event.resolution.getScaledHeight();
	        int health = (int) Minecraft.getMinecraft().thePlayer.getHealth();
	        int maxhealth = (int) Minecraft.getMinecraft().thePlayer.getEntityAttribute(SharedMonsterAttributes.maxHealth).getAttributeValue();
	        
	        int goalwidth = width / 2 - 91;
	        int goalheight = height - 39;
	        
	        if (Helper.getHUDPositionX(Helper.getPlayer(), "Health") != 0) {
	        	goalwidth = (int) (width * Helper.getHUDPositionX(Helper.getPlayer(), "Health")) - 45;
	        }
	        
	        if (Helper.getHUDPositionY(Helper.getPlayer(), "Health") != 0) {
	        	goalheight = (int) (height * Helper.getHUDPositionY(Helper.getPlayer(), "Health"));
	        }
	           
	        int length = 90 * health / maxhealth;
	        Gui.drawRect(goalwidth, goalheight, goalwidth + 90, goalheight + 9, 0x7F000000);
	        Gui.drawRect(goalwidth, goalheight, goalwidth + length, goalheight + 9, 0x7F00FF00);
	        
	        String hp = "Health: " + health + " / " + maxhealth;
	        FontRenderer fontRenderer = mc.fontRenderer;
	        int color = 0xFFFFFF;
	        if (health <= maxhealth * 0.25) {color = 0xFF0000;}
	        else if (health <= maxhealth * 0.5) {color = 0xFFFF00;}
	        else if (health > maxhealth) {color = 0x00FF00;}
	        fontRenderer.drawStringWithShadow(hp, goalwidth, goalheight, color);
	        fontRenderer.drawString("", 0, 0, 0xFFFFFF);	//初始化撞钛鸡       
	        mc.renderEngine.bindTexture(Gui.icons);
	    }
	}

}
