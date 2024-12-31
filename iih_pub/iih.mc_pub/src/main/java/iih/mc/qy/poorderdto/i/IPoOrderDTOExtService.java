package iih.mc.qy.poorderdto.i;


import iih.mc.qy.poorderdto.d.PoorderDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

public interface IPoOrderDTOExtService {
	
	
	
	public PagingRtnData<PoorderDTO> findPoorderDTOByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg) throws BizException;
}
