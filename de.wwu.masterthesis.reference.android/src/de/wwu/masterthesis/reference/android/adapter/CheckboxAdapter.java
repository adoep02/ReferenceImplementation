package de.wwu.masterthesis.reference.android.adapter;

import java.util.ArrayList;
import java.util.List;

import de.wwu.masterthesis.reference.android.models.Contact;
import de.wwu.masterthesis.reference.android.models.Group;
import de.wwu.masterthesis.reference.android.R;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

public class CheckboxAdapter extends ArrayAdapter<Group> {
	
	private ArrayList<Group> groupList;
	private Contact contact;
	private Context context;

	public CheckboxAdapter(Context context, int resource,
			int textViewResourceId, List<Group> groupList, Contact contact) {
		super(context, resource, textViewResourceId, groupList);
		this.groupList = new ArrayList<Group>();
		this.groupList.addAll(groupList);
		this.contact = contact;
		this.context = context;
	}
	
	private class ViewHolder {
		   TextView code;
		   CheckBox group;
	}
	
	@Override
	  public View getView(int position, View convertView, ViewGroup parent) {
	 
	   ViewHolder holder = null;
	   Log.v("ConvertView", String.valueOf(position));
	 
	   if (convertView == null) {
		   LayoutInflater vi = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		   convertView = vi.inflate(R.layout.checkboxlist, null);
		 
		   holder = new ViewHolder();
		   holder.code = (TextView) convertView.findViewById(R.id.code);
		   holder.group = (CheckBox) convertView.findViewById(R.id.checkBox1);
		   convertView.setTag(holder);
		 
		    holder.group.setOnClickListener( new View.OnClickListener() { 
		      public void onClick(View v) { 
		       CheckBox cb = (CheckBox) v ; 
		       Group group = (Group) cb.getTag(); 
		       if(cb.isChecked()){
		    	   contact.getGroups().add(group);
		       }
		       else{
		    	   contact.getGroups().remove(group);
		       }
		      } 
		     }
		    ); 
	   }
	   else {
	    holder = (ViewHolder) convertView.getTag();
	   }
	 
	   Group group = groupList.get(position);
	   holder.code.setText(group.toString()); //Groupname that appears next to the checkbox
	   holder.group.setText(group.getName());
	   holder.group.setChecked(contact.getGroups().contains(group));
	   holder.group.setTag(group);
	 
	   return convertView;
	  }
}
