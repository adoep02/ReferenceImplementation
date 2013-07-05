package de.wwu.masterthesis.reference.android.contentprovider;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import org.codehaus.jackson.Version;
import org.codehaus.jackson.map.module.SimpleModule;
import org.codehaus.jackson.type.TypeReference;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.widget.TextView;

import de.wwu.md2.android.lib.MD2Application;
import de.wwu.md2.android.lib.controller.actions.CodeFragment;
import de.wwu.md2.android.lib.controller.actions.CustomAction;
import de.wwu.md2.android.lib.controller.contentprovider.MD2DateSerializer;
import de.wwu.md2.android.lib.controller.contentprovider.MD2EnumDeserializer;
import de.wwu.md2.android.lib.controller.contentprovider.MD2EnumSerializer;
import de.wwu.masterthesis.reference.android.R;
import de.wwu.masterthesis.reference.android.libextension.contentprovider.LocalContentProviderMany;
import de.wwu.masterthesis.reference.android.models.Contact;

@SuppressWarnings("all")
public class ContactContentProvider extends LocalContentProviderMany<Contact> {

	public ContactContentProvider(MD2Application app) {
		super(app, new TypeReference<Contact.Array>() {}, Contact.class, true,
		"contactContentProvider.json"
		);
		
		SimpleModule module = new SimpleModule("MyModule", new Version(1, 0, 0, null));
		module.addSerializer(Date.class, new MD2DateSerializer());
		om.registerModule(module);
		
		final ContactContentProvider cp = this;
		new CustomAction(app) {
			
			@Override
			protected void initializeCodeFragments() {
				addCodeFragment(new CodeFragment() {
					
					@Override
					public String getActivityName() {
						return "MainViewActivity";
					}
					
					@Override
					public void execute(MD2Application app) {
						cp.open();
					}
				});
			}
		}.execute();
	}
	
	//ArrayList<Contact> contacts = new ArrayList<Contact>();
	//private final String storageFilename;
	
	/*public ContactContentProvider(MD2Application app) {
		super(app, new TypeReference<Contact>() {}, Contact.class, true,
		"contactContentProvider.json"
		);
		
		storageFilename = "contactContentProvider.json";
		
		SimpleModule module = new SimpleModule("MyModule", new Version(1, 0, 0, null));
		module.addSerializer(Date.class, new MD2DateSerializer());
		om.registerModule(module);
		
		final ContactContentProvider cp = this;
		new CustomAction(app) {
			
			@Override
			protected void initializeCodeFragments() {
				addCodeFragment(new CodeFragment() {
					
					@Override
					public String getActivityName() {
						return "ContactsActivity";
					}
					
					@Override
					public void execute(MD2Application app) {
						cp.open();
					}
				});
			}
		}.execute();
	}
	
	private Activity getCtx() {
		return app.getActiveActivity();
	}
	
	@Override
	public void loadEntity() {
		entity = null;
		try {
			entity = om.readValue(getCtx().getFileStreamPath(storageFilename), jsonType);
			throwRefreshEvent();
		} catch (Exception e) {
			Log.w(getClass().getSimpleName(), "Error while loading", e);
		}
	}
	
	@Override
	public void saveEntity() {
		if(!contacts.contains(entity)){
			contacts.add((Contact) entity);
		}
		try {
			FileOutputStream fos = getCtx().openFileOutput("contactContentProvider.json", Context.MODE_PRIVATE);
			try {
				om.writeValue(fos, contacts);		
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			fos.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ArrayList<Contact> getContacts() {
		try {
			TypeReference ref = new TypeReference<ArrayList<Contact>>(){};
			contacts = om.readValue(getCtx().getFileStreamPath(storageFilename), ref);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return contacts;
	}
	
	@Override
	public void deleteEntity() {
		getCtx().deleteFile(storageFilename);
	}
	
	@SuppressWarnings("unchecked")
	public Contact getEntity() {
		if (entity == null)
			resetEntity();
		return (Contact) entity;
	}

	protected void resetEntity(boolean silent) {
		try {
			entity = entityType.newInstance();
		} catch (Exception e) {
			Log.e(getClass().getSimpleName(), "Internal error: Could not instanciate model", e);
		}
		if (!silent) throwRefreshEvent();
	}
	
	public void resetEntity() {
		resetEntity(false);
	}
	
	public void setEntity(Contact contact){
		entity = contact;
	}*/
	
}
