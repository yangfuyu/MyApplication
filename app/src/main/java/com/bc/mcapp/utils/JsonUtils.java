package com.bc.mcapp.utils;

import com.google.gson.Gson;

public class JsonUtils {
	static Gson gson;
	static{
		gson = new Gson();
	}
	
	public static <T> T parse(String jsonStr,Class<T> clazz){
		return gson.fromJson(jsonStr, clazz);
	}
	
}
