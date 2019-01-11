package test.intern.com.intern;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Date;

public class Main3Activity extends AppCompatActivity {

    long descending_timestamp;
    private DatabaseReference mDatabase,sortuser;
    private ListView userList;
    private ArrayList<String> sortUsername = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        mDatabase= FirebaseDatabase.getInstance().getReference();
        Query last2= mDatabase.child("user1").orderByChild("id").limitToLast(1);
        userList=(ListView)findViewById(R.id.sort_user);
        descending_timestamp= -1 * new Date().getTime();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();

        last2.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                try {
                    String message = dataSnapshot.child("name").getValue().toString();
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        /*final ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,sortUsername);

        ref.orderByChild("descending_timestamp").limitToFirst(3).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int userCount = 0;
                for (DataSnapshot userSnapshot: dataSnapshot.getChildren()) {
                    if (userCount++ > 2) {
                        userSnapshot.getRef().removeValue();
                    } else {
                        // TODO: show the user in your app
                        userList.setAdapter(arrayAdapter);

                        mDatabase.addChildEventListener(new ChildEventListener() {
                            @Override
                            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                                String value = dataSnapshot.getValue(String.class);
                                sortUsername.add(value);
                                arrayAdapter.notifyDataSetChanged();
                                //hideProgressDialog();
                            }

                            @Override
                            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                            }

                            @Override
                            public void onChildRemoved(DataSnapshot dataSnapshot) {

                            }

                            @Override
                            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                Log.w("Message", "load users", databaseError.toException());
            }
        });
    }*/
    }
}
