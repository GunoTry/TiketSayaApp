package app.tiketsaya;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class TicketDetailAct extends AppCompatActivity {

    Button btn_buy_ticket;
    TextView title_ticket, location_ticket, photo_spot, wife_available, festival_ticket, short_desc_ticket;
    DatabaseReference reference;
    ImageView header_ticket_detail;

    LinearLayout btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_detail);


        btn_buy_ticket = findViewById(R.id.btn_buy_ticket);
        header_ticket_detail = findViewById(R.id.header_ticket_detail);
        btn_back = findViewById(R.id.btn_back);

        title_ticket = findViewById(R.id.title_ticket);
        location_ticket = findViewById(R.id.location_ticket);
        photo_spot = findViewById(R.id.photo_spot);
        wife_available = findViewById(R.id.wife_available);
        festival_ticket = findViewById(R.id.festival_ticket);
        short_desc_ticket = findViewById(R.id.short_desc_ticket);

        //mangambil data dari intent
        Bundle bundle = getIntent().getExtras();
        final String jenis_tiket_baru = bundle.getString("jenis_tiket");

        //mengambil data firebase dari intent
        reference = FirebaseDatabase.getInstance().getReference().child("Wisata").child(jenis_tiket_baru);
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //menimpa data yang ada dengan data baru
                title_ticket.setText(dataSnapshot.child("nama_wisata").getValue().toString());
                location_ticket.setText(dataSnapshot.child("lokasi").getValue().toString());
                photo_spot.setText(dataSnapshot.child("is_photo_sport").getValue().toString());
                wife_available.setText(dataSnapshot.child("is_wifi").getValue().toString());
                festival_ticket.setText(dataSnapshot.child("is_festival").getValue().toString());
                short_desc_ticket.setText(dataSnapshot.child("short_desc").getValue().toString());
                Picasso.with(TicketDetailAct.this)
                        .load(dataSnapshot.child("url_thumbnail")
                        .getValue().toString()).centerCrop().fit()
                        .into(header_ticket_detail);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoback = new Intent(TicketDetailAct.this, HomeAct.class);
                startActivity(gotoback);
            }
        });

        btn_buy_ticket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotocheckout = new Intent(TicketDetailAct.this, TicketCheckoutAct.class);
                gotocheckout.putExtra("jenis_tiket",jenis_tiket_baru);
                startActivity(gotocheckout);
            }
        });


    }
}
