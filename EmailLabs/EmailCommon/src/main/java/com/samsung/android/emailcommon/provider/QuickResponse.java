/* * Copyright (C) 2011 The Android Open Source Project * * Licensed under the Apache License, Version 2.0 (the "License"); * you may not use this file except in compliance with the License. * You may obtain a copy of the License at * *      http://www.apache.org/licenses/LICENSE-2.0 * * Unless required by applicable law or agreed to in writing, software * distributed under the License is distributed on an "AS IS" BASIS, * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. * See the License for the specific language governing permissions and * limitations under the License. */package com.samsung.android.emailcommon.provider;import android.content.ContentValues;import android.content.Context;import android.database.Cursor;import android.net.Uri;import android.os.Parcel;import android.os.Parcelable;import com.samsung.android.emailcommon.provider.EmailContent.QuickResponseColumns;/** * A user-modifiable message that may be quickly inserted into the body while * user is composing a message. Tied to a specific account. */public final class QuickResponse extends EmailContent implements QuickResponseColumns, Parcelable {    public static final String TABLE_NAME = "QuickResponse";    @SuppressWarnings("hiding")    public static final Uri CONTENT_URI = Uri.parse(EmailContent.CONTENT_URI + "/quickresponse");    public static final Uri ACCOUNT_ID_URI = Uri.parse(EmailContent.CONTENT_URI            + "/quickresponse/account");    private String mText;    private long mAccountKey;    private int mPredefinedResponseNumber;    private boolean mIsEditedPredefined;    private static final int CONTENT_ID_COLUMN = 0;    private static final int CONTENT_QUICK_RESPONSE_COLUMN = 1;    private static final int CONTENT_ACCOUNT_KEY_COLUMN = 2;    private static final int CONTENT_PREDEFINED_RESPONSE_NUMBER_COLUMN = 3;    private static final int CONTENT_IS_EDITED_PREDEFINED_COLUMN = 4;    public static final String[] CONTENT_PROJECTION = new String[] {            RECORD_ID, QuickResponseColumns.TEXT, QuickResponseColumns.ACCOUNT_KEY,             QuickResponseColumns.PREDEFINED_RESPONSE_NUMBER, QuickResponseColumns.IS_EDITED_PREDEFINED    };    public static final String CONTENT_ORDER_BY = QuickResponseColumns.PREDEFINED_RESPONSE_NUMBER + ", " + RECORD_ID;    /**     * Creates an empty QuickResponse. Restore should be called after.     */    private QuickResponse() {        // empty    }    /**     * Constructor used by CREATOR for parceling.     */    private QuickResponse(Parcel in) {        mBaseUri = CONTENT_URI;        mId = in.readLong();        mText = in.readString();        mAccountKey = in.readLong();        mPredefinedResponseNumber = in.readInt();        mIsEditedPredefined = (in.readInt()!=0);    }    /**     * Creates QuickResponse associated with a particular account using the     * given string.     */    public QuickResponse(long accountKey, String quickResponse) {        mBaseUri = CONTENT_URI;        mAccountKey = accountKey;        mText = quickResponse;        mPredefinedResponseNumber = 0;        mIsEditedPredefined = false;    }    /**     * Creates QuickResponse account using the given string.     */    public QuickResponse(String quickResponse) {        mBaseUri = CONTENT_URI;        mAccountKey = -1;        mText = quickResponse;        mPredefinedResponseNumber = 0;        mIsEditedPredefined = false;    }    private void updatePredefinedTextFromResource(Context context, int[] predefinedQuickResponsesResources) {        // Update text from string resources for predefined quick responses to provide translation        if (predefinedQuickResponsesResources != null                 && mPredefinedResponseNumber > 0 && mPredefinedResponseNumber <= predefinedQuickResponsesResources.length                 && !mIsEditedPredefined) {            mText = context.getResources().getString(predefinedQuickResponsesResources[mPredefinedResponseNumber-1]);        }    }        /**     * @see com.samsung.android.emailcommon.provider.EmailContent#restore(android.database.Cursor)     */    @Override    public void restore(Cursor cursor) {        mBaseUri = CONTENT_URI;        mId = cursor.getLong(CONTENT_ID_COLUMN);        mText = cursor.getString(CONTENT_QUICK_RESPONSE_COLUMN);        mAccountKey = cursor.getLong(CONTENT_ACCOUNT_KEY_COLUMN);        mPredefinedResponseNumber = cursor.getInt(CONTENT_PREDEFINED_RESPONSE_NUMBER_COLUMN);        mIsEditedPredefined = (cursor.getInt(CONTENT_IS_EDITED_PREDEFINED_COLUMN)!=0);    }    /**     * @see com.samsung.android.emailcommon.provider.EmailContent#toContentValues()     */    @Override    public ContentValues toContentValues() {        ContentValues values = new ContentValues();        values.put(QuickResponseColumns.TEXT, mText);        values.put(QuickResponseColumns.ACCOUNT_KEY, mAccountKey);        values.put(QuickResponseColumns.PREDEFINED_RESPONSE_NUMBER, mPredefinedResponseNumber);        values.put(QuickResponseColumns.IS_EDITED_PREDEFINED, mIsEditedPredefined ? 1 : 0);        return values;    }    @Override    public int update(Context context, ContentValues contentValues) {        // For predefined and not edited response we need to check, if user updated text, then we will mark        // such response as predefined edited and will not translate it in future        if (isPredefined() && !mIsEditedPredefined) {            if (mText != null && mText.equals(contentValues.getAsString(QuickResponseColumns.TEXT))) {                return 0;            } else {                mIsEditedPredefined = true;                contentValues.put(IS_EDITED_PREDEFINED, 1);            }        }        return super.update(context, contentValues);    }        @Override    public String toString() {        return mText;    }    /**     * Given an array of QuickResponses, returns the an array of the String     * values corresponding to each QuickResponse.     */    public static String[] getQuickResponseStrings(QuickResponse[] quickResponses) {        int count = quickResponses.length;        String[] quickResponseStrings = new String[count];        for (int i = 0; i < count; i++) {            quickResponseStrings[i] = quickResponses[i].toString();        }        return quickResponseStrings;    }    /**     * @param context     * @param predefinedQuickResponsesResources resources array     * @return array of QuickResponses     */    public static QuickResponse[] restoreQuickResponses(Context context, int[] predefinedQuickResponsesResources) {        Cursor c = context.getContentResolver().query(CONTENT_URI, CONTENT_PROJECTION, null, null, CONTENT_ORDER_BY);        try {            int count = c.getCount();            QuickResponse[] quickResponses = new QuickResponse[count];            for (int i = 0; i < count; ++i) {                c.moveToNext();                QuickResponse quickResponse = new QuickResponse();                quickResponse.restore(c);                // Provide translated text for predefined quick resources                quickResponse.updatePredefinedTextFromResource(context, predefinedQuickResponsesResources);                 quickResponses[i] = quickResponse;            }            return quickResponses;        } finally {            c.close();        }    }    /**     * @param context     * @return Number of QuickResponses     */    public static int getQuickResponsesCount(Context context) {        Cursor c = null;        int res = 0;        try {            c = context.getContentResolver().query(CONTENT_URI, CONTENT_PROJECTION, null, null, null);            if (c != null)                res = c.getCount();        } finally {            if (c != null)                c.close();            c = null;        }        return res;    }    /**     * Returns the base URI for this QuickResponse     */    public Uri getBaseUri() {        return mBaseUri;    }    /**     * Returns the unique id for this QuickResponse     */    public long getId() {        return mId;    }    @Override    public boolean equals(Object objectThat) {        if (this == objectThat)            return true;        if (!(objectThat instanceof QuickResponse))            return false;        QuickResponse that = (QuickResponse) objectThat;        return mText.equals(that.mText) && mId == that.mId && mAccountKey == that.mAccountKey             && mPredefinedResponseNumber == that.mPredefinedResponseNumber && mIsEditedPredefined == that.mIsEditedPredefined;    }    @Override    public int hashCode() {        return 0;        /*         * 1117_for_ICS_by_Kang return Objects.hashCode(mId, mText,         * mAccountKey); 1117_by_Kang         */    }    /**     * Implements Parcelable. Not used.     */    @Override    public int describeContents() {        return 0;    }    /**     * Implements Parcelable.     */    @Override    public void writeToParcel(Parcel dest, int flags) {        // mBaseUri is not parceled        dest.writeLong(mId);        dest.writeString(mText);        dest.writeLong(mAccountKey);        dest.writeInt(mPredefinedResponseNumber);        dest.writeInt(mIsEditedPredefined ? 1:0);    }    public boolean isPredefined() {        return (mPredefinedResponseNumber > 0);    }        public void setEditedPredefined(boolean isEditedPredefined) {        mIsEditedPredefined = isEditedPredefined;    }    public boolean isEditedPredefined() {        return mIsEditedPredefined;    }    /**     * Implements Parcelable     */    public static final Parcelable.Creator<QuickResponse> CREATOR = new Parcelable.Creator<QuickResponse>() {        @Override        public QuickResponse createFromParcel(Parcel in) {            return new QuickResponse(in);        }        @Override        public QuickResponse[] newArray(int size) {            return new QuickResponse[size];        }    };}