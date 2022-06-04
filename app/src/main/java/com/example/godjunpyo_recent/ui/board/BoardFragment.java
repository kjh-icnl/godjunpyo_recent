package com.example.godjunpyo_recent.ui.board;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.godjunpyo_recent.databinding.FragmentBoardBinding;

public class BoardFragment extends Fragment {

    private BoardViewModel boardViewModel;
    private FragmentBoardBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        boardViewModel =
                new ViewModelProvider(this).get(BoardViewModel.class);

        binding = FragmentBoardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textBoard;
        boardViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}