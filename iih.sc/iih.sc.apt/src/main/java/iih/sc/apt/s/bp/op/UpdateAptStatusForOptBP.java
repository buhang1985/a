package iih.sc.apt.s.bp.op;

import iih.sc.apt.s.ep.AptEP;
import iih.sc.apt.scapt.d.ScAptDO;
import iih.sc.apt.scapt.i.IScaptMDORService;
import iih.sc.apt.scaptappl.d.ScAptApplDO;
import iih.sc.apt.scaptappl.i.IScaptapplMDORService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
/***
 * 手术申请单术后确认、取消确认之后以及术前确认，修改手术预约状态
 * 
 * @author fanlq
 *
 */
public class UpdateAptStatusForOptBP {
	/***
	 * 手术申请单术后确认、取消确认之后以及术前确认，修改手术预约状态
	 * 
	 * @param applNo 手术申请单号
	 * @param isFinish 是否术后确认，true-确认，预约状态改为完成；false-取消确认，预约状态改为预约
	 * @param isBefConf 是否术前确认，true-确认，预约状态改为术前确认
	 * @throws BizException
	 */
	public void exec(String applNo,FBoolean isFinish,FBoolean isBefConf) throws BizException{
		ScAptDO aptDO = this.getScAptDOByApplNo(applNo);
		if(aptDO == null)
			return;
		AptEP ep = new AptEP();
		if(FBoolean.TRUE.equals(isBefConf)){
			//ep.befConf(aptDO);//经于老田沟通，术前确认暂不需要修改预约状态
		}else{
		if(FBoolean.TRUE.equals(isFinish)){
			ep.finish(aptDO);
		}else{
			//取消预约
			ep.aptStatus(aptDO);
		}
	}
	}
	/***
	 * 通过手术申请单号获取预约DO
	 * @param applNo 手术申请单号
	 * @return
	 * @throws BizException
	 */
	private ScAptDO getScAptDOByApplNo(String applNo) throws BizException {
		IScaptapplMDORService applService = ServiceFinder.find(IScaptapplMDORService.class);
		ScAptApplDO[] scAptApplDOs = applService.find("applyno = '"+applNo+"'", null, FBoolean.FALSE);
		if(scAptApplDOs != null && scAptApplDOs.length > 0){
			IScaptMDORService rService = ServiceFinder.find(IScaptMDORService.class);
			ScAptDO[] scAptDOs = rService.find("id_apt = '"+scAptApplDOs[0].getId_scapt()+"'", null, FBoolean.FALSE);
			if(scAptDOs != null && scAptDOs.length > 0){
				return scAptDOs[0];
			}
		}
		return null;
	}
}
