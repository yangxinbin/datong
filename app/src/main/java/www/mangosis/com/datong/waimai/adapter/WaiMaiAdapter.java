package www.mangosis.com.datong.waimai.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.zhy.android.percent.support.PercentLinearLayout;

import java.util.ArrayList;
import java.util.List;

import www.mangosis.com.datong.R;
import www.mangosis.com.datong.home.entity.ImageDeal;
import www.mangosis.com.datong.tools.GlideImageLoader;


public class WaiMaiAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;

    private int[] hotPlaceHidePosition = {5, 7};
    //type
    public static final int TYPE_CIRCLER_SHOW = 0;
    public static final int TYPE_BANNER = 1;
    //public static final int TYPE_RECOMMEND_ACTIVITY = 2;
    public static final int TYPE_NEARBY_ACTIVITY = 2;
    public static final int TYPE_HOT_ACTIVITY = 3;
    private List<String> banner_images = new ArrayList<>();

    public WaiMaiAdapter(Context context) {
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case TYPE_CIRCLER_SHOW:
                return new CirclerShowViewHolder(LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.index_recycler_circler_waimai_show, parent, false));
            case TYPE_BANNER:
                return new BannerViewHolder(LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.index_recycler_banner, parent, false));
/*            case TYPE_RECOMMEND_ACTIVITY:
                return new RecommendViewHolder(LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.index_recycler_recommend, parent, false));*/
            case TYPE_NEARBY_ACTIVITY:
                return new RecommendViewHolder(LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.index_recycler_area, parent, false));
            case TYPE_HOT_ACTIVITY:
/*                return new PopularPlacesViewHolder(LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.homepage_nice_item, parent, false));*/
                return new MultiPlexViewHolder(LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.index_recycler_multiplex_waimai, parent, false));
            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof BannerViewHolder) {
            ImageDeal imageDeal = new ImageDeal(context);
            banner_images = imageDeal.getBanner_images();
            List<String> pathsTitle = new ArrayList<>();
            for (int i = 0; i < banner_images.size(); i++) {
                pathsTitle.add("");
            }
            ((BannerViewHolder) holder).banner.setImages(banner_images)
                    .setBannerTitles(pathsTitle)
                    .setBannerStyle(BannerConfig.CIRCLE_INDICATOR)
                    .setImageLoader(new GlideImageLoader())
                    .setDelayTime(5000)
                    // .setOnBannerClickListener(this)
                    .start();
        } else if (holder instanceof CirclerShowViewHolder) {

        } else if (holder instanceof RecommendViewHolder) {

        } else if (holder instanceof NearbyViewHolder) {

        } else if (holder instanceof PopularPlacesViewHolder) {

        }

    }


    @Override
    public void onAttachedToRecyclerView(final RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        //Toast.makeText(context, "onAttachedToRecyclerView", Toast.LENGTH_SHORT).show();
        RecyclerView.LayoutManager manager = recyclerView.getLayoutManager();
        if (manager instanceof GridLayoutManager) {
            Toast.makeText(context, "manager instanceof GridLayoutManager", Toast.LENGTH_SHORT).show();
            final GridLayoutManager gridManager = ((GridLayoutManager) manager);
            gridManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    int type = getItemViewType(position);
                    switch (type) {
                        case TYPE_BANNER:
                        case TYPE_CIRCLER_SHOW:
                        //case TYPE_RECOMMEND_ACTIVITY:
                        case TYPE_NEARBY_ACTIVITY:
                            return gridManager.getSpanCount();
                        default:
                            return 1;
                    }
                }
            });
        }

    }


    @Override
    public int getItemCount() {
        return 4;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_CIRCLER_SHOW;
        } else if (position == 1) {
            return TYPE_BANNER;
        } /*else if (position == 2) {
            return TYPE_RECOMMEND_ACTIVITY;
        }*/ else if (position == 2) {
            return TYPE_NEARBY_ACTIVITY;
        } else {
            return TYPE_HOT_ACTIVITY;
        }
    }

    /*
    * 轮播的viewholder
    * */
    public class BannerViewHolder extends RecyclerView.ViewHolder {
        public Banner banner;

        public BannerViewHolder(View itemView) {
            super(itemView);
            banner = (Banner) itemView.findViewById(R.id.index_banner);
        }
    }

    /*
    * 第二栏所有活动圆形按钮的viewholder
    * */
    public class CirclerShowViewHolder extends RecyclerView.ViewHolder {
        public PercentLinearLayout index_circler_show;
        public CardView cardView;

        public CirclerShowViewHolder(View itemView) {
            super(itemView);
            index_circler_show = (PercentLinearLayout) itemView.findViewById(R.id.index_recycler_circler_show);
            cardView = (CardView) index_circler_show.findViewById(R.id.index_circleshow_cardview);
        }
    }
    /*
    * 推荐活动的viewholder
    * */
    public class MultiPlexViewHolder extends RecyclerView.ViewHolder {

        ImageView imageview;

        public MultiPlexViewHolder(View itemView) {
            super(itemView);
            imageview = (ImageView) itemView.findViewById(R.id.recommend_second_image);
        }
    }

    /*
    * 推荐活动的viewholder
    * */
    public class RecommendViewHolder extends RecyclerView.ViewHolder {

        ImageView imageview;

        public RecommendViewHolder(View itemView) {
            super(itemView);
            imageview = (ImageView) itemView.findViewById(R.id.recommend_second_image);
        }
    }

    /*
    * 推荐附近的viewholder
    * */
    public class NearbyViewHolder extends RecyclerView.ViewHolder {

        ImageView imageview;

        public NearbyViewHolder(View itemView) {
            super(itemView);
            imageview = (ImageView) itemView.findViewById(R.id.recommend_second_image);
        }
    }

    /*
    * 热门场所的viewholder
    * */

    public class PopularPlacesViewHolder extends RecyclerView.ViewHolder {
        LinearLayout list_item;
        ImageView pic_1;
        TextView txt_name, tx_money, txt_what, txt_place, tx_far;

        public PopularPlacesViewHolder(View itemView) {
            super(itemView);
            list_item = (LinearLayout) itemView.findViewById(R.id.list_item);
            pic_1 = (ImageView) itemView.findViewById(R.id.pic_1);
            txt_name = (TextView) itemView.findViewById(R.id.txt_name);
            tx_money = (TextView) itemView.findViewById(R.id.tx_money);
            txt_what = (TextView) itemView.findViewById(R.id.txt_what);
            txt_place = (TextView) itemView.findViewById(R.id.txt_place);
            tx_far = (TextView) itemView.findViewById(R.id.tx_far);

        }
    }
}
