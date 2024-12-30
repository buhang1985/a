package iih.sc.sch.s.bp.mt.apt.bp;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class GetSchproptpKinditmBP {

	/**
	 * 根据排班id查询排班计划中的号源释放规则中的类别明细属性的类别明细
	 * @param id_sch
	 * @return
	 * @throws DAException 
	 */
	public String exec(String id_sch) throws DAException
	{
		StringBuilder sql = new StringBuilder();
		sql.append(" select itm.ids_scsrvkinditm ");
		sql.append(" from sc_sch sch  ");
		sql.append(" inner join sc_pl pl on pl.id_scpl = sch.id_scpl ");
		sql.append(" inner join sc_release_rule_itm itm on itm.id_release_rule = pl.id_release_rule ");
		sql.append(" where itm.id_sch_prop_tp = ? ");
		sql.append(" and sch.fg_auto_release = 'Y' ");
		sql.append(" and sch.id_sch = ? ");
		SqlParam params = new SqlParam();
		params.addParam(IScDictCodeConst.ID_SCHPROPTP_KINDITM);
		params.addParam(id_sch);
		String itms = (String) new DAFacade().execQuery(sql.toString(), params, new ColumnHandler());
		return itms;
	}
}
