/**
 * 
 * A concrete BaseAdapter which returns view with cake's name and cake's picture for TextView.
 */
package com.androidbegin.jsouptutorial;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * @author Margaritka
 *
 */
public class CakeAdapter extends BaseAdapter {
    @SuppressWarnings("unused")
	private Context mContext;
    private LayoutInflater mInflater;
    private ArrayList<Cake> mCakesArray;
    
    /**
     * * @param mInflater
     * * @param mCakesArray
     * */
    public CakeAdapter(Context mContext, ArrayList<Cake> mCakesArray) {
        super();
        this.mContext = mContext;
        this.mInflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.mCakesArray = mCakesArray;
    }

    @Override
    public int getCount() {
        return mCakesArray.size();
    }

	@Override
    public Object getItem(int position) {
        return mCakesArray.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = mInflater.inflate(R.layout.cake_item, parent, false);
        }

        Cake cake = (Cake)getItem(position);

        ((TextView)view.findViewById(R.id.tvCakeName)).setText(cake.getmCakeName());
        ((TextView)view.findViewById(R.id.cur)).setText(cake.getCakeTimeString());
        ((ImageView)view.findViewById(R.id.ivCakeImage)).setImageResource(cake.getCakeImage());
        
        view.setTag(position);

        return view;
    }    

}
