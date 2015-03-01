# Editable-and-Dynamic-Carrier-Name-in-Statusbar


For Static Carrier Name, you can use four Carrier Name in diferent parent at statusbar.
Put this in your statusbar:

    <com.dhian.systemui.CarrierName android:gravity="center_vertical" android:paddingLeft="2.0dip" android:layout_width="wrap_content" android:layout_height="wrap_content" android:clickable="true" android:onClick="CarrierName"/>
    
    
For 2nd Carrier name add this:
    
    <com.dhian.systemui.CarrierName2 android:gravity="center_vertical" android:paddingLeft="2.0dip" android:layout_width="wrap_content" android:layout_height="wrap_content" android:clickable="true" android:onClick="CarrierName" />
    
    
For 3rd Carrier name add this:
    
    <com.dhian.systemui.CarrierName3 android:gravity="center_vertical" android:paddingLeft="2.0dip" android:layout_width="wrap_content" android:layout_height="wrap_content" android:clickable="true" android:onClick="CarrierName" />
    
    
For 4th Carrier name add this:
    
    <com.dhian.systemui.CarrierName4 android:gravity="center_vertical" android:paddingLeft="2.0dip" android:layout_width="wrap_content" android:layout_height="wrap_content" android:onClick="CarrierName" android:clickable="true" />
    
And for Dynamic Carrier name, You just add this in statusbar:

    <include layout="@layout/dinamic_carrier_name" />
    
You Can Edit all Carrier name in carrier name settings

