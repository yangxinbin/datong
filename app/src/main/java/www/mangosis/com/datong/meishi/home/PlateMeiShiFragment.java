package www.mangosis.com.datong.meishi.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

import www.mangosis.com.datong.R;
import www.mangosis.com.datong.waimai.WaiMaiActivity;


public class PlateMeiShiFragment extends Fragment {
    GridView gridView;

    int[] res = {
            R.drawable.hot_pot,
            R.drawable.barbecue,
            R.drawable.buffet,
            R.drawable.fast_food,
            R.drawable.western_food,
            R.drawable.japanese_food,
            R.drawable.local_food,
            R.drawable.dessert};
    String[] titles = {"火锅", "烧烤烤肉", "自助餐", "小吃快餐", "西餐", "日韩料理", "地方菜系", "甜点饮品"};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.grid, container, false);
        gridView = (GridView) view.findViewById(R.id.gridview);
        ArrayList<HashMap<String, Object>> item = new ArrayList<HashMap<String, Object>>();
        for (int i = 0; i < res.length; i++) {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("itemImage", res[i]);
            map.put("itemName", titles[i]);
            item.add(map);
        }

        SimpleAdapter simpleAdapter = new SimpleAdapter(getActivity(), item, R.layout.grid_content,
                new String[]{"itemImage", "itemName"}, new int[]{R.id.image, R.id.text});

        gridView.setAdapter(simpleAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(getContext(),titles[position], Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), WaiMaiActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
}
