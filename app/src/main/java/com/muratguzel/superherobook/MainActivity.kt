package com.muratguzel.superherobook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity() {
    private lateinit var superKahramanAdapter: SuperKahramanAdapter
    private lateinit var viewPagerCardSlider: ViewPager2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPagerCardSlider = findViewById(R.id.viewPagerCardSlider)

        var superKahramanArrayList = ArrayList<SuperKahraman>()



        var superman = SuperKahraman(getString(R.string.superman_head),getString(R.string.superman_features),R.drawable.superman)
        var batman = SuperKahraman(getString(R.string.batman_head),getString(R.string.batman_features),R.drawable.batman)
        var ironman = SuperKahraman(getString(R.string.ironman_head),getString(R.string.ironman_features),R.drawable.ironman)
        var spiderman = SuperKahraman(getString(R.string.spiderman_head),getString(R.string.spiderman_features),R.drawable.spiderman)

        superKahramanArrayList.add(superman)
        superKahramanArrayList.add(batman)
        superKahramanArrayList.add(ironman)
        superKahramanArrayList.add(spiderman)


        superKahramanAdapter= SuperKahramanAdapter(superKahramanArrayList,viewPagerCardSlider)
        viewPagerCardSlider.adapter = SuperKahramanAdapter(superKahramanArrayList,viewPagerCardSlider)
        viewPagerCardSlider.clipToPadding = false
        viewPagerCardSlider.clipChildren = false
        viewPagerCardSlider.offscreenPageLimit = 3
        viewPagerCardSlider.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER

        val compositePageTransformer = CompositePageTransformer()

        compositePageTransformer.addTransformer(MarginPageTransformer(40))
        compositePageTransformer.addTransformer(ViewPager2.PageTransformer { page, position ->
            var r = 1 - Math.abs(position)
            page.scaleY = (0.95f + r * 0.05f)
        })

        viewPagerCardSlider.setPageTransformer(compositePageTransformer)

    }
}