/*
 * Copyright (C) 2015 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.cherish.settings.preferences;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import androidx.annotation.VisibleForTesting;
import androidx.core.content.res.TypedArrayUtils;
import androidx.preference.Preference;
import androidx.preference.PreferenceViewHolder;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.settings.R;
import com.android.settings.Utils;

public class CherishPreference extends Preference {

    private final View.OnClickListener mClickListener = v -> performClick(v);

    private boolean mAllowDividerAbove;
    private boolean mAllowDividerBelow;

    public CherishPreference(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.obtainStyledAttributes(attrs, androidx.preference.R.styleable.Preference);

        mAllowDividerAbove = TypedArrayUtils.getBoolean(a, androidx.preference.R.styleable.Preference_allowDividerAbove,
                androidx.preference.R.styleable.Preference_allowDividerAbove, false);
        mAllowDividerBelow = TypedArrayUtils.getBoolean(a, androidx.preference.R.styleable.Preference_allowDividerBelow,
                androidx.preference.R.styleable.Preference_allowDividerBelow, false);
        a.recycle();

        setLayoutResource(R.layout.preference_cherish_seekbar);
    }

    public CherishPreference(Context context, View view) {
        super(context);
    }

    @Override
    public void onBindViewHolder(PreferenceViewHolder holder) {
        super.onBindViewHolder(holder);
        holder.itemView.setOnClickListener(mClickListener);

        final boolean selectable = isSelectable();
        holder.itemView.setFocusable(selectable);
        holder.itemView.setClickable(selectable);
        holder.setDividerAllowedAbove(mAllowDividerAbove);
        holder.setDividerAllowedBelow(mAllowDividerBelow);
    }

}
