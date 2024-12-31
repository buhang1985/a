package iih.bd.fc.mdwfcfg.s.bp;

import iih.bd.fc.mdwfcfg.d.MdwftreeDTO;
import iih.bd.fc.mdwfcfg.s.bp.qry.getListSql;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;


public class getListbp {

	/*
	 *  获取个性化医嘱流向树列表
	 */
	public MdwftreeDTO[] exec() throws BizException {
		
		getListSql Sql = new getListSql();

		MdwftreeDTO[] DTOS = (MdwftreeDTO[]) AppFwUtil.getDORstWithDao(Sql, MdwftreeDTO.class);

		return DTOS;
	}
}
