package iih.en.pv.s.bp.ip.qry;

import iih.bd.base.utils.SqlUtils;
import iih.en.comm.IEnConst;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.IpBasicDTO;
import iih.en.pv.inpatient.d.EnPeCmpyItmDO;
import iih.en.pv.inpatient.d.InpatientDO;
import iih.en.pv.inpatient.d.desc.InpatientDODesc;
import iih.en.pv.inpatient.dto.d.EnPeCmpyDTO;
import iih.en.pv.inpatient.i.IInpatientRService;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitRService;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 
 * @author renzhi
 *
 */
public class GetIpBasicDTOBP {

    // 获取有指定团检单位并没有关联单位的就诊记录
    public IpBasicDTO[] exec(EnPeCmpyDTO qryDTO) throws BizException {
        if (qryDTO == null || qryDTO.getId_pecmpy() == null || qryDTO.getId_cust_cmpy() == null) {
            return null;
        }
        // 获取关联了团检单位的就诊id
        List<String> list = this.getEntid(qryDTO);
        List<IpBasicDTO> ipList = null;
        ipList =this.geIpBasicDTOs(qryDTO,list);
        if (ipList != null && ipList.size() != 0) {
            return ipList.toArray(new IpBasicDTO[ipList.size()]);
        }
        return null;
    }
    
    /**
     * 获取sql 
     * @return
     */
    private StringBuilder getSql() {
        StringBuilder sqlSb = new StringBuilder();
        sqlSb.append(" SELECT");
        sqlSb.append(" ENT.ID_ENT,");
        sqlSb.append(" PAT.NAME NAME_PAT,");
        sqlSb.append(" PAT.ID_CODE,");
        sqlSb.append(" PAT.CODE CODE_PAT,");
        sqlSb.append(" PAT.MOB TEL_PAT,");
        sqlSb.append(" ENT.DT_ENTRY,");
        sqlSb.append(" ENT.DT_ACPT,");
        sqlSb.append(" ENT.DT_END,");
        sqlSb.append(" ENT.FG_IP,");
        sqlSb.append(" ENT.ID_DEP_NUR,");
        sqlSb.append(" ENT.ID_DEP_PHY,");
        sqlSb.append(" ENT.SD_STATUS,");
        sqlSb.append(" ENT.ID_HP,");
        sqlSb.append(" ENT.ID_SEX_PAT NAME_SEX,");//性别
        sqlSb.append(" ENT.DT_BIRTH_PAT DT_BIRTH,");
        sqlSb.append(" IP.CODE_AMR_IP,");
        sqlSb.append(" IP.ID_BED,");
        sqlSb.append(" IP.NAME_BED,");
        sqlSb.append(" IP.TIMES_IP,");
        sqlSb.append(" PAT.ID_PAT,");
        sqlSb.append(" NUR.NAME NAME_DEP_NUR,");
        sqlSb.append(" PHY.NAME NAME_DEP_PHY");
        sqlSb.append(" FROM EN_ENT_IP IP");
        sqlSb.append(" LEFT JOIN EN_ENT  ENT ON ENT.ID_ENT = IP.ID_ENT");
        sqlSb.append(" LEFT JOIN PI_PAT  PAT  ON PAT.ID_PAT = ENT.ID_PAT");
        sqlSb.append(" LEFT JOIN BD_DEP NUR ON NUR.ID_DEP= ENT.ID_DEP_NUR");
        sqlSb.append(" LEFT JOIN BD_DEP PHY ON  PHY.ID_DEP= ENT.ID_DEP_PHY");
        sqlSb.append(" WHERE");
        
        
        return sqlSb;
    }
    
    /**
     * 获取住院属性
     * @param qryDTO
     * @param list
     * @return
     * @throws DAException
     */
    @SuppressWarnings("unchecked")
    private List<IpBasicDTO> geIpBasicDTOs(EnPeCmpyDTO qryDTO, List<String>list) throws DAException {
        StringBuilder sqlSb = this.getSql();
        //sql条件
        SqlParam param = new SqlParam();
        //住院属性中 团检标识
        sqlSb.append(" IP.SD_PE_PSNTP = ?");
        param.addParam(IEnConst.SD_PE_PSNTP);
        if (qryDTO.getId_cust_cmpy() != null) {
            sqlSb.append(" AND ENT.ID_CUST_CMPY = ?");
            param.addParam(qryDTO.getId_cust_cmpy());
        }
        if (list != null && list.size()!= 0) {
            sqlSb.append(" AND  ");
            String notInSqlByBigIds = SqlUtils.getNotInSqlByBigIds("ENT.ID_ENT", list.toArray(new String[list.size()]));
            sqlSb.append(notInSqlByBigIds);
        }
        List<IpBasicDTO> ipBasicDTOs = (List<IpBasicDTO>) new DAFacade().execQuery(sqlSb.toString(), param, new BeanListHandler(IpBasicDTO.class));
        if (ipBasicDTOs != null && ipBasicDTOs.size() != 0) {
            return this.setlist(ipBasicDTOs);
        }
        return null;
    }
    
