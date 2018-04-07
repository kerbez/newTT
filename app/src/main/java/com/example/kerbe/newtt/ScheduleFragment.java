package com.example.kerbe.newtt;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;


public class ScheduleFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    KlassDbHelper db = new KlassDbHelper(getActivity());
    Context context;
    ListView sch_list;
    ArrayList<Klass> data;
    private  static Schedule_item_adapter adapter;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    FloatingActionButton fab;

    private  ScheduleFragment.OnFragmentInteractionListener mListener;

    public ScheduleFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ScheduleFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ScheduleFragment newInstance(String param1, String param2) {

        ScheduleFragment fragment = new ScheduleFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getActivity();
        Log.d("in oncreate", "context = " + context);


        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             final Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_schedule, container, false);
        data = db.getAllKlass();
        fab =  view.findViewById(R.id.fab);
        sch_list = view.findViewById(R.id.sch_list);
        /*fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddFragment f = new AddFragment();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.frame_container, f);
                ft.addToBackStack(null);
                ft.commit();

            }
        });*/

        adapter = new Schedule_item_adapter(data, getActivity().getApplicationContext());
        sch_list.setAdapter(adapter);
        sch_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Klass klass = data.get(i);
                Log.d("item_clicked",klass.getId() + " " + klass.getSubject() + " "  + klass.getTeacher());
            }
        });
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{

            Log.d("onAttach", "works");
            mListener = (ScheduleFragment.OnFragmentInteractionListener) context;
        }catch (ClassCastException e){

            Log.d("onAttach", "guess sth get wrong");
            throw new ClassCastException(context.toString());
        }
        /*if (context instanceof ScheduleFragment.OnFragmentInteractionListener) {
            mListener = (ScheduleFragment.OnFragmentInteractionListener) context;
        } else {
            Log.d("onAttach", "guess sth get wrong");
//            throw new RuntimeException(context.toString()
 //                   + " must implement OnFragmentInteractionListener");
        }*/

       /* try{
            mListener = (OnFragmentInteractionListener) activity;
        }catch (ClassCastException e){
            Log.d("onAttach", "guess sth get wrong");
            throw new ClassCastException(activity.toString()
                    + " must implement OnHeadlineSelectedListener");

        }*/
    }


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }


}
