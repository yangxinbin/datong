package www.mangosis.com.datong.pages.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.zhy.android.percent.support.PercentLinearLayout;

import java.util.ArrayList;
import java.util.List;

import www.mangosis.com.datong.R;
import www.mangosis.com.datong.pages.entity.ImageDeal;
import www.mangosis.com.datong.tools.GlideImageLoader;


public class HomePageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;

    private int[] hotPlaceHidePosition = {5, 7};
    //type
    public static final int TYPE_BANNER = 0;
    public static final int TYPE_CIRCLER_SHOW = 1;
    public static final int TYPE_RECOMMEND_ACTIVITY = 2;
    public static final int TYPE_NEARBY_ACTIVITY = 3;
    public static final int TYPE_HOT_ACTIVITY = 4;
    private List<String> banner_images = new ArrayList<>();

    public HomePageAdapter(Context context) {
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case TYPE_BANNER:
                return new BannerViewHolder(LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.index_recycler_banner, parent, false));
            case TYPE_CIRCLER_SHOW:
                return new CirclerShowViewHolder(LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.index_recycler_circler_show, parent, false));
            case TYPE_RECOMMEND_ACTIVITY:
                return new RecommendViewHolder(LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.index_recycler_recommend, parent, false));
            case TYPE_NEARBY_ACTIVITY:
                return new RecommendViewHolder(LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.index_recycler_nearby, parent, false));
            case TYPE_HOT_ACTIVITY:
                return new PopularPlacesViewHolder(LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.index_recycler_popular_places_item, parent, false));
            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof BannerViewHolder) {
            ImageDeal imageDeal = new ImageDeal(context);
            banner_images.clear();
            banner_images = imageDeal.getBanner_images();
            List<String> pathsTitle = new ArrayList<>();
            for (int i = 0; i < banner_images.size(); i++) {
                pathsTitle.add("");
            }
            ((BannerViewHolder) holder).banner.setImages(banner_images)
                    .setBannerTitles(pathsTitle)
                    .setBannerStyle(BannerConfig.CIRCLE_INDICATOR)
                    .setImageLoader(new GlideImageLoader())
                    // .setOnBannerClickListener(this)
                    .start();
        } else if (holder instanceof CirclerShowViewHolder) {

        } else if (holder instanceof RecommendViewHolder) {

        } else if (holder instanceof NearbyViewHolder) {

        } else if (holder instanceof PopularPlacesViewHolder) {
            ((PopularPlacesViewHolder) holder).hot_title_place.setVisibility(View.VISIBLE);
            if (position != 4)
                ((PopularPlacesViewHolder) holder).hot_title_place.setVisibility(View.GONE);

            ((PopularPlacesViewHolder) holder).stop_car_sign.setVisibility(View.VISIBLE);
            for (int i = 0; i < hotPlaceHidePosition.length; i++) {
                if (position == hotPlaceHidePosition[i]) {

                    ((PopularPlacesViewHolder) holder).stop_car_sign.setVisibility(View.INVISIBLE);
                }
            }
            Glide.with(context).load("http://img.taopic.com/uploads/allimg/130612/318764-1306120IZ443.jpg")
                    .into(((PopularPlacesViewHolder) holder).hot_back);
        }

    }


    @Override
    public void onAttachedToRecyclerView(final RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        Toast.makeText(context, "onAttachedToRecyclerView", Toast.LENGTH_SHORT).show();
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
                        case TYPE_RECOMMEND_ACTIVITY:
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
        return 10;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_BANNER;
        } else if (position == 1) {
            return TYPE_CIRCLER_SHOW;
        } else if (position == 2) {
            return TYPE_RECOMMEND_ACTIVITY;
        } else if (position == 3) {
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
        PercentLinearLayout hot_title_place;
        ImageView stop_car_sign, hot_back;

        public PopularPlacesViewHolder(View itemView) {
            super(itemView);
            hot_title_place = (PercentLinearLayout) itemView.findViewById(R.id.hot_title_place);
            stop_car_sign = (ImageView) itemView.findViewById(R.id.stop_car_sign);
            hot_back = (ImageView) itemView.findViewById(R.id.hot_back_img);
        }
    }


}
