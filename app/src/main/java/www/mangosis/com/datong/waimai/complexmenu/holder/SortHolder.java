package www.mangosis.com.datong.waimai.complexmenu.holder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import java.util.List;

import www.mangosis.com.datong.R;

/**
 *
 * 综合排序
 * Created by vonchenchen on 2016/4/5 0005.
 */
public class SortHolder extends BaseWidgetHolder<List<String>> {

    /** 智能排序 */
    public static final String SORT_BY_1 = "";
    /** 离我最近 */
    public static final String SORT_BY_2 = "2";
    /** 人气最高 */
    public static final String SORT_BY_3 = "3";
    /** 评分最高 */
    public static final String SORT_BY_4 = "4";
    /** 起送价最低 */
    public static final String SORT_BY_5 = "5";

    /** 智能排序 */
    private View p1;
    /** 离我最近 */
    private View p2;
    /** 人气最高 */
    private View p3;
    /** 评分最高 */
    private View p4;
    /** 起送价最低 */
    private View p5;

    private ImageView mRecordImageView;
    private ImageView m1;
    private ImageView m2;
    private ImageView m3;
    private ImageView m4;
    private ImageView m5;

    private OnSortInfoSelectedListener mOnSortInfoSelectedListener;

    public SortHolder(Context context) {
        super(context);
    }

    @Override
    public View initView() {

        View view = View.inflate(mContext, R.layout.layout_holder_sort, null);

        p1 = view.findViewById(R.id.re_sort1);
        p2 = view.findViewById(R.id.re_sort2);
        p3 = view.findViewById(R.id.re_sort4);
        p4 = view.findViewById(R.id.re_sort5);
        p5 = view.findViewById(R.id.re_sort6);

        m1 = (ImageView) view.findViewById(R.id.img_sort1);
        m2 = (ImageView) view.findViewById(R.id.img_sort2);
        m3 = (ImageView) view.findViewById(R.id.img_sort4);
        m4 = (ImageView) view.findViewById(R.id.img_sort5);
        m5 = (ImageView) view.findViewById(R.id.img_sort6);

        //综合排序
        p1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                retSortInfo(SORT_BY_1, m1);
            }
        });

        //评价最高
        p2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                retSortInfo(SORT_BY_2, m2);
            }
        });

        //价格最低
        p3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                retSortInfo(SORT_BY_3, m3);
            }
        });

        //价格最高
        p4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                retSortInfo(SORT_BY_4, m4);
            }
        });
        //离我最近
        p5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                retSortInfo(SORT_BY_5, m5);
            }
        });

        return view;
    }

    @Override
    public void refreshView(List<String> data) {
        m1.setVisibility(View.INVISIBLE);
        m2.setVisibility(View.INVISIBLE);
        m3.setVisibility(View.INVISIBLE);
        m4.setVisibility(View.INVISIBLE);
        m5.setVisibility(View.INVISIBLE);
    }

    private void retSortInfo(String info, ImageView imageView){

        if(mRecordImageView != null){
            mRecordImageView.setVisibility(View.INVISIBLE);
        }
        mRecordImageView = imageView;

        imageView.setVisibility(View.VISIBLE);

        if(mOnSortInfoSelectedListener != null){
            mOnSortInfoSelectedListener.onSortInfoSelected(info);
        }
    }

    public void setOnSortInfoSelectedListener(OnSortInfoSelectedListener onSortInfoSelectedListener){
        this.mOnSortInfoSelectedListener = onSortInfoSelectedListener;
    }

    public interface OnSortInfoSelectedListener{
        void onSortInfoSelected(String info);
    }
}
