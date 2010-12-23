/* Author: 	Michael de Silva
 * Date:	22nd December 2010
 * Email:	michael@mwdesilva.com
 * Blog:	bsodmike.com
 * 
 * Demonstration of extending a ListActivity and passing data between
 * this activity and the subactivity.  This code is based on the 
 * tutorial provided by Google:
 * http://developer.android.com/resources/tutorials/views/hello-listview.html
 */

package com.google.example.helloListView;
 
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
 
public class modalPopup extends Activity implements OnClickListener{
    private static final String PUBLIC_STATIC_STRING_IDENTIFIER = null;
	private static final String TAG = "modalPopup";

	@Override  
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modalpopup);     

        // find views by id        
        TextView textData = (TextView)findViewById(R.id.textData);
        Button buttonClose = (Button)findViewById(R.id.buttonClose);
        
        // add listener
        buttonClose.setOnClickListener(this);         
      
       
        Bundle b = this.getIntent().getExtras();
        String s = b.getString("IDENT");
        textData.setText(s); 
        Toast.makeText(getApplicationContext(), "Subactivity: " + s, Toast.LENGTH_LONG).show();        
		Log.d(TAG,"Subactivity: " + s);
    }

	public void onClick(View v) {
		switch(v.getId()){
		
		case R.id.buttonClose:
			
			try{
				Intent resultIntent = new Intent(getApplicationContext(),helloListView.class);
				resultIntent.putExtra(PUBLIC_STATIC_STRING_IDENTIFIER, "data_to_activity");
				setResult(Activity.RESULT_OK, resultIntent);				
				finish();
			}catch (Exception e){
				Toast.makeText(getApplicationContext(), "Error: " + e, Toast.LENGTH_LONG).show();
				Log.e(TAG,"buttonClose Error: "+e);
			}	
			Log.d(TAG,"buttonClose");
		break;
		}		
	}
	
}