    /**
     * 封装性别 和年龄
     * @param ipBasicDTOs
     * @return
     */
    private List<IpBasicDTO> setlist(List<IpBasicDTO> ipBasicDTOs) {
        for (IpBasicDTO ipBasicDTO : ipBasicDTOs) {
            ipBasicDTO.setName_sex(this.setSexName(ipBasicDTO.getName_sex()));
            ipBasicDTO.setAge_pat(this.setAgePat(ipBasicDTO.getDt_birth()));
        }
        return ipBasicDTOs;
    }

    /**
     * 
     * @param Idcustcmpy
     * @param list
     * @return
     * @throws BizException 
     */
    private List<IpBasicDTO> getExcludeId(String Idcustcmpy,List<String> list) throws BizException{
        StringBuilder sBuilder = new StringBuilder();    
        IPativisitRService patvisitService = ServiceFinder.find(IPativisitRService.class);
        String inSqlByIds = SqlUtils.getInSqlByIds(" AND a0.ID_ENT NOT",list);
        sBuilder.append("a0.FG_IP = 'Y' and a0.id_cust_cmpy = '" + Idcustcmpy + "'");
        sBuilder.append(inSqlByIds);//" AND a0.ID_ENT NOT" +
        PatiVisitDO[] patiVisitDOs = patvisitService.find( sBuilder.toString(), "sv asc", FBoolean.FALSE);
        return this.setIpBasicDTOS(patiVisitDOs);
    }
    
    /**
     * 获取指定合同单位的就诊记录
     * 
     * @return
     * @throws BizException
     */
    private List<IpBasicDTO> getIpBasicDTO(String Idcustcmpy) throws BizException {
        IPativisitRService patvisitService = ServiceFinder.find(IPativisitRService.class);
        PatiVisitDO[] patiVisitDOs = patvisitService.find("a0.FG_IP = 'Y' and a0.id_cust_cmpy = '" + Idcustcmpy + "'", "sv asc", FBoolean.FALSE);
        return this.setIpBasicDTOS(patiVisitDOs);
    }

    /**
     * 
     * @param list
     * @return
     * @throws BizException
     */
    private List<IpBasicDTO> setIpBasicDTOS(PatiVisitDO[] list) throws BizException {
        List<IpBasicDTO> ipList = new ArrayList<IpBasicDTO>(list.length);
        if (!EnValidator.isEmpty(list)) {
            for (PatiVisitDO pativisitDO : list) {
                ipList.add(this.seIpBasicDTO(pativisitDO));
            }
        }
        return ipList;
    }

