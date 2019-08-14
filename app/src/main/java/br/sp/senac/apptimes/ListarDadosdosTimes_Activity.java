package br.sp.senac.apptimes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class ListarDadosdosTimes_Activity extends AppCompatActivity {

    TextView lstTimes;
    ImageView imgTimes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listar_dados_dos_times_layout);

        lstTimes = (TextView) findViewById(R.id.lstDTimes);
        imgTimes = (ImageView) findViewById(R.id.lstIMGTimes);

        Intent intent = getIntent();
        String nomeRetorno = intent.getStringExtra("name");
        int imagemRetorno = intent.getIntExtra("image", 0);

        lstTimes.setText(nomeRetorno);
        imgTimes.setImageResource(imagemRetorno);

        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}

