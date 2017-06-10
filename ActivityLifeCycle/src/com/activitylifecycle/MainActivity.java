package com.activitylifecycle;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private String TAG = "This Activity";
	private TextView tvEditor;
	private EditText etWrite;
	private File filename;
	private TextView tvRead;
	private TextView tvFileName;
	private FileOutputStream output;
	private String filename1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Toast.makeText(MainActivity.this, "onCreate", Toast.LENGTH_SHORT).show();
		Log.i(TAG, "onCreate");

		
		tvFileName=(TextView)findViewById(R.id.textView1);

//        File filepath = Environment.getExternalStorageDirectory();
//        File dir = new File(filepath.getAbsolutePath()
//                + "/" + getString(R.string.app_name) + "/Media" + "/" + getString(R.string.app_name) + " Profile Pictures/");
//
//        
//        File myFile = new File("/sdcard/AAA/"+filename);  
//        try {
//			myFile.createNewFile();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}  
//        if (!dir.exists())
//            dir.mkdirs();
//
//
//        File file = new File(dir, "vinay.jpg");
        
		File filepath = Environment.getExternalStorageDirectory();
		File dir = new File(filepath.getAbsolutePath() + "/" + "AAA" + "/");

//		if (!dir.exists())
			dir.mkdirs();

		filename = new File(dir, "simple.txt");

		filename.mkdirs();
		try {
			filename.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			tvFileName.setText(filename1+e);
		}
//		filename1 = "" + filename;
		tvFileName.setText(filename+"");
//		
//		Toast.makeText(MainActivity.this, filename1, Toast.LENGTH_SHORT).show();
//		createfile(filename1);
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();

//		Toast.makeText(MainActivity.this, "onStart", Toast.LENGTH_SHORT).show();
		Log.i(TAG, "onStart");

		// readfile(filename);
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();

//		Toast.makeText(MainActivity.this, "onResume", Toast.LENGTH_SHORT).show();
		Log.i(TAG, "onResume");
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();

//		Toast.makeText(MainActivity.this, "onPause", Toast.LENGTH_SHORT).show();
		Log.i(TAG, "onPause");
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();

//		Toast.makeText(MainActivity.this, "onStop", Toast.LENGTH_SHORT).show();
		Log.i(TAG, "onStop");
	}

	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();

//		Toast.makeText(MainActivity.this, "onRestart", Toast.LENGTH_SHORT).show();
		Log.i(TAG, "onRestart");
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();

//		Toast.makeText(MainActivity.this, "onDestroy", Toast.LENGTH_SHORT).show();
		Log.i(TAG, "onDestroy");
	}

	public void writefile(File filename2) {
		// Scanner scan=new Scanner(System.in);
		try {
			// FileWriter writter=new FileWriter("myfile.txt",true);
			// BufferedWriter out = new BufferedWriter(new
			// FileWriter(filename2));
			// System.out.print("Writing Something: ");
			etWrite.setText("vinay");
			// out.write(tvEditor.getText().toString());
			// out.newLine();
			// out.close();
			// System.out.println("\nFile Writen Succesfully");
			String data = tvEditor.getText().toString();

			filename2.createNewFile();
			FileOutputStream fOut = new FileOutputStream(filename2);
			OutputStreamWriter myOutWriter = new

			OutputStreamWriter(fOut);
			myOutWriter.append(data);
			myOutWriter.close();
			fOut.close();

			// FileOutputStream fOut = new FileOutputStream(filename2);
			//
			// OutputStreamWriter myOutWriter = new
			// OutputStreamWriter(openFileOutput(filename2,
			// Context.MODE_APPEND));
			// myOutWriter.append(data);
			// myOutWriter.close();
			// fOut.close();

			Toast.makeText(MainActivity.this, "File Writen Succesfully", Toast.LENGTH_SHORT).show();

		} catch (IOException e) {
			// System.out.println(e.getMessage());
			etWrite.setText("" + e);
		}
	}

	public void readfile(File filename2) {
		try {
			BufferedReader in = new BufferedReader(new FileReader(filename2));
			String str;
			while ((str = in.readLine()) != null) {
				// System.out.println(str);
				etWrite.setText(str);

			}
			Toast.makeText(MainActivity.this, "File Read Succesfully", Toast.LENGTH_SHORT).show();
			Log.i(TAG, "File Read Succesfully");
			// System.out.println("\nFile Read Succesfully");
		} catch (IOException e) {
			// System.out.println(e.getMessage());
			etWrite.setText("" + e);
		}
	}

	public void createfile(String filename) {
		try {
			File file = new File(filename);
			if (file.createNewFile())
				Toast.makeText(MainActivity.this, "File is created", Toast.LENGTH_SHORT).show();
			// System.out.println("File Successfully Created!!");
			else
				Toast.makeText(MainActivity.this, "Error, file already exists.", Toast.LENGTH_SHORT).show();
			// System.out.println("Error, file already exists.");
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	//
	// public void createfile() {
	//
	// tvFileName = (TextView) findViewById(R.id.textView1);
	// tvRead = (TextView) findViewById(R.id.textView2);
	// etWrite = (EditText) findViewById(R.id.editText1);
	// Toast.makeText(MainActivity.this, "File is created",
	// Toast.LENGTH_SHORT).show();
	//
	//
	// try {
	// output = new FileOutputStream(filename);
	// } catch (FileNotFoundException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	//
	// tvFileName.setText(filename + "");
	// Toast.makeText(MainActivity.this, dir + "File is created",
	// Toast.LENGTH_SHORT).show();
	// }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
