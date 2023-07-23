package com.example.demo.rest.respone.messages;

import java.util.Locale;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Component;

@Component
public class MessageProperties {

	private MessageSource source;
    private MessageSourceAccessor accessor;

    @Autowired
    public void setSource(@Qualifier("messageSource") MessageSource source) {
        this.source = source;
    }

    @PostConstruct
    public void init(){
        accessor = new MessageSourceAccessor(source, Locale.ENGLISH);
    }

    //Message for selected all value from database when it successfully.
    public String selected(String resourceName){
        return accessor.getMessage("message.selected",new Object[]{resourceName},Locale.ENGLISH);
    }

    //Message for selected one record from database.
    public String selectedOne(String resourceName){
        return accessor.getMessage("message.selected-one",new Object[]{resourceName},Locale.ENGLISH);
    }

    // Message for inserted to database when it insert successfully.
    public String inserted(String resourceName){
        return accessor.getMessage("message.inserted",new Object[]{resourceName},Locale.ENGLISH);
    }

    // Message for updated data when it successfully.
    public String updated(String resourceName){
        return accessor.getMessage("message.updated",new Object[]{resourceName},Locale.ENGLISH);
    }

    //Message for deleted data in database.
    public String deleted(String resourceName){
        return accessor.getMessage("message.deleted",new Object[]{resourceName},Locale.ENGLISH);
    }

    //Message for error inserted value to database.
    public String insertError(String resourceName){
        return accessor.getMessage("message.insert-error",new Object[]{resourceName},Locale.ENGLISH);
    }

    //Message for error updated value to database.
    public String updatedError(String resourceName){
        return accessor.getMessage("message.update-error",new Object[]{resourceName},Locale.ENGLISH);
    }

    //Message for error deleted record in database.
    public String deletedError(String resourceName){
        return accessor.getMessage("message.delete-error",new Object[]{resourceName},Locale.ENGLISH);
    }

    //Message for error select record from database.
    public String selectedError(String resourceName){
        return accessor.getMessage("message.select-error",new Object[]{resourceName},Locale.ENGLISH);
    }


    // Message for data is empty
    public String dataEmpty(String resourceName){
        return accessor.getMessage("message.has-empty-value",new Object[]{resourceName},Locale.ENGLISH);
    }

    //Message for not records in database.
    public String notRecords(String resourceName){
        return accessor.getMessage("message.has-no-records",new Object[]{resourceName},Locale.ENGLISH);
    }

    //Message for not record in database.
    public String notRecord(String resourceName){
        return accessor.getMessage("message.has-no-record",new Object[]{resourceName},Locale.ENGLISH);
    }

    //Message for value is null
    public String nullValue(String resourceName){
        return accessor.getMessage("message.has-null-value",new Object[]{resourceName},Locale.ENGLISH);
    }

    //Message for login successfully
    public String LoginSuccess(String resourceName){
        return accessor.getMessage("message.login",new Object[]{resourceName},Locale.ENGLISH);
    }

    //Message for login failed
    public String LoginFail(String resourceName){
        return accessor.getMessage("message.-fail-login",new Object[]{resourceName},Locale.ENGLISH);
    }

    // Message for Data not null and Status true
    public String ViewStatus(String resourceOne,String resourceTwo){
        return accessor.getMessage("message.isStatus",new Object[]{resourceOne,resourceTwo},Locale.ENGLISH);
    }

    // Message for Data not null and Status true
    public String ViewStatusFlase(String resourceOne,String resourceTwo){
        return accessor.getMessage("message.isStatus-false",new Object[]{resourceOne,resourceTwo},Locale.ENGLISH);
    }
}
