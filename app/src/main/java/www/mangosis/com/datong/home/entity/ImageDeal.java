package www.mangosis.com.datong.home.entity;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.DrawableRes;

import java.util.ArrayList;
import java.util.List;

import www.mangosis.com.datong.R;

/**
 * load pic from internet
 */

public class ImageDeal {
    private static List<String> banner_images = new ArrayList<>();
    private volatile static ImageDeal imageDeal;
    private Context mContext;
    public ImageDeal(Context context) {
        this.mContext = context;
        banner_images.clear();
    }
    public List<String> getBanner_images() {
        banner_images.add(getResourcesUri(R.drawable.banner));
        banner_images.add(getResourcesUri(R.drawable.banner));
        banner_images.add(getResourcesUri(R.drawable.banner));
        return banner_images;
    }
    private String getResourcesUri(@DrawableRes int id) {
        Resources resources = mContext.getResources();
        String uriPath = ContentResolver.SCHEME_ANDROID_RESOURCE + "://" +
                resources.getResourcePackageName(id) + "/" +
                resources.getResourceTypeName(id) + "/" +
                resources.getResourceEntryName(id);
        return uriPath;
    }
}
