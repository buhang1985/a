package iih.mi.mc.mimcspec.i;

import iih.mi.mc.mimcspec.d.MiMcSpecDO;
import iih.mi.mc.mimcspec.d.MiMcSpecDrugDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
/**
 * 医保特殊病可开项目扩展服务
 * @author LIM
 *
 */
public interface IMiMcSpecDrugDOExtCrudService  {

	/**
	 * 获取医保特殊病诊断可开医保项目分页数据
	 * 
	 * @param miMcSpecDO
	 *            医保特殊病诊断
	 * @param qryRootNodeDto
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	public abstract PagingRtnData<MiMcSpecDrugDO> findSpecSrvAndPageInfo(MiMcSpecDO miMcSpecDO,
			QryRootNodeDTO qryRootNodeDto, PaginationInfo pg) throws BizException;
}
