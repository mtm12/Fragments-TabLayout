package fragments_tablayout.demo.com.fragments_tablayout;

//import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static fragments_tablayout.demo.com.fragments_tablayout.MainActivity.fragmentsList;
import static fragments_tablayout.demo.com.fragments_tablayout.MainActivity.pageAdapter;
import static fragments_tablayout.demo.com.fragments_tablayout.MainActivity.tabCounter;
import static fragments_tablayout.demo.com.fragments_tablayout.MainActivity.tabLayout;
import static fragments_tablayout.demo.com.fragments_tablayout.MainActivity.tabTitles;

/**
 * Created by marct_000 on 8/22/2017.
 */

public class Tab1 extends Fragment {
    private Button btnAdd;
    private Button btnRemove;
    private Button btnRemoveNumber;
    private Button insertBtn;
    private EditText editText;
    private EditText editTextInsert;
    public static final String EXTRA_MESSAGE = "EXTRA_MESSAGE";
    private int y = 0;
    private int iCount = 0;
    private int x = 0;
    public static final Tab1 newInstance(String message)

    {
        Tab1 f = new Tab1();
        Bundle bdl = new Bundle(1);
        bdl.putString(EXTRA_MESSAGE, message);
        f.setArguments(bdl);
        return f;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String message = getArguments().getString(EXTRA_MESSAGE);
        View v = inflater.inflate(R.layout.tab1, container, false);
        TextView messageTextView = (TextView)v.findViewById(R.id.textView);
        messageTextView.setText(message);

        btnAdd = (Button)v.findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //int x = tabTitles.size();
                //tabTitles.add("Tab" + x);
                tabTitles.add("Tab" + tabCounter);
                fragmentsList.add(Tab2.newInstance("Fragment " + tabCounter));
//                if(y>0){tabLayout.getTabAt(y-1).select();}

                for(iCount= 0; iCount < fragmentsList.size(); iCount++){
                    Log.d("Tablayout2", "FragmentList: " + fragmentsList.get(iCount));
                }
                tabCounter++;
                pageAdapter.notifyDataSetChanged();
                //tabLayout.getTabAt(tabLayout.getTabCount()-1).select();
            }
        });

        btnRemove = (Button)v.findViewById(R.id.btnRemove);
        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tabTitles.size() > 1){

                    x = tabTitles.size()-1;
                    tabTitles.remove(x);
                    fragmentsList.remove(x);
                    for(iCount= 0; iCount < fragmentsList.size(); iCount++){

                        Log.d("Tablayout2", "FragmentList: " + fragmentsList.get(iCount));
                    }
                    pageAdapter.notifyDataSetChanged();
                    //tabLayout.getTabAt(tabLayout.getTabCount()-1).select();
                }

            }
        });

        editText = (EditText) v.findViewById(R.id.editTextNumber);
        btnRemoveNumber = (Button)v.findViewById(R.id.btnRemoveNumber);
        btnRemoveNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editText.getText().toString() != null && !editText.getText().toString().equals("")) {
                    y = Integer.parseInt(editText.getText().toString());
                    if (y > 0 && y < tabTitles.size()) {
                        //tabLayout.getTabAt(y).select();
                        tabTitles.remove(y);
                        fragmentsList.remove(y);
                        for(iCount= 0; iCount < fragmentsList.size(); iCount++){
                            Log.d("Tablayout2", "FragmentList: " + fragmentsList.get(iCount));
                        }
                        pageAdapter.notifyDataSetChanged();
                    }
                }

            }
        });

        editTextInsert = (EditText)v.findViewById(R.id.editTextInsertNumber);
        insertBtn = (Button)v.findViewById(R.id.btnInsertNumber);
        insertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editTextInsert.getText().toString() != null && !editTextInsert.getText().toString().equals("")) {
                    y = Integer.parseInt(editTextInsert.getText().toString());
                    if (y > 0 && y < tabTitles.size()) {
                        tabTitles.add(Integer.valueOf(editTextInsert.getText().toString()), "Tab" + editTextInsert.getText());
                        fragmentsList.add(Integer.valueOf(editTextInsert.getText().toString()), Tab2.newInstance("Fragment " + editTextInsert.getText().toString()));
                        pageAdapter.notifyDataSetChanged();
                    }
                }

            }
        });

        return v;
    }
}
