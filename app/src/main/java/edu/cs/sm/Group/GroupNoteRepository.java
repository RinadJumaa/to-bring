package edu.cs.sm.Group;

import android.app.Application;
import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import android.os.AsyncTask;
import java.util.List;

public class GroupNoteRepository {

    private GroupNoteDao noteDao;
    private LiveData<List<GroupNote>> allNotes;

    public GroupNoteRepository(Application application){
        GroupNoteDatabase noteDatabase = GroupNoteDatabase.getInstance(application);
        noteDao = noteDatabase.noteDao();
        allNotes = noteDao.getAllNotes();
    }

    public void insert(GroupNote note){
        new InsertAsyncTask(noteDao).execute(note);
    }

    public void update(GroupNote note){
        new UpdateAsyncTask(noteDao).execute(note);
    }

    public void delete(GroupNote note){
        new DeleteAsyncTask(noteDao).execute(note);
    }

    public void deleteAll(){
        new DeleteAllAsyncTask(noteDao).execute();
    }

    public LiveData<List<GroupNote>> getAllNotes(){
        return allNotes;
    }

    private class InsertAsyncTask extends AsyncTask<GroupNote,Void,Void>{

        private GroupNoteDao noteDao;

        InsertAsyncTask(GroupNoteDao noteDao){
            this.noteDao = noteDao;
        }

        @Override
        protected Void doInBackground(GroupNote... notes) {
            noteDao.insert(notes[0]);
            return null;
        }
    }

    private class UpdateAsyncTask extends AsyncTask<GroupNote,Void,Void>{

        private GroupNoteDao noteDao;

        UpdateAsyncTask(GroupNoteDao noteDao){
            this.noteDao = noteDao;
        }

        @Override
        protected Void doInBackground(GroupNote... notes) {
            noteDao.update(notes[0]);
            return null;
        }
    }

    private class DeleteAsyncTask extends AsyncTask<GroupNote,Void,Void>{

        private GroupNoteDao noteDao;

        DeleteAsyncTask(GroupNoteDao noteDao){
            this.noteDao = noteDao;
        }

        @Override
        protected Void doInBackground(GroupNote... notes) {
            noteDao.delete(notes[0]);
            return null;
        }
    }


    private class DeleteAllAsyncTask extends AsyncTask<Void,Void,Void>{

        private GroupNoteDao noteDao;

        DeleteAllAsyncTask(GroupNoteDao noteDao){
            this.noteDao = noteDao;
        }


        @Override
        protected Void doInBackground(Void... voids) {
            noteDao.deleteAll();
            return null;
        }
    }
}

