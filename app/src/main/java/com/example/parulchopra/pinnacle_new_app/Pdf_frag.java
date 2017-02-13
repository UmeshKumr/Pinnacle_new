package com.example.parulchopra.pinnacle_new_app;


import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;


public class Pdf_frag extends Fragment {
String index;
    String pdf;



    public  Pdf_frag newInstance(int position) {
        Pdf_frag f = new Pdf_frag();
        Bundle args = new Bundle();
        args.putInt("index", position);
        f.setArguments(args);
        return f;

    }
      private RecyclerView r;
    private RecyclerView.Adapter a;
    private RecyclerView.LayoutManager l;






        @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_pdf_frag, container, false);

        index = getArguments().getString("index");

        r=(RecyclerView)v.findViewById(R.id.Recycler1);
        r.addItemDecoration(new SimpleDividerItemDecoration(getContext()));
        a= new PdfRecyclerAdapter(getContext(),index);
        l=new LinearLayoutManager(getContext());
        r.setLayoutManager(l);
        r.setHasFixedSize(true);
        r.setAdapter(a);
        return v;
    }




    private class PdfRecyclerAdapter extends RecyclerView.Adapter<PdfRecyclerAdapter.Recyclerviewholder> {

        Context context;

        String c;
        LayoutInflater inflater;

        public PdfRecyclerAdapter(Context C1,  String c) {
            this.context = C1;

            this.c = c;
            inflater = LayoutInflater.from(C1);

        }

        @Override
        public PdfRecyclerAdapter.Recyclerviewholder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = inflater.inflate(R.layout.pdflistview, parent, false);
            Recyclerviewholder M1 = new Recyclerviewholder(view);

            return M1;
        }

        @Override
        public void onBindViewHolder(PdfRecyclerAdapter.Recyclerviewholder holder, int position) {

            holder.T2.setText(c);

            holder.rumani_Listener(new OnClickListener() {
                @Override
                public void parul(View v, int pos) {
                    Snackbar.make(v,"hellloooooooo" , Snackbar.LENGTH_LONG).setAction("action",null).show();
                }
            });

        }

        @Override
        public int getItemCount() {
            return 1;
        }


        public class Recyclerviewholder extends RecyclerView.ViewHolder implements View.OnClickListener {
            TextView T2;
            OnClickListener onClickListener;

            public Recyclerviewholder(View itemView) {
                super(itemView);

                T2 = (TextView) itemView.findViewById(R.id.name2);

                itemView.setOnClickListener(this);

            }

            @Override
            public void onClick(View v) {
                this.onClickListener.parul(v, getLayoutPosition());
            }

            public void rumani_Listener(OnClickListener io) {
                this.onClickListener = io;
            }
        }

    }

        }




