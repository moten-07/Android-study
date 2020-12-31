package com.example.class17_2;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    boolean isTwo;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{

        public class ViewHolder extends RecyclerView.ViewHolder {
            TextView listname;
            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                listname=itemView.findViewById(R.id.list_name);
            }
        }

        List<goodsList> list;
        public MyAdapter(List <goodsList> list){
            this.list=list;
        }

        @NonNull
        @Override
        public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
            final ViewHolder holder=new ViewHolder(view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    goodsList item=list.get(holder.getAdapterPosition());
                    if (isTwo){
                        contentFragment fragment=(contentFragment) getFragmentManager().findFragmentById(R.id.fragment2);
                        fragment.refersh(item.getImg());

                    }else {
                        Intent intent=new Intent(getActivity(),content.class);
                        intent.putExtra("img",item.getImg());
                        startActivity(intent);
                    }
                }
            });
            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull MyAdapter.ViewHolder holder, int position) {
            goodsList goods=list.get(position);
            holder.listname.setText(goods.getName());
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

    }


    public ListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ListFragment newInstance(String param1, String param2) {
        ListFragment fragment = new ListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_list, container, false);
        RecyclerView recyclerView=view.findViewById(R.id.goodlist);
        LinearLayoutManager manager=new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(manager);
        MyAdapter adapter=new MyAdapter(getList());
        recyclerView.setAdapter(adapter);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if(getActivity().findViewById(R.id.fragment2)!=null){// 判断屏幕模式
            isTwo=true;
        }else{
            isTwo=false;
        }
    }

    public List<goodsList> getList(){
        List<goodsList> listset=new ArrayList<>();
        goodsList item1=new goodsList();
        item1.setName("畅销女装");
        item1.setImg(R.mipmap.nz);
        listset.add(item1);
        goodsList item2=new goodsList();
        item2.setName("爆款男装");
        item2.setImg(R.mipmap.nanzhuang);
        listset.add(item2);
        goodsList item3=new goodsList();
        item3.setName("热门女装");
        item3.setImg(R.mipmap.mz);
        listset.add(item3);
        goodsList item4=new goodsList();
        item4.setName("品质母婴");
        item4.setImg(R.mipmap.my);
        listset.add(item4);
        goodsList item5=new goodsList();
        item5.setName("美味零食");
        item5.setImg(R.mipmap.ls);
        listset.add(item5);
        goodsList item6=new goodsList();
        item6.setName("猜你喜欢");
        item6.setImg(R.mipmap.cnxh);
        listset.add(item6);
        return listset;
    }

}
