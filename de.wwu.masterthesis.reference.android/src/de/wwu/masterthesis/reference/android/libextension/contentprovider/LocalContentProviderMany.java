package de.wwu.masterthesis.reference.android.libextension.contentprovider;

import java.io.FileOutputStream;
import java.util.ArrayList;

import org.codehaus.jackson.type.TypeReference;

import android.app.Activity;
import android.content.Context;

import de.wwu.md2.android.lib.MD2Application;
import de.wwu.md2.android.lib.controller.contentprovider.LocalContentProvider;
import de.wwu.md2.android.lib.model.Entity;

public class LocalContentProviderMany<T extends Entity> extends LocalContentProvider<T> {

	private ArrayList<T> contentArray = new ArrayList<T>();
	private final String storageFilename;

	public LocalContentProviderMany(MD2Application app, TypeReference<?> typeRef, Class<T> entityType, boolean isMany,
			String storageFilename) {
		super(app, typeRef, entityType, isMany, storageFilename);
		this.storageFilename = storageFilename;
	}
	
	private Activity getCtx() {
		return app.getActiveActivity();
	}
	
	@Override
	public void saveEntity() {
		if(!contentArray.contains(entity)){
			contentArray.add((T) entity);
		}
		try {
			FileOutputStream fos = getCtx().openFileOutput(storageFilename, Context.MODE_PRIVATE);
			try {
				om.writeValue(fos, contentArray);		
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
	
	public ArrayList<T> getContentList() {
		try {
			TypeReference ref = new TypeReference<ArrayList<T>>(){};
			contentArray = om.readValue(getCtx().getFileStreamPath(storageFilename), ref);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return contentArray;
	}
	
	public void setEntity(T entity){
		this.entity = entity;
	}
	
}
