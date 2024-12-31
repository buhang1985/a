package iih.ci.ord.s.external.provide.bp.mr;

import java.util.ArrayList;
import java.util.List;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.ci.ord.i.external.provide.meta.mr.OutHospOrderInfoDTO;
import iih.ci.ord.i.external.provide.meta.mr.d.CiOrdInfoDTO;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 患在相关信息
 * 
 * @author HUMS
 *
 */
public class PatOrderInfoBP {

	/**
	 * 获取患者死亡医嘱时间
	 * 医生签署即可，不需要护士确认
	 * @param id_en
	 * @return
	 * @throws DAException
	 */
	public FDateTime getPatDeathTime(String id_en) throws DAException {

		List<FDateTime> dtEffeList = this.getDtEffeByIden(id_en, IBdSrvDictCodeConst.SD_SRVTP_PATIMAN_CLIDEATH);

		if (dtEffeList != null && dtEffeList.size() > 0) {
			return dtEffeList.get(0);
		}
		return null;
	}

	/**
	 * 获取出院医嘱生效时间<br>
	 * 医生签署即可，不需要护士确认
	 * @param id_en
	 * @return
	 * @throws DAException
	 */
	public FDateTime getPatLeaveHospitalTime(String id_en) throws DAException {

		List<FDateTime> dtEffeList = this.getDtEffeByIden(id_en, IBdSrvDictCodeConst.SD_SRVTP_PATIMAN_LEAVEHOS);

		if (dtEffeList != null && dtEffeList.size() > 0) {
			return dtEffeList.get(0);
		}
		return null;
	}
	
	/**
	 * 获取一次就诊指定服务类型医嘱的生效时间
	 * @param id_en
	 * @param sd_srvtp
	 * @return
	 * @throws DAException
	 */
	private List<FDateTime> getDtEffeByIden(String id_en,String sd_srvtp) throws DAException{
		
		List<FDateTime> dtEffeList = new ArrayList<FDateTime>();
		DAFacade fdacade = new DAFacade();
		SqlParam param = new SqlParam();
		param.addParam(id_en);
		param.addParam(sd_srvtp);
		
		StringBuffer sb = new StringBuffer();
		sb.append(" select dt_effe from ci_order where id_en = ? and sd_srvtp = ? ");
		sb.append(" and fg_sign='Y' and fg_canc='N' order by dt_effe desc");
		List<String> dtEffeStrlist = (List<String>) fdacade.execQuery(sb.toString(), param, new ColumnListHandler());
		for(String dateStr : dtEffeStrlist){
			dtEffeList.add(new FDateTime(dateStr));
		}
		
		return dtEffeList;
	}
	
	/**
	 * 获取一次就诊出院、死亡类型医嘱信息
	 * @param id_en
	 * @param sd_srvtp
	 * @return
	 * @throws DAException
	 */
	public List<OutHospOrderInfoDTO> getOutHospitalInfoByIdEn(String id_en) throws DAException{
		
		List<OutHospOrderInfoDTO> outHospList = new ArrayList<OutHospOrderInfoDTO>();
		DAFacade fdacade = new DAFacade();
		SqlParam param = new SqlParam();
		param.addParam(id_en);
		param.addParam(IBdSrvDictCodeConst.SD_SRVTP_PATIMAN_CLIDEATH);
		param.addParam(IBdSrvDictCodeConst.SD_SRVTP_PATIMAN_LEAVEHOS);	
		
		StringBuffer sb = new StringBuffer();
		sb.append(" select ord.id_or,ord.dt_effe as dt_out,ord.id_dep_or, dep.code as code_dep_or,dep.name as name_dep_or,ord.id_dep_nur_or as id_nur_or, ")
		.append(" nur.code as code_nur_or, nur.name as name_nur_or,ord.id_emp_or, usern.code as code_emp_or, psn.name as name_emp_or, ")
		.append(" apout.id_outtp,apout.sd_outtp,udi.name as name_outtp")
		.append(" from ci_order ord ")
		.append(" left outer join bd_dep dep on dep.id_dep=ord.id_dep_or ")
		.append(" left outer join bd_dep nur on nur.id_dep=ord.id_dep_nur_or ")
		.append(" left outer join bd_psndoc psn on psn.id_psndoc=ord.id_emp_or")
		.append(" left outer join sys_user usern on usern.id_psn=ord.id_emp_or")
		.append(" left outer join ci_ap_out apout on apout.id_or=ord.id_or ")
		.append(" left outer join bd_udidoc udi on udi.id_udidoc=apout.id_outtp ");
		sb.append(" where ord.id_en = ? and ( ord.sd_srvtp = ? or  ord.sd_srvtp = ? ) ");
		sb.append(" and ord.fg_sign='Y' and ord.fg_canc='N' order by dt_effe desc");
		List<OutHospOrderInfoDTO> rtnlist = (List<OutHospOrderInfoDTO>) fdacade.execQuery(sb.toString(), param, new BeanListHandler(OutHospOrderInfoDTO.class));
		for(OutHospOrderInfoDTO rtnDto : rtnlist){
			outHospList.add(rtnDto);
		}
		
		return outHospList;
	}
	
	@SuppressWarnings("unchecked")
	public List<CiOrdInfoDTO> geCiOrdInfoDTOs(String id_en) throws DAException {
		
		DAFacade fdacade = new DAFacade();
		SqlParam param = new SqlParam();
		param.addParam(id_en);
		StringBuilder sb = new StringBuilder();
		sb.append("select c.sd_srvtp orderTypecode, b.name orderTypeName,c.dt_effe orderPlanStartDate,c.dt_end orderPlanEndDate, ")
		.append("c.dt_last_mp executeTime,dep.name executeDeptName, doc3.code executePersonCode,doc3.name executePersonName, ")
		.append("c.dt_entry orderTime,doc.code orderDocCode,doc.name orderDocName,dep1.name orderDeptName,c.dt_chk orderConfirmDate, ")
		.append("doc1.code confirmDocCode,doc1.name confirmDocName,c.dt_canc cancelTime,doc2.code cancelPerson, ")
		.append("doc2.name cancelPersonName,c.des_or orderRemarks,b1.name orderStatus,c.content_or orderContent  ")
		.append("from ci_order c ")
		.append("left join bd_udidoc b on c.id_srvtp = b.id_udidoc ")
		.append("left join bd_udidoc b1 on c.id_su_mp = b1.id_udidoc ")
		.append("left join bd_dep dep on c.id_dep_mp = dep.id_dep ")
		.append("left join bd_dep dep1 on c.id_dep_or = dep1.id_dep ")
		.append("left join bd_psndoc doc on c.id_emp_or = doc.id_psndoc ")
		.append("left join bd_psndoc doc1 on c.id_emp_chk = doc1.id_psndoc ")
		.append("left join bd_psndoc doc2 on c.id_emp_canc = doc2.id_psndoc ")
		.append("left join mp_or_nur nur on nur.id_or = c.id_or ")
		.append("left join bd_psndoc doc3 on nur.id_emp_oper = doc3.id_psndoc ")
		.append("where c.code_entp = '00' and c.id_en = ?  ");
		
		List<CiOrdInfoDTO> rtnlist = (List<CiOrdInfoDTO>) fdacade.execQuery(sb.toString(), param, new BeanListHandler(CiOrdInfoDTO.class));
		
		return rtnlist;
	}
}
