package iih.ei.sc.s.bp.qry;

import java.util.ArrayList;
import java.util.List;
import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.ei.sc.ws.bean.IsSelfCancableBean;
import iih.sc.apt.i.IScAptOutQryService;
import iih.sc.apt.scaptappl.d.ScAptApplDO;
import iih.sc.apt.scaptappl.i.IScaptapplMDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

public class IsSelfCancableBP {
	/**
	 * 根据申请单id查询申请单是否允许自助取消预约
	 * @param chlType 
	 * @param id_aptapplys
	 * @return
	 * @throws BizException
	 */
	public IsSelfCancableBean[] exec(String id_apts,String rule_type, String chlType) throws BizException {
		List<IsSelfCancableBean> beanList = new ArrayList<IsSelfCancableBean>();
		if(StringUtil.isEmpty(id_apts)) return null;
		String[] idapts = id_apts.split(",");
		IScaptapplMDORService iscaptapplmdorservice = ServiceFinder.find(IScaptapplMDORService.class);
		ScAptApplDO[] appls = iscaptapplmdorservice.findByIds(idapts, FBoolean.FALSE);
		IScAptOutQryService iscaptoutqryservice = ServiceFinder.find(IScAptOutQryService.class);
		for (ScAptApplDO appl : appls) {
			IsSelfCancableBean bean = new IsSelfCancableBean();
			bean.setId_apt(appl.getId_aptappl());
			if(!StringUtil.isEmpty(appl.getId_scapt())){
				FBoolean result = iscaptoutqryservice.isSelfAptOrCanc(null ,appl.getId_scapt(), rule_type,chlType);
				bean.setIsCancable(result.toString());
			}else{
				bean.setIsCancable(FBoolean.FALSE.toString());
			}
			beanList.add(bean);
		}
		return beanList.toArray(new IsSelfCancableBean[0]);
	}
}
