package com.iiit.iiitkalyani;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import java.util.List;
import de.hdodenhof.circleimageview.CircleImageView;


public class BlogAdapter extends RecyclerView.Adapter<BlogAdapter.ImageViewHolder> {
    private Context mContext;
    private List<Download> mdownloads;

    public BlogAdapter(Context context, List<Download> Download) {
        mContext = context;
        mdownloads = Download;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.blog_item, parent, false);
        return new ImageViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ImageViewHolder holder, int position) {
        Download uploadCurrent = mdownloads.get(position);
        Picasso.get().load(uploadCurrent.getprofileimg()).placeholder(R.drawable.logo).into(holder.profile_image);
        holder.profile_name.setText(uploadCurrent.getName());
        holder.title.setText(uploadCurrent.gettitle());
        holder.des.setText(uploadCurrent.getdescription());
        Picasso.get().load(uploadCurrent.getImageUrl()).placeholder(R.drawable.logo).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return mdownloads.size();
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public TextView des;
        public TextView profile_name;
        public ImageView imageView;
        public CircleImageView profile_image;
        public ImageViewHolder(View itemView) {
            super(itemView);
            profile_image = itemView.findViewById(R.id.profile_image);
            profile_name = itemView.findViewById(R.id.profile_name);
            des = itemView.findViewById(R.id.post_descreption);
            title = itemView.findViewById(R.id.post_title);
            imageView = itemView.findViewById(R.id.post_image);
        }
    }
}