package iih.mi.mibd.drug.i;
import iih.mi.mibd.drug.d.DrugDO;
import iih.mi.mibd.mis.d.MisDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 *药品扩展数据查询服务接口
 * 
 * 
 * @author hexx
 *
 */
public interface IDrugExtRService {

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
	public abstract PagingRtnData<DrugDO> FindPagingByMisAndQCond( MisDO mis,QryRootNodeDTO qryRootNodeDto, String orderStr, PaginationInfo pg) throws BizException;

}
