/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.mandatPersonnel.model.service;

import com.faculte.mandatPersonnel.bean.Personnel;
import java.util.List;

/**
 *
 * @author abdou
 */
public interface PersonnelService {
     public Personnel findByCin(String cin);
     public Personnel creerPersonnel(Personnel personnel);
     public List<Personnel> findAll();
}
