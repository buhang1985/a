package iih.ci.mr.s.bp;

import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;
import iih.ci.mr.cimrpatsigns.d.PatDTO;
import iih.ci.mr.cimrpatsigns.d.Patparam;
import iih.ci.mr.s.bp.qry.FindPatDTOSql;

public class FindPatDTOBp {

	/**
	 * 生命体征批量录入患者列表查询
	 * 
	 * @param code_entp
	 * @param sd_status
	 * @param id_dep_nur
	 * @param whereType
	 * @param key
	 * @return
	 * @throws BizException
	 */
	public PatDTO[] exec(Patparam patparam) throws BizException {

		FindPatDTOSql sqlPara = new FindPatDTOSql(patparam);

		PatDTO[] rtn = (PatDTO[]) AppFwUtil.getDORstWithDao(sqlPara, PatDTO.class);
		CalculationRule rule = new CalculationRule();
		return rule.exec(rtn, patparam);
	}

	
}
