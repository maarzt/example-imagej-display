package com.mycompany.imagej;

/**
 * Small example class, that represents a bird.
 * The bird has a name and a kind.
 */
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

	public String getKind()
	{
		return kind;
	}

	@Override
	public String toString()
	{
		return "Bird " + name + " (" + kind + ")";
	}
}
