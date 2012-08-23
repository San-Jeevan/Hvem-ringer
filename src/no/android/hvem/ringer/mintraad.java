package no.android.hvem.ringer;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class mintraad extends Activity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// Remove title bar
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);

		// Remove notification bar
		this.getWindow().addFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL);
		this.getWindow().addFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE);
		

		super.onCreate(savedInstanceState);
		setContentView(R.layout.dialog);

		// TextView minTv2 = (TextView) findViewById(R.id.Tv2);
		// minTv2.setText((getIntent().getData().getScheme()+
		// getIntent().getData().getSchemeSpecificPart()));

		// TextView mTextSample = (TextView) findViewById(R.id.text);
		String lol = "";
		//lol = getIntent().getData().getQueryParameter("author");
		System.out.print("gsdfdsf");
		// mTextSample = (TextView) findViewById(R.id.text1);
		// mTextSample.setText(getIntent().getData().getQueryParameter("nick"));
	}
}//