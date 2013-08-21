package de.wwu.masterthesis.reference.android.contentprovider;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Date;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.Version;
import org.codehaus.jackson.map.module.SimpleModule;
import org.codehaus.jackson.type.TypeReference;

import android.app.Activity;
import android.content.Context;
import android.widget.TextView;

import de.wwu.md2.android.lib.MD2Application;
import de.wwu.md2.android.lib.controller.actions.CodeFragment;
import de.wwu.md2.android.lib.controller.actions.CustomAction;
import de.wwu.md2.android.lib.controller.contentprovider.LocalContentProvider;
import de.wwu.md2.android.lib.controller.contentprovider.MD2DateSerializer;
import de.wwu.md2.android.lib.controller.contentprovider.MD2EnumDeserializer;
import de.wwu.md2.android.lib.controller.contentprovider.MD2EnumSerializer;
import de.wwu.masterthesis.reference.android.R;
import de.wwu.masterthesis.reference.android.libextension.contentprovider.LocalContentProviderMany;
import de.wwu.masterthesis.reference.android.models.Contact;
import de.wwu.masterthesis.reference.android.models.Group;

@SuppressWarnings("all")
public class GroupContentProvider extends LocalContentProviderMany<Group> {
	
	public GroupContentProvider(MD2Application app) {
		super(app, new TypeReference<Group.Array>() {}, Group.class, true,
				"groupContentProvider.json"
				);
				
				SimpleModule module = new SimpleModule("MyModule", new Version(1, 0, 0, null));
				module.addSerializer(Date.class, new MD2DateSerializer());
				om.registerModule(module);
				
				final GroupContentProvider cp = this;
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

	/*
	private Activity getCtx() {
		return app.getActiveActivity();
	}
	
	@Override
	public void saveEntity() {
		if(!groups.contains(entity)){
			groups.add((Group) entity);
		}
		try {
			FileOutputStream fos = app.getActiveActivity().openFileOutput("groupContentProvider.json", Context.MODE_WORLD_READABLE);
			try {
				om.writeValue(fos, groups);		
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
	
	public ArrayList<Group> getGroups() {
		try {
			TypeReference ref = new TypeReference<ArrayList<Group>>(){};
			groups = om.readValue(getCtx().getFileStreamPath(storageFilename), ref);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return groups;
	}*/
	
}
