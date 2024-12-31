package iih.pi.reg.s.external.provide.bp;

import java.util.ArrayList;
import java.util.List;

import iih.bd.base.utils.SqlUtils;
import iih.pi.reg.dto.d.PiPatPeDTO;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.i.IPatiMDORService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 查询体检患者信息
 * 
 * @author houll 2018-11-23
 *
 */
public class FindPePatInfoBP {
	/***
	 * 查询体检患者信息
	 * 
	 * @param piPatPeDTOs
	 * @return
	 * @throws BizException
	 */
	public PatDO[] exec(PiPatPeDTO[] piPatPeDTOs) throws BizException {
		if (piPatPeDTOs == null || piPatPeDTOs.length < 0) {
			throw new BizException("入参为空！");
		}
	   List<String> idCodes = new ArrayList<String>();
       for (PiPatPeDTO piPatPeDTO : piPatPeDTOs)
       {
    	   if(idCodes != null && !idCodes.contains(piPatPeDTO.getIdcode())){
    		   idCodes.add(piPatPeDTO.getIdcode());
    	   }
       }
		IPatiMDORService service = ServiceFinder.find(IPatiMDORService.class);
		PatDO[] patDOs = service.find(SqlUtils.getInSqlByIds(PatDO.ID_CODE, idCodes), null, FBoolean.FALSE);
		return patDOs;
	}
}
