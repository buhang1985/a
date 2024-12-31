package iih.bd.pp.hpsrvorca.i;

import iih.bd.pp.hp.d.HPDO;
import iih.bd.pp.hpsrvorca.d.HPSrvorcaDO;
import iih.bd.pp.hpsrvorcadto.d.HpsrvorcaDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

public interface IHpSrvorcaExtRService {
	/**
	 * 通过qryRootNodeDTO和PageInfo查询医保对照信息
	 * 
	 * @param qryRootNodeDTO
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<HPSrvorcaDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO, String orderStr,
			PaginationInfo pg) throws BizException;
	
	/**
	 * 通过qryRootNodeDTO,Hpdo和PageInfo查询医保对照信息
	 * 
	 * @param qryRootNodeDTO
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<HPSrvorcaDO> findByHpQCondAndPageInfo(HPDO hpdo,QryRootNodeDTO qryRootNodeDTO, String orderStr,
			PaginationInfo pg) throws BizException;

	/**
	 * 根据医保目录对照主键查询医保目录对照信息
	 * 
	 * @author hao_wu
	 * @param srvOrCaId
	 * @return
	 * @throws BizException
	 */
	public HPSrvorcaDO findById(String srvOrCaId) throws BizException;

	/**
	 * 通过qryRootNodeDTO,Hpdo和PageInfo查询医保对照信息
	 * 
	 * @param qryRootNodeDTO
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<HPSrvorcaDO> findPagingByHpIdQCond(HPDO Hpdo, QryRootNodeDTO qryRootNodeDTO, String orderStr,
			PaginationInfo pg) throws BizException;

	/**
	 * 获取导出数据
	 * 
	 * @param Hpdo
	 * @param qryRootNodeDTO
	 * @param orderStr
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<HpsrvorcaDTO> findPagingDataByQCondAndMisrvTp(HPDO Hpdo, QryRootNodeDTO qryRootNodeDTO,
			String orderStr, PaginationInfo pg, String miSrvTp) throws BizException;

}
