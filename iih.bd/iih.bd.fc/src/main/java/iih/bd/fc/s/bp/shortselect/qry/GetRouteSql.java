package iih.bd.fc.s.bp.shortselect.qry;

import iih.bd.fc.dto.shortselect.d.CardCondDTO;
import iih.bd.fc.s.bp.common.BdFcEnvContextUtil;
import iih.bd.fc.s.bp.common.WfUtils;
import iih.bd.srv.medusage.d.MedUsageDO;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * @Description:查询用法信息
 * @author: xu_xing@founder.com.cn
 * @version：2019年3月14日 下午4:21:09 创建
 */
public class GetRouteSql implements ITransQry {

	private CardCondDTO cond;
	private String[] id_keys;

	public GetRouteSql(CardCondDTO cond, String[] id_keys) {
		this.cond = cond;
		this.id_keys = id_keys;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
		if (!StringUtil.isEmptyWithTrim(this.cond.getId_route()))
			param.addParam(this.cond.getId_route());
		if (this.id_keys != null && this.id_keys.length > 0)
			WfUtils.setSqlParam(param, this.id_keys);
		if (!StringUtil.isEmptyWithTrim(this.cond.getKey())) {
			param.addParam("%" + this.cond.getKey() + "%");
			param.addParam("%" + this.cond.getKey() + "%");
			param.addParam("%" + this.cond.getKey() + "%");
			param.addParam("%" + this.cond.getKey() + "%");
			param.addParam("%" + this.cond.getKey() + "%");
		}
		return param;
	}

	@Override
	public String getQrySQLStr() {
		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append(" select                  ");
		sqlStr.append(" route.id_route as id,   ");
		sqlStr.append(" route.code,             ");
		sqlStr.append(" route.name,             ");
		sqlStr.append(" 'Y' as fg_display       ");
		sqlStr.append(" from bd_route route     ");
		sqlStr.append(" where route.ds = 0      ");
		sqlStr.append(" and " + new BdFcEnvContextUtil().getWherePart(new MedUsageDO(), "route"));
		if (!StringUtil.isEmptyWithTrim(this.cond.getId_route()))
			sqlStr.append(" and route.id_route = ?   ");
		String whereNotIn = WfUtils.getSqlParamChars(this.id_keys);
		if (!StringUtil.isEmptyWithTrim(whereNotIn))
			sqlStr.append(" and route.id_route not in (" + whereNotIn + ")   ");
		if (!StringUtil.isEmptyWithTrim(this.cond.getKey())) {
			sqlStr.append(" and                     ");
			sqlStr.append(" (                       ");
			sqlStr.append(" route.code like ?       ");
			sqlStr.append(" or route.name like ?    ");
			sqlStr.append(" or route.pycode like ?  ");
			sqlStr.append(" or route.wbcode like ?  ");
			sqlStr.append(" or route.mnecode like ? ");
			sqlStr.append(" )                       ");
		}
		sqlStr.append(" order by route.code asc ");
		return sqlStr.toString();
	}
}
