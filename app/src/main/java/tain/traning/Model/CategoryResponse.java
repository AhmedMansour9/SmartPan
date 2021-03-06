package tain.traning.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by HP on 21/07/2018.
 */

public class CategoryResponse {
    @SerializedName("success")
    @Expose
    private String success;
    @SerializedName("Categories")
    @Expose
    private List<Category> categories = null;

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

}
