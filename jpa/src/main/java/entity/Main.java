package entity;

import CRUD.CountrySql;

public class Main {
    public static void main(String[] args) {

        CountrySql.selectCountry("Sweden");
        CountrySql.insertCountry("Netherlands", "Dutch");
        CountrySql.deleteCountry("Sweden");
        CountrySql.updateCountry("Brazil", "Spanish");


    }

}
