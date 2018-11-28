package escuelaing.com.co.bowmobileapp.data.network;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import escuelaing.com.co.bowmobileapp.R;
import escuelaing.com.co.bowmobileapp.data.entities.Party;
import escuelaing.com.co.bowmobileapp.data.ui.PartyActivity;
import escuelaing.com.co.bowmobileapp.data.ui.PartyListActivity;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private List<Party> parties;

    private OnItemClicked onClick;

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
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        Party party = parties.get(i);
        if(party.getImageFileDrawable() == 0){
            viewHolder.partyImage.setImageResource(R.drawable.party_image);
        } else{
            viewHolder.partyImage.setImageResource(party.getImageFileDrawable());
        }
        viewHolder.partyTitle.setText(party.getPartyName());
        viewHolder.partyDescription.setText(party.getDescription());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                onClick.onItemClick(i);
            }
        });
    }

    public void setOnClick(OnItemClicked onClick)
    {
        this.onClick=onClick;
    }

    @Override
    public int getItemCount() {
        return parties == null ? 0: parties.size();
    }

    public interface OnItemClicked {
        void onItemClick(int position);
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
