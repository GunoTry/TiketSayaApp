package app.tiketsaya;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class KetParis extends AppCompatActivity {

    LinearLayout btn_back;
    Button btn_paris;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ket_paris);

        btn_back = findViewById(R.id.btn_back);
        btn_paris = findViewById(R.id.btn_paris);



        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoback= new Intent(KetParis.this, HomeAct.class);
                startActivity(gotoback);
            }
        });

        btn_paris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goparisticket= new Intent(KetParis.this, TicketDetailAct.class);
                goparisticket.putExtra("jenis_tiket", "Pagoda");
                startActivity(goparisticket);
            }
        });
    }
}
