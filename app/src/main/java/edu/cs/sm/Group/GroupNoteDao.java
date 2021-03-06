package edu.cs.sm.Group;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;


import java.util.List;

@Dao
public interface GroupNoteDao {

    @Insert
    void insert(GroupNote note);

    @Delete
    void delete(GroupNote note);

    @Update
    void update(GroupNote note);

    @Query("DELETE FROM note_table")
    void deleteAll();

    @Query("SELECT * FROM note_table ORDER BY priority DESC")
    LiveData<List<GroupNote>> getAllNotes();
}
