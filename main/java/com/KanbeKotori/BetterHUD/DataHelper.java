package com.KanbeKotori.BetterHUD;

import java.io.*;

import net.minecraft.entity.player.EntityPlayer;

public class DataHelper {
	
	public final static String filePath = "data.dat";
	public final static String filePath1 = "data1.dat";
	
	public static void init() throws IOException {
		try {
			RandomAccessFile rf = new RandomAccessFile(filePath, "r");
			rf.close();
		} catch(Exception e) {
			RandomAccessFile rf = new RandomAccessFile(filePath, "rw");
			for (int i = 0; i < 8; i++)
				rf.writeFloat(0);
			rf.close();
		}
		
		try {
			RandomAccessFile rf = new RandomAccessFile(filePath1, "r");
			rf.close();
		} catch(Exception e) {
			RandomAccessFile rf = new RandomAccessFile(filePath1, "rw");
			for (int i = 0; i < 8; i++)
				rf.writeInt(0);
			rf.close();
		}
	}
	
	public static void setUnDraw(String HUD, boolean flag) throws IOException {
		RandomAccessFile rf = new RandomAccessFile(filePath1, "rw");
		int pos = getPosInFile1(HUD);
		rf.seek(pos * 4);
		if (flag)
			rf.writeInt(1);
		else
			rf.writeInt(0);
		rf.close();
	}
	
	public static boolean isUnDraw(String HUD) throws IOException {
		RandomAccessFile rf = new RandomAccessFile(filePath1, "r");
		int pos = getPosInFile(HUD, 0);
		rf.seek(pos * 4);
		int toreturn = rf.readInt();
		rf.close();
		return toreturn == 1;
	}
	
	
	public static void setposX(String HUD, float toset) throws IOException {
		RandomAccessFile rf = new RandomAccessFile(filePath, "rw");
		int pos = getPosInFile(HUD, 0);
		rf.seek(pos * 4);
		rf.writeFloat(toset);
		rf.close();
	}
	
	public static void setposY(String HUD, float toset) throws IOException {
		RandomAccessFile rf = new RandomAccessFile(filePath, "rw");
		int pos = getPosInFile(HUD, 1);
		rf.seek(pos * 4);
		rf.writeFloat(toset);
		rf.close();
	}
	
	public static float getposX(String HUD) throws IOException {
		RandomAccessFile rf = new RandomAccessFile(filePath, "r");
		int pos = getPosInFile(HUD, 0);
		rf.seek(pos * 4);
		float toreturn = rf.readFloat();
		rf.close();
		return toreturn;
	}
	
	public static float getposY(String HUD) throws IOException {
		RandomAccessFile rf = new RandomAccessFile(filePath, "r");
		int pos = getPosInFile(HUD, 1);
		rf.seek(pos * 4);
		float toreturn = rf.readFloat();
		rf.close();
		return toreturn;
	}
	
	private static int getPosInFile(String HUD, int XorY) {
		if (HUD.equals("Air")) {
			return XorY;
		} else if (HUD.equals("Armor")) {
			return 2 + XorY;
		} else if (HUD.equals("Food")) {
			return 4 + XorY;
		} else if (HUD.equals("Health")) {
			return 6 + XorY;
		}
		return 0;
	}
	
	private static int getPosInFile1(String HUD) {
		if (HUD.equals("Air")) {
			return 0;
		} else if (HUD.equals("Armor")) {
			return 1;
		} else if (HUD.equals("Food")) {
			return 2;
		} else if (HUD.equals("Health")) {
			return 3;
		}
		return 0;
	}

}
