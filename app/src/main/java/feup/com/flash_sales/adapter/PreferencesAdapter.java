package feup.com.flash_sales.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import feup.com.flash_sales.R;
import feup.com.flash_sales.StoreActivity;
import feup.com.flash_sales.model.Preferences;
import feup.com.flash_sales.model.Promotion;

/**
 * Created by jhonny on 05-01-2018.
 */

public class PreferencesAdapter extends RecyclerView.Adapter<PreferencesAdapter.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.checkBox)
        CheckBox checkBox;
        public ViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
        }
    }
    private List<Preferences> preferences;
    private Context context;

    public PreferencesAdapter(Context context, List<Preferences> promotions) {
        this.preferences = promotions;
        this.context = context;
    }

    @Override
    public PreferencesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_preferences, parent, false);
        return new PreferencesAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Preferences preference = preferences.get(position);
        if(preference != null) {
            holder.checkBox.setText(preference.getName());
        }
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return preferences.size();
    }
}