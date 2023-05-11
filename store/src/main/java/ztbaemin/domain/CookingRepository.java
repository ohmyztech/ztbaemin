package ztbaemin.domain;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ztbaemin.domain.*;

@RepositoryRestResource(collectionResourceRel = "cookings", path = "cookings")
public interface CookingRepository
    extends PagingAndSortingRepository<Cooking, Long> {}
