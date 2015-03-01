package com.dhian.systemui;

import android.content.Context;
import android.content.res.TypedArray;
import android.preference.Preference;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
public class SeekBarPreferences extends Preference implements OnSeekBarChangeListener {
    private static final String TAG = SeekBarPreferences.class.getSimpleName();
    private static final float DEFAULT_VALUE = 50;
    private static final String APP_NS = "http://code.google.com/p/javadrone";
    private float maxValue      = 100;
    private float minValue      = 0;
    private float interval      = 1;
    public static float sizetext ;
    private boolean roundValue = false;
    private String unitsLeft  = "";
    private String unitsRight = "";
    private SeekBar seekBar;
    private TextView statusText;
    public SeekBarPreferences(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPreference(context, attrs);
    }
    public SeekBarPreferences(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initPreference(context, attrs);
        Log.d(TAG, "Preferences are installed");
    }
    private void initPreference(Context context, AttributeSet attrs) {
        Log.d(TAG, "Set values from xml");
        setValuesFromXml(attrs);
        this.seekBar = new SeekBar(context, attrs);
        this.seekBar.setMax(Math.round((this.maxValue - this.minValue)/this.interval));
        this.seekBar.setOnSeekBarChangeListener(this);
    }
    private void setValuesFromXml(AttributeSet attrs) {
        this.maxValue = attrs.getAttributeFloatValue(APP_NS, "max", 100);
        this.minValue = attrs.getAttributeFloatValue(APP_NS, "min", 0);
        this.unitsLeft = getAttributeStringValue(attrs, APP_NS, "unitsLeft", "");
        this.unitsRight = getAttributeStringValue(attrs, APP_NS, "unitsRight", "");
        this.roundValue = attrs.getAttributeBooleanValue(APP_NS, "roundValue", false);
        try {
            String newInterval = attrs.getAttributeValue(APP_NS, "interval");
            if(newInterval != null)
                this.interval = Float.parseFloat(newInterval);
        }
        catch(Exception e) {
            Log.e(TAG, "Invalid interval value", e);
        }
    }
    private String getAttributeStringValue(AttributeSet attrs, String namespace, String name, String defaultValue) {
        String value = attrs.getAttributeValue(namespace, name);
        if(value == null)
            value = defaultValue;
        return value;
    }
    @Override
    protected View onCreateView(ViewGroup parent){
        Log.d(TAG, "Start creating view");
        RelativeLayout layout =  null;
        try {
            LayoutInflater mInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            layout = (RelativeLayout)mInflater.inflate(getID("seek_bar_preference","layout"), parent, false);
        }
        catch(Exception e) {
            Log.e(TAG, "Error creating seek bar preference", e);
        }
        return layout;
    }
    @Override
    public void onBindView(View view) {
        super.onBindView(view);
        Log.d(TAG, "Start binding view");
        try
        {
            // move our seekbar to the new view we've been given
            ViewParent oldContainer = this.seekBar.getParent();
            ViewGroup newContainer = (ViewGroup) view.findViewById(getID("seekBarPrefBarContainer","id"));
            if (oldContainer != newContainer) {
                // remove the seekbar from the old view
                if (oldContainer != null) {
                    ((ViewGroup) oldContainer).removeView(this.seekBar);
                }
                // remove the existing seekbar (there may not be one) and add ours
                newContainer.removeAllViews();
                newContainer.addView(this.seekBar, ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);
            }
        }
        catch(Exception e) {
            Log.e(TAG, "Error binding view: ", e);
        }
        updateView(view);
    }
    /**
     * Update a SeekBarPreference view with our current state
     * @param view
     */
    protected void updateView(View view) {
        Log.d(TAG, "updateView");
        try {
            RelativeLayout layout = (RelativeLayout)view;
            this.statusText = (TextView)layout.findViewById(getID("seekBarPrefValue","id"));
            this.statusText.setText( roundValue ? String.valueOf((int) this.sizetext) : String.valueOf(this.sizetext));
            this.statusText.setMinimumWidth(30);
            this.seekBar.setProgress((int)Math.round((this.sizetext - this.minValue)/this.interval));
            TextView unitsRight = (TextView)layout.findViewById(getID("seekBarPrefUnitsRight","id"));
            unitsRight.setText(this.unitsRight);
            TextView unitsLeft = (TextView)layout.findViewById(getID("seekBarPrefUnitsLeft","id"));
            unitsLeft.setText(this.unitsLeft);
        }
        catch(Exception e) {
            Log.e(TAG, "Error updating seek bar preference", e);
        }
    }
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        Log.d(TAG, "onProgressChanged");
        float newValue = ((float)Math.round((progress*this.interval+ this.minValue)*100))/100 ;
        if(newValue > this.maxValue)
            newValue = this.maxValue;
        else if(newValue < this.minValue)
            newValue = this.minValue;
        if(!callChangeListener(Math.round(newValue))){
            seekBar.setProgress(Math.round((this.sizetext - this.minValue)/this.interval));
            return;
        }
        this.sizetext = newValue;
        this.statusText.setText(roundValue ? String.valueOf((int)newValue) : String.valueOf(newValue));
        persistFloat(newValue);
    }
    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {}
    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
    }
    @Override
    protected Object onGetDefaultValue(TypedArray ta, int index){
        Log.d(TAG,"onGetDefaultValue");
        float defaultValue = ta.getFloat(index, DEFAULT_VALUE);
        return defaultValue;
    }
    @Override
    protected void onSetInitialValue(boolean restoreValue, Object defaultValue) {
        Log.d(TAG,"onSetInitialValue");
        if(restoreValue) {
            Log.d(TAG,"restoreValue");
            this.sizetext = getPersistedFloat(this.sizetext);
        }
        else {
            float temp = (float)this.minValue;
            try {
                temp = (Float)defaultValue;
            }
            catch(Exception e) {
                Log.e(TAG, "Invalid default value: " + defaultValue.toString(), e);
            }
            persistFloat(temp);
            this.sizetext = temp;
        }}
    
	public int getID(String name, String Type) {
		return getContext().getResources().getIdentifier(name, Type, getContext().getPackageName());
	}}
