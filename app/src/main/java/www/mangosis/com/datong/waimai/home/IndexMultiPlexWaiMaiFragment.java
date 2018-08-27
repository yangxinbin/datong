package www.mangosis.com.datong.waimai.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import www.mangosis.com.datong.waimai.listdetail.WaiMaiListMainActivity;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import butterknife.Bind;
import butterknife.ButterKnife;
import www.mangosis.com.datong.R;
import www.mangosis.com.datong.waimai.adapter.WaiMaiListAdapter;
import www.mangosis.com.datong.waimai.complexmenu.SelectMenuView;


public class IndexMultiPlexWaiMaiFragment extends Fragment {
    View view = null;
    @Bind(R.id.selectMenuView)
    SelectMenuView selectMenuView;
    private SmartRefreshLayout refresh;
    private RecyclerView recycle;
    private LinearLayoutManager mLayoutManager;
    private WaiMaiListAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.index_recycler_multi_item_waimai, container, false);
        ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {
        View content = LayoutInflater.from(getActivity()).inflate(R.layout.recycler__items, null);
        refresh = content.findViewById(R.id.refresh);
        recycle = content.findViewById(R.id.recycle);
        content.setLayoutParams(new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT));
        selectMenuView.setDropDownMemu(content);
        recycle.setHasFixedSize(true);//固定宽高
        mLayoutManager = new LinearLayoutManager(getActivity());
        recycle.setLayoutManager(mLayoutManager);
        recycle.setItemAnimator(new DefaultItemAnimator());//设置默认动画
        adapter = new WaiMaiListAdapter(getActivity().getApplicationContext());
        adapter.setOnWaiMaiListClickListener(mOnItemClickListener);
        recycle.removeAllViews();
        recycle.setAdapter(adapter);
    }
    private WaiMaiListAdapter.OnWaiMaiListClickListener mOnItemClickListener;

    {
        mOnItemClickListener = new WaiMaiListAdapter.OnWaiMaiListClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(getActivity(), WaiMaiListMainActivity.class);
                startActivity(intent);
            }
        };
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

}
