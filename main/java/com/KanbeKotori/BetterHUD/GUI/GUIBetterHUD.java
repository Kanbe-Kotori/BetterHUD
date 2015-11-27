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
package com.KanbeKotori.BetterHUD.GUI;

import org.lwjgl.input.Keyboard;

import com.KanbeKotori.BetterHUD.Helper;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;

public class GUIBetterHUD extends GuiScreen {
	
	private GuiScreen parentScreen;
	 
    public GUIBetterHUD(GuiScreen parent) {
         parentScreen = parent;
    }
    
    private GuiTextField AirPosInputX;
    private GuiTextField AirPosInputY;
    private GuiTextField ArmorPosInputX;
    private GuiTextField ArmorPosInputY;
    private GuiTextField FoodPosInputX;
    private GuiTextField FoodPosInputY;
    private GuiTextField HealthPosInputX;
    private GuiTextField HealthPosInputY;
    
    private GuiButton btnYes;
	private GuiButton btnExit;
    
    @Override
    protected void keyTyped(char par1, int par2) {
    	
    	if(AirPosInputX.textboxKeyTyped(par1, par2))
        	return;
        if(AirPosInputY.textboxKeyTyped(par1, par2))
        	return;
        if(ArmorPosInputX.textboxKeyTyped(par1, par2))
        	return;
        if(ArmorPosInputY.textboxKeyTyped(par1, par2))
        	return;
        if(FoodPosInputX.textboxKeyTyped(par1, par2))
        	return;
        if(FoodPosInputY.textboxKeyTyped(par1, par2))
        	return;
        if(HealthPosInputX.textboxKeyTyped(par1, par2))
        	return;
        if(HealthPosInputY.textboxKeyTyped(par1, par2))
        	return;
        
        super.keyTyped(par1, par2);
        
    }
    
    @Override
    protected void mouseClicked(int par1, int par2, int par3) {
    	
    	AirPosInputX.mouseClicked(par1, par2, par3);
    	AirPosInputY.mouseClicked(par1, par2, par3);
    	ArmorPosInputX.mouseClicked(par1, par2, par3);
    	ArmorPosInputY.mouseClicked(par1, par2, par3);
    	FoodPosInputX.mouseClicked(par1, par2, par3);
    	FoodPosInputY.mouseClicked(par1, par2, par3);
    	HealthPosInputX.mouseClicked(par1, par2, par3);
    	HealthPosInputY.mouseClicked(par1, par2, par3);

        super.mouseClicked(par1, par2, par3);
        
    }
     
    @Override
    public void onGuiClosed() {
        //Keyboard.enableRepeatEvents(false); //关闭键盘连续输入
    }
 
    public void initGui() {
    	
    	//Keyboard.enableRepeatEvents(true); //打开键盘连续输入
    	
    	buttonList.add(btnYes = new GuiButton(0, (int) (width * 0.3) - 40, (int) (height*0.9) - 10, 80, 20, "Yes"));
    	buttonList.add(btnExit = new GuiButton(2, (int) (width * 0.6) - 40, (int) (height*0.9) - 10, 80, 20, "Exit"));

    	AirPosInputX 	= new GuiTextField(fontRendererObj, (int) (width * 0.4) - 25, (int) (height * 0.3) - 10, 50, 20);
    	AirPosInputY 	= new GuiTextField(fontRendererObj, (int) (width * 0.6) - 25, (int) (height * 0.3) - 10, 50, 20);
    	ArmorPosInputX 	= new GuiTextField(fontRendererObj, (int) (width * 0.4) - 25, (int) (height * 0.45) - 10, 50, 20);
    	ArmorPosInputY 	= new GuiTextField(fontRendererObj, (int) (width * 0.6) - 25, (int) (height * 0.45) - 10, 50, 20);
    	FoodPosInputX 	= new GuiTextField(fontRendererObj, (int) (width * 0.4) - 25, (int) (height * 0.6) - 10, 50, 20);
    	FoodPosInputY 	= new GuiTextField(fontRendererObj, (int) (width * 0.6) - 25, (int) (height * 0.6) - 10, 50, 20);
    	HealthPosInputX = new GuiTextField(fontRendererObj, (int) (width * 0.4) - 25, (int) (height * 0.75) - 10, 50, 20);
    	HealthPosInputY = new GuiTextField(fontRendererObj, (int) (width * 0.6) - 25, (int) (height * 0.75) - 10, 50, 20);

    	AirPosInputX.setFocused(false);
    	AirPosInputX.setCanLoseFocus(true);
    	AirPosInputY.setFocused(false);
    	AirPosInputY.setCanLoseFocus(true);
    	ArmorPosInputX.setFocused(false);
    	ArmorPosInputX.setCanLoseFocus(true);
    	ArmorPosInputY.setFocused(false);
    	ArmorPosInputY.setCanLoseFocus(true);
    	FoodPosInputX.setFocused(false);
    	FoodPosInputX.setCanLoseFocus(true);
    	FoodPosInputY.setFocused(false);
    	FoodPosInputY.setCanLoseFocus(true);
    	HealthPosInputX.setFocused(false);
    	HealthPosInputX.setCanLoseFocus(true);
    	HealthPosInputY.setFocused(false);
    	HealthPosInputY.setCanLoseFocus(true);    
    	
    	AirPosInputX.setText(Helper.getHUDPositionX(Helper.getPlayer(), "Air") + "");
    	AirPosInputY.setText(Helper.getHUDPositionY(Helper.getPlayer(), "Air") + "");
    	ArmorPosInputX.setText(Helper.getHUDPositionX(Helper.getPlayer(), "Armor") + "");
    	ArmorPosInputY.setText(Helper.getHUDPositionY(Helper.getPlayer(), "Armor") + "");
    	FoodPosInputX.setText(Helper.getHUDPositionX(Helper.getPlayer(), "Food") + "");
    	FoodPosInputY.setText(Helper.getHUDPositionY(Helper.getPlayer(), "Food") + "");
    	HealthPosInputX.setText(Helper.getHUDPositionX(Helper.getPlayer(), "Health") + "");
    	HealthPosInputY.setText(Helper.getHUDPositionY(Helper.getPlayer(), "Health") + "");
    	
    }
 
