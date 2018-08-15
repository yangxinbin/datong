package www.mangosis.com.datong;

import android.os.Bundle;
import android.view.KeyEvent;

import www.mangosis.com.datong.base.BaseActivity;
import www.mangosis.com.datong.pages.DaTongFragment;
import www.mangosis.com.datong.pages.GroupFragment;
import www.mangosis.com.datong.pages.HomePageFragment;
import www.mangosis.com.datong.pages.OrderFragment;
import www.mangosis.com.datong.pages.PersonalFragment;
import www.mangosis.com.datong.view.BottomBar;

public class DaTongActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_da_tong);
        BottomBar bottomBar = (BottomBar) findViewById(R.id.bottom_bar);
        bottomBar.setContainer(R.id.container)
                .setTitleBeforeAndAfterColor("#333333", "#1698FD")
                .addItem(HomePageFragment.class,
                        "主页",
                        R.drawable.home,
                        R.drawable.home2)
                .addItem(GroupFragment.class,
                        "拼团",
                        R.drawable.group,
                        R.drawable.group2)
                .addItem(DaTongFragment.class,
                        "大同风情",
                        R.drawable.datong,
                        R.drawable.datong2)
                .addItem(OrderFragment.class,
                        "订单",
                        R.drawable.order,
                        R.drawable.order2)
                .addItem(PersonalFragment.class,
                        "我的",
                        R.drawable.my,
                        R.drawable.my2)
                .build();
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            return false; //返回交给fragment
        }
        return super.onKeyDown(keyCode, event);
    }
}
