package iih.mkr.std.commondeval.i;

import iih.mkr.std.commonde.d.DataElementDO;
import iih.mkr.std.commondeval.d.DataElementValDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 公共数据元值域扩展读取服务接口
 * 
 * @author hao_wu
 *
 */
public interface ICommondevalExtRService {
	/**
	 * 依据查询信息和数据元查询数据域值域列表
	 * 
	 * @param qryRootNodeDto
	 *            查询信息
	 * @param dataElementDo
	 *            数据元
	 * @return
	 * @throws BizException
	 */
	DataElementValDO[] FindByQCondAndDe(QryRootNodeDTO qryRootNodeDto, DataElementDO dataElementDo) throws BizException;

	/**
	 * 依据数据元查询数据域值域列表
	 * 
	 * @param dataElementDo
	 *            数据元
	 * @return
	 * @throws BizException
	 */
	DataElementValDO[] FindByDe(DataElementDO dataElementDo) throws BizException;

	/**
	 * 获取不重复的值域分类集合
	 * 
	 * @return
	 * @throws BizException
	 */
	PagingRtnData<DataElementValDO> getElevalCa(QryRootNodeDTO qryRootNodeDTO, PaginationInfo pg) throws BizException;
}
