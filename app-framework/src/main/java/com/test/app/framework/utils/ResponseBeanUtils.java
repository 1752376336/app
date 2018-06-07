package com.test.app.framework.utils;

import com.test.app.framework.exception.ServiceException;
import com.test.app.framework.metadata.consts.ResultCode;
import com.test.app.framework.metadata.model.Response;
import com.test.app.framework.validation.exception.ServiceValidateException;

public class ResponseBeanUtils {

    public static Response ok() {
        return ok(null);
    }

    public static Response ok(Object body) {
        Response response = build(ResultCode.Default.SUCCESS);
        response.setBody(body);
        return response;
    }

    public static Response build(ServiceException e) {
        return build(e.getCode(), e.getValues());
    }

    public static Response build(ServiceValidateException e) {
        return build(e.getCode(), e.getBody(), e.getValues());
    }

    public static Response build(String buildCode) {
        return build(buildCode, null, null);
    }

    public static Response build(String buildCode, Object body, String... values) {
        String tip = ContextUtils.getMessage(buildCode, values);
        String[] tips = tip.split("\\|");
        String code = tips[1];
        String message = tips[0];
        if (code.equalsIgnoreCase("010101")) {
            message += " - " + buildCode;
        }
        Response res = new Response();
        res.setCode(code);
        res.setMessage(message);
        res.setBody(body);
        return res;
    }


}
