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

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.*;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.Blocks;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

@Mod(modid = BetterHUD.MODID, version = BetterHUD.VERSION)
public class BetterHUD {
    public static final String MODID = "BetterHUD";
    public static final String VERSION = "1.0";
    
    @EventHandler
    public void init(FMLInitializationEvent event) {
    	MinecraftForge.EVENT_BUS.register(this);
    }
    
    @SubscribeEvent
	public void ReDrawHUD(RenderGameOverlayEvent.Pre event) {
		if(event.type == ElementType.HEALTH) {
	    	event.setCanceled(true);
	    	Minecraft mc = Minecraft.getMinecraft();
	        int width = event.resolution.getScaledWidth();
	        int height = event.resolution.getScaledHeight();
	        int health = (int) Minecraft.getMinecraft().thePlayer.getHealth();
	        int maxhealth = (int) Minecraft.getMinecraft().thePlayer.getEntityAttribute(SharedMonsterAttributes.maxHealth).getAttributeValue();
	        
	        int length = 90 * health / maxhealth;
	        Gui.drawRect(width / 2 - 91, height - 39, width / 2 - 1, height - 30, 0x7F000000);
	        Gui.drawRect(width / 2 - 91, height - 39, width / 2 - 91 + length, height - 30, 0x7F00FF00);
	        
	        String hp = "Health: " + health + " / " + maxhealth;
	        FontRenderer fontRenderer = mc.fontRenderer;
	        int color = 0xFFFFFF;
	        if (health != maxhealth) {color = 0xFF0000;}
	        fontRenderer.drawStringWithShadow(hp, width / 2 - 91, height - 39, color);
	        fontRenderer.drawString("", 0, 0, 0xFFFFFF);	//初始化撞钛鸡       
	        mc.renderEngine.bindTexture(Gui.icons);
	    } else if(event.type == ElementType.ARMOR) {
	    	event.setCanceled(true);
	    	Minecraft mc = Minecraft.getMinecraft();
	    	int width = event.resolution.getScaledWidth();
	    	int height = event.resolution.getScaledHeight() - 10;
	    	int armor = ForgeHooks.getTotalArmorValue(Minecraft.getMinecraft().thePlayer);
	    	int maxarmor = 20;
    
	    	if (armor != 0) {   
	    		int length = 90 * armor / maxarmor;
	    		Gui.drawRect(width / 2 - 91, height - 39, width / 2 - 1, height - 30, 0x7F000000);
	    		Gui.drawRect(width / 2 - 91, height - 39, width / 2 - 91 + length, height - 30, 0x7FAFAFAF);

	    		String ap = "Armor: " + armor + " / " + maxarmor;
	    		FontRenderer fontRenderer = mc.fontRenderer;
	    		fontRenderer.drawStringWithShadow(ap, width / 2 - 91, height - 39, 0xFFFFFF);
	    		fontRenderer.drawString("", 0, 0, 0xFFFFFF);	//初始化撞钛鸡       
	    	}
	    	
	    	mc.renderEngine.bindTexture(Gui.icons);
	    } else if(event.type == ElementType.FOOD) {
	    	event.setCanceled(true);
	    	Minecraft mc = Minecraft.getMinecraft();
	    	int width = event.resolution.getScaledWidth();
	    	int height = event.resolution.getScaledHeight();
	    	int hunger = Minecraft.getMinecraft().thePlayer.getFoodStats().getFoodLevel();
	    	int maxhunger = 20;
     
	    	int length = 90 * hunger / maxhunger;
	    	Gui.drawRect(width / 2, height - 39, width / 2 + 90, height - 30, 0x7F000000);
	    	Gui.drawRect(width / 2, height - 39, width / 2 + length, height - 30, 0x7FFF0000);

	    	String hup = "Hunger: " + hunger + " / " + maxhunger;
	    	FontRenderer fontRenderer = mc.fontRenderer;
	    	fontRenderer.drawStringWithShadow(hup, width / 2, height - 39, 0xFFFFFF);
	    	fontRenderer.drawString("", 0, 0, 0xFFFFFF);	//初始化撞钛鸡    
	    	
	    	mc.renderEngine.bindTexture(Gui.icons);
	    } else if(event.type == ElementType.AIR) {
	    	event.setCanceled(true);
	    	Minecraft mc = Minecraft.getMinecraft();
	    	int width = event.resolution.getScaledWidth();
	    	int height = event.resolution.getScaledHeight() - 10;
	    	int air = Minecraft.getMinecraft().thePlayer.getAir();
	    	int maxair = 300;
     
	    	if (air < 300) {
	    		int length = 90 * air / maxair;
	    		Gui.drawRect(width / 2, height - 39, width / 2 + 90, height - 30, 0x7F000000);
	    		Gui.drawRect(width / 2, height - 39, width / 2 + length, height - 30, 0x7F0000FF);

	    		String hup = "Air: " + air + " / " + maxair;
	    		FontRenderer fontRenderer = mc.fontRenderer;
	    		fontRenderer.drawStringWithShadow(hup, width / 2, height - 39, 0xFFFFFF);
	    		fontRenderer.drawString("", 0, 0, 0xFFFFFF);	//初始化撞钛鸡    
	    	}
	    	
	    	mc.renderEngine.bindTexture(Gui.icons);
	    }
		
	}
}