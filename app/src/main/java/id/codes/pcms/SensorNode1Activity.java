package id.codes.pcms;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SensorNode1Activity extends AppCompatActivity {

    private CardView suhu;
    private TextView tvSuhu;
    private CardView kelembapanUdara;
    private TextView tvKelembapanUdara;
    private CardView intensitasCahaya;
    private TextView tvIntensitasCahaya;
    private CardView suhuTanah;
    private TextView tvSuhuTanah;
    private CardView kelembapanTanah;
    private TextView tvKelembapanTanah;
    private CardView ph;
    private TextView tvPh;
    static String sensor;
    DatabaseReference databaseReference;
    private TextView tvNamaSensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_node1);
        initView();
        sensor = getIntent().getStringExtra("sensor");
        tvNamaSensor.setText(getIntent().getStringExtra("nama"));
        databaseReference = FirebaseDatabase.getInstance().getReference(sensor);
        getSuhu("airHum", tvKelembapanUdara);
        getSuhu("airTemp", tvSuhu);
        getSuhu("lux", tvIntensitasCahaya);
        getSuhu("pH", tvPh);
        getSuhu("soilHum", tvKelembapanTanah);
        getSuhu("soilTemp", tvSuhuTanah);

        suhu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SensorNode1Activity.this, DetailGrafikActivity.class);
                intent.putExtra("child", "airTempChart");
                intent.putExtra("nama", "Suhu Udara");
                startActivity(intent);
            }
        });
        kelembapanUdara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SensorNode1Activity.this, DetailGrafikActivity.class);
                intent.putExtra("child", "airHumChart");
                intent.putExtra("nama", "Kelembapan Udara");
                startActivity(intent);
            }
        });
        intensitasCahaya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SensorNode1Activity.this, DetailGrafikActivity.class);
                intent.putExtra("child", "luxChart");
                intent.putExtra("nama", "Intensitas Cahaya");
                startActivity(intent);
            }
        });
        suhuTanah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SensorNode1Activity.this, DetailGrafikActivity.class);
                intent.putExtra("child", "soilTempChart");
                intent.putExtra("nama", "Suhu Tanah");
                startActivity(intent);
            }
        });
        kelembapanTanah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SensorNode1Activity.this, DetailGrafikActivity.class);
                intent.putExtra("child", "soilHumChart");
                intent.putExtra("nama", "Kelembapan Tanah");
                startActivity(intent);
            }
        });
        ph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SensorNode1Activity.this, DetailGrafikActivity.class);
                intent.putExtra("child", "phChart");
                intent.putExtra("child", "pH Tanah");
                startActivity(intent);
            }
        });

    }

    private void initView() {
        suhu = (CardView) findViewById(R.id.suhu);
        tvSuhu = (TextView) findViewById(R.id.tv_suhu);
        kelembapanUdara = (CardView) findViewById(R.id.kelembapan_udara);
        tvKelembapanUdara = (TextView) findViewById(R.id.tv_kelembapan_udara);
        intensitasCahaya = (CardView) findViewById(R.id.intensitas_cahaya);
        tvIntensitasCahaya = (TextView) findViewById(R.id.tv_intensitas_cahaya);
        suhuTanah = (CardView) findViewById(R.id.suhu_tanah);
        tvSuhuTanah = (TextView) findViewById(R.id.tv_suhu_tanah);
        kelembapanTanah = (CardView) findViewById(R.id.kelembapan_tanah);
        tvKelembapanTanah = (TextView) findViewById(R.id.tv_kelembapan_tanah);
        ph = (CardView) findViewById(R.id.ph);
        tvPh = (TextView) findViewById(R.id.tv_ph);
        tvNamaSensor = (TextView) findViewById(R.id.tv_nama_sensor);
    }

    void getSuhu(String child, TextView textView) {
        databaseReference.child(child).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                textView.setText(snapshot.getValue(Double.class).toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

}