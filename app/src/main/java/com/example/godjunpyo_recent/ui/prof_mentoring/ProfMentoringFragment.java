package com.example.godjunpyo_recent.ui.prof_mentoring;

import android.os.Bundle;
import android.provider.SyncStateContract;
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
import com.example.godjunpyo_recent.databinding.FragmentProfMentoringBinding;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerFullScreenListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.ui.PlayerUiController;

import java.util.ArrayList;
import java.util.List;

public class ProfMentoringFragment extends Fragment {

    private ProfMentoringViewModel profMentoringViewModel;
    private FragmentProfMentoringBinding binding;
    final int[] text_ids = {
            R.id.text_prof_1,
            R.id.text_prof_2,
            R.id.text_prof_3,
            R.id.text_prof_4
    };
    final String[] titles = {
            "권혁준 교수님: DGIST",
            "홍석준 교수님: 한양대학교",
            "박진성 교수님: 성균관대학교",
            "김진균 교수님: 경희대학교"
    };

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        profMentoringViewModel =
                new ViewModelProvider(this).get(ProfMentoringViewModel.class);

        binding = FragmentProfMentoringBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        /*
        final TextView textView = binding.textProfMentoring;
        profMentoringViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        */

        /** Set YouTube Videos' Titles **/
        for (int i=0; i<titles.length; ++i){
            TextView textView = root.findViewById(text_ids[i]);
            textView.setText(titles[i]);
        }


        /** How to watch YouTube videos in app with a full screen? **/

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}