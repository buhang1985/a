package iih.pe.pwf.i;

import iih.pe.pwf.dto.peovallistdto.d.PeOvalListDTO;
import iih.pe.pwf.peoverquery.d.PeOverQueryDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

public interface IPeOvalListDTOQueryService {
	public PeOvalListDTO[] findByDTO(PeOverQueryDO qryDo) throws BizException;
	
	public PagingRtnData<PeOvalListDTO> findCustomPageInfoList(PaginationInfo pg, String[] sqlParam, String funcode, String orderStr, FBoolean isLazy) throws BizException;
	//查询面板快速查询的方法
	public PeOvalListDTO[] queryPeOvalListDTOData(String dtPe,String cardNo,String namePsn) throws BizException;
}
