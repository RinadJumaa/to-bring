package edu.cs.sm.Group;


import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import androidx.annotation.NonNull;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = GroupNote.class,version = 1)
public abstract class GroupNoteDatabase extends RoomDatabase {

    public abstract GroupNoteDao noteDao();

    private static GroupNoteDatabase instance;

    public static synchronized GroupNoteDatabase getInstance(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(context,GroupNoteDatabase.class,"note_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }
        return instance;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void,Void,Void>{
        private GroupNoteDao noteDao;
        private PopulateDbAsyncTask(GroupNoteDatabase noteDatabase){
            this.noteDao = noteDatabase.noteDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            noteDao.insert(new GroupNote("Title 1","Description 1",1));
            noteDao.insert(new GroupNote("Title 2","Description 3",2));
            noteDao.insert(new GroupNote("Title 3","Description 3",3));
            return null;
        }
    }
}