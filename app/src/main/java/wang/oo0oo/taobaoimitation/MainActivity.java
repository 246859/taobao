package wang.oo0oo.taobaoimitation;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import wang.oo0oo.taobaoimitation.fragment.FindFragment;
import wang.oo0oo.taobaoimitation.fragment.HomeFragment;
import wang.oo0oo.taobaoimitation.fragment.ShoppingCartFragment;
import wang.oo0oo.taobaoimitation.fragment.UserCenterFragment;

/**
 * TODO List:
 * 1、为商品添加点击事件【完成】
 * 2、制作商品详情页【80%】
 * 3、制作微淘（商品分类列表）页面【20%】
 * 4、制作发现（全部商品列表）页面
 * 5、制作购物车页面
 * 6、制作“我的”页面
 * 7、解决首页图片控件不滚动问题
 * 8、解决在首页添加其他几个图片按钮
 */
public class MainActivity extends AppCompatActivity {

    // 安排控件


    // 其他
    private static final String TAG = "MainActivity";
    private int lastIndex;
    List<Fragment> mFragments = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 获取各控件实例
        BottomNavigationView mNavView = findViewById(R.id.nav_view);

        // BottomNavigationView
        mNavView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        mNavView.setLabelVisibilityMode(1);
        initFragment();


    }

    /**
     * BottomNavigationView 的 Item 点击(Selected)事件监听器
     */
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    setFragmentPosition(0);
                    break;
                case R.id.navigation_find:
                    setFragmentPosition(1);
                    break;
                case R.id.navigation_shopping_cart:
                    setFragmentPosition(2);
                    break;
                case R.id.navigation_user_center:
                    setFragmentPosition(3);
                    break;
                default:
                    break;
            }
            return true;
        }
    };


    private void initFragment() {
        //setSupportActionBar(toolbar);
        mFragments.add(HomeFragment.newInstance(null, null));
        mFragments.add(FindFragment.newInstance(null, null));
        mFragments.add(ShoppingCartFragment.newInstance(null, null));
        mFragments.add(UserCenterFragment.newInstance(null, null));
        // 初始化展示MessageFragment
        setFragmentPosition(0);
    }




    private void setFragmentPosition(int position) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        Fragment currentFragment = mFragments.get(position);
        Fragment lastFragment = mFragments.get(lastIndex);
        lastIndex = position;
        ft.hide(lastFragment);
        if (!currentFragment.isAdded()) {
            getSupportFragmentManager().beginTransaction().remove(currentFragment).commit();
            ft.add(R.id.frame_layout, currentFragment);
        }
        ft.show(currentFragment);
        ft.commitAllowingStateLoss();
    }

//    private void setFragmentPosition(int position) {
//
//    }

}
