package com.yuikya.musicplayer.service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.yuikya.musicplayer.db.TrackDataHelper;
import com.yuikya.musicplayer.models.Track;

import java.util.List;


public class PlayerService extends Service {

    private List<Track> trackList;
    private MediaPlayer mp;

    @Override
    public void onCreate() {
        super.onCreate();
        TrackDataHelper helper = new TrackDataHelper(this);
        trackList = helper.getTrackList();
        mp = new MediaPlayer();

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


}
