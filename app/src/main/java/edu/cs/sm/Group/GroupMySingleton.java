package edu.cs.sm.Group;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;


public class GroupMySingleton {
    private static edu.cs.sm.Group.GroupMySingleton mInstance;
    private RequestQueue mRequestQueue;
    private static Context mCtx;

    private GroupMySingleton(Context context) {
        mCtx = context;
        mRequestQueue = getRequestQueue();
    }

    public static synchronized edu.cs.sm.Group.GroupMySingleton getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new edu.cs.sm.Group.GroupMySingleton(context);
        }
        return mInstance;
    }

    private RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            // getApplicationContext() is key, it keeps you from leaking the
            // Activity or BroadcastReceiver if someone passes one in.
            mRequestQueue = Volley.newRequestQueue(mCtx.getApplicationContext());
        }
        return mRequestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue().add(req);
    }
}