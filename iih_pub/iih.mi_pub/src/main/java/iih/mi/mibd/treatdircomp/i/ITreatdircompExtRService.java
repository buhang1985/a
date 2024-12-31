package iih.mi.mibd.treatdircomp.i;

import iih.mi.mibd.treatdircomp.d.TreatDirCompDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * @ClassName: ITreatdircompExtCudService
 * @Description: 医保平台_诊疗对照扩展维护服务
 * @author: dj.zhang
 * @date: 2018年1月31日 下午1:53:45
 */
public interface ITreatdircompExtRService {
	/**
	 * 诊疗项目对照信息查询服务
	 * 
	 * @param qryRootNodeDto
	 * @param misId
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	public abstract PagingRtnData<TreatDirCompDTO> findCompDataList(QryRootNodeDTO qryRootNodeDto, String misId,
			PaginationInfo pg) throws BizException;
}