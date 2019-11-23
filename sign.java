package com.example.bestieat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class sign extends AppCompatActivity implements View.OnClickListener{
    private Button signin;
    private Button register;
    private EditText email,pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign);

        signin=(Button)findViewById(R.id.button);
        signin.setOnClickListener(this);
        register=(Button)findViewById(R.id.button2);
        register.setOnClickListener(this);

        email = (EditText)findViewById(R.id.email);
        pass = (EditText)findViewById(R.id.pass);
    }
    @Override
    public void onClick(View v){
        switch (v.getId()) {
            case R.id.button:
                DatabaseReference usersRef =FirebaseDatabase.getInstance().getReference().child("users");
                usersRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String usersRef = dataSnapshot.child("name").child("婕").getKey();
                        email.setText(usersRef);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                    }

                    //@Override
                    //public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {

                        //String emailinput = dataSnapshot.child("婕").child("email").getValue().toString();
                        //System.out.println(emailinput);

                    //}
                    //@Override
                    //public void onCancelled(DatabaseError databaseError) {
                    //}
                });
                //startActivity(new Intent(this, maps.class));
                break;
            case R.id.button2:
                startActivity(new Intent(this, user_register.class));
                break;
        }
    }
}
