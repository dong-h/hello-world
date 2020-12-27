package com.dh.learn.entity;

/**
 * person对象类
 * @author dongh
 * @since 2020年12月27日
 */
public class Person {
	
	private String id;
	
	private String name;
	
	private String gender;
	
	private int age;
	
	/**
	 * @param id
	 * @param name
	 * @param gender
	 * @param age
	 */
	public Person(String id, String name, String gender, int age) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.age = age;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "{ " + "id:"+this.id+ ", name:"+this.name+ ", gender:"+this.gender+ ", age:"+this.age+" }";
	}
}
