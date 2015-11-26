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
	    		fontRenderer.drawString("", 0, 0, 0xFFFFFF);	//��ʼ��ײ�Ѽ�    
	    	}
	    	
	    	mc.renderEngine.bindTexture(Gui.icons);
	    }
		
	}

}
