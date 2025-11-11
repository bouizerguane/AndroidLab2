package ma.ens.lab2;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText edt_surface;
    private Spinner spi_nb_pieces;
    private CheckBox chb_piscine;
    private Button btn_calculer;
    private TextView txt_resultat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        edt_surface = findViewById(R.id.surface);
        spi_nb_pieces = findViewById(R.id.nb_pieces);
        chb_piscine = findViewById(R.id.piscine);
        btn_calculer = findViewById(R.id.btn_calculer);
        txt_resultat = findViewById(R.id.txt_resultat);

        btn_calculer.setOnClickListener(v -> {
            double surface = Double.parseDouble(edt_surface.getText().toString());
            int pieces = spi_nb_pieces.getSelectedItemPosition()+1;
            Boolean piscine = chb_piscine.isChecked();
            double impotBase = surface * 2;
            double supplement = pieces * 50 + (piscine ? 100 : 0);
            double total = impotBase + supplement;
            String resultat = "Impôt de base : " + impotBase + "\n"+
                    "Impôt supplémentaire : " + supplement + "\n"+
                    "Impôt total : " + total;

            txt_resultat.setText(resultat);
        });


    }

}