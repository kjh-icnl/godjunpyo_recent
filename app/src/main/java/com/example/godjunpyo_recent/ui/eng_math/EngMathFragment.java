package com.example.godjunpyo_recent.ui.eng_math;

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

import com.example.godjunpyo_recent.databinding.FragmentEngMathBinding;

public class EngMathFragment extends Fragment {

    private EngMathViewModel engMathViewModel;
    private FragmentEngMathBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        engMathViewModel =
                new ViewModelProvider(this).get(EngMathViewModel.class);

        binding = FragmentEngMathBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textEngMath;
        engMathViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
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