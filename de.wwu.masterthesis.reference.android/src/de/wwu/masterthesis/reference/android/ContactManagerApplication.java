package de.wwu.masterthesis.reference.android;

import de.wwu.md2.android.lib.MD2Application;
import de.wwu.md2.android.lib.controller.events.OnConditionEvent;
import de.wwu.masterthesis.reference.android.contentprovider.*;

public class ContactManagerApplication extends MD2Application {
	
	@Override
	protected void bootStrap() {
		
		// Register all actions
		registerAction(new de.wwu.masterthesis.reference.android.actions.AutoGenerationAction(this));
		registerAction(new de.wwu.masterthesis.reference.android.actions.StartUpAction(this));
		registerAction(new de.wwu.masterthesis.reference.android.actions.RetrieveGPSPositionAction(this));
		
		// Register all content providers
		registerContentProvider(new ContactContentProvider(this));
		registerContentProvider(new GroupContentProvider(this));
		
		// Initialize all on condition events
		
		// Initialize all workflows
		
		// Set initial workflow (if specified)
		
		// Execute default actions
		executeAction(de.wwu.masterthesis.reference.android.actions.AutoGenerationAction.class);
		executeAction(de.wwu.masterthesis.reference.android.actions.StartUpAction.class);
	}
	
}
