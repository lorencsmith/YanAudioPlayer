package edu.gsu.httpscs.yanaudioplayer.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import edu.gsu.httpscs.yanaudioplayer.AudioOb;
import edu.gsu.httpscs.yanaudioplayer.R;
import edu.gsu.httpscs.yanaudioplayer.audio.BaseAudioOb;

/**
 * Created by YoungH on 3/16/17.
 */

public class PlayListAdapter extends BaseAdapter {

    private final ArrayList<BaseAudioOb> contentList;
    private final Context context;

    public PlayListAdapter(Context context, ArrayList<BaseAudioOb> contentList) {
        this.contentList = contentList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return contentList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView != null) {
            holder = (ViewHolder) convertView.getTag();
        } else {
            convertView = LayoutInflater.from(context).inflate(R.layout.playlist_item, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }

        AudioOb vo = (AudioOb) contentList.get(position);
        holder.name.setText(vo.getName());

        return convertView;
    }

    static class ViewHolder{
        public ViewHolder(View view){
            ButterKnife.bind(this,view);
        }
        @BindView(R.id.playlist_item_name) TextView name;
        @BindView(R.id.playlist_item_img) ImageView mark;
    }
}
