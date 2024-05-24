package com.my.musclemapp;

import android.Manifest;
import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.content.*;
import android.content.ClipData;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.net.Uri;
import android.os.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import java.io.*;
import java.io.File;
import java.text.*;
import java.util.*;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.*;
import org.json.*;
import android.Manifest;
import android.content.pm.PackageManager;
// For Android 11+
import android.provider.Settings;

public class RegisterActivity extends AppCompatActivity {
	
	public final int REQ_CD_FK = 101;
	
	private Timer _timer = new Timer();
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	private FirebaseStorage _firebase_storage = FirebaseStorage.getInstance();
	
	private boolean checkPermission1 = false;
	private String ppPath = "";
	private String ppName = "";
	private HashMap<String, Object> map = new HashMap<>();
	
	private LinearLayout linear2;
	private TextView textview2;
	private ImageView imageview1;
	private TextView textview3;
	private LinearLayout mob_text;
	private LinearLayout reg_text;
	private LinearLayout linear6;
	private LinearLayout linear7;
	private ImageView imageview2;
	private EditText edittext1;
	private ImageView imageview3;
	private EditText edittext2;
	private TextView textview4;
	
	private Intent FK = new Intent(Intent.ACTION_GET_CONTENT);
	private StorageReference Profileimg = _firebase_storage.getReference("Profileimg");
	private OnCompleteListener<Uri> _Profileimg_upload_success_listener;
	private OnSuccessListener<FileDownloadTask.TaskSnapshot> _Profileimg_download_success_listener;
	private OnSuccessListener _Profileimg_delete_success_listener;
	private OnProgressListener _Profileimg_upload_progress_listener;
	private OnProgressListener _Profileimg_download_progress_listener;
	private OnFailureListener _Profileimg_failure_listener;
	
