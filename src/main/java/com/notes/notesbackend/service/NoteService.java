package com.notes.notesbackend.service;


import com.notes.notesbackend.model.Note;
import com.notes.notesbackend.respository.NoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {

    private final NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository){
        this.noteRepository = noteRepository;
    }
    public Note createNote(Note note){
        return noteRepository.save(note);
    }

    public List<Note> getAllNotes(){
        return noteRepository.findAll();
    }

    public Note updateNote(Long id,Note changes){

        Note updatedNote = noteRepository.findById(id).get();
        if (changes.getTitle() != null){
            updatedNote.setTitle(changes.getTitle());
        }
        if (changes.getContent() != null){
            updatedNote.setContent(changes.getContent());
        }
        return noteRepository.save(updatedNote);


    }

    public boolean deleteNote(Long id){
        if (!noteRepository.existsById(id)){
            return false;
        }
        noteRepository.deleteById(id);
        return true;
    }

}
