package iih.ci.ord.s.bp.ems.save.op;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.utils.GetCiOrdEnInfoUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.BizRuntimeException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.xbd.udi.d.UdidocDO;
import xap.sys.xbd.udi.i.IUdidocRService;

public class CheckExcessiveReasonBp {
	
	public void exe(CiEmsDTO ciEms) throws BizException {
		// 只判断西成药
		if(!ciEms.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_WESTDRUG)){
			return ;
		}
		String reasonname="门诊";
		Boolean isEren=new GetCiOrdEnInfoUtils().isEren(ciEms);
		int maxUseDays = 7;
		if(isEren) {
			maxUseDays=3;
			reasonname="急诊";
		}
		
		if(ciEms.getId_excessive_reason()!=null) {
		UdidocDO udi=ServiceFinder.find(IUdidocRService.class).findById(ciEms.getId_excessive_reason());
		if(udi!=null) {
			String val=udi.getCtrl1();
			if(isEren) {
				val=udi.getCtrl2();
			}
			if(val!=null&&!"0".equals(val)) {
				maxUseDays=Integer.parseInt(val);
				reasonname=reasonname+udi.getName();
			}
			if(CiOrdUtils.isEmpty(val)){
				maxUseDays=ciEms.getDays_or().intValue();
			}
		}

	}
		if(ciEms.getDays_or()>maxUseDays)
		{
			String msg=reasonname+"用药超过"+maxUseDays+"天，请填写超量开单原因。";
			if(ciEms.getId_excessive_reason()!=null) {
				msg=reasonname+"用药超过"+maxUseDays+"天，不允许用药。";
			}
			throw new BizRuntimeException(msg);
		}
	}

}
