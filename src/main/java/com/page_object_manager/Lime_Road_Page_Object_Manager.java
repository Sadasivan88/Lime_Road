package com.page_object_manager;

import com.baseclass.Lime_Road_Base_Class;
import com.baseclass.NykkaBase;
import com.page_object_model.Lime_Road_Pom_Home_page;

public class Lime_Road_Page_Object_Manager extends NykkaBase{
	
	private Lime_Road_Pom_Home_page pom;
	private static Lime_Road_Page_Object_Manager poma;
	
	public Lime_Road_Pom_Home_page storedElements() {
		if(pom==null) {
			pom = new Lime_Road_Pom_Home_page();
		}
		return pom;
	}
	public static Lime_Road_Page_Object_Manager pageObjectManager() {
		if(poma == null) {
			poma = new Lime_Road_Page_Object_Manager();
		}
		return poma;
	}
	
}

