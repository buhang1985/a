package iih.bd.res.opt.s;

import iih.bd.res.opt.i.IOptServiceExt;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;

@Service(serviceInterfaces = { IOptServiceExt.class }, binding = Binding.JSONRPC)
public class OptServiceExtImpl implements IOptServiceExt {

	@Override
	public FArrayList getOptCountByDepId() {
		StringBuilder sqlStr = new StringBuilder();
		sqlStr.append("select ");
		sqlStr.append("(select count(opt.id_opt) from bd_opt opt where opt.id_dep_belong = dep.id_dep) as Optcount,");
		sqlStr.append("dep.* ");
		sqlStr.append("from bd_dep dep ");
		sqlStr.append("where dep.sd_depttp like '03%' and dep.ds='0' and dep.activestate='2'");

		// sqlStr.append("select opt.id_dep_belong as Id_dep,count(id_opt) as Optcount ");
		// sqlStr.append("from bd_opt opt ");
		// sqlStr.append("where opt.ds='0' ");
		// sqlStr.append("group by opt.id_dep_belong ");

		FArrayList rtn;
		try {
			rtn = AppFwUtil.getMapListWithDao(sqlStr.toString());
			return rtn;
		} catch (BizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int checkOpertCode(String opertCode) throws DAException {
		StringBuilder sqlStr = new StringBuilder();
		sqlStr.append("SELECT COUNT(*) FROM BD_OPT OPT WHERE OPT.CODE=?");
		sqlStr.append(" AND OPT.DS='0'");
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(opertCode);
		Object result = new DAFacade().execQuery(sqlStr.toString(), sqlParam,
				new ColumnHandler());
		return (int) result;
	}
}
