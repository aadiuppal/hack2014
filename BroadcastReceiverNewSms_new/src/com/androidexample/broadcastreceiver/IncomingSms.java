package com.androidexample.broadcastreceiver;

import java.util.Arrays;
import java.util.Vector;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;


public class IncomingSms extends BroadcastReceiver {
	private static final String TAG = IncomingSms.class.getCanonicalName();
	// Get the object of SmsManager
	final SmsManager sms = SmsManager.getDefault();
	public Vibrator vibrator;
	
	public void onReceive(Context context, Intent intent) {
	
		// Retrieves a map of extended data from the intent.
		final Bundle bundle = intent.getExtras();

		try {
			
			if (bundle != null) {
				
				final Object[] pdusObj = (Object[]) bundle.get("pdus");
				
				for (int i = 0; i < pdusObj.length; i++) {
					
					SmsMessage currentMessage = SmsMessage.createFromPdu((byte[]) pdusObj[i]);
					String phoneNumber = currentMessage.getDisplayOriginatingAddress();
					
			        String senderNum = phoneNumber;
			        String message = currentMessage.getDisplayMessageBody();
			        
			        morse(context, message);
			        
			        //Log.i("SmsReceiver", "senderNum: "+ senderNum + "; message: " + message);
					
				} // end for loop
				
              } // bundle is null

		} catch (Exception e) {
			Log.e("SmsReceiver", "Exception smsReceiver" +e);
			
		}
	}
	
	 public void morse(Context context, String message){
	    	Vector<Long> pauses = new Vector<Long>();
	    	
	    	pauses.add(1l);
	    	
	    	char[] chars = message.toCharArray();
	    	
	    	for(int i=0; i<chars.length; i++){
	    		long[] ticks = ticksForChar(chars[i]);
	    		for(int i2=0; i2<ticks.length; i2++){
	    			pauses.add(ticks[i2]);
	    		}
	    	}
	    	
	    	long[] pattern = new long[pauses.size()];
	    	
	    	for(int i=0; i<pattern.length; i++){
	    		pattern[i] = pauses.get(i);
	    	}
	    
	        vibrator = (Vibrator)context.getSystemService(Context.VIBRATOR_SERVICE);

	    	Toast.makeText(context, Arrays.toString(pattern), Toast.LENGTH_LONG).show();
	        Log.d(TAG, "attempting to vibrate for 1000ms");
	    	vibrator.vibrate(pattern, -1);
	 }

	public  long[] ticksForChar(char c){
		//ms on, then ms off, for each tick
	    long sT = 200;
	    long lT = 600;
	    long s = 200;
	    long se = 800; 
		
	    c = Character.toLowerCase(c);
	    
		switch(c){
		case 'a' :
			long[] r1 = {sT,s,lT,se};
			return r1;
			
		case 'b' :
			long[] r2 = {lT,s,sT,s,sT,s,sT,se};
			return r2;
			
		case 'c' :
			long[] r3 = {lT,s,sT,s,lT,s,sT,se};
			return r3;
			
		case 'd' :
			long[] r4 = {lT,s,sT,s,sT,se};
			return r4;
			
		case 'e' :
			long[] r5 = {sT,se};
			return r5;
			
		case 'f' :
			long[] r6 = {sT,s,sT,s,lT,s,sT,se};
			return r6;
			
		case 'g' :
			long[] r7 = {lT,s,lT,s,sT,se};
			return r7;
			
		case 'h' :
			long[] r8 = {sT,s,sT,s,sT,s,sT,se};
			return r8;
			
		case 'i' :
			long[] r9 = {sT,s,sT,se};
			return r9;
			
		case 'j' :
			long[] r10 = {sT,s,lT,s,lT,s,lT,se};
			return r10;
			
		case 'k' :
			long[] r11 = {lT,s,sT,s,lT,se};
			return r11;
			
		case 'l' :
			long[] r12 = {sT,s,lT,s,sT,s,sT,se};
			return r12;
			
		case 'm' :
			long[] r13 = {lT,s,lT,se};
			return r13;
			
		case 'n' :
			long[] r14 = {lT,s,sT,se};
			return r14;
			
		case 'o' :
			long[] r15 = {lT,s,lT,s,lT,se};
			return r15;
			
		case 'p' :
			long[] r16 = {sT,s,lT,s,lT,s,sT,se};
			return r16;
		
		case 'q' :
			long[] r17 = {lT,s,lT,s,sT,s,lT,se};
			return r17;
		
		case 'r' :
			long[] r18 = {sT,s,lT,s,sT,se};
			return r18;
		
		case 's' :
			long[] r19 = {sT,s,sT,s,sT,se};
			return r19;
		
		case 't' :
			long[] r20 = {lT,se};
			return r20;
		
		case 'u' :
			long[] r21 = {sT,s,sT,s,lT,se};
			return r21;
		
		case 'v' :
			long[] r22 = {sT,s,sT,s,sT,s,lT,se};
			return r22;
		
		case 'w' :
			long[] r23 = {sT,s,lT,s,lT,se};
			return r23;
		
		case 'x' :
			long[] r24 = {lT,s,sT,s,sT,s,lT,se};
			return r24;
		
		case 'y' :
			long[] r25 = {lT,s,sT,s,lT,s,lT,se};
			return r25;
		
		case 'z' :
			long[] r26 = {lT,s,lT,s,sT,s,sT,se};
			return r26;
		
		case '1' :
			long[] r27 = {sT,s,lT,s,lT,s,lT,s,lT,se};
			return r27;
		
		case '2' :
			long[] r28 = {sT,s,sT,s,lT,s,lT,s,lT,se};
			return r28;
		
		case '3' :
			long[] r29 = {sT,s,sT,s,sT,s,lT,s,lT,se};
			return r29;
		
		case '4' :
			long[] r30 = {sT,s,sT,s,sT,s,sT,s,lT,se};
			return r30;
		
		case '5' :
			long[] r31 = {sT,s,sT,s,sT,s,sT,s,sT,se};
			return r31;
		
		case '6' :
			long[] r32 = {lT,s,sT,s,sT,s,sT,s,sT,se};
			return r32;
		
		case '7' :
			long[] r33 = {lT,s,lT,s,sT,s,sT,s,sT,se};
			return r33;
		
		case '8' :
			long[] r34 = {lT,s,lT,s,lT,s,sT,s,sT,se};
			return r34;
		
		case '9' :
			long[] r35 = {lT,s,lT,s,lT,s,lT,s,sT,se};
			return r35;
			
		case '0' :
			long[] r36 = {lT,s,lT,s,lT,s,lT,s,lT,se};
			return r36;
		
		case ' ' :
			long[] r37 = {0,700};
			return r37;
			
		default:
	    }
		long ret[]={0};
		return ret;
	}
	 
	
	
}