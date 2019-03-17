/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.mandatPersonnel.model.dao;

import com.faculte.mandatPersonnel.bean.Personnel;
import com.faculte.mandatPersonnel.bean.TypePersonnel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author abdou
 */
@Repository
public interface TypePersonnelDao extends JpaRepository<TypePersonnel, Long>{
   public TypePersonnel findByPersonnel(Personnel personnel); 
   public TypePersonnel findByLibelle(String libelle);
   
}

