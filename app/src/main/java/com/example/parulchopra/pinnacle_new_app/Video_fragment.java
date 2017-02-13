package com.example.parulchopra.pinnacle_new_app;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class Video_fragment extends Fragment {

    private RecyclerView r;
    private RecyclerView.Adapter a;
    private RecyclerView.LayoutManager l;
    String[] name1= {" 1","2","3","4"," 5","6","7","8"," 9","10","11","12"," 13","14","15","16"};
    String name2="HTML BASICS";
    String[] name3= {"What is HTML ?","HTML Syntax","HTML Block and Inline","HTML Hierarchy","What is HTML ?","HTML Syntax","HTML Block and Inline","HTML Hierarchy","What is HTML ?","HTML Syntax","HTML Block and Inline","HTML Hierarchy","What is HTML ?","HTML Syntax","HTML Block and Inline","HTML Hierarchy"};
    int[] image={R.drawable.b1, R.drawable.b12,R.drawable.b4, R.drawable.blue,R.drawable.b2, R.drawable.color12,R.drawable.b1, R.drawable.b12,R.drawable.b4, R.drawable.blue,R.drawable.b2, R.drawable.color12,R.drawable.b1, R.drawable.b12,R.drawable.b4, R.drawable.blue};

    public Video_fragment newInstance(String subject) {
        Video_fragment f = new Video_fragment();

        Bundle args = new Bundle();
        args.putString("index", subject);
        f.setArguments(args);
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_video_fragment, container, false);
        r=(RecyclerView)v.findViewById(R.id.videorecyler);
        r.addItemDecoration(new SimpleDividerItemDecoration(getContext()));
        a= new VideoRecyclerAdapter(getContext(),name1,name2,name3,image);
        l=new LinearLayoutManager(getContext());
        r.setLayoutManager(l);
        r.setHasFixedSize(true);
        r.setAdapter(a);

        return v;

    }

    private class VideoRecyclerAdapter extends RecyclerView.Adapter<VideoRecyclerAdapter.Recyclerviewholder> {
        Context context;
        String[] a;
        String b;
        String[] c;
        int[] image;
        LayoutInflater inflater;
        public VideoRecyclerAdapter(Context C1, String[] a,String b,String[] c,int[] image) {
            this.context=C1;
            this.a=a;
            this.b=b;
            this.c=c;
            this.image=image;
            inflater= LayoutInflater.from(C1);
        }

        @Override
        public Recyclerviewholder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view =inflater.inflate(R.layout.videolistview,parent,false);
            Recyclerviewholder M1= new Recyclerviewholder(view);

            return M1;
        }

        @Override
        public void onBindViewHolder(Recyclerviewholder holder, int position) {
            holder.T1.setText(a[position]);
            holder.T2.setText(b);
            holder.T3.setText(c[position]);
            holder.I1.setImageResource(image[position]);
        }

        @Override
        public int getItemCount() {
            return a.length;
        }

        public class Recyclerviewholder extends RecyclerView.ViewHolder {
            TextView T1,T2,T3;
            ImageView I1;
            public Recyclerviewholder(View itemView) {
                super(itemView);
                T1=(TextView)itemView.findViewById(R.id.name1);
                T1.setBackgroundResource(R.drawable.circletextshape);
                T2=(TextView)itemView.findViewById(R.id.name2);
                T3=(TextView)itemView.findViewById(R.id.name3);
                I1=(ImageView)itemView.findViewById(R.id.Image1);
            }
        }
    }
}
