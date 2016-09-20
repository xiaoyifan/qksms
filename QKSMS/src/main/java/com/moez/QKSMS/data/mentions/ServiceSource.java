package com.moez.QKSMS.data.mentions;

import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.util.Log;

import com.linkedin.android.spyglass.mentions.Mentionable;
import com.moez.QKSMS.R;

import org.json.JSONArray;

/**
 * Created by yxiao on 9/20/16.
 */
public class ServiceSource implements Mentionable {

    private final String mName;

    public ServiceSource(String name){
        mName = name;
    }

    public String getName(){
        return mName;
    }

    @NonNull
    @Override
    public String getTextForDisplayMode(MentionDisplayMode mode) {
        switch (mode) {
            case FULL:
                return mName;
            case PARTIAL:
            case NONE:
            default:
                return "";
        }
    }

    @Override
    public MentionDeleteStyle getDeleteStyle() {
        return MentionDeleteStyle.PARTIAL_NAME_DELETE;
    }

    @Override
    public int getSuggestibleId() {
        return mName.hashCode();
    }

    @Override
    public String getSuggestiblePrimaryText() {
        return mName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int i) {
        dest.writeString(mName);
    }

    public ServiceSource(Parcel in) {
        mName = in.readString();
    }

    public static final Parcelable.Creator<ServiceSource> CREATOR
            = new Parcelable.Creator<ServiceSource>() {
        public ServiceSource createFromParcel(Parcel in) {
            return new ServiceSource(in);
        }

        public ServiceSource[] newArray(int size) {
            return new ServiceSource[size];
        }
    };

    public static class ServiceSourceLoader extends MentionsLoader<ServiceSource>{

        private static final String TAG = ServiceSourceLoader.class.getSimpleName();

        public ServiceSourceLoader(Resources res) {
            super(res, R.raw.mention_source);
        }

        @Override
        public ServiceSource[] loadData(JSONArray arr) {
            ServiceSource[] data = new ServiceSource[arr.length()];
            try {
                for (int i = 0; i < arr.length(); i++) {
                    data[i] = new ServiceSource(arr.getString(i));
                }
            } catch (Exception e) {
                Log.e(TAG, "Unhandled exception while parsing city JSONArray", e);
            }
            return data;
        }

    }


}
