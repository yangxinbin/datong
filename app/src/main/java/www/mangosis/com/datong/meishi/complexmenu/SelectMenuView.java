package www.mangosis.com.datong.meishi.complexmenu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;



import java.util.ArrayList;
import java.util.List;

import www.mangosis.com.datong.R;
import www.mangosis.com.datong.meishi.complexmenu.holder.NearbyHolder;
import www.mangosis.com.datong.meishi.complexmenu.holder.SelectHolder;
import www.mangosis.com.datong.meishi.complexmenu.holder.SortHolder;
import www.mangosis.com.datong.meishi.complexmenu.holder.SubjectHolder;

/**
 * 搜索菜单栏
 * Created by vonchenchen on 2016/4/5 0005.
 */
public class SelectMenuView extends LinearLayout {

    private static final int TAB_SUBJECT = 1;
    private static final int TAB_NEARBY = 2;
    private static final int TAB_SORT = 3;
    private static final int TAB_SELECT = 4;

    private Context mContext;

    private View mSubjectView;
    private View mNearbyView;
    private View mSortView;
    private View mSelectView;

    private View mRootView;

    private View mPopupWindowView;

    private RelativeLayout mMainContentLayout;
    private View mBackView;

    /**
     * 全部分类
     */
    private SubjectHolder mSubjectHolder;
    /**
     * 附近
     */
    private NearbyHolder mNearbyHolder;
    /**
     * 智能排序
     */
    private SortHolder mSortHolder;
    /**
     * 筛选
     */
    private SelectHolder mSelectHolder;

    private OnMenuSelectDataChangedListener mOnMenuSelectDataChangedListener;

    private LinearLayout mContentLayout;

    private TextView mSubjectText;
    private ImageView mSubjectArrowImage;
    private TextView mNearbyText;
    private ImageView mNearbyArrowImage;
    private TextView mSortText;
    private ImageView mSortArrowImage;
    private TextView mSelectText;
    private ImageView mSelectArrowImage;

    private List<String> mGroupList1;
    private List<String> mList1_1;
    private List<String> mList1_2;
    private List<String> mList1_3;
    private List<List<String>> mSubjectDataList1;

    private List<String> mGroupList2;
    private List<String> mList2_1;
    private List<String> mList2_2;
    private List<String> mList2_3;
    private List<List<String>> mSubjectDataList2;

    private int mTabRecorder = -1;

    public SelectMenuView(Context context) {
        super(context);
        this.mContext = context;
        this.mRootView = this;
        init();
    }

