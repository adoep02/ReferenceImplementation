package de.wwu.masterthesis.reference.android.actions;

import android.content.Intent;
import android.location.Address;
import android.location.Location;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;
import de.wwu.md2.android.lib.MD2Application;
import de.wwu.md2.android.lib.controller.actions.*;
import de.wwu.md2.android.lib.controller.binding.CheckBoxMapping;
import de.wwu.md2.android.lib.controller.binding.DateTimeTextViewMapping;
import de.wwu.md2.android.lib.controller.binding.EnumPathResolver;
import de.wwu.md2.android.lib.controller.binding.FloatTextViewMapping;
import de.wwu.md2.android.lib.controller.binding.IntegerTextViewMapping;
import de.wwu.md2.android.lib.controller.binding.PathResolver;
import de.wwu.md2.android.lib.controller.binding.SpinnerMapping;
import de.wwu.md2.android.lib.controller.binding.StringTextViewMapping;
import de.wwu.md2.android.lib.controller.contentprovider.GPSAddressProvider;
import de.wwu.md2.android.lib.controller.contentprovider.GPSAddressProvider.GPSAddressReceiver;
import de.wwu.md2.android.lib.controller.events.MD2EventHandler;
import de.wwu.md2.android.lib.controller.validators.NotNullValidator;
import de.wwu.md2.android.lib.controller.validators.NumberRangeValidator;
import de.wwu.md2.android.lib.controller.validators.StringRangeValidator;
import de.wwu.md2.android.lib.controller.validators.RegExValidator;
import de.wwu.md2.android.lib.controller.validators.IsDateValidator;
import de.wwu.md2.android.lib.controller.validators.IsNumberValidator;
import de.wwu.md2.android.lib.controller.validators.IsIntValidator;
import de.wwu.md2.android.lib.model.MD2Enum;
import de.wwu.md2.android.lib.view.TabbedActivity;
import de.wwu.masterthesis.reference.android.contentprovider.*;
import de.wwu.masterthesis.reference.android.R;

@SuppressWarnings("all")
public class RetrieveGPSPositionAction extends CustomAction {
	
	public RetrieveGPSPositionAction(MD2Application application) {
		super(application);
	}

	@Override
	protected void initializeCodeFragments() {
		
		addCodeFragment(new CodeFragment() {
			@Override
			public String getActivityName() {
				return null;
			}
			
			@Override
			public void execute(MD2Application app) {
				GPSAddressReceiver receiver = new GPSAddressReceiver() {
					@Override
					public void receiveGPSAddress(MD2Application app, Address address, Location location) {
						StringBuilder sb;
						// Build value to set
						sb = new StringBuilder();
						if(address.getThoroughfare() != null) {
							sb.append(address.getThoroughfare());
						}
						
						// Set value
						app.findContentProviderByType(ContactContentProvider.class).getEntity().setStreet(sb.toString());
						app.findContentProviderByType(ContactContentProvider.class).throwRefreshEvent();
						// Build value to set
						sb = new StringBuilder();
						if(address.getLocality() != null) {
							sb.append(address.getLocality());
						}
						
						// Set value
						app.findContentProviderByType(ContactContentProvider.class).getEntity().setCity(sb.toString());
						app.findContentProviderByType(ContactContentProvider.class).throwRefreshEvent();
						// Build value to set
						sb = new StringBuilder();
						if(address.getPostalCode() != null) {
							sb.append(address.getPostalCode());
						}
						
						// Set value
						app.findContentProviderByType(ContactContentProvider.class).getEntity().setZipCode(Integer.parseInt(sb.toString()));
						app.findContentProviderByType(ContactContentProvider.class).throwRefreshEvent();
					}
				};
				GPSAddressProvider gpsAddressProvider = new GPSAddressProvider(app, receiver);
				gpsAddressProvider.provideGPSAddress();
			}
		});
		
	}
}
