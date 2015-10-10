package arthur.mobileapps.com.vendingmachine.ui.views;

import android.app.Activity;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import arthur.mobileapps.com.vendingmachine.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ScreenSlideFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ScreenSlideFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ScreenSlideFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_HEADING = "heading";
    private static final String ARG_CONTENT = "content";

    // TODO: Rename and change types of parameters
    private String mHeading;
    private String mContent;

    private OnFragmentInteractionListener mListener;


    private RelativeLayout relativeLayoutParent;
    private TextView contentTV;


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ScreenSlideFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ScreenSlideFragment newInstance(String param1, String param2) {
        ScreenSlideFragment fragment = new ScreenSlideFragment();
        Bundle args = new Bundle();
        args.putString(ARG_HEADING, param1);
        args.putString(ARG_CONTENT, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public ScreenSlideFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mHeading = getArguments().getString(ARG_HEADING);
            mContent = getArguments().getString(ARG_CONTENT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        ViewGroup  rootView= (ViewGroup) inflater.inflate(R.layout.fragment_screen_slide,container,false);
        relativeLayoutParent=(RelativeLayout)rootView.findViewById(R.id.parent_layout);
        contentTV=(TextView)rootView.findViewById(R.id.tv_content_info);

        int red=(int)(Math.random()*255);
        int green=(int)(Math.random()*255);
        int blue=(int)(Math.random()*255);
        relativeLayoutParent.setBackgroundColor(Color.rgb(red,green,blue));

        contentTV.setText(mContent);

        return rootView;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

}
