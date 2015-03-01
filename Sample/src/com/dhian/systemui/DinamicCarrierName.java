package com.dhian.systemui;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.*;
import android.util.AttributeSet;
import android.widget.ViewFlipper;
import android.text.TextUtils;
import android.content.*;
import android.preference.*;
import android.view.animation.Animation;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationUtils;



/*
 * Failed to analyse overrides
 */
public class DinamicCarrierName
extends ViewFlipper {
	
	
    public DinamicCarrierName(final Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
		this.setAutoStart(true);
		
			this.setFlipInterval(4000);
		this.startFlipping();
		this.setInAnimation(AnimationUtils.loadAnimation(context, getID("from_middle","anim")));
		this.setOutAnimation(AnimationUtils.loadAnimation(context, getID("to_middle","anim")));
		
	}
	public int getID(String name, String Type) {
		return getContext().getResources().getIdentifier(name, Type, getContext().getPackageName());
	}
	
	

    
	
	

}

