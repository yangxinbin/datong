package www.mangosis.com.datong.waimai;

import android.os.Bundle;
import android.view.KeyEvent;

import www.mangosis.com.datong.R;
import www.mangosis.com.datong.base.BaseActivity;
import www.mangosis.com.datong.view.BottomBar;
import www.mangosis.com.datong.waimai.fragment.WaiMaiHomePageFragment;
import www.mangosis.com.datong.waimai.fragment.WaiMaiOrderFragment;
import www.mangosis.com.datong.waimai.fragment.WaiMaiPersonalFragment;

public class WaiMaiActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wai_mai);
        BottomBar bottomBar = (BottomBar) findViewById(R.id.waimai_bottom_bar);
        bottomBar.setContainer(R.id.waimai_container)
                .setTitleBeforeAndAfterColor("#333333", "#1698FD")
                .addItem(WaiMaiHomePageFragment.class,
                        "主页",
                        R.drawable.takeaway_home,
                        R.drawable.takeaway_home1)
                .addItem(WaiMaiOrderFragment.class,
                        "订单",
                        R.drawable.takeaway_order,
                        R.drawable.takeaway_order1)
                .addItem(WaiMaiPersonalFragment.class,
                        "我的",
                        R.drawable.takeaway_my,
                        R.drawable.takeaway_my1)
                .build();
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
/*            Intent intent = new Intent(this, DaTongActivity.class);
            startActivity(intent);*/
            finish();
            return false; //返回交给fragment
        }
        return super.onKeyDown(keyCode, event);
    }

}
