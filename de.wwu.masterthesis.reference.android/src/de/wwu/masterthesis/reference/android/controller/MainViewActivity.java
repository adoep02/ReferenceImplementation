package de.wwu.masterthesis.reference.android.controller;

import java.util.ArrayList;
import java.util.List;

import android.app.ActionBar;
import android.app.Activity;
import android.view.Menu;
import de.wwu.md2.android.lib.ChangeTabListener;
import de.wwu.md2.android.lib.MD2Application;
import de.wwu.md2.android.lib.view.TabbedActivity;
import de.wwu.masterthesis.reference.android.R;

public class MainViewActivity extends Activity implements TabbedActivity {
	
	private boolean isInitialized = false;
	private List<String> tabList;
	private int currentTab;
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		if (!isInitialized) {
			// Check whether app object has to be reinitialized
			getApp().checkForReinitialization("MainView");
			getApp().setActiveActivity("MainView", this);
			initializeTabList();
			createActionBar(getActionBar());
			isInitialized = true;
		}
		return false;
	}
	
	private void initializeTabList() {
		tabList = new ArrayList<String>();
		tabList.add("contactsTab");
		tabList.add("detailTab");
		tabList.add("groupTab");
	}
	
	@Override
	public void setSelectedTab(String tabName) {
		setSelectedTab(tabList.indexOf(tabName));
	}
	
	private void setSelectedTab(int index) {
		getActionBar().setSelectedNavigationItem(index);
	}
	
	@Override
	public void tabChanged() {
		currentTab = getActionBar().getSelectedNavigationIndex();
	}

	@Override
	public void cancelTabChange() {
		setSelectedTab(currentTab);
	}
	
	private void createActionBar(ActionBar bar) {
		bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		
		bar.addTab(bar
			.newTab()
			.setText(R.string.tabtitle_contactstab)
			.setTabListener(
				new ChangeTabListener<ContactsTabFragment>(getApp(), this, "Contacts",
					ContactsTabFragment.class, "contactsTab", this)));
		bar.addTab(bar
			.newTab()
			.setText(R.string.tabtitle_detailtab)
			.setTabListener(
				new ChangeTabListener<DetailTabFragment>(getApp(), this, "Detail View",
					DetailTabFragment.class, "detailTab", this)));
		bar.addTab(bar
			.newTab()
			.setText(R.string.tabtitle_grouptab)
			.setTabListener(
				new ChangeTabListener<GroupTabFragment>(getApp(), this, "New Group",
					GroupTabFragment.class, "groupTab", this)));
		
		if(getIntent() != null && getIntent().getStringExtra("tabToShow") != null) {
			setSelectedTab(getIntent().getStringExtra("tabToShow"));
		}
		else {
			setSelectedTab("contactsTab");
		}
	}
	
	private MD2Application getApp() {
		return (MD2Application) getApplication();
	}
}
