package com.example.godjunpyo_recent.ui.see_all;

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

import com.example.godjunpyo_recent.databinding.FragmentSeeAllBinding;

public class SeeAllFragment extends Fragment {

    private SeeAllViewModel seeAllViewModel;
    private FragmentSeeAllBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        seeAllViewModel =
                new ViewModelProvider(this).get(SeeAllViewModel.class);

        binding = FragmentSeeAllBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textSeeAll;
        seeAllViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
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