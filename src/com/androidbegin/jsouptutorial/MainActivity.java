package com.androidbegin.jsouptutorial;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

public class MainActivity extends Activity {
	private ArrayList<Cake> mCakesArray;
	private CakeAdapter mCakeAdapter;
	private String[] mCakesNames;
	private String[] mUrlsNames;

	private ListView lvMain;
	private int currentID;

	String url = "xxxxxxxx";
	public String urltext = "xxxxxxxx";
	ProgressDialog mProgressDialog;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		fillCakesArray();
		mCakeAdapter = new CakeAdapter(this, mCakesArray);
		lvMain = (ListView) findViewById(R.id.lvMain);
		lvMain.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
		lvMain.setAdapter(mCakeAdapter);

		mUrlsNames = this.getResources().getStringArray(R.array.namesUrl);
		new Title().execute();
	}

	private void fillCakesArray() {
		mCakesArray = new ArrayList<Cake>();
		// Time today = new Time(Time.getCurrentTimezone());
		mCakesNames = this.getResources().getStringArray(R.array.namesCake);
		for (int i = 0; i < mCakesNames.length; i++) {
			mCakesArray.add(new Cake(mCakesNames[i], "", R.drawable.questionmark));
		}
	}

	// Title AsyncTask
	private class Title extends AsyncTask<Void, Void, Void> {
		String title;

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
		}

		private void showTime(int ID, String text) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
			try {
				Date d = sdf.parse(urltext);
				Date now = new Date();

				long diff = (now.getTime() - d.getTime());
				if (diff < 0)
					diff = 1;
				long timediff = diff / 60000;
				String ss = String.valueOf(timediff);
				sdf.applyPattern("dd-MM-yyyy  HH:mm");
				mCakesArray.get(ID).setCakeTime(
						sdf.format(d) + "  (Delay " + ss + " Minutes)");
				if (timediff > 30) {
					mCakesArray.get(ID).setCakeImage(R.drawable.questionmark);
				}
				if (timediff <= 30) {
					mCakesArray.get(ID).setCakeImage(R.drawable.checkmark);
				}
				
			} catch (ParseException ex) {

			}
		}

		private void updateListView(int ID) {

			Document doc;
			try {
				doc = Jsoup.connect(mUrlsNames[ID]).get();
				title = doc.text();
				urltext = title.substring(6, 18);
				showTime(ID, urltext);

			} catch (IOException e) {

				e.printStackTrace();
			}
		}

		@Override
		protected Void doInBackground(Void... params) {
			// Connect to the web site
			for (int i = 0; i < 13; i++) {
				updateListView(i);
			}
			return null;
		}

		@Override
		protected void onPostExecute(Void result) {
			mCakeAdapter.notifyDataSetChanged();
			Log.d("currentID  ", String.valueOf(currentID));
		}
	}

}