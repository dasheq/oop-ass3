package ie.dit.reeageshark;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class MainMenu extends Activity {

	
	RelativeLayout Btn;
	ImageView ImageButton;
	TextView txt;
	
	
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Btn = (RelativeLayout) findViewById(R.id.butto_start);
        ImageButton = (ImageView) findViewById(R.id.image_butto);
        txt = (TextView) findViewById(R.id.Begin_Text);
        
        Typeface Custom = Typeface.createFromAsset(getAssets(), "font.ttf");
        txt.setTypeface(Custom);
        
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
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
