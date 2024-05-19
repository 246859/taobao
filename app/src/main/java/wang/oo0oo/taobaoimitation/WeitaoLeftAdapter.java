package wang.oo0oo.taobaoimitation;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class WeitaoLeftAdapter extends RecyclerView.Adapter<WeitaoLeftAdapter.ViewHolder> {

    private List<String> mItemList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;

        public ViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.weitao_left_item_name);
        }
    }

    public WeitaoLeftAdapter(List<String> itemList) {
        mItemList = itemList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.weitao_left_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String name = mItemList.get(position);
        holder.name.setText(name);
    }

    @Override
    public int getItemCount() {
        return mItemList.size();
    }
}
