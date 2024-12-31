package iih.bd.srv.ems.s;

import iih.bd.srv.ems.bp.EmsprntmplDynamicBp;
import iih.bd.srv.ems.d.EmsPrnTmplDO;
import iih.bd.srv.ems.d.EmsprntmplAggDO;
import iih.bd.srv.ems.i.IEmsprntmplExtService;
import iih.bd.srv.ems.i.IEmsprntmplMDORService;
import iih.bd.srv.ems.i.IEmsprntmplRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;

public class EmsprntmplExtServiceImpl implements IEmsprntmplExtService {

	@Override
	public PagingRtnData<EmsPrnTmplDO> findByPageInfo(PaginationInfo pg, String wherePart, String orderByPart)
			throws BizException {
		IEmsprntmplMDORService emsprntmplMDORService= ServiceFinder.find(IEmsprntmplMDORService.class);
		PagingRtnData<EmsPrnTmplDO> pageData= emsprntmplMDORService.findByPageInfo(pg, wherePart, orderByPart);
		FArrayList pageDataList= pageData.getPageData();
		EmsprntmplDynamicBp bp=new EmsprntmplDynamicBp();
		bp.exec(pageDataList);
		return pageData;
	}

	@SuppressWarnings("unchecked")
	@Override
	public EmsprntmplAggDO findById(String id) throws BizException {
		IEmsprntmplRService emsprntmplRService= ServiceFinder.find(IEmsprntmplRService.class);
		EmsprntmplAggDO emsprntmplAggDO= emsprntmplRService.findById(id);
		FArrayList dataList=new FArrayList();
		dataList.add(emsprntmplAggDO.getParentDO());
		EmsprntmplDynamicBp bp=new EmsprntmplDynamicBp();
		bp.exec(dataList);
		return emsprntmplAggDO;		
	}

}
