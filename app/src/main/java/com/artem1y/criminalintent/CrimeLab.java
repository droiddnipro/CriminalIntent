package com.artem1y.criminalintent;

import android.content.Context;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class CrimeLab {

    private Map<UUID, Crime> mCrimes;

    private static CrimeLab sCrimeLab;

    public static CrimeLab get(Context context) {
        if (sCrimeLab == null) {
            sCrimeLab = new CrimeLab(context);
        }
        return sCrimeLab;
    }

    private  CrimeLab(Context context){

        mCrimes = new HashMap<UUID, Crime>();
        Crime c;
        for (int i = 0; i < 100; i++) {
            //c = new Crime("Crime #" + i, i % 2 == 0, i % 2 != 0);
            c = new Crime("Crime #" + i, i % 2 == 0, false);
            mCrimes.put(c.getId(), c);
        }
    }

    public List<Crime> getCrimes() {
        return new ArrayList<Crime>(mCrimes.values());
    }

    public Crime getCrime (UUID uuid) {
        return mCrimes.get(uuid);
    }
}
