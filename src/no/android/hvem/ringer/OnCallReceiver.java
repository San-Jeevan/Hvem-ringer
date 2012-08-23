package no.android.hvem.ringer;

import no.android.hvem.ringer.R.layout;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.text.Layout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class OnCallReceiver extends BroadcastReceiver implements TaskCallback {
	private Context context;

	

	@Override
	public void onReceive(Context context, Intent intent) {
		this.context = context;
		PlateInfoTask task = new PlateInfoTask(this, context);
		task.execute("91782062");
	}

	@Override
	public void onComplete(InfoPack infopack) {
	
	    WindowManager wm = (WindowManager) context.getApplicationContext().getSystemService(Context.WINDOW_SERVICE);

	    WindowManager.LayoutParams params = new WindowManager.LayoutParams(
	            LayoutParams.MATCH_PARENT,
	            LayoutParams.WRAP_CONTENT,
	            WindowManager.LayoutParams.TYPE_SYSTEM_ALERT | 
	            WindowManager.LayoutParams.TYPE_SYSTEM_OVERLAY,
	            WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL |
	            WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
	            PixelFormat.TRANSLUCENT);
	    params.x = 50;
//	    params.height = LayoutParams.WRAP_CONTENT;
//	    params.width = LayoutParams.MATCH_PARENT;
//	    params.format = PixelFormat.TRANSLUCENT;


	    params.gravity = Gravity.TOP;
	    params.setTitle("Testing");
	    Button closeInviteButton = new Button(context);
	    closeInviteButton.setClickable(true);
	    closeInviteButton.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.ic_launcher));
	    closeInviteButton.setWidth(30);
	    
	    ImageView background = new ImageView(context);
	    background.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.pinkf));
	    background.setMinimumWidth(LayoutParams.MATCH_PARENT);
	    
	    TextView tv2 = new TextView(context);
	    tv2.setText(infopack.name);
	    
	    wm.addView(background, params);
	    wm.addView(tv2, params);
	}

	@Override
	public void onError(String error) {
		// TODO Auto-generated method stub
		
	}

}
