/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.mandatPersonnel.rest.converter;

import com.faculte.mandatPersonnel.bean.Mandat;
import com.faculte.mandatPersonnel.common.util.DateUtil;
import com.faculte.mandatPersonnel.rest.vo.EntiteAdministratifVo;
import com.faculte.mandatPersonnel.rest.vo.MandatVo;
import java.time.Instant;
import java.util.Date;

/**
 *
 * @author abdou
 */
public class MandatConverter extends AbstractConverter<Mandat, MandatVo> {

    @Override
    public Mandat toItem(MandatVo vo) {
         if (vo == null) {
            return null;
        } else {
            Mandat item = new Mandat();
            item.setId(vo.getId());
            item.setDateDebutMandat(DateUtil.parse(vo.getDateDebutMandat()));
            item.setDateFinMandat(DateUtil.parse(vo.getDateFinMandat()));
            item.setPersonnel(new PersonnelConverter().toItem(vo.getPersonnelVo()));
            item.setEntiteAdministratif(new EntiteAdministratifConverter().toItem(vo.getEntiteAdministratifVo()));
            item.setResponsabilite(new ResponsabiliteConverter().toItem(vo.getResponsabiliteVo()));
            return item;
        }
    }

    @Override
    public MandatVo toVo(Mandat item) {
           if(item==null){
            return null;
        }
        else{
            MandatVo vo =new MandatVo();
            vo.setDateDebutMandat(DateUtil.formateDate(item.getDateDebutMandat()));
            vo.setDateFinMandat(DateUtil.formateDate(item.getDateFinMandat()));
            vo.setPersonnelVo(new PersonnelConverter().toVo(item.getPersonnel()));
            vo.setEntiteAdministratifVo(new EntiteAdministratifConverter().toVo(item.getEntiteAdministratif()));
            vo.setResponsabiliteVo(new ResponsabiliteConverter().toVo(item.getResponsabilite()));
            return vo;
        }
    }

}
