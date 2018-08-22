package com.artem1y.criminalintent;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.List;
import java.util.UUID;

public class CrimePagerActivity extends AppCompatActivity {

    private static final String EXTRA_CRIME_ID =
            "com.artem1y.criminalintent.crime_id";

    public static Intent newIntent(Context packageContext, UUID crimeId){
        Intent result = new Intent(packageContext, CrimePagerActivity.class);
        result.putExtra(EXTRA_CRIME_ID, crimeId);
        return result;
    }

    private ViewPager mViewPager;
    private List<Crime> mCrimes;
    private Button mFirstRecordButton;
    private Button mLastRecordButton;

    @Override
    protected void onCreate(Bundle bundle){
        super.onCreate(bundle);

        setContentView(R.layout.activity_crime_pager);

        mViewPager = findViewById(R.id.crime_view_pager);

        mCrimes = CrimeLab.get(this).getCrimes();

        mFirstRecordButton = findViewById(R.id.first_record_button);
        mLastRecordButton = findViewById(R.id.last_record_button);

        mFirstRecordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewPager.setCurrentItem(0);
                mLastRecordButton.setEnabled(true);
                mFirstRecordButton.setEnabled(false);
            }
        });

        mLastRecordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewPager.setCurrentItem(mCrimes.size());
                mFirstRecordButton.setEnabled(true);
                mLastRecordButton.setEnabled(false);
            }
        });

        UUID crimeId = (UUID) getIntent()
                .getSerializableExtra(EXTRA_CRIME_ID);

        FragmentManager fragmentManager = getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int position) {
                Crime crime = mCrimes.get(position);
                return CrimeFragment.newInstance(crime.getId());
            }

            @Override
            public int getCount() {
                return mCrimes.size();
            }
        });

        for (int i = 0; i < mCrimes.size(); i++) {
            if(mCrimes.get(i).getId().equals(crimeId)){
                mViewPager.setCurrentItem((i));
                break;
            }
        }
    }
/*
    public static int convertDip2Pixels(Context context, int dip) {
        return (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dip, context.getResources().getDisplayMetrics());
    }
*/
}
