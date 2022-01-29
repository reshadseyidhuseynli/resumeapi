package com.company.implementation;

import com.company.entity.Country;
import com.company.inter.AbstractDAO;
import com.company.inter.CountryDAOInter;
import javax.persistence.EntityManager;
import java.util.List;

public class CountryDAO extends AbstractDAO implements CountryDAOInter {

    @Override
    public List<Country> getAllCountry() {
        EntityManager em = createEM();
        List<Country> result = em.createQuery("SELECT c from Country c", Country.class).getResultList();
        closeEmf();
        return result;
    }

}
