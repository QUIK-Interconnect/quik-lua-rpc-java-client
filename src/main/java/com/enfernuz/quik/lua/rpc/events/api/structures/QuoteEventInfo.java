package com.enfernuz.quik.lua.rpc.events.api.structures;

import com.google.common.base.MoreObjects;
import lombok.Builder;
import lombok.Value;
import lombok.experimental.NonFinal;

import java.util.Objects;

@Value
public class QuoteEventInfo {

    String classCode;
    String secCode;

    private transient @NonFinal int hashCode;
    private transient @NonFinal String asString;

    @Builder
    private QuoteEventInfo(final String classCode, final String secCode) {
        this.classCode = classCode;
        this.secCode = secCode;
    }

    @Override
    public boolean equals(final Object o) {

        if (o == this) {
            return true;
        } else if ( !(o instanceof QuoteEventInfo) ) {
            return false;
        } else {
            final QuoteEventInfo that = (QuoteEventInfo) o;
            return Objects.equals(classCode, that.classCode) &&
                    Objects.equals(secCode, that.secCode);
        }
    }

    @Override
    public int hashCode() {

        if (hashCode == 0) {
            hashCode = Objects.hash(classCode, secCode);
        }

        return hashCode;
    }

    @Override
    public String toString() {

        if (asString == null) {
            asString = MoreObjects.toStringHelper(this)
                    .add("class_code", classCode)
                    .add("sec_code", secCode)
                    .toString();
        }

        return asString;
    }
}
