package wang.oo0oo.taobaoimitation.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import wang.oo0oo.taobaoimitation.CartAdapter;
import wang.oo0oo.taobaoimitation.R;
import wang.oo0oo.taobaoimitation.pojo.Goods;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ShoppingCartFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ShoppingCartFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ShoppingCartFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public ShoppingCartFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ShoppingCartFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ShoppingCartFragment newInstance(String param1, String param2) {
        ShoppingCartFragment fragment = new ShoppingCartFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_shopping_cart, container, false);
//    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }

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
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
    private RecyclerView recyclerView;
    private CartAdapter cartAdapter;
    private List<Goods> cartItems;
    private TextView totalPriceTextView;
    private Button removeAllButton;
    private static final String TAG = "ShoppingCartFragment";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_shopping_cart, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recycler_view_cart_items);
        totalPriceTextView = view.findViewById(R.id.text_view_total_price);
        removeAllButton = view.findViewById(R.id.button_remove_all);

        cartItems = new ArrayList<>();
        cartItems.add(new Goods("毛衣", 1,130.0, 1, R.drawable.hot_pic6));
        cartItems.add(new Goods("保健品", 2,288.0, 1, R.drawable.hot_pic7));
        cartItems.add(new Goods("零食大礼包", 3,50.0, 1, R.drawable.hot_pic8));

        // 打印cartItems列表
        for (Goods item : cartItems) {
            Log.d(TAG, "Item: " + item.getName() + ", Price: " + item.getPrice() + ", Quantity: " + item.getMonthlySales());
        }

        cartAdapter = new CartAdapter(getContext(), cartItems, new CartAdapter.OnItemRemoveListener() {
            @Override
            public void onItemRemove(int position) {
                cartItems.remove(position);
                cartAdapter.notifyItemRemoved(position);
                updateTotalPrice();
            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(cartAdapter);

        updateTotalPrice();

        removeAllButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cartItems.clear();
                cartAdapter.notifyDataSetChanged();
                updateTotalPrice();
            }
        });
    }

    private void updateTotalPrice() {
        double totalPrice = 0.0;
        for (Goods item : cartItems) {
            totalPrice += item.getPrice() * item.getMonthlySales();
        }
        totalPriceTextView.setText("总价: ¥" + totalPrice);
    }
}
