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
import de.wwu.masterthesis.reference.android.models.Contact;
import de.wwu.masterthesis.reference.android.R;

@SuppressWarnings("all")
public class StartUpAction extends CustomAction {
	
	public StartUpAction(MD2Application application) {
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
			public void execute(final MD2Application app) {
				
				
				app.getEventBus().subscribe("retrieveGPS_Touched", "retrieveGPS_Touched_RetrieveGPSPositionAction", app.findActionByType(RetrieveGPSPositionAction.class));
		
			}
			
		});
		
		addCodeFragment(new CodeFragment() {
			
			@Override
			public String getActivityName() {
				return null;
			}
			
			@Override
			public void execute(final MD2Application app) {
				
				
				app.getEventBus().subscribe("editContactButton1_Touched", "editContactButton1_Touched_GotoViewAction_detailTab", new MD2EventHandler() {
					
					@Override
					public void eventOccured() {						
						if(app.getActiveActivity() instanceof TabbedActivity) {
							((TabbedActivity)app.getActiveActivity()).setSelectedTab("detailTab");
						}
						else {
							Intent intent = new Intent(app.getActiveActivity(), de.wwu.masterthesis.reference.android.controller.MainViewActivity.class);
							intent.putExtra("tabToShow", "detailTab");
							app.getActiveActivity().startActivity(intent);
						}
					}
				}
				);
		
			}
			
		});
		
		addCodeFragment(new CodeFragment() {
			
			@Override
			public String getActivityName() {
				return null;
			}
			
			@Override
			public void execute(final MD2Application app) {
				
				
				app.getEventBus().subscribe("addGroupButton_Touched", "addGroupButton_Touched_GotoViewAction_groupTab", new MD2EventHandler() {
					
					@Override
					public void eventOccured() {
						
						//Added manually
						GroupContentProvider groupContentProvider = (GroupContentProvider)app.findContentProviderByType(GroupContentProvider.class);
						groupContentProvider.resetEntity();
						//end
						
						if(app.getActiveActivity() instanceof TabbedActivity) {
							((TabbedActivity)app.getActiveActivity()).setSelectedTab("groupTab");
						}
						else {
							Intent intent = new Intent(app.getActiveActivity(), de.wwu.masterthesis.reference.android.controller.MainViewActivity.class);
							intent.putExtra("tabToShow", "groupTab");
							app.getActiveActivity().startActivity(intent);
						}
					}
				}
				);
		
			}
			
		});
		
		addCodeFragment(new CodeFragment() {
			
			@Override
			public String getActivityName() {
				return null;
			}
			
			@Override
			public void execute(final MD2Application app) {
				
				
				app.getEventBus().subscribe("saveButton1_Touched", "saveButton1_Touched_DataAction_ContactContentProvider_CreateOrUpdate;", new MD2EventHandler() {
					
					@Override
					public void eventOccured() {
						app.findContentProviderByType(ContactContentProvider.class).saveEntity();
					}
				}
				);
		
			}
			
		});
		
		addCodeFragment(new CodeFragment() {
			
			@Override
			public String getActivityName() {
				return null;
			}
			
			@Override
			public void execute(final MD2Application app) {
				
				
				app.getEventBus().subscribe("saveButton2_Touched", "saveButton2_Touched_DataAction_GroupContentProvider_CreateOrUpdate;", new MD2EventHandler() {
					
					@Override
					public void eventOccured() {
						app.findContentProviderByType(GroupContentProvider.class).saveEntity();
					}
				}
				);
		
			}
			
		});
		
		addCodeFragment(new CodeFragment() {
			
			@Override
			public String getActivityName() {
				return null;
			}
			
			@Override
			public void execute(final MD2Application app) {
				
				
				app.getEventBus().subscribe("saveButton_Touched", "saveButton_Touched_GotoViewAction_contactsTab", new MD2EventHandler() {
					
					@Override
					public void eventOccured() {
						if(app.getActiveActivity() instanceof TabbedActivity) {
							((TabbedActivity)app.getActiveActivity()).setSelectedTab("contactsTab");
						}
						else {
							Intent intent = new Intent(app.getActiveActivity(), de.wwu.masterthesis.reference.android.controller.MainViewActivity.class);
							intent.putExtra("tabToShow", "contactsTab");
							app.getActiveActivity().startActivity(intent);
						}
					}
				}
				);
		
			}
			
		});
		
		addCodeFragment(new CodeFragment() {
			
			@Override
			public String getActivityName() {
				return null;
			}
			
			@Override
			public void execute(final MD2Application app) {
				
				
				app.getEventBus().subscribe("saveButton3_Touched", "saveButton3_Touched_GotoViewAction_detailTab", new MD2EventHandler() {
					
					@Override
					public void eventOccured() {
						if(app.getActiveActivity() instanceof TabbedActivity) {
							((TabbedActivity)app.getActiveActivity()).setSelectedTab("detailTab");
						}
						else {
							Intent intent = new Intent(app.getActiveActivity(), de.wwu.masterthesis.reference.android.controller.MainViewActivity.class);
							intent.putExtra("tabToShow", "detailTab");
							app.getActiveActivity().startActivity(intent);
						}
					}
				}
				);
		
			}
			
		});
		
		addCodeFragment(new CodeFragment() {
			
			@Override
			public String getActivityName() {
				return null;
			}
			
			@Override
			public void execute(final MD2Application app) {
				
				
				app.getEventBus().subscribe("retrieveGPS1_Touched", "retrieveGPS1_Touched_RetrieveGPSPositionAction", app.findActionByType(RetrieveGPSPositionAction.class));
		
			}
			
		});
		
		addCodeFragment(new CodeFragment() {
			
			@Override
			public String getActivityName() {
				return null;
			}
			
			@Override
			public void execute(final MD2Application app) {
				
				
				app.getEventBus().subscribe("editContactButton_Touched", "editContactButton_Touched_GotoViewAction_detailTab", new MD2EventHandler() {
					
					@Override
					public void eventOccured() {
						//Added manually
						ContactContentProvider contactContentProvider = (ContactContentProvider)app.findContentProviderByType(ContactContentProvider.class);
						contactContentProvider.resetEntity();
						//end
						
						if(app.getActiveActivity() instanceof TabbedActivity) {
							((TabbedActivity)app.getActiveActivity()).setSelectedTab("detailTab");
						}
						else {
							Intent intent = new Intent(app.getActiveActivity(), de.wwu.masterthesis.reference.android.controller.MainViewActivity.class);
							intent.putExtra("tabToShow", "detailTab");
							app.getActiveActivity().startActivity(intent);
						}
					}
				}
				);
		
			}
			
		});
		
		addCodeFragment(new CodeFragment() {
			
			@Override
			public String getActivityName() {
				return null;
			}
			
			@Override
			public void execute(final MD2Application app) {
				
				
				app.getEventBus().subscribe("addGroupButton1_Touched", "addGroupButton1_Touched_GotoViewAction_groupTab", new MD2EventHandler() {
					
					@Override
					public void eventOccured() {
						//Added manually
						GroupContentProvider groupContentProvider = (GroupContentProvider)app.findContentProviderByType(GroupContentProvider.class);
						groupContentProvider.resetEntity();
						//end
						
						if(app.getActiveActivity() instanceof TabbedActivity) {
							((TabbedActivity)app.getActiveActivity()).setSelectedTab("groupTab");
						}
						else {
							Intent intent = new Intent(app.getActiveActivity(), de.wwu.masterthesis.reference.android.controller.MainViewActivity.class);
							intent.putExtra("tabToShow", "groupTab");
							app.getActiveActivity().startActivity(intent);
						}
					}
				}
				);
		
			}
			
		});
		
		addCodeFragment(new CodeFragment() {
			
			@Override
			public String getActivityName() {
				return null;
			}
			
			@Override
			public void execute(final MD2Application app) {
				
				
				app.getEventBus().subscribe("saveButton1_Touched", "saveButton1_Touched_GotoViewAction_contactsTab", new MD2EventHandler() {
					
					@Override
					public void eventOccured() {
						if(app.getActiveActivity() instanceof TabbedActivity) {
							((TabbedActivity)app.getActiveActivity()).setSelectedTab("contactsTab");
						}
						else {
							Intent intent = new Intent(app.getActiveActivity(), de.wwu.masterthesis.reference.android.controller.MainViewActivity.class);
							intent.putExtra("tabToShow", "contactsTab");
							app.getActiveActivity().startActivity(intent);
						}
					}
				}
				);
		
			}
			
		});
		
		addCodeFragment(new CodeFragment() {
			
			@Override
			public String getActivityName() {
				return null;
			}
			
			@Override
			public void execute(final MD2Application app) {
				
				
				app.getEventBus().subscribe("saveButton2_Touched", "saveButton2_Touched_GotoViewAction_detailTab", new MD2EventHandler() {
					
					@Override
					public void eventOccured() {
						if(app.getActiveActivity() instanceof TabbedActivity) {
							((TabbedActivity)app.getActiveActivity()).setSelectedTab("detailTab");
						}
						else {
							Intent intent = new Intent(app.getActiveActivity(), de.wwu.masterthesis.reference.android.controller.MainViewActivity.class);
							intent.putExtra("tabToShow", "detailTab");
							app.getActiveActivity().startActivity(intent);
						}
					}
				}
				);
		
			}
			
		});
		
	}
}

