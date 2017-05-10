package com.example.abdul_wahab.assignment3spring2017;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;


public class ContactFragment extends Fragment {
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "cinfo";
    private String mParam1;
    private Contact contact;

    public static ContactFragment newInstance(Contact contact) {
        ContactFragment fragment = new ContactFragment();
        Bundle args = new Bundle();

        Gson gson = new Gson();

        // args.putSerializable(ARG_PARAM1,contact);

        args.putString(ARG_PARAM1, gson.toJson(contact));
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
    Gson gson = new Gson();
    this.contact = gson.fromJson(mParam1, Contact.class);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_contact, container, false);

        TextView txtContactID = (TextView) view.findViewById(R.id.txtContactID);
        TextView txtContactName = (TextView) view.findViewById(R.id.txtContactName);
        ImageView imgDisplay = (ImageView) view.findViewById(R.id.imgDisplay);

        txtContactID.setText("id = " + contact.id);
        txtContactName.setText("name  = " + contact.name);

        return view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}
