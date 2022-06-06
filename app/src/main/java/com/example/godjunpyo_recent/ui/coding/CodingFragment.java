package com.example.godjunpyo_recent.ui.coding;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.godjunpyo_recent.R;
import com.example.godjunpyo_recent.databinding.FragmentCodingBinding;

public class CodingFragment extends Fragment {

    private CodingViewModel codingViewModel;
    private FragmentCodingBinding binding;
    private WebView webView;

    @SuppressLint("SetJavaScriptEnabled")
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        codingViewModel =
                new ViewModelProvider(this).get(CodingViewModel.class);

        binding = FragmentCodingBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        /*
        final TextView textView = binding.textCoding;
        codingViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        */

        /** for WebView**/
        webView = (WebView) root.findViewById(R.id.webview_coding);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://godjunpyo.com/코딩/");

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}