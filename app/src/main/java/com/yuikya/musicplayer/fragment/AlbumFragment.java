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
import com.yuikya.musicplayer.adapter.AlbumAdapter;
import com.yuikya.musicplayer.db.TrackDataHelper;
import com.yuikya.musicplayer.models.Album;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fan on 2015/10/15.
 */
public class AlbumFragment extends Fragment {
    private AlbumAdapter albumAdapter;
    private RecyclerView albumRecyclerview;
    private List<Album> albumList = new ArrayList<>();
    private TrackDataHelper helper;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.album_fragment,container,false);
        albumRecyclerview = (RecyclerView) view.findViewById(R.id.album_recyclerview);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        helper = new TrackDataHelper(getActivity());
        albumList = helper.getAlbums();

        albumRecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        albumAdapter = new AlbumAdapter(getActivity(),albumList);
        albumRecyclerview.setAdapter(albumAdapter);
    }
}
