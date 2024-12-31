package iih.bd.srv.i;

import iih.bd.srv.d.MrtplItmDTO;
import iih.bd.srv.d.MrtplvtDTO;
import iih.bd.srv.d.MrvtmeacaitmDTO;
import xap.mw.core.data.BizException;

public interface IMrtplvtExtService {
	
	public abstract MrtplvtDTO GetMrtplvtDTO(String Id_mrtplvt) throws BizException;
	
	public abstract MrtplItmDTO GetItmDTO(String Id_mrtplvtitm) throws BizException;
	
	public abstract MrtplItmDTO[] GetMrtplItmDTOList(String Id_mrtplvt) throws BizException;
	
	public abstract MrtplItmDTO SetItmDeInfo(MrtplItmDTO DTO) throws BizException;
	
}
