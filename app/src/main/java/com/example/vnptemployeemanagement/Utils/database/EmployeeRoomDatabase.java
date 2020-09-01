package com.example.vnptemployeemanagement.Utils.database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.vnptemployeemanagement.Models.Employee;
import com.example.vnptemployeemanagement.EmployeeDao;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Employee.class}, version = 1, exportSchema = false)
public abstract class EmployeeRoomDatabase extends RoomDatabase {

    public abstract EmployeeDao employeeDao();

    // marking the instance as volatile to ensure atomic access to the variable
    private static volatile EmployeeRoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static EmployeeRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (EmployeeRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            EmployeeRoomDatabase.class, "employee_database")
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    /**
     * Override the onOpen method to populate the database.
     * For this sample, we clear the database every time it is created or opened.
     *
     * If you want to populate the database only when the database is created for the 1st time,
     * override RoomDatabase.Callback()#onCreate
     */
    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);

            // If you want to keep data through app restarts,
            // comment out the following block
            databaseWriteExecutor.execute(() -> {
                // Populate the database in the background.
                // If you want to start with more words, just add them.
                EmployeeDao dao = INSTANCE.employeeDao();
                dao.deleteAll();

                //Employee employee = new Employee("Hello","name");
                Employee employee = new Employee("Luu Quang Hieu", "26/11/1988","VNPT-HANOI", "Android team","Nam", "Dev","Single","0948122111","Hieu@gmail.com","Xa La Ha Dong" );
                dao.insert(employee);
                employee = new Employee("Nguyen Quang Hoa", "26/11/1988","VNPT-HANOI", "Android team","Nam", "Dev","Single","0948122111","Hieu@gmail.com","Xa La Ha Dong" );
                dao.insert(employee);
            });
        }
    };
}
