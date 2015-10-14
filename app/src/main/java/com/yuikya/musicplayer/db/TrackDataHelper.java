package com.yuikya.musicplayer.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.yuikya.musicplayer.models.Album;
import com.yuikya.musicplayer.models.Artist;
import com.yuikya.musicplayer.models.Track;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fan on 2015/10/13.
 */
public class TrackDataHelper {

    private SQLiteDatabase db;

    public TrackDataHelper(Context context) {
        DbOpenHelper helper = new DbOpenHelper(context);
        db = helper.getWritableDatabase();
    }

    public List<Track> getTrackList() {
        List<Track> trackList = new ArrayList<>();
        Cursor cursor = db.query(DbOpenHelper.TABLE_NAME, null, null, null, null, null, "title");
        if (cursor.moveToFirst()) {
            do {
                Track track = new Track();
                track.setId(Integer.parseInt(cursor.getString(0)));
                track.setTitle(cursor.getString(1));
                track.setPath(cursor.getString(2));
                track.setArtist(cursor.getString(3));
                track.setAlbum_id(Integer.parseInt(cursor.getString(4)));
                track.setAlbum(cursor.getString(5));
                track.setDuration(Integer.parseInt(cursor.getString(6)));
                track.setDisplay_name(cursor.getString(7));
                trackList.add(track);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return trackList;
    }

    public void insertTrack(Track track) {
        ContentValues c = new ContentValues();
        c.put("id", track.getId());
        c.put("title", track.getTitle());
        c.put("path", track.getPath());
        c.put("artist", track.getArtist());
        c.put("album_id", track.getAlbum_id());
        c.put("album", track.getAlbum());
        c.put("duration", track.getDuration());
        c.put("display_name",track.getDisplay_name());
        db.insert(DbOpenHelper.TABLE_NAME, null, c);
    }

    public void updateTrack(Track track) {
        ContentValues c = new ContentValues();
        c.put("id", track.getId());
        c.put("title", track.getTitle());
        c.put("path", track.getPath());
        c.put("artist", track.getArtist());
        c.put("album_id", track.getAlbum_id());
        c.put("album", track.getAlbum());
        c.put("duration", track.getDuration());
        c.put("display_name",track.getDisplay_name());
        db.update(DbOpenHelper.TABLE_NAME, c, "path = ?", new String[]{track.getPath()});
    }

    public void saveTrackList(List<Track> trackList) {
        if (trackList.size() > 0) {
            db.beginTransaction();
            for (Track track : trackList) {
                if (containsTrack(track)) {
                    updateTrack(track);
                }else{
                    insertTrack(track);
                }
            }
            db.setTransactionSuccessful();
            db.endTransaction();
        }

    }

    public boolean containsTrack(Track track) {
        Cursor cursor = db.rawQuery("select title from " + DbOpenHelper.TABLE_NAME + " where path = ?", new String[]{track.getPath()});
        boolean contains = cursor.moveToFirst();
        cursor.close();
        return contains;

    }

    public List<Artist> getArtists(){
        List<Artist> list = new ArrayList<>();
        Cursor cursor = db.query(true, DbOpenHelper.TABLE_NAME, new String[]{"artist","count(title)"}, null, null, "artist", null, null, null);
        if(cursor.moveToFirst()){
            do{
                Artist artist = new Artist();
                artist.setName(cursor.getString(0));
                artist.setCount(Integer.parseInt(cursor.getString(1)));
                list.add(artist);

            }while(cursor.moveToNext());
        }
        cursor.close();
        return list;
    }

    /**
     * get albums
     * @return
     */
    public List<Album> getAlbums(){
        List<Album> list = new ArrayList<>();
        Cursor cursor = db.query(true,DbOpenHelper.TABLE_NAME,new String[]{"album","artist","count(title)"},null,null,"album",null,null,null);
        if(cursor.moveToFirst()){
            do{
                Album album = new Album();
                album.setName(cursor.getString(0));
                album.setArtist(cursor.getString(1));
                album.setCount(Integer.parseInt(cursor.getString(2)));
                list.add(album);
            }while(cursor.moveToNext());
        }
        cursor.close();
        return list;
    }
}
