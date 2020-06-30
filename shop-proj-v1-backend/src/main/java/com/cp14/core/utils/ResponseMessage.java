package com.cp14.core.utils;

import java.util.HashMap;

public class ResponseMessage {
	public static int KEY_RC_SUCCESS                = 200;
    public static int KEY_RC_EXCEPTION              = 900;
    
    
    public static String MES_RC_SUCCESS   = "OK - Everything Worked";
    public static String MES_RC_EXCEPTION     = "Exception request API";
    
    public static String getMessage(int code){      
        HashMap<Integer,String> hMes = new HashMap<>();
        hMes.put(KEY_RC_SUCCESS, MES_RC_SUCCESS);
        hMes.put(KEY_RC_EXCEPTION, MES_RC_EXCEPTION);
        return hMes.get(code);
    }
}
