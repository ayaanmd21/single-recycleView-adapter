package faizzy.singlerecycleradapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Faizan on 7/3/18.
 */

public abstract class SingleRecyclerAdapter<T> extends RecyclerView.Adapter<MyViewHolder> {
    private Context mContext;
    private List<T> mDataList;
    private int mLayoutId;
    private OnItemClickListener<T> mOnItemClickListener;
    private OnItemLongClickListener<T> mOnItemLongClickListener;
    public SingleRecyclerAdapter(Context mContext, List<T> mDataList, int mLayoutId) {
        this.mContext = mContext;
        this.mDataList = mDataList;
        this.mLayoutId = mLayoutId;
    }

    public void setOnItemClickListener(OnItemClickListener<T> onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener<T> onItemLongClickListener) {
        mOnItemLongClickListener = onItemLongClickListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(mLayoutId, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder,  int position) {
        final int finalPosition=position;
        if (mOnItemClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemClickListener.onItemClick(v, finalPosition,mDataList.get(finalPosition));
                }
            });
        }
        if (mOnItemLongClickListener != null) {
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    return mOnItemLongClickListener.onItemLongClick(v, finalPosition,mDataList.get(finalPosition));
                }
            });
        }
        onPostBindViewHolder(holder, mDataList.get(position));
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    public abstract void onPostBindViewHolder(MyViewHolder holder, T t);

    public interface OnItemClickListener<T> {
        void onItemClick(View view, int position, T t);
    }

    public interface OnItemLongClickListener<T> {
        boolean onItemLongClick(View view, int position, T t);
    }
}
