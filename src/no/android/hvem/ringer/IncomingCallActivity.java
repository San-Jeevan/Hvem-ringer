package no.android.hvem.ringer;

import android.app.Activity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.WindowManager;
import android.widget.TextView;

public class IncomingCallActivity extends Activity implements TaskCallback {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Logg.d("IncomingCallActivity: onCreate: ");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main2);
		String number = getIntent().getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER);
		PlateInfoTask asyncthread = new PlateInfoTask(this, getApplicationContext());
		asyncthread.execute("91782062");
	}

	@Override
	public void onComplete(InfoPack infopack) {
		TextView text = (TextView) findViewById(R.id.textView1);
		text.setText("Incoming call from " + infopack.name);
	}

	@Override
	public void onError(String error) {
		// TODO Auto-generated method stub

	}
}
