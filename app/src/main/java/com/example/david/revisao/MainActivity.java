package com.example.david.revisao;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import com.example.david.revisao.Adapters.FragmentPageAdapter;
import com.example.david.revisao.Fragment.FragmentoNowPlaying;
import com.example.david.revisao.Fragment.FragmentPopular;
import com.example.david.revisao.Fragment.FragmentTopRated;
import com.example.david.revisao.Fragment.FragmentoUpcoming;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebView webView = findViewById(R.id.webview);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://www.themoviedb.org/");

        List<Fragment> fragmentList = new ArrayList<>();
        List<String> titulos = new ArrayList<>();

        //Criando os titulos
        String fragment1 = "Now Playing";
        String fragment2 = "Up Coming";
        String fragment3 = "Popular";
        String fragment4 = "Top Rated";

        //Adicionando os títulos na Lista de títulos
        titulos.add(fragment1);
        titulos.add(fragment2);
        titulos.add(fragment3);
        titulos.add(fragment4);

        //Criando os fragmentos
        FragmentoNowPlaying fragmentEA = new FragmentoNowPlaying();
        FragmentPopular fragmentCapCom = new FragmentPopular();
        FragmentTopRated fragmentKonami = new FragmentTopRated();
        FragmentoUpcoming fragmentRockstar = new FragmentoUpcoming();

        //inserindo os fragmentos na Lista
        fragmentList.add(fragmentEA);
        fragmentList.add(fragmentCapCom);
        fragmentList.add(fragmentKonami);
        fragmentList.add(fragmentRockstar);

        ViewPager viewPager = findViewById(R.id.viewPager);
        TabLayout tabLayout = findViewById(R.id.tabs);

        FragmentPagerAdapter fragmentPagerAdapter = new FragmentPageAdapter(getSupportFragmentManager(), fragmentList,titulos);

        viewPager.setAdapter(fragmentPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
