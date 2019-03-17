/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.mandatPersonnel.rest.converter;

import com.faculte.mandatPersonnel.bean.SousProjet;
import com.faculte.mandatPersonnel.rest.vo.SousProjetVo;


/**
 *
 * @author abdou
 */
public class SousProjetConverter extends AbstractConverter<SousProjet, SousProjetVo>{

    
    @Override
    public SousProjet toItem(SousProjetVo vo) {
         if (vo == null) {
            return null;
        } else {
            SousProjet item = new SousProjet();
            item.setId(vo.getId());
            item.setReferenceSousProjet(vo.getReferenceSousProjet());
            item.setEntiteAdministratifs(new EntiteAdministratifConverter().toItem(vo.getEntiteAdministratifsVo()));
            return item;
        }
    }

    @Override
    public SousProjetVo toVo(SousProjet item) {
         if(item==null){
            return null;
        }
        else{
            SousProjetVo vo =new SousProjetVo();
            vo.setId(item.getId());
            vo.setReferenceSousProjet(item.getReferenceSousProjet());
            vo.setEntiteAdministratifsVo(new EntiteAdministratifConverter().toVo(item.getEntiteAdministratifs()));
            return vo;
        }
    }
    
    
    
}
