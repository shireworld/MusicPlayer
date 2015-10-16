package com.yuikya.musicplayer.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yuikya.musicplayer.R;
import com.yuikya.musicplayer.models.Album;
import com.yuikya.musicplayer.models.Artist;

import java.util.List;

/**
 * Created by fan on 2015/10/13.
 */
public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.ViewHolder> {

    private Context context;
    private List<Album> albumList;

    public AlbumAdapter(Context context, List<Album> albumList) {
        this.context = context;
        this.albumList = albumList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.album_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Album album = albumList.get(position);
        String alphabet = album.getName().substring(0, 1).toUpperCase();
        holder.albumName.setText(album.getName());
        holder.albumArtist.setText(album.getArtist());
        holder.albumImg.setImageResource(R.mipmap.ic_launcher);
        if (position > 0) {
            if (alphabet.equals(albumList.get(position - 1).getName().substring(0, 1).toUpperCase())) {
                holder.albumHeader.setVisibility(View.GONE);
            } else {
                holder.albumHeader.setVisibility(View.VISIBLE);
                holder.albumAlpabet.setText(alphabet);
            }
        }
    }

    @Override
    public int getItemCount() {
        return albumList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView albumName, albumArtist, albumAlpabet;
        public ImageView albumImg;
        public LinearLayout albumHeader;
        public ViewHolder(View itemView) {
            super(itemView);
            albumAlpabet = (TextView) itemView.findViewById(R.id.album_alphabet);
            albumArtist = (TextView) itemView.findViewById(R.id.album_artist);
            albumHeader = (LinearLayout) itemView.findViewById(R.id.album_header);
            albumImg = (ImageView) itemView.findViewById(R.id.album_img);
            albumName = (TextView) itemView.findViewById(R.id.album_name);

        }
    }
}
