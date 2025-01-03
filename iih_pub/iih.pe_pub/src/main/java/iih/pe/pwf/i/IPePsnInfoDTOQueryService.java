package iih.pe.pwf.i;

import iih.pe.pwf.dto.pepsninfodto.d.PePsnInfoDTO;
import iih.pe.pwf.pedwsquery.d.PeDwsQueryDO;
import xap.mw.core.data.BizException;

public interface IPePsnInfoDTOQueryService {
	public PePsnInfoDTO[] findByDTO(String dt_pe,String card_pe) throws BizException;
	
	public PePsnInfoDTO[] findDtoByPecode(String code,String multiGroupValue) throws BizException;

	public PePsnInfoDTO[] findDtoByQry(PeDwsQueryDO qry,String multiGroupValue) throws BizException;

	public PePsnInfoDTO findDtoByIdPepsnbinfo(String idPepsnbinfo, String orderPart) throws BizException;
}
