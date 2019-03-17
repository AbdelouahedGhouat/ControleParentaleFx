/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.mandatPersonnel.rest.converter;

import com.faculte.mandatPersonnel.bean.Projet;
import com.faculte.mandatPersonnel.rest.vo.ProjetVo;

/**
 *
 * @author abdou
 */
public class ProjetConverter extends AbstractConverter<Projet,ProjetVo>{

    @Override
    public Projet toItem(ProjetVo vo) {
       
        if (vo == null) {
            return null;
        } else {
            Projet item = new Projet();
            item.setId(vo.getId());
            item.setLibelleP(vo.getLibelleP());
            item.setSousProjets(new SousProjetConverter().toItem(vo.getSousProjetsVo()));
            return item;
        }
    }
    

    @Override
    public ProjetVo toVo(Projet item) {
            if(item==null){
            return null;
        }
        else{
            ProjetVo vo =new ProjetVo();
            vo.setId(item.getId());
            vo.setLibelleP(item.getLibelleP());
            vo.setSousProjetsVo(new SousProjetConverter().toVo(item.getSousProjets()));
            return vo;
        }
    

    }
    
}
