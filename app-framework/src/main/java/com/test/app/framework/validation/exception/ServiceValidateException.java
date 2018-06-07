package com.test.app.framework.validation.exception;

import com.test.app.framework.exception.ServiceException;
import com.test.app.framework.metadata.model.Response;
import com.test.app.framework.utils.ResponseBeanUtils;
import com.test.app.framework.validation.model.ValidateFieldMessage;

import java.util.List;

public class ServiceValidateException extends ServiceException {
    private List<ValidateFieldMessage> body;

    public void body(List<ValidateFieldMessage> body) {
        this.body = body;
    }

    public List<ValidateFieldMessage> getBody() {
        return body;
    }

    public Response toResponse() {
        return ResponseBeanUtils.build(this);
    }

}
