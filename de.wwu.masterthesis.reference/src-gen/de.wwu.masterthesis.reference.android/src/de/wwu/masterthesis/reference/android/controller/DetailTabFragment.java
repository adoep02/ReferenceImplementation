package de.wwu.masterthesis.reference.android.controller;

import android.app.DialogFragment;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
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
		getView().findViewById(R.id.photoTextInput).setOnFocusChangeListener(new MD2FocusLeftEvent(getApp().getEventBus(), "photoTextInput_FocusLeft"));
		getView().findViewById(R.id.photoTextInput).setOnClickListener(new MD2TouchEvent(getApp().getEventBus(), "photoTextInput_Touched"));
		getView().findViewById(R.id.nameTextInput1).setOnFocusChangeListener(new MD2FocusLeftEvent(getApp().getEventBus(), "nameTextInput1_FocusLeft"));
		getView().findViewById(R.id.nameTextInput1).setOnClickListener(new MD2TouchEvent(getApp().getEventBus(), "nameTextInput1_Touched"));
		getView().findViewById(R.id.firstnameTextInput).setOnFocusChangeListener(new MD2FocusLeftEvent(getApp().getEventBus(), "firstnameTextInput_FocusLeft"));
		getView().findViewById(R.id.firstnameTextInput).setOnClickListener(new MD2TouchEvent(getApp().getEventBus(), "firstnameTextInput_Touched"));
		getView().findViewById(R.id.phoneTextInput).setOnFocusChangeListener(new MD2FocusLeftEvent(getApp().getEventBus(), "phoneTextInput_FocusLeft"));
		getView().findViewById(R.id.phoneTextInput).setOnClickListener(new MD2TouchEvent(getApp().getEventBus(), "phoneTextInput_Touched"));
		getView().findViewById(R.id.emailTextInput).setOnFocusChangeListener(new MD2FocusLeftEvent(getApp().getEventBus(), "emailTextInput_FocusLeft"));
		getView().findViewById(R.id.emailTextInput).setOnClickListener(new MD2TouchEvent(getApp().getEventBus(), "emailTextInput_Touched"));
		getView().findViewById(R.id.streetTextInput).setOnFocusChangeListener(new MD2FocusLeftEvent(getApp().getEventBus(), "streetTextInput_FocusLeft"));
		getView().findViewById(R.id.streetTextInput).setOnClickListener(new MD2TouchEvent(getApp().getEventBus(), "streetTextInput_Touched"));
		getView().findViewById(R.id.cityTextInput).setOnFocusChangeListener(new MD2FocusLeftEvent(getApp().getEventBus(), "cityTextInput_FocusLeft"));
		getView().findViewById(R.id.cityTextInput).setOnClickListener(new MD2TouchEvent(getApp().getEventBus(), "cityTextInput_Touched"));
		getView().findViewById(R.id.zipCodeTextInput).setOnFocusChangeListener(new MD2FocusLeftEvent(getApp().getEventBus(), "zipCodeTextInput_FocusLeft"));
		getView().findViewById(R.id.zipCodeTextInput).setOnClickListener(new MD2TouchEvent(getApp().getEventBus(), "zipCodeTextInput_Touched"));
		getView().findViewById(R.id.retrieveGPS).setOnClickListener(new MD2TouchEvent(getApp().getEventBus(), "retrieveGPS_Touched"));
		getView().findViewById(R.id.addGroupButton).setOnClickListener(new MD2TouchEvent(getApp().getEventBus(), "addGroupButton_Touched"));
		getView().findViewById(R.id.saveButton1).setOnClickListener(new MD2TouchEvent(getApp().getEventBus(), "saveButton1_Touched"));
	}
	
	private void initializeEntitySelectors() {
	}
	
	private MD2Application getApp() {
		return (MD2Application) getActivity().getApplication();
	}
}
