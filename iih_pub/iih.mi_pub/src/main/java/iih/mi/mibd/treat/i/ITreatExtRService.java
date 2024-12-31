package iih.mi.mibd.treat.i;



import iih.mi.mibd.mis.d.MisDO;
import iih.mi.mibd.treat.d.TreatDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

import xap.sys.xbd.udi.d.UdidocDO;

/**
 *诊疗项目扩展数据查询服务接口
 * 
 *
 *@author hexx
 */
public interface ITreatExtRService {

	/**
	 * 根据医保系统和查询方案查询诊疗项目分页数据
     * @param mis
	 *            医保系统
	 * @param qryRootNodeDto
	 *            查询方案
	 * @param orderStr
	 *            排序语句
	 * @param pg
	 *            分页信息
	 * @return 分页数据
	 * @throws BizException
	 */
	public abstract PagingRtnData<TreatDO> FindPagingByMisAndQCond( MisDO mis,QryRootNodeDTO qryRootNodeDto, String orderStr, PaginationInfo pg) throws BizException;

}
