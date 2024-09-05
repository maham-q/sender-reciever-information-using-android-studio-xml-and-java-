package com.example.smd_a1;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class sender extends AppCompatActivity {

    // hooks
    Button btnseNext;
    EditText etseName, etseAddress, etseContact, etseCountry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sender);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.sender), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        init();

        btnseNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = etseName.getText().toString();
                String address = etseAddress.getText().toString();
                String contact = etseContact.getText().toString();
                String country = etseCountry.getText().toString();

                if(name.isEmpty() || address.isEmpty() || contact.isEmpty() || country.isEmpty()){
                    Toast.makeText(sender.this, "Credentials can't be empty", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent i = new Intent(sender.this, reciever.class);
                    i.putExtra("senderName", name);
                    i.putExtra("senderAddress", address);
                    i.putExtra("senderContact", contact);
                    i.putExtra("senderCountry", country);
                    startActivity(i);
                }
            }
        });
    }

    private void init() {
        btnseNext = findViewById(R.id.btnseNext);
        etseName = findViewById(R.id.etseName);
        etseAddress = findViewById(R.id.etseAddress);
        etseContact = findViewById(R.id.etseContact);
        etseCountry = findViewById(R.id.etseCountry);
    }
}
