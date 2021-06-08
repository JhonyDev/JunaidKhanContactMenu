package com.example.junaidkhancontactmenu.pojo;

public class ListItemPojo {
    public int contactImage;
    public String contactName;
    public long phoneNumber;

    public ListItemPojo(int contactImage, String contactName, int phoneNumber) {
        this.contactImage = contactImage;
        this.contactName = contactName;
        this.phoneNumber = phoneNumber;
    }
}
