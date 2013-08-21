package de.wwu.masterthesis.reference.android.controller;

import java.util.ArrayList;

import android.app.DialogFragment;
import android.app.Fragment;
import android.app.ListFragment;
import android.os.Bundle;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView.OnItemClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import de.wwu.md2.android.lib.MD2Application;
import de.wwu.md2.android.lib.controller.contentprovider.EntitySelectorHandler;
import de.wwu.md2.android.lib.controller.events.MD2EventHandler;
import de.wwu.md2.android.lib.controller.events.MD2FocusLeftEvent;
import de.wwu.md2.android.lib.controller.events.MD2ItemSelectedEvent;
import de.wwu.md2.android.lib.controller.events.MD2TouchEvent;
import de.wwu.md2.android.lib.controller.validators.NotNullValidator;
import de.wwu.md2.android.lib.view.DatePickerFragment;
import de.wwu.md2.android.lib.view.DateTimePickerFragment;
import de.wwu.md2.android.lib.view.MessageBoxFragment;
import de.wwu.md2.android.lib.view.TabbedActivity;
import de.wwu.md2.android.lib.view.TimePickerFragment;
import de.wwu.masterthesis.reference.android.R;
import de.wwu.masterthesis.reference.android.contentprovider.ContactContentProvider;
import de.wwu.masterthesis.reference.android.models.Contact;

@SuppressWarnings("unused")
public class ContactsTabFragment extends Fragment {
	
	private View view;
	private boolean isInitialized;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// If the view is already inflated, no initialization is required
		isInitialized = view != null;
		
		if(!isInitialized) {
			// Check whether app object has to be reinitialized
			getApp().checkForReinitialization("ContactsTab");
			
			view = inflater.inflate(R.layout.contactstab, container, false);
		}
		
		
		//added manually
		ContactContentProvider contentProvider = (ContactContentProvider)getApp().findContentProviderByType(ContactContentProvider.class);
		ArrayList<Contact> contactList = contentProvider.getContentList();
				
				
		//Create ListAdapter to present Items in Array
		ListAdapter adapter = new ArrayAdapter<Contact>(getApp().getApplicationContext(), android.R.layout.simple_list_item_1, contactList);
		
		final ListView lv = (ListView) view.findViewById(R.id.contactlist);
		lv.setAdapter(adapter);
						
		//OnClickEvent
		lv.setOnItemClickListener(new OnItemClickListener(){
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				ContactContentProvider contentProvider = (ContactContentProvider)getApp().findContentProviderByType(ContactContentProvider.class);
				contentProvider.setEntity((Contact)lv.getAdapter().getItem(arg2));
				if(getApp().getActiveActivity() instanceof TabbedActivity) {
					((TabbedActivity)getApp().getActiveActivity()).setSelectedTab("detailTab");
				}
				else {
					Intent intent = new Intent(getApp().getActiveActivity(), de.wwu.masterthesis.reference.android.controller.MainViewActivity.class);
					intent.putExtra("tabToShow", "detailTab");
					getApp().getActiveActivity().startActivity(intent);
				}	
			}
		 }
		);
		//end
				
		return view;
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
		if(!isInitialized) {
			// Initialize date and time pickers
			initializeDateTimePickers();
			
			// Initialize event handling
			initializeEvents();
			
			// Initialize tool tips
			initializeToolTips();
			
			// Initialize entity selectors
			initializeEntitySelectors();
			
			isInitialized = true;
		}
	}
	
	@Override
    public void onResume() {
        super.onResume();
		getApp().setActiveActivity("ContactsTab", getActivity());
    }
	
	@Override
	public void onHiddenChanged(boolean hidden) {
		// Additionally to onResume this method has to be used to notify on tab
		// changes, because hiding and then showing a tab does not lead to a
		// call of onResume.
		if (!hidden) {
			getApp().setActiveActivity("ContactsTab", getActivity());
		}
	}
	
	private void initializeDateTimePickers() {
	}
	
	private void initializeToolTips() {
	}
	
	private void initializeEvents() {
		getView().findViewById(R.id.editContactButton).setOnClickListener(new MD2TouchEvent(getApp().getEventBus(), "editContactButton_Touched"));
	}
	
	private void initializeEntitySelectors() {
	}
	
	private MD2Application getApp() {
		return (MD2Application) getActivity().getApplication();
	}
}
