package it.units.img_processing_studemt_app.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import it.units.img_processing_studemt_app.R;

public class DescriptionFragment extends Fragment {

    private String description;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_description, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        View view = getView();
        if(view != null) {
            TextView textView = (TextView) view.findViewById(R.id.text_desc);
            textView.setText(this.description);
        }
    }

    public void setDescription(String description) {
        this.description = description;
    }
}