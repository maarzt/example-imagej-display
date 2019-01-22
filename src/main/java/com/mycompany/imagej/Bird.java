package com.mycompany.imagej;

public class Bird
{
	private String kind;

	private String name = "Coco";

	public Bird(String kind)
	{
		this.kind = kind;
	}

	public void setName(String name) { this.name = name; }

	public String getName() { return this.name; }

	@Override
	public String toString()
	{
		return "Bird (" + kind + ")";
	}
}
