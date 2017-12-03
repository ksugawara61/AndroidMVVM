package net.kokohadoko.instil.androidmvvm.models;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import net.kokohadoko.instil.androidmvvm.models.dao.BorrowModelDao;
import net.kokohadoko.instil.androidmvvm.models.entity.BorrowModel;

/**
 * アプリケーションのDBクラス
 *
 * @author katsuya
 * @since 1.0.0
 */
@Database(entities = {BorrowModel.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase INSTANCE;

    public static AppDatabase getDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "borrow_db")
                    .build();
        }
        return INSTANCE;
    }

    public abstract BorrowModelDao itemAndPersonModel();
}
