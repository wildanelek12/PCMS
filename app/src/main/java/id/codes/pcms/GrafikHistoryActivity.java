package id.codes.pcms;

import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Cartesian;
import com.anychart.core.cartesian.series.Line;
import com.anychart.data.Mapping;
import com.anychart.data.Set;
import com.anychart.enums.Anchor;
import com.anychart.enums.MarkerType;
import com.anychart.enums.TooltipPositionMode;
import com.anychart.graphics.vector.Stroke;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import id.codes.pcms.Model.DataHistory;
import id.codes.pcms.Model.DataSuhu;

public class GrafikHistoryActivity extends AppCompatActivity {

    private AnyChartView anyChartView;
    List<DataEntry> seriesData = new ArrayList<>();
    Set set;
    Mapping series1Mapping,series2Mapping,series3Mapping;
    Line series1,series2,series3;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grafik_history);
        initView();
        Cartesian cartesian = AnyChart.line();

        cartesian.animation(true);

        cartesian.padding(10d, 20d, 5d, 20d);

        cartesian.crosshair().enabled(true);
        cartesian.crosshair()
                .yLabel(true)
                // TODO ystroke
                .yStroke((Stroke) null, null, null, (String) null, (String) null);

        cartesian.tooltip().positionMode(TooltipPositionMode.CHART);

        cartesian.title(getIntent().getStringExtra("nama"));

        FirebaseDatabase.getInstance().getReference("History").child(getIntent().getStringExtra("child")).limitToLast(10).orderByChild("waktu").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                seriesData.clear();
                if (dataSnapshot.exists()) {
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        DataHistory dataHistory = snapshot.getValue(DataHistory.class);
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        SimpleDateFormat output = new SimpleDateFormat("HH:mm:ss");
                        Date d = null;
                        try {
                            d = sdf.parse(dataHistory.getWaktu());
                            String formattedTime = output.format(d);
                            seriesData.add(new CustomDataEntry(formattedTime,dataHistory.getSensor_node1(),dataHistory.getSensor_node2(),dataHistory.getSensor_node3()));
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }

                    }
                    set = Set.instantiate();
                    series1Mapping = set.mapAs("{ x: 'x', value: 'value' }");
                        series2Mapping = set.mapAs("{ x: 'x', value: 'value2' }");
                        series3Mapping = set.mapAs("{ x: 'x', value: 'value3' }");
                    series1 = cartesian.line(series1Mapping);
                        series2 = cartesian.line(series2Mapping);
                        series3 = cartesian.line(series3Mapping);
                    series1.name("Node 1");
                    series1.hovered().markers().enabled(true);
                    series1.hovered().markers()
                            .type(MarkerType.CIRCLE)
                            .size(4d);
                    series2.name("Node 2");
                    series2.hovered().markers().enabled(true);
                    series2.hovered().markers()
                            .type(MarkerType.CIRCLE)
                            .size(4d);
                    series3.name("Node 3");
                    series3.hovered().markers().enabled(true);
                    series3.hovered().markers()
                            .type(MarkerType.CIRCLE)
                            .size(4d);


                    set.data(seriesData);
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {

            }
        });

        anyChartView.setChart(cartesian);
    }

    private class CustomDataEntry extends ValueDataEntry {

        CustomDataEntry(String x, Number value,Number value2,Number value3) {
            super(x, value);
            setValue("value2", value2);
            setValue("value3", value3);
        }

    }
//    private class CustomDataEntry extends ValueDataEntry {
//
//        CustomDataEntry(String x, Number value) {
//            super(x, value);
//        }
//
//    }


    private void initView() {
        anyChartView = (AnyChartView) findViewById(R.id.any_chart_view);
    }
}