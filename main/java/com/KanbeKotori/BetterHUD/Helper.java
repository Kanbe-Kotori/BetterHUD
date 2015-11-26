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
import net.minecraft.entity.player.EntityPlayer;

public class Helper {
	
	public static EntityPlayer getPlayer() {
		return Minecraft.getMinecraft().thePlayer;
	}
	
	public static void setUnDraw(EntityPlayer player, boolean flag, String HUD) {
		player.getEntityData().setBoolean(HUD + "isUnDraw", flag);
	}
	
	public static boolean isUnDraw(EntityPlayer player, String HUD) {
		return player.getEntityData().getBoolean(HUD + "isUnDraw");
	}

	public static void setVerticle(EntityPlayer player, boolean flag, String HUD) {
		player.getEntityData().setBoolean(HUD + "isVerticle", flag);
	}
	
	public static boolean isVerticle(EntityPlayer player, String HUD) {
		return player.getEntityData().getBoolean(HUD + "isVerticle");
	}

	public static void setHUDPosition(EntityPlayer player, float posX, float posY, String HUD) {
		player.getEntityData().setFloat(HUD + "posX", posX);
		player.getEntityData().setFloat(HUD + "posY", posY);
	}
	
	public static float getHUDPositionX(EntityPlayer player, String HUD) {
		return player.getEntityData().getFloat(HUD + "posX");
	}
	
	public static float getHUDPositionY(EntityPlayer player, String HUD) {
		return player.getEntityData().getFloat(HUD + "posY");
	}
	
	public static boolean isNumeric(String str) {
		try {
			Float.valueOf(str);
		} catch(Exception e) {
			return false;
		}
		return true;
	}
	
	public static float toFloat(String str) {
		if (isNumeric(str))
			return Float.valueOf(str);
		return 0;
	}
	
	public static float to0_1(float num) {
		if (num > 0 && num < 1)
			return num;
		return 0;
	}
	
}
