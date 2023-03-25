package com.vagrant.MyNote.Controller;

import com.vagrant.MyNote.Model.Note;
import com.vagrant.MyNote.Service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/MyNote")
@CrossOrigin
public class NoteController{
    @Autowired
    private NoteService noteService;
    @PostMapping("/add")
    public String add(@RequestBody Note n){
        this.noteService.addNote(n);
        return "New Note added.";
    }
    @PutMapping("/update")
    public String update(@RequestBody Note n){
        if(this.noteService.UpdateNote(n)==null){
            return "Update error";
        }
        return "New Note updated.";
    }
    @DeleteMapping("/delete/{id}")
    public String remove(@PathVariable(value = "id") int id){
        if(this.noteService.deleteNote(id)==null) return "Delete query error";
        return "New Note deleted.";
    }
    @GetMapping("/getAll")
    public List<Note> list(){
        return noteService.getAllNote();
    }
    @GetMapping("/get/{id}")
    public Note getNoteById(@PathVariable(value = "id") int id){
        return noteService.getNoteById(id);
    }
    @GetMapping("/Count")
    public long getCount(){
        return noteService.countNote();
    }

}
