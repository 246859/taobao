package wang.oo0oo.taobaoimitation.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import wang.oo0oo.taobaoimitation.GlideImageLoader;
import wang.oo0oo.taobaoimitation.GoodsAdapter;
import wang.oo0oo.taobaoimitation.R;
import wang.oo0oo.taobaoimitation.pojo.Goods;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link HomeFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private static final String TAG = "HomeFragment";
    List<Integer> bannerImages = new ArrayList<>();
    List<Goods> goodsList = new ArrayList<>();
    private GoodsAdapter adapter;

    private OnFragmentInteractionListener mListener;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
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
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    @Override
    public void onStart() {
        super.onStart();

        FragmentActivity view = Objects.requireNonNull(getActivity());

        // Banner
        initImages();
        Banner banner = view.findViewById(R.id.banner);
        if (banner != null) {
            // 设置图片加载器
            banner.setImageLoader(new GlideImageLoader());
            // 设置图片集合
            banner.setImages(bannerImages);
            banner.start();
        } else {
            Log.d(TAG, "onCreateView: Banner为NULL");
        }
        banner.setFocusable(true);
        banner.setFocusableInTouchMode(true);
        banner.requestFocus();

        // RecyclerView
        initGoodsList();
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view_home);
        GridLayoutManager layoutManager = new GridLayoutManager(view, 2);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new GoodsAdapter(goodsList);
        recyclerView.setAdapter(adapter);
    }

    private void initImages() {
        bannerImages.add(R.drawable.carousel_box61);
        bannerImages.add(R.drawable.carousel_box62);
        bannerImages.add(R.drawable.carousel_box63);
    }

    private void initGoodsList() {
        goodsList.clear();
        goodsList.add(new Goods("雪纺印花百皱裙半身裙,简约的线条和版型看上去很好看,整体更有看点", R.drawable.pic1, 115, 62, 0));
        goodsList.add(new Goods("时尚真皮女凉鞋 牛筋底中跟欧美潮鞋 2015夏个性森系女鞋子罗马鞋", R.drawable.pic2, 90, 66, 0));
        goodsList.add(new Goods("藤雷达椅 太阳椅 藤椅躺椅 午睡藤椅 太阳躺椅 懒人月亮椅", R.drawable.pic3, 320, 14, 10));
        goodsList.add(new Goods("一件漂亮的软纱公主裙，配上一双白色高跟鞋子，又美丽又简单。", R.drawable.pic4, 90, 66, 0));
        goodsList.add(new Goods("自制果冻布甸 餐厅专供原料 夏天美食，草莓味", R.drawable.pic5, 21, 236, 0));

        goodsList.add(new Goods("雪纺印花百皱裙半身裙,简约的线条和版型看上去很好看,整体更有看点", R.drawable.pic1, 115, 62, 0));
        goodsList.add(new Goods("时尚真皮女凉鞋 牛筋底中跟欧美潮鞋 2015夏个性森系女鞋子罗马鞋", R.drawable.pic2, 90, 66, 0));
        goodsList.add(new Goods("藤雷达椅 太阳椅 藤椅躺椅 午睡藤椅 太阳躺椅 懒人月亮椅", R.drawable.pic3, 320, 14, 10));
        goodsList.add(new Goods("一件漂亮的软纱公主裙，配上一双白色高跟鞋子，又美丽又简单。", R.drawable.pic4, 90, 66, 0));
        goodsList.add(new Goods("自制果冻布甸 餐厅专供原料 夏天美食，草莓味", R.drawable.pic5, 21, 236, 0));

        goodsList.add(new Goods("雪纺印花百皱裙半身裙,简约的线条和版型看上去很好看,整体更有看点", R.drawable.pic1, 115, 62, 0));
        goodsList.add(new Goods("时尚真皮女凉鞋 牛筋底中跟欧美潮鞋 2015夏个性森系女鞋子罗马鞋", R.drawable.pic2, 90, 66, 0));
        goodsList.add(new Goods("藤雷达椅 太阳椅 藤椅躺椅 午睡藤椅 太阳躺椅 懒人月亮椅", R.drawable.pic3, 320, 14, 10));
        goodsList.add(new Goods("一件漂亮的软纱公主裙，配上一双白色高跟鞋子，又美丽又简单。", R.drawable.pic4, 90, 66, 0));
        goodsList.add(new Goods("自制果冻布甸 餐厅专供原料 夏天美食，草莓味", R.drawable.pic5, 21, 236, 0));

        goodsList.add(new Goods("雪纺印花百皱裙半身裙,简约的线条和版型看上去很好看,整体更有看点", R.drawable.pic1, 115, 62, 0));
        goodsList.add(new Goods("时尚真皮女凉鞋 牛筋底中跟欧美潮鞋 2015夏个性森系女鞋子罗马鞋", R.drawable.pic2, 90, 66, 0));
        goodsList.add(new Goods("藤雷达椅 太阳椅 藤椅躺椅 午睡藤椅 太阳躺椅 懒人月亮椅", R.drawable.pic3, 320, 14, 10));
        goodsList.add(new Goods("一件漂亮的软纱公主裙，配上一双白色高跟鞋子，又美丽又简单。", R.drawable.pic4, 90, 66, 0));
        goodsList.add(new Goods("自制果冻布甸 餐厅专供原料 夏天美食，草莓味", R.drawable.pic5, 21, 236, 0));
    }
}
