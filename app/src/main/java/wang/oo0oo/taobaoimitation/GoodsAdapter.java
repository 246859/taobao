package wang.oo0oo.taobaoimitation;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

import wang.oo0oo.taobaoimitation.pojo.Goods;

public class GoodsAdapter extends RecyclerView.Adapter<GoodsAdapter.ViewHolder> {

    private Context mContext;
    private List<Goods> mGoodsList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        ImageView goodsImage;
        TextView goodsName;
        TextView goodsPrice;
        TextView goodsMonthlySales;
        TextView goodsPostage;

        public ViewHolder(View view) {
            super(view);
            cardView = (CardView) view;
            goodsImage = view.findViewById(R.id.goods_image);
            goodsName = view.findViewById(R.id.goods_name);
            goodsPrice = view.findViewById(R.id.goods_price);
            goodsMonthlySales = view.findViewById(R.id.goods_monthly_sales);
            goodsPostage = view.findViewById(R.id.goods_postage);
        }
    }

    public GoodsAdapter(List<Goods> goodsList) {
        mGoodsList = goodsList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (mContext == null) {
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.goods_item, parent, false);

        // 添加点击事件
        final ViewHolder holder = new ViewHolder(view);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                int position = holder.getAdapterPosition();
//                Goods goods = mGoodsList.get(position);
//                Toast.makeText(v.getContext(), "You clicked view: " + goods.getName(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(v.getContext(), GoodsDetailsActivity.class);
                v.getContext().startActivity(intent);
            }
        });
        return holder;
    }

    @SuppressLint("DefaultLocale")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Goods goods = mGoodsList.get(position);
        holder.goodsName.setText(goods.getName());
        Glide.with(mContext).load(goods.getImageId()).into(holder.goodsImage);
        holder.goodsPrice.setText(String.format("¥ %.2f", goods.getPrice()));
        holder.goodsMonthlySales.setText(String.format("月销%d笔", goods.getMonthlySales()));
        holder.goodsPostage.setText(goods.getPostage() == 0 ? "免邮费" : String.format("邮费%d元", goods.getPostage()));
    }

    @Override
    public int getItemCount() {
        return mGoodsList.size();
    }
}
