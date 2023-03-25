package com.vagrant.MyNote.Service;

import com.vagrant.MyNote.Model.Note;
import com.vagrant.MyNote.Repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class NoteServiceImpl implements NoteService{
    @Autowired
    private NoteRepository noteRepository;
    @Override
    public Note addNote(Note n) {
        return this.noteRepository.save(n);
    }

    @Override
    public List<Note> getAllNote() {
        return this.noteRepository.findAll();
    }

    @Override
    public Note getNoteById(int id) {
        return this.noteRepository.findById(id).get();
    }

    @Override
    public Note UpdateNote(Note n) {
        Note newNote=this.noteRepository.findById(n.getId()).get();
        if(newNote==null) return null;
        newNote.setContent(n.getContent());
        newNote.setTitle(n.getTitle());
        return this.noteRepository.save(newNote);
    }

    @Override
    public Note deleteNote(int id) {
        Note n=this.noteRepository.findById(id).get();
        if(n==null){
            return null;
        }
        this.noteRepository.delete(n);
        return n;
    }

    @Override
    public long countNote() {
       return this.noteRepository.count();
    }
}
