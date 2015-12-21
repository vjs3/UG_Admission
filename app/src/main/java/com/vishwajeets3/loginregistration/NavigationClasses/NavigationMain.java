
package com.vishwajeets3.loginregistration.NavigationClasses;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.util.SparseIntArray;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.vishwajeets3.loginregistration.R;
import com.vishwajeets3.loginregistration.adapter.NavigationAdapter;
import com.vishwajeets3.loginregistration.fragments.CounsellingStatusFragment;
import com.vishwajeets3.loginregistration.fragments.StudentInfoFragment;
import com.vishwajeets3.loginregistration.fragments.FeeStatusFragment;
import com.vishwajeets3.loginregistration.utils.Constant;
import com.vishwajeets3.loginregistration.utils.Menus;
import com.vishwajeets3.loginregistration.utils.Utils;

import java.util.ArrayList;
import java.util.List;


public class NavigationMain extends ActionBarActivity{

	private int mLastPosition = 1;
	private ListView mListDrawer;

	private DrawerLayout mLayoutDrawer;
	private RelativeLayout mUserDrawer;
	private RelativeLayout mRelativeDrawer;

	private FragmentManager mFragmentManager;
	private NavigationAdapter mNavigationAdapter;
	private ActionBarDrawerToggleCompat mDrawerToggle;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getSupportActionBar().setIcon(R.drawable.ic_launcher);

		setContentView(R.layout.navigation_main);

		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);

		mListDrawer = (ListView) findViewById(R.id.listDrawer);
		mRelativeDrawer = (RelativeLayout) findViewById(R.id.relativeDrawer);
		mLayoutDrawer = (DrawerLayout) findViewById(R.id.layoutDrawer);

		mUserDrawer = (RelativeLayout) findViewById(R.id.userDrawer);
		mUserDrawer.setOnClickListener(userOnClick);

		if (mListDrawer != null) {

			// All header menus should be informed here
			// listHeader.add(MENU POSITION)
			List<Integer> mListHeader = new ArrayList<Integer>();
			mListHeader.add(0);
			mListHeader.add(6);
			mListHeader.add(10);

			// All menus which will contain an accountant should be informed here
			// Counter.put ("POSITION MENU", "VALUE COUNTER");
			SparseIntArray  mCounter = new SparseIntArray();
			//mCounter.put(Constant.MENU_DOWNLOADS,7);
			mCounter.put(Constant.MENU_MAPS,10);
			mNavigationAdapter = new NavigationAdapter(this, NavigationList.getNavigationAdapter(this, mListHeader, mCounter, null));
		}

		mListDrawer.setAdapter(mNavigationAdapter);
		mListDrawer.setOnItemClickListener(new DrawerItemClickListener());

		mDrawerToggle = new ActionBarDrawerToggleCompat(this, mLayoutDrawer);
		mLayoutDrawer.setDrawerListener(mDrawerToggle);

		if (savedInstanceState != null) {
			setLastPosition(savedInstanceState.getInt(Constant.LAST_POSITION));

			setTitleFragments(mLastPosition);
			mNavigationAdapter.resetarCheck();
			mNavigationAdapter.setChecked(mLastPosition, true);
		}else{
			setLastPosition(mLastPosition);
			setFragmentList(mLastPosition);
		}
	}

	private void setFragmentList(int posicao){

		Fragment mFragment = null;
		mFragmentManager = getSupportFragmentManager();

		switch (posicao) {
			/*case Constant.MENU_DOWNLOADS:
				mFragment = new DownloadFragment().newInstance(Utils.getTitleItem(NavigationMain.this, Constant.MENU_DOWNLOADS));
				break;*/
			/*case Constant.MENU_ROUTER:
				//Toast.makeText(NavigationMain.this,"Id is "+posicao,Toast.LENGTH_SHORT).show();
				mFragment = new RouteFragment().newInstance(Utils.getTitleItem(NavigationMain.this, Constant.MENU_ROUTER));
				break;*/
			case Constant.MENU_COUNSELLING_STATUS:
				//Toast.makeText(NavigationMain.this,"Id is "+posicao,Toast.LENGTH_SHORT).show();
				mFragment = new CounsellingStatusFragment().newInstance(Utils.getTitleItem(NavigationMain.this, Constant.MENU_COUNSELLING_STATUS));
				break;
			case Constant.MENU_STUDENT_INFO:
				//Toast.makeText(NavigationMain.this,"Id is "+posicao,Toast.LENGTH_SHORT).show();
				mFragment = new StudentInfoFragment().newInstance(Utils.getTitleItem(NavigationMain.this, Constant.MENU_STUDENT_INFO));
				break;
			case Constant.MENU_FEE_STATUS:
				//Toast.makeText(NavigationMain.this,"Id is "+posicao,Toast.LENGTH_SHORT).show();
				mFragment = new FeeStatusFragment().newInstance(Utils.getTitleItem(NavigationMain.this, Constant.MENU_FEE_STATUS));
				break;
			case Constant.MENU_CALL_SUPPORT:
				String number="7742173669";
				Intent callIntent = new Intent(Intent.ACTION_CALL);
				callIntent.setData(Uri.parse("tel:" + number));
				try{
					startActivity(callIntent);
				}catch(SecurityException e){
					e.printStackTrace();
				}
				break;
			case Constant.SENDFEEDBACK_TEXT_FRAGMENT:
				break;
		}

		if (mFragment != null){
			setTitleFragments(mLastPosition);
			mNavigationAdapter.resetarCheck();
			mNavigationAdapter.setChecked(posicao, true);
			mFragmentManager.beginTransaction().replace(R.id.content_frame, mFragment).commit();
		}
	}

	/*private void hideMenus(Menu menu, int posicao) {

		boolean drawerOpen = mLayoutDrawer.isDrawerOpen(mRelativeDrawer);

		switch (posicao) {
			*//*case Constant.MENU_DOWNLOADS:
				menu.findItem(Menus.ADD).setVisible(!drawerOpen);
				menu.findItem(Menus.UPDATE).setVisible(!drawerOpen);
				menu.findItem(Menus.SEARCH).setVisible(!drawerOpen);
				break;*//*

			case Constant.MENU_COUNSELLING_STATUS:
				menu.findItem(Menus.ADD).setVisible(!drawerOpen);
				menu.findItem(Menus.UPDATE).setVisible(!drawerOpen);
				menu.findItem(Menus.SEARCH).setVisible(!drawerOpen);
				break;

			case Constant.MENU_STUDENT_INFO:
				menu.findItem(Menus.ADD).setVisible(!drawerOpen);
				menu.findItem(Menus.UPDATE).setVisible(!drawerOpen);
				menu.findItem(Menus.SEARCH).setVisible(!drawerOpen);
				break;

			case Constant.MENU_FEE_STATUS:
				menu.findItem(Menus.ADD).setVisible(!drawerOpen);
				menu.findItem(Menus.UPDATE).setVisible(!drawerOpen);
				menu.findItem(Menus.SEARCH).setVisible(!drawerOpen);
				break;

			*//*case Constant.MENU_ROUTER:
				menu.findItem(Menus.ADD).setVisible(!drawerOpen);
				menu.findItem(Menus.SEARCH).setVisible(!drawerOpen);
				break;
			*//*
		}
	}*/

	private void setTitleFragments(int position){
		setIconActionBar(Utils.iconNavigation[position]);
		setSubtitleActionBar(Utils.getTitleItem(NavigationMain.this, position));
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
		outState.putInt(Constant.LAST_POSITION, mLastPosition);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		switch (item.getItemId()) {
			case Menus.HOME:
				if (mLayoutDrawer.isDrawerOpen(mRelativeDrawer)) {
					mLayoutDrawer.closeDrawer(mRelativeDrawer);
				} else {
					mLayoutDrawer.openDrawer(mRelativeDrawer);
				}
				return true;
			default:

				if (mDrawerToggle.onOptionsItemSelected(item)) {
					return true;
				}

				return super.onOptionsItemSelected(item);
		}
	}

	/*public boolean isOptionsMenu(Menu menu) {
		hideMenus(menu, mLastPosition);
		return super.onPrepareOptionsMenu(menu);
	}*/

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		mDrawerToggle.syncState();
	}

	public void setTitleActionBar(CharSequence informacao) {
		getSupportActionBar().setTitle(informacao);
	}

	public void setSubtitleActionBar(CharSequence informacao) {
		getSupportActionBar().setSubtitle(informacao);
	}

	public void setIconActionBar(int icon) {
		getSupportActionBar().setIcon(icon);
	}

	public void setLastPosition(int posicao){
		this.mLastPosition = posicao;
	}

	private class ActionBarDrawerToggleCompat extends ActionBarDrawerToggle {

		public ActionBarDrawerToggleCompat(Activity mActivity, DrawerLayout mDrawerLayout){
			super(
					mActivity,
					mDrawerLayout,
					R.drawable.ic_action_navigation_drawer,
					R.string.drawer_open,
					R.string.drawer_close);
		}

		@Override
		public void onDrawerClosed(View view) {
			supportInvalidateOptionsMenu();
		}

		@Override
		public void onDrawerOpened(View drawerView) {
			mNavigationAdapter.notifyDataSetChanged();
			supportInvalidateOptionsMenu();
		}
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		// TODO Auto-generated method stub
		super.onConfigurationChanged(newConfig);
		mDrawerToggle.onConfigurationChanged(newConfig);
	}

	private class DrawerItemClickListener implements ListView.OnItemClickListener {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int posicao, long id) {
			setLastPosition(posicao);
			setFragmentList(mLastPosition);
			//Toast.makeText(NavigationMain.this,"This is "+id, Toast.LENGTH_SHORT).show();
			mLayoutDrawer.closeDrawer(mRelativeDrawer);
		}
	}

	private OnClickListener userOnClick = new OnClickListener() {
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			mLayoutDrawer.closeDrawer(mRelativeDrawer);
			mLayoutDrawer.openDrawer(mRelativeDrawer);
		}
	};
}
