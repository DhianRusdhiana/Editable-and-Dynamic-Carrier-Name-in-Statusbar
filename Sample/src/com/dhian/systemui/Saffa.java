package com.dhian.systemui;

import android.preference.*;
import android.preference.Preference.*;
import android.os.*;
import android.content.*;
import android.net.*;
import android.widget.*;
import android.view.View;
import android.app.*;
import android.os.Process;
import java.net.*;
import android.app.*;
import android.app.ActivityManager.*;
import android.content.*;
import android.content.SharedPreferences.*;
import android.content.pm.*;
import android.content.pm.PackageManager.*;
import android.net.*;
import android.os.*;
import android.preference.*;
import android.preference.Preference.*;
import android.widget.*;
import java.io.*;
import java.util.*;
import android.app.TimePickerDialog.*;
import android.provider.MediaStore;

public class Saffa extends PreferenceActivity implements OnSharedPreferenceChangeListener
{
	private Uri mImageCaptureUri;
	private ImageView mImageView;

	private static final int PICK_FROM_CAMERA = 1;
	private static final int CROP_FROM_CAMERA = 2;
	private static final int PICK_FROM_FILE = 3;
	
	private PackageManager manager;
	public static boolean getBooleanFromkey(String key,Context v) {
		SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(v);
		return preferences.getBoolean(key, true);
	}
	
	
	public static SharedPreferences settings;
	
	
	private android.preference.Preference a;
	private android.preference.Preference b;	
	private android.preference.Preference c;
	
	private android.preference.Preference aa;
	private android.preference.Preference bb;	
	private android.preference.Preference cc;

	private android.preference.Preference aaa;
	private android.preference.Preference bbb;	
	private android.preference.Preference ccc;

	private android.preference.Preference aaaa;
	private android.preference.Preference bbbb;	
	private android.preference.Preference cccc;



		
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(getID("navisha","xml"));
        
		settings = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
    	

		a = findPreference("carrier_name_color");
	    b = findPreference("carrier_name_size");
	    c = findPreference("carrier_name_font");
		
		aa = findPreference("carrier_name_color_2");
	    bb = findPreference("carrier_name_size_2");
	    cc = findPreference("carrier_name_font_2");
	
		aaa = findPreference("carrier_name_color_3");
	    bbb = findPreference("carrier_name_size_3");
	    ccc = findPreference("carrier_name_font_3");

		aaaa = findPreference("carrier_name_color_4");
	    bbbb = findPreference("carrier_name_size_4");
	    cccc = findPreference("carrier_name_font_4");
		
	
		
	this.findPreference("restart_systemui2")
	.setOnPreferenceClickListener(new OnPreferenceClickListener() {
	public boolean onPreferenceClick(Preference preference) {
		restarttWithConfirm();
		return false;
	}
	});
	
		this.findPreference("restart_systemui")
			.setOnPreferenceClickListener(new OnPreferenceClickListener() {
				public boolean onPreferenceClick(Preference preference) {
					restarttWithConfirm();
					return false;
				}
			});
			
		this.findPreference("restart_systemui3")
			.setOnPreferenceClickListener(new OnPreferenceClickListener() {
				public boolean onPreferenceClick(Preference preference) {
					restarttWithConfirm();
					return false;
				}
			});
			
