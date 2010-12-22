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
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class helloListView extends ListActivity {
    protected static final int SUB_ACTIVITY_REQUEST_CODE = 0;
	private static final String PUBLIC_STATIC_STRING_IDENTIFIER = null;
	private static final String TAG = "helloListView";
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);

      setListAdapter(new ArrayAdapter<String>(this, R.layout.main, COUNTRIES));

      ListView lv = getListView();
      lv.setTextFilterEnabled(true);

      lv.setOnItemClickListener(new OnItemClickListener() {
        public void onItemClick(AdapterView<?> parent, View view,
            int position, long id) {
          
        	/*
        	 * This wasn't useful enough, as the user had to return by manually
        	 * clicking on the back button.
        	 */
        	// Switch to the other activity by intent
        	//startActivity(new Intent(getApplicationContext(), modalPopup.class));
        	
        	Intent i = new Intent(getApplicationContext(), modalPopup.class);
        	Bundle b = new Bundle();
            b.putString("IDENT", "data_to_subactivity");
            i.putExtras(b);
            
        	// SUB_ACTIVITY_REQUEST_CODE used as an 'identifier'       	
        	startActivityForResult(i,SUB_ACTIVITY_REQUEST_CODE);
        	
        	// When clicked, show a toast with the TextView text
        	Toast.makeText(getApplicationContext(), ((TextView) view).getText(),
              Toast.LENGTH_SHORT).show();
        }
      });    
      
    }
    
    @Override 
    public void onActivityResult(int requestCode, int resultCode, Intent data) {     
      super.onActivityResult(requestCode, resultCode, data); 
      switch(requestCode) { 
        case (SUB_ACTIVITY_REQUEST_CODE) : { 
          if (resultCode == Activity.RESULT_OK) { 
        	  String tabIndex = data.getStringExtra(PUBLIC_STATIC_STRING_IDENTIFIER);

        	  Toast.makeText(getApplicationContext(), "onActivityResult: " + tabIndex, Toast.LENGTH_LONG).show();
        	  Log.i(TAG, "onActivityResult: " + tabIndex);
          } 
          break; 
        } 
      } 
    }
    
    /*
     * Note that using a hard-coded string array is not the best design practice.
     * One is used in this tutorial for simplicity, in order to demonstrate the
     * ListView widget. The better practice is to reference a string array
     * defined by an external resource, such as with a <string-array> resource
     * in your project res/values/strings.xml file.
     * ref: http://developer.android.com/resources/tutorials/views/hello-listview.html
     */
    static final String[] COUNTRIES = new String[] {
        "Afghanistan", "Albania", "Algeria", "American Samoa", "Andorra",
        "Angola", "Anguilla", "Antarctica", "Antigua and Barbuda", "Argentina",
        "Armenia", "Aruba", "Australia", "Austria", "Azerbaijan",
        "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium",
        "Belize", "Benin", "Bermuda", "Bhutan", "Bolivia",
        "Bosnia and Herzegovina", "Botswana", "Bouvet Island", "Brazil", "British Indian Ocean Territory",
        "British Virgin Islands", "Brunei", "Bulgaria", "Burkina Faso", "Burundi",
        "Cote d'Ivoire", "Cambodia", "Cameroon", "Canada", "Cape Verde",
        "Cayman Islands", "Central African Republic", "Chad", "Chile", "China",
        "Christmas Island", "Cocos (Keeling) Islands", "Colombia", "Comoros", "Congo",
        "Cook Islands", "Costa Rica", "Croatia", "Cuba", "Cyprus", "Czech Republic",
        "Democratic Republic of the Congo", "Denmark", "Djibouti", "Dominica", "Dominican Republic",
        "East Timor", "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea", "Eritrea",
        "Estonia", "Ethiopia", "Faeroe Islands", "Falkland Islands", "Fiji", "Finland",
        "Former Yugoslav Republic of Macedonia", "France", "French Guiana", "French Polynesia",
        "French Southern Territories", "Gabon", "Georgia", "Germany", "Ghana", "Gibraltar",
        "Greece", "Greenland", "Grenada", "Guadeloupe", "Guam", "Guatemala", "Guinea", "Guinea-Bissau",
        "Guyana", "Haiti", "Heard Island and McDonald Islands", "Honduras", "Hong Kong", "Hungary",
        "Iceland", "India", "Indonesia", "Iran", "Iraq", "Ireland", "Israel", "Italy", "Jamaica",
        "Japan", "Jordan", "Kazakhstan", "Kenya", "Kiribati", "Kuwait", "Kyrgyzstan", "Laos",
        "Latvia", "Lebanon", "Lesotho", "Liberia", "Libya", "Liechtenstein", "Lithuania", "Luxembourg",
        "Macau", "Madagascar", "Malawi", "Malaysia", "Maldives", "Mali", "Malta", "Marshall Islands",
        "Martinique", "Mauritania", "Mauritius", "Mayotte", "Mexico", "Micronesia", "Moldova",
        "Monaco", "Mongolia", "Montserrat", "Morocco", "Mozambique", "Myanmar", "Namibia",
        "Nauru", "Nepal", "Netherlands", "Netherlands Antilles", "New Caledonia", "New Zealand",
        "Nicaragua", "Niger", "Nigeria", "Niue", "Norfolk Island", "North Korea", "Northern Marianas",
        "Norway", "Oman", "Pakistan", "Palau", "Panama", "Papua New Guinea", "Paraguay", "Peru",
        "Philippines", "Pitcairn Islands", "Poland", "Portugal", "Puerto Rico", "Qatar",
        "Reunion", "Romania", "Russia", "Rwanda", "Sqo Tome and Principe", "Saint Helena",
        "Saint Kitts and Nevis", "Saint Lucia", "Saint Pierre and Miquelon",
        "Saint Vincent and the Grenadines", "Samoa", "San Marino", "Saudi Arabia", "Senegal",
        "Seychelles", "Sierra Leone", "Singapore", "Slovakia", "Slovenia", "Solomon Islands",
        "Somalia", "South Africa", "South Georgia and the South Sandwich Islands", "South Korea",
        "Spain", "Sri Lanka", "Sudan", "Suriname", "Svalbard and Jan Mayen", "Swaziland", "Sweden",
        "Switzerland", "Syria", "Taiwan", "Tajikistan", "Tanzania", "Thailand", "The Bahamas",
        "The Gambia", "Togo", "Tokelau", "Tonga", "Trinidad and Tobago", "Tunisia", "Turkey",
        "Turkmenistan", "Turks and Caicos Islands", "Tuvalu", "Virgin Islands", "Uganda",
        "Ukraine", "United Arab Emirates", "United Kingdom",
        "United States", "United States Minor Outlying Islands", "Uruguay", "Uzbekistan",
        "Vanuatu", "Vatican City", "Venezuela", "Vietnam", "Wallis and Futuna", "Western Sahara",
        "Yemen", "Yugoslavia", "Zambia", "Zimbabwe"
    };
}
    