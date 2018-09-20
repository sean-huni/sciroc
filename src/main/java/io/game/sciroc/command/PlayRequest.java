package io.game.sciroc.command;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * PROJECT   : sciroc
 * PACKAGE   : io.game.sciroc.command
 * USER      : sean
 * DATE      : 16-Sun-Sep-2018
 * TIME      : 21:37
 * E-MAIL    : kudzai@bcs.org
 * CELL      : +27-64-906-8809
 */
@JsonDeserialize
@JsonRootName(value = "PlayRequest")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class PlayRequest {
    @JsonProperty("choice")
    private String choice;

    @JsonProperty("choice")
    public String getChoice() {
        return choice;
    }

    @JsonProperty("choice")
    public void setChoice(String choice) {
        this.choice = choice;
    }

    @JsonIgnore
    @Override
    public String toString() {
        return "PlayRequest{" +
                "choice='" + choice + '\'' +
                '}';
    }
}
