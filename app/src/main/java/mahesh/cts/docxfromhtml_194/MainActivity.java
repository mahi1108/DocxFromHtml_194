package mahesh.cts.docxfromhtml_194;

import android.Manifest;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.aspose.words.Document;
import com.aspose.words.License;
import com.aspose.words.SaveFormat;

import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityCompat.requestPermissions(MainActivity.this,
                new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},123);
        Button b = findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    License l = new License();
                    l.setLicense(getResources().openRawResource(R.raw.license));

                    InputStream isr = getAssets().open("GeneratedTemplate.html");
                    String dest_file = "/storage/emulated/0/GeneratedTemplate.docx";

                    Document d = new Document(isr);
                    d.save(dest_file, SaveFormat.DOCX);

                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        });
    }
}
