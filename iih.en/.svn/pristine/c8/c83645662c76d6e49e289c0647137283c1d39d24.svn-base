package iih.en.pv.s.bp.op.ws;

import iih.en.comm.util.EnLogUtil;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.outpatient.dto.d.EntInfoDTO;

import java.util.List;

import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 查询科室某段时间内的就诊记录
 * @author fanlq
 *
 */
public class GetEntListByDeptCodeBP {

    /**
     * 查询科室某段时间内的就诊记录
     * @param dtBegin  开始时间
     * @param dtEnd    结束时间         
     * @param deptCode 科室编码  可空         
     * @param entcode   就诊编码  可空
     * @param entpCode 就诊类型  00 门诊，01 急诊，02 体检：10 住院；空串表示全部       
     * @return
     * @throws DAException 
     */
    public EntInfoDTO[] exec(String dtBegin, String dtEnd, String deptCode, String entcode, String entpCode) throws DAException {
        // 记录输入参数日志
        EnLogUtil.getInstance().logInfo("方法：GetEntListByDeptCodeBP参数为:dtBegin:" + dtBegin + "dtEnd:" + dtEnd + "deptCode:" + deptCode + "entcode:" + entcode + "entpCode:" + entpCode);
       
        // 参数校验
        if (EnValidator.isEmpty(dtBegin)
				|| EnValidator.isEmpty(dtEnd)) {
			return null;
		}
        String dtBeginStr = dtBegin.substring(0, 10) + " 00:00:00";
		String dtEndStr = dtEnd.substring(0, 10) + " 00:00:00";	
        EntInfoDTO[] entInfoDTOs = this.getEntInfoDTOSql(dtBeginStr,dtEndStr,deptCode,entcode,entpCode);
        return entInfoDTOs;
    }

    /***
     * 查询就诊记录SQL
     * @author fanlq 
     * @param dtBegin
     * @param dtEnd
     * @param deptCode
     * @param entcode
     * @param entpCode
     * @return
     * @throws DAException
     */
    private EntInfoDTO[] getEntInfoDTOSql(String dtBegin, String dtEnd, String deptCode, String entcode, String entpCode) throws DAException {
    	StringBuilder sqlSb = new StringBuilder();
        SqlParam param = new SqlParam();
        sqlSb.append("select distinct pat.code as patCode,op.times_op as opTimes,ip.times_ip as ipTimes,");
        sqlSb.append("ent.code_entp as entpCode,ent.dt_acpt as dtAcpt,ca.code as patCaCode,");
        sqlSb.append("pri.code as patPriCode,hp.no_hp as hpNo,");
        sqlSb.append("case when op.fg_first = 'Y' then 1 else 0 end as fgFirst,");
        sqlSb.append("srv.code as srvCode,srv.name as srvName,dep.code as deptCode,");
        sqlSb.append("doc.code as empPhyCode,substr(ent.dt_entry,0,10) as dtEntry,");
        sqlSb.append("case when aop.id_en = '~' then  0 else 1 end as  isApt,");
        sqlSb.append("case when dayslot.code = '1001' then 'am' when dayslot.code = '1003' then 'pm' end as ampm,");
        sqlSb.append("case when ent.fg_canc = 'N' then 0 when ent.fg_canc = 'Y' then 1 end as fg_canc,");//退号标志，fanlq-2018-04-25
        sqlSb.append("op.ticketno as tickNo,nvl(op.sd_status,ip.sd_status) as statusCode,ent.code as entCode ");
        sqlSb.append(" from en_ent ent ");
        sqlSb.append(" left join pi_pat pat on pat.id_pat = ent.id_pat");
        sqlSb.append(" left join bd_dep dep on dep.id_dep = ent.id_dep_phy");
        sqlSb.append(" left join en_ent_op op on op.id_ent = ent.id_ent");
        sqlSb.append(" left join en_ent_ip ip on ip.id_ent = ent.id_ent");
        sqlSb.append(" left join pi_pat_ca ca on ca.id_patca = ent.id_patca");
        sqlSb.append(" left join bd_pri_pat pri on pri.id_pripat = pat.id_patpritp");
        sqlSb.append(" left join pi_pat_hp hp on hp.id_pat = pat.id_pat");
        sqlSb.append(" left join sc_srv srv on srv.id_scsrv = op.id_scsrv");
        sqlSb.append(" left join bd_psndoc doc on op.id_emp_reg = doc.id_psndoc");
        sqlSb.append(" left join sc_apt apt on apt.id_pat = ent.id_pat");
        sqlSb.append(" left join sc_apt_op aop on aop.id_apt = apt.id_apt");
        sqlSb.append(" left join bd_dayslot dayslot on dayslot.id_dayslot = op.id_dateslot");
        sqlSb.append(" where 1=1 ");
        if(!EnValidator.isEmpty(dtBegin)){
        	sqlSb.append(" and ent.dt_entry >= ? ");
        	param.addParam(dtBegin);
        }
        if(!EnValidator.isEmpty(dtEnd)){
        	sqlSb.append(" and ent.dt_entry <= ?");
        	param.addParam(dtEnd);
        }
        if(!EnValidator.isEmpty(deptCode)){
        	sqlSb.append(" and dep.code = ? ");
        	param.addParam(deptCode);
        }
        if(!EnValidator.isEmpty(entcode)){
        	sqlSb.append(" and ent.code = ? ");
        	param.addParam(entcode);
        }
        if(!EnValidator.isEmpty(entpCode)){
        	sqlSb.append(" and ent.code_entp = ? ");
        	param.addParam(entpCode);
        }
        sqlSb.append(" order by dtEntry desc ");
        @SuppressWarnings("unchecked")
		List<EntInfoDTO> entList = (List<EntInfoDTO>) new DAFacade().execQuery(sqlSb.toString(), param, new BeanListHandler(EntInfoDTO.class));   
        if(entList != null && !entList.isEmpty()){
        	return entList.toArray(new EntInfoDTO[0]);
        }
    	return null;
    }
}
