package io.game.sciroc.utils.converter;

import io.game.sciroc.domain.MatchStat;
import io.game.sciroc.entity.Match;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

/**
 * PROJECT   : sciroc
 * PACKAGE   : io.game.sciroc.utils.converter
 * USER      : sean
 * DATE      : 19-Wed-Sep-2018
 * TIME      : 12:15
 * E-MAIL    : kudzai@bcs.org
 * CELL      : +27-64-906-8809
 */
@Component
public final class MatchToMatchStat implements Converter<Match, MatchStat> {
    /**
     * Convert the source object of type {@code S} to target type {@code T}.
     *
     * @param source the source object to convert, which must be an instance of {@code S} (never {@code null})
     * @return the converted object, which must be an instance of {@code T} (potentially {@code null})
     * @throws IllegalArgumentException if the source cannot be converted to the desired target type
     */
    @Override
    public MatchStat convert(Match source) {
        MatchStat target = new MatchStat();
        target.setRound(source.getRound());
        target.setMe(source.getMe());
        target.setPc(source.getPc());
        target.setResult(source.getResult());
        target.setTimestamp(new Timestamp(source.getTimestamp().getTime()));
        return target;
    }
}
