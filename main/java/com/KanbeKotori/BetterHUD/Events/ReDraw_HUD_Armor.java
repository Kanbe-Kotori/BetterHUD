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
	    		fontRenderer.drawString("", 0, 0, 0xFFFFFF);	//��ʼ��ײ�Ѽ�       
	    	}
	    	
	    	mc.renderEngine.bindTexture(Gui.icons);
		}
	}

}
