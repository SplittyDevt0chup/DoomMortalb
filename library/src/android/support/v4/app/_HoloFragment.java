
package android.support.v4.app;

import org.holoeverywhere.LayoutInflater;
import org.holoeverywhere.app.Activity;
import org.holoeverywhere.app.Base;
import org.holoeverywhere.app.BaseFragment;
import org.holoeverywhere.preference.PreferenceManager;
import org.holoeverywhere.preference.SharedPreferences;

import android.os.Bundle;
import android.util.AttributeSet;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.ViewGroup;

import com.actionbarsherlock.internal.view.menu.ContextMenuBuilder;
import com.actionbarsherlock.internal.view.menu.ContextMenuDecorView;
import com.actionbarsherlock.internal.view.menu.ContextMenuItemWrapper;
import com.actionbarsherlock.internal.view.menu.ContextMenuListener;
import com.actionbarsherlock.internal.view.menu.ContextMenuWrapper;
import com.actionbarsherlock.internal.view.menu.MenuItemWrapper;
import com.actionbarsherlock.internal.view.menu.MenuWrapper;
import com.actionbarsherlock.view.ContextMenu;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;

public abstract class _HoloFragment extends Fragment implements
        BaseFragment {
    private static final int INTERNAL_DECOR_VIEW_ID = 0x7f999999;

    private Base mBase;

    private Bundle savedInstanceState;

    @Override
    public void createContextMenu(ContextMenuBuilder contextMenuBuilder,
            View view, ContextMenuInfo menuInfo, ContextMenuListener listener) {
        mBase.createContextMenu(contextMenuBuilder, view, menuInfo, listener);
    }

    @Override
    public Base getBase() {
        return mBase;
    }

    protected int getContainerId() {
        return mContainerId;
    }

    @Override
    public SharedPreferences getDefaultSharedPreferences() {
        return mBase.getDefaultSharedPreferences();
    }

    @Override
    public LayoutInflater getLayoutInflater() {
        return LayoutInflater.from(getActivity());
    }

    @Override
    public LayoutInflater getLayoutInflater(Bundle savedInstanceState) {
        return LayoutInflater.from(super.getLayoutInflater(savedInstanceState));
    }

    public MenuInflater getMenuInflater() {
        return mBase.getSupportMenuInflater();
    }

    protected Bundle getSavedInstanceState() {
        return savedInstanceState;
    }

    @Override
    public SharedPreferences getSharedPreferences(String name, int mode) {
        return PreferenceManager.wrap(getActivity(), name, mode);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T extends Activity & Base> T getSupportActivity() {
        return (T) mBase;
    }

    @Override
    public FragmentManager getSupportFragmentManager() {
        if (mBase != null) {
            return mBase.getSupportFragmentManager();
        } else {
            return getFragmentManager();
        }
    }

    public Object getSystemService(String name) {
        return getSupportActivity().getSystemService(name);
    }

    @Override
    public boolean isABSSupport() {
        return false;
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public final void onAttach(android.app.Activity activity) {
        if (!(activity instanceof Activity)) {
            throw new RuntimeException(
                    "HoloEverywhere.Fragment must be attached to HoloEverywhere.Activity");
        }
        mBase = (Activity) activity;
        onAttach((Activity) activity);
    }

    @Override
    public final boolean onContextItemSelected(android.view.MenuItem item) {
        return onContextItemSelected(new ContextMenuItemWrapper(item));
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        return mBase.onContextItemSelected(item);
    }

    @Override
    public void onContextMenuClosed(ContextMenu menu) {
        mBase.onContextMenuClosed(menu);
    }

    @Override
    public final void onCreateContextMenu(android.view.ContextMenu menu,
            View v, ContextMenuInfo menuInfo) {
        onCreateContextMenu(new ContextMenuWrapper(menu), v, menuInfo);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
            ContextMenuInfo menuInfo) {
        mBase.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public final void onCreateOptionsMenu(android.view.Menu menu, android.view.MenuInflater inflater) {
        if (isABSSupport()) {
            onCreateOptionsMenu(new MenuWrapper(menu),
                    mBase.getSupportMenuInflater());
        } else {
            super.onCreateOptionsMenu(menu, inflater);
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        mBase.onCreateOptionsMenu(menu);
    }

    @Override
    public final View onCreateView(android.view.LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        return prepareDecorView(onCreateView(
                getLayoutInflater(savedInstanceState), container,
                savedInstanceState));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onInflate(Activity activity, AttributeSet attrs,
            Bundle savedInstanceState) {
        super.onInflate(activity, attrs, savedInstanceState);
    }

    @Override
    public final void onInflate(android.app.Activity activity,
            AttributeSet attrs, Bundle savedInstanceState) {
        onInflate((Activity) activity, attrs, savedInstanceState);
    }

    @Override
    public final boolean onOptionsItemSelected(android.view.MenuItem item) {
        if (isABSSupport()) {
            return onOptionsItemSelected(new MenuItemWrapper(item));
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return mBase.onOptionsItemSelected(item);
    }

    @Override
    public final void onPrepareOptionsMenu(android.view.Menu menu) {
        if (isABSSupport()) {
            onPrepareOptionsMenu(new MenuWrapper(menu));
        } else {
            super.onPrepareOptionsMenu(menu);
        }
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        mBase.onPrepareOptionsMenu(menu);
    }

    public void onViewCreated(View view) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public final void onViewCreated(View view, Bundle savedInstanceState) {
        View v = view.findViewById(INTERNAL_DECOR_VIEW_ID);
        if (v != null && v instanceof ContextMenuDecorView) {
            view = ((ContextMenuDecorView) v).unwrap();
        }
        this.savedInstanceState = savedInstanceState;
        onViewCreated(view);
    }

    public boolean openContextMenu(View v) {
        return v.showContextMenu();
    }

    protected View prepareDecorView(View v) {
        return ContextMenuDecorView.prepareDecorView(getSupportActivity(), v, this,
                INTERNAL_DECOR_VIEW_ID);
    }
}
