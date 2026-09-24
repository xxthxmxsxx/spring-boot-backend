package com.notes.notesbackend.controller;

import com.notes.notesbackend.service.NoteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.notes.notesbackend.model.Note;


import java.util.List;

@RestController
public class NoteController {

    private final NoteService noteService;
    public NoteController(NoteService noteService){
        this.noteService = noteService;
    }

    @PostMapping("/notes")
    public ResponseEntity<Note> createNote(@RequestBody Note note){
        Note saved = noteService.createNote(note);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping("/notes")
    public ResponseEntity<List<Note>> getAllNotes(){
        return ResponseEntity.ok(noteService.getAllNotes());
    }

    @PatchMapping("/notes/{id}")
    public ResponseEntity<Note> updateNote(@PathVariable Long id, @RequestBody Note changes){
        Note result = noteService.updateNote(id, changes);
        if (result == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);


    }

    @DeleteMapping("/notes/{id}")
    public ResponseEntity<Void> deleteNote(@PathVariable Long id){
        if (noteService.deleteNote(id)){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

