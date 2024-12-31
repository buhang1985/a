package iih.bd.fc.wf.s.bp;

import iih.bd.fc.wf.d.WfDO;
import iih.bd.fc.wf.i.IWfMDORService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;

/**
 * 获取医嘱流程主DO分页数据业务逻辑
 * 
 * @author hao_wu
 */
public class getWfDoPageDataBp {

	/**
	 * 医嘱流向配置，获取流向分页列表
	 * 
	 * @param pg
	 * @param wherePart
	 * @param orderByPart
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<WfDO> exec(PaginationInfo pg, String wherePart, String orderByPart) throws BizException {

		// 1、检索数据
		PagingRtnData<WfDO> wfDoList = getWfDOPageData(pg, wherePart, orderByPart);

		// 2、组装数据
		packageWfMDOS(wfDoList);
		
		return wfDoList;
	}

	/**
	 * 包装医嘱流向分页信息_设置主表服务类型
	 * 
	 * @param wfDoList
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private void packageWfMDOS(PagingRtnData<WfDO> wfDoList) throws BizException {
		WfDO[] wfArray = (WfDO[]) wfDoList.getPageData().toArray(new WfDO[] {});
		packageWfMDOBp bp = new packageWfMDOBp();
		for (WfDO wfDo : wfArray) {
			bp.exec(wfDo, null);
		}
	}

	/**
	 * 查询医嘱流向分页数据
	 * 
	 * @param pg
	 * @param wherePart
	 * @param orderByPart
	 * @return
	 * @throws BizException
	 */
	private PagingRtnData<WfDO> getWfDOPageData(PaginationInfo pg, String wherePart, String orderByPart)
			throws BizException {
		IWfMDORService wfMdoRService = ServiceFinder.find(IWfMDORService.class);
		return wfMdoRService.findByPageInfo(pg, wherePart, orderByPart);
	}
}
