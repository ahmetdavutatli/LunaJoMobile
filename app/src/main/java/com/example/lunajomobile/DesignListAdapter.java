package com.example.lunajomobile;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

public class DesignListAdapter extends BaseAdapter {

    private Context context;
    private List<DesignItem> designList;

    public DesignListAdapter(Context context, List<DesignItem> designList) {
        this.context = context;
        this.designList = designList;
    }

    @Override
    public int getCount() {
        return designList.size();
    }

    @Override
    public Object getItem(int position) {
        return designList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.design_list_item, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.designerNameTextView = convertView.findViewById(R.id.designerNameTextView);
            viewHolder.designImageView = convertView.findViewById(R.id.designImageView);
            viewHolder.designDescriptionTextView = convertView.findViewById(R.id.designDescriptionTextView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // Get the current design item
        DesignItem currentDesign = designList.get(position);

        // Set designer name, design image, and design description
        viewHolder.designerNameTextView.setText(currentDesign.getDesignerName());
        viewHolder.designImageView.setImageResource(currentDesign.getDesignImageResource());
        viewHolder.designDescriptionTextView.setText(currentDesign.getDesignDescription());

        // Set a click listener to navigate to DesignDetailsActivity
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start DesignDetailsActivity and pass the selected design name
                String selectedDesign = currentDesign.getDesignerName();
                Intent intent = new Intent(context, DesignDetailsActivity.class);
                intent.putExtra("selectedDesign", selectedDesign);
                context.startActivity(intent);
            }
        });

        return convertView;
    }

    static class ViewHolder {
        TextView designerNameTextView;
        ImageView designImageView;
        TextView designDescriptionTextView;
    }
}