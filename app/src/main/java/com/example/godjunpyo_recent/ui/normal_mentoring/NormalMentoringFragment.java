package com.example.godjunpyo_recent.ui.normal_mentoring;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.godjunpyo_recent.R;
import com.example.godjunpyo_recent.databinding.FragmentNormalMentoringBinding;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.ui.menu.MenuItem;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.ui.menu.YouTubePlayerMenu;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

public class NormalMentoringFragment extends Fragment {

    private NormalMentoringViewModel normalMentoringViewModel;
    private FragmentNormalMentoringBinding binding;
    private LinearLayout normal_mentoring_layout;
    private String url = "https://raw.githubusercontent.com/kjh-icnl/godjunpyo_recent/master/link?token=GHSAT0AAAAAABTPCCSRTKCOKZIMSETCW5AOYU3RWEA";
    //public ArrayList<String> stringArrayList;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        normalMentoringViewModel =
                new ViewModelProvider(this).get(NormalMentoringViewModel.class);

        binding = FragmentNormalMentoringBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
/*
        final TextView textView = binding.textNormalMentoring;
        normalMentoringViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
 */


        /** for Web Data **/
        ArrayList<String> stringArrayList = new ArrayList<>();
        Thread thread = new Thread(() -> {
            Document doc = null;
            try {
                doc = Jsoup.connect(url).get();
                String[] splited = doc.text().split(" ");
                for (int i = 0; i< splited.length/3; ++i){
                    Log.d("WEB_DATA", "onCreateView: " + splited[3*i] + " " + splited[3*i+1] + " " + splited[3*i+2]);
                    stringArrayList.add(splited[3*i]); stringArrayList.add(splited[3*i+1]); stringArrayList.add(splited[3*i+2]);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        try {
            thread.start();
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        /** YouTube **/
        normal_mentoring_layout = root.findViewById(R.id.normal_mentoring_layout);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                                                                         ViewGroup.LayoutParams.WRAP_CONTENT);
        LinearLayout.LayoutParams text_params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                                                                         ViewGroup.LayoutParams.WRAP_CONTENT);
        // YouTube Player Layout Parameter Setting
        params.bottomMargin=10; params.topMargin=45; params.leftMargin=30; params.rightMargin=30;
        // TextView Parameter Setting
        text_params.bottomMargin=20; text_params.topMargin=0; text_params.leftMargin=30; text_params.rightMargin=30;

        for (int i = 0; i<stringArrayList.size()/3; ++i) {
            // for Video Player
            YouTubePlayerView youTubePlayerView = new YouTubePlayerView(root.getContext());
            youTubePlayerView.setLayoutParams(params);
            normal_mentoring_layout.addView(youTubePlayerView);
            getLifecycle().addObserver(youTubePlayerView);
            int _i = i;
            youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
                @Override
                public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                    //super.onReady(youTubePlayer); // for autoPlay true
                    youTubePlayer.cueVideo(stringArrayList.get(3*_i), 0); // for autoPlay false
                }
            });

            // for Video Title
            TextView textView = new TextView(root.getContext());
            normal_mentoring_layout.addView(textView);
            textView.setGravity(Gravity.CENTER);
            String str = stringArrayList.get(3*_i+1) + " " + stringArrayList.get(3*_i+2);
            textView.setText(str);
        }
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }



}