package com.yuikya.musicplayer.loader;


import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore.Audio.Media;

import com.yuikya.musicplayer.models.Track;

import java.util.ArrayList;
import java.util.List;

public class MusicLoader {

    private List<Track> trackList = new ArrayList<>();

    private static MusicLoader musicLoader;

    private static ContentResolver contentResolver;
    //Uri，指向external的database
    private Uri contentUri = Media.EXTERNAL_CONTENT_URI;
    //projection：选择的列; where：过滤条件; sortOrder：排序。
    private String[] projection = {
            Media._ID,
            Media.TITLE,
            Media.DATA,
            Media.ARTIST,
            Media.ALBUM_ID,
            Media.ALBUM,
            Media.DURATION,
            Media.DISPLAY_NAME,
    };
    //    private String where = "mime_type in ('audio/mpeg','audio/x-ms-wma') and bucket_display_name <> 'audio' and is_music > 0 ";
    private String where = "is_music > 0";
    private String sortOrder = Media.DATA;

    public static MusicLoader instance(ContentResolver pContentResolver) {
        if (musicLoader == null) {
            contentResolver = pContentResolver;
            musicLoader = new MusicLoader();
        }
        return musicLoader;
    }

    private MusicLoader() {                                                                                                               //利用ContentResolver的query函数来查询数据，然后将得到的结果放到MusicInfo对象中，最后放到数组中
        Cursor cursor = contentResolver.query(contentUri, projection, where, null, Media.DISPLAY_NAME);
        if (cursor.moveToFirst()) {
            int titleCol = cursor.getColumnIndex(Media.TITLE);
            int albumIdCol = cursor.getColumnIndex(Media.ALBUM_ID);
            int idCol = cursor.getColumnIndex(Media._ID);
            int durationCol = cursor.getColumnIndex(Media.DURATION);
            int albumCol = cursor.getColumnIndex(Media.ALBUM);
            int artistCol = cursor.getColumnIndex(Media.ARTIST);
            int pathCol = cursor.getColumnIndex(Media.DATA);
            int displayCol = cursor.getColumnIndex(Media.DISPLAY_NAME);
            do {
                Track track = new Track();
                String id = cursor.getString(idCol);
                String title = cursor.getString(titleCol);
                String path = cursor.getString(pathCol);
                String artist = cursor.getString(artistCol);
                String album_id = cursor.getString(albumIdCol);
                String album = cursor.getString(albumCol);
                String duration = cursor.getString(durationCol);
                String display_name = cursor.getString(displayCol);
                track.setId(Integer.parseInt(id));
                track.setTitle(title);
                track.setPath(path);
                track.setArtist(artist);
                track.setAlbum_id(Integer.parseInt(album_id));
                track.setAlbum(album);
                track.setDuration(Integer.parseInt(duration));
                track.setDisplay_name(display_name);
                trackList.add(track);
            } while (cursor.moveToNext());
        }
    }

    public List<Track> getTrackList() {
        return trackList;
    }

}
