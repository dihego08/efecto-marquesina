package com.example.marquesina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    ScrollView scrollView;
    Button mas, menos;
    ImageButton start, pause;
    int vel_start = 1;
    final Handler handler= new Handler();
    boolean flag = false;
    Runnable r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) this.findViewById (R.id.tv);
        start = findViewById(R.id.start);
        pause = findViewById(R.id.pause);
        mas = findViewById(R.id.mas);
        menos = findViewById(R.id.menos);
        scrollView = findViewById(R.id.sc);

        get_texto();

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag){

                }else{
                    vel_start = 1;
                    ejecutar();
                    flag = true;
                }
            }
        });
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handler.removeCallbacks(r);
                vel_start = 0;
                flag = false;
            }
        });

        mas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vel_start += 1;
            }
        });
        menos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(vel_start < 2){
                    vel_start = 1;
                }else{
                    vel_start -= 1;
                }
            }
        });
    }
    private void ejecutar(){
        r = new Runnable() {
            public void run() {
                metodoEjecutar(vel_start);
                handler.postDelayed(this, 100);
            }
        };
        handler.postDelayed(r, 0);
    }
    private void metodoEjecutar(int vel) {
        System.out.println("VEL METODO " + vel);
        scrollView.scrollTo(0, scrollView.getScrollY() + vel);
    }
    public void get_texto(){
        tv.setText("Lorem ipsum dolor sit amet, consectetur adipisicing elit. Accusantium accusamus adipisci quo tempora rem voluptate repudiandae blanditiis voluptas sed libero perferendis debitis, aut quasi, enim laborum quam reprehenderit consequatur quisquam.\n" +
                "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Accusantium accusamus adipisci quo tempora rem voluptate repudiandae blanditiis voluptas sed libero perferendis debitis, aut quasi, enim laborum quam reprehenderit consequatur quisquam.\n" +
                "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Accusantium accusamus adipisci quo tempora rem voluptate repudiandae blanditiis voluptas sed libero perferendis debitis, aut quasi, enim laborum quam reprehenderit consequatur quisquam.\n" +
                "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Accusantium accusamus adipisci quo tempora rem voluptate repudiandae blanditiis voluptas sed libero perferendis debitis, aut quasi, enim laborum quam reprehenderit consequatur quisquam.");
    }
}