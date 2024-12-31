package iih.pe.papt.i;

import iih.pe.papt.dto.pehmapptdto.d.PeHmApptDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;

public interface IPeHmApptdtoRService {
	
	public PagingRtnData<PeHmApptDTO> findPagingByQCond(String dt_appt, String id_user, String orderPart, PaginationInfo pg) throws BizException;
	public PeHmApptDTO[] findAllByQCond(String dt_appt, String id_user, String orderPart) throws BizException;
	public PeHmApptDTO findDtoById(String idPehmapptStr,String orderPart) throws BizException;

	public PeHmApptDTO[] findAllByDateAndStatus(String dt_begin, String dt_end, String hmstatus, String orderPart) throws BizException;
	public PagingRtnData<PeHmApptDTO> findAllByNameMobAndIdcode(PaginationInfo pg,String[] conds,String orderStr, FBoolean isLazy) throws BizException;
	
}
