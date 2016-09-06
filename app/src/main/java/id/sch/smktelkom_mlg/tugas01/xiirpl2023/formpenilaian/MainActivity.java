package id.sch.smktelkom_mlg.tugas01.xiirpl2023.formpenilaian;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etNama, etAlasan;
    Button bOK;
    TextView tvHasil;
    RadioGroup rgjk;
    CheckBox cbd, cba, cbs, cbj, cbw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.editTextNama);
        etAlasan = (EditText) findViewById(R.id.editTextAlasan);
        bOK = (Button) findViewById(R.id.buttonOK);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);
        rgjk = (RadioGroup) findViewById(R.id.radioGrupJK);
        cba = (CheckBox) findViewById(R.id.checkBoxA);
        cbd = (CheckBox) findViewById(R.id.checkBoxD);
        cbs = (CheckBox) findViewById(R.id.checkBoxS);
        cbj = (CheckBox) findViewById(R.id.checkBoxJ);
        cbw = (CheckBox) findViewById(R.id.checkBoxW);

        bOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                doProcess();

            }
        });


    }


    private void doProcess() {

        String alasan = null;
        String nama = null;

        //textbox
        if (isValid()) {
            String nm = etNama.getText().toString();
            String als = etAlasan.getText().toString();

            nama = "Nama : " + nm + "\n";
            alasan = "Alasan mengikuti  : " + als + "\n";

            String jk = "Jenis Kelamin :  ";
            int jenis = jk.length();
            if (rgjk.getCheckedRadioButtonId() != -1) {
                RadioButton rb = (RadioButton)
                        findViewById(rgjk.getCheckedRadioButtonId());
                jk += rb.getText().toString() + "\n";

            }

            if (jk.length() == jenis) {
                jk += "Tidak Ada Pilihan JK \n";
            }

            //checkbox
            String ahli = "Keahlian Anda :  ";
            int startlen = ahli.length();
            if (cba.isChecked()) ahli += cba.getText() + "\n";
            if (cbs.isChecked()) ahli += cbs.getText() + "\n";
            if (cbd.isChecked()) ahli += cbd.getText() + "\n";
            if (cbj.isChecked()) ahli += cbj.getText() + "\n";
            if (cbw.isChecked()) ahli += cbw.getText() + "\n";

            if (ahli.length() == startlen) ahli += "Tidak Ada Pilihan \n";
            tvHasil.setText(nama + alasan + jk + ahli);

            // tvHasil.setText(nama + " berusia " + usia + " tahun");
        }
        //radiobutton




    }

    private boolean isValid() {

        boolean valid = true;
        String nama = etNama.getText().toString();
        String alasan = etAlasan.getText().toString();


        if (nama.isEmpty()) {
            etNama.setError("Nama Belum Diisi");
            valid = false;
        } else {
            etNama.setError(null);
        }
        if (alasan.isEmpty()) {
            etAlasan.setError("Alasan Belum Diisi");
            valid = false;
        } else if (etAlasan.length() > 50) {
            etAlasan.setError("Harap memasukkan alasan yang singkat");
            valid = false;
        } else {
            etAlasan.setError(null);
        }
        return valid;
    }
}



    /*
    @Overridepublic void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {

        if(isChecked) nHobi+=1;
        else nHobi-=1;

        //tvHobi.setText("Hobi ("+nHobi+"  terpilih)");
    }
}*/