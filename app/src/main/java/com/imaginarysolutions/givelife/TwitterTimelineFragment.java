package com.imaginarysolutions.givelife;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.twitter.sdk.android.tweetui.SearchTimeline;
import com.twitter.sdk.android.tweetui.TweetTimelineListAdapter;

public class TwitterTimelineFragment extends ListFragment {

    public static final String ARG_QUERY = "arg_query";

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param query Twitter search query
     * @return A new instance of fragment TwitterTimelineFragment.
     */
    public static TwitterTimelineFragment newInstance(String query) {
        TwitterTimelineFragment fragment = new TwitterTimelineFragment();
        Bundle args = new Bundle();
        args.putString(ARG_QUERY, query);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String query = null;
        if (getArguments() != null) {
            query = getArguments().getString(ARG_QUERY);
        }

        SearchTimeline searchTimeline = new SearchTimeline.Builder()
                .query(query).build();
        TweetTimelineListAdapter adapter =
                new TweetTimelineListAdapter(getActivity(), searchTimeline);
        setListAdapter(adapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_twitter_timeline, container, false);
    }
}
