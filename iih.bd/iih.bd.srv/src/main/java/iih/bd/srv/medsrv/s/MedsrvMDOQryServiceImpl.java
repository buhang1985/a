package iih.bd.srv.medsrv.s;

import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.i.IMedsrvMDOQryService;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import iih.bd.srv.medsrv.s.bp.FindPagingByTpsAndCaAndQCondBp;
import iih.bd.srv.medsrv.s.bp.SetAccSrvByMedsrvDOBp;
import iih.bd.srv.medsrv.s.bp.SetRealPriBp;
import iih.bd.srv.medsrv.s.bp.SetupInccaBp;
import iih.bd.srv.srvcate.d.SrvCateDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 医疗服务主DO查询服务
 * 
 * @author hao_wu
 *
 */
public class MedsrvMDOQryServiceImpl implements IMedsrvMDOQryService {

	@Override
	public PagingRtnData<MedSrvDO> findByPageInfo(PaginationInfo pg, String whereStr, String orderStr)
			throws BizException {
		PagingRtnData<MedSrvDO> result = getPageData(pg, whereStr, orderStr);
		SetRealPri(result);
		// MedSrvDO[] medSrvArr = getMedSrvArr(result);
		// setupIncca(medSrvArr);
		return result;
	}

	@Override
	public PagingRtnData<MedSrvDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO, String orderStr,
			PaginationInfo pg) throws BizException {
		PagingRtnData<MedSrvDO> result = getPageData(qryRootNodeDTO, orderStr, pg);
		SetRealPri(result);
		// MedSrvDO[] medSrvArr = getMedSrvArr(result);
		// setupIncca(medSrvArr);
		return result;
	}

	@Override
	public PagingRtnData<MedSrvDO> findByQCondAndPageInfoAndCondtion(QryRootNodeDTO qryRootNodeDTO, String orderStr,
			String condition, PaginationInfo pg) throws BizException {
		IMedsrvMDORService medsrvMDORService = ServiceFinder.find(IMedsrvMDORService.class);
		IQrySQLGeneratorService qrySQLGeneratorService = ServiceFinder.find(IQrySQLGeneratorService.class);
		String wherePart = qrySQLGeneratorService.getQueryStringWithDOName(qryRootNodeDTO, MedSrvDO.class.getName());
		if (wherePart == null) {
			wherePart = " 1=1 ";
		}
		wherePart += (" and " + condition);
		PagingRtnData<MedSrvDO> result = medsrvMDORService.findByPageInfo(pg, wherePart, orderStr);
		return result;
	}

	/**
	 * 获取分页数据
	 * 
	 * @param qryRootNodeDTO
	 * @param orderStr
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	private PagingRtnData<MedSrvDO> getPageData(QryRootNodeDTO qryRootNodeDTO, String orderStr, PaginationInfo pg)
			throws BizException {
		IMedsrvMDORService medsrvMDORService = ServiceFinder.find(IMedsrvMDORService.class);
		PagingRtnData<MedSrvDO> result = medsrvMDORService.findByQCondAndPageInfo(qryRootNodeDTO, orderStr, pg);
		return result;
	}

	/**
	 * 获取分页数据数组
	 * 
	 * @param result
	 * @return
	 */
	@SuppressWarnings("unused")
	private MedSrvDO[] getMedSrvArr(PagingRtnData<MedSrvDO> result) {
		FArrayList pagedataList = result.getPageData();
		@SuppressWarnings("unchecked")
		MedSrvDO[] medSrvArr = (MedSrvDO[]) pagedataList.toArray(new MedSrvDO[pagedataList.size()]);
		return medSrvArr;
	}

	/**
	 * 获取分页数据
	 * 
	 * @param pg
	 * @param whereStr
	 * @param whereStr2
	 * @return
	 * @throws BizException
	 */
	private PagingRtnData<MedSrvDO> getPageData(PaginationInfo pg, String whereStr, String orderStr)
			throws BizException {
		IMedsrvMDORService medsrvMDORService = ServiceFinder.find(IMedsrvMDORService.class);
		PagingRtnData<MedSrvDO> result = medsrvMDORService.findByPageInfo(pg, whereStr, orderStr);
		return result;
	}

	/**
	 * 安装票据分类项目信息
	 * 
	 * @param medSrvArr
	 * @throws BizException
	 */
	private void setupIncca(MedSrvDO[] medSrvArr) throws BizException {
		SetupInccaBp bp = new SetupInccaBp();
		bp.exec(medSrvArr);
	}

	@Override
	public MedSrvDO findById(String id) throws BizException {
		IMedsrvMDORService medsrvMDORService = ServiceFinder.find(IMedsrvMDORService.class);
		MedSrvDO result = medsrvMDORService.findById(id);
		setupIncca(new MedSrvDO[] { result });
		SetAccSrvByMedsrvDOBp bp = new SetAccSrvByMedsrvDOBp();
		bp.exec(new MedSrvDO[] { result });
		return result;
	}

	/**
	 * 设置定价模式为本服务定价的服务价格
	 * 
	 * @param result
	 * @throws BizException
	 */
	private void SetRealPri(PagingRtnData<MedSrvDO> result) throws BizException {
		MedSrvDO[] medSrvArr = getMedSrvArr(result);
		SetRealPriBp bp = new SetRealPriBp();
		bp.exec(medSrvArr);
	}

	@Override
	public PagingRtnData<MedSrvDO> findPagingByCaAndQCond(SrvCateDO srvCateDo, QryRootNodeDTO qryRootNodeDto,
			String orderStr, PaginationInfo pg) throws BizException {
		FindPagingByTpsAndCaAndQCondBp bp = new FindPagingByTpsAndCaAndQCondBp();
		PagingRtnData<MedSrvDO> pagingRtnData = bp.exec(null, srvCateDo, qryRootNodeDto, orderStr, pg);
		return pagingRtnData;
	}

	@Override
	public PagingRtnData<MedSrvDO> findPagingByTpsAndCaAndQCond(String[] srvTpCodes, SrvCateDO srvCateDo,
			QryRootNodeDTO qryRootNodeDto, String orderStr, PaginationInfo pg) throws BizException {
		FindPagingByTpsAndCaAndQCondBp bp = new FindPagingByTpsAndCaAndQCondBp();
		PagingRtnData<MedSrvDO> pagingRtnData = bp.exec(srvTpCodes, srvCateDo, qryRootNodeDto, orderStr, pg);
		return pagingRtnData;
	}
}
