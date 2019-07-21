package com.example.mapainteractivo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class FotosEdificio extends AppCompatActivity {
    String id;
    ImageView img1, img2, img3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fotos_edificio);

        img1= findViewById(R.id.imgEdi1);
        img2= findViewById(R.id.imgEdi2);
        img3= findViewById(R.id.imgEdi3);
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            finish();
            return;
        }


        id = extras.getString("id");

        switch (id) {
            case "1":
                img1.setImageResource(R.drawable.imagen_t);
                img2.setImageResource(R.drawable.imagen_t1);
                img3.setImageResource(R.drawable.imagen_t2);
                break;
            case "2":
                img1.setImageResource(R.drawable.imagen_b11);
                img2.setImageResource(R.drawable.imagen_b12);
                img3.setImageResource(R.drawable.imagen_b13);
                break;
            case "3":
                img1.setImageResource(R.drawable.imagen_u);
                img2.setImageResource(R.drawable.imagen_u1);
                img3.setImageResource(R.drawable.imagen_u3);
                break;
            case "4":
                img1.setImageResource(R.drawable.imagen_a1);
                img2.setImageResource(R.drawable.imagen_a2);
                img3.setImageResource(R.drawable.imagen_a3);
                break;
            case "5":
                img1.setImageResource(R.drawable.imagen_a11);
                img2.setImageResource(R.drawable.imagen_a12);
                img3.setImageResource(R.drawable.imagen_a13);
                break;
            case "6":
                img1.setImageResource(R.drawable.imagen_b1);
                img2.setImageResource(R.drawable.imagen_b2);
                img3.setImageResource(R.drawable.imagen_b3);
                break;
            case "7":
                img1.setImageResource(R.drawable.imagen_b31);
                img2.setImageResource(R.drawable.imagen_b32);
                img3.setImageResource(R.drawable.imagen_b33);
                break;
            case "8":
                img1.setImageResource(R.drawable.imagen_c11);
                img2.setImageResource(R.drawable.imagen_c12);
                img3.setImageResource(R.drawable.imagen_c13);
                break;
            case "9":
                img1.setImageResource(R.drawable.imagen_c21);
                img2.setImageResource(R.drawable.imagen_c22);
                img3.setImageResource(R.drawable.imagen_c23);
                break;
            case "10":
                img1.setImageResource(R.drawable.imagen_c31);
                img2.setImageResource(R.drawable.imagen_c32);
                img3.setImageResource(R.drawable.imagen_c33);
                break;
            case "12":
                img1.setImageResource(R.drawable.imagen_k1);
                img2.setImageResource(R.drawable.imagen_k3);
                img3.setImageResource(R.drawable.imagen_k5);
                break;
            case "13":
                img1.setImageResource(R.drawable.imagen_x1);
                img2.setImageResource(R.drawable.imagen_x2);
                img3.setImageResource(R.drawable.imagen_x3);
                break;
            case "14":
                img1.setImageResource(R.drawable.imagen_b21);
                img2.setImageResource(R.drawable.imagen_b22);
                img3.setImageResource(R.drawable.imagen_b23);
                break;
            case "15":
                img1.setImageResource(R.drawable.imagen_e);
                img2.setImageResource(R.drawable.imagen_e1);
                img3.setImageResource(R.drawable.imagen_e3);
                break;
            case "16":
                img1.setImageResource(R.drawable.imagen_f1);
                img2.setImageResource(R.drawable.imagen_f2);
                img3.setImageResource(R.drawable.imagen_f3);
                break;
            case "17":
                img1.setImageResource(R.drawable.imagen_m1);
                img2.setImageResource(R.drawable.imagen_m2);
                img3.setImageResource(R.drawable.imagen_m3);
                break;
            case "18":
                img1.setImageResource(R.drawable.imagen_p1);
                img2.setImageResource(R.drawable.imagen_p2);
                img3.setImageResource(R.drawable.imagen_p3);
                break;
            case "19":
                img1.setImageResource(R.drawable.imagen_q1);
                img2.setImageResource(R.drawable.imagen_q2);
                img3.setImageResource(R.drawable.imagen_q3);
                break;
            case "20":
                img1.setImageResource(R.drawable.imagen_v);
                img2.setImageResource(R.drawable.imagen_v1);
                break;
            case "21":
                img1.setImageResource(R.drawable.imagen_y);
                img2.setImageResource(R.drawable.imagen_y1);
                img3.setImageResource(R.drawable.imagen_y2);
                break;
            case "22":
                img1.setImageResource(R.drawable.imagen_d31);
                img2.setImageResource(R.drawable.imagen_d32);
                img3.setImageResource(R.drawable.imagen_d33);
                break;
            case "23":
                img1.setImageResource(R.drawable.imagen_b41);
                img2.setImageResource(R.drawable.imagen_b42);
                img3.setImageResource(R.drawable.imagen_b43);
                break;
            case "24":
                img1.setImageResource(R.drawable.imagen_b51);
                img2.setImageResource(R.drawable.imagen_b52);
                img3.setImageResource(R.drawable.imagen_b53);
                break;
            case "25":
                img1.setImageResource(R.drawable.imagen_d1);
                img2.setImageResource(R.drawable.imagen_d2);
                img3.setImageResource(R.drawable.imagen_d3);
                break;
            case "26":
                img1.setImageResource(R.drawable.imagen_d11);
                img2.setImageResource(R.drawable.imagen_d12);
                img3.setImageResource(R.drawable.imagen_d13);
                break;
            case "27":
                img1.setImageResource(R.drawable.imagen_g);
                img2.setImageResource(R.drawable.imagen_g2);
                img3.setImageResource(R.drawable.imagen_g1);
                break;
            case "28":
                img1.setImageResource(R.drawable.imagen_z);
                img2.setImageResource(R.drawable.imagen_z1);
                img3.setImageResource(R.drawable.imagen_z2);
                break;
            case "29":
                img1.setImageResource(R.drawable.imagen_j1);
                img2.setImageResource(R.drawable.imagen_j2);
                img3.setImageResource(R.drawable.imagen_j3);
                break;
            case "30":
                img1.setImageResource(R.drawable.imagen_n1);
                img2.setImageResource(R.drawable.imagen_n2);
                img3.setImageResource(R.drawable.imagen_n3);
                break;
            case "31":
                img1.setImageResource(R.drawable.imagen_r1);
                img2.setImageResource(R.drawable.imagen_r2);
                img3.setImageResource(R.drawable.imagen_r3);
                break;
            case "32":
                img1.setImageResource(R.drawable.imagen_s1);
                img2.setImageResource(R.drawable.imagen_s2);
                img3.setImageResource(R.drawable.imagen_s3);
                break;
            case "33":
                img1.setImageResource(R.drawable.imagen_h);
                img2.setImageResource(R.drawable.imagen_h2);
                img3.setImageResource(R.drawable.imagen_h3);
                break;
            case "34":
                img1.setImageResource(R.drawable.imagen_o);
                img2.setImageResource(R.drawable.imagen_o1);
                img3.setImageResource(R.drawable.imagen_o3);
                break;
            case "35":
                img1.setImageResource(R.drawable.imagen_t11);
                img2.setImageResource(R.drawable.imagen_t21);
                img3.setImageResource(R.drawable.imagen_t31);
                break;
            case "37":
                img1.setImageResource(R.drawable.imagen_cd1a1);
                img2.setImageResource(R.drawable.imagen_cd1a2);
                img3.setImageResource(R.drawable.imagen_cd1a3);
                break;
            case "38":
                img1.setImageResource(R.drawable.imagen_cd21);
                img2.setImageResource(R.drawable.imagen_cd22);
                img3.setImageResource(R.drawable.imagen_cd23);
                break;
            case "39":
                img1.setImageResource(R.drawable.imagen_g12);
                img2.setImageResource(R.drawable.imagen_g13);
                img3.setImageResource(R.drawable.imagen_g14);
                break;

        }
       // img1.setImageResource(R.drawable.imagen_imagen_a1);



    }
}