    /**
     * 根据就诊记录设置值
     * 
     * @param pativisitDO
     * @return
     * @throws BizException
     */
    private IpBasicDTO seIpBasicDTO(PatiVisitDO pativisitDO) throws BizException {
        IpBasicDTO ipbasicDTO = new IpBasicDTO();
        ipbasicDTO.setId_pat(pativisitDO.getId_pat());
        ipbasicDTO.setName_pat(pativisitDO.getName_pat());
        ipbasicDTO.setId_ent(pativisitDO.getId_ent());
        ipbasicDTO.setDt_entry(pativisitDO.getDt_entry());// 入院登记时间
        ipbasicDTO.setDt_acpt(pativisitDO.getDt_acpt());
        ipbasicDTO.setId_dep_phy(pativisitDO.getId_dep_phy());
        ipbasicDTO.setId_dep_nur(pativisitDO.getId_dep_nur());
        ipbasicDTO.setAge_pat(this.setAgePat(pativisitDO.getDt_birth_pat()));
        ipbasicDTO.setName_sex(this.setSexName(pativisitDO.getId_sex_pat()));//性別
        ipbasicDTO.setName_dep_phy(pativisitDO.getName_dep_phy());
        ipbasicDTO.setName_dep_nur(pativisitDO.getName_dep_nur());
        ipbasicDTO.setId_pat(pativisitDO.getId_pat());
        ipbasicDTO.setDt_end(pativisitDO.getDt_end());
        ipbasicDTO.setFg_ip(pativisitDO.getFg_ip());
        ipbasicDTO.setId_hp(pativisitDO.getId_hp());// 医保计划
        this.getInPatientDO(ipbasicDTO);
        return ipbasicDTO;
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
    
    /**
     * 获取性别
     * 
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
     * 查询住院信息
     * 
     * @param ipbasicDTO
     * @throws BizException
     */
    private void getInPatientDO(IpBasicDTO ipbasicDTO) throws BizException {
        IInpatientRService inpatientRService = ServiceFinder.find(IInpatientRService.class);
        InpatientDO[] inpatientDOs = inpatientRService.find(InpatientDODesc.TABLE_ALIAS_NAME + ".id_ent = '" + ipbasicDTO.getId_ent() + "'", "", FBoolean.FALSE);
        InpatientDO inpatientDO = inpatientDOs[0];
        ipbasicDTO.setId_bed(inpatientDO.getId_bed());
        ipbasicDTO.setName_bed(inpatientDO.getName_bed());
        ipbasicDTO.setCode_amr_ip(inpatientDO.getCode_amr_ip());
        ipbasicDTO.setSd_status(inpatientDO.getSd_status());
        ipbasicDTO.setTimes_ip(inpatientDO.getTimes_ip());// 住院次数
    }

    /**
     * 用于获取团检单位制定的就诊id
     * @throws BizException 
     * 
     */
    public EnPeCmpyItmDO[] getEnPeCmpyItmDOS(String Idpecmpy) throws BizException {
        StringBuilder sqlSb = this.getEntIdSql();
        // sql条件
        SqlParam param = new SqlParam();
        List<String> list = null;
        if (!EnValidator.isEmpty(Idpecmpy)) {
            sqlSb.append(" WHERE ITM.ID_PECMPY = ?");
            param.addParam(Idpecmpy);
            List<EnPeCmpyItmDO> enPeCmpyItmDOs = (List<EnPeCmpyItmDO>) new DAFacade().execQuery(sqlSb.toString(), param, new BeanListHandler(EnPeCmpyItmDO.class));
            list = this.setListid(enPeCmpyItmDOs);
            return list.toArray(new EnPeCmpyItmDO[list.size()]);
        }
        return null;
    }
    
    /**
     * 根据团检单位id 获取关联的个人就诊id
     * 
     * @param qryDTO
     * @return
     * @throws BizException
     */
    @SuppressWarnings("unchecked")
    public List<String> getEntid(EnPeCmpyDTO qryDTO) throws BizException {
        StringBuilder sqlSb = this.getEntIdSql();
        // sql条件
        SqlParam param = new SqlParam();
        List<String> list = null;
        if (!EnValidator.isEmpty(qryDTO.getId_pecmpy())) {
            sqlSb.append(" WHERE ITM.ID_PECMPY = ?");
            param.addParam(qryDTO.getId_pecmpy());
            List<EnPeCmpyItmDO> enPeCmpyItmDOs = (List<EnPeCmpyItmDO>) new DAFacade().execQuery(sqlSb.toString(), param, new BeanListHandler(EnPeCmpyItmDO.class));
            list = this.setListid(enPeCmpyItmDOs);
        }
        return list;
    }

    /**
     * 把查询的团检记录明细查到就诊id放在集合中
     * 
     * @return
     */
    private List<String> setListid(List<EnPeCmpyItmDO> enPeCmpyItmDOs) {
        List<String> list = new ArrayList<String>(enPeCmpyItmDOs.size());
        for (EnPeCmpyItmDO enPeCmpyItmDO : enPeCmpyItmDOs) {
            list.add(enPeCmpyItmDO.getId_ent());
        }
        return list;
    }


    /**
     * 拼接查询团检记录明细的sql
     * 
     * @return
     */
    private StringBuilder getEntIdSql() {
        StringBuilder sqlSb = new StringBuilder();
        sqlSb.append(" SELECT");
        sqlSb.append(" ITM.ID_ENT");
        sqlSb.append(" FROM EN_PE_CMPY_ITM ITM");
        return sqlSb;
    }
}
