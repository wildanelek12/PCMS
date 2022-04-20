package id.codes.pcms;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class HistoryActivity extends AppCompatActivity {

    private CardView suhu;
    private CardView kelembapanUdara;
    private CardView intensitasCahaya;
    private CardView suhuTanah;
    private CardView kelembapanTanah;
    private CardView ph;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        initView();
        suhu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HistoryActivity.this, GrafikHistoryActivity.class);
                intent.putExtra("child", "airTemp");
                intent.putExtra("nama", "Suhu Udara");
                startActivity(intent);
            }
        });
        kelembapanUdara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HistoryActivity.this, GrafikHistoryActivity.class);
                intent.putExtra("child", "airHum");
                intent.putExtra("nama", "Kelembapan Udara");
                startActivity(intent);
            }
        });
        intensitasCahaya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HistoryActivity.this, GrafikHistoryActivity.class);
                intent.putExtra("child", "lux");
                intent.putExtra("nama", "Intensitas Cahaya");
                startActivity(intent);
            }
        });
        suhuTanah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HistoryActivity.this, GrafikHistoryActivity.class);
                intent.putExtra("child", "soilTemp");
                intent.putExtra("nama", "Suhu Tanah");
                startActivity(intent);
            }
        });
        kelembapanTanah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HistoryActivity.this, GrafikHistoryActivity.class);
                intent.putExtra("child", "soilHum");
                intent.putExtra("nama", "Kelembapan Tanah");
                startActivity(intent);
            }
        });
        ph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HistoryActivity.this, GrafikHistoryActivity.class);
                intent.putExtra("child", "ph");
                intent.putExtra("child", "pH Tanah");
                startActivity(intent);
            }
        });
    }

    private void initView() {
        suhu = (CardView) findViewById(R.id.suhu);
        kelembapanUdara = (CardView) findViewById(R.id.kelembapan_udara);
        intensitasCahaya = (CardView) findViewById(R.id.intensitas_cahaya);
        suhuTanah = (CardView) findViewById(R.id.suhu_tanah);
        kelembapanTanah = (CardView) findViewById(R.id.kelembapan_tanah);
        ph = (CardView) findViewById(R.id.ph);
    }
}