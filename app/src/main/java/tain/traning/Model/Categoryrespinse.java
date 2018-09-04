package tain.traning.Model;

import android.content.ClipData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by HP on 28/07/2018.
 */

public class Categoryrespinse {

    @SerializedName("success")
    @Expose
    private String success;
    @SerializedName("items")
    @Expose
    private List<Categoryitem> items = null;

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public List<Categoryitem> getItems() {
        return items;
    }

    public void setItems(List<Categoryitem> items) {
        this.items = items;
    }

}