		this.findPreference("restart_systemui4")
			.setOnPreferenceClickListener(new OnPreferenceClickListener() {
				public boolean onPreferenceClick(Preference preference) {
					restarttWithConfirm();
					return false;
				}
			});
			

	}

    private void restarttWithConfirm() {

		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setMessage("Are you sure to restart SystemUI")
			.setCancelable(false)
			.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int id) {
					Restart();
				}
			})
			.setNegativeButton("No", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int id) {
					dialog.cancel();
				}
			}).create();
		builder.show();
	}
	
	
	public static void Restart(){
		Process.killProcess(Process.myPid());
	}

	public int getID(String name, String Type) {
		return getBaseContext().getResources().getIdentifier(name, Type, getBaseContext().getPackageName());
	}
		
	
	@Override
	public void onSharedPreferenceChanged(SharedPreferences sharePreferences, String key){
		
		setEnableColor();
		setEnableSize();
		setEnableFont();
		
		setEnableColor2();
		setEnableSize2();
		setEnableFont2();
		
		setEnableColor3();
		setEnableSize3();
		setEnableFont3();

		setEnableColor4();
		setEnableSize4();
		setEnableFont4();
		}	
			

		@Override
		protected void onResume()
		{
			// TODO: Implement this method
			super.onResume();
			 getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
			
			setEnableColor();
			setEnableSize();
			setEnableFont();
			
			setEnableColor2();
			setEnableSize2();
			setEnableFont2();
			
			setEnableColor3();
			setEnableSize3();
			setEnableFont3();

			setEnableColor4();
			setEnableSize4();
			setEnableFont4();
		}

		@Override
		protected void onDestroy()
		{
			// TODO: Implement this method
			super.onDestroy();
			 getPreferenceScreen().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
			
			setEnableColor();
			setEnableSize();
			setEnableFont();
			
			setEnableColor2();
			setEnableSize2();
			setEnableFont2();
			
			setEnableColor3();
			setEnableSize3();
			setEnableFont3();

			setEnableColor4();
			setEnableSize4();
			setEnableFont4();
	
		}

		
	public void setEnableColor(){
		if(!getBooleanFromkey("defaultcolor",getBaseContext())) {
			a.setEnabled(true);			
		}else{
			a.setEnabled(false);
			}
		}
	public void setEnableSize(){
		if(!getBooleanFromkey("defaultsize",getBaseContext())) {
			b.setEnabled(true);	
		}else{
			b.setEnabled(false);
			}
		}
	public void setEnableFont(){
		if(!getBooleanFromkey("defaultfont",getBaseContext())){
			c.setEnabled(true);
		}else{
			c.setEnabled(false);
		    }
			}
	
			
			
			
			
	public void setEnableColor2(){
		if(!getBooleanFromkey("defaultcolor2",getBaseContext())) {
			aa.setEnabled(true);			
		}else{
			aa.setEnabled(false);
		}
	}
	public void setEnableSize2(){
		if(!getBooleanFromkey("defaultsize2",getBaseContext())) {
			bb.setEnabled(true);	
		}else{
			bb.setEnabled(false);
		}
	}
	public void setEnableFont2(){
		if(!getBooleanFromkey("defaultfont2",getBaseContext())){
			cc.setEnabled(true);
		}else{
			cc.setEnabled(false);
		}
	}
	
	public void setEnableColor3(){
		if(!getBooleanFromkey("defaultcolor3",getBaseContext())) {
			aaa.setEnabled(true);			
		}else{
			aaa.setEnabled(false);
		}
	}
	public void setEnableSize3(){
		if(!getBooleanFromkey("defaultsize3",getBaseContext())) {
			bbb.setEnabled(true);	
		}else{
			bbb.setEnabled(false);
		}
	}
	public void setEnableFont3(){
		if(!getBooleanFromkey("defaultfont3",getBaseContext())){
			ccc.setEnabled(true);
		}else{
			ccc.setEnabled(false);
		}
	}
	
	
	
	
	public void setEnableColor4(){
		if(!getBooleanFromkey("defaultcolor4",getBaseContext())) {
			aaaa.setEnabled(true);			
		}else{
			aaaa.setEnabled(false);
		}
	}
	public void setEnableSize4(){
		if(!getBooleanFromkey("defaultsize4",getBaseContext())) {
			bbbb.setEnabled(true);	
		}else{
			bbbb.setEnabled(false);
		}
	}
	public void setEnableFont4(){
		if(!getBooleanFromkey("defaultfont4",getBaseContext())){
			cccc.setEnabled(true);
		}else{
			cccc.setEnabled(false);
		}
	}
	}
