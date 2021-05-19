package edu.cs.sm.Group;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.annotation.NonNull;

import java.util.List;


public class GroupNoteViewModel extends AndroidViewModel {

    private GroupNoteRepository noteRepository;
    private LiveData<List<GroupNote>> allNotes;

    public GroupNoteViewModel(@NonNull Application application) {
        super(application);
        noteRepository = new GroupNoteRepository(application);
        allNotes = noteRepository.getAllNotes();
    }

    public void insert(GroupNote note) {
        noteRepository.insert(note);
    }

    public void update(GroupNote note) {
        noteRepository.update(note);
    }

    public void delete(GroupNote note) {
        noteRepository.delete(note);
    }

    public void deleteAll() {
        noteRepository.deleteAll();
    }

    public LiveData<List<GroupNote>> getAllNotes() {
        return allNotes;
    }

}
