package com.example.dev.domain;

import java.util.ArrayList;

public class Type
{
	public static ArrayList<String> types = new ArrayList<String>()
	{
		{
			add("pdf");
			add("xml");
		}
	};
	
	public static String file_verify(String type)
	{
		if(types.contains(type))
			return "VALID";
		return "INVALID";
	}
}
