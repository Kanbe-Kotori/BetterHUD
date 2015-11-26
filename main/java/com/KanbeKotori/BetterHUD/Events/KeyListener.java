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
	    if (openGUI.isPressed()) { // ��Ҵ�GUI��
	        Minecraft mc = Minecraft.getMinecraft();
	        mc.displayGuiScreen(new GUIBetterHUD(mc.currentScreen));
	    }
	}

}
