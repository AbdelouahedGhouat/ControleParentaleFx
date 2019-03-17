/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.mandatPersonnel.rest.converter;

import com.faculte.mandatPersonnel.bean.Responsabilite;
import com.faculte.mandatPersonnel.rest.vo.ResponsabiliteVo;

/**
 *
 * @author abdou
 */
public class ResponsabiliteConverter extends AbstractConverter<Responsabilite, ResponsabiliteVo>{

    @Override
    public Responsabilite toItem(ResponsabiliteVo vo) {
         if (vo == null) {
            return null;
        } else {
            Responsabilite item = new Responsabilite();
            item.setId(vo.getId());
            item.setPoste(vo.getPoste());
            return item;
        }
    }

    @Override
    public ResponsabiliteVo toVo(Responsabilite item) {
         if(item==null){
            return null;
        }
        else{
            ResponsabiliteVo vo =new ResponsabiliteVo();
            vo.setId(item.getId());
            vo.setPoste(item.getPoste());
            return vo;
        }
    }
    
}
