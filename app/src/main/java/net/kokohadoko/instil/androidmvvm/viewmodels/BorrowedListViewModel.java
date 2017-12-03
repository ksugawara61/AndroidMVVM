package net.kokohadoko.instil.androidmvvm.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import net.kokohadoko.instil.androidmvvm.models.AppDatabase;
import net.kokohadoko.instil.androidmvvm.models.entity.BorrowModel;

import java.util.List;

/**
 * 貸出リストのViewModelクラス
 *
 * @author katsuya
 * @since 1.0.0
 */
public class BorrowedListViewModel extends AndroidViewModel {  // Application Contextが必要な場合 AndroidViewModelを継承

    private final LiveData<List<BorrowModel>> itemAndPersonList;

    private AppDatabase appDatabase;

    /**
     * コンストラクタ
     *
     * @param application アプリケーション
     */
    public BorrowedListViewModel(Application application) {
        super(application);

        appDatabase = AppDatabase.getDatabase(this.getApplication());

        itemAndPersonList = appDatabase.itemAndPersonModel().getAllBorrowedItems();
    }

    public LiveData<List<BorrowModel>> getItemAndPersonList() {
        return itemAndPersonList;
    }

    public void deleteItem(BorrowModel borrowModel) {
        new deleteAsyncTask(appDatabase).execute(borrowModel);
    }

    private static class deleteAsyncTask extends AsyncTask<BorrowModel, Void, Void> {

        private AppDatabase db;

        deleteAsyncTask(AppDatabase appDatabase) {
            db = appDatabase;
        }

        @Override
        protected Void doInBackground(final BorrowModel... params) {
            db.itemAndPersonModel().deleteBorrow(params[0]);
            return null;
        }
    }
}
