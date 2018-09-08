package com.marukonekocyan.demo.reminderlist;

import java.util.ArrayList;
import java.util.List;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.marukonekocyan.demo.reminderlist.provider.NonsenseMsg;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private MainActivity self;

    public MainActivity() {
        super();
        self = this;
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        RecyclerView nonsenseMsgList = findViewById(R.id.nonsense_msg_list);
        nonsenseMsgList.setLayoutManager(new LinearLayoutManager(this));

        List<NonsenseMsg> msgList = new ArrayList<NonsenseMsg>();
        generateMockData(msgList);
        NonsenseMsgAdapter adapter = new NonsenseMsgAdapter(msgList);
        nonsenseMsgList.setAdapter(adapter);
    }

    private void generateMockData(List<NonsenseMsg> msgList) {
        for (int i = 0; i < 30; i++) {
            msgList.add(new NonsenseMsg("Hello", i));
        }
        Log.d("size", String.valueOf(msgList.size()));
    }


    private class NonsenseMsgHolder extends RecyclerView.ViewHolder {

        private TextView mMsgTextView;

        public NonsenseMsgHolder(View itemView) {
            super(itemView);
            mMsgTextView = itemView.findViewById(R.id.nonsense_msg_list_item_msg_text);
        }

        public void setMsgText(String msg) {
            mMsgTextView.setText(msg);
        }
    }


    private class NonsenseMsgAdapter extends RecyclerView.Adapter<NonsenseMsgHolder> {

        private List<NonsenseMsg> mMsgList;

        public NonsenseMsgAdapter(List<NonsenseMsg> list) {
            mMsgList = list;
        }

        @Override
        public NonsenseMsgHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(self);
            View view = layoutInflater.inflate(R.layout.nonsense_msg_list_item, parent, false);
            return new NonsenseMsgHolder(view);
        }

        @Override
        public void onBindViewHolder(NonsenseMsgHolder holder, int position) {
            NonsenseMsg msg = mMsgList.get(position);
            holder.setMsgText(msg.getMsg());
        }

        @Override
        public int getItemCount() {
            return mMsgList.size();
        }

    }

}
