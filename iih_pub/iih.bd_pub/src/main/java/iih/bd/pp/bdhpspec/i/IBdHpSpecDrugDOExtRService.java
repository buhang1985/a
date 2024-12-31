package iih.bd.pp.bdhpspec.i;

import iih.bd.pp.bdhpspec.d.BdHpSpecDO;
import iih.bd.pp.bdhpspec.d.BdHpSpecDrugDO;
import iih.bd.pp.hpsrvorca.d.HPSrvorcaDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 医保特殊病可开项目扩展服务
 * 
 * @author hao_wu
 *
 */
public interface IBdHpSpecDrugDOExtRService {

	/**
	 * 获取医保特殊病诊断可开医保项目分页数据
	 * 
	 * @param bdHpSpecDo
	 *            医保特殊病诊断
	 * @param qryRootNodeDto
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	public abstract PagingRtnData<BdHpSpecDrugDO> FindMedicalCareSrv(BdHpSpecDO bdHpSpecDo,
			QryRootNodeDTO qryRootNodeDto, PaginationInfo pg) throws BizException;

	/**
	 * 使用查询方案查询医保分页信息
	 * 
	 * @param qryRootNodeDto
	 * @param orderStr
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	public abstract PagingRtnData<HPSrvorcaDO> FindMedicalInsurPagingDataByQCond(QryRootNodeDTO qryRootNodeDto,
			PaginationInfo pg) throws BizException;
}
