package wang.oo0oo.taobaoimitation;

import android.annotation.SuppressLint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import wang.oo0oo.taobaoimitation.pojo.Goods;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {
    private List<Goods> cartItems;
    private OnItemRemoveListener onItemRemoveListener;
    private Context context;

    public interface OnItemRemoveListener {
        void onItemRemove(int position);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView itemImage;
        public TextView itemName;
        public TextView itemPrice;
        public TextView itemQuantity;
        public Button removeButton;

        public ViewHolder(View view) {
            super(view);
            itemImage = view.findViewById(R.id.item_image);
            itemName = view.findViewById(R.id.item_name);
            itemPrice = view.findViewById(R.id.item_price);
            itemQuantity = view.findViewById(R.id.item_quantity);
            removeButton = view.findViewById(R.id.button_remove_item);
        }
    }

    public CartAdapter(Context context, List<Goods> cartItems, OnItemRemoveListener onItemRemoveListener) {
        this.context = context;
        this.cartItems = cartItems;
        this.onItemRemoveListener = onItemRemoveListener;
    }

    @Override
    public CartAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cart_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Goods cartItem = cartItems.get(position);
        if(cartItem.getImageId()==1){holder.itemImage.setImageResource(R.drawable.hot_pic6);}
        if(cartItem.getImageId()==2){holder.itemImage.setImageResource(R.drawable.hot_pic7);}
        if(cartItem.getImageId()==3){holder.itemImage.setImageResource(R.drawable.hot_pic8);}

        holder.itemName.setText(cartItem.getName()+"");
        holder.itemPrice.setText("¥" + cartItem.getPrice());
        holder.itemQuantity.setText("数量: " + cartItem.getMonthlySales());

        holder.removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int adapterPosition = holder.getAdapterPosition();
                if (adapterPosition != RecyclerView.NO_POSITION && onItemRemoveListener != null) {
                    onItemRemoveListener.onItemRemove(adapterPosition);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return cartItems.size();
    }
}
