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

import org.lwjgl.input.Keyboard;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;

import com.KanbeKotori.BetterHUD.BetterHUD;
import com.KanbeKotori.BetterHUD.GUI.GUIBetterHUD;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent.KeyInputEvent;

public class KeyListener {
	
	public static final KeyBinding openGUI = new KeyBinding("Open GUI", Keyboard.KEY_R, BetterHUD.MODID);

	@SubscribeEvent
	public void keyListener(KeyInputEvent event) {
	    if (openGUI.isPressed()) { // 玩家打开GUI。
	        Minecraft mc = Minecraft.getMinecraft();
	        mc.displayGuiScreen(new GUIBetterHUD(mc.currentScreen));
	    }
	}

}
