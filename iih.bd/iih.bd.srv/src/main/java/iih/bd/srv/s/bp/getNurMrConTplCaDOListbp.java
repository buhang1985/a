package iih.bd.srv.s.bp;

import iih.bd.srv.nurmrtpl.d.NurMrConTplCaDO;
import iih.bd.srv.s.bp.qry.getNurMrConTplCaDOListSql;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;

public class getNurMrConTplCaDOListbp {

	/**
	 * 护理记录内容模板维护树列表
	 * @return
	 * @throws BizException
	 */
	public NurMrConTplCaDO[] exec() throws BizException {

		getNurMrConTplCaDOListSql Sql = new getNurMrConTplCaDOListSql();

		NurMrConTplCaDO[] DTOS = (NurMrConTplCaDO[]) AppFwUtil.getDORstWithDao(Sql, NurMrConTplCaDO.class);

		return DTOS;
	}
}
