package model.user;

import com.fasterxml.jackson.annotation.JsonProperty;


public record Token(@JsonProperty("access_token") String accessToken) {

}
