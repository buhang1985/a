package iih.bd.fc.orderexesigndict.s.bp;

import iih.bd.fc.orderexesigndict.s.bp.qry.getListSql;
import iih.bd.fc.orpltp.d.OrpltpStaDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;

public class getListbp {

	/**
	 * zhurou 
	 * @return
	 * @throws BizException
	 */
	public OrpltpStaDO[] exec() throws BizException {

		getListSql Sql = new getListSql();

		OrpltpStaDO[] DO = (OrpltpStaDO[]) AppFwUtil.getDORstWithDao(Sql, OrpltpStaDO.class);

		return DO;

	}
}
