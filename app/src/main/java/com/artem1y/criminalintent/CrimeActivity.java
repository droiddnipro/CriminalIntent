package com.artem1y.criminalintent;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import java.util.UUID;


public class CrimeActivity extends SingleFragmentActivity {

    private static final String EXTRA_CRIME_ID = "com.artem1y.criminalintent.crime_id";

    @Override
    protected Fragment createFragment() {
        UUID crimeid = (UUID) getIntent()
                .getSerializableExtra(EXTRA_CRIME_ID);
        return CrimeFragment.newInstance(crimeid);
    }

    public static Intent newIntent(Context packageContext, UUID crimeId) {
        Intent result = new Intent(packageContext, CrimeActivity.class);
        result.putExtra(EXTRA_CRIME_ID, crimeId);
        return result;
    }
}
