package com.property.common.exception;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import org.apache.log4j.Logger;

import com.property.common.response.BaseResponse;
import com.property.common.response.ValidationResponse;

/**
 * Runtime exception handler
 * 
 * @author vinayaksm
 *
 */
public class RuntimeExceptionHandler implements ExceptionMapper<RuntimeException> {

    private static final Logger logger = Logger.getLogger(RuntimeExceptionHandler.class);

    @Context
    private HttpServletRequest httpRequest;

    private String content_type;


    @Override
    public Response toResponse(final RuntimeException exception) {
        BaseResponse response = null;
        logger.info("Handling runtime exception occured: " + exception);

        if (exception instanceof ValidationException) {
            response = new ValidationResponse();
            ((ValidationResponse) response).addFieldMsg(
                ((ValidationException) exception).getFieldName(),
                ((ValidationException) exception).getMessage() + " :"
                    + ((ValidationException) exception).getFieldValue());
            response.setMessage("Invalid input");
        } else {
            response = new BaseResponse();
            response.setMessage(exception.getMessage());
        }
        response.setStatusCode(BaseResponse.FAILED_CODE);
        String type = httpRequest.getHeader("Content-Type");
        content_type = (type == null) ? "application/json" : type;
        return Response.ok(response, content_type).build();
    }
}
