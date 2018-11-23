package escuelaing.com.co.bowmobileapp.data.network;

import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import escuelaing.com.co.bowmobileapp.R;
import escuelaing.com.co.bowmobileapp.data.entities.Party;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private List<Party> parties;

    public RecyclerAdapter(List<Party> parties){
        this.parties = parties;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_layout, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.partyImage.setImageResource(R.drawable.party_image);
        viewHolder.partyTitle.setText(parties.get(i).getPartyName());
        viewHolder.partyDescription.setText(parties.get(i).getDescription());
    }

    @Override
    public int getItemCount() {
        return parties == null ? 0: parties.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder{
        public ImageView partyImage;
        public TextView partyTitle;
        public TextView partyDescription;

        public ViewHolder(View itemView){
            super(itemView);
            partyImage = (ImageView) itemView.findViewById(R.id.item_image);
            partyTitle = (TextView) itemView.findViewById(R.id.item_title);
            partyDescription = (TextView) itemView.findViewById(R.id.item_detail);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    int position = getAdapterPosition();

                    Snackbar.make(v, "Click detected on item " + position,
                            Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();

                }
            });
        }
    }
}
