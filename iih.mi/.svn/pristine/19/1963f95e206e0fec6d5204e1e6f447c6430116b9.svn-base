package iih.mi.mc.mimcspec.s;

import iih.mi.mc.mimcspec.d.MiMcSpecDO;
import iih.mi.mc.mimcspec.d.MiMcSpecDrugDO;
import iih.mi.mc.mimcspec.i.IMiMcSpecDrugDOExtCrudService;
import iih.mi.mc.mimcspec.s.bp.FindSpecSrvBP;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
/**
 * 医保特殊病可开项目扩展查询服务
 * @author liming
 *
 */
public class MiMcSpecDrugDOExtCrudServiceImpl implements IMiMcSpecDrugDOExtCrudService{

	@Override
	public PagingRtnData<MiMcSpecDrugDO> findSpecSrvAndPageInfo(MiMcSpecDO miMcSpecDO, QryRootNodeDTO qryRootNodeDto,PaginationInfo pg) throws BizException {
		FindSpecSrvBP bp = new FindSpecSrvBP();
		PagingRtnData<MiMcSpecDrugDO> result = bp.exec(miMcSpecDO, qryRootNodeDto, pg);
		return result;
	}

}
