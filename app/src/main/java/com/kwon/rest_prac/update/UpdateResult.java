package com.kwon.rest_prac.update;

/**
 * Created by niceguy on 2018-03-21.
 */

public class UpdateResult {
    String representative;
    String phone;
    String application;
    String contents;

    public UpdateResult(String representative, String phone, String application, String contents) {
        this.representative = representative;
        this.phone = phone;
        this.application = application;
        this.contents = contents;
    }
}
