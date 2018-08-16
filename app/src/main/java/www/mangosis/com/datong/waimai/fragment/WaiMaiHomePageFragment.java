package www.mangosis.com.datong.waimai.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import butterknife.Bind;
import butterknife.ButterKnife;
import www.mangosis.com.datong.R;
import www.mangosis.com.datong.pages.adapter.HomePageAdapter;
import www.mangosis.com.datong.tools.header.ClassicsHeader;
import www.mangosis.com.datong.waimai.adapter.WaiMaiAdapter;

/**
 * Created by admin on 2018/8/16.
 */

public class WaiMaiHomePageFragment extends Fragment {
    @Bind(R.id.recycle)
    RecyclerView recycle;
    @Bind(R.id.refresh)
    SmartRefreshLayout refresh;
    WaiMaiAdapter waiMaiAdapter;
    @Bind(R.id.et_search)
    EditText etSearch;
    private boolean isFirstEnter = true;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.waimai_homepage_fragment, container, false);
        ButterKnife.bind(this, view);
        etSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etSearch.setCursorVisible(true);
            }
        });
        initView();
        refreshAndLoadMore();
        return view;
    }
    private void initView() {
        waiMaiAdapter = new WaiMaiAdapter(getActivity());
        recycle.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        recycle.setAdapter(waiMaiAdapter);
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
        refresh.setRefreshHeader(new ClassicsHeader(getActivity()));
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
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
