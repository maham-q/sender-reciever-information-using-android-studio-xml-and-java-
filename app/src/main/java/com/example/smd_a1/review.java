package com.example.smd_a1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class review extends AppCompatActivity {

    // hooks
    EditText etseName, etseAddress, etseContact, etseCountry, etreName, etreAddress, etreContact, etreCountry;
    TextView senderName, senderAddress, senderContact, senderCountry, recName, recAddress, recContact, recCountry;
    FloatingActionButton fabAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        init();

        String senderNameData = getIntent().getStringExtra("senderName");
        String senderAddressData = getIntent().getStringExtra("senderAddress");
        String senderContactData = getIntent().getStringExtra("senderContact");
        String senderCountryData = getIntent().getStringExtra("senderCountry");
        String receiverNameData = getIntent().getStringExtra("receiverName");
        String receiverAddressData = getIntent().getStringExtra("receiverAddress");
        String receiverContactData = getIntent().getStringExtra("receiverContact");
        String receiverCountryData = getIntent().getStringExtra("receiverCountry");

        senderName.setText(senderNameData);
        senderAddress.setText(senderAddressData);
        senderCountry.setText(senderCountryData);
        senderContact.setText(senderContactData);
        recName.setText(receiverNameData);
        recAddress.setText(receiverAddressData);
        recCountry.setText(receiverCountryData);
        recContact.setText(receiverContactData);

        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(review.this, sender.class));
                etreName.setText("");
                etreAddress.setText("");
                etreContact.setText("");
                etreCountry.setText("");
                etseName.setText("");
                etseAddress.setText("");
                etseContact.setText("");
                etseCountry.setText("");
            }
        });
    }

    private void init() {
        etreName = findViewById(R.id.etreName);
        etreAddress = findViewById(R.id.etreAddress);
        etreContact = findViewById(R.id.etreContact);
        etreCountry = findViewById(R.id.etreCountry);
        etseName = findViewById(R.id.etseName);
        etseAddress = findViewById(R.id.etseAddress);
        etseContact = findViewById(R.id.etseContact);
        etseCountry = findViewById(R.id.etseCountry);
        senderName = findViewById(R.id.senderName);
        senderAddress = findViewById(R.id.senderAddress);
        senderCountry = findViewById(R.id.senderCountry);
        senderContact = findViewById(R.id.senderContact);
        recName = findViewById(R.id.recName);
        recAddress = findViewById(R.id.recAddress);
        recCountry = findViewById(R.id.recCountry);
        recContact = findViewById(R.id.recContact);
        fabAdd = findViewById(R.id.fabAdd);
    }
}
