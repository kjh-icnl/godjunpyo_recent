package com.example.godjunpyo_recent.ui.thermo;

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

import com.example.godjunpyo_recent.databinding.FragmentThermoBinding;

public class ThermoFragment extends Fragment {

    private ThermoViewModel thermoViewModel;
    private FragmentThermoBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        thermoViewModel =
                new ViewModelProvider(this).get(ThermoViewModel.class);

        binding = FragmentThermoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textThermo;
        thermoViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
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