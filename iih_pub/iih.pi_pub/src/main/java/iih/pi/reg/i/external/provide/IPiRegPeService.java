package iih.pi.reg.i.external.provide;

import iih.pi.reg.dto.d.PiPatPeDTO;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PatiAggDO;
import xap.mw.core.data.BizException;

/**
 * 
 * 患者对体检提供服务
 * @author ly 2018/11/19
 *
 */
public interface IPiRegPeService {

	public abstract PatiAggDO[] createPats(PiPatPeDTO[] aggDos) throws BizException;
	
	public abstract PatiAggDO[] updatePats(PiPatPeDTO[] aggDos) throws BizException;

	public abstract PatDO[] find(PiPatPeDTO[] piPatPeDTOs)  throws BizException;
}
