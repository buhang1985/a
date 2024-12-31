package iih.ei.sc.s.bp.qry;

import java.util.ArrayList;
import java.util.List;
import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.ei.sc.ws.bean.IsSelfAptableBean;
import iih.sc.apt.i.IScAptOutQryService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

public class IsSelfAptableBP {
	/**
	 * 根据申请单id查询申请单是否允许自助预约
	 * @param id_aptapplys
	 * @param chlType 
	 * @return
	 * @throws BizException
	 */
	public IsSelfAptableBean[] exec(String id_aptapplys, String chlType) throws BizException {
		
		List<IsSelfAptableBean> beanList = new ArrayList<IsSelfAptableBean>();
		if(StringUtil.isEmpty(id_aptapplys)) return null;
		String[] idaptappls = id_aptapplys.split(",");
		IScAptOutQryService iscaptoutqryservice = ServiceFinder.find(IScAptOutQryService.class);
		for (String id_aptappl : idaptappls) {
			IsSelfAptableBean bean = new IsSelfAptableBean();
			FBoolean result = iscaptoutqryservice.isSelfAptOrCanc(id_aptappl,null, IScDictCodeConst.RULE_SC_MT_APT,chlType);
			bean.setId_aptapply(id_aptappl);
			bean.setIsAptable(result.toString());
			beanList.add(bean);
		}
		return beanList.toArray(new IsSelfAptableBean[0]);
	}
}
