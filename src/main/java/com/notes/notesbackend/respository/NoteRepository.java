package com.notes.notesbackend.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.notes.notesbackend.model.Note;
public interface NoteRepository extends JpaRepository<Note, Long>{
}
