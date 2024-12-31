package iih.bl.pay.blpaypat.bp;

import iih.bl.pay.blpaypat.qry.BlPaypatRExtQry;
import iih.bl.pay.blpaypat.qry.BlPrePayRExtQry;
import iih.bl.pay.dto.blprepaydto.d.BlPrepayDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;

public class FindByDtoPageInfoBp {
	
	/**
	 * 预交金Dto分页分组查询数据
	 * @param pg
	 * @param whereStr
	 * @param orderStr
	 * @return
	 * @throws BizException
	 * @author F 2019年3月5日
	 */
	public PagingRtnData<BlPrepayDTO> exec(PaginationInfo pg,String Sd_cctp, String whereStr, String orderStr) throws BizException {
		PagingRtnData<BlPrepayDTO> pageFeeDTO = new PagingRtnData<BlPrepayDTO>();
		PagingServiceImpl<BlPrepayDTO> service = new PagingServiceImpl<BlPrepayDTO>();
		BlPrePayRExtQry qry = new BlPrePayRExtQry(whereStr, orderStr, Sd_cctp);
		pageFeeDTO = service.findByPageInfo(new BlPrepayDTO(), pg, qry.getQrySQLStr(), "", qry.getQryParameter(null));
		return pageFeeDTO;
	}
}
