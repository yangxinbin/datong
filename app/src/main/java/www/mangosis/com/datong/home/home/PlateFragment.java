package www.mangosis.com.datong.home.home;

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


public class PlateFragment extends Fragment {
    GridView gridView;

    int[] res = {
            R.drawable.food,
            R.drawable.play,
            R.drawable.travel,
            R.drawable.shopping,
            R.drawable.supermarket,
            R.drawable.takeaway,};
    String[] titles = {"享美食", "享娱乐", "享旅游", "享购物", "享农超", "外卖"};

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
                if (position == 5) {
                    Intent intent = new Intent(getActivity(), WaiMaiActivity.class);
                    startActivity(intent);
                }

            }
        });
        return view;
    }
}