    public void drawScreen(int par1, int par2, float par3) {
        drawDefaultBackground();
        drawCenteredString(fontRendererObj, "Please typing the position of HUDs(percentage) or choose whether draws it.", (int) (width * 0.5), (int) (height * 0.1) - 4, 0xFFFFFF);
        drawCenteredString(fontRendererObj, "X", (int) (width * 0.4), (int) (height * 0.2) - 4, 0xFFFFFF);
        drawCenteredString(fontRendererObj, "Y", (int) (width * 0.6), (int) (height * 0.2) - 4, 0xFFFFFF);
        fontRendererObj.drawStringWithShadow("Air", (int) (width * 0.2), (int) (height * 0.3) - 4, 0xFFFFFF);
        fontRendererObj.drawStringWithShadow("Armor", (int) (width * 0.2), (int) (height * 0.45) - 4, 0xFFFFFF);
        fontRendererObj.drawStringWithShadow("Food", (int) (width * 0.2), (int) (height * 0.6) - 4, 0xFFFFFF);
        fontRendererObj.drawStringWithShadow("Health", (int) (width * 0.2), (int) (height * 0.75) - 4, 0xFFFFFF);
////////////////////////////////////////////////////////////////////////////////////////
        super.drawScreen(par1,par2,par3); 
        AirPosInputX.drawTextBox();
    	AirPosInputY.drawTextBox();
    	ArmorPosInputX.drawTextBox();
    	ArmorPosInputY.drawTextBox();
    	FoodPosInputX.drawTextBox();
    	FoodPosInputY.drawTextBox();
    	HealthPosInputX.drawTextBox();
    	HealthPosInputY.drawTextBox();

	}
    
    @Override
	protected void actionPerformed(GuiButton button) {
		if (button == btnExit) {
	        mc.displayGuiScreen(parentScreen);
	    } else if (button == btnYes) {
	    	float AirX = Helper.to0_1(Helper.toFloat(AirPosInputX.getText()));
	    	float AirY = Helper.to0_1(Helper.toFloat(AirPosInputY.getText()));
	    	float ArmorX = Helper.to0_1(Helper.toFloat(ArmorPosInputX.getText()));
	    	float ArmorY = Helper.to0_1(Helper.toFloat(ArmorPosInputY.getText()));
	    	float FoodX = Helper.to0_1(Helper.toFloat(FoodPosInputX.getText()));
	    	float FoodY = Helper.to0_1(Helper.toFloat(FoodPosInputY.getText()));
	    	float HealthX = Helper.to0_1(Helper.toFloat(HealthPosInputX.getText()));
	    	float HealthY = Helper.to0_1(Helper.toFloat(HealthPosInputY.getText()));

	    	Helper.setHUDPosition(Helper.getPlayer(), AirX, AirY, "Air");
	    	Helper.setHUDPosition(Helper.getPlayer(), ArmorX, ArmorY, "Armor");
	    	Helper.setHUDPosition(Helper.getPlayer(), FoodX, FoodY, "Food");
	    	Helper.setHUDPosition(Helper.getPlayer(), HealthX, HealthY, "Health");
	    	
	        //mc.displayGuiScreen(parentScreen);
    	}
	}       

}
