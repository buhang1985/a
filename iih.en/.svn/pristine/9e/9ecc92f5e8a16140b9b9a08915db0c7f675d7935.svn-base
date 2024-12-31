package iih.en.pv.s.bp.ip;

import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.en.comm.validator.EnValidator;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取住院患者转出科室时间
 * 
 * @author jizb
 *
 */
public class GetIpTransOutDateBP {
	/**
	 * 住院患者转出科室时间
	 * 
	 * @param id_ent 就诊id
	 * @param id_dep 科室id
	 * @return
	 * @throws BizException
	 */
	public FDateTime exec(String id_ent, String id_dep) throws DAException {
		//校验入参是否为空
		if (EnValidator.isEmpty(id_dep) || EnValidator.isEmpty(id_ent))
			return null;
		StringBuilder sb = new StringBuilder();
		sb.append("select max(dt_e) ");
		sb.append("from en_ent ent ");
		sb.append("inner join en_ent_dep dep on ent.id_ent = dep.id_ent ");
		sb.append("where ent.id_ent = ? ");
		sb.append("and dep.id_dep = ? ");
		sb.append("and dep.id_dep_to is not null ");
		sb.append("and dep.id_dep_to <> '~' ");
		sb.append("and dep.sd_status = '" + IEnDictCodeConst.SD_ENTDEP_STATUS_SUC + "' ");
		SqlParam param = new SqlParam();
		param.addParam(id_ent);
		param.addParam(id_dep);
		String str = (String)new DAFacade().execQuery(sb.toString(), param, new ColumnHandler());
		if (EnValidator.isEmpty(str))
			return null;
		FDateTime dtEnd = new FDateTime(str);
		return dtEnd;
	}

}
