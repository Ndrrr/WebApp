import dao.concrete.CountryDao;
import model.Country;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class CountryDaoTest {
    @Test
    public void testGetSingleCountry(){
        CountryDao countryDao = new CountryDao();
        Country country = countryDao.get(1);
        System.out.println(country);
        assertNotEquals(null, country);
    }
    @Test
    public void testCreateNewCountry(){
        Country country = new Country(-1, "England", "UK","British");
        CountryDao countryDao = new CountryDao();
        int previousSize = countryDao.getAll().size();
        countryDao.create(country);
        int newSize = countryDao.getAll().size();
        assertEquals(previousSize + 1, newSize);
    }
    @Test
    public void testDeleteCountry(){
        CountryDao countryDao = new CountryDao();
        var countries = countryDao.getAll();
        int previousSize = countries.size();
        countryDao.delete(countries.get(countries.size()-1).getId());
        int newSize = countryDao.getAll().size();
        assertEquals(previousSize - 1, newSize);
    }
    @Test
    public void testUpdateCountry(){
        Country country = new Country(2, "United Kingdom", "UK","British");
        CountryDao countryDao = new CountryDao();
        countryDao.update(country);
    }
    @Test
    public void testGetAllCountries() {
        CountryDao countryDao = new CountryDao();
        List<Country> countries = countryDao.getAll();
        System.out.println(countries);
    }
}
