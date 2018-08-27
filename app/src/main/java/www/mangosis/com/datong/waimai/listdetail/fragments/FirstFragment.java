package www.mangosis.com.datong.waimai.listdetail.fragments;


import android.os.Bundle;


import www.mangosis.com.datong.R;
import www.mangosis.com.datong.waimai.listdetail.Views.ListContainer;
import www.mangosis.com.datong.waimai.listdetail.WaiMaiListMainActivity;
import www.mangosis.com.datong.waimai.listdetail.adapters.FoodAdapter;
import www.mangosis.com.datong.waimai.listdetail.adapters.TypeAdapter;

import com.shizhefei.fragment.LazyFragment;

public class FirstFragment extends LazyFragment {

    private ListContainer listContainer;

    @Override
    protected void onCreateViewLazy(Bundle savedInstanceState) {
        super.onCreateViewLazy(savedInstanceState);
        setContentView(R.layout.fragment_first);
        listContainer = (ListContainer) findViewById(R.id.listcontainer);
        listContainer.setAddClick((WaiMaiListMainActivity) getActivity());
    }

    public FoodAdapter getFoodAdapter() {
        return listContainer.foodAdapter;
    }

    public TypeAdapter getTypeAdapter() {
        return listContainer.typeAdapter;
    }

}
