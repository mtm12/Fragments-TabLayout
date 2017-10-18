package fragments_tablayout.demo.com.fragments_tablayout;

//import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;

import static fragments_tablayout.demo.com.fragments_tablayout.MainActivity.fragmentsList;
import static fragments_tablayout.demo.com.fragments_tablayout.MainActivity.tabCounter;

//import android.support.v4.app.Fragment;
//import static viewpager.www.viewpager.com.viewpager.MainActivity.fList;

/**
 * Created by marct_000 on 8/22/2017.
 */

public class Tab2 extends Fragment {

    private Button btn;
    public static final String EXTRA_MESSAGE = "EXTRA_MESSAGE";
    public static final Tab2 newInstance(String message)
    {
        Tab2 f = new Tab2();
        Bundle bdl = new Bundle(1);
        bdl.putString(EXTRA_MESSAGE, message);
        f.setArguments(bdl);
        return f;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String store_url = getArguments().getString(EXTRA_MESSAGE);
        View v = inflater.inflate(R.layout.tab2, container, false);
        String message = getArguments().getString(EXTRA_MESSAGE);
        final TextView messageTextView = (TextView)v.findViewById(R.id.textView);
        messageTextView.setText(message);
        btn = (Button)v.findViewById(R.id.btnChange);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                messageTextView.setText(messageTextView.getText() + " new state");
            }
        });
        return v;
    }
}
