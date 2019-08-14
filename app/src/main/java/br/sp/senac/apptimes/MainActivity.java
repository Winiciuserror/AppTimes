package br.sp.senac.apptimes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    String[] nameTimes = {"Corinthians", "Ceara", "Flamengo", "Gremio",
            "Internacional", "Atletico MG", "São Paulo", "Vasco", "Cruzeiro"};
    int[] imageTimes = {R.drawable.corinthians, R.drawable.ceara,
            R.drawable.fla, R.drawable.gremio,
            R.drawable.inter, R.drawable.mineiro,
            R.drawable.spfc,
            R.drawable.vasco, R.drawable.cru};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.lstTimes);

        CustomAdapter customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), ListarDadosdosTimes_Activity.class);
                intent.putExtra("name", nameTimes[position]);
                intent.putExtra("image", imageTimes[position]);
                startActivity(intent);
            }
        });
    }

    class CustomAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return imageTimes.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View view1 = getLayoutInflater().inflate(R.layout.carrega_times, null);

            TextView name = (TextView) view1.findViewById(R.id.times);
            ImageView image = (ImageView) view1.findViewById(R.id.imgTimes);

            name.setText(nameTimes[position]);
            image.setImageResource(imageTimes[position]);

            return view1;
        }
    }
}
