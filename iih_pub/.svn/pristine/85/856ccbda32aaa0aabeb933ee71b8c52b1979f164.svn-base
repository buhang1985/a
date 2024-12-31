package iih.bd.srv.mrbasetpl.i;

import iih.bd.srv.mrbasetpl.d.EmrBaseTplDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 医疗记录基础模板自定义保存服务接口
 * 
 * @author hao_wu
 *
 */
public interface IMrBaseTplService {

	/**
	 * 根据分页信息及查询与分组条件获得分页数据
	 */
	public abstract PagingRtnData<EmrBaseTplDO> findByPageInfo(PaginationInfo pg, String wherePart, String orderByPart)
			throws BizException;

	/**
	 * 根据查询模板条件、分页信息查询分页数据集合
	 * 
	 * @param qryRootNodeDTO
	 * @param orderStr
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<EmrBaseTplDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO, String orderStr,
			PaginationInfo pg) throws BizException;

	/**
	 * 根据条件语句、查询模板、分页信息查询分页数据集合
	 * 
	 * @param wherPart
	 * @param qryRootNodeDTO
	 * @param orderStr
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<EmrBaseTplDO> findPagingDataByQCondAndWherePart(String wherePart,
			QryRootNodeDTO qryRootNodeDTO, String orderStr, PaginationInfo pg) throws BizException;

	/**
	 * 基础病历模板获取编码
	 * 
	 * @return
	 * @throws BizException
	 */
	public String getEmrBaseTplCode() throws BizException;

	/**
	 * 基础病历模板回滚编码
	 * 
	 * @throws BizException
	 */
	public void rollBackEmrBaseTplCode(String[] codes) throws BizException;

	/**
	 * 根据基础模板主键获取医疗记录模板个数
	 * 
	 * @param baseTplId 基础模板主键
	 * @return 医疗记录模板个数
	 * @throws BizException
	 */
	public Integer findMrTplCountByBaseTplId(String baseTplId) throws BizException;

}
