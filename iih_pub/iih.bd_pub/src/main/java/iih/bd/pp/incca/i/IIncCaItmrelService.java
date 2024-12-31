package iih.bd.pp.incca.i;

import iih.bd.pp.incca.d.IncCaItmDO;
import iih.bd.pp.incca.d.IncCaItmRelDO;
import iih.bd.pp.incca.d.UnComparisonedSrvDTO;
import iih.bd.srv.medsrv.d.MedSrvDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

public interface IIncCaItmrelService {
	/**
	 * 获取未对照的服务个数
	 * 
	 * @param str
	 * @return
	 * @throws BizException
	 */
	public abstract int getUnComparisonedSrvCount(String str) throws BizException;

	/**
	 * 获取某个票据分类下所包含的所有未对照的服务分类
	 * 
	 * @param id_incca
	 * @return
	 * @throws BizException
	 */
	public abstract UnComparisonedSrvDTO[] getUnComparisonedSrvDtoByIdincca(String id_incca) throws BizException;

	/**
	 * 获取某个服务分类下的所有的未对照的服务
	 * 
	 * @param idIncca
	 * @param idSrvca
	 * @return
	 * @throws BizException
	 */
	public abstract PagingRtnData<MedSrvDO> getUnComparisonedSrvsList(PaginationInfo pg, QryRootNodeDTO qryRootNodeDTO, String idIncca, String idSrvca) throws BizException;
	
	/**
	 * 获取票据分类项目对照的服务，且一同查询出服务的分类
	 * @param pg
	 * @param idIncca
	 * @param idInccaitm
	 * @return
	 * @throws BizException
	 */
	public abstract PagingRtnData<IncCaItmRelDO> getSrvAndSrvcaList(PaginationInfo pg, QryRootNodeDTO[] qryRootNodeDTOArr, IncCaItmDO incCaItmDO) throws BizException;
}
