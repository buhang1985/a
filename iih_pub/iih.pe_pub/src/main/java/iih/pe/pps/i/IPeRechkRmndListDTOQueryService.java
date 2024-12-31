package iih.pe.pps.i;

import iih.pe.pps.dto.perecheckreminddto.d.PeRechkRmndListDTO;
import xap.mw.core.data.BizException;

public interface IPeRechkRmndListDTOQueryService {
   
	public PeRechkRmndListDTO[] queryPeRechkRmndList(String dt_begin, String dt_end) throws BizException;

	//根据预约单号查询该复查人员信息
	PeRechkRmndListDTO[] queryReChkRmdInfoByPsnapptId(String pepsnapptId) throws BizException;
}
