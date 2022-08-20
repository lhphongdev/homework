//package com.example.homework;
//
//import android.content.Context;
//import android.content.Intent;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Button;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.viewpager.widget.PagerAdapter;
//
//import org.w3c.dom.Text;
//
//public class SlideViewPagerAdapter extends PagerAdapter {
//
//    Context ctx;
//
//    public SlideViewPagerAdapter(Context ctx) {
//        this.ctx = ctx;
//    }
//
//    @Override
//    public int getCount() {
//        return 3;
//    }
//
//    @Override
//    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
//        return view == object;
//    }
//
//    @NonNull
//    @Override
//    public Object instantiateItem(@NonNull ViewGroup container, int position) {
//        LayoutInflater layoutInflater = (LayoutInflater) ctx.getSystemService(ctx.LAYOUT_INFLATER_SERVICE);
//        View view = layoutInflater.inflate(R.layout.slide_screen, container, false);
//
//        ImageView logo = view.findViewById(R.id.logo);
//        ImageView index1 = view.findViewById(R.id.index1);
//        ImageView index2 = view.findViewById(R.id.index2);
//        ImageView index3 = view.findViewById(R.id.index3);
//
//        TextView title = view.findViewById(R.id.titleLogo);
//        TextView desc = view.findViewById(R.id.desc);
//
//        ImageView next = view.findViewById(R.id.next);
//        ImageView back = view.findViewById(R.id.back);
//
//        Button btnGetStarted = view.findViewById(R.id.btnGetStarted);
//
//        btnGetStarted.setOnClickListener(view13 -> {
//            Intent intent = new Intent(ctx, LoginActivity.class);
//            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
//            ctx.startActivity(intent);
//        });
//
//        next.setOnClickListener(view1 -> SlideActivity.viewPager.setCurrentItem(position + 1));
//
//        back.setOnClickListener(view12 -> SlideActivity.viewPager.setCurrentItem(position - 1));
//
//        index1.setOnClickListener(view14 -> {
//            int position1 = 0;
//            SlideActivity.viewPager.setCurrentItem(position1);
//        });
//
//        index2.setOnClickListener(view15 -> {
//            int position12 = 1;
//            SlideActivity.viewPager.setCurrentItem(position12);
//        });
//
//        index3.setOnClickListener(view16 -> {
//            int position13 = 2;
//            SlideActivity.viewPager.setCurrentItem(position13);
//        });
//
//        TextView skip = view.findViewById(R.id.skip);
//
//        skip.setOnClickListener(view17 -> {
//            Intent intent = new Intent(ctx, LoginActivity.class);
//            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
//            ctx.startActivity(intent);
//        });
//
//
//        switch (position) {
//            case 0:
//                logo.setImageResource(R.drawable.logo);
//                index1.setImageResource(R.drawable.selected);
//                index2.setImageResource(R.drawable.unselected);
//                index3.setImageResource(R.drawable.unselected);
//                title.setText("Shopping Place");
//                desc.setText("this is a random text taking from lorem - Shopping place");
//                back.setVisibility(View.GONE);
//                next.setVisibility(View.VISIBLE);
//                btnGetStarted.setVisibility(View.GONE);
//                skip.setVisibility(View.VISIBLE);
//                break;
//            case 1:
//                logo.setImageResource(R.drawable.payment);
//                index1.setImageResource(R.drawable.unselected);
//                index2.setImageResource(R.drawable.selected);
//                index3.setImageResource(R.drawable.unselected);
//                title.setText("Payment methods");
//                desc.setText("this is a random text taking from lorem - Payment methods");
//                back.setVisibility(View.VISIBLE);
//                next.setVisibility(View.VISIBLE);
//                btnGetStarted.setVisibility(View.GONE);
//                skip.setVisibility(View.VISIBLE);
//                break;
//            case 2:
//                logo.setImageResource(R.drawable.shipper);
//                index1.setImageResource(R.drawable.unselected);
//                index2.setImageResource(R.drawable.unselected);
//                index3.setImageResource(R.drawable.selected);
//                title.setText("Shipper");
//                desc.setText("this is a random text taking from lorem - Shipper");
//                back.setVisibility(View.VISIBLE);
//                next.setVisibility(View.GONE);
//                btnGetStarted.setVisibility(View.VISIBLE);
//                skip.setVisibility(View.GONE);
//                break;
//        }
//
//        container.addView(view);
//        return view;
//    }
//
//    @Override
//    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
//        container.removeView((View) object);
//    }
//}
