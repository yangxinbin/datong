package www.mangosis.com.datong.home.home;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.OnClick;
import www.mangosis.com.datong.R;


public class IndexRecommendFragment extends Fragment {
    View view = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.index_recycler_recommend_item, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick({R.id.recommend_first_image, R.id.recommend_second_image, R.id.recommend_third_image, R.id.recommend_forth_image, R.id.recommend_fifth_image})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.recommend_first_image:
                break;
            case R.id.recommend_second_image:
                break;
            case R.id.recommend_third_image:
                break;
            case R.id.recommend_forth_image:
                break;
            case R.id.recommend_fifth_image:
                break;
        }
    }
}
