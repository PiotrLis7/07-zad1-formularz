package com.example.formularz_z_zapisu;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.materialswitch.MaterialSwitch;

public class MainActivity extends AppCompatActivity {

    EditText etName, etEmail;
    Button btnBirthDate, btnSubmit;
    Spinner spCourse;
    RadioGroup rgMode;
    SeekBar sbLevel;
    MaterialSwitch swNewsletter;
    CheckBox cbTerms;
    TextView tvSummary;

    String birthDate = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        btnBirthDate = findViewById(R.id.btnBirthDate);
        btnSubmit = findViewById(R.id.btnSubmit);
        spCourse = findViewById(R.id.spCourse);
        rgMode = findViewById(R.id.rgMode);
        sbLevel = findViewById(R.id.sbLevel);
        swNewsletter = findViewById(R.id.swNewsletter);
        cbTerms = findViewById(R.id.cbTerms);
        tvSummary = findViewById(R.id.tvSummary);

        setUpCourseSpinner();

        btnSubmit.setOnClickListener(v -> submitForm());
    }

    private void setUpCourseSpinner() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.courses,
                android.R.layout.simple_spinner_item
        );

        adapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item
        );

        spCourse.setAdapter(adapter);
    }

    private void submitForm() {
        String name = etName.getText().toString().trim();
        String email = etEmail.getText().toString().trim();

        String course = spCourse.getSelectedItem().toString();

        String mode = "";
        int selectedMode = rgMode.getCheckedRadioButtonId();

        if (selectedMode == R.id.rbOnsite) {
            mode = "Stacjonarny";
        } else if (selectedMode == R.id.rbRemote) {
            mode = "Zdalny";
        }

        int level = sbLevel.getProgress();
        boolean newsletter = swNewsletter.isChecked();

        String summary = "Podsumowanie zgłoszenia:\n\n"
                + "Imię i nazwisko: " + name + "\n"
                + "E-mail: " + email + "\n"
                + "Data urodzenia: " + birthDate + "\n"
                + "Kurs: " + course + "\n"
                + "Tryb: " + mode + "\n"
                + "Poziom: " + level + "\n"
                + "Newsletter: " + (newsletter ? "Tak" : "Nie");

        tvSummary.setText(summary);
        Toast.makeText(this, "Odczytano formularz", Toast.LENGTH_SHORT).show();
    }
}