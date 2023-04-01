package it.units.img_processing_studemt_app;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;

import org.opencv.android.OpenCVLoader;
import org.opencv.android.Utils;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;
import androidx.appcompat.widget.Toolbar;

import it.units.img_processing_studemt_app.fragments.DescriptionFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DescriptionFragment descriptionFragment = (DescriptionFragment) getSupportFragmentManager().findFragmentById(R.id.desc);
        descriptionFragment.setDescription("miao");
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(view -> {
            ImageView imageView = findViewById(R.id.cameraman);
            if (OpenCVLoader.initDebug()) {
                Log.d("Loaded", "success");
                BitmapDrawable bitmapDrawable = (BitmapDrawable) imageView.getDrawable();
                Bitmap bitmap = bitmapDrawable.getBitmap();
                Mat gray = new Mat();
                Mat cannyMat = new Mat();
                Utils.bitmapToMat(bitmap,gray);
                Bitmap editedBitmap = Bitmap.createBitmap(bitmapDrawable.getBitmap().getWidth(), bitmapDrawable.getBitmap().getHeight(), Bitmap.Config.RGB_565);

                Imgproc.Canny(gray, cannyMat, 50, 150);

                Utils.matToBitmap(cannyMat, editedBitmap);

                imageView.setImageBitmap(editedBitmap);
            } else {
                Log.d("Loaded", "error");
            }

        });



    }
}