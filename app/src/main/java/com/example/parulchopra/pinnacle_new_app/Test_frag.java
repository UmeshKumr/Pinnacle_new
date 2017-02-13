package com.example.parulchopra.pinnacle_new_app;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class Test_frag extends Fragment {
    private RecyclerView r;
    private RecyclerView.Adapter a;
    private RecyclerView.LayoutManager l;
    String[] name1= {" 1","2","3","4"," 5","6","7","8"," 9","10","11","12"," 13","14","15","16"};
    String name2="PINNACLE";
    String name3="HTML BASICS";
    String[] name4= {"What is HTML ?","HTML Syntax","HTML Block and Inline","HTML Hierarchy","What is HTML ?","HTML Syntax","HTML Block and Inline","HTML Hierarchy","What is HTML ?","HTML Syntax","HTML Block and Inline","HTML Hierarchy","What is HTML ?","HTML Syntax","HTML Block and Inline","HTML Hierarchy"};

    public  Test_frag newInstance(String subject) {
        Test_frag f = new Test_frag();

        Bundle args = new Bundle();
        args.putString("index", subject);
        f.setArguments(args);
        return f;

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_test_frag, container, false);

        r=(RecyclerView)v.findViewById(R.id.testrecyler);
        r.addItemDecoration(new SimpleDividerItemDecoration(getContext()));
        a= new TestRecyclerAdapter(getContext(),name1,name2,name3,name4);
        l=new LinearLayoutManager(getContext());
        r.setLayoutManager(l);
        r.setHasFixedSize(true);
        r.setAdapter(a);


    return v;
}

    private class TestRecyclerAdapter extends RecyclerView.Adapter<TestRecyclerAdapter.Recyclerviewholder> {
        Context context;
        String[] a,d;
        String b,c;

        LayoutInflater inflater;
        public TestRecyclerAdapter(Context C1, String[] a,String b,String c,String[] d) {
            this.context=C1;
            this.a=a;
            this.b=b;
            this.c=c;
            this.d=d;
            inflater= LayoutInflater.from(C1);

        }

        @Override
        public TestRecyclerAdapter.Recyclerviewholder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view =inflater.inflate(R.layout.testlistview,parent,false);
            Recyclerviewholder M1= new Recyclerviewholder(view);

            return M1;
        }

        @Override
        public void onBindViewHolder(TestRecyclerAdapter.Recyclerviewholder holder, int position) {
            holder.T1.setText(a[position]);
            holder.T2.setText(b);
            holder.T3.setText(c);
            holder.T4.setText(d[position]);
        }

        @Override
        public int getItemCount() {

            return a.length;
        }

        public class Recyclerviewholder extends RecyclerView.ViewHolder {
            TextView T1,T2,T3,T4;

            public Recyclerviewholder(View itemView) {
                super(itemView);
                T1 = (TextView) itemView.findViewById(R.id.name1);
                T1.setBackgroundResource(R.drawable.circletextshape);
                T2 = (TextView) itemView.findViewById(R.id.name2);
                T3 = (TextView) itemView.findViewById(R.id.name3);
                T4 = (TextView) itemView.findViewById(R.id.name4);
            }
        }     }
}
