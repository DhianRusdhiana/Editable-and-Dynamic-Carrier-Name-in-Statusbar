package com.dhian.systemui;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.*;
import android.util.AttributeSet;
import android.widget.TextView;
import android.text.TextUtils;
import android.content.*;
import android.preference.*;
import android.view.animation.Animation;
import android.view.animation.AlphaAnimation;



/*
 * Failed to analyse overrides
 */
public class CarrierName4
extends TextView {


	public static boolean getBooleanFromkey(String key,Context v) {
		SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(v);
		return preferences.getBoolean(key, true);
	}
	public static int getIntFromkey(Context c,String key) {
		SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(c);
		return preferences.getInt(key , 0);
	}
	public static float getFloatFromkey(Context v,String key) {
		SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(v);
		return preferences.getFloat(key , 0);
	}
	public static SharedPreferences sp;
	public static String font;


	StringBuilder builder = new StringBuilder();


    public CarrierName4(Context context) {
        super(context);
		this.setSelected(true);
		this.setSingleLine(true);
		this.setEllipsize(TextUtils.TruncateAt.MARQUEE);
		this.setMarqueeRepeatLimit(10000000);
		this.setHorizontallyScrolling(true);
		if(!getBooleanFromkey("defaultfont4",context)){
			sp = PreferenceManager.getDefaultSharedPreferences(getContext());
			font = sp.getString("carrier_name_font_4", "fonts/DroidSans.ttf");
			this.setTypeface(Typeface.createFromAsset((AssetManager)this.getContext().getAssets(), font));

		}else{
			this.setTypeface(Typeface.createFromAsset((AssetManager)this.getContext().getAssets(), "fonts/DroidSans.ttf"));
		}
		if(!getBooleanFromkey("defaultcolor4",context)){
			this.setTextColor(getIntFromkey(context,"carrier_name_color_4"));

		}else{
			this.setTextColor(Color.WHITE);
		}
		if(!getBooleanFromkey("defaultsize4",context)){
			this.setTextSize(getFloatFromkey(context,"carrier_name_size_4"));
		}else{
			this.setTextSize(16);
		}


		sp = PreferenceManager.getDefaultSharedPreferences(getContext());

		builder.append(sp.getString("set_carrier_name_4", "Carrier Name 4"));
		this.setText(builder.toString());	

	}



    public CarrierName4(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
		this.setSelected(true);
		this.setSingleLine(true);
		this.setEllipsize(TextUtils.TruncateAt.MARQUEE);
		this.setMarqueeRepeatLimit(10000000);
		this.setHorizontallyScrolling(true);
        if(!getBooleanFromkey("defaultfont4",context)){
			sp = PreferenceManager.getDefaultSharedPreferences(getContext());
			font = sp.getString("carrier_name_font_4", "fonts/DroidSans.ttf");
			this.setTypeface(Typeface.createFromAsset((AssetManager)this.getContext().getAssets(), font));

		}else{
			this.setTypeface(Typeface.createFromAsset((AssetManager)this.getContext().getAssets(), "fonts/DroidSans.ttf"));
		}
		if(!getBooleanFromkey("defaultcolor4",context)){
			this.setTextColor(getIntFromkey(context,"carrier_name_color_4"));

		}else{
			this.setTextColor(Color.WHITE);
		}
		if(!getBooleanFromkey("defaultsize4",context)){
			this.setTextSize(getFloatFromkey(context,"carrier_name_size_4"));
		}else{
			this.setTextSize(16);
		}


		sp = PreferenceManager.getDefaultSharedPreferences(getContext());

		builder.append(sp.getString("set_carrier_name_4", "Carrier Name 4"));
		this.setText(builder.toString());	

	}

    public CarrierName4(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
		this.setSelected(true);
		this.setSingleLine(true);
		this.setEllipsize(TextUtils.TruncateAt.MARQUEE);
		this.setMarqueeRepeatLimit(10000000);
		this.setHorizontallyScrolling(true);
        if(!getBooleanFromkey("defaultfont4",context)){
			sp = PreferenceManager.getDefaultSharedPreferences(getContext());
			font = sp.getString("carrier_name_font_4", "fonts/DroidSans.ttf");
			this.setTypeface(Typeface.createFromAsset((AssetManager)this.getContext().getAssets(), font));

		}else{
			this.setTypeface(Typeface.createFromAsset((AssetManager)this.getContext().getAssets(), "fonts/DroidSans.ttf"));
		}
		if(!getBooleanFromkey("defaultcolor4",context)){
			this.setTextColor(getIntFromkey(context,"carrier_name_color_4"));

		}else{
			this.setTextColor(Color.WHITE);
		}
		if(!getBooleanFromkey("defaultsize4",context)){
			this.setTextSize(getFloatFromkey(context,"carrier_name_size_4"));
		}else{
			this.setTextSize(16);
		}


		sp = PreferenceManager.getDefaultSharedPreferences(getContext());

		builder.append(sp.getString("set_carrier_name_4", "Carrier Name 4"));
		this.setText(builder.toString());	

	}



}

