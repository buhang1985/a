package iih.pe.phm.i;
 
import iih.pe.phm.dto.petcmevaldto.d.PeTCMAsseDTO;
import xap.mw.core.data.BizException;

public interface IPetcmasseQueryService{

	PeTCMAsseDTO[] queryTipsByConId(String pepsnapptId) throws BizException;
	
}
