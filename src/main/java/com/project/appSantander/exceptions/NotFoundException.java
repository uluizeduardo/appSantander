package com.project.appSantander.exceptions;

import com.project.appSantander.util.MessageUtils;

public class NotFoundException extends RuntimeException {
    public NotFoundException(){
        super(MessageUtils.NO_RECORDS_FOUND);
    }
}
