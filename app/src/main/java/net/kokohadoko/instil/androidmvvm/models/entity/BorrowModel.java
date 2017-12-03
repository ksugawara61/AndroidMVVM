package net.kokohadoko.instil.androidmvvm.models.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;


import net.kokohadoko.instil.androidmvvm.models.util.DateConverter;

import java.util.Date;

/**
 * モデル
 *
 * @author katsuya
 * @since 1.0.0
 */
@Entity  // このクラスをDBのテーブルとして利用することを宣言
public class BorrowModel {

    @PrimaryKey(autoGenerate = true)
    public int id;  // テーブルの PrimaryKeyとして宣言。 autoGenerate = true はエンティティ生成時に自動生成することを意味する
    private String itemName;
    private String personName;
    @TypeConverters(DateConverter.class)  // SQLiteはデフォルトでDate型を保存できないため変換用のアノテーションを宣言
    private Date borrowDate;

    /**
     * コンストラクタ
     *
     * @param itemName 貸し出すアイテム
     * @param personName 貸し出すユーザ
     * @param borrowDate 貸出日
     */
    public BorrowModel(String itemName, String personName, Date borrowDate) {
        this.itemName = itemName;
        this.personName = personName;
        this.borrowDate = borrowDate;
    }

    public String getItemName() {
        return itemName;
    }

    public String getPersonName() {
        return personName;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }
}
