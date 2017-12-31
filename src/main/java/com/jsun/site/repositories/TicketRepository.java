package com.jsun.site.repositories;

import com.jsun.site.entities.TicketEntity;
import org.springframework.data.repository.CrudRepository;

public interface TicketRepository extends CrudRepository<TicketEntity, Long>, SearchableRepository<TicketEntity>
{
}
