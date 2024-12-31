package iih.en.pv.s.bp.ip.qry;

import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnLogUtil;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.inpatient.dto.d.PatientsDTO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;

/**
 * 住院医生站查询留观患者
 * 
 * @author Liubin
 */
public class GetEmgstayPatsBP {
	// 科室部门ID
	private static final String PARAM_DEP_ID = "@id_dep";
	// 人员ID
	private static final String PARAM_EMP_ID = "@id_emp";
	// 日期
	private static final String PARAM_DATA = "@date";
	// 时间
	private static final String PARAM_TIME = "@time";
	// 日期时间
	private static final String PARAM_DATA_TIME = "@datetime";

	/**
	 * 查询自定义患者
	 * 
	 * @param entPatListDO
	 *            自定义患者列表DO
	 * @param deptId
	 *            科室ID
	 * @param empId
	 *            医生ID
	 * @param code_entp
	 * @return 患者DTO集合
	 * @throws BizException
	 */
	public PatientsDTO[] exec(String deptId, String empId, String code_entp) throws BizException {
		if (EnValidator.isEmpty(deptId) || EnValidator.isEmpty(empId)) {
			return null;
		}
		List<String> list = getEntIdsList(deptId, empId, code_entp);
		if (!EnValidator.isEmpty(list)) {
			return new GetIpDocStationPatsBP().exec(list, empId);
		}
		return null;
	}

	/**
	 * 得到自定义患者的就诊ID集合
	 * 
	 * @param entPatListDO
	 * @param deptId
	 * @param empId
	 * @return
	 * @throws BizException
	 */
	private List<String> getEntIdsList(String deptId, String empId, String code_entp) throws BizException {
		String sql = this.getSql();
		FDateTime dateTime = EnAppUtils.getServerDateTime();
		sql = sql.replaceAll(PARAM_DEP_ID, String.format("'%s'", deptId));
		sql = sql.replaceAll(PARAM_EMP_ID, String.format("'%s'", empId));
		sql = sql.replaceAll(PARAM_DATA, String.format("'%s'", dateTime.getDate().toString()));
		sql = sql.replaceAll(PARAM_TIME, String.format("'%s'", dateTime.getTime()));
		sql = sql.replaceAll(PARAM_DATA_TIME, String.format("'%s'", dateTime.toString()));
		List<String> list = null;
		try {
			EnLogUtil.getInstance().logInfo("住院医生站查询留观患者【" + sql + "】");
			list = (List<String>) new DAFacade().execQuery(sql, new ColumnListHandler());
		} catch (BizException e) {
			EnLogUtil.getInstance().logError("住院医生站查询留观患者【" + sql + "】", e);
			return null;
			// throw new BizException(IEnErrorMsgConst.ERROR_CUSTOMPAT_SQL);
		}
		return list;
	}

	/**
	 * 获取sql
	 * 
	 * @return
	 */
	private String getSql() {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT DISTINCT EN.ID_ENT").append(" FROM EN_ENT EN")
				.append(" INNER JOIN CI_ORDER ORD ON EN.ID_ENT = ORD.ID_EN").append(" WHERE EN.CODE_ENTP IN ('0103')")
				.append(" AND EN.FG_IP = 'Y'").append(" AND EN.FG_CANC = 'N'").append(" AND ORD.FG_CHK = 'Y'")
				.append(" AND ORD.FG_CANC = 'N'").append(" AND ORD.SD_SRVTP NOT LIKE '01%'")
				.append(" AND ORD.ID_DEP_MP = @id_dep");
		return sql.toString();
	}
}
