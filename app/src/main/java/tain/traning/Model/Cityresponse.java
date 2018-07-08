package tain.traning.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by HP on 08/07/2018.
 */

public class Cityresponse {
    @SerializedName("success")
    @Expose
    private String success;
    @SerializedName("cities")
    @Expose
    private List<City> cities = null;

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }


}
