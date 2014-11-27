package co.com.educame.controladores;

import android.app.Activity;
import android.app.ProgressDialog;

public abstract class AbstractController {

	private Activity activity;
	private ProgressDialog progressDialog;
	
	public AbstractController(Activity activity){
		super();
		this.activity= activity;
	}
	
	public void showProgressDialog(String title, String message){
		progressDialog =  new ProgressDialog(getActivity());
		progressDialog.setCancelable(false);
		progressDialog.setTitle(title);
		progressDialog.setMessage(message);
		progressDialog.show();
		
	}
	
	public void dismissProgressDialog(){
		progressDialog.dismiss();
	}

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}
	
	
	
	
	 
}
