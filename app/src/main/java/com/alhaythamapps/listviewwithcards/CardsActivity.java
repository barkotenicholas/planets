package com.alhaythamapps.listviewwithcards;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.anjlab.android.iab.v3.BillingProcessor;
import com.anjlab.android.iab.v3.TransactionDetails;

/**
 * @author Alhaytham Alfeel on 10/10/2016.
 */

public class CardsActivity extends AppCompatActivity {
    private BillingProcessor billingProcessor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cards);

        ListView lvCards = (ListView) findViewById(R.id.list_cards);
        CardsAdapter adapter = new CardsAdapter(this);
        billingProcessor = new BillingProcessor(this,"MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAimYOGnBuxZXnU5GCiXsaWdSFW3ToKhiEOB25l1GvbGAVKdOksfAfkWFbi3aFz39Xpl61Ef7K/0kmUcb2yYBA4olyW8rFhlpRtIi1s4oIm1ZIaWUZ730jnejctr8XWVEFFCtnLbh9gS1wuzB4txu5xM1mjs3rQAZ1jO7NL96s1wwoFm30a9iNPxsUcEHTF/Dho+ufvXKnAGu8/SqVm3erQFzL0sTST/AY4Yw4o2ViDxqqe2l69GlJgYu9T7ccf/ZahQM25bS4v71iD5LrRMwQjDc4528UbWn6iqJCsKeS8cCICc3Oj5CLTJ/Pb12DbvfKkbdf0/LwQpn8HDguH9zhCQIDAQAB" , null, new BillingProcessor.IBillingHandler() {
            @Override
            public void onProductPurchased(String productId, TransactionDetails details) {
                Toast.makeText(CardsActivity.this,"purchased",Toast.LENGTH_LONG);

            }

            @Override
            public void onPurchaseHistoryRestored() {

            }

            @Override
            public void onBillingError(int errorCode, Throwable error) {

            }

            @Override
            public void onBillingInitialized() {

            }
        });
        lvCards.setAdapter(adapter);
        adapter.addAll(new CardModel(R.drawable.mercury, R.string.mercury, R.string.mercury_sub),
                new CardModel(R.drawable.venus, R.string.venus, R.string.venus_sub),
                new CardModel(R.drawable.earth, R.string.earth, R.string.earth_sub),
                new CardModel(R.drawable.mars, R.string.mars, R.string.mars_sub),
                new CardModel(R.drawable.jupiter, R.string.jupiter, R.string.jupiter_sub),
                new CardModel(R.drawable.saturn, R.string.saturn, R.string.saturn_sub),
                new CardModel(R.drawable.uranus, R.string.uranus, R.string.uranus_sub),
                new CardModel(R.drawable.neptune, R.string.neptune, R.string.neptune_sub),
                new CardModel(R.drawable.pluto, R.string.pluto, R.string.pluto_sub));

        lvCards.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                billingProcessor.subscribe(CardsActivity.this,"acup");

            }
        });
    }
}
