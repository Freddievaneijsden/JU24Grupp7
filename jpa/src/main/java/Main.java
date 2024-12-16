import CRUD.CountrySql;
import quiz.CountryQuiz;

public class Main {
    public static void main(String[] args) {

//        CountrySql.selectCountryAndPrint("Sweden");
//        CountrySql.insertCountry("Netherlands", "Dutch");
//        CountrySql.deleteCountry("Sweden");
//        CountrySql.updateCountry("Brazil", "Spanish");

        CountryQuiz quiz = new CountryQuiz();

        quiz.play();




    }

}
