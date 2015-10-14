package com.yuikya.musicplayer.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by fan on 2015/10/12.
 */
public class Track implements Parcelable {

    private String title;
    private String path;
    private int id;
    private int duration;
    private int album_id;
    private String album;
    private String artist;
    private String display_name;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getAlbum_id() {
        return album_id;
    }

    public void setAlbum_id(int album_id) {
        this.album_id = album_id;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getDisplay_name() {
        return display_name;
    }

    public void setDisplay_name(String display_name) {
        this.display_name = display_name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.path);
        dest.writeInt(this.id);
        dest.writeInt(this.duration);
        dest.writeInt(this.album_id);
        dest.writeString(this.album);
        dest.writeString(this.artist);
        dest.writeString(this.display_name);
    }

    public Track() {
    }

    protected Track(Parcel in) {
        this.title = in.readString();
        this.path = in.readString();
        this.id = in.readInt();
        this.duration = in.readInt();
        this.album_id = in.readInt();
        this.album = in.readString();
        this.artist = in.readString();
        this.display_name = in.readString();
    }

    public static final Parcelable.Creator<Track> CREATOR = new Parcelable.Creator<Track>() {
        public Track createFromParcel(Parcel source) {
            return new Track(source);
        }

        public Track[] newArray(int size) {
            return new Track[size];
        }
    };
}
