package iih.bl.pay.blpaypat.bp;

import iih.bl.pay.blpaypat.d.BlPrePayPatDO;
import iih.bl.pay.blpaypat.qry.BlPaypatRExtQry;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;

public class FindByPageInfoBp {
/**
 * 预交金分页查询
 * @param pg
 * @param whereStr
 * @param orderStr
 * @return
 * @throws BizException
 * @author liwenqiang
 */
	public PagingRtnData<BlPrePayPatDO> exec(PaginationInfo pg, String whereStr, String orderStr) throws BizException {
		PagingRtnData<BlPrePayPatDO> pageFeeDTO = new PagingRtnData<BlPrePayPatDO>();
		PagingServiceImpl<BlPrePayPatDO> service = new PagingServiceImpl();
		BlPaypatRExtQry qry = new BlPaypatRExtQry(whereStr, orderStr, FBoolean.FALSE);
		pageFeeDTO = service.findByPageInfo(new BlPrePayPatDO(), pg, qry.getQrySQLStr(), "", qry.getQryParameter(null));
		return pageFeeDTO;

	}

}
