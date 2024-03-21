package model.user;

import com.fasterxml.jackson.annotation.JsonProperty;

public record User (
    @JsonProperty("username")
    String login,
    String password) {

}
