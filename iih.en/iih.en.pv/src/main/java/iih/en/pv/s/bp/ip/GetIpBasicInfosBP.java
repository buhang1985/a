package iih.en.pv.s.bp.ip;

import iih.en.comm.IEnConst;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.IpBasicDTO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDate;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * 
 * @author renzhi
 */
public class GetIpBasicInfosBP {

    /**
     * 获取住院基本信息 
     * @param entId 就诊id
     * @return
     * @throws BizException
     */
    public IpBasicDTO[] exec(String idpecmpy) throws BizException{   
        if( EnValidator.isEmpty(idpecmpy) )
        {
            return null;
        }
        return this.getIpBasicDTos(idpecmpy);
    }
    
    /**
     * 根据团检单位id 获取团检单位关联用户
     * 
     */
    @SuppressWarnings("unchecked")
    private IpBasicDTO[] getIpBasicDTos(String idpecmpy) throws DAException {
        StringBuilder sqlSb = this.getsql();
        SqlParam param = new SqlParam();
        List<IpBasicDTO> patEntInfos = null;
        if ( !EnValidator.isEmpty(idpecmpy )) {
            sqlSb.append(" WHERE ITM.ID_PECMPY = ? ");
            param.addParam(idpecmpy);
            patEntInfos = (List<IpBasicDTO>) new DAFacade().execQuery(sqlSb.toString(), param, new BeanListHandler(IpBasicDTO.class));
        }
        if (patEntInfos != null && patEntInfos.size() != 0) {
            //设置性别
            this.setSex(patEntInfos);
            //设置年龄
            this.setAge(patEntInfos);
            return patEntInfos.toArray(new IpBasicDTO[patEntInfos.size()]);
        }
        return null;
    }
    
    /**
     * 拼接sql
     * @return
     */
    private StringBuilder getsql() {
        StringBuilder sqlSb = new StringBuilder();
        sqlSb.append(" SELECT");
        sqlSb.append(" ITM.ID_PECMPYITM,");//团检患者明细id
        sqlSb.append(" ENT.ID_ENT,");//就诊id
        sqlSb.append(" ENT.ID_ENT,");//患者id
        sqlSb.append(" ENT.ID_DEP_PHY,");//科室id
        sqlSb.append(" ENT.ID_DEP_NUR,");//病区id
        sqlSb.append(" ENT.ID_SEX_PAT NAME_SEX,");//患者性别id
        sqlSb.append(" ENT.NAME_PAT,");//患者姓名
        sqlSb.append(" ENT.DT_ENTRY,");//登记时间
        sqlSb.append(" ENT.DT_BIRTH_PAT DT_BIRTH,");//出生时间
        sqlSb.append(" PHY.NAME NAME_DEP_PHY,");//科室名称
        sqlSb.append(" NUR.NAME NAME_DEP_NUR,");//病区名称
        sqlSb.append(" IP.CODE_AMR_IP");//住院号
        sqlSb.append(" FROM EN_PE_CMPY_ITM ITM");
        sqlSb.append(" LEFT JOIN EN_ENT ENT ON ENT.ID_ENT = ITM.ID_ENT");
        sqlSb.append(" LEFT JOIN EN_ENT_IP IP ON IP.ID_ENT =  ENT.ID_ENT");
        sqlSb.append(" LEFT JOIN BD_DEP NUR ON NUR.ID_DEP = ENT.ID_DEP_NUR");
        sqlSb.append(" LEFT JOIN BD_DEP PHY ON PHY.ID_DEP = ENT.ID_DEP_PHY");
        return sqlSb;
    }
    
    /**
     * 设置年龄
     * @param list
     */
    private void setAge(List<IpBasicDTO> list) {
        for (IpBasicDTO ipBasicDTO : list) {
            ipBasicDTO.setAge_pat(this.setAgePat(ipBasicDTO.getDt_birth()));
        }
    }
    
    /**
     * 设置性别
     * @param list
     */
    private void setSex(List<IpBasicDTO> list) {
        for (IpBasicDTO ipBasicDTO : list) {
            ipBasicDTO.setName_sex(this.setSexName(ipBasicDTO.getName_sex()));
        }
    }
    
    /**
     * 获取性别
     * @param Idsexpat
     * @return
     */
    private String setSexName(String Idsexpat) {
        if (IEnConst.SEX_ID_BOY.equals(Idsexpat)) {
            return IEnConst.SEX_NAME_BOY;
        }
        if (IEnConst.SEX_ID_GIRL.equals(Idsexpat)) {
            return IEnConst.SEX_NAME_GIRL;
        }
        if (IEnConst.SEX_ID_UNDECLARED.equals(Idsexpat)) {
            return IEnConst.SEX_NAME_UNDECLARED;
        }
        if (IEnConst.SEX_ID_UNKNOWN.equals(Idsexpat)) {
            return IEnConst.SEX_NAME_UNKNOWN;
        }
        return "";
    }
    /**
     * 获取年龄
     * @param fDate
     * @return
     */
    private String setAgePat(FDate fDate) {
        FDate date = new FDate();
        if (fDate != null && fDate.getYear() != 0) {
            Integer age = date.getYear() - fDate.getYear();
            return age.toString();
        }
        return "";
    }

}
