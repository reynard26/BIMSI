package projectc1.com.viewpager;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import projectc1.com.R;


public class ViewPagerMyumn extends Fragment {

    WebView webb;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_view_pager_myumn, container, false);
        webb = view.findViewById(R.id.webVIEW);
        webb.getSettings().setJavaScriptEnabled(true);
        webb.setWebViewClient(new WebViewClient());
        webb.loadUrl("https://my.umn.ac.id/");
        return view;


    }


}