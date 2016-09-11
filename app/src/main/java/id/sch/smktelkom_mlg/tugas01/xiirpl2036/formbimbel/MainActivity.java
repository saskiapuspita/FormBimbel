package id.sch.smktelkom_mlg.tugas01.xiirpl2036.formbimbel;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etNama;
    EditText etTahun;
    RadioButton rbSD, rbSMP, rbSMA;
    //RadioGroup rgStatus;
    CheckBox cbM, cbI, cbBIG, cbBI;
    Spinner spProvinsi;
    Button bOk;
    TextView tvHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.editTextNama);
        etTahun = (EditText) findViewById(R.id.editTextTahun);
        rbSD = (RadioButton) findViewById(R.id.radioButtonSD);
        rbSMP = (RadioButton) findViewById(R.id.radioButtonSMP);
        rbSMA = (RadioButton) findViewById(R.id.radioButtonSMA);
        //rgStatus = (RadioGroup) findViewById(R.id.RadioGroupStatus);

        cbM = (CheckBox) findViewById(R.id.checkBoxM);
        cbI = (CheckBox) findViewById(R.id.checkBoxI);
        cbBIG = (CheckBox) findViewById(R.id.checkBoxBING);
        cbBI = (CheckBox) findViewById(R.id.checkBoxBI);

        spProvinsi = (Spinner) findViewById(R.id.spinnerProvinsi);

        bOk = (Button) findViewById(R.id.buttonOK);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);

        //button
        bOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doProcess();
            }
        });
    }

    private void doProcess() {
        if (isValid()) {
            String nama = etNama.getText().toString();
            int tahun = Integer.parseInt(etTahun.getText().toString());

            String hasil1 = "";
            int startlen = hasil1.length();
            if (cbM.isChecked()) hasil1 += cbM.getText() + "\n";
            if (cbI.isChecked()) hasil1 += cbI.getText() + "\n";
            if (cbBIG.isChecked()) hasil1 += cbBIG.getText() + "\n";
            if (cbBI.isChecked()) hasil1 += cbBI.getText() + "\n";

            if (hasil1.length() == startlen) hasil1 += "Tidak Ada Pilihan";

            //tvHasil.setText(hasil1);


            String hasil = null;

            if (rbSD.isChecked()) {
                hasil = rbSD.getText().toString();
            } else if (rbSMP.isChecked()) {
                hasil = rbSMP.getText().toString();
            } else if (rbSMA.isChecked()) {
                hasil = rbSMA.getText().toString();
            }

            /*if(rgStatus.getCheckedRadioButtonId()!=-1)
            {
                RadioButton rb = (RadioButton)
                        findViewById(rgStatus.getCheckedRadioButtonId());
                hasil = rb.getText().toString();
            }*/

            if (hasil == null) {
                tvHasil.setText("Belum Memilih Status");
            } else {
                tvHasil.setText("CEK ULANG DATA ANDA" + "\n\n" + nama + "\n" + tahun + "\n" + hasil + "\n" + hasil1 + spProvinsi.getSelectedItem().toString());
            }
            //tvHasil.setText(nama + "\n" + tahun + "\n");
        }
    }

    private boolean isValid() {
        boolean valid = true;

        String nama = etNama.getText().toString();
        String tahun = etTahun.getText().toString();

        if (nama.isEmpty()) {
            etNama.setError("Nama belum diisi");
            valid = false;
        } else if (nama.length() < 3) {
            etNama.setError("Nama minimal 3 karakter");
            valid = false;
        } else {
            etNama.setError(null);
        }

        if (tahun.isEmpty()) {
            etTahun.setError("Tahun lahir belum diisi");
            valid = false;
        } else if (tahun.length() != 4) {
            etTahun.setError("Format tahun kelahiran bukan yyyy");
            valid = false;
        } else {
            etTahun.setError(null);
        }
        return valid;
    }
}
