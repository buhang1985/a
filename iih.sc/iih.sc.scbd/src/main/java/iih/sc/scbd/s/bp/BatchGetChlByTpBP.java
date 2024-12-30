package iih.sc.scbd.s.bp;

import iih.sc.comm.ScSqlUtils;
import iih.sc.scbd.schedulechl.d.SchedulechlDO;
import iih.sc.scbd.schedulechl.d.desc.SchedulechlDODesc;
import iih.sc.scbd.schedulechl.i.ISchedulechlMDORService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 根据类型集合获取渠道
 * @author yank
 *
 */
public class BatchGetChlByTpBP {
	/**
	 * 获取渠道
	 * @param chlTps 渠道类型编码集合
	 * @return
	 * @throws BizException
	 */
	public SchedulechlDO[] exec(String[] chlTps) throws BizException{		
		String ids = ScSqlUtils.arrayToStr(chlTps);
		String whereStr = String.format("%s.SD_SCCHLTP IN (%s)",SchedulechlDODesc.TABLE_ALIAS_NAME,ids);
		ISchedulechlMDORService chlService = ServiceFinder.find(ISchedulechlMDORService.class);
		SchedulechlDO[] chlDOs = chlService.find(whereStr, null, FBoolean.FALSE);
		return chlDOs;
	} 
}
