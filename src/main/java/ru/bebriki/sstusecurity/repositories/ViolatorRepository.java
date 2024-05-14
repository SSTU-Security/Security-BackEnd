package ru.bebriki.sstusecurity.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.bebriki.sstusecurity.entities.Violator;

@Repository
public interface ViolatorRepository extends JpaRepository<Violator, Long> {
}
