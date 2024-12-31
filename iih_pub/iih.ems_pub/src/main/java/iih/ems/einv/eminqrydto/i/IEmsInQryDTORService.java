package iih.ems.einv.eminqrydto.i;

import iih.ems.einv.eminqrydto.d.EminQryDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 耗材入库查询服务
 * @author ma.hy
 *
 */
public interface IEmsInQryDTORService {

	/**
	*  根据分页信息及查询与分组条件获得分页数据
	*/
	public abstract PagingRtnData<EminQryDTO> findByPageInfo(String wherePart,String orderByPart,PaginationInfo pg) throws BizException;
	
	/**
	 * 根据查询模板条件、分页信息查询分页数据集合
	 * @param qryRootNodeDTO
	 * @param orderStr
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<EminQryDTO> findEmInQryByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg) throws BizException;
	
	/**
	 * 查询入库信息（非分页）
	 * @param wherePart
	 * @return
	 * @throws BizException
	 */
	public EminQryDTO[] find(String wherePart) throws BizException;
	
}
