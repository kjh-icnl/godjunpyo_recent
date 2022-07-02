package com.example.godjunpyo_recent.ui.see_all;

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
import com.example.godjunpyo_recent.databinding.FragmentSeeAllBinding;

public class SeeAllFragment extends Fragment {

    private SeeAllViewModel seeAllViewModel;
    private FragmentSeeAllBinding binding;
    private WebView webView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        seeAllViewModel =
                new ViewModelProvider(this).get(SeeAllViewModel.class);

        binding = FragmentSeeAllBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        /*
        final TextView textView = binding.textSeeAll;
        seeAllViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        */

        /** for WebView**/
        webView = (WebView) root.findViewById(R.id.webview_see_all);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://godjunpyo.com/역학-콘서트/");

        // do this operation after the view is loaded
        webView.setWebViewClient(new WebViewClient() {
            public void onPageFinished(WebView view, String url) {
                view.evaluateJavascript("document.querySelector('#post-3740 > div').scrollIntoView()", s -> {
                    // do nothing
                });
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