package com.example.android.emojify;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.util.SparseArray;
import android.widget.Toast;

import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.face.Face;
import com.google.android.gms.vision.face.FaceDetector;
import com.google.android.gms.vision.face.Landmark;

public class Emojifier {
    private static final String TAG = "Emojifier";

    static void detectFaces(Context context, Bitmap bitmap) {
        FaceDetector faceDetector = new FaceDetector.Builder(context)
                .setTrackingEnabled(false)
                .setLandmarkType(FaceDetector.ALL_LANDMARKS)
                .build();

        Frame frame = new Frame.Builder().setBitmap(bitmap).build();

        SparseArray<Face> faces = faceDetector.detect(frame);

        int numberOfFaces = faces != null ? faces.size() : 0;
        Toast.makeText(context, "" + numberOfFaces, Toast.LENGTH_SHORT).show();
        Log.d(TAG, "Number of faces detected: " + numberOfFaces);

        faceDetector.release();
    }
}
