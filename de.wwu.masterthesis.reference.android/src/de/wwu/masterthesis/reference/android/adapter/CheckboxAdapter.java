package de.wwu.masterthesis.reference.android.adapter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import de.wwu.masterthesis.reference.android.contentprovider.ContactContentProvider;
import de.wwu.masterthesis.reference.android.contentprovider.GroupContentProvider;
import de.wwu.masterthesis.reference.android.models.Contact;
import de.wwu.masterthesis.reference.android.models.Group;
import de.wwu.masterthesis.reference.android.R;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

public class CheckboxAdapter extends ArrayAdapter<Group>{
	
	private ArrayList<Group> groupList;
	private ContactContentProvider contactContentProvider;
	private Context context;
	private ViewHolder holder; 
	private Group group;


	public CheckboxAdapter(Context context, int resource, int textViewResourceId, ArrayList<Group> groupList, ContactContentProvider contactContentProvider) {
		super(context, resource, textViewResourceId, groupList);
		this.groupList = groupList;
		this.contactContentProvider = contactContentProvider;
		this.context = context;
		this.holder = null;
		this.group = null;
	}
	
	private class ViewHolder {
		   protected CheckBox checkbox;
	}
	
	@Override
	  public View getView(final int position, View convertView, ViewGroup parent) {
		
	   Log.v("ConvertView", String.valueOf(position));
	  
	 
	   if (convertView == null) {
		   LayoutInflater vi = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		   convertView = vi.inflate(R.layout.checkboxlist, null);
		   
		   holder = new ViewHolder();
		   
		   //cache the view
		   holder.checkbox = (CheckBox) convertView.findViewById(R.id.checkBox1);
		   
		   group = groupList.get(position);
		   holder.checkbox.setText(group.getName());
		   holder.checkbox.setTag(group);
		   
//		   for(Iterator<Group> i = contactContentProvider.getEntity().getGroups().iterator(); i.hasNext(); ){
//			   if(i.next().getName().equalsIgnoreCase(group.getName()))
//				   holder.checkbox.setChecked(true);
////			   else
////				   holder.checkbox.setChecked(false);
//		   }
			if(contactContentProvider.getEntity().getGroups().contains(group)){
				holder.checkbox.setChecked(true);
			}
			else{
			  	holder.checkbox.setChecked(false);
			}
		 
		   //link the chached views to the convertview
		   convertView.setTag(holder); 
	   }
	   else {
			if(contactContentProvider.getEntity().getGroups().contains(group)){
				holder.checkbox.setChecked(true);
			}
			else{
			  	holder.checkbox.setChecked(false);
			}
	    holder = (ViewHolder) convertView.getTag();
	    
	   }
	   
	   
	   this.notifyDataSetChanged();
	   convertView.refreshDrawableState();
	   holder.checkbox.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			if(!contactContentProvider.getEntity().getGroups().contains(group)){
			    contactContentProvider.getEntity().getGroups().add(group);
			}
			else{
			    contactContentProvider.getEntity().getGroups().remove(group);
			}
	       v.refreshDrawableState();
			
		}
	});
	 
	   return convertView;
	  }

//	@Override
//	public void onClick(View v) {
//	CheckBox cb = (CheckBox) v ; 
////       if(cb.isChecked()){
////    	   contactContentProvider.getEntity().getGroups().add(groupList.get(currentPosition));
////       }
////       else{
////    	   contactContentProvider.getEntity().getGroups().remove(groupList.get(currentPosition));
////       }
//       
//		if(!contactContentProvider.getEntity().getGroups().contains(group)){
//		    contactContentProvider.getEntity().getGroups().add(group);
//		    //cb.setChecked(true);
//		}
//		else{
//		    contactContentProvider.getEntity().getGroups().remove(group);
//		    //cb.setChecked(false);
//		}
//       
//       this.notifyDataSetChanged();
//       v.refreshDrawableState();
//   }
}
