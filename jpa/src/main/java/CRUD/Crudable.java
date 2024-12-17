package CRUD;

public interface Crudable {

    void selectOne (String countryName);
    void insertOne (String countryName, String countryLanguage);
    void updateOne (String countryName, String countryLanguage);
    void deleteOne (String countryName);

}
