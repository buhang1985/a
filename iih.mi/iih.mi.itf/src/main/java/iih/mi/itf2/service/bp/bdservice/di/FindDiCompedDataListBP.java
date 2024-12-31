package iih.mi.itf2.service.bp.bdservice.di;

import iih.bd.pp.hp.d.HPDO;
import iih.bd.pp.hp.i.IHpMDORService;
import iih.mi.itf2.dto.dicompdto.d.DiCompDTO;
import iih.mi.itf2.service.bp.bdservice.di.qry.FindDiCompedDataListSql;
import iih.mi.itf2.service.bp.bdservice.util.ToolUtils;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

public class FindDiCompedDataListBP {
	public PagingRtnData<DiCompDTO> exec(QryRootNodeDTO qryRootNodeDto, String hpId, PaginationInfo pg) throws BizException{
		String wherePart = ToolUtils.GetWherePart(qryRootNodeDto);
		String idRef = getIdRef(hpId);
		FindDiCompedDataListSql sql = new FindDiCompedDataListSql(wherePart,hpId,idRef);
		PagingServiceImpl<DiCompDTO> pagingServiceImpl = new PagingServiceImpl<DiCompDTO>();
		PagingRtnData<DiCompDTO> result = pagingServiceImpl.findByPageInfo(new DiCompDTO(), pg,
				sql.getQrySQLStr(), "DI_DEF.CODE", sql.getQryParameter(null));
		return result;
	}
	
	/**
	 * 获取idRef
	 * @author zhang.hw
	 * @date 2019年7月30日
	 * @param hpId
	 * @return
	 * @throws BizException
	 */
	private String getIdRef(String hpId) throws BizException {
		IHpMDORService iHpMDORService = ServiceFinder.find(IHpMDORService.class);
		HPDO hpdo = iHpMDORService.findById(hpId);
		return hpdo.getId_refhp();
	}
}
