package com.example.realsoloeat;

//import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.soloeat.R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {
    public static final int PERMISSION_ACCESS_LOCATION = 1001;

    private GoogleMap googleMap;
    //현재위치 사용 권한 허용여부
    boolean locationPermissionGranted = false;
    boolean isLocationEnabled = false;
    SupportMapFragment mapFragment;
    GoogleApiAvailability apiAvailability;  //GoogleApi 사용가능여부 체크를 위한 변수

    //현재위치를 가져오기 위한 client 선언
    FusedLocationProviderClient fusedLocationClient;

    Location myLocation;

    LinearLayout layoutdetail;
    TextView restrant;
    TextView event;
    TextView location;

    Button apply;
    Button invite;
    ArrayList<Restrant> list;

    Button menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layoutdetail = findViewById(R.id.layoutdetail);
        restrant = findViewById(R.id.restrant);
        event = findViewById(R.id.event);
        location = findViewById(R.id.location);

        apply = findViewById(R.id.applyActivity);
        invite = findViewById(R.id.inviteActivity);
        layoutdetail.setVisibility(View.GONE);
        menu = findViewById(R.id.menu);

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NavActivity.class);
                startActivity(intent);
            }
        });

        //모집하기 액티비티 연결
        invite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ClusterActivity.class);
                startActivity(intent);
            }
        });


        //지원하기 액티비티 연결
        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, JoinActivity.class);
                startActivity(intent);
            }
        });

        mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
//        mapFragment.getMapAsync(this);
        //GoogleApi 사용가능여부
        apiAvailability = GoogleApiAvailability.getInstance();

        // 접근권한 허용여부 가져오기
        int permissionCheckFineLocation = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION);
        int permissionCheckCoarseLocation = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION);

        //권한이 있는 경우
        if (permissionCheckFineLocation == PackageManager.PERMISSION_GRANTED
                && permissionCheckCoarseLocation == PackageManager.PERMISSION_GRANTED) {

            locationPermissionGranted = true;

            //위치정보 사용 활성화여부 체크
            getIsLocationEnabled();
        }
        //권한이 없는 경우
        else {
            //권한 허용/거부 팝업 띄우기
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION}, PERMISSION_ACCESS_LOCATION);
            }

        }




        // SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
       // mapFragment.getMapAsync(this);

    }

    /**
     * 1-2. 위치정보 권한 허용/거부 결과 처리
     * @param requestCode: 권한 요청코드
     * @param permissions: 권한 배열
     * @param grantResults: 혀용/거부
     *
     * Android 6.0 이상에서 권한요청을 하고 사용자가 허용/거부 한 후의 callback 메서드로
     * 사용자의 선택에 따라 locationPermissionGranted를 true 또는 false로 설정
     *
     */

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {

        switch (requestCode) {
            case PERMISSION_ACCESS_LOCATION: {
                //권한 허용했을 경우
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if (grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                        locationPermissionGranted = true;
                    } else {
                        locationPermissionGranted = false;
                    }
                }
                //권한 거부했을 경우
                else {
                    locationPermissionGranted = false;
                }

                //위치정보 사용 활성화여부 체크
                getIsLocationEnabled();

                break;
            }

            default:

                break;
        }
    }

    /**
     * 2. 위치정보 사용 가능여부 체크
     *
     * GPS, Network를 이용한 위치정보 사용 가능한지 여부를 체크하며
     * 둘 중 하나라도 사용 가능할 경우 isLocationEnabled를 true로 설정
     * 위치정보 사용이 불가능할 경우 사용자에게 안내 팝업 띄워 설정화면으로 이동할 수 있도록 함
     */
    public void getIsLocationEnabled() {

        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        boolean isGPSEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        boolean isNetworkEnabled = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);

        if (isGPSEnabled || isNetworkEnabled) {
            isLocationEnabled = true;
        }

        //위치정보 사용 가능할 경우
        if (isLocationEnabled) {

            //GoogleApi가 사용 가능할 경우 지도 생성
            if (ConnectionResult.SUCCESS == apiAvailability.isGooglePlayServicesAvailable(this)) {
                mapFragment.getMapAsync(this);
            }
            //GoogleApi가 사용 불가능할 경우 안내메시지 팝업
            else {
//                apiAvailability.getErrorDialog(getActivity(), apiAvailability.isGooglePlayServicesAvailable(getActivity()), 0).show();
            }
        }
    }

    @SuppressLint("MissingPermission")
    @Override
    public void onMapReady(GoogleMap googleMap) {

        this.googleMap = googleMap;

        googleMap.setMyLocationEnabled(true);
        googleMap.getUiSettings().setRotateGesturesEnabled(false);

        Restrant restrant0 = new Restrant("고랭","서울시 동작구 상도동 507-3",new LatLng(37.49446562565, 126.95868841164719),2);
        Restrant restrant1 = new Restrant("뚝배기 스파게티","서울시 동작구 상도동 508-4",new LatLng(37.49468092911922, 126.95897309983381),3);
        Restrant restrant2 = new Restrant("스톤 504","서울시 동작구 상도동 507-11",new LatLng(37.494825713454496, 126.95778658404008),3);
        Restrant restrant3 = new Restrant("동경야네","서울시 동작구 상도동 504 ",new LatLng(37.494823401088276, 126.95749208218982),1);
        Restrant restrant4 = new Restrant("아쯔다무라","서울시 동작구 상도동 494-11",new LatLng(37.49547608685569, 126.95413773986135),2);
        Restrant restrant5 = new Restrant("청년다방","서울시 동작구 상도동 502-5",new LatLng(37.495362225639, 126.95607699753279),2);
        Restrant restrant6 = new Restrant("신룽푸마라탕","서울시 동작구 상도동 505-6 ",new LatLng(37.495250701258136, 126.9567013975329),1);
        Restrant restrant7 = new Restrant("스시이야기","서울시 동작구 상도동 501",new LatLng(37.49553614815076, 126.95536002451834),2);

        list = new ArrayList<>();
        list.add(restrant0);
        list.add(restrant1);
        list.add(restrant2);
        list.add(restrant3);
        list.add(restrant4);
        list.add(restrant5);
        list.add(restrant6);
        list.add(restrant7);

        for(Restrant data : list){
            LatLng latLng = data.getLatLng();
            MarkerOptions markerOptions = new MarkerOptions();
            markerOptions.position(latLng);
            markerOptions.title(data.getName());
            googleMap.addMarker(markerOptions);
        }

        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(list.get(0).getLatLng(), 15));

        googleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                layoutdetail.setVisibility(View.GONE);
            }
        });

        googleMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {

                String title = marker.getTitle();

                Restrant item = null;
                for(Restrant data : list){
                    if(data.getName().equals(title)){
                        item = data;
                    }
                }

                restrant.setText(item.getName());
                event.setText(String.valueOf(item.getEvnet()) + "건");
                location.setText(item.getLoaction());



                //마커 선택 시 하단에 레이아웃 visible 처리
                //마커 객체 데이터(타이틀)을 기준으로 arraylist에서 추가정보 조회해와서

                layoutdetail.setVisibility(View.VISIBLE);
                return false;
            }
        });
    }
}