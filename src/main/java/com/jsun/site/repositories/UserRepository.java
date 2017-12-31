package com.jsun.site.repositories;

import com.jsun.site.entities.UserPrincipal;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserPrincipal, Long>
{
	UserPrincipal getByUsername(String username);
}
