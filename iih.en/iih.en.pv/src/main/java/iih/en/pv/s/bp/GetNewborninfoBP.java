package iih.en.pv.s.bp;

import iih.bd.base.utils.SqlUtils;
import iih.en.comm.ep.NbEP;
import iih.en.comm.util.FDoubleUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.inpatient.d.NewbornDO;
import iih.en.pv.inpatient.dto.d.NewbornDTO;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

public class GetNewborninfoBP {

    public NewbornDTO[] exec(String momEntId) throws BizException {
        if (EnValidator.isEmpty(momEntId)) {
            return null;
        }
        NewbornDTO[] newbornDTOs = this.NewbornDOtoNewbornDTO(momEntId);
        return newbornDTOs;
    }
    
    /**
     * NewbornDO数组转为NewbornDTO数组
     * 
     * @param momEntId
     * @return
     * @throws BizException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     */
    private NewbornDTO[] NewbornDOtoNewbornDTO(String momEntId) throws BizException {
        NbEP nbEP = new NbEP();
        NewbornDO[] newbornDOs = nbEP.getNbListByMomEnt(momEntId);
        NewbornDTO[] dtos = new NewbornDTO[newbornDOs.length];
        // 存储就诊id 用于查询价格分类
        String[] entids = new String[newbornDOs.length];
        if (EnValidator.isEmpty(newbornDOs)) {
            return null;
        }
        for (int i = 0; i < newbornDOs.length; i++) {
            NewbornDTO dto = new NewbornDTO();
            NewbornDO nbdo = newbornDOs[i];
            try {
                BeanUtils.copyProperties(dto, newbornDOs[i]);
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new BizException("新生儿查询记录失败!");
            }
            // 设置父亲民族
            dto.setName_nation_dad(nbdo.getName_nation());
            // 设置证件类型
            dto.setName_idtp_dad(nbdo.getName_idtp());
            // 设置健康状态
            dto.setName_newbb_health(nbdo.getName_healthy());
            // 设置体重kg转换为g
            if(nbdo.getWeight() != null) 
            	dto.setWeight_g(FDoubleUtils.convertKgToG(nbdo.getWeight()));
            if(nbdo.getWeight_reg() != null) 
            	dto.setWeight_reg_g(FDoubleUtils.convertKgToG(nbdo.getWeight_reg()));
            dtos[i] = dto;
            // 获取新生儿就诊记录id
            entids[i] = dto.getId_ent_bb();
        }
        this.setpripat(entids, dtos);
        return dtos;
    }

    /**
     * 设置价格分类到新生儿dto中
     * 
     * @throws DAException
     */
    private void setpripat(String[] entids, NewbornDTO[] dtos) throws DAException {
        Map<String, Object> map = this.initpripatmap(entids);
        if (!EnValidator.isEmpty(dtos) && map != null) {
            for (NewbornDTO item : dtos) {
                NewbornDTO dto = (NewbornDTO) map.get(item.getId_entnb());
                if (dto != null) {
                    item.setId_pripat(dto.getId_pripat());
                    item.setName_paticate(dto.getName_paticate());
                }
            }
        }

    }

    /**
     * 初始化价格分类map
     * 
     * @param entids
     * @throws DAException
     */
    private Map<String, Object> initpripatmap(String[] entids) throws DAException {
        List<NewbornDTO> getpripat = this.getpripat(entids);
        Map<String, Object> pripatmap = new HashMap<String, Object>();
        if (!EnValidator.isEmpty(getpripat)) {
            for (NewbornDTO item : getpripat) {
                if (item != null && !EnValidator.isEmpty(item.getId_entnb())) {
                    pripatmap.put(item.getId_entnb(), item);
                }
            }
        }
        return pripatmap;
    }

    /**
     * 获取价格分类
     * 
     * @return
     * @throws DAException
     */
    @SuppressWarnings("unchecked")
    private List<NewbornDTO> getpripat(String[] entids) throws DAException {
        StringBuilder sqlSb = new StringBuilder();
        sqlSb.append(" SELECT");
        sqlSb.append(" NB.ID_ENTNB,");
        sqlSb.append(" ENT.ID_PRIPAT,");
        sqlSb.append(" PRI_PAT.NAME AS NAME_PATICATE");
        sqlSb.append(" FROM EN_ENT_NB NB");
        sqlSb.append(" LEFT JOIN EN_ENT ENT ON ENT.ID_ENT = NB.ID_ENT_BB");
        sqlSb.append(" LEFT JOIN BD_PRI_PAT PRI_PAT ON PRI_PAT.ID_PRIPAT = ENT.ID_PRIPAT");
        sqlSb.append(" WHERE ");
        if (!EnValidator.isEmpty(entids)) {
            String inSqlByIds = SqlUtils.getInSqlByIds("ENT.ID_ENT", entids);
            sqlSb.append(inSqlByIds);
            List<NewbornDTO> list = (List<NewbornDTO>) new DAFacade().execQuery(sqlSb.toString(), new BeanListHandler(NewbornDTO.class));
            return list;
        }

        return null;
    }


}
