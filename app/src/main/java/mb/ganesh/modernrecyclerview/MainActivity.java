package mb.ganesh.modernrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.animation.OvershootInterpolator;

import jp.wasabeef.recyclerview.adapters.AlphaInAnimationAdapter;
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;
import jp.wasabeef.recyclerview.adapters.SlideInRightAnimationAdapter;
import jp.wasabeef.recyclerview.animators.FadeInDownAnimator;

public class MainActivity extends AppCompatActivity {

    MyAdapter adapter;
    RecyclerView recyclerView;

    String strNo[] ;
    String strTitle[] ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        strNo = getResources().getStringArray(R.array.no_arr);
        strTitle = getResources().getStringArray(R.array.title_arr);

        ScaleInAnimationAdapter scaleInAnimationAdapter = new ScaleInAnimationAdapter(new MyAdapter(this , strNo , strTitle ));
        scaleInAnimationAdapter.setDuration(1000);
        scaleInAnimationAdapter.setFirstOnly(false);
        scaleInAnimationAdapter.setInterpolator(new OvershootInterpolator());


        recyclerView = findViewById(R.id.recyclerViewId);
//        adapter = new MyAdapter(this , strNo , strTitle );

        recyclerView.setAdapter(scaleInAnimationAdapter);

//        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}

/*

Animation Type:
***************

AlphaInAnimationAdapter
ScaleInAnimationAdapter
SlideInBottomAnimationAdapter
SlideInRightAnimationAdapter
SlideInLeftAnimationAdapter

 */