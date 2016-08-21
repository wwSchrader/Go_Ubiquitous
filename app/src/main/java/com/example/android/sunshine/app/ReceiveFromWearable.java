package com.example.android.sunshine.app;

import android.util.Log;

import com.example.android.sunshine.app.sync.SunshineSyncAdapter;
import com.google.android.gms.wearable.DataEvent;
import com.google.android.gms.wearable.DataEventBuffer;
import com.google.android.gms.wearable.WearableListenerService;

public class ReceiveFromWearable extends WearableListenerService {
    @Override
    public void onDataChanged(DataEventBuffer dataEvents) {
        Log.d("onDataChanged", "onDataChanged Triggered");
        for (DataEvent dataEvent : dataEvents) {
            if (dataEvent.getType() == DataEvent.TYPE_CHANGED) {
                String path = dataEvent.getDataItem().getUri().getPath();
                if (path.equals(getString(R.string.Data_Message_Path))) {
                    SunshineSyncAdapter.syncImmediately(this);
                }
            }
        }
    }
}
