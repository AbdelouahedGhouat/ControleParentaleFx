/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.mandatPersonnel.rest.converter;

import com.faculte.mandatPersonnel.bean.EntiteAdministratif;
import com.faculte.mandatPersonnel.rest.vo.EntiteAdministratifVo;

/**
 *
 * @author abdou
 */
public class EntiteAdministratifConverter extends AbstractConverter<EntiteAdministratif, EntiteAdministratifVo>{

    @Override
    public EntiteAdministratif toItem(EntiteAdministratifVo vo) {
         if (vo == null) {
            return null;
        } else {
            EntiteAdministratif item = new EntiteAdministratif();
            item.setId(vo.getId());
            item.setReferenceEntiteAdministratif(vo.getReferenceEntiteAdministratif());
            return item;
        }
    }

    @Override
    public EntiteAdministratifVo toVo(EntiteAdministratif item) {
          if(item==null){
            return null;
        }
        else{
            EntiteAdministratifVo vo =new EntiteAdministratifVo();
            vo.setId(item.getId());
            vo.setReferenceEntiteAdministratif(item.getReferenceEntiteAdministratif());
            return vo;
        }
    }
    
}
