package com.kevin.mellow.cache;

import java.util.Stack;

import android.app.Activity; 

public class ScreenManager { 
private static Stack activityStack; 
private static ScreenManager instance; 
private ScreenManager(){ 
} 
public static ScreenManager getScreenManager(){ 
if(instance==null){ 
instance=new ScreenManager(); 
} 
return instance; 
} 
public void popActivity(){ 
Activity activity= (Activity) activityStack.lastElement();
if(activity!=null){ 
activity.finish(); 
activity=null; 
} 
} 
public void popActivity(Activity activity){ 
if(activity!=null){ 
activity.finish(); 
activityStack.remove(activity); 
activity=null; 
} 
} 
public Activity currentActivity(){ 
Activity activity= (Activity) activityStack.lastElement();
return activity; 
} 
public void pushActivity(Activity activity){ 
if(activityStack==null){ 
activityStack=new Stack(); 
} 
activityStack.add(activity); 
} 

public void popAllActivityExceptOne(Class cls){ 
while(true){ 
Activity activity=currentActivity(); 
if(activity==null){ 
break; 
} 
if(activity.getClass().equals(cls) ){ 
break; 
} 
popActivity(activity); 
} 
} 
} 