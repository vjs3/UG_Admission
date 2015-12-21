package com.vishwajeets3.loginregistration.navigationliveo;

import android.content.Context;
import android.util.SparseIntArray;

import com.vishwajeets3.loginregistration.R;
import com.vishwajeets3.loginregistration.adapter.NavigationItemAdapter;
import com.vishwajeets3.loginregistration.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class NavigationList {

	public static List<NavigationItemAdapter> getNavigationAdapter(
			Context context, List<Integer> listItensHeader, SparseIntArray sparce, List<Integer> listItensHide) {

		List<NavigationItemAdapter> mList = new ArrayList<NavigationItemAdapter>();
		String[] mMenuItems = context.getResources().getStringArray(R.array.nav_menu_items);

		int count = -1;
		boolean isheader = false;
		boolean isVisible = false;

		for (int i = 0; i < mMenuItems.length; i++) {

			String title = mMenuItems[i];
			NavigationItemAdapter itemNavigation;


			if (sparce != null) {
				count = sparce.get(i, -1);
			}

			if (listItensHeader != null) {
				isheader = listItensHeader.contains(i);
			}

			if (listItensHide != null) {
				isVisible = listItensHide.contains(i);
			}

			itemNavigation = new NavigationItemAdapter(title, Utils.iconNavigation[i], isheader, count, !isVisible);
			mList.add(itemNavigation);
		}

		return mList;
	}
}
