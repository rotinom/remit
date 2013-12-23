package com.rotinom.remit;

import java.util.List;

import com.rotinom.remit.R;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class ChargeNumberAdapter extends ArrayAdapter<ChargeNumberItem> {
	
	private Context context_;

	public ChargeNumberAdapter(Context context, int resource, List<ChargeNumberItem> items) {
		super(context, resource, items);
			context_ = context;
	}
	
	public View getView(int position, View convertView, ViewGroup parent) {
        ChargeNumberItem rowItem = getItem(position);

        LayoutInflater mInflater = (LayoutInflater) context_
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        
//        ChargeNumberItem item;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_chargenumber, null);
        }
//            holder = new ViewHolder();
//            holder.txtMenuName = (TextView) convertView.findViewById(R.id.menu_name);
//            holder.txtMenuDesc = (TextView) convertView.findViewById(R.id.description);
//            holder.txtPrice = (TextView) convertView.findViewById(R.id.price);
//            holder.imageView = (ImageView) convertView.findViewById(R.id.list_image);
//            convertView.setTag(holder);
//        } 
//        else {
//            holder = (ViewHolder) convertView.getTag();
//        }

        TextView total_time = (TextView)convertView.findViewById(R.id.total_time);
        total_time.setText("1.2");
//        convertView.findViewById(R.id.menu_name).txtMenuName.setText(rowItem.getName());
//        convertView.findViewById(R.id.menu_name).txtPrice.setText(String.valueOf(rowItem.getPrice()) + " TL");
        //holder.imageView.setImageResource(rowItem.getImageId());

        return convertView;
    }

}
