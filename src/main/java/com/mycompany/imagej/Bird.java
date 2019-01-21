package com.mycompany.imagej;

public class Bird
{
	private String kind;

	public Bird(String kind)
	{
		this.kind = kind;
	}

	@Override
	public String toString()
	{
		return "Bird (" + kind + ")";
	}
}
