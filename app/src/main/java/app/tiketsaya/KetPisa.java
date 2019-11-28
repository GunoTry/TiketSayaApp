package app.tiketsaya;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class KetPisa extends AppCompatActivity {

    LinearLayout btn_back;
    Button btn_pisa;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ket_pisa);


        btn_back = findViewById(R.id.btn_back);
        btn_pisa = findViewById(R.id.btn_pisa);


        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoback = new Intent(KetPisa.this, HomeAct.class);
                startActivity(gotoback);
            }
        });

        btn_pisa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gopisaticket = new Intent(KetPisa.this, TicketDetailAct.class);

                //meletakan data pada intent
                gopisaticket.putExtra("jenis_tiket", "Pisa");
                startActivity(gopisaticket);

            }
        });
    }
}