    public SelectMenuView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        this.mRootView = this;
        init();
    }

    private void init() {

        mGroupList1 = new ArrayList<String>();
        mGroupList1.add("全部");
        mGroupList1.add("火锅");
        mGroupList1.add("烧烤烤肉");
        mGroupList1.add("自助餐");
        mGroupList1.add("小吃快餐");
        mGroupList1.add("日韩料理");
        mGroupList1.add("地方菜系");
        mGroupList1.add("甜点饮品");

        mList1_1 = new ArrayList<String>();
        mList1_1.add("全部1");
        mList1_1.add("全部2");
        mList1_1.add("全部3");
        mList1_2 = new ArrayList<String>();
        mList1_2.add("火锅1");
        mList1_2.add("火锅2");
        mList1_2.add("火锅3");
        mList1_2.add("火锅4");
        mList1_2.add("火锅5");
        mList1_2.add("火锅6");
        mList1_2.add("火锅7");
        mList1_2.add("火锅8");
        mList1_2.add("火锅9");
        mList1_3 = new ArrayList<String>();
        mList1_3.add("烧烤烤肉1");
        mList1_3.add("烧烤烤肉2");
        mList1_3.add("烧烤烤肉3");
        mList1_3.add("烧烤烤肉4");
        mList1_3.add("烧烤烤肉5");
        mList1_3.add("烧烤烤肉6");
        mList1_3.add("烧烤烤肉7");

        mSubjectDataList1 = new ArrayList<List<String>>();
        mSubjectDataList1.add(mGroupList1);
        mSubjectDataList1.add(mList1_1);
        mSubjectDataList1.add(mList1_2);
        mSubjectDataList1.add(mList1_3);


        mGroupList2 = new ArrayList<String>();
        mGroupList2.add("附近");
        mGroupList2.add("南山区");
        mGroupList2.add("龙岗区");
        mGroupList2.add("龙华区");
        mGroupList2.add("坪山区");

        mList2_1 = new ArrayList<String>();
        mList2_1.add("附近1");
        mList2_1.add("附近2");
        mList2_1.add("附近3");
        mList2_2 = new ArrayList<String>();
        mList2_2.add("南山区1");
        mList2_2.add("南山区2");
        mList2_2.add("南山区3");
        mList2_2.add("南山区4");
        mList2_2.add("南山区5");
        mList2_2.add("南山区6");
        mList2_2.add("南山区7");
        mList2_2.add("南山区8");
        mList2_2.add("南山区9");
        mList2_3 = new ArrayList<String>();
        mList2_3.add("龙岗区1");
        mList2_3.add("龙岗区2");
        mList2_3.add("龙岗区3");
        mList2_3.add("龙岗区4");
        mList2_3.add("龙岗区5");
        mList2_3.add("龙岗区6");
        mList2_3.add("龙岗区7");

        mSubjectDataList2 = new ArrayList<List<String>>();
        mSubjectDataList2.add(mGroupList2);
        mSubjectDataList2.add(mList2_1);
        mSubjectDataList2.add(mList2_2);
        mSubjectDataList2.add(mList2_3);

        //全部分类
        mSubjectHolder = new SubjectHolder(mContext);
        mSubjectHolder.refreshData(mSubjectDataList1, 0, -1);
        mSubjectHolder.setOnRightListViewItemSelectedListener(new SubjectHolder.OnRightListViewItemSelectedListener() {
            @Override
            public void OnRightListViewItemSelected(int leftIndex, int rightIndex, String text) {

                if (mOnMenuSelectDataChangedListener != null) {
                    int grade = leftIndex + 1;
                    int subject = getSubjectId(rightIndex);
                    mOnMenuSelectDataChangedListener.onSubjectChanged(grade + "", subject + "");
                }

                dismissPopupWindow();
                //Toast.makeText(UIUtils.getContext(), text, Toast.LENGTH_SHORT).show();
                mSubjectText.setText(text);
            }
        });

        //附近
        mNearbyHolder = new NearbyHolder(mContext);
        mNearbyHolder.refreshData(mSubjectDataList2, 0, -1);
        mNearbyHolder.setOnRightListViewItemSelectedListener(new NearbyHolder.OnRightListViewItemSelectedListener() {
            @Override
            public void OnRightListViewItemSelected(int leftIndex, int rightIndex, String text) {

                if (mOnMenuSelectDataChangedListener != null) {
                    int grade = leftIndex + 1;
                    int nearby = getSubjectId(rightIndex);
                    mOnMenuSelectDataChangedListener.onNearbyChanged(grade + "", nearby + "");
                }

                dismissPopupWindow();
                //Toast.makeText(UIUtils.getContext(), text, Toast.LENGTH_SHORT).show();
                mNearbyText.setText(text);
            }
        });

        //综合排序
        mSortHolder = new SortHolder(mContext);
        mSortHolder.setOnSortInfoSelectedListener(new SortHolder.OnSortInfoSelectedListener() {
            @Override
            public void onSortInfoSelected(String info) {

                if (mOnMenuSelectDataChangedListener != null) {
                    mOnMenuSelectDataChangedListener.onSortChanged(info);
                }

                dismissPopupWindow();
                mSortText.setText(getSortString(info));
                //Toast.makeText(UIUtils.getContext(), info, Toast.LENGTH_SHORT).show();
            }
        });

        //筛选
        mSelectHolder = new SelectHolder(mContext);
        mSelectHolder.setOnSelectedInfoListener(new SelectHolder.OnSelectedInfoListener() {
            @Override
            public void OnselectedInfo(String gender, String type) {

                if (mOnMenuSelectDataChangedListener != null) {
                    mOnMenuSelectDataChangedListener.onSelectedChanged(gender, type);
                }

                dismissPopupWindow();
                //Toast.makeText(UIUtils.getContext(), gender+" "+type, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private int getSubjectId(int index) {
        return index;
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        View.inflate(mContext, R.layout.layout_search_menu, this);

        mSubjectText = (TextView) findViewById(R.id.subject);
        mSubjectArrowImage = (ImageView) findViewById(R.id.img_sub);

        mNearbyText = (TextView) findViewById(R.id.ne);
        mNearbyArrowImage = (ImageView) findViewById(R.id.img_ne);

        mSortText = (TextView) findViewById(R.id.comprehensive_sorting);
        mSortArrowImage = (ImageView) findViewById(R.id.img_cs);

        mSelectText = (TextView) findViewById(R.id.tv_select);
        mSelectArrowImage = (ImageView) findViewById(R.id.img_sc);

        mContentLayout = (LinearLayout) findViewById(R.id.rl_content);

        mPopupWindowView = View.inflate(mContext, R.layout.layout_search_menu_content, null);
        mMainContentLayout = (RelativeLayout) mPopupWindowView.findViewById(R.id.rl_main);
        //mBackView = mPopupWindowView.findViewById(R.id.ll_background);

        mSubjectView = findViewById(R.id.ll_subject);
        mNearbyView = findViewById(R.id.ll_ne);
        mSortView = findViewById(R.id.ll_sort);
        mSelectView = findViewById(R.id.ll_select);

        //点击 全部分类 弹出菜单
        mSubjectView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnMenuSelectDataChangedListener != null) {
                    mOnMenuSelectDataChangedListener.onViewClicked(mSubjectView);
                }
                handleClickSubjectView();
            }
        });
        //点击 附近 弹出菜单
        mNearbyView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnMenuSelectDataChangedListener != null) {
                    mOnMenuSelectDataChangedListener.onViewClicked(mNearbyView);
                }
                handleClickNearbyView();
            }
        });
        //点击 智能排序 弹出菜单
        mSortView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnMenuSelectDataChangedListener != null) {
                    mOnMenuSelectDataChangedListener.onViewClicked(mSortView);
                }
                handleClickSortView();
            }
        });
        //点击 筛选 弹出菜单
        mSelectView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnMenuSelectDataChangedListener != null) {
                    mOnMenuSelectDataChangedListener.onViewClicked(mSelectView);
                }
                handleClickSelectView();
            }
        });

        mContentLayout.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                dismissPopupWindow();
            }
        });
    }

    public void setDropDownMemu(View contentView) {

    }

    private void handleClickSubjectView() {

        mMainContentLayout.removeAllViews();
        mMainContentLayout.addView(mSubjectHolder.getRootView(), ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

        popUpWindow(TAB_SUBJECT);
    }

    private void handleClickNearbyView() {

        mMainContentLayout.removeAllViews();
        mMainContentLayout.addView(mNearbyHolder.getRootView(), ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

        popUpWindow(TAB_NEARBY);
    }

    private void handleClickSortView() {

        mMainContentLayout.removeAllViews();
        mMainContentLayout.addView(mSortHolder.getRootView(), ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

        popUpWindow(TAB_SORT);
    }

    private void handleClickSelectView() {

        mMainContentLayout.removeAllViews();
        mMainContentLayout.addView(mSelectHolder.getRootView(), ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

        popUpWindow(TAB_SELECT);
    }

    private void popUpWindow(int tab) {
        if (mTabRecorder != -1) {
            resetTabExtend(mTabRecorder);
        }
        extendsContent();
        setTabExtend(tab);
        mTabRecorder = tab;
    }

    private void extendsContent() {
        mContentLayout.removeAllViews();
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        mContentLayout.addView(mPopupWindowView, params);
    }

    private void dismissPopupWindow() {
        mContentLayout.removeAllViews();
        setTabClose();
    }

    public void setOnMenuSelectDataChangedListener(OnMenuSelectDataChangedListener onMenuSelectDataChangedListener) {
        this.mOnMenuSelectDataChangedListener = onMenuSelectDataChangedListener;
    }

    public interface OnMenuSelectDataChangedListener {

        void onSubjectChanged(String grade, String subjects);

        void onNearbyChanged(String grade, String subjects);

        void onSortChanged(String sortType);

        void onSelectedChanged(String gender, String classType);

        void onViewClicked(View view);

        //筛选菜单，当点击其他处菜单收回后，需要更新当前选中项
        void onSelectedDismissed(String gender, String classType);
    }

    private void setTabExtend(int tab) {
        if (tab == TAB_SUBJECT) {
            mSubjectText.setTextColor(getResources().getColor(R.color.blue_meishi));
            mSubjectArrowImage.setImageResource(R.drawable.smallblue_triangle);
        } else if (tab == TAB_NEARBY) {
            mNearbyText.setTextColor(getResources().getColor(R.color.blue_meishi));
            mNearbyArrowImage.setImageResource(R.drawable.smallblue_triangle);
        } else if (tab == TAB_SORT) {
            mSortText.setTextColor(getResources().getColor(R.color.blue_meishi));
            mSortArrowImage.setImageResource(R.drawable.smallblue_triangle);
        } else if (tab == TAB_SELECT) {
            mSelectText.setTextColor(getResources().getColor(R.color.blue_meishi));
            mSelectArrowImage.setImageResource(R.drawable.smallblue_triangle);
        }
    }

    private void resetTabExtend(int tab) {
        if (tab == TAB_SUBJECT) {
            mSubjectText.setTextColor(getResources().getColor(R.color.grayText));
            mSubjectArrowImage.setImageResource(R.drawable.small_triangle);
        }else if (tab == TAB_NEARBY) {
            mNearbyText.setTextColor(getResources().getColor(R.color.grayText));
            mNearbyArrowImage.setImageResource(R.drawable.small_triangle);
        } else if (tab == TAB_SORT) {
            mSortText.setTextColor(getResources().getColor(R.color.grayText));
            mSortArrowImage.setImageResource(R.drawable.small_triangle);
        } else if (tab == TAB_SELECT) {
            mSelectText.setTextColor(getResources().getColor(R.color.grayText));
            mSelectArrowImage.setImageResource(R.drawable.small_triangle);
        }
    }

    private void setTabClose() {

        mSubjectText.setTextColor(getResources().getColor(R.color.text_color_gey));
        mSubjectArrowImage.setImageResource(R.drawable.small_triangle);

        mNearbyText.setTextColor(getResources().getColor(R.color.text_color_gey));
        mNearbyArrowImage.setImageResource(R.drawable.small_triangle);

        mSortText.setTextColor(getResources().getColor(R.color.text_color_gey));
        mSortArrowImage.setImageResource(R.drawable.small_triangle);

        mSelectText.setTextColor(getResources().getColor(R.color.text_color_gey));
        mSelectArrowImage.setImageResource(R.drawable.small_triangle);
    }

    private String getSortString(String info) {
        if (SortHolder.SORT_BY_1.equals(info)) {
            return "智能排序";
        } else if (SortHolder.SORT_BY_2.equals(info)) {
            return "离我最近";
        } else if (SortHolder.SORT_BY_3.equals(info)) {
            return "人气最高";
        } else if (SortHolder.SORT_BY_4.equals(info)) {
            return "评分最高";
        } else if (SortHolder.SORT_BY_5.equals(info)) {
            return "起送价最低";
        }
        return "智能排序";
    }

    public void clearAllInfo() {
        //清除控件内部选项
        mSubjectHolder.refreshData(mSubjectDataList1, 0, -1);
        mNearbyHolder.refreshData(mSubjectDataList2, 0, -1);
        mSortHolder.refreshView(null);
        mSelectHolder.refreshView(null);

        //清除菜单栏显示
        //mSubjectText.setText("type1");
        //mSortText.setText("智能排序");
    }
}