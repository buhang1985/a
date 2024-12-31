package iih.pe.pqry.i;

import iih.pe.pqry.penhcposirpt.d.PeNhcPosiListDO;
import xap.mw.core.data.BizException;

public interface IPeNhcPosiListQueryService {
	
	//查询统计报表明细
	PeNhcPosiListDO[] queryAllPosiListDos() throws BizException;
}
