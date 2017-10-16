package edu.upc.eseiaat.pma.titleapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class TittleActivity extends AppCompatActivity {

    private String title = "Aquest es el titol inicial...";
    private TextView title_text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tittle);
        title_text = (TextView) findViewById(R.id.title);
        title_text.setText(title);
    }
    public void editTitle(View view) {
        //(I)
        //1. crear un 'intent'
        Intent intent = new Intent(this, EditTitleActivity.class);
        //2. Afegir parametres (dades extra) a la crida a l'activitat
        intent.putExtra("title",title);
        //3. passar l'intent a Android perquè obri l'activitat
        startActivityForResult(intent, 0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case 0:
                //(IV)
                if (resultCode == AppCompatActivity.RESULT_OK){
                    title = data.getStringExtra("title");
                    title_text.setText(title);
                }
        }
    }
}
