package iih.ci.mr.s.bp;

import iih.bd.srv.billtypedto.d.BillTypeDto;
import iih.bd.srv.mrfpbltype.d.MrFpBlTypeDO;
import iih.ci.mr.s.bp.qry.MrFpBlTypeSql;
import xap.mw.core.data.BizException;

/**
 * 获取费用分类修改后数据。
 * 
 * @author tangws
 *
 */
public class MrFpBlTypeBP {
	public BillTypeDto[] setMmDTO(MrFpBlTypeDO[] mrlist, String eventtype)
			throws BizException {
		// 获得费用分类数据信息
		MrFpBlTypeSql sql = new MrFpBlTypeSql();
		BillTypeDto[] btypedtos = sql.setEventStatus(mrlist, eventtype);
		return btypedtos;

	}
}
