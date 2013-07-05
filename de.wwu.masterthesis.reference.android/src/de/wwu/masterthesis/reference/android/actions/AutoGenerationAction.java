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
public class AutoGenerationAction extends CustomAction {
	
	public AutoGenerationAction(MD2Application application) {
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
				// This code fragment is related to a view element contained in an activity or fragment
				// that has not been generated, because it will never be used (usually view containers
				// that are defined on the top level and are referenced inside other view containers)
			}
			
		});
		
		addCodeFragment(new CodeFragment() {
			
			@Override
			public String getActivityName() {
				return null;
			}
			
			@Override
			public void execute(MD2Application app) {
				// This code fragment is related to a view element contained in an activity or fragment
				// that has not been generated, because it will never be used (usually view containers
				// that are defined on the top level and are referenced inside other view containers)
			}
			
		});
		
		addCodeFragment(new CodeFragment() {
			
			@Override
			public String getActivityName() {
				return null;
			}
			
			@Override
			public void execute(MD2Application app) {
				// This code fragment is related to a view element contained in an activity or fragment
				// that has not been generated, because it will never be used (usually view containers
				// that are defined on the top level and are referenced inside other view containers)
			}
			
		});
		
		addCodeFragment(new CodeFragment() {
			
			@Override
			public String getActivityName() {
				return null;
			}
			
			@Override
			public void execute(MD2Application app) {
				// This code fragment is related to a view element contained in an activity or fragment
				// that has not been generated, because it will never be used (usually view containers
				// that are defined on the top level and are referenced inside other view containers)
			}
			
		});
		
		addCodeFragment(new CodeFragment() {
			
			@Override
			public String getActivityName() {
				return null;
			}
			
			@Override
			public void execute(MD2Application app) {
				// This code fragment is related to a view element contained in an activity or fragment
				// that has not been generated, because it will never be used (usually view containers
				// that are defined on the top level and are referenced inside other view containers)
			}
			
		});
		
		addCodeFragment(new CodeFragment() {
			
			@Override
			public String getActivityName() {
				return null;
			}
			
			@Override
			public void execute(MD2Application app) {
				// This code fragment is related to a view element contained in an activity or fragment
				// that has not been generated, because it will never be used (usually view containers
				// that are defined on the top level and are referenced inside other view containers)
			}
			
		});
		
		addCodeFragment(new CodeFragment() {
			
			@Override
			public String getActivityName() {
				return null;
			}
			
			@Override
			public void execute(MD2Application app) {
				// This code fragment is related to a view element contained in an activity or fragment
				// that has not been generated, because it will never be used (usually view containers
				// that are defined on the top level and are referenced inside other view containers)
			}
			
		});
		
		addCodeFragment(new CodeFragment() {
			
			@Override
			public String getActivityName() {
				return null;
			}
			
			@Override
			public void execute(MD2Application app) {
				// This code fragment is related to a view element contained in an activity or fragment
				// that has not been generated, because it will never be used (usually view containers
				// that are defined on the top level and are referenced inside other view containers)
			}
			
		});
		
		addCodeFragment(new CodeFragment() {
			
			@Override
			public String getActivityName() {
				return null;
			}
			
			@Override
			public void execute(MD2Application app) {
				// This code fragment is related to a view element contained in an activity or fragment
				// that has not been generated, because it will never be used (usually view containers
				// that are defined on the top level and are referenced inside other view containers)
			}
			
		});
		
		addCodeFragment(new CodeFragment() {
			
			@Override
			public String getActivityName() {
				return "GroupTab";
			}
			
			@Override
			public void execute(MD2Application app) {
				app.getMappings().add(
					new StringTextViewMapping<de.wwu.masterthesis.reference.android.models.Group>(
						(TextView) app.getActiveActivity().findViewById(R.id.nameTextInput2),
						app.findContentProviderByType(GroupContentProvider.class),
						new PathResolver<de.wwu.masterthesis.reference.android.models.Group, String>() {
							public String retrieveValue(de.wwu.masterthesis.reference.android.models.Group entity) {
								return entity.getName();
							}
							
							public void adaptValue(de.wwu.masterthesis.reference.android.models.Group entity, String value) {
								entity.setName(value);
							}
						},
						app.getEventBus(),
						"nameTextInput2",
						getActivityName()
					)
				);
			}
			
		});
		
		addCodeFragment(new CodeFragment() {
			
			@Override
			public String getActivityName() {
				return "DetailTab";
			}
			
			@Override
			public void execute(MD2Application app) {
				app.getMappings().add(
					new IntegerTextViewMapping<de.wwu.masterthesis.reference.android.models.Contact>(
						(TextView) app.getActiveActivity().findViewById(R.id.photoTextInput1),
						app.findContentProviderByType(ContactContentProvider.class),
						new PathResolver<de.wwu.masterthesis.reference.android.models.Contact, Integer>() {
							public Integer retrieveValue(de.wwu.masterthesis.reference.android.models.Contact entity) {
								return entity.getPhoto();
							}
							
							public void adaptValue(de.wwu.masterthesis.reference.android.models.Contact entity, Integer value) {
								entity.setPhoto(value);
							}
						},
						app.getEventBus(),
						"photoTextInput1",
						getActivityName()
					)
				);
			}
			
		});
		
		addCodeFragment(new CodeFragment() {
			
			@Override
			public String getActivityName() {
				return "DetailTab";
			}
			
			@Override
			public void execute(MD2Application app) {
				app.getMappings().add(
					new StringTextViewMapping<de.wwu.masterthesis.reference.android.models.Contact>(
						(TextView) app.getActiveActivity().findViewById(R.id.nameTextInput1),
						app.findContentProviderByType(ContactContentProvider.class),
						new PathResolver<de.wwu.masterthesis.reference.android.models.Contact, String>() {
							public String retrieveValue(de.wwu.masterthesis.reference.android.models.Contact entity) {
								return entity.getName();
							}
							
							public void adaptValue(de.wwu.masterthesis.reference.android.models.Contact entity, String value) {
								entity.setName(value);
							}
						},
						app.getEventBus(),
						"nameTextInput1",
						getActivityName()
					)
				);
			}
			
		});
		
		addCodeFragment(new CodeFragment() {
			
			@Override
			public String getActivityName() {
				return "DetailTab";
			}
			
			@Override
			public void execute(MD2Application app) {
				app.getMappings().add(
					new StringTextViewMapping<de.wwu.masterthesis.reference.android.models.Contact>(
						(TextView) app.getActiveActivity().findViewById(R.id.firstnameTextInput1),
						app.findContentProviderByType(ContactContentProvider.class),
						new PathResolver<de.wwu.masterthesis.reference.android.models.Contact, String>() {
							public String retrieveValue(de.wwu.masterthesis.reference.android.models.Contact entity) {
								return entity.getFirstname();
							}
							
							public void adaptValue(de.wwu.masterthesis.reference.android.models.Contact entity, String value) {
								entity.setFirstname(value);
							}
						},
						app.getEventBus(),
						"firstnameTextInput1",
						getActivityName()
					)
				);
			}
			
		});
		
		addCodeFragment(new CodeFragment() {
			
			@Override
			public String getActivityName() {
				return "DetailTab";
			}
			
			@Override
			public void execute(MD2Application app) {
				app.getMappings().add(
					new IntegerTextViewMapping<de.wwu.masterthesis.reference.android.models.Contact>(
						(TextView) app.getActiveActivity().findViewById(R.id.phoneTextInput1),
						app.findContentProviderByType(ContactContentProvider.class),
						new PathResolver<de.wwu.masterthesis.reference.android.models.Contact, Integer>() {
							public Integer retrieveValue(de.wwu.masterthesis.reference.android.models.Contact entity) {
								return entity.getPhone();
							}
							
							public void adaptValue(de.wwu.masterthesis.reference.android.models.Contact entity, Integer value) {
								entity.setPhone(value);
							}
						},
						app.getEventBus(),
						"phoneTextInput1",
						getActivityName()
					)
				);
			}
			
		});
		
		addCodeFragment(new CodeFragment() {
			
			@Override
			public String getActivityName() {
				return "DetailTab";
			}
			
			@Override
			public void execute(MD2Application app) {
				app.getMappings().add(
					new StringTextViewMapping<de.wwu.masterthesis.reference.android.models.Contact>(
						(TextView) app.getActiveActivity().findViewById(R.id.emailTextInput1),
						app.findContentProviderByType(ContactContentProvider.class),
						new PathResolver<de.wwu.masterthesis.reference.android.models.Contact, String>() {
							public String retrieveValue(de.wwu.masterthesis.reference.android.models.Contact entity) {
								return entity.getEmail();
							}
							
							public void adaptValue(de.wwu.masterthesis.reference.android.models.Contact entity, String value) {
								entity.setEmail(value);
							}
						},
						app.getEventBus(),
						"emailTextInput1",
						getActivityName()
					)
				);
			}
			
		});
		
		addCodeFragment(new CodeFragment() {
			
			@Override
			public String getActivityName() {
				return "DetailTab";
			}
			
			@Override
			public void execute(MD2Application app) {
				app.getMappings().add(
					new StringTextViewMapping<de.wwu.masterthesis.reference.android.models.Contact>(
						(TextView) app.getActiveActivity().findViewById(R.id.streetTextInput1),
						app.findContentProviderByType(ContactContentProvider.class),
						new PathResolver<de.wwu.masterthesis.reference.android.models.Contact, String>() {
							public String retrieveValue(de.wwu.masterthesis.reference.android.models.Contact entity) {
								return entity.getStreet();
							}
							
							public void adaptValue(de.wwu.masterthesis.reference.android.models.Contact entity, String value) {
								entity.setStreet(value);
							}
						},
						app.getEventBus(),
						"streetTextInput1",
						getActivityName()
					)
				);
			}
			
		});
		
		addCodeFragment(new CodeFragment() {
			
			@Override
			public String getActivityName() {
				return "DetailTab";
			}
			
			@Override
			public void execute(MD2Application app) {
				app.getMappings().add(
					new StringTextViewMapping<de.wwu.masterthesis.reference.android.models.Contact>(
						(TextView) app.getActiveActivity().findViewById(R.id.cityTextInput1),
						app.findContentProviderByType(ContactContentProvider.class),
						new PathResolver<de.wwu.masterthesis.reference.android.models.Contact, String>() {
							public String retrieveValue(de.wwu.masterthesis.reference.android.models.Contact entity) {
								return entity.getCity();
							}
							
							public void adaptValue(de.wwu.masterthesis.reference.android.models.Contact entity, String value) {
								entity.setCity(value);
							}
						},
						app.getEventBus(),
						"cityTextInput1",
						getActivityName()
					)
				);
			}
			
		});
		
		addCodeFragment(new CodeFragment() {
			
			@Override
			public String getActivityName() {
				return "DetailTab";
			}
			
			@Override
			public void execute(MD2Application app) {
				app.getMappings().add(
					new IntegerTextViewMapping<de.wwu.masterthesis.reference.android.models.Contact>(
						(TextView) app.getActiveActivity().findViewById(R.id.zipCodeTextInput1),
						app.findContentProviderByType(ContactContentProvider.class),
						new PathResolver<de.wwu.masterthesis.reference.android.models.Contact, Integer>() {
							public Integer retrieveValue(de.wwu.masterthesis.reference.android.models.Contact entity) {
								return entity.getZipCode();
							}
							
							public void adaptValue(de.wwu.masterthesis.reference.android.models.Contact entity, Integer value) {
								entity.setZipCode(value);
							}
						},
						app.getEventBus(),
						"zipCodeTextInput1",
						getActivityName()
					)
				);
			}
			
		});
		
		addCodeFragment(new CodeFragment() {
			
			@Override
			public String getActivityName() {
				return null;
			}
			
			@Override
			public void execute(MD2Application app) {
				
				// This code fragment is related to a view element contained in an activity or fragment
				// that has not been generated, because it will never be used (usually view containers
				// that are defined on the top level and are referenced inside other view containers)
			}
			
		});
		
		addCodeFragment(new CodeFragment() {
			
			@Override
			public String getActivityName() {
				return "DetailTab";
			}
			
			@Override
			public void execute(MD2Application app) {
				
				new IsIntValidator("", (TextView)app.getActiveActivity().findViewById(R.id.phoneTextInput1), app, "phoneTextInput1");
				
			}
			
		});
		
		addCodeFragment(new CodeFragment() {
			
			@Override
			public String getActivityName() {
				return "DetailTab";
			}
			
			@Override
			public void execute(MD2Application app) {
				
				new NotNullValidator("", (TextView)app.getActiveActivity().findViewById(R.id.firstnameTextInput1), app, "firstnameTextInput1");
				
			}
			
		});
		
		addCodeFragment(new CodeFragment() {
			
			@Override
			public String getActivityName() {
				return null;
			}
			
			@Override
			public void execute(MD2Application app) {
				
				// This code fragment is related to a view element contained in an activity or fragment
				// that has not been generated, because it will never be used (usually view containers
				// that are defined on the top level and are referenced inside other view containers)
			}
			
		});
		
		addCodeFragment(new CodeFragment() {
			
			@Override
			public String getActivityName() {
				return null;
			}
			
			@Override
			public void execute(MD2Application app) {
				
				// This code fragment is related to a view element contained in an activity or fragment
				// that has not been generated, because it will never be used (usually view containers
				// that are defined on the top level and are referenced inside other view containers)
			}
			
		});
		
		addCodeFragment(new CodeFragment() {
			
			@Override
			public String getActivityName() {
				return "DetailTab";
			}
			
			@Override
			public void execute(MD2Application app) {
				
				new NotNullValidator("", (TextView)app.getActiveActivity().findViewById(R.id.nameTextInput1), app, "nameTextInput1");
				
			}
			
		});
		
		addCodeFragment(new CodeFragment() {
			
			@Override
			public String getActivityName() {
				return null;
			}
			
			@Override
			public void execute(MD2Application app) {
				
				// This code fragment is related to a view element contained in an activity or fragment
				// that has not been generated, because it will never be used (usually view containers
				// that are defined on the top level and are referenced inside other view containers)
			}
			
		});
		
		addCodeFragment(new CodeFragment() {
			
			@Override
			public String getActivityName() {
				return "DetailTab";
			}
			
			@Override
			public void execute(MD2Application app) {
				
				new IsIntValidator("", (TextView)app.getActiveActivity().findViewById(R.id.photoTextInput1), app, "photoTextInput1");
				
			}
			
		});
		
		addCodeFragment(new CodeFragment() {
			
			@Override
			public String getActivityName() {
				return null;
			}
			
			@Override
			public void execute(MD2Application app) {
				
				// This code fragment is related to a view element contained in an activity or fragment
				// that has not been generated, because it will never be used (usually view containers
				// that are defined on the top level and are referenced inside other view containers)
			}
			
		});
		
		addCodeFragment(new CodeFragment() {
			
			@Override
			public String getActivityName() {
				return "DetailTab";
			}
			
			@Override
			public void execute(MD2Application app) {
				
				new IsIntValidator("", (TextView)app.getActiveActivity().findViewById(R.id.zipCodeTextInput1), app, "zipCodeTextInput1");
				
				new NumberRangeValidator("", (TextView)app.getActiveActivity().findViewById(R.id.zipCodeTextInput1), app, "zipCodeTextInput1", 1000.0, 99999.0);
				
			}
			
		});
		
		addCodeFragment(new CodeFragment() {
			
			@Override
			public String getActivityName() {
				return null;
			}
			
			@Override
			public void execute(MD2Application app) {
				
				// This code fragment is related to a view element contained in an activity or fragment
				// that has not been generated, because it will never be used (usually view containers
				// that are defined on the top level and are referenced inside other view containers)
			}
			
		});
		
		addCodeFragment(new CodeFragment() {
			
			@Override
			public String getActivityName() {
				return "GroupTab";
			}
			
			@Override
			public void execute(MD2Application app) {
				
				new NotNullValidator("", (TextView)app.getActiveActivity().findViewById(R.id.nameTextInput2), app, "nameTextInput2");
				
			}
			
		});
		
	}
}

