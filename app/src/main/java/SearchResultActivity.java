import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.hosi.ncu_news.R;

/**
 * Created by HOSI on 2018/3/21.
 */

public class SearchResultActivity extends AppCompatActivity{
    TextView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

        searchView = (TextView) findViewById(R.id.search_view);

        // 注意這一行指令
        handleIntent(getIntent());
    }


    @Override
    protected void onNewIntent(Intent intent)
    {
        handleIntent(intent);
    }


    private void handleIntent(Intent intent)
    {
        if (Intent.ACTION_SEARCH.equals(intent.getAction()))
        {
            String query = intent.getStringExtra(SearchManager.QUERY);
            searchView.setText("傳遞的查詢字串為 "+query.toString());
        }
    }
}
