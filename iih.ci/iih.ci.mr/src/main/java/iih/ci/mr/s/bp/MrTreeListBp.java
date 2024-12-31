package iih.ci.mr.s.bp;

import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;
import iih.bd.srv.d.RefItemDTO;
import iih.ci.mr.d.MrTreeListDTO;
import iih.ci.mr.s.bp.qry.MrTreeListSql;

public class MrTreeListBp {
	
	
	public MrTreeListDTO[] exe()throws BizException{
		
		MrTreeListSql sql = new MrTreeListSql();
		
		MrTreeListDTO[] rtn=(MrTreeListDTO[])AppFwUtil.getDORstWithDao(sql, MrTreeListDTO.class);
		return rtn;
	}

}
