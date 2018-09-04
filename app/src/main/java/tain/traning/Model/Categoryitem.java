package tain.traning.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by HP on 28/07/2018.
 */

public class Categoryitem {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("arabicName")
    @Expose
    private String arabicName;
    @SerializedName("englishName")
    @Expose
    private String englishName;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("categoryId")
    @Expose
    private Integer categoryId;
    @SerializedName("price")
    @Expose
    private Integer price;
    @SerializedName("imageUrl")
    @Expose
    private String imageUrl;
    @SerializedName("orderPrepareTime")
    @Expose
    private Integer orderPrepareTime;
    @SerializedName("modificationsCount")
    @Expose
    private Integer modificationsCount;
    @SerializedName("parentId")
    @Expose
    private Integer parentId;
    @SerializedName("itemTypeId")
    @Expose
    private Integer itemTypeId;

    private int Count;

    public int getCount() {
        return Count;
    }

    public void setCount(int count) {
        Count = count;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getArabicName() {
        return arabicName;
    }

    public void setArabicName(String arabicName) {
        this.arabicName = arabicName;
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getOrderPrepareTime() {
        return orderPrepareTime;
    }

    public void setOrderPrepareTime(Integer orderPrepareTime) {
        this.orderPrepareTime = orderPrepareTime;
    }

    public Integer getModificationsCount() {
        return modificationsCount;
    }

    public void setModificationsCount(Integer modificationsCount) {
        this.modificationsCount = modificationsCount;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getItemTypeId() {
        return itemTypeId;
    }

    public void setItemTypeId(Integer itemTypeId) {
        this.itemTypeId = itemTypeId;
    }
}