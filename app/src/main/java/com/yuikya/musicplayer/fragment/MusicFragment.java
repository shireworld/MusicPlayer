package com.yuikya.musicplayer.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yuikya.musicplayer.MusicLoader;
import com.yuikya.musicplayer.R;
import com.yuikya.musicplayer.adapter.TrackAdapter;
import com.yuikya.musicplayer.db.TrackDataHelper;
import com.yuikya.musicplayer.models.Track;
import com.yuikya.musicplayer.widget.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fan on 2015/10/13.
 */
public class MusicFragment extends Fragment {

    private RecyclerView musicRecyclerview;
    private List<Track> trackList = new ArrayList<>();
    private TrackDataHelper helper;
    private TrackAdapter trackAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.music_fragment, container, false);
        musicRecyclerview = (RecyclerView) view.findViewById(R.id.music_recyclerview);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        helper = new TrackDataHelper(getActivity());
        //helper.saveTrackList(MusicLoader.instance(getActivity().getContentResolver()).getTrackList());
        trackList = helper.getTrackList();

        musicRecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        musicRecyclerview.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL_LIST));
        trackAdapter = new TrackAdapter(getActivity(),trackList);
        musicRecyclerview.setAdapter(trackAdapter);


    }
}
