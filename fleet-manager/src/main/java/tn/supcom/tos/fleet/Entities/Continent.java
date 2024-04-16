package tn.supcom.tos.fleet.Entities;

import java.util.*;

import static tn.supcom.tos.fleet.Entities.Country.*;

public enum Continent {
    AFRICA(Set.of(AGO, BDI, BEN, BFA, BWA, CAF, CIV, CMR, COD, COG, COM, CPV, DJI, DZA, EGY, ERI, ESH, ETH, GAB, GHA, GIN, GMB, GNB, GNQ, IOT, KEN, LBR, LBY, LSO, MAR, MDG, MLI, MOZ, MRT, MUS, MWI, MYT, NAM, NER, NGA, REU, RWA, SDN, SSD, SEN, SHN, SLE, SOM, STP, SWZ, SYC, TCD, TGO, TUN, TZA, UGA, ZAF, ZMB, ZWE)),
    ASIA(Set.of(AFG, ARE, ARM, AZE, BGD, BHR, BRN, BTN, CHN, CYP, GEO, HKG, IDN, IND, IRN, IRQ, ISR, JOR, JPN, KAZ, KGZ, KHM, KOR, KWT, LAO, LBN, LKA, MAC, MDV, MMR, MNG, MYS, NPL, OMN, PAK, PHL, PRK, PSE, QAT, SAU, SGP, SYR, THA, TJK, TKM, TLS, TUR, TWN, UZB, VNM, YEM)),
    EUROPE(Set.of(ALA,ALB, AND, AUT, BEL, BGR, BIH, BLR, CHE, CZE, DEU, DNK, ESP, EST, FIN, FRA, FRO, GBR, GGY, GIB, GRC, HRV, HUN, IMN, IRL, ISL, ITA, JEY, LIE, LTU, LUX, LVA, MCO, MDA, MKD, MLT, MNE, NLD, NOR, POL, PRT, ROU, RUS, SJM, SMR, SRB, SVK, SVN, SWE, UKR, VAT)),
    NORTH_AMERICA(Set.of(ABW, AIA, ATG, BES, BHS, BLM, BLZ, BMU, BRB, CAN, CRI, CUB, CUW, CYM, DMA, DOM, GLP, GRD, GRL, GTM, HND, HTI, JAM, KNA, LCA, MAF, MEX, MSR, MTQ, NIC, PAN, PRI, SLV, SPM, SXM, TCA, TTO, USA, VCT, VGB, VIR)),
    SOUTH_AMERICA(Set.of(ARG, BOL, BRA, CHL, COL, ECU, FLK, GUF, GUY, PER, PRY, SUR, URY, VEN)),
    OCEANIA(Set.of(ASM, AUS, CCK, COK, CXR, FJI, FSM, GUM, KIR, MHL, MNP, NCL, NFK, NIU, NRU, NZL, PCN, PLW, PNG, PYF, SLB, TKL, TON, TUV, UMI, VUT, WLF, WSM)),
    ANTRACTICA(Set.of(ATA, ATF, BVT, HMD, SGS));

    private final Set<Country> countries;

    static final Map<Country,Continent> countryContinentMap = new HashMap<>();

    private static final Map<String,Set<Country>> regions = new HashMap<>();

    private static final Map<Country,String> countryRegion = new HashMap<>();

    private static final Map<String,Continent> regionContinent = new HashMap<>();

    private static final Map<Continent,Set<String>> continentRegions = new HashMap<>();
    private static final String northernAfrica = "northern-africa";
    private static final String centralAfrica = "central-africa";
    private static final String easternAfrica = "eastern-africa";
    private static final String westernAfrica = "western-africa";
    private static final String southernAfrica = "southern-africa";
    private static final String caribbean = "caribbean";
    private static final String easternEurope = "eastern-europe";
    private static final String westernEurope = "western-europe";
    private static final String southernEurope = "southern-europe";
    private static final String nordicCountries = "nordic-countries";
    private static final String britishIslands = "british-islands";

    private static final String southeastAsia = "southeast-asia";

