package com.example.admin.project2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class PDFViewer extends AppCompatActivity {

    PDFView pdfView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdfviewer);

        pdfView = (PDFView) findViewById(R.id.pdfView);
        pdfView.fromAsset("manga_and_anime.pdf").load();
    }
}
