/**
 * 
 * This class describes cake.
 */
package com.androidbegin.jsouptutorial;


/**
 * @author Margaritka
 * 
 */
public class Cake {
	private String mCakeName;
	private String mCakeTime;

	private int mCakeImage;

	/**
	 * * @param mCakeName * @param mCakeImage
	 * */
	public Cake(String mCakeName, int mCakeImage) {
		super();
		this.mCakeName = mCakeName;
		this.mCakeImage = mCakeImage;
	}

	public Cake(String mCakeName, String mCakeTime, int mCakeImage) {
		super();
		this.mCakeName = mCakeName;
		this.mCakeImage = mCakeImage;
		this.mCakeTime = mCakeTime;
	}

	public String getmCakeName() {
		return mCakeName;
	}

	public void setmCakeName(String mCakeName) {
		this.mCakeName = mCakeName;
	}

	public int getCakeImage() {
		return mCakeImage;
	}

	public void setCakeImage(int mCakeImage) {
		this.mCakeImage = mCakeImage;
	}

	public String getCakeCalendar() {
		return mCakeTime;
	}

	public String getCakeTimeString() {
 
		return mCakeTime;
	}

	public void setCakeTime(String mCakeTime) {
		this.mCakeTime = mCakeTime;
	}
}
