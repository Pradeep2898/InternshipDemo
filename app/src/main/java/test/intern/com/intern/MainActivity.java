package test.intern.com.intern;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button next;
    private RecyclerView recyclerView;
    private ArrayList<FruitModel> imageModelArrayList;
    private FruitAdapter adapter;
    private int[] myImageList = new int[]{R.drawable.ic_android_black_24dp, R.drawable.ic_attach_money_black_24dp,R.drawable.ic_audiotrack_black_24dp, R.drawable.ic_beach_access_black_24dp,R.drawable.ic_bug_report_black_24dp,R.drawable.ic_brightness_high_black_24dp,R.drawable.ic_cake_black_24dp};
    private String[] myImageNameList = new String[]{"Android","Money" ,"Music","Beach","Bug","Sun","Cake"};
    private String[] myUserNameList = new String[]{"Andromeda","Dollar" ,"C#","Umbrella","Beetle","Star","Birthday"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        next=(Button)findViewById(R.id.button2);
        recyclerView = (RecyclerView) findViewById(R.id.recycler);

        imageModelArrayList = eatFruits();
        adapter = new FruitAdapter(this, imageModelArrayList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
            }
        });

    }

    private ArrayList<FruitModel> eatFruits(){

        ArrayList<FruitModel> list = new ArrayList<>();

        for(int i = 0; i < 7; i++){
            FruitModel fruitModel = new FruitModel();
            fruitModel.setUserdetail(myImageNameList[i]);
            fruitModel.setName(myUserNameList[i]);
            fruitModel.setImage_drawable(myImageList[i]);
            list.add(fruitModel);
        }

        return list;
    }

}