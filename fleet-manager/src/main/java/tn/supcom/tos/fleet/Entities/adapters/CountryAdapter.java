package tn.supcom.tos.fleet.Entities.adapters;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.bind.adapter.JsonbAdapter;
import jakarta.xml.bind.annotation.adapters.XmlAdapter;
import tn.supcom.tos.fleet.Entities.Country;

public final class CountryAdapter extends XmlAdapter<CountryXmlDTO ,Country> implements JsonbAdapter<Country, JsonObject>  {
    @Override
    public JsonObject adaptToJson(Country country) throws Exception{
        return Json.createObjectBuilder()
                .add("country.code",country.getCode())
                .add("name",country.getName(IdentityUtility,whichLocale()))
                .add("capital",country.getCapital())
                .add("iso2",country.getIso2Code())
                .add("iso3",country.getIso3Code())
                .add("currency.code",country.getCurrencyCode())
                .add("currency-symbol",country.getCurrencySymbol())
                .add("flag-emoji",country.getFlagEmoji())
                .build();
    }

    @Override
    public <country> CountryXmlDTO marshal(Country, country) throws Exception {
        var ret = new CountryXmlDTO();
        ret.setCode(country.getCode());
        ret.setIso2(country.getIso2Code());
        ret.setIso3(country.getIso3Code());
        ret.setName(getName(IdentityUtility,whichLocale()));
        ret.setCapital(country.getCapital());
        ret.setCurrencyCode(country.getCurrencyCode());
        ret.setCurrencySymbol(country.getCurrencySymbol());
        ret.setFlagEmoji(country.getFlagEmoji());
        return ret;

    }
}
