package de.deutschepost.epost.springproject.repositories;

import de.deutschepost.epost.springproject.models.Purchase;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by afischer on 16/03/2017.
 */
@Repository
public interface PurchaseRepository extends CrudRepository<Purchase, Long> {
}
