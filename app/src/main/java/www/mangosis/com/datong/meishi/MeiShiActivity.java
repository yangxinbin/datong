package www.mangosis.com.datong.meishi;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import butterknife.Bind;
import butterknife.ButterKnife;
import www.mangosis.com.datong.R;
import www.mangosis.com.datong.meishi.adapter.MeiShiAdapter;
import www.mangosis.com.datong.tools.header.ClassicsHeader;
import www.mangosis.com.datong.waimai.adapter.WaiMaiAdapter;

public class MeiShiActivity extends AppCompatActivity {

    @Bind(R.id.imageView_back)
    ImageView imageViewBack;
    @Bind(R.id.et_search)
    EditText etSearch;
    @Bind(R.id.et_delete)
    ImageView etDelete;
    @Bind(R.id.recycle)
    RecyclerView recycle;
    @Bind(R.id.refresh)
    SmartRefreshLayout refresh;
    private boolean isFirstEnter = true;
    MeiShiAdapter meiShiAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mei_shi);
        ButterKnife.bind(this);
        etSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etSearch.setCursorVisible(true);
            }
        });
        initView();
        refreshAndLoadMore();
    }

    private void initView() {
        meiShiAdapter = new MeiShiAdapter(this);
        recycle.setLayoutManager(new LinearLayoutManager(this));
        recycle.setAdapter(meiShiAdapter);
    }

    private void refreshAndLoadMore() {
        refresh.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull final RefreshLayout refreshLayout) {
                refreshLayout.getLayout().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        refreshLayout.finishRefresh();
                    }
                }, 500);
            }
        });
        refresh.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull final RefreshLayout refreshLayout) {
                refreshLayout.getLayout().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        refreshLayout.finishLoadMore();
                    }
                }, 500);
            }
        });
        refresh.setRefreshHeader(new ClassicsHeader(this));
        refresh.setHeaderHeight(50);

        //触发自动刷新
        if (isFirstEnter) {
            isFirstEnter = false;
            //refresh.autoRefresh();
        } else {
            //mAdapter.refresh(initData());
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }
}
