package iih.en.pv.s.bp.ip.qry;

import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.en.comm.util.EnAgeCalcUtil;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.inpatient.dto.d.IpRegInfoDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 
 * @author renzhi
 *
 */
public class GetIpRegInfoBP {

    public PagingRtnData<IpRegInfoDTO> exec(IpRegInfoDTO qryDto, PaginationInfo pageInfo) throws BizException {
        if (qryDto == null)
            return null;
        SqlParam param = new SqlParam();
        String sql = this.getSql(qryDto, param);
        PagingRtnData<IpRegInfoDTO> ret = this.getRtnData(pageInfo, sql, param);
        if (ret != null && ret.getPageData() != null && ret.getPageData().size() > 0) 
            this.getPatAge(ret);
        return ret;
    }

    /**
     * 根据查询卡 
     * 拼接查询条件
     * @param qryDto
     * @param param
     * @return
     */
    private String getSql(IpRegInfoDTO qryDto, SqlParam param) {
        StringBuilder sqlsb= new StringBuilder();
        sqlsb.append(" SELECT");
        sqlsb.append(" PAT.CODE AS CODE_PAT,");//患者编码
        sqlsb.append(" PAT.NAME AS NAME_PAT,");//患者姓名  
        sqlsb.append(" IP.CODE_AMR_IP,");//住院号code_amr_ip
        sqlsb.append(" PAT.DT_BIRTH,");//出生日期
        sqlsb.append(" ENT.ID_PATCA,");//患者身份id
        sqlsb.append(" CA.NAME AS NAME_PATCA,");//患者身份
        sqlsb.append(" DEP_NURDISC.NAME AS NAME_DEP_NUR_OUT,");//出院病区
        sqlsb.append(" DEP_PHYDISC.NAME AS NAME_DEP_OUT,");//出院科室
        sqlsb.append(" DEP_NURADM.NAME AS NAME_DEP_NURADM,");//入院病区
        sqlsb.append(" DEP_PHYADM.NAME AS NAME_DEP_PHYADM,");//入院科室
        sqlsb.append(" ENT.DT_END,");//出院时间
        sqlsb.append(" ENT.ID_HP,");//主医保计划_本次
        sqlsb.append(" BD_HP.NAME AS NAME_HP,");//医保类型
        sqlsb.append(" ENT.DT_ENTRY AS DT_ENTRY,");//入院时间
        sqlsb.append(" IP.NAME_BED AS NAME_BED,");//床号
        sqlsb.append(" IP.DT_DEATH AS DT_DEATH,");//死亡时间
        sqlsb.append(" emp.name AS name_psn_st,");//结算人员
        sqlsb.append(" ent.fg_st AS fg_st,");//结算标志
        sqlsb.append(" stip.fg_pay AS fg_payedf ");//死亡时间
        sqlsb.append(" FROM EN_ENT ENT");
        sqlsb.append(" INNER JOIN PI_PAT PAT  ON PAT.ID_PAT = ENT.ID_PAT ");
        sqlsb.append(" INNER JOIN EN_ENT_IP  IP ON IP.ID_ENT = ENT.ID_ENT ");
        sqlsb.append(" LEFT JOIN PI_PAT_CA CA ON CA.ID_PATCA = ENT.ID_PATCA");
        sqlsb.append(" LEFT JOIN BD_DEP DEP_NURDISC ON DEP_NURDISC.ID_DEP = IP.ID_DEP_NURDISC");//出院病区
        sqlsb.append(" LEFT JOIN BD_DEP DEP_PHYDISC ON DEP_PHYDISC.ID_DEP = IP.ID_DEP_PHYDISC");//出院科室
        sqlsb.append(" LEFT JOIN BD_DEP DEP_NURADM ON DEP_NURADM.ID_DEP = IP.ID_DEP_NURADM");//入院病区
        sqlsb.append(" LEFT JOIN BD_DEP DEP_PHYADM ON DEP_PHYADM.ID_DEP = IP.ID_DEP_PHYADM");//入院科室
        sqlsb.append(" LEFT JOIN BD_HP BD_HP ON BD_HP.ID_HP = ENT.ID_HP");//医保
        //结算人员
        sqlsb.append(" left join bl_st_ip stip on stip.id_ent = ent.id_ent and stip.eu_direct = '1' and stip.fg_canc = 'N' ");
        sqlsb.append(" left join bd_psndoc emp on emp.id_psndoc = stip.id_emp_st");
        sqlsb.append(" WHERE");
        sqlsb.append(" ENT.FG_IP = ? ");
        //没有在院
        param.addParam(FBoolean.FALSE);
        sqlsb.append(" AND IP.SD_STATUS = ? ");
        //就诊状态
        param.addParam(IEnDictCodeConst.SD_ENSTATUS_IN_HOSPITALOUT);
        //出院时间
        if (qryDto.getDt_end_qry_left()!= null ) {
            sqlsb.append(" AND ENT.DT_END >= ?");
            param.addParam(qryDto.getDt_end_qry_left());
        }
        //出院时间
        if (qryDto.getDt_end_qry_right() != null ) {
            sqlsb.append(" AND ENT.DT_END <= ?");
            param.addParam(qryDto.getDt_end_qry_right());
        }
        //入院时间
        if (qryDto.getDt_entry_qry_left() != null) {
            sqlsb.append(" AND ENT.DT_ENTRY >= ?");
            param.addParam(qryDto.getDt_entry_qry_left());
        }
        if (qryDto.getDt_entry_qry_right() != null) {
            sqlsb.append(" AND ENT.DT_ENTRY <= ?");
            param.addParam(qryDto.getDt_entry_qry_right());
        }
        //入科时间
        if (qryDto.getDt_acpt_left() != null) {
            sqlsb.append(" AND ENT.DT_ACPT >= ?");
            param.addParam(qryDto.getDt_acpt_left());
        }
        if (qryDto.getDt_acpt_right()!= null) {
            sqlsb.append(" AND ENT.DT_ACPT <= ?");
            param.addParam(qryDto.getDt_acpt_right());
        }
        //出院病区
        if (!EnValidator.isEmpty(qryDto.getId_dep_nur_out()) ) {
            sqlsb.append(" AND IP.ID_DEP_NURDISC = ?");
            param.addParam(qryDto.getId_dep_nur_out());
        }
        //入院病区
        if (!EnValidator.isEmpty(qryDto.getId_dep_nuradm()) ) {
            sqlsb.append(" AND IP.ID_DEP_NURADM = ?");
            param.addParam(qryDto.getId_dep_nuradm());
        }
        //出院科室
        if (!EnValidator.isEmpty(qryDto.getId_dep_out())) {
            sqlsb.append(" AND IP.ID_DEP_PHYDISC = ?");
            param.addParam(qryDto.getId_dep_out());
        }
        //入院科室
        if (!EnValidator.isEmpty(qryDto.getId_dep_phyadm()) ) {
            sqlsb.append(" AND IP.ID_DEP_PHYADM = ?");
            param.addParam(qryDto.getId_dep_phyadm());
        }
        //患者code
        if (!EnValidator.isEmpty(qryDto.getCode_pat()) ) {
            sqlsb.append(" AND PAT.CODE  = ?");
            param.addParam(qryDto.getCode_pat());
        }
        //患者姓名
        if (!EnValidator.isEmpty(qryDto.getName_pat())) {
            sqlsb.append(" AND PAT.NAME  = ?");
            param.addParam(qryDto.getName_pat());
        }
        //患者身份
        if (!EnValidator.isEmpty(qryDto.getId_patca()) ) {
            sqlsb.append(" AND ENT.ID_PATCA = ?");
            param.addParam(qryDto.getId_patca());
        }
        //结算人员
        if(!EnValidator.isEmpty(qryDto.getId_psn_st())){
        	sqlsb.append(" and stip.id_emp_st = ? ");
        	param.addParam(qryDto.getId_psn_st());
        }
    	 //结算标志
        if(FBoolean.TRUE.equals(qryDto.getFg_st())){
        	sqlsb.append(" and ent.fg_st = ? ");
        	param.addParam(qryDto.getFg_st());
        }
        //支付标志
        if(FBoolean.TRUE.equals(qryDto.getFg_payedf())){
        	sqlsb.append(" and stip.fg_pay = ? ");
        	param.addParam(qryDto.getFg_payedf());
        }
        return sqlsb.toString();
    }
    
    
    /**
     * 查询数据 分页
     * @param pg
     * @param sql
     * @param param
     * @return
     * @throws BizException
     */
    private PagingRtnData<IpRegInfoDTO> getRtnData(PaginationInfo pg, String sql, SqlParam param)
            throws BizException {
        PagingServiceImpl<IpRegInfoDTO> pageQryService = new PagingServiceImpl<IpRegInfoDTO>();
        return pageQryService.findByPageInfo(new IpRegInfoDTO(), pg, sql, null, param);
    }
    
    /**
     * 查找患者年龄
     * @param ret
     * @throws BizException 
     */
    private void getPatAge(PagingRtnData<IpRegInfoDTO> ret) throws BizException{
        FArrayList arrList = ret.getPageData();
        if (arrList != null && arrList.size() > 0){
            for (Object obj : arrList) {
                IpRegInfoDTO pePatInfoDTO = (IpRegInfoDTO)obj;
                //pePatInfoDTO.setAge(AgeCalcUtil.getAge(pePatInfoDTO.getDt_birth()));
				//设置患者是否死亡
                if (pePatInfoDTO.getDt_death() == null) {
                    pePatInfoDTO.setFg_death(FBoolean.FALSE);
                }else {
                    pePatInfoDTO.setFg_death(FBoolean.TRUE);
                }          
            }
            //设置年龄
            EnAgeCalcUtil.setDoAges((IpRegInfoDTO[])arrList.toArray(new IpRegInfoDTO[]{}), "Id_ent", "Age");
        }
    }
    
}
