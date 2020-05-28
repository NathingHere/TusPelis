package com.example.tuspelis.Sesion;

import com.google.gson.annotations.SerializedName;

public class GuestSesion {
    @SerializedName("guest_session_id")
    private String guestID;

    public String getGuestID() {
        return guestID;
    }

    public void setGuestID(String guestID) {
        this.guestID = guestID;
    }
}
