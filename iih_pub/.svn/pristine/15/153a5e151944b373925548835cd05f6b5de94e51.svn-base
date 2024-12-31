package iih.mi.mibd.drugdircomp.i;
import iih.mi.mibd.drugdircomp.d.DrugDirCompDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
* 医保平台_药品对照数据维护服务
* @author hexx
*/
public interface IDrugdircompExtRService {
	
    /**
	 * 根据分页信息查询对照分页数据集合
	 * @param qryRootNodeDTO
	 * @param mis_id
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<DrugDirCompDTO> FindCompDataList(QryRootNodeDTO qryRootNodeDto, String misId, PaginationInfo pg) throws BizException;
}