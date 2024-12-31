package iih.bd.fc.triagecmpt.i;

import iih.bd.fc.triageca.d.TriageCaDO;
import iih.bd.fc.triagecmpt.d.TriageCmptDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 检伤主诉扩展查询服务接口
 * 
 * @author hao_wu
 *
 */
public interface ITriageCmptExtRService {

	/**
	 * 使用检伤分类和查询方案查询检伤主诉分页数据
	 * 
	 * @param triageCa
	 *            检伤分类
	 * @param qryRootNodeDto
	 *            查询方案
	 * @param orderPart
	 *            排序语句
	 * @param pg
	 *            分页信息
	 * @return 分页数据
	 */
	public abstract PagingRtnData<TriageCmptDO> FindPagingByQcondAndCa(TriageCaDO triageCa,
			QryRootNodeDTO qryRootNodeDto, String orderPart, PaginationInfo pg) throws BizException;
}
