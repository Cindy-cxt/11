package mobileshop.edu.huatec.com.mobileshop.common;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import org.jetbrains.annotations.Nullable;

import butterknife.ButterKnife;

public abstract class BaseFragment extends Fragment {
    @Override
    @Nullable
    public View onCreateView(LayoutInflater inflater,ViewGroup container, @Nullable Bundle savedInstabceState) {
        View view = inflater.inflate(getContentViewId(), container, false);
        ButterKnife.bind(this,view);
        initView(view);
        initData();
        return view;
    }

    protected void initData() {
    }

    protected void initView(View view) {

    }

    public abstract int getContentViewId();

    public void toastlong(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_LONG).show();
    }
    public void toastshort(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
    }

}



