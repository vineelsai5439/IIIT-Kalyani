package com.iiit.iiitkalyani;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import java.util.List;
import de.hdodenhof.circleimageview.CircleImageView;


public class BlogAdapter extends RecyclerView.Adapter<BlogAdapter.ViewHolder> {
    private Context mContext;
    private List<Download> mdownloads;

    public BlogAdapter(Context context, List<Download> Download) {
        mContext = context;
        mdownloads = Download;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.blog_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Download uploadCurrent = mdownloads.get(position);
        Picasso.get().load(uploadCurrent.getprofileimg()).placeholder(R.drawable.profile).into(holder.profile_image);
        holder.pro_name.setText(uploadCurrent.getname());
        holder.title.setText(uploadCurrent.gettitle());
        holder.des.setText(uploadCurrent.getdescription());
        Picasso.get().load(uploadCurrent.getImageUrl()).placeholder(R.drawable.logo).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return mdownloads.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public TextView des;
        public TextView pro_name;
        public ImageView imageView;
        public CircleImageView profile_image;
        public ViewHolder(View itemView) {
            super(itemView);
            profile_image = itemView.findViewById(R.id.profile_image);
            pro_name = itemView.findViewById(R.id.profile_name);
            des = itemView.findViewById(R.id.post_description);
            title = itemView.findViewById(R.id.post_title);
            imageView = itemView.findViewById(R.id.post_image);
        }
    }
}