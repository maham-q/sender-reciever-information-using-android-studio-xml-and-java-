package com.example.smd_a1;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class reciever extends AppCompatActivity {

    // hooks
    Button btnreNext;
    EditText etreName, etreAddress, etreContact, etreCountry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_reciever);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.reciever), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        init();

        btnreNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = etreName.getText().toString();
                String address = etreAddress.getText().toString();
                String contact = etreContact.getText().toString();
                String country = etreCountry.getText().toString();
                if(name.isEmpty() || address.isEmpty() || contact.isEmpty() || country.isEmpty()){
                    Toast.makeText(reciever.this, "Credentials can't be empty", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent i = new Intent(reciever.this, review.class);
                    i.putExtra("receiverName", name);
                    i.putExtra("receiverAddress", address);
                    i.putExtra("receiverContact", contact);
                    i.putExtra("receiverCountry", country);
                    i.putExtra("senderName", getIntent().getStringExtra("senderName"));
                    i.putExtra("senderAddress", getIntent().getStringExtra("senderAddress"));
                    i.putExtra("senderContact", getIntent().getStringExtra("senderContact"));
                    i.putExtra("senderCountry", getIntent().getStringExtra("senderCountry"));
                    startActivity(i);
                }
            }
        });

    }
    private void init() {
        btnreNext = findViewById(R.id.btnreNext);
        etreName = findViewById(R.id.etreName);
        etreAddress = findViewById(R.id.etreAddress);
        etreContact = findViewById(R.id.etreContact);
        etreCountry = findViewById(R.id.etreCountry);
    }
}
