package faizzy.singlerecycleradapter;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Item> itemArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        itemArrayList = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            itemArrayList.add(new Item("name " + i, "btn " + i));
        }
        RecyclerView mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        SingleRecyclerAdapter<Item> singleRecyclerAdapter = new SingleRecyclerAdapter<Item>(this, itemArrayList, R.layout.item) {
            @Override
            public void onPostBindViewHolder(MyViewHolder holder, Item item) {
                holder.setViewText(R.id.tv_name, item.getName());
                holder.setViewText(R.id.btn_me, item.getBtnText()).setViewOnClickListener(R.id.btn_me, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Toast.makeText(MainActivity.this, "clicked", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        };
        singleRecyclerAdapter.setOnItemClickListener(new SingleRecyclerAdapter.OnItemClickListener<Item>() {
            @Override
            public void onItemClick(View view, int position, Item item) {
                Toast.makeText(MainActivity.this, "Clicked " + (position + 1) + " and item " + item.getName(), Toast.LENGTH_SHORT).show();
            }
        });

        singleRecyclerAdapter.setOnItemLongClickListener(new SingleRecyclerAdapter.OnItemLongClickListener<Item>() {
            @Override
            public boolean onItemLongClick(View view, int position, Item item) {
                Toast.makeText(MainActivity.this, "long Clicked " + (position + 1) + " and item " + item.getName(), Toast.LENGTH_SHORT).show();
                return true;
            }
        });
        mRecyclerView.setAdapter(singleRecyclerAdapter);
    }

}
