package com.jsun.site.repositories;

import com.jsun.site.entities.TicketCommentEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface TicketCommentRepository extends CrudRepository<TicketCommentEntity, Long> {
	Page<TicketCommentEntity> getByTicketId(long ticketId, Pageable p); 
}
