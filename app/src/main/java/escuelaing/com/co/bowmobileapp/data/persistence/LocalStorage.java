package escuelaing.com.co.bowmobileapp.data.persistence;

import java.util.List;

import escuelaing.com.co.bowmobileapp.data.entities.Party;
import escuelaing.com.co.bowmobileapp.data.entities.User;
import escuelaing.com.co.bowmobileapp.data.network.RetrofitNetwork;

public class LocalStorage {
    private static List<Party> loadedParties;
    private static Party selectedParty;
    private static User accountUser;
    public static final RetrofitNetwork retrofitNetwork = new RetrofitNetwork();

    public static List<Party> getLoadedParties() {
        return loadedParties;
    }

    public static void setLoadedParties(List<Party> loadedParties) {
        LocalStorage.loadedParties = loadedParties;
    }
    public static User getAccountUser() {
        return accountUser;
    }

    public static void setAccountUser(User accountUser) {
        LocalStorage.accountUser = accountUser;
    }

    public static Party getSelectedParty() {
        return selectedParty;
    }

    public static void setSelectedParty(Party selectedParty) {
        LocalStorage.selectedParty = selectedParty;
    }

    public static RetrofitNetwork getRetrofitNetwork() {
        return retrofitNetwork;
    }
}
