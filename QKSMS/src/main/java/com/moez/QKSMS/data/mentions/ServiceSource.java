package com.moez.QKSMS.data.mentions;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import com.linkedin.android.spyglass.mentions.Mentionable;

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
        return null;
    }

    @Override
    public MentionDeleteStyle getDeleteStyle() {
        return null;
    }

    @Override
    public int getSuggestibleId() {
        return 0;
    }

    @Override
    public String getSuggestiblePrimaryText() {
        return null;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

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
}
