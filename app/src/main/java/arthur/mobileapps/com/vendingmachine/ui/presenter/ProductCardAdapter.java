package arthur.mobileapps.com.vendingmachine.ui.presenter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import arthur.mobileapps.com.vendingmachine.R;
import arthur.mobileapps.com.vendingmachine.beans.ProductBean;
import arthur.mobileapps.com.vendingmachine.ui.views.CircleImageView;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Arthur Rocha on 01/10/2015.
 * Adapter for the GridView
 * each view created is a card
 */
public class ProductCardAdapter extends ArrayAdapter<ProductBean> {
    private LayoutInflater mInflater;

    public ProductCardAdapter(Context context,List<ProductBean> products){
        super(context, R.layout.product_card,R.id.product_price,products);
        this.mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }




    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = super.getView(position, convertView, parent);

        ViewHolder holder;
        if (v == null || !(v.getTag() instanceof ViewHolder)) {
            v = mInflater.inflate(R.layout.product_card, parent, false);
            holder = new ViewHolder(v);
            v.setTag(holder);
        }else{
            holder = (ViewHolder) v.getTag();
        }



        //set the values to each view of the card

        holder.status.setBackgroundColor(getItem(position).getStatus());
        holder.productPrice.setText("$" + String.valueOf(getItem(position).getPrice()));
        holder.productStock.setText(String.valueOf(getItem(position).getStock()));
        holder.circleImage.setImageResource(getItem(position).getImage());

        return v;

    }

    //butterknife is used to simplify the view holder pattern inside of an adapter.
    static class ViewHolder {
        @Bind(R.id.product_price)
        TextView productPrice; //indicates the product price
        @Bind(R.id.product_stock)
        TextView productStock; //product stock
        @Bind(R.id.product_status_layout)
        LinearLayout status;   //status used to indicate if there is more than 5 products on stock
        @Bind(R.id.product_image)
        ImageView circleImage; //image of the product

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
