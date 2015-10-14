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
import com.yuikya.musicplayer.models.Artist;

import java.util.List;

/**
 * Created by fan on 2015/10/13.
 */
public class ArtistAdapter extends RecyclerView.Adapter<ArtistAdapter.ViewHolder> {

    private Context context;
    private List<Artist> artistList;

    public ArtistAdapter(Context context, List<Artist> artistList) {
        this.context = context;
        this.artistList = artistList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.artist_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Artist artist = artistList.get(position);
        String alphabet = artist.getName().substring(0, 1).toUpperCase();
        holder.artistName.setText(artist.getName());
        holder.artistCount.setText(artist.getCount() + " song");
        holder.artistImg.setImageResource(R.mipmap.ic_launcher);
        if (position > 0) {
            if (alphabet.equals(artistList.get(position - 1).getName().substring(0, 1).toUpperCase())) {
                holder.artistHeader.setVisibility(View.GONE);
            } else {
                holder.artistHeader.setVisibility(View.VISIBLE);
                holder.artistAlpabet.setText(alphabet);
            }
        }
    }

    @Override
    public int getItemCount() {
        return artistList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView artistName, artistCount, artistAlpabet;
        public ImageView artistImg;
        public LinearLayout artistHeader;
        public ViewHolder(View itemView) {
            super(itemView);
            artistName = (TextView) itemView.findViewById(R.id.artist_name);
            artistCount = (TextView) itemView.findViewById(R.id.artist_count);
            artistImg = (ImageView) itemView.findViewById(R.id.artist_img);
            artistAlpabet = (TextView) itemView.findViewById(R.id.artist_alphabet);
            artistHeader = (LinearLayout) itemView.findViewById(R.id.artist_header);

        }
    }
}
