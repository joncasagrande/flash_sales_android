package feup.com.flash_sales.utils;

import android.app.Dialog;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.model.LatLng;
import com.squareup.picasso.Picasso;

import java.lang.ref.WeakReference;

import feup.com.flash_sales.R;
import feup.com.flash_sales.model.Store;

/**
 * Created by jhonny on 06-01-2018.
 */

public class LocalInfoDialog extends DialogFragment
        implements View.OnClickListener {

    private static final String TAG = LocalInfoDialog.class.getSimpleName();

    private WeakReference<Store> mLocalizavel;

    public static void showDialog(@NonNull FragmentManager fragmentManager,
                                                          @NonNull Store store) {
        LocalInfoDialog dialog = new LocalInfoDialog();
        dialog.mLocalizavel = new WeakReference<>(store); // TODO send this via bundle
        dialog.show(fragmentManager, TAG);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Log.d(TAG, "onCreateDialog()");
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(initializeView());

        // Set the dialog title
        //builder.setTitle(mLocalizavel.get().getName());

        // Create the AlertDialog object and return it
        return builder.create();
    }

    @Override
    public void onClick(View v) {

    }

    private View initializeView() {
        // Get the layout inflater and inflate the dialog
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.row_store, null);

        final Store localizavel = mLocalizavel.get();

        // Get specific values from concrete classes
        String telefone = null;
        String email = null;
        String video = null;

        TextView storeName = (TextView) view.findViewById(R.id.profile_name);
        TextView description = (TextView)view.findViewById(R.id.descriptionTV);
        ImageView imageView  = (ImageView) view.findViewById(R.id.full_image);
        ImageButton imgButton = (ImageButton) view.findViewById(R.id.directionBT);
        storeName.setText(localizavel.getName());
        description.setText(localizavel.getDescription());
        if(!localizavel.getImage().isEmpty()) {
            Picasso.with(view.getContext())
                    .load(localizavel.getImage())
                    .into(imageView);
        }

        imgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LatLng local = new LatLng(localizavel.getAddress().getLatitude(),
                        localizavel.getAddress().getLongitude());
                MapUtils.openMapsNavigation(getActivity(),local);

            }
        });

        return  view;
    }


}
