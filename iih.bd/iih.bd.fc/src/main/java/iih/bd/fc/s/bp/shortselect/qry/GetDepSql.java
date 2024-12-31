package iih.bd.fc.s.bp.shortselect.qry;

import iih.bd.fc.dto.shortselect.d.CardCondDTO;
import iih.bd.fc.s.bp.common.BdFcEnvContextUtil;
import iih.bd.fc.s.bp.common.WfUtils;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.orgfw.dept.d.DeptDO;

/**
 * @Description:查询部门信息
 * @author: xu_xing@founder.com.cn
 * @version：2019年3月14日 下午4:21:09 创建
 */
public class GetDepSql implements ITransQry {

	private CardCondDTO cond;
	private String[] id_keys;

	public GetDepSql(CardCondDTO cond, String[] id_keys) {
		this.cond = cond;
		this.id_keys = id_keys;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
		if (!StringUtil.isEmptyWithTrim(this.cond.getId_dep()))
			param.addParam(this.cond.getId_dep());
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
		sqlStr.append(" select                   ");
		sqlStr.append(" dep.id_dep as id,        ");
		sqlStr.append(" dep.code,                ");
		sqlStr.append(" dep.name,                ");
		sqlStr.append(" 'Y' as fg_display        ");
		sqlStr.append(" from bd_dep dep          ");
		sqlStr.append(" where dep.ds = 0         ");
		sqlStr.append(" and " + new BdFcEnvContextUtil().getWherePart(new DeptDO(), "dep"));
		sqlStr.append(" and dep.activestate = 2  ");
		if (!StringUtil.isEmptyWithTrim(this.cond.getId_dep()))
			sqlStr.append(" and dep.id_dep = ?      ");
		String whereNotIn = WfUtils.getSqlParamChars(this.id_keys);
		if (!StringUtil.isEmptyWithTrim(whereNotIn))
			sqlStr.append(" and dep.id_dep not in (" + whereNotIn + ")   ");
		if (!StringUtil.isEmptyWithTrim(this.cond.getKey())) {
			sqlStr.append(" and                   ");
			sqlStr.append(" (                     ");
			sqlStr.append(" dep.code like ?       ");
			sqlStr.append(" or dep.name like ?    ");
			sqlStr.append(" or dep.pycode like ?  ");
			sqlStr.append(" or dep.wbcode like ?  ");
			sqlStr.append(" or dep.mnecode like ? ");
			sqlStr.append(" )                     ");
		}
		sqlStr.append(" order by dep.code asc    ");
		return sqlStr.toString();
	}
}
