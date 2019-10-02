package com.playground.uml;

import java.util.Date;

class IdCard {

    private Date dateExpire;

    IdCard(Date dateExpire) {
        this.dateExpire = dateExpire;
    }

    Date getDateExpire() {
        return dateExpire;
    }
}