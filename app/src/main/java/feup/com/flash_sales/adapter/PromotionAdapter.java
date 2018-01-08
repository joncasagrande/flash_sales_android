package feup.com.flash_sales.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import feup.com.flash_sales.R;
import feup.com.flash_sales.StoreActivity;
import feup.com.flash_sales.model.Promotion;

/**
 * Created by jhonny on 05-01-2018.
 */

public class PromotionAdapter extends RecyclerView.Adapter<PromotionAdapter.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.profile_name)
        TextView storeName;
        @BindView(R.id.descriptionTV)
        TextView description;
        @BindView(R.id.full_image)
        ImageView imageView;
        @BindView(R.id.distanceTV)
        TextView distance;
        @BindView(R.id.PromotionRowLL)
        LinearLayout promotionRow;
        public ViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
        }
    }
    private List<Promotion> promotions;
    private Context context;

    public PromotionAdapter(Context context, List<Promotion> promotions) {
        this.promotions = promotions;
        this.context = context;
    }

    @Override
    public PromotionAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_promotion, parent, false);
        return new PromotionAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Promotion promotion = promotions.get(position);
        if(promotion != null) {
            holder.storeName.setText(promotion.getName());
            holder.description.setText(promotion.getDescription());
            if(promotion.getImage() > 0) {

                Picasso.with(context)
                        .load(promotion.getImage())
                        //.fit()
                        .resize(200, 200)
                        .into(holder.imageView);
            }
            holder.promotionRow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, StoreActivity.class);
                    intent.putExtra(context.getString(R.string.store), promotion.getStoreId());
                    context.startActivity(intent);
                }
            });
        }
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return promotions.size();
    }
}