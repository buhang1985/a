package iih.sc.sch.s.bp;


import org.apache.commons.lang.StringUtils;

import iih.sc.scbd.schedulechl.d.SchedulechlDO;
import iih.sc.scbd.schedulechl.d.desc.SchedulechlDODesc;
import iih.sc.scbd.schedulechl.i.ISchedulechlMDORService;
import iih.sc.sch.scsch.d.ScSchChlDO;
import iih.sc.sch.scsch.d.desc.ScSchChlDODesc;
import iih.sc.sch.scsch.i.IScSchChlDORService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**获取号源池数
 * @author ccj
 *
 */
public class GetScpolcnByIdAndSdBp{
	/**获取号源池数根据排班id和渠道编码
	 * @param sd_scchltp  渠道编码
	 * @param id_sch   排班id
	 * @return  号源池数
	 * @throws BizException
	 */
	public Integer exec(String sd_scchltp,String id_sch) throws BizException{
		if(StringUtils.isBlank(id_sch) || StringUtils.isBlank(sd_scchltp)) return null;
		ISchedulechlMDORService iSchedulechlRService = ServiceFinder.find(ISchedulechlMDORService.class);
		IScSchChlDORService chlDORService = ServiceFinder.find(IScSchChlDORService.class);
		SchedulechlDO[] schedulechlDOs = iSchedulechlRService.find(SchedulechlDODesc.TABLE_ALIAS_NAME+".sd_scchltp = '"+sd_scchltp+"'", "", FBoolean.TRUE);
		if(schedulechlDOs == null || schedulechlDOs.length == 0) return null;
		ScSchChlDO[] chlDOs = chlDORService.find(ScSchChlDODesc.TABLE_ALIAS_NAME+".id_scchl = '"+schedulechlDOs[0].getId_scchl()+"' and "+ScSchChlDODesc.TABLE_ALIAS_NAME+".id_sch = '"+id_sch+"'", "", FBoolean.TRUE);
		// 排班渠道控制那里没有维护渠道与号源池关系 则默认使用0号源池
		if(chlDOs == null || chlDOs.length == 0) return null;
		return chlDOs[0].getScpolcn();
	}
}
