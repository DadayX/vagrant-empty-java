package com.vagrant.MyNote.Service;

import com.vagrant.MyNote.Model.Note;
import java.util.List;
public interface NoteService {
    public Note addNote(Note n);
    public List<Note> getAllNote();
    public Note getNoteById(int id);
    public Note UpdateNote(Note n);
    public Note deleteNote(int id);
    public long countNote();
}
