/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.mandatPersonnel.rest.converter;

import com.faculte.mandatPersonnel.bean.TypePersonnel;
import com.faculte.mandatPersonnel.rest.vo.TypePersonnelVo;

/**
 *
 * @author abdou
 */
public class TypePersonnelConverter extends AbstractConverter<TypePersonnel, TypePersonnelVo>{

    @Override
    public TypePersonnel toItem(TypePersonnelVo vo) {
         if (vo == null) {
            return null;
        } else {
            TypePersonnel item = new TypePersonnel();
            item.setId(vo.getId());
            item.setLibelle(vo.getLibelle());
            //item.setPersonnel(vo.getPersonnelVo());
            return item;
        }
    }

    @Override
    public TypePersonnelVo toVo(TypePersonnel item) {
           if(item==null){
            return null;
        }
        else{
            TypePersonnelVo vo =new TypePersonnelVo();
            vo.setId(item.getId());
            vo.setLibelle(item.getLibelle());
            return vo;
        }
    }
    }
    

