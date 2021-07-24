package hust.hungnq.bigfive;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class QRCodeScanner extends AppCompatActivity implements ZXingScannerView.ResultHandler{

    public static final int REQUEST_CAMERA = 1;
    public static final int cam = Camera.CameraInfo.CAMERA_FACING_BACK;
    private ZXingScannerView scannerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // activity scanner
        scannerView = new ZXingScannerView(this);
        setContentView(scannerView);

        if (checkPermission()){
            Toast.makeText(this, "Permision Granted", Toast.LENGTH_SHORT).show();
        }
        else requestPermission();
    }

    private boolean checkPermission(){
        return (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED);
    }

    private void requestPermission(){
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.CAMERA},
                REQUEST_CAMERA);

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void onRequestPermissionResult(int requestCode, String permission[], int[] grantResult){
        switch (requestCode){
            case REQUEST_CAMERA:
                if (grantResult.length > 0){
                    boolean cameraAccept = grantResult[0] == PackageManager.PERMISSION_GRANTED;
                    if (cameraAccept){
                        Toast.makeText(this, "Permission Cam Granted by User", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(this, "Permission Denied by User", Toast.LENGTH_SHORT).show();
                        if (shouldShowRequestPermissionRationale(Manifest.permission.CAMERA)){
                            showMessage("You need to granted the permission",
                                    new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            requestPermissions(new String[] {Manifest.permission.CAMERA}, REQUEST_CAMERA);
                                        }
                                    });

                        }
                    }
                }
                break;

            default:
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (checkPermission()) {
            if (scannerView == null){
                scannerView = new ZXingScannerView(this);
                setContentView(scannerView);
            }
            scannerView.setResultHandler(this);
            scannerView.startCamera();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        scannerView.stopCamera();
        scannerView = null;
    }

    private void showMessage(String message, DialogInterface.OnClickListener okListener){
        new AlertDialog.Builder(QRCodeScanner.this)
                .setMessage(message)
                .setPositiveButton("OK", okListener)
                .setNegativeButton("Cancel", null)
                .create()
                .show();
    }


    @Override
    public void handleResult(Result result) {
        final String rawResult = result.getText().toString();

        Toast.makeText(this, "Scan Result: " + rawResult, Toast.LENGTH_SHORT).show();
        finish();
    }

}