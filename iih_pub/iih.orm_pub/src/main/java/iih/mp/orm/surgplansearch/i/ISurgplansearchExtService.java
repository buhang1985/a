package iih.mp.orm.surgplansearch.i;

import iih.mp.orm.surgplansearch.d.SurgPlanSearchDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

public interface ISurgplansearchExtService {
	
	/**
	 * 查询手术安排列表
	 * @param dt_begin
	 * @param dt_end
	 * @return
	 * @throws BizException
	 */
	public abstract SurgPlanSearchDTO[] findByQCond(QryRootNodeDTO qryNode) throws BizException;
	
	/**
	 * 根据查询模板分页查询数据
	 * @param qryRootNodeDTO
	 * @param orderStr
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<SurgPlanSearchDTO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO, String orderStr,
    		PaginationInfo pg) throws BizException;

	/**
	 * 更改手术人员后刷新页面数据
	 * @param id_apopcf
	 * @return
	 * @throws BizException
	 */
	public abstract SurgPlanSearchDTO findById(String id_apopcf) throws BizException;
}
