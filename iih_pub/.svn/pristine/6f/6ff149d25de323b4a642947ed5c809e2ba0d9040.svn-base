package iih.bd.mhi.hpdrugdircomp.i;

import iih.bd.mhi.hpdrugdircomp.d.HpDrugDirCompDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 医保平台_药品对照数据维护服务
 * 
 * @author hexx
 */
public interface IHpdrugdircompExtRService {

	/**
	 * 根据分页信息查询对照分页数据集合
	 * 
	 * @param qryRootNodeDTO
	 * @param hpId
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<HpDrugDirCompDTO> FindCompDataList(QryRootNodeDTO qryRootNodeDto, String hpId,
			PaginationInfo pg) throws BizException;
}