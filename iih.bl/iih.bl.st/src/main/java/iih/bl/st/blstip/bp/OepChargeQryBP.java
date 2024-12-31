package iih.bl.st.blstip.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import iih.bd.base.utils.SqlUtils;
import iih.bl.st.dto.d.BlAuditIncInfoDTO;
import iih.bl.st.dto.d.BlIpAuditStPayInfoDTO;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取门诊发票信息(门诊费用综合查询)
 * @author:hanjq
 * @date  :2020年7月4日
 */
public class OepChargeQryBP {

	/**
	 * 查询发票
	 * @description:
	 * @author:hanjq  2020年7月6日
	 * @param id_stoep
	 * @return
	 * @throws DAException
	 */
	public BlAuditIncInfoDTO[] getBlCgOepInc(String id_stoep) throws DAException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT DISTINCT A.id_stoep ID_STIP,			");
		sql.append("	A.ID_ENT,		");
		sql.append("	C.ID_INCOEP   Id_inc,		");
		sql.append("	C.INCNO,		");
		sql.append("	C.DT_INC,		");
		sql.append("	C.AMT        AMT_INC,		");
		sql.append("	A.DT_ST,		");
		sql.append("	A.ID_EMP_ST,		");
		sql.append("	C.DT_INC     DT_PAY,		");
		sql.append("	B.ID_EMP_PAY,		");
		sql.append("	C.ID_EMP_INC,		");
		sql.append("	A.FG_CANC		");
		sql.append("FROM BL_ST_OEP A			");
		sql.append("INNER JOIN BL_PAY_PAT_OEP B		ON A.Id_Paypatoep = B.Id_Paypatoep	");
		sql.append("JOIN BL_INC_OEP C	ON A.id_stoep = C.id_stoep		");
		sql.append("WHERE A.id_stoep = ?			");
		SqlParam param = new SqlParam();
		param.addParam(id_stoep);

		@SuppressWarnings("unchecked")
		List<BlAuditIncInfoDTO> auditList = (List<BlAuditIncInfoDTO>) new DAFacade()
				.execQuery(sql.toString(), param, new BeanListHandler(
						BlAuditIncInfoDTO.class));
		if (auditList == null || auditList.size() == 0) {
			return new BlAuditIncInfoDTO[0];
		}
		HashSet<String> idPsnSet = new HashSet<>();
		for(BlAuditIncInfoDTO itm:auditList){
			if(StringUtils.isNotBlank(itm.getId_emp_inc())){
				idPsnSet.add(itm.getId_emp_inc());
			}
			if(StringUtils.isNotBlank(itm.getId_emp_st())){
				idPsnSet.add(itm.getId_emp_st());
			}
			if(StringUtils.isNotBlank(itm.getId_emp_pay())){
				idPsnSet.add(itm.getId_emp_pay());
			}
		}
		if(idPsnSet.size() > 0){
			String idPsnCond = SqlUtils.arrayToStr(idPsnSet.toArray(new String[0]));
			String sqlPsn = "select id_psndoc,name from bd_psndoc where id_psndoc in("+idPsnCond+")";
			DAFacade dAFacade = new DAFacade();
			@SuppressWarnings("unchecked")
			List<PsnDocDO> psnDocDOList = (List<PsnDocDO>) dAFacade.execQuery(sqlPsn, new BeanListHandler(PsnDocDO.class));
			HashMap<String, String> psnNameMap = new HashMap<>();
			for(PsnDocDO psn:psnDocDOList){
				psnNameMap.put(psn.getId_psndoc(), psn.getName());
			}			
			for(BlAuditIncInfoDTO itm:auditList){
				itm.setEmp_inc_name(psnNameMap.get(itm.getId_emp_inc()));
				itm.setEmp_pay_name(psnNameMap.get(itm.getId_emp_pay()));
				itm.setEmp_st_name(psnNameMap.get(itm.getId_emp_st()));
			}			
		}		
		return auditList.toArray(new BlAuditIncInfoDTO[0]);
	}

	/**
	 * 查询收付款信息
	 * @description:
	 * @author:hanjq  2020年7月6日
	 * @param id_stoep
	 * @return
	 * @throws DAException 
	 */
	@SuppressWarnings("unchecked")
	public BlIpAuditStPayInfoDTO[] getBlOepStPayInfo(String id_stoep) throws DAException {
		if (id_stoep == null) {
			return null;
		}
		// 1、查询收款信息
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT st.ID_STOEP id_stip,			");
		sql.append("	to_char(A.EU_DIRECT * A.AMT, '99999990.00') AMT,		");
		sql.append("	C.DT_PAY,		");
		sql.append("	B.NAME SD_PM_NAME,		");
		sql.append("	A.SD_PM,		");
		sql.append("	C.ID_EMP_PAY,		");
		sql.append("	D.NAME EMP_NAME_PAY,		");
		sql.append("	CASE     WHEN (A.SD_PM <> '05') THEN          '结算'		");
		sql.append("	WHEN (A.SD_PM = '05' AND A.EU_DIRECT < 0) THEN    '退预交金'		");
		sql.append("	WHEN (A.SD_PM = '05' AND A.EU_DIRECT > 0) THEN    '收预交金'		");
		sql.append("	END PAY_STATUS,		");
		sql.append("	E.CODE_REP PREPAYCODENO		");
		sql.append("FROM BL_PAY_ITM_PAT_OEP A			");
		sql.append("LEFT outer JOIN BD_PRI_PM B  ON A.ID_PM = B.ID_PM			");
		sql.append("JOIN BL_PAY_PAT_OEP C  ON A.ID_PAYPATOEP = C.ID_PAYPATOEP			");
		sql.append("INNER JOIN BD_PSNDOC D  ON C.ID_EMP_PAY = D.ID_PSNDOC			");
		sql.append("LEFT outer JOIN BL_PREPAY_PAT E  ON A.ID_PAYPAT = E.ID_PAYPAT			");
		sql.append("join bl_st_oep st on st.id_paypatoep = C.ID_PAYPATOEP			");
		sql.append("WHERE st.ID_STOEP = ?			");
		sql.append("ORDER BY E.DT_PAY			");

		SqlParam param = new SqlParam();
		param.addParam(id_stoep);

		List<BlIpAuditStPayInfoDTO> listDatas = new ArrayList<BlIpAuditStPayInfoDTO>();
		listDatas = (List<BlIpAuditStPayInfoDTO>) new DAFacade().execQuery(sql
				.toString(), param, new BeanListHandler(
				BlIpAuditStPayInfoDTO.class));

		if (listDatas == null || listDatas.size() <= 0) {
			return null;
		}

		BlIpAuditStPayInfoDTO[] datasArr = listDatas
				.toArray(new BlIpAuditStPayInfoDTO[] {});

		return datasArr;
	}

}
