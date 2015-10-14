package com.yuikya.musicplayer.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yuikya.musicplayer.R;
import com.yuikya.musicplayer.models.Track;

import java.util.List;

/**
 * Created by fan on 2015/10/13.
 */
public class TrackAdapter extends RecyclerView.Adapter<TrackAdapter.ViewHolder> {

    private Context context;
    private List<Track> trackList;

    public TrackAdapter(Context context, List<Track> list) {
        this.context = context;
        this.trackList = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.music_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        Track track = trackList.get(i);
        viewHolder.title.setText(track.getTitle());
        viewHolder.artist.setText(track.getArtist());
    }

    @Override
    public int getItemCount() {
        return trackList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView title, artist;

        public ViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.music_title_text);
            artist = (TextView) itemView.findViewById(R.id.music_artist_text);
        }
    }
}
