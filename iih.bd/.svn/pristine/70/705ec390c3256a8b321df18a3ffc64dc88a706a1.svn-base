package iih.bd.pp.hpdivshisdto.s.bp;

import iih.bd.pp.hp.d.HPDO;
import iih.bd.pp.hp.i.IHpMDORService;
import iih.bd.pp.hpdivshisdto.d.HpDiVsHisDTO;
import iih.bd.pp.hpdivshisdto.s.bp.sql.FindCompDataListSql;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 查询对照数据列表业务逻辑
 * 
 * @author hao_wu
 *
 */
public class FindCompDataListBp {
	
	/**
	 * @param qryRootNodeDto
	 * @param hpId
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<HpDiVsHisDTO> exec(QryRootNodeDTO qryRootNodeDto, String hpId, PaginationInfo pg)
			throws BizException {
		String wherePart = GetWherePart(qryRootNodeDto);
		String idRef = getIdRef(hpId);
		FindCompDataListSql sql = new FindCompDataListSql(wherePart, hpId, idRef);
		PagingServiceImpl<HpDiVsHisDTO> pagingServiceImpl = new PagingServiceImpl<HpDiVsHisDTO>();
		PagingRtnData<HpDiVsHisDTO> result = pagingServiceImpl.findByPageInfo(new HpDiVsHisDTO(), pg,
				sql.getQrySQLStr(), "DI_DEF.CODE", sql.getQryParameter(null));
		return result;
	}

	/**
	 * @param hpId
	 * @return
	 * @throws BizException 
	 */
	private String getIdRef(String hpId) throws BizException {
		IHpMDORService iHpMDORService = ServiceFinder.find(IHpMDORService.class);
		HPDO hpdo = iHpMDORService.findById(hpId);
		return hpdo.getId_refhp();
	}

	/**
	 * 查询方案生成条件语句
	 * 
	 * @param qryRootNodeDto
	 * @return
	 * @throws BizException
	 */
	private String GetWherePart(QryRootNodeDTO qryRootNodeDto) throws BizException {
		IQrySQLGeneratorService qrySQLGeneratorService = ServiceFinder.find(IQrySQLGeneratorService.class);
		String wherePart = qrySQLGeneratorService.getQueryStringWithoutDesc(qryRootNodeDto);
		return wherePart;
	}
}
