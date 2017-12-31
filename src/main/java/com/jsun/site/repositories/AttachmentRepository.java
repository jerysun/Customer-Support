package com.jsun.site.repositories;

import com.jsun.site.entities.Attachment;
import org.springframework.data.repository.CrudRepository;

public interface AttachmentRepository extends CrudRepository<Attachment, Long> {
	Iterable<Attachment> getByTicketId(long ticketId);
}
