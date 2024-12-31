package iih.bd.srv.medsrv.i;

import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.srvcate.d.SrvCateDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 医疗服务主DO查询服务接口
 * 
 * @author hao_wu
 *
 */
public interface IMedsrvMDOQryService {

	/**
	 * 根据分页信息、查询与分组条件及管控获得分页数据
	 */
	public PagingRtnData<MedSrvDO> findByPageInfo(PaginationInfo pg, String whereStr, String orderStr)
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
	public PagingRtnData<MedSrvDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO, String orderStr,
			PaginationInfo pg) throws BizException;

	/**
	 * 根据id值查找医疗服务数据
	 */
	public abstract MedSrvDO findById(String id) throws BizException;

	/**
	 * 根据查询方案，分页信息，查询条件查询分页数据集合
	 * 
	 * @param qryRootNodeDTO
	 * @param orderStr
	 * @param pg
	 * @param condition
	 * @return
	 * @throws BizException
	 */
	public abstract PagingRtnData<MedSrvDO> findByQCondAndPageInfoAndCondtion(QryRootNodeDTO qryRootNodeDTO,
			String orderStr, String condition, PaginationInfo pg) throws BizException;

	/**
	 * 根据服务分类和查询方案查询医疗服务分页信息
	 * 
	 * @param srvCateDo      服务分类
	 * @param qryRootNodeDto 查询方案
	 * @param orderStr       排序语句
	 * @param pg             分页信息
	 * @return 分页数据
	 * @throws BizException
	 */
	public abstract PagingRtnData<MedSrvDO> findPagingByCaAndQCond(SrvCateDO srvCateDo, QryRootNodeDTO qryRootNodeDto,
			String orderStr, PaginationInfo pg) throws BizException;

	/**
	 * 根据服务分类和查询方案查询医疗服务分页信息
	 * 
	 * @param srvTpCodes     服务类型编码集合
	 * @param srvCateDo      服务分类
	 * @param qryRootNodeDto 查询方案
	 * @param orderStr       排序语句
	 * @param pg             分页信息
	 * @return 分页数据
	 * @throws BizException
	 */
	public abstract PagingRtnData<MedSrvDO> findPagingByTpsAndCaAndQCond(String[] srvTpCodes, SrvCateDO srvCateDo,
			QryRootNodeDTO qryRootNodeDto, String orderStr, PaginationInfo pg) throws BizException;
}
