package com.artem1y.criminalintent;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

public class Crime {

    private UUID mId;
    private String mTitle;
    private Date mDate;
    private boolean mSolved;

    private boolean mRequirePolice;

    public Crime() {
        mId = UUID.randomUUID();
        mDate = new Date();
    }

    public Crime(String title, boolean solved, boolean requirePolice) {
        mId = UUID.randomUUID();
        mDate = new Date();
        mTitle = title;
        mSolved = solved;
        mRequirePolice = requirePolice;
    }

    public boolean isRequirePolice() {
        return mRequirePolice;
    }

    public void setRequirePolice(boolean requirePolice) {
        mRequirePolice = requirePolice;
    }

    public UUID getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public boolean isSolved() {
        return mSolved;
    }

    public void setSolved(boolean solved) {
        mSolved = solved;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Crime crime = (Crime) o;
        return isSolved() == crime.isSolved() &&
                Objects.equals(getId(), crime.getId()) &&
                Objects.equals(getTitle(), crime.getTitle()) &&
                Objects.equals(getDate(), crime.getDate());
    }

    @Override
    public int hashCode() {
        //return Objects.hash(getId(), getTitle(), getDate(), isSolved());
        return getId().hashCode();
    }
}
