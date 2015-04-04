package allProject.dao.impl;

import allProject.dao.PlaceDao;
import allProject.entity.Place;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Aleksandr on 26.03.2015.
 */
@Repository
public class PlaceDaoImpl implements PlaceDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void addPlace(Place place) {
        if (place==null) throw new IllegalArgumentException("Place must be vzlid");
        sessionFactory.getCurrentSession().saveOrUpdate(place);
    }

    @Override
    @Transactional
    public void deletePlace(Place place) {
        if (place==null) throw new IllegalArgumentException("Place must be vzlid");
        sessionFactory.getCurrentSession().delete(place);
    }

    @Override
    @Transactional
    @SuppressWarnings("unchecked")
    public Set<Place> getAllPlace() {
        List<Place> placeList = sessionFactory.getCurrentSession().createQuery("from Place").list();
        Set<Place> placeSet = new HashSet<Place>();
        if (placeList == null) return null;
        for (Place place : placeList){
            placeSet.add(place);
        }
        return placeSet;
    }

}
