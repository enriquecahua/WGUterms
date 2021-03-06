package com.example.wguterms.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.wguterms.Entities.TermEntity;

import java.util.List;
@Dao
public interface TermDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertTerm(TermEntity termEntity);

    @Update
    void updateTerm(TermEntity term);

    @Delete
    void deleteTerm(TermEntity termEntity);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllTerms(List<TermEntity> terms);


    @Query("SELECT * FROM terms WHERE term_id = :term_id")
    TermEntity getTermByID(int term_id);

    @Query("SELECT * FROM terms ORDER BY term_start_date ASC")
    LiveData<List<TermEntity>> getAllTerms();

    @Query("DELETE FROM terms")
    int deleteAllTerms();

@Query("SELECT COUNT(*) FROM terms")
    int getTermCount();



}
