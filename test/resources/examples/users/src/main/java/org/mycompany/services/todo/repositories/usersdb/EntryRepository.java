package org.mycompany.services.todo.repositories.usersdb;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EntryRepository extends JpaRepository<Entry, String> {}
