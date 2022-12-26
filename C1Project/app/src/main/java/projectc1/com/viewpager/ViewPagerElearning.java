package projectc1.com.viewpager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.fragment.app.Fragment;

import projectc1.com.R;


public class ViewPagerElearning extends Fragment {

    WebView webb;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_viewpager_elearning, container, false);
        webb = view.findViewById(R.id.webVIEW);
        webb.getSettings().setJavaScriptEnabled(true);
        webb.setWebViewClient(new WebViewClient());
        webb.loadUrl("https://elearning.umn.ac.id/login/index.php");
        return view;


    }


}