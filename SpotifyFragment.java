package com.bignerdranch.android.weathify;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileReader;
import java.util.Iterator;


public class SpotifyFragment extends Fragment {

    //playlist variables
    private String playlistJSONFile;
    private String playlistUri;
    private String playlistLabel;

    //song variables
    private TextView currentTrack;
    private TextView currentArtist;
    private TextView currentAlbum;
    private ImageView currentAlbumArtwork;

    //buttons
    private Button playButton;
    private Button pauseButton;
    private Button previousButton;
    private Button nextButton;

    private static final String TAG = "SpotifyFragment";

    private String currentTrackUri;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.spotify_fragment, container, false);


        //TODO: get current track from PlayerState (String trackUri)

        //TODO: call getCurrentPlaylist

        //TODO: call getTrackInfo

        return view;
    }

    //get current playlist
    private void getCurrentPlaylist(String uri){
        switch(uri){
            //Autumn Acoustics
            case "spotify:user:spotify:playlist:6NCfeirBIrZfYcs9kwnS3x":
                playlistJSONFile = WeathifyManagerActivity.getSpotifyPlaylists(R.raw.autumnacoustics);
                playlistLabel = "Autumn Acoustics";
                break;

            //Rainy Day
            case "spotify:user:spotify:playlist:7CQunpJEHecknIyABfS8pP":
                playlistJSONFile = WeathifyManagerActivity.getSpotifyPlaylists(R.raw.rainyday);
                playlistLabel = "Rainy Day";
                break;

            //Winter Run
            case "spotify:user:spotify:playlist:67mbEfYTxSfO0px53W8zsL":
                playlistJSONFile = WeathifyManagerActivity.getSpotifyPlaylists(R.raw.winterrun);
                playlistLabel = "WinterRun";
                break;

            //Down In The Dumps
            case "spotify:user:spotify:playlist:6ejgjp55cJWGzcDOp4HpGC":
                playlistJSONFile = WeathifyManagerActivity.getSpotifyPlaylists(R.raw.downinthedumps);
                playlistLabel = "Down in the Dumps";
                break;

            //Get Happy
            case "spotify:user:myplay.com:playlist:1h90L3LP8kAJ7KGjCV2Xfd":
                playlistJSONFile = WeathifyManagerActivity.getSpotifyPlaylists(R.raw.gethappy);
                playlistLabel = "Get Happy";
                break;
        }
    }

    //extract track info
    //get track name, artist name, album name, get 300x300 album artwork
    private void getTrackInfo(int playlistID, String playlistJSONFile){

        try{
            //
            JSONObject playlistObject = new JSONObject(playlistJSONFile);
            JSONArray items = (JSONArray) playlistObject.get("items");


            for(int i=0; i<items.length(); i++){
                JSONObject trackObject = items.getJSONObject(i);
                String trackID = trackObject.getString("id");
                //TODO: match track id to current track and grab metadata

            }

        }catch(JSONException e){
            Log.e(TAG, "Error parsing JSON file", e);
        }


    }
}
