package com.example.godjunpyo_recent.ui.material;

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
import com.example.godjunpyo_recent.databinding.FragmentMaterialBinding;

public class MaterialFragment extends Fragment {

    private MaterialViewModel materialViewModel;
    private FragmentMaterialBinding binding;
    private WebView webView;

    @SuppressLint("SetJavaScriptEnabled")
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        materialViewModel =
                new ViewModelProvider(this).get(MaterialViewModel.class);

        binding = FragmentMaterialBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        /*
        final TextView textView = binding.textMaterial;
        materialViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        */


        /** for WebView**/
        webView = (WebView) root.findViewById(R.id.webview_material);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://godjunpyo.com/공학재료학/");

        // do this operation after the view is loaded
        webView.setWebViewClient(new WebViewClient() {
            public void onPageFinished(WebView view, String url) {
                view.evaluateJavascript("document.querySelector('#post-5596 > div').scrollIntoView()", s -> {
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