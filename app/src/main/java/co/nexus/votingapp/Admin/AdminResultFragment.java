package co.nexus.votingapp.Admin;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import co.nexus.votingapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AdminResultFragment extends Fragment {


    public AdminResultFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_admin_result, container, false);
    }

}