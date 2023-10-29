package com.voron.repositories;

import com.voron.models.Publication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublicationRepository extends JpaRepository<Publication,Long> {
}
