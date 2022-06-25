package com.fis.sprint4.service;

import com.fis.sprint4.model.Detective;

import java.util.Set;

public interface DetectiveService {
    Detective addDetective(Detective detective);

    Detective updateDetective(Detective detective);

    Set<Detective> getDetectives();

    Detective getDetective(Long id);

    void deleteDetective(Long id);

}
