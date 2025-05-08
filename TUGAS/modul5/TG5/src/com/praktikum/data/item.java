package com.praktikum.data;

public class item {
    private String itemNama;
    private String location;
    private String status;

    public item(String itemNama, String location, String status){
        this.itemNama=itemNama;
        this.location=location;
        this.status=status;
    }
    public String getItemNama(){
        return itemNama;
    }
    public String getLocation(){
        return location;
    }
    public String getStatus(){
        return status;
    }

    public void setItemNama(String itemNama){
        this.itemNama=itemNama;
    }
    public void setLocation(String location){
        this.location=location;
    }
    public void setStatus(String status){
        this.status=status;
    }
}