    static {
        for (Continent continent: Continent.values()){
            continent.getCountries().forEach(c->countryContinentMap.put(c,continent));
            continentRegions.put(continent,new HashSet<>());
        }
        regions.put(northernAfrica,Set.of(DZA,EGY,ESH,LBY,MAR,SDN,TUN));
        regions.get(northernAfrica).forEach(c->countryRegion.put(c,northernAfrica));
        regionContinent.put(northernAfrica,AFRICA);
        continentRegions.get(AFRICA).add(northernAfrica);

        regions.put(centralAfrica,Set.of(AGO,CAF,CMR,COD,COG,GAB,GNQ,SSD,STP,TCD));
        regions.get(centralAfrica).forEach(c->countryRegion.put(c,centralAfrica));
        regionContinent.put(centralAfrica,AFRICA);
        continentRegions.get(AFRICA).add(centralAfrica);

        regions.put(easternAfrica,Set.of(BDI,COM,DJI,ERI,ETH,IOT,KEN,MDG,MOZ,MUS,MWI,MYT,REU,RWA,SOM,SYC,TZA,UGA,ZMB,ZWE));
        regions.get(easternAfrica).forEach(c->countryRegion.put(c,easternAfrica));
        regionContinent.put(easternAfrica,AFRICA);
        continentRegions.get(AFRICA).add(easternAfrica);

        regions.put(westernAfrica,Set.of(BEN,BFA,CIV,CPV,GHA,GIN,GMB,GNB,LBR,MLI,MRT,NER,NGA,SEN,SHN,SLE,TGO));
        regions.get(westernAfrica).forEach(c->countryRegion.put(c,westernAfrica));
        regionContinent.put(westernAfrica,AFRICA);
        continentRegions.get(AFRICA).add(westernAfrica);

        regions.put(southernAfrica,Set.of(BWA,LSO,NAM,SWZ,ZAF));
        regions.get(southernAfrica).forEach(c->countryRegion.put(c,southernAfrica));
        regionContinent.put(southernAfrica,AFRICA);
        continentRegions.get(AFRICA).add(southeastAsia);

        regions.put(caribbean,Set.of(ABW,AIA,ATG,BES,BHS,BLM,BRB,CUB,CYM,CUW,DMA,DOM,GLP,GRD,HTI,JAM,KNA,LCA,MAF,MSR,MTQ,PRI,SXM,TCA,TTO,VCT,VGB,VIR));
        regions.get(caribbean).forEach(c->countryRegion.put(c,caribbean));
        regionContinent.put(caribbean,NORTH_AMERICA);
        continentRegions.get(NORTH_AMERICA).add(caribbean);

        regions.put(easternEurope,Set.of(BGR,BLR,CZE,HUN,MDA,POL,ROU,RUS,SVK,UKR));
        regions.get(easternEurope).forEach(c->countryRegion.put(c,easternEurope));
        regionContinent.put(easternEurope,EUROPE);
        continentRegions.get(EUROPE).add(easternEurope);

        regions.put(westernEurope,Set.of(AUT,BEL,CHE,DEU,FRA,LIE,LUX,MCO,NLD));
        regions.get(westernEurope).forEach(c->countryRegion.put(c,westernEurope));
        regionContinent.put(westernEurope,EUROPE);
        continentRegions.get(EUROPE).add(westernEurope);

        regions.put(britishIslands,Set.of(JEY,GBR,IRL,GGY,IMN));
        regions.get(britishIslands).forEach(c->countryRegion.put(c,britishIslands));
        regionContinent.put(britishIslands,EUROPE);
        continentRegions.get(EUROPE).add(britishIslands);

        regions.put(southernEurope,Set.of(ALB,AND,BIH,ESP,GIB,GRC,HRV,ITA,MKD,MNE,MLT,PRT,SMR,SRB,SVN,VAT));
        regions.get(southernEurope).forEach(c->countryRegion.put(c,southernEurope));
        regionContinent.put(southernEurope,EUROPE);
        continentRegions.get(EUROPE).add(southernEurope);

        regions.put(nordicCountries,Set.of(ALA,DNK,FIN,FRO,ISL,NOR,SJM,SWE));
        regions.get(nordicCountries).forEach(c->countryRegion.put(c,nordicCountries));
        regionContinent.put(nordicCountries,EUROPE);
        continentRegions.get(EUROPE).add(nordicCountries);

        regions.put(southeastAsia,Set.of(BRN,IDN,KHM,LAO,MMR,MYS,PHL,SGP,THA,TLS,VNM));
        regions.get(southeastAsia).forEach(c->countryRegion.put(c,southeastAsia));
        regionContinent.put(southeastAsia,ASIA);
        continentRegions.get(ASIA).add(southeastAsia);
    }
    Continent(Set<Country> countries){
        this.countries = countries;
    }

    public Set<Country> getCountries() {
        return countries;
    }

    public String getName(Locale locale){
        final ResourceBundle bundle = ResourceBundle.getBundle("continents", locale);
        return bundle.getString(name().toLowerCase().replace('_','-'));
    }
    public String getRegion(Country country,Locale locale){
        final ResourceBundle bundle = ResourceBundle.getBundle("continents", locale);
        return bundle.getString(countryRegion.get(country));
    }

    public Set<String> getRegionKeys(){
        return continentRegions.get(this);
    }
}
