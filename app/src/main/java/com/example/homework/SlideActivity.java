//package com.example.homework;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.viewpager.widget.ViewPager;
//
//import android.os.Bundle;
//
//public class SlideActivity extends AppCompatActivity {
//
//    public static ViewPager viewPager;
//    SlideViewPagerAdapter adapter;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_sldie);
//
//        viewPager=findViewById(R.id.viewPager);
//        adapter = new SlideViewPagerAdapter(this);
//        viewPager.setAdapter(adapter);
//
////        if(isOpenAlready()){
////            Intent intent = new Intent(SlideActivity.this,MainActivity.class);
////            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
////            startActivity(intent);
////        }
////        else{
////            SharedPreferences.Editor editor = getSharedPreferences("slide",MODE_PRIVATE).edit();
////            editor.putBoolean("slide",true);
////            editor.commit();
////        }
//    }
//
////    private boolean isOpenAlready() {
////        SharedPreferences sharedPreferences = getSharedPreferences("slide",MODE_PRIVATE);
////        boolean result = sharedPreferences.getBoolean("slide", false);
////        return result;
////    }
//}