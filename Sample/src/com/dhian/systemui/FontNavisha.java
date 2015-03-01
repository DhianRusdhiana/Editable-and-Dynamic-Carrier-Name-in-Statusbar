package com.dhian.systemui;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.preference.ListPreference;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import android.app.*;

import java.io.IOException;
import java.util.ArrayList;

public class FontNavisha extends ListPreference {
    private final Context           mContext;
    private final LayoutInflater    mInflater;

    private String                  mSelectedFontFace;
    private final String            mFontDirectory;
    private final String            mFontPreviewString;
    private final ArrayList<String> mEntries     = new ArrayList<>();
    private final ArrayList<String> mEntryValues = new ArrayList<>();
	
    AlertDialog alert;

    public FontNavisha(final Context context, final AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        mInflater = LayoutInflater.from(context);

        
        mFontDirectory = "fonts";
        mFontPreviewString = "Font Style Preview";

        try {
            final String[] fonts = mContext.getAssets().list(mFontDirectory);

            for (final String font : fonts) {
                final String fontType = font.substring(font.length() - 3);

                if ("ttf".equals(fontType) || "otf".equals(fontType)) {
                    mEntries.add(this.removeDataEnding(font));
                    mEntryValues.add(font);
                }
            }
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onSetInitialValue(final boolean restoreValue, final Object defaultValue) {
        mSelectedFontFace = restoreValue ? this.getPersistedString(null) : (String) defaultValue;
        this.updateSummary();
    }

    @Override
    protected Object onGetDefaultValue(final TypedArray a, final int index) {
        return a.getString(index);
    }

    @Override
    protected void onPrepareDialogBuilder(final Builder builder) {
        if (mEntries.size() == 0) {
            throw new IllegalStateException("FontListPreference could not find any fonts in the assets/" + mFontDirectory + " folder. Please add some!");
        }

        final CustomListPreferenceAdapter customListPreferenceAdapter = new CustomListPreferenceAdapter();

        builder.setAdapter(customListPreferenceAdapter, new DialogInterface.OnClickListener() {
				@Override
				public void onClick(final DialogInterface dialog, final int which) {
					if (FontNavisha.this.shouldPersist()) {
						mSelectedFontFace = FontNavisha.this.getFontPath(mEntryValues.get(which));
						FontNavisha.this.persistString(mSelectedFontFace);
						FontNavisha.this.updateSummary();
						
					}
					dialog.cancel();
				}
			});

        builder.setPositiveButton(null, null);
    }

    private void updateSummary() {
        super.setSummary(" " + this.removeFontPath(this.removeDataEnding(mSelectedFontFace)));
    }

    private String getFontPath(final String font) {
        return mFontDirectory + "/" + font;
    }

    private String removeFontPath(final String fontPath) {
        return fontPath.replace(mFontDirectory, "").substring(1);
    }

    private String removeDataEnding(final String value) {
        return value.substring(0, value.length() - 4);
    }

    private class CustomListPreferenceAdapter extends BaseAdapter {
        public CustomListPreferenceAdapter() {

        }

        @Override
        public int getCount() {
            return mEntries.size();
        }

        @Override
        public Object getItem(final int position) {
            return position;
        }

        @Override
        public long getItemId(final int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, final ViewGroup parent) {
            final CustomHolder holder;

            if (convertView == null) {
                convertView = mInflater.inflate(android.R.layout.select_dialog_singlechoice, parent, false);

                holder = new CustomHolder();
                holder.checkedTextView = (CheckedTextView) convertView;

                convertView.setTag(holder);
            } else {
                holder = (CustomHolder) convertView.getTag();
            }

            final Typeface type = Typeface.createFromAsset(mContext.getAssets(), FontNavisha.this.getFontPath(mEntryValues.get(position)));
            holder.checkedTextView.setTypeface(type);
            holder.checkedTextView.setText(mFontPreviewString != null ? mFontPreviewString : mEntries.get(position));
            holder.checkedTextView.setChecked(FontNavisha.this.getFontPath(mEntryValues.get(position)).equals(mSelectedFontFace));

            return convertView;
        }
    }

    private static class CustomHolder {
        private CheckedTextView checkedTextView;
    }
	public int getID(String name, String Type) {
		return getContext().getResources().getIdentifier(name, Type, getContext().getPackageName());
	}

}
