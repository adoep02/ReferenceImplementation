package de.wwu.masterthesis.reference.android.controller;

import java.util.ArrayList;

import android.app.DialogFragment;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
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
import de.wwu.md2.android.lib.view.TimePickerFragment;
import de.wwu.masterthesis.reference.android.R;
import de.wwu.masterthesis.reference.android.adapter.CheckboxAdapter;
import de.wwu.masterthesis.reference.android.contentprovider.ContactContentProvider;
import de.wwu.masterthesis.reference.android.contentprovider.GroupContentProvider;
import de.wwu.masterthesis.reference.android.models.Group;

@SuppressWarnings("unused")
public class DetailTabFragment extends Fragment {
	
	private View view;
	private boolean isInitialized;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// If the view is already inflated, no initialization is required
		isInitialized = view != null;
		
		if(!isInitialized) {
			// Check whether app object has to be reinitialized
			getApp().checkForReinitialization("DetailTab");
			
			view = inflater.inflate(R.layout.detailtab, container, false);
		}
		
		//added manually
		//get ArrayList of contacts
		GroupContentProvider contentProvider = (GroupContentProvider)getApp().findContentProviderByType(GroupContentProvider.class);
		ArrayList<Group> groupList = contentProvider.getGroups();
		
		System.out.println("-----------" + groupList.size());
				
		ContactContentProvider contactContentProvider = (ContactContentProvider)getApp().findContentProviderByType(ContactContentProvider.class);
									
		//Create ListAdapter to present Items in Array
		ListAdapter adapter = new CheckboxAdapter(getApp().getApplicationContext(), R.layout.checkboxlist, R.id.checkBox1, groupList, contactContentProvider.getEntity());
					
		ListView lv = (ListView) view.findViewById(R.id.grouplist);
		lv.setAdapter(adapter);
				
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
        
		getApp().setActiveActivity("DetailTab", getActivity());
    }
	
	@Override
	public void onHiddenChanged(boolean hidden) {
		// Additionally to onResume this method has to be used to notify on tab
		// changes, because hiding and then showing a tab does not lead to a
		// call of onResume.
		if (!hidden) {
			getApp().setActiveActivity("DetailTab", getActivity());
		}
	}
	
	private void initializeDateTimePickers() {
	}
	
	private void initializeToolTips() {
	}
	
	private void initializeEvents() {
		getView().findViewById(R.id.photoTextInput1).setOnFocusChangeListener(new MD2FocusLeftEvent(getApp().getEventBus(), "photoTextInput1_FocusLeft"));
		getView().findViewById(R.id.photoTextInput1).setOnClickListener(new MD2TouchEvent(getApp().getEventBus(), "photoTextInput1_Touched"));
		getView().findViewById(R.id.nameTextInput1).setOnFocusChangeListener(new MD2FocusLeftEvent(getApp().getEventBus(), "nameTextInput1_FocusLeft"));
		getView().findViewById(R.id.nameTextInput1).setOnClickListener(new MD2TouchEvent(getApp().getEventBus(), "nameTextInput1_Touched"));
		getView().findViewById(R.id.firstnameTextInput1).setOnFocusChangeListener(new MD2FocusLeftEvent(getApp().getEventBus(), "firstnameTextInput1_FocusLeft"));
		getView().findViewById(R.id.firstnameTextInput1).setOnClickListener(new MD2TouchEvent(getApp().getEventBus(), "firstnameTextInput1_Touched"));
		getView().findViewById(R.id.phoneTextInput1).setOnFocusChangeListener(new MD2FocusLeftEvent(getApp().getEventBus(), "phoneTextInput1_FocusLeft"));
		getView().findViewById(R.id.phoneTextInput1).setOnClickListener(new MD2TouchEvent(getApp().getEventBus(), "phoneTextInput1_Touched"));
		getView().findViewById(R.id.emailTextInput1).setOnFocusChangeListener(new MD2FocusLeftEvent(getApp().getEventBus(), "emailTextInput1_FocusLeft"));
		getView().findViewById(R.id.emailTextInput1).setOnClickListener(new MD2TouchEvent(getApp().getEventBus(), "emailTextInput1_Touched"));
		getView().findViewById(R.id.streetTextInput1).setOnFocusChangeListener(new MD2FocusLeftEvent(getApp().getEventBus(), "streetTextInput1_FocusLeft"));
		getView().findViewById(R.id.streetTextInput1).setOnClickListener(new MD2TouchEvent(getApp().getEventBus(), "streetTextInput1_Touched"));
		getView().findViewById(R.id.cityTextInput1).setOnFocusChangeListener(new MD2FocusLeftEvent(getApp().getEventBus(), "cityTextInput1_FocusLeft"));
		getView().findViewById(R.id.cityTextInput1).setOnClickListener(new MD2TouchEvent(getApp().getEventBus(), "cityTextInput1_Touched"));
		getView().findViewById(R.id.zipCodeTextInput1).setOnFocusChangeListener(new MD2FocusLeftEvent(getApp().getEventBus(), "zipCodeTextInput1_FocusLeft"));
		getView().findViewById(R.id.zipCodeTextInput1).setOnClickListener(new MD2TouchEvent(getApp().getEventBus(), "zipCodeTextInput1_Touched"));
		getView().findViewById(R.id.retrieveGPS1).setOnClickListener(new MD2TouchEvent(getApp().getEventBus(), "retrieveGPS1_Touched"));
		getView().findViewById(R.id.addGroupButton1).setOnClickListener(new MD2TouchEvent(getApp().getEventBus(), "addGroupButton1_Touched"));
		getView().findViewById(R.id.saveButton1).setOnClickListener(new MD2TouchEvent(getApp().getEventBus(), "saveButton1_Touched"));
	}
	
	private void initializeEntitySelectors() {
	}
	
	private MD2Application getApp() {
		return (MD2Application) getActivity().getApplication();
	}
}
