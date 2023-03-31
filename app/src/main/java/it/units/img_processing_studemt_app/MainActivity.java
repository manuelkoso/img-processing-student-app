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

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(view -> {
            ImageView imageView = (ImageView) findViewById(R.id.cameraman);
            BitmapDrawable bitmapDrawable = (BitmapDrawable) imageView.getDrawable();
            Bitmap bitmap = bitmapDrawable.getBitmap();
            Mat gray = new Mat();
            Mat cannyMat = new Mat();
            Utils.bitmapToMat(bitmap,gray);
            Bitmap editedBitmap = Bitmap.createBitmap(bitmapDrawable.getBitmap().getWidth(), bitmapDrawable.getBitmap().getHeight(), Bitmap.Config.RGB_565);
            Imgproc.Canny(gray, cannyMat, 50, 150);
            Utils.matToBitmap(cannyMat, editedBitmap);
            imageView.setImageBitmap(editedBitmap);
        });



    }
}