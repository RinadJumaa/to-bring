package edu.cs.sm.Group;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.sql.Date;

@Entity(tableName = "note_table")

public class GroupNote {

    @PrimaryKey(autoGenerate = true)
    int id;
    String title;
    String description;
    int priority;

    public GroupNote(String title, String description, int priority ) {
        this.title = title;
        this.description = description;
        this.priority = priority;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getPriority() {
        return priority;
    }

}