package com.example.tugaspam;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Calendar;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    String a, b, jns;
    Button Daftar, Keluar;
    RadioButton lk, pr, islam, katolik, buddha, alkep, kristen, hindu, konghucu;
    TextInputEditText Namadpn, Namablkng, Tempatlhr, Tgllhr, Alamat, Telepon , Email, Pass, Inpass;
    TextView data1, data2, data3, data4, data5, data6, data7, data8;
    RadioGroup Jns, mFirstGroup, mSecondGroup, mThirdGroup,mFourthGroup;
    private boolean isChecking = true;
    private int mCheckedId = R.id.type1;
    LayoutInflater inflater;
    View dialogView;
    int tahun, bulan, hari;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Daftar = findViewById(R.id.button2);
        Keluar = findViewById(R.id.button1);
        Namadpn = findViewById(R.id.input_nama_dpn);
        Namablkng = findViewById(R.id.input_nama_blkng);
        Tempatlhr = findViewById(R.id.input_tempat_lahir);
        Tgllhr = findViewById(R.id.input_tanggal_lahir);
        Alamat = findViewById(R.id.input_alamat);
        Telepon = findViewById(R.id.input_telepon);
        Email = findViewById(R.id.input_email);
        Pass = findViewById(R.id.input_password);
        Inpass = findViewById(R.id.input_masukan_password);

        Jns =  (RadioGroup) findViewById(R.id.Jns);
        mFirstGroup = (RadioGroup) findViewById(R.id.first_group);
        mSecondGroup = (RadioGroup) findViewById(R.id.second_group);
        mThirdGroup = (RadioGroup) findViewById(R.id.third_group);
        mFourthGroup = (RadioGroup) findViewById(R.id.fourth_group);

        lk = findViewById(R.id.lk);
        pr = findViewById(R.id.pr);
        islam = findViewById(R.id.type1);
        kristen = findViewById(R.id.type2);
        katolik = findViewById(R.id.type3);
        hindu = findViewById(R.id.type4);
        buddha = findViewById(R.id.type5);
        konghucu = findViewById(R.id.type6);
        alkep = findViewById(R.id.type7);

        Keluar = (Button) findViewById(R.id.button1);
        Keluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveTaskToBack(true);
                finish();
                System.exit(0);
            }
        });

        Email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!Email.getText().toString().trim()
                        .matches("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+")) {
                    Email.setError("Format Email Salah");
                }
            }
        });

        Daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (Namadpn.getText().toString().equals("") &&
                        Namablkng.getText().toString().equals("") &&
                        Tempatlhr.getText().toString().equals("") &&
                        Tgllhr.getText().toString().equals("") &&
                        Alamat.getText().toString().equals("") &&
                        Telepon.getText().toString().equals("") &&
                        Email.getText().toString().equals("") &&
                        Pass.getText().toString().equals("") &&
                        Inpass.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Login Gagal", Toast.LENGTH_LONG).show();
                } else if (Namadpn.getText().toString().length() == 0) {
                    Namadpn.setError("Email Harus Diisi");
                } else if (Namablkng.getText().toString().length() == 0) {
                    Namablkng.setError("Nama Belakang Harus Diisi");
                } else if (Tempatlhr.getText().toString().length() == 0) {
                    Tempatlhr.setError("Tempat Lahir Harus Diisi");
                } else if (Tgllhr.getText().toString().length() == 0) {
                    Tgllhr.setError("Tanggal Lahir Harus Diisi");
                } else if (Alamat.getText().toString().length() == 0) {
                    Alamat.setError("Alamat Harus Diisi");
                } else if (Telepon.getText().toString().length() == 0) {
                    Telepon.setError("Telepon Harus Diisi");
                } else if (Email.getText().toString().length() == 0) {
                    Email.setError("Email Harus Diisi");
                } else if (Pass.getText().toString().length() == 0) {
                    Pass.setError("Password Harus Diisi");
                } else if (Inpass.getText().toString().length() == 0) {
                    Inpass.setError("Maasukan Password Harus Diisi");
                } else AlertDialog();
            }

            public boolean pattern(String pass) {
                String patt = "^(?=.*[0-9])" +
                        "(?=.*[a-z])" +
                        "(?=.*[A-Z])" +
                        "(?=.*[@#$%^&+=])" +
                        "(?=\\S+$).{4,}" +
                        "$";
                return Pattern.compile("^" +
                        "(?=.*[0-9])" +
                        "(?=.*[a-z])" +
                        "(?=.*[A-Z])" +
                        "(?=.*[@#$%^&+=])" +
                        "(?=\\S+$).{4,}" +
                        "$").matcher(pass).matches();
            }
            public void isValidPassword(){
                String err = "Panjang password minimal adalah 8 karakter dengan angka, huruf " +
                        "besar, huruf kecil, dan spesial karakter (seperti: @,&,#,?)";
                if (TextUtils.isEmpty(Pass.getText().toString().trim()) ||
                        Pass.getText().toString().trim().length() < 8) {
                    Pass.setError(err);
                } else if (!pattern(Pass.getText().toString().trim())) {
                    Pass.setError(err);
                } else {
                    if (!Pass.getText().toString().trim().equals(
                            Inpass.getText().toString().trim())) {
                        Inpass.setError("Password harus sama");
                    }
                }
            }
        });
        Tgllhr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePick();
            }
        });

    }
    public void datePick() {
        Calendar d = Calendar.getInstance();
        tahun = d.get(Calendar.YEAR);
        bulan = d.get(Calendar.MONTH);
        hari = d.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dPD = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {
                    public void onDateSet(DatePicker view, int _tahun, int _bulan, int _hari) {
                        Tgllhr.setText(_hari + "-" + (_bulan + 1) + "-" + _tahun);
                    }
                }, tahun, bulan, hari
        );

        dPD.show();
    }
    public void AlertDialog(){
        AlertDialog.Builder ab = new AlertDialog.Builder(MainActivity.this);
        ab.setTitle("confirm");
        ab.setIcon(R.mipmap.ic_launcher_round);
        ab.setMessage("Apakah data Anda Sudah Benar");
        ab.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                CustomDialog();
            }
        });
        ab.setNegativeButton("CANCEL", null);
        ab.show();
    }

    public void CustomDialog() {
        final AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
        inflater = getLayoutInflater();
        dialogView = inflater.inflate(R.layout.detail_pendaftran, null);
        mBuilder.setCancelable(true);
        mBuilder.setView(dialogView);
        mBuilder.setTitle("Detail Pendaftaran");
        mBuilder.setIcon(R.mipmap.ic_launcher_round);

        TextView data1 = dialogView.findViewById(R.id.data1);
        TextView data2 = dialogView.findViewById(R.id.data2);
        TextView data3 = dialogView.findViewById(R.id.data3);
        TextView data4 = dialogView.findViewById(R.id.data4);
        TextView data5 = dialogView.findViewById(R.id.data5);
        TextView data6 = dialogView.findViewById(R.id.data6);
        TextView data7 = dialogView.findViewById(R.id.data7);
        TextView data8 = dialogView.findViewById(R.id.data8);

        data1.setText(Namadpn.getText());
        data2.setText(Namablkng.getText());
        data3.setText(Tempatlhr.getText() + "," + Tgllhr.getText());
        data4.setText(Alamat.getText());
        data5.setText(jns);
        data6.setText(a);
        data7.setText(Telepon.getText());
        data8.setText(Email.getText());

        mBuilder.setPositiveButton("SELESAI", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "Pendaftaran Selesai",
                        Toast.LENGTH_LONG).show();
            }
        });

        mBuilder.setNegativeButton("KELLUAR", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                moveTaskToBack(true);
                finish();
                System.exit(0);
            }
        });


        mBuilder.show();
    }public void ChooseRB(View v) {
        boolean checked = ((RadioButton) v).isChecked();

        switch (v.getId()) {
            case R.id.lk:
                if (checked) {
                    jns = "Laki-Laki";
                }
                break;
            case R.id.pr:
                if (checked) {
                    jns = "Perempuan";
                }
                break;
            case R.id.type1:
                if (checked) {
                    a = "Islam";
                    mSecondGroup.clearCheck();
                    mThirdGroup.clearCheck();
                    mFourthGroup.clearCheck();
                }
                break;
            case R.id.type2:
                if (checked) {
                    a = "Kristen";
                    mSecondGroup.clearCheck();
                    mThirdGroup.clearCheck();
                    mFourthGroup.clearCheck();
                }
                break;
            case R.id.type3:
                if (checked) {
                    a = "Katolik";
                    mFirstGroup.clearCheck();
                    mThirdGroup.clearCheck();
                    mFourthGroup.clearCheck();
                }
                break;
            case R.id.type4:
                if (checked) {
                    a = "Hindu";
                    mFirstGroup.clearCheck();
                    mThirdGroup.clearCheck();
                    mFourthGroup.clearCheck();
                }
                break;
            case R.id.type5:
                if (checked) {
                    a = "Buddha";
                    mFirstGroup.clearCheck();
                    mSecondGroup.clearCheck();
                    mFourthGroup.clearCheck();
                }
                break;
            case R.id.type6:
                if (checked) {
                    a = "Konghucu";
                    mFirstGroup.clearCheck();
                    mSecondGroup.clearCheck();
                    mFourthGroup.clearCheck();
                }
                break;
            case R.id.type7:
                if (checked) {
                    a = "Aliran Kepercayaan";
                    mFirstGroup.clearCheck();
                    mSecondGroup.clearCheck();
                    mThirdGroup.clearCheck();
                }
                break;
            default:
                break;
        }
    }

}

