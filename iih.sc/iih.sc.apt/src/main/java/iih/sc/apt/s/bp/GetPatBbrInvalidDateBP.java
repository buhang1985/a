package iih.sc.apt.s.bp;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.xbd.udi.d.UdidocDO;
import xap.sys.xbd.udi.i.IUdidocRService;

/**
 * 计算黑名单失效日期
 * @author yzh
 *
 */
public class GetPatBbrInvalidDateBP {
	public FDateTime exec(FDateTime now,String id_bbrtp) throws BizException{
		if(now == null || StringUtil.isEmpty(id_bbrtp)) return null;
		int invalidDays = this.getInvalidTime(id_bbrtp);
		if(invalidDays != -999){
			FDateTime result =  now.getDateTimeAfter(invalidDays);
			return new FDateTime(result.getBeginDate(), new FTime("00:00:00"));
		}
		return null;
	}
	
	/**
	 * 获取黑名单类型上的失效时长
	 * @param id_bbrtp
	 * @return
	 * @throws BizException
	 */
	private int getInvalidTime(String id_bbrtp) throws BizException{
		IUdidocRService udiService = ServiceFinder.find(IUdidocRService.class);
		UdidocDO udi = udiService.findById(id_bbrtp);
		if(udi != null){
			String ctrl1 = udi.getCtrl1();
			if(!StringUtil.isEmpty(ctrl1) &&  isInt(ctrl1)){
				return Integer.valueOf(ctrl1);
			}
		}
		return -999;
	}
	
	/**
	 * 判断是否是整型
	 * @param str
	 * @return
	 */
	private static boolean isInt(String str) {
        try {
            Integer.valueOf(str);
            return true;
        } catch (Exception e) {
        return false;
        }
    }
}
