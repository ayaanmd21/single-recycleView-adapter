package faizzy.singlerecycleradapter;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;

/**
 * Created by Faizan on 7/3/18.
 */

public class MyViewHolder extends RecyclerView.ViewHolder {
    private SparseArray<View> mViews;
    public MyViewHolder(View itemView) {
        super(itemView);
        mViews=new SparseArray<>();
    }

    public <T extends View> T getView(int viewId) {
        View view = mViews.get(viewId);

        if (view == null) {
            view = itemView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        //noinspection unchecked
        return (T) view;
    }
    public MyViewHolder setViewText(int viewId, CharSequence text) {
        ReflectHelper.invokeMethodIfExists("setText", getView(viewId), new Class[]{CharSequence.class}, text);
        return this;
    }



    public MyViewHolder setViewText(int viewId, int resId) {
        ReflectHelper.invokeMethodIfExists("setText", getView(viewId), new Class[]{int.class}, resId);
        return this;
    }

    public MyViewHolder setViewTextColor(int viewId, int color) {
        ReflectHelper.invokeMethodIfExists("setTextColor", getView(viewId), new Class[]{int.class}, color);
        return this;
    }

    public MyViewHolder setViewTextSize(int viewId, float size) {
        ReflectHelper.invokeMethodIfExists("setTextSize", getView(viewId), new Class[]{float.class}, size);
        return this;
    }

    public MyViewHolder setViewTextSize(int viewId, int unit, float size) {
        ReflectHelper.invokeMethodIfExists("setTextSize", getView(viewId), new Class[]{int.class, float.class}, unit, size);
        return this;
    }

    public MyViewHolder setViewImageResource(int viewId, int resId) {
        ReflectHelper.invokeMethodIfExists("setImageResource", getView(viewId), new Class[]{int.class}, resId);
        return this;
    }

    public MyViewHolder setViewImageBitmap(int viewId, Bitmap bitmap) {
        ReflectHelper.invokeMethodIfExists("setImageBitmap", getView(viewId), new Class[]{Bitmap.class}, bitmap);
        return this;
    }

    public MyViewHolder setViewImageDrawable(int viewId, Drawable drawable) {
        ReflectHelper.invokeMethodIfExists("setImageDrawable", getView(viewId), new Class[]{Drawable.class}, drawable);
        return this;
    }

    public MyViewHolder setViewImageURI(int viewId, Uri uri) {
        ReflectHelper.invokeMethodIfExists("setImageURI", getView(viewId), new Class[]{Uri.class}, uri);
        return this;
    }

    public MyViewHolder setViewChecked(int viewId, boolean checked) {
        ReflectHelper.invokeMethodIfExists("setChecked", getView(viewId), new Class[]{boolean.class}, checked);
        return this;
    }

    public MyViewHolder setViewOnClickListener(int viewId, View.OnClickListener listener) {
        ReflectHelper.invokeMethodIfExists("setOnClickListener", getView(viewId), new Class[]{View.OnClickListener.class}, listener);
        return this;
    }

    public MyViewHolder setViewOnLongClickListener(int viewId, View.OnLongClickListener listener) {
        ReflectHelper.invokeMethodIfExists("setOnLongClickListener", getView(viewId), new Class[]{View.OnLongClickListener.class}, listener);
        return this;
    }

    public MyViewHolder setViewVisibility(int viewId, int visibility) {
        ReflectHelper.invokeMethodIfExists("setVisibility", getView(viewId), new Class[]{int.class}, visibility);
        return this;
    }

    public MyViewHolder setViewProperty(int viewId, String propertyName, Object... params) {
        if(propertyName==null){
            throw new  IllegalArgumentException("propertyName is null");
        }
        propertyName = Character.toUpperCase(propertyName.charAt(0)) + propertyName.substring(1);
        ReflectHelper.invokeMethodIfExists("set" + propertyName, getView(viewId), params);
        return this;
    }
}
