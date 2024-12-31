package iih.pe.phm.i;

import iih.pe.papt.dto.pehmapptdto.d.PeHmApptDTO;
import iih.pe.phm.pedietplan.d.PedietplanAggDO;
import iih.pe.pwf.dto.peovallistdto.d.PeOvalListDTO;
import xap.mw.core.data.BizException;

public interface IPeDietPlanMaintainService{
	
	//制定一周的饮食计划
	public PedietplanAggDO[] makeDietPlan(PedietplanAggDO aggdo,PeHmApptDTO ovalListDto) throws BizException;
	
} 
