package com.example.david.revisao.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.david.revisao.API.RetrofitConfig;
import com.example.david.revisao.API.Service;
import com.example.david.revisao.Adapters.DavidAdapter;
import com.example.david.revisao.Model.Pojo;
import com.example.david.revisao.Model.Result;
import com.example.david.revisao.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentTopRated extends Fragment {

    View v;
    public String api_key = "e9258c359e580c8d5bc18cdc835efdd0";
    public String language = "pt-BR";
    public String category = "top_rated";
    public String region = "BR";
    public int page = 1;
    public List<Result> resultList;


    public FragmentTopRated() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_fragmento_4, container, false);

        Service service = RetrofitConfig.getClient().create(Service.class);
        Call<Pojo> call = service.getMovies(category, api_key,language,page,region);

        call.enqueue(new Callback<Pojo>() {
            @Override
            public void onResponse(Call<Pojo> call, Response<Pojo> response) {
                resultList = response.body().getResults();
                RecyclerView recyclerView = v.findViewById(R.id.recycler);
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(v.getContext());
                DavidAdapter davidAdapter = new DavidAdapter(resultList, v.getContext());
                recyclerView.setAdapter(davidAdapter);
                recyclerView.setLayoutManager(layoutManager);
            }

            @Override
            public void onFailure(Call<Pojo> call, Throwable t) {

            }
        });

        return v;
    }

}
