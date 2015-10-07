package com.concur.mobile.android.sdk.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.io.IOException;

/**
 * @author Chris Diaz
 */
public class ImageUtil {

    // Util class.
    private ImageUtil() {
    }

    /**
     *
     */
    public interface ImageDownloadCallback {

        public void onSuccess();

        public void onFailure();
    }

    /**
     *
     * Synchronously fetches the image from the given <code>Uri</code>.  This method must <b>not</b>
     * be called from the main thread.
     *
     * @param context
     * @param source
     * @return
     */
    public static synchronized Bitmap getImage(Context context, Uri source) throws IOException {

        if(context != null && source != null) {
            return Picasso.with(context).load(source).get();
        }

        return null;

    }

    /**
     *
     * @param context
     * @param source
     * @param callback
     */
    public static synchronized void getImageAsync(Context context, Uri source, final ImageDownloadCallback callback) {

        if(context != null && source != null) {
            Picasso.with(context).load(source).fetch(new Callback() {
                @Override
                public void onSuccess() {
                    if(callback != null) {
                        callback.onSuccess();
                    }
                }

                @Override
                public void onError() {
                    if(callback != null) {
                        callback.onFailure();
                    }
                }
            });
        } else {
            throw new IllegalArgumentException("Context and Uri must not be null!");
        }

    }

}
