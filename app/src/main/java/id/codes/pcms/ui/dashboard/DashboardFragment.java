package id.codes.pcms.ui.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import id.codes.pcms.HistoryActivity;
import id.codes.pcms.R;
import id.codes.pcms.SensorNode1Activity;
import id.codes.pcms.databinding.FragmentDashboardBinding;

public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;
    private ImageView btnSensor1;
    private ImageView btnSensor2;
    private ImageView btnSensor3;
    private AppCompatButton btn_history;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        initView(root);
        btnSensor1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), SensorNode1Activity.class);
                intent.putExtra("sensor","SensorNode1");
                intent.putExtra("nama","Sensor Node 1");
                startActivity(intent);
            }
        });
        btnSensor2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), SensorNode1Activity.class);
                intent.putExtra("sensor","SensorNode2");
                intent.putExtra("nama","Sensor Node 2");
                startActivity(intent);
            }
        });
        btnSensor3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), SensorNode1Activity.class);
                intent.putExtra("sensor","SensorNode3");
                intent.putExtra("nama","Sensor Node 3");
                startActivity(intent);
            }
        });
        btn_history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), HistoryActivity.class);
                startActivity(intent);
            }
        });
        return root;
    }

    private void initView(View view) {
        btnSensor1 = (ImageView) view.findViewById(R.id.btn_sensor_1);
        btnSensor2 = (ImageView) view.findViewById(R.id.btn_sensor_2);
        btnSensor3 = (ImageView) view.findViewById(R.id.btn_sensor_3);
        btnSensor3 = (ImageView) view.findViewById(R.id.btn_sensor_3);
        btn_history = (AppCompatButton) view.findViewById(R.id.btn_history);
    }
}