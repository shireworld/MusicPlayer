package com.yuikya.musicplayer.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yuikya.musicplayer.R;
import com.yuikya.musicplayer.adapter.ArtistAdapter;
import com.yuikya.musicplayer.db.TrackDataHelper;
import com.yuikya.musicplayer.models.Artist;
import com.yuikya.musicplayer.widget.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fan on 2015/10/13.
 */
public class ArtistFragment extends Fragment {

    private RecyclerView artistRecyclerview;
    private ArtistAdapter artistAdapter;
    private List<Artist> artistList = new ArrayList<>();
    private TrackDataHelper helper;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.artist_fragment,container,false);
        artistRecyclerview = (RecyclerView) view.findViewById(R.id.artist_recyclerview);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        helper = new TrackDataHelper(getActivity());
        helper.getArtists();
        artistList = helper.getArtists();

        artistRecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        //artistRecyclerview.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL_LIST));
        artistAdapter = new ArtistAdapter(getActivity(),artistList);
        artistRecyclerview.setAdapter(artistAdapter);
    }
}
