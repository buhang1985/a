package iih.bd.srv.mrbasetpl.s;

import iih.bd.srv.mrbasetpl.bp.FillEmrBaseTplFsBp;
import iih.bd.srv.mrbasetpl.d.EmrBaseTplDO;
import iih.bd.srv.mrbasetpl.i.IMrBaseTplService;
import iih.bd.srv.mrbasetpl.i.IMrbasetplRService;
import iih.bd.srv.mrbasetpl.s.bp.FindMrTplCountByBaseTplIdBp;
import iih.bd.srv.mrbasetpl.s.bp.FindPagingDataByQCondAndWherePartBp;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
import xap.sys.custcfg.billcode.i.IBillcodeManage;

/**
 * 医疗记录基础模板自定义保存服务实现
 * 
 * @author hao_wu
 *
 */
public class MrBaseTplServiceImpl implements IMrBaseTplService {

	@Override
	public PagingRtnData<EmrBaseTplDO> findByPageInfo(PaginationInfo pg, String wherePart, String orderByPart)
			throws BizException {
		IMrbasetplRService mrbasetplRService = ServiceFinder.find(IMrbasetplRService.class);
		PagingRtnData<EmrBaseTplDO> pagingRtnData = mrbasetplRService.findByPageInfo(pg, wherePart, orderByPart);
		if (pagingRtnData != null) {
			@SuppressWarnings("unchecked")
			EmrBaseTplDO[] pageData = (EmrBaseTplDO[]) pagingRtnData.getPageData().toArray(new EmrBaseTplDO[0]);
			FillEmrBaseTplFsBp bp = new FillEmrBaseTplFsBp();
			bp.exec(pageData);
		}
		return pagingRtnData;
	}

	@Override
	public PagingRtnData<EmrBaseTplDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO, String orderStr,
			PaginationInfo pg) throws BizException {
		IMrbasetplRService mrbasetplRService = ServiceFinder.find(IMrbasetplRService.class);
		PagingRtnData<EmrBaseTplDO> pagingRtnData = mrbasetplRService.findByQCondAndPageInfo(qryRootNodeDTO, orderStr,
				pg);
		if (pagingRtnData != null) {
			@SuppressWarnings("unchecked")
			EmrBaseTplDO[] pageData = (EmrBaseTplDO[]) pagingRtnData.getPageData().toArray(new EmrBaseTplDO[0]);
			FillEmrBaseTplFsBp bp = new FillEmrBaseTplFsBp();
			bp.exec(pageData);
		}
		return pagingRtnData;
	}

	@Override
	public PagingRtnData<EmrBaseTplDO> findPagingDataByQCondAndWherePart(String wherePart,
			QryRootNodeDTO qryRootNodeDTO, String orderStr, PaginationInfo pg) throws BizException {
		FindPagingDataByQCondAndWherePartBp bp = new FindPagingDataByQCondAndWherePartBp();
		PagingRtnData<EmrBaseTplDO> result = bp.exec(wherePart, qryRootNodeDTO, orderStr, pg);
		return result;
	}

	@Override
	public String getEmrBaseTplCode() throws BizException {
		IBillcodeManage BillcodeManage = ServiceFinder.find(IBillcodeManage.class);
		return BillcodeManage.getPreBillCode_RequiresNew(EmrBaseTplDO.class.getName());
	}

	@Override
	public void rollBackEmrBaseTplCode(String[] codes) throws BizException {
		IBillcodeManage BillcodeManage = ServiceFinder.find(IBillcodeManage.class);
		for (String code : codes) {
			// 没有批量回滚服务，暂时循环调用
			BillcodeManage.rollbackPreBillCode(EmrBaseTplDO.class.getName(), code);
		}
	}

	@Override
	public Integer findMrTplCountByBaseTplId(String baseTplId) throws BizException {
		FindMrTplCountByBaseTplIdBp bp = new FindMrTplCountByBaseTplIdBp();
		Integer mrTplCount = bp.exec(baseTplId);
		return mrTplCount;
	}

}