	private DatabaseReference Users = _firebase.getReference("Users");
	private ChildEventListener _Users_child_listener;
	private SharedPreferences userid;
	private SharedPreferences first_run;
	private Intent open = new Intent();
	private TimerTask T;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.register);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		
		if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED
		|| ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
			ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1000);
		} else {
			initializeLogic();
		}
	}
	
	@Override
	public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
		super.onRequestPermissionsResult(requestCode, permissions, grantResults);
		if (requestCode == 1000) {
			initializeLogic();
		}
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear2 = findViewById(R.id.linear2);
		textview2 = findViewById(R.id.textview2);
		imageview1 = findViewById(R.id.imageview1);
		textview3 = findViewById(R.id.textview3);
		mob_text = findViewById(R.id.mob_text);
		reg_text = findViewById(R.id.reg_text);
		linear6 = findViewById(R.id.linear6);
		linear7 = findViewById(R.id.linear7);
		imageview2 = findViewById(R.id.imageview2);
		edittext1 = findViewById(R.id.edittext1);
		imageview3 = findViewById(R.id.imageview3);
		edittext2 = findViewById(R.id.edittext2);
		textview4 = findViewById(R.id.textview4);
		FK.setType("image/*");
		FK.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
		userid = getSharedPreferences("userid", Activity.MODE_PRIVATE);
		first_run = getSharedPreferences("first_run", Activity.MODE_PRIVATE);
		
		imageview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				startActivityForResult(FK, REQ_CD_FK);
			}
		});
		
		linear7.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (ppPath.length() > 0) {
					Profileimg.child(ppName).putFile(Uri.fromFile(new File(ppPath))).addOnFailureListener(_Profileimg_failure_listener).addOnProgressListener(_Profileimg_upload_progress_listener).continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
						@Override
						public Task<Uri> then(Task<UploadTask.TaskSnapshot> task) throws Exception {
							return Profileimg.child(ppName).getDownloadUrl();
						}}).addOnCompleteListener(_Profileimg_upload_success_listener);
					Log.d("FirebaseStorage", "Uploading file to: " + ppName);
					Log.d("FirebaseStorage", "File path: " + ppPath);
				}
				else {
					if (edittext1.getText().toString().equals("") || edittext2.getText().toString().equals("")) {
						SketchwareUtil.showMessage(getApplicationContext(), " Please add your name or number");
					}
					else {
						map = new HashMap<>();
						map.put("Mobile", edittext1.getText().toString());
						map.put("Name", edittext2.getText().toString());
						map.put("UID", edittext1.getText().toString());
						map.put("Verify", "false");
						Users.child(edittext1.getText().toString()).updateChildren(map);
						map.clear();
						userid.edit().putString("userid", edittext1.getText().toString()).commit();
						first_run.edit().putString("first_run", "no").commit();
						open.setClass(getApplicationContext(), MainActivity.class);
						startActivity(open);
						finish();
					}
				}
			}
		});
		
		_Profileimg_upload_progress_listener = new OnProgressListener<UploadTask.TaskSnapshot>() {
			@Override
			public void onProgress(UploadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				
			}
		};
		
		_Profileimg_download_progress_listener = new OnProgressListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onProgress(FileDownloadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				
			}
		};
		
		_Profileimg_upload_success_listener = new OnCompleteListener<Uri>() {
			@Override
			public void onComplete(Task<Uri> _param1) {
				final String _downloadUrl = _param1.getResult().toString();
				map = new HashMap<>();
				map.put("Mobile", edittext1.getText().toString());
				map.put("Name", edittext2.getText().toString());
				map.put("UID", edittext1.getText().toString());
				map.put("Verify", "false");
				map.put("ProfilePic", _downloadUrl);
				Users.child(edittext1.getText().toString()).updateChildren(map);
				map.clear();
				T = new TimerTask() {
					@Override
					public void run() {
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								userid.edit().putString("userid", edittext1.getText().toString()).commit();
								first_run.edit().putString("first_run", "no").commit();
								open.setClass(getApplicationContext(), MainActivity.class);
								startActivity(open);
								finish();
							}
						});
					}
				};
				_timer.schedule(T, (int)(1500));
			}
		};
		
		_Profileimg_download_success_listener = new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onSuccess(FileDownloadTask.TaskSnapshot _param1) {
				final long _totalByteCount = _param1.getTotalByteCount();
				
			}
		};
		
		_Profileimg_delete_success_listener = new OnSuccessListener() {
			@Override
			public void onSuccess(Object _param1) {
				
			}
		};
		
		_Profileimg_failure_listener = new OnFailureListener() {
			@Override
			public void onFailure(Exception _param1) {
				final String _message = _param1.getMessage();
				
			}
		};
		
		_Users_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onChildMoved(DataSnapshot _param1, String _param2) {
				
			}
			
			@Override
			public void onChildRemoved(DataSnapshot _param1) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		Users.addChildEventListener(_Users_child_listener);
	}
	
	private void initializeLogic() {
		linear7.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)30, 0xFF9352F4));
		if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
			Window w =RegisterActivity.this.getWindow();
			w.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
			w.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS); w.setStatusBarColor(0xFFFFFFFF);
		}
		getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
		getWindow().setStatusBarColor(0xFFFFFFFF);
		Window window =
		this.getWindow();
		
		window.setNavigationBarColor(
		Color.parseColor("#FFFFFF"));
		mob_text.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)30, (int)1, 0xFFD5D5D5, 0xFFFFFFFF));
		reg_text.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)30, (int)1, 0xFFD5D5D5, 0xFFFFFFFF));
		
		if (Build.VERSION.SDK_INT > 29) {
			    FileUtil.makeDir(FileUtil.getPackageDataDir(getApplicationContext()).concat(""));
		} else {
			    FileUtil.makeDir(FileUtil.getExternalStorageDir().concat(""));
		}
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);
		
		switch (_requestCode) {
			case REQ_CD_FK:
			if (_resultCode == Activity.RESULT_OK) {
				ArrayList<String> _filePath = new ArrayList<>();
				if (_data != null) {
					if (_data.getClipData() != null) {
						for (int _index = 0; _index < _data.getClipData().getItemCount(); _index++) {
							ClipData.Item _item = _data.getClipData().getItemAt(_index);
							_filePath.add(FileUtil.convertUriToFilePath(getApplicationContext(), _item.getUri()));
						}
					}
					else {
						_filePath.add(FileUtil.convertUriToFilePath(getApplicationContext(), _data.getData()));
					}
				}
				ppPath = _filePath.get((int)(0));
				ppName = Uri.parse(ppPath).getLastPathSegment();
				imageview1.setImageBitmap(FileUtil.decodeSampleBitmapFromPath(ppPath, 1024, 1024));
			}
			else {
				
			}
			break;
			default:
			break;
		}
	}
	
	public void _checkPermission() {
		checkPermission1 = false;
		
		// Android 6 to 12 check storage permission
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
			    // For Android 11+
			    if (Environment.isExternalStorageManager()) {
				        // The app has permission to read/write storage
				        // Add your function here
				        checkPermission1 = true;
				    } else {
				        // The app does not have permission to read/write storage
				        // Request permission from the user
				        Intent intent = new Intent(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION);
				        Uri uri = Uri.fromParts("package", getPackageName(), null);
				        intent.setData(uri);
				        startActivity(intent);
				    }
		} else {
			    // For Android 10 and lower
			    if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
				        requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 3000);
				    } else {
				        // Granted
				        // The app has permission to write storage
				        // Add your function here
				        checkPermission1 = true;
				    }
		}
		
		/*
if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
    requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 3000);
    // DENIED
} else {
    // Granted
    // Add your function here
}

// Instead of WRITE_EXTERNAL_STORAGE, you can change the permission you want to add

// The permission added here must also be added to Android Manifest.
// Example:
<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>

*/
	}
	
	
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input) {
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels() {
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels() {
		return getResources().getDisplayMetrics().heightPixels;
	}
}