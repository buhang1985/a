package iih.sc.scbd.s.ep;

import iih.sc.scbd.scheduleca.d.ScheduleCADO;
import iih.sc.scbd.scheduleca.i.ISchedulecaRService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

public class SccaEP {

	/**
	 * 获取对应类型的排班分类
	 * @param sctp
	 * @throws BizException
	 */
	public ScheduleCADO GetScca(String sctp) throws BizException{
		ISchedulecaRService rService = ServiceFinder.find(ISchedulecaRService.class) ;
		ScheduleCADO[] cados = rService.find("sd_sctp ='"+ sctp+"'", "", FBoolean.FALSE);	
		if(ArrayUtil.isEmpty(cados)){
			throw new BizException("请先维护排班分类");
		}
		return cados[0];
	}
}
