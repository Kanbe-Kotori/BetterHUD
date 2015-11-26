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
	    if (openGUI.isPressed()) { // Íæ¼Ò´ò¿ªGUI¡£
	        Minecraft mc = Minecraft.getMinecraft();
	        mc.displayGuiScreen(new GUIBetterHUD(mc.currentScreen));
	    }
	}

}
