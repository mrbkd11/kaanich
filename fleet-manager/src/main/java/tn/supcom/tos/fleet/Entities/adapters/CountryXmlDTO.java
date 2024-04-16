package tn.supcom.tos.fleet.Entities.adapters;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "country")
public final class CountryXmlDTO {

    private Short code;
    private String iso2;
    private String iso3;
    private String name;
    private String capital;

    private String currencyCode;

    private String currencySymbol;

    private String flagEmoji;

    @XmlAttribute
    public Short getCode() {
        return code;
    }

    public void setCode(Short code) {
        this.code = code;
    }

    @XmlAttribute
    public String getIso2() {
        return iso2;
    }

    public void setIso2(String iso2) {
        this.iso2 = iso2;
    }
    @XmlAttribute
    public String getIso3() {
        return iso3;
    }

    public void setIso3(String iso3) {
        this.iso3 = iso3;
    }
    @XmlElement
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement
    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    @XmlAttribute(name = "currency-code")
    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    @XmlAttribute(name = "currency-symbol")
    public String getCurrencySymbol() {
        return currencySymbol;
    }

    public void setCurrencySymbol(String currencySymbol) {
        this.currencySymbol = currencySymbol;
    }

    @XmlAttribute(name = "flag-emogi")
    public String getFlagEmoji() {
        return flagEmoji;
    }

    public void setFlagEmoji(String flagEmoji) {
        this.flagEmoji = flagEmoji;
    }
}