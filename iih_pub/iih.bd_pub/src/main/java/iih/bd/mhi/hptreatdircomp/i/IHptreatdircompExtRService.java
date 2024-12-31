package iih.bd.mhi.hptreatdircomp.i;

import iih.bd.mhi.hptreatdircomp.d.HpTreatDirCompDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 医保产品_诊疗对照数据维护扩展服务
 * 
 * @author dj.zhang
 *
 */
public interface IHptreatdircompExtRService {

	/**
	 * 诊疗项目对照信息查询服务
	 * 
	 * @param qryRootNodeDto
	 * @param hpId
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	public abstract PagingRtnData<HpTreatDirCompDTO> findCompDataList(QryRootNodeDTO qryRootNodeDto, String hpId,
			PaginationInfo pg) throws BizException;
}