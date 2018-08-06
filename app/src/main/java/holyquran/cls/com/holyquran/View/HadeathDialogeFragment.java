package holyquran.cls.com.holyquran.View;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import holyquran.cls.com.holyquran.Model.HadeathItem;
import holyquran.cls.com.holyquran.R;

/**
 * Created by CLS on 8/6/2018.
 */

public class HadeathDialogeFragment extends DialogFragment {

    public static HadeathItem hadeathItem;
       @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View v = inflater.inflate(R.layout.hadeath_dialog_fragment, container, false);

            TextView content=v.findViewById(R.id.content);
            String AllLines="";
            for (int i=0;i<hadeathItem.getAllLines().size();i++)
                AllLines=AllLines+hadeathItem.getAllLines().get(i)+"\n";

            content.setText(AllLines);

            // Do all the stuff to initialize your custom view

            return v;
        }

}
