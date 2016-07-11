/*** * Created by taesoo77.lee 2011. 08. 12. */package com.samsung.android.emailcommon.utility;import java.util.HashMap;import android.os.SystemProperties;public class SecFeatureWrapper {    final static String TAG = "SecFeatureWrapper";    public final static int CARRIER_NOT_INIT = -1;    public final static int CARRIER_UNKNOWN = 0;    public final static int CARRIER_VZW = 1;    public final static int CARRIER_TMB = 2;    public final static int CARRIER_ATT = 3;    public final static int CARRIER_SPR = 4;    public final static int CARRIER_SKT = 5;    public final static int CARRIER_KTT = 6;    public final static int CARRIER_LGT = 7;    public final static int CARRIER_DCM = 8;    public final static int CARRIER_BRI = 9;    public final static int CARRIER_CHM = 10;    public final static int CARRIER_CHN = 11;    public final static int CARRIER_CTC = 12;    public final static int CARRIER_TGY = 13;    public final static int CARRIER_USC = 14;    public final static int CARRIER_VMU = 15;    public final static int CARRIER_H3G = 16;    public final static int CARRIER_3IE = 17;    public final static int CARRIER_DRE = 18;    public final static int CARRIER_HUI = 19;    public final static int CARRIER_BST = 20;    public final static int CARRIER_XAS = 21;    public final static int CARRIER_ACG = 22;    public static int CARRIER_CODE = CARRIER_NOT_INIT;    public static String CARRIER_CODE_STRING = null;    public static String COUNTRY_CODE_STRING = null;    private static String product_model = null;        private static int BUILD_TYPE = 0;    static HashMap<String, Integer> operator_features = new HashMap<String, Integer>();    static HashMap<String, String> operator_features_string = new HashMap<String, String>();    // static Class<?> c = null;    static public void initInstance() {        // new Thread(new Runnable() {        // @Override        // public void run() {        // if (c == null) {        // try {        // PathClassLoader loader = new PathClassLoader(        // "/system/framework/sec_feature.jar",        // ClassLoader.getSystemClassLoader());        // // Class<?> c =        // // Class.forName("com.sec.android.app.SecFeature");        // c = loader.loadClass("com.sec.android.app.SecFeature");        //        // loader = null;        // } catch (Exception e) {        // Log.e("Email:SecFeatureWrapper",        // "Cannot initiate SecFeatureWrapper");        // }        // }        // }        // }).start();    }//    static public boolean isEnabled(String feature) {////        boolean bEnabled = false;////////        // if (operator_features.containsKey(feature)) {////        // bEnabled = (operator_features.get(feature) == 1);////        // } else {////        // if (c == null) {////        // Log.d("Email:SecFeatureWrapper", "Was not initiated ");////        // return false;////        // }////        // try {////        // bEnabled = c.getField(feature).getBoolean(null);////        // } catch (Exception e) {////        // Log.w("Email:SecFeatureWrapper", feature + " was not found");////        // }////        // operator_features.put(feature, bEnabled ? 1 : 0);////        // }////////        return bEnabled;////    }//    static public String getString(String feature) {////        String ret = "";////////        // if (operator_features_string.containsKey(feature)) {////        // ret = operator_features_string.get(feature);////        // } else {////        // if (c == null) {////        // Log.d("Email:SecFeatureWrapper", "Was not initiated ");////        // return ret;////        // }////        // try {////        // ret = (String)c.getField(feature).get(null);////        // } catch (Exception e) {////        // Log.w("Email:SecFeatureWrapper", feature + " was not found");////        // }////        // operator_features_string.put(feature, ret);////        // Log.d("Email:SecFeatureWrapper", "getString : " + ret);////        // }////////        return ret;////    }    static public String getProductModel() {        if (product_model == null) {            product_model = SystemProperties.get("ro.product.model").trim().toLowerCase();            if (product_model == null) {                product_model = "Unknown";            }        }        return product_model;    }    static public int getCarrierId() {        if (CARRIER_CODE == CARRIER_NOT_INIT) {            CARRIER_CODE_STRING = SystemProperties.get("ro.csc.sales_code");            CARRIER_CODE = CARRIER_UNKNOWN;            if ("VZW".equals(CARRIER_CODE_STRING)) {                CARRIER_CODE = CARRIER_VZW;            } else if ("TMB".equals(CARRIER_CODE_STRING) || "TMK".equals(CARRIER_CODE_STRING)) {                CARRIER_CODE = CARRIER_TMB;            } else if ("ATT".equals(CARRIER_CODE_STRING)) {                CARRIER_CODE = CARRIER_ATT;            } else if ("SPR".equals(CARRIER_CODE_STRING)) {                CARRIER_CODE = CARRIER_SPR;            } else if ("SKT".equals(CARRIER_CODE_STRING)) {                CARRIER_CODE = CARRIER_SKT;            } else if ("KT".equals(CARRIER_CODE_STRING)) {                CARRIER_CODE = CARRIER_KTT;            } else if ("LGT".equals(CARRIER_CODE_STRING)) {                CARRIER_CODE = CARRIER_LGT;            } else if ("DCM".equals(CARRIER_CODE_STRING)) {                CARRIER_CODE = CARRIER_DCM;            } else if ("BRI".equals(CARRIER_CODE_STRING)) {                CARRIER_CODE = CARRIER_BRI;            } else if ("CHM".equals(CARRIER_CODE_STRING)) {                CARRIER_CODE = CARRIER_CHM;            } else if ("CHN".equals(CARRIER_CODE_STRING)) {                CARRIER_CODE = CARRIER_CHN;            } else if ("CTC".equals(CARRIER_CODE_STRING)) {                CARRIER_CODE = CARRIER_CTC;            } else if ("TGY".equals(CARRIER_CODE_STRING)) {                CARRIER_CODE = CARRIER_TGY;            } else if ("USC".equals(CARRIER_CODE_STRING)) {                CARRIER_CODE = CARRIER_USC;            } else if ("VMU".equals(CARRIER_CODE_STRING)) {                CARRIER_CODE = CARRIER_VMU;            } else if ("H3G".equals(CARRIER_CODE_STRING)) {                CARRIER_CODE = CARRIER_H3G;            } else if ("3IE".equals(CARRIER_CODE_STRING)) {                CARRIER_CODE = CARRIER_3IE;            } else if ("DRE".equals(CARRIER_CODE_STRING)) {                CARRIER_CODE = CARRIER_DRE;            } else if ("HUI".equals(CARRIER_CODE_STRING)) {                CARRIER_CODE = CARRIER_HUI;            } else if ("BST".equals(CARRIER_CODE_STRING)) {                CARRIER_CODE = CARRIER_BST;            } else if ("XAS".equals(CARRIER_CODE_STRING)) {                CARRIER_CODE = CARRIER_XAS;            } else if ("ACG".equals(CARRIER_CODE_STRING)) {                CARRIER_CODE = CARRIER_ACG;            }        }        //Log.d("Email:SecFeatureWrapper", "getId" + CARRIER_CODE);        return CARRIER_CODE;    }    static public boolean isNACarrier() {        COUNTRY_CODE_STRING = SystemProperties.get("ro.csc.country_code");        if ("USA".equals(COUNTRY_CODE_STRING)) {            return true;        } else {            return false;        }    }    static public boolean isCTCCarrier() {        if (getCarrierId() == CARRIER_CTC) {            return true;        }        else {            return false;        }    }        static public boolean isEngBuild()    {        boolean ret = false;                if (BUILD_TYPE == 0) {            String sBuildType;            sBuildType = SystemProperties.get("ro.build.type");                        EmailLog.d(TAG, "isEngBuild : " + sBuildType);            if ("eng".equalsIgnoreCase(sBuildType)) {                BUILD_TYPE = 1;            } else if ("user".equalsIgnoreCase(sBuildType)) {                BUILD_TYPE = 2;            } else {                BUILD_TYPE = 3;            }        }                if(BUILD_TYPE == 1){            ret = true;        }                return ret;    }   }