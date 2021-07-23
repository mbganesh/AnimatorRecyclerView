package mb.ganesh.modernrecyclerview;

import android.content.Context;
import android.content.pm.PackageManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;
    String unitNo[] ;
    String unitTitle[];

    public MyAdapter(Context context, String unitNo[], String unitTitle[]) {
        this.context = context;
        this.unitNo = unitNo;
        this.unitTitle = unitTitle;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_row , parent , false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {

        if (unitNo[position] != null){
            holder.no.setText(unitNo[position]);
            holder.title.setText(unitTitle[position]);
        }else {
            Toast.makeText(context, "Empty", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public int getItemCount() {
        return unitNo.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView no , title;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            no = itemView.findViewById(R.id.unitNoId);
            title = itemView.findViewById(R.id.unitTitleId);

        }
    }
}
