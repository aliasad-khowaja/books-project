package com.example.filter.functions;

import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.util.Strings;
import org.reactivestreams.Publisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.factory.rewrite.RewriteFunction;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Base64;

@Component
public class ResponseBodyRewrite implements RewriteFunction<String, String> {

    Logger log = LoggerFactory.getLogger(ResponseBodyRewrite.class);

    @Override
    public Publisher<String> apply(ServerWebExchange exchange, String responseBody){

        log.info("Outgoing response for url: {}, body: {}", exchange.getRequest().getURI().getPath(), responseBody);

        if(!Strings.isBlank(responseBody) ) {
            String enCodedResponse = encodeResponse(responseBody);
            log.info("Decoded request body: {}", enCodedResponse);
            return Mono.just(enCodedResponse);
        } else {
            return Mono.just(StringUtils.EMPTY);
        }

    }

    private String encodeResponse(String requestBody) {
        return new String(Base64.getEncoder().encode(requestBody.getBytes()));
    }

}
