package www.mangosis.com.datong.waimai.adapter;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import www.mangosis.com.datong.R;
import www.mangosis.com.datong.tools.RatingBar;
import www.mangosis.com.datong.waimai.bean.WaiMaiListBean;

/**
 * Created by admin on 2018/5/11.
 */

public class WaiMaiListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private OnWaiMaiListClickListener mOnWaiMaiListClickListener;//自注册的接口给调用者用于点击逻辑
    private List<WaiMaiListBean> mData = new ArrayList<>();
    private Handler mHandler = new Handler(Looper.getMainLooper()); //获取主线程的Handler

    public void setmDate(List<WaiMaiListBean> data) {
        this.mData = data;
        this.notifyDataSetChanged();
    }

    public void reMove() {
        List<WaiMaiListBean> m = new ArrayList<WaiMaiListBean>();
        this.mData = m;
        this.notifyDataSetChanged();
    }
    /**
     * 添加列表项     * @param item
     */
    public void addItem(WaiMaiListBean bean) {
        if (mData != null) {
            mData.add(bean);
        }
        this.notifyDataSetChanged();
    }

    public WaiMaiListAdapter(Context context) {
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.waimai_nice_item, parent, false);
            ItemViewHolder vh = new ItemViewHolder(v);
            return vh;

    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        final int pos = getRealPosition(holder);
        if (holder instanceof ItemViewHolder) {
            if (true) {
            }
        }
    }

    private int getRealPosition(RecyclerView.ViewHolder holder) {
        int position = holder.getLayoutPosition();
        return position;
    }

    @Override
    public int getItemCount() {
        return 8/*mData.size()*/;
    }

    public void setOnWaiMaiListClickListener(OnWaiMaiListClickListener onItemnewsClickListener) {
        this.mOnWaiMaiListClickListener = onItemnewsClickListener;
    }
    public WaiMaiListBean getItem(int position) {
        return mData == null ? null : mData.get(position);
    }

    public interface OnWaiMaiListClickListener {
        public void onItemClick(View view, int position);
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView txt_name, tx_time_far, txt_1,txt_site1,txt_site2;
        public ImageView pic_1,imageView_site1,imageView_site2;
        public RatingBar ratingBar;

        public ItemViewHolder(View v) {
            super(v);
            txt_name = (TextView) v.findViewById(R.id.txt_name);
            tx_time_far = (TextView) v.findViewById(R.id.tx_time_far);
            txt_1 = (TextView) v.findViewById(R.id.txt_1);
            txt_site1 = (TextView) v.findViewById(R.id.txt_site1);
            txt_site2 = (TextView) v.findViewById(R.id.txt_site2);

            pic_1 = (ImageView) v.findViewById(R.id.pic_1);
            imageView_site1 = (ImageView) v.findViewById(R.id.imageView_site1);
            imageView_site2 = (ImageView) v.findViewById(R.id.imageView_site2);

            ratingBar = (RatingBar) v.findViewById(R.id.rb);

            v.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mOnWaiMaiListClickListener != null) {
                mOnWaiMaiListClickListener.onItemClick(view, this.getLayoutPosition());
            }
        }
    }
}
