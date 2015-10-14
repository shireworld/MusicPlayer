package com.yuikya.musicplayer.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by fan on 2015/10/13.
 */
public class Album implements Parcelable {

    private int count;
    private String name;
    private String artist;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.count);
        dest.writeString(this.name);
        dest.writeString(this.artist);
    }

    public Album() {
    }

    protected Album(Parcel in) {
        this.count = in.readInt();
        this.name = in.readString();
        this.artist = in.readString();
    }

    public static final Parcelable.Creator<Album> CREATOR = new Parcelable.Creator<Album>() {
        public Album createFromParcel(Parcel source) {
            return new Album(source);
        }

        public Album[] newArray(int size) {
            return new Album[size];
        }
    };
}
