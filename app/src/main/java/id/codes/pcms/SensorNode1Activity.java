package id.codes.pcms;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_node1);
        initView();
        suhu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SensorNode1Activity.this,DetailGrafikActivity.class);
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
    }
}