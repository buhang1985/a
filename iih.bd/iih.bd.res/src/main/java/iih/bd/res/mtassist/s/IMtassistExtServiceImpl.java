package iih.bd.res.mtassist.s;

import iih.bd.res.mtassist.i.IMtassistExtService;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 医技辅资源服务
 * 
 * @author wjy
 *
 */
@Service(serviceInterfaces = { IMtassistExtService.class }, binding = Binding.JSONRPC)
public class IMtassistExtServiceImpl implements IMtassistExtService {

	@Override
	public FArrayList getDeptWithMTCount() {
		StringBuilder sqlStr = new StringBuilder();
		sqlStr.append("select ");
		sqlStr.append("(select count(mt.id_mt) from bd_mt mt where mt.id_dep_belong = dep.id_dep) as Optcount,");
		sqlStr.append("dep.* ");
		sqlStr.append("from bd_dep dep ");
		sqlStr.append("where dep.sd_depttp like '03%' and dep.ds='0' and dep.activestate='2'");

		FArrayList rtn;
		try {
			rtn = AppFwUtil.getMapListWithDao(sqlStr.toString());
			return rtn;
		} catch (BizException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int checkMtassistCode(String mtCode) throws DAException {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("SELECT COUNT(*) FROM BD_MT MT WHERE MT.CODE=?");
		sqlBuilder.append(" AND MT.DS='0'");

		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(mtCode);
		Object result = new DAFacade().execQuery(sqlBuilder.toString(),
				sqlParam, new ColumnHandler());

		return (int) result;
	}

}
