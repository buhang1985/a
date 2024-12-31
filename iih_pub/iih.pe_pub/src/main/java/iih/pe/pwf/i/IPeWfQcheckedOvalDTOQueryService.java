package iih.pe.pwf.i;

import iih.pe.pwf.dto.pewfqcheckedovaldto.d.PeWfQcheckedOvalDTO;
import iih.pe.pwf.pedwsquery.d.PeDwsQueryDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

public interface IPeWfQcheckedOvalDTOQueryService {
	
	/**
	*  总检名单：不分页
	*/
	PeWfQcheckedOvalDTO[] findPeWfQcheckedOvalDTO(String dt_pe, String ent_date,String room_id,String id_pecorpappt,String groupId, String pestatus,String sortoval, String id_corp,String rmk_corp,String multiGroupValue) throws BizException;
	
	//根据体检流程号进行检索//
	PeWfQcheckedOvalDTO[] findPeWfQcheckedOvalDTOByCardPe(String cardPe,String multiGroupValue) throws BizException;
	
	/**
	*  总检名单：根据分页信息及查询与分组条件获得分页数据
	*/
	public abstract PagingRtnData<PeWfQcheckedOvalDTO> findByPageInfo(PaginationInfo pg, PeDwsQueryDO qry, String orderStr, FBoolean isLazy) throws BizException;
}
