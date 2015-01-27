package jaangari.opensoft.iitkgp.jaankari;

import android.app.Activity;
import android.app.ListActivity;
import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import jaangari.opensoft.iitkgp.jaangari.R;


public class SearchableActivity extends Activity {
    private DatabaseHandler dbHandler;
    private final String TAG = "Searchable";
    static final String JARGON = "Searchable";
    public class PairCategory{
        String category;
        ArrayList<Integer> ids;
    }

    protected void contentSearch(String Query){
        Log.e(TAG,Query);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchable);
        Intent intent  =  getIntent();
        Bundle appData = getIntent().getBundleExtra(SearchManager.APP_DATA);
        if (appData != null) {
            boolean jargon = appData.getBoolean(SearchableActivity.JARGON);
        }
        if(intent.ACTION_SEARCH.equals(intent.getAction())){
            String Query = intent.getStringExtra(SearchManager.QUERY);
            contentSearch(Query);
            dbHandler = new DatabaseHandler(getApplicationContext());
//            ArrayList<PairCategory> fetchedIds = dbHandler.fetchIndexList(Query);
//            int size  = fetchedIds.size();
//            for(int i=0; i<size ; i++){
//
//            }
            dbHandler.closeDB();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

//    @Override
//    public boolean onSearchRequested() {
//        Bundle appData = new Bundle();
//        appData.putBoolean(SearchableActivity.JARGON, true);
//        startSearch(null, false, appData, false);
//        return true;
//    }
}
