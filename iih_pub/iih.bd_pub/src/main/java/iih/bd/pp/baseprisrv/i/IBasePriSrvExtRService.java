package iih.bd.pp.baseprisrv.i;

import iih.bd.pp.baseprisrv.d.PriSrvDO;
import iih.bd.srv.srvcate.d.SrvCateDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 基础价表服务扩展服务接口
 * 
 * @author hao_wu 2019-8-16
 *
 */
public interface IBasePriSrvExtRService {

	/**
	 * 根据服务分类和查询方案查询基础价表服务分页数据
	 * 
	 * @param srvCateDo
	 * @param qryRootNodeDto
	 * @param whereStr
	 * @param orderStr
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	public abstract PagingRtnData<PriSrvDO> findPagingByCaAndQryNode(SrvCateDO srvCateDo, QryRootNodeDTO qryRootNodeDto,
			String whereStr, String orderStr, PaginationInfo pg) throws BizException;
}
