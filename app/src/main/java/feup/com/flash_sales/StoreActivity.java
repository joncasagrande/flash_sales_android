package feup.com.flash_sales;

import android.Manifest;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import butterknife.BindView;
import butterknife.ButterKnife;
import feup.com.flash_sales.model.Store;
import feup.com.flash_sales.utils.LocalInfoDialog;
import feup.com.flash_sales.utils.MapUtils;
import feup.com.flash_sales.utils.Mock;
import feup.com.flash_sales.utils.PermissionUtils;

/**
 * Created by jhonny on 06-01-2018.
 */

public class StoreActivity extends AppCompatActivity implements OnMapReadyCallback{

    private static final String TAG = StoreActivity.class.getSimpleName();
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    MapFragment mapView;

    private GoogleMap googleMap;
    private Store store;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);
        ButterKnife.bind(this);
        String storeId = getIntent().getStringExtra(getString(R.string.store));
        store = Mock.getStore(storeId);

        toolbar.setTitle(store.getName());
        setSupportActionBar(toolbar);

        // Check if google play services is available
        isGooglePlayServicesAvailable();
        mapView = (MapFragment) getFragmentManager().findFragmentById(R.id.mapView);
        mapView.getMapAsync(this);

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        Log.d(TAG, "GoogleMap loaded.");
        this.googleMap = googleMap;

        // Check the Location Permissions
        checkLocationPermission();

        // First search, get the eventos
        loadStore();
    }

    private void loadStore(){
        LatLng latLng = new LatLng(store.getAddress().getLatitude(),store.getAddress().getLongitude());
        googleMap.addMarker(new MarkerOptions()
                .position(latLng)
                .snippet(store.getName()));

        googleMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                if (marker.getSnippet() == null) {
                    googleMap.moveCamera(CameraUpdateFactory.zoomIn());
                    return true;
                }
                LocalInfoDialog.showDialog(getSupportFragmentManager(), store);
                return true;
            }
        });
        moveToCurrentLocation(latLng);
    }

    private void moveToCurrentLocation(LatLng currentLocation)
    {
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(currentLocation,15));
        // Zoom in, animating the camera.
        googleMap.animateCamera(CameraUpdateFactory.zoomIn());
        // Zoom out to zoom level 10, animating with a duration of 2 seconds.
        googleMap.animateCamera(CameraUpdateFactory.zoomTo(15), 2000, null);


    }
    private void clearMap() {
        googleMap.clear();
    }

    public void onLocationPermissionGranted() {
        // If Location Permissions are granted, set the user location on Map
        if (googleMap != null) {
            MapUtils.setUserLocation(this, googleMap);
            MapUtils.enableUserLocation(this, googleMap);
        }
    }
    /**
     * Check if Google Play Service is available, and display an error dialog if not.
     *
     * @return
     */
    public boolean isGooglePlayServicesAvailable() {
        GoogleApiAvailability googleAPI = GoogleApiAvailability.getInstance();
        int result = googleAPI.isGooglePlayServicesAvailable(this);
        if (ConnectionResult.SUCCESS == result) {
            Log.d(TAG, "Google Play Services is available.");
            return true;
        } else {
            googleAPI.getErrorDialog(this, result, 0).show();
            return false;
        }
    }

    /**
     * Check if the Location Permissions are granted, requesting the permissions to the user if necessary.
     * And, call 'onLocationPermissionGranted()' on permissions granted.
     */
    public void checkLocationPermission() {
        if (!PermissionUtils.checkLocationPermission(this)) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION},
                        PermissionUtils.PERMISSIONS_LOCATION);
            }
        } else {
            onLocationPermissionGranted();
        }
    }

}
