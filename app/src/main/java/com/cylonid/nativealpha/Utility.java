package com.cylonid.nativealpha;

import android.content.Context;
import android.content.Intent;
import android.util.TypedValue;

import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;

public final class Utility {
    public static final String INT_ID_WEBAPPID = "webappID";
    public static final String DESKTOP_USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.116 Safari/537.36";
    public static Intent createWebViewIntent(WebApp d, Context c) {
        Intent intent = new Intent(c, WebViewActivity.class);
        intent.putExtra(Utility.INT_ID_WEBAPPID, d.getID());
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.setAction(Intent.ACTION_VIEW);

        return intent;
    }

    public static Long getTimeInSeconds()
    {
        return System.currentTimeMillis() / 1000;
    }

    public static void Assert(boolean condition, String message) {
        if (!condition) {
            throw new AssertionError(message);
        }
    }
    @ColorInt
    public static int getThemeColor
            (
                    @NonNull final Context context,
                    @AttrRes final int attributeColor
            )
    {
        final TypedValue value = new TypedValue();
        context.getTheme ().resolveAttribute (attributeColor, value, true);
        return value.data;
    }

}