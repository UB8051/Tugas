package com.example.tugaspam;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    String a,b;
    Button Daftar, Keluar;
    RadioButton lk, pr;
    TextInputEditText Namadpn, Namablkng, Tempatlhr, Tgllhr, Alamat, Telepon , Email, Pass, Inpass;
    TextView data1, data2, data3, data4, data5, data6, data7, data8;
    RadioGroup Jns, mFirstGroup, mSecondGroup, mThirdGroup,mFourthGroup;
    private boolean isChecking = true;
    private int mCheckedId = R.id.type1;
    LayoutInflater inflater;
    View dialogView;

//    private void kosong(){
//        txt_namadpn.findViewById(R.id.data1);
//        txt_namablkng.findViewById(R.id.data2);
//        txt_ttl.findViewById(R.id.data3);
//        txt_almt.findViewById(R.id.data4);
//        txt_telp.findViewById(R.id.data7);
//        txt_mail.findViewById(R.id.data8);
//    }

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
        Jns = findViewById(R.id.Jns);
        Telepon = findViewById(R.id.input_telepon);
        Email = findViewById(R.id.input_email);
        Pass = findViewById(R.id.input_password);
        Inpass = findViewById(R.id.input_masukan_password);

        mFirstGroup = (RadioGroup) findViewById(R.id.first_group);
        mSecondGroup = (RadioGroup) findViewById(R.id.second_group);
        mThirdGroup = (RadioGroup) findViewById(R.id.third_group);
        mFourthGroup = (RadioGroup) findViewById(R.id.fourth_group);

        lk = (RadioButton) findViewById(R.id.lk);
        pr = (RadioButton) findViewById(R.id.pr);
        mFirstGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId != -1 && isChecking) {
                    isChecking = false;
                    mSecondGroup.clearCheck();
                    mThirdGroup.clearCheck();
                    mFourthGroup.clearCheck();
                    mCheckedId = checkedId;
                }
                isChecking = true;
            }
        });

        mSecondGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId != -1 && isChecking) {
                    isChecking = false;
                    mFirstGroup.clearCheck();
                    mThirdGroup.clearCheck();
                    mFourthGroup.clearCheck();
                    mCheckedId = checkedId;
                }
                isChecking = true;
            }
        });

        mThirdGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId != -1 && isChecking) {
                    isChecking = false;
                    mFirstGroup.clearCheck();
                    mSecondGroup.clearCheck();
                    mFourthGroup.clearCheck();
                    mCheckedId = checkedId;
                }
                isChecking = true;
            }
        });

        mFourthGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId != -1 && isChecking) {
                    isChecking = false;
                    mFirstGroup.clearCheck();
                    mSecondGroup.clearCheck();
                    mThirdGroup.clearCheck();
                    mCheckedId = checkedId;
                }
                isChecking = true;
            }
        });

        Keluar = (Button) findViewById(R.id.button1);
        Keluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveTaskToBack(true);
                finish();
                System.exit(0);
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

        });

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
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
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
        data6.setText(a);
        data7.setText(Telepon.getText());
        data8.setText(Email.getText());

        mBuilder.setPositiveButton("SELESAI", null);

        mBuilder.setNegativeButton("KELLUAR", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                moveTaskToBack(true);
                finish();
                System.exit(0);
            }
        });


        mBuilder.show();
    }

    public void JenisKlmn (View view) {

        Boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.lk:
                if (checked)
                    a = "Laki-Laki";
                mSecondGroup.clearCheck();
                mThirdGroup.clearCheck();
                mFourthGroup.clearCheck();
                break;

            case R.id.pr:
                if (checked)
                    a = "Perempuan";
                mFirstGroup.clearCheck();
                mThirdGroup.clearCheck();
                mFourthGroup.clearCheck();
                break;
        }
    }

//    public void Agama(View view) {
//
//        Boolean checked = ((RadioButton) view).isChecked();
//
//        switch (view.getId()) {
//            case R.id.first_group:
//                if (checked)
//                    Agama = "Islam";
//                mSecondGroup.clearCheck();
//                mThirdGroup.clearCheck();
//                mFourthGroup.clearCheck();
//                break;
//
//            case R.id.second_group:
//                if (checked)
//                    Agama = "Katolik";
//                mFirstGroup.clearCheck();
//                mThirdGroup.clearCheck();
//                mFourthGroup.clearCheck();
//                break;
//
//            case R.id.third_group:
//                if (checked)
//                    Agama = "Buddha";
//                mFirstGroup.clearCheck();
//                mSecondGroup.clearCheck();
//                mFourthGroup.clearCheck();
//                break;
//
//            case R.id.fourth_group:
//                if (checked)
//                    Agama = "Aliran Kepercayaan";
//                mFirstGroup.clearCheck();
//                mThirdGroup.clearCheck();
//                mSecondGroup.clearCheck();
//                break;
//        }
//        isChecking = true;
//    }
}

