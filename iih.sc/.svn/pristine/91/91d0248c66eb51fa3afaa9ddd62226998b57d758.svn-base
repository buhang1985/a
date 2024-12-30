package iih.sc.sch.s.ep;

import iih.sc.scbd.scheduleca.d.ScheduleCADO;
import iih.sc.scbd.scheduleca.i.ISchedulecaRService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 基础数据BP
 * @author renying
 *
 */
public class SchBdEP {
	/**
	 * 查找医技的排班分类
	 * @return
	 * @throws BizException
	 */
	public ScheduleCADO[] getSchEduleCaDOs(String sd_sctp) throws BizException{
		ISchedulecaRService caService = ServiceFinder.find(ISchedulecaRService.class);	
		ScheduleCADO[] caDos =  caService.find("sd_sctp = '"+sd_sctp+"'", "", FBoolean.FALSE);
		return caDos;
	}

}
