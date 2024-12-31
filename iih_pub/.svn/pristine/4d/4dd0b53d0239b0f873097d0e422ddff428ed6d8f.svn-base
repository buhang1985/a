package iih.bd.srv.empphydto.i;

import iih.bd.srv.empphydto.d.EmpphyDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 医师属性dto查询接口
 * @author guoyang
 *
 */
public interface IEmpPhyDtoRService {

	/**
	*  根据分页信息及查询与分组条件获得分页数据
	*/
	public abstract PagingRtnData<EmpphyDTO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart) throws BizException;
	
	/**
	 * 根据查询模板条件、分页信息查询分页数据集合
	 * @param qryRootNodeDTO
	 * @param flag
	 * @param orderStr
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<EmpphyDTO> FindByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String condition,String orderStr,PaginationInfo pg) throws BizException;
}
