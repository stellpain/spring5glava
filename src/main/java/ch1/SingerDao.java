package ch1;

import ch2.Singer;

public interface SingerDao {
    String findNameById(Long id);
    void insert(Singer singer);
    void insert(Singer singer);
}
