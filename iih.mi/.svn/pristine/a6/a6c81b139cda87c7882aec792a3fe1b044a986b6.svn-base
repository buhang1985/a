package iih.mi.mc.s.ctrlcore.mimcwholecheck.rule.bp;

import iih.bd.base.utils.AppUtils;
import iih.bd.base.utils.DateTimeUtils;
import iih.bl.cg.i.IBlOutQryService;
import iih.ci.ord.i.ICiOrdQryService;
import iih.mi.itf2.util.MiParamUtil;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList2;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
/**
 * 查询历史医嘱
 * @author LIM
 *
 */
public class GetHisOrderListBP {
	/**
	 * 查询历史医嘱信息
	 * 
	 * @param id_pat 患者id
	 * @return
	 * @throws BizException
	 */
	public FArrayList2 exec(String id_pat,String id_hp) throws BizException {
		if(StringUtil.isEmpty(id_pat)||StringUtil.isEmpty(id_hp)){
			return null;
		}
		// 获取当前日期
		FDateTime endTime = AppUtils.getServerDateTime();
		Integer queryDays=MiParamUtil.MI3001(id_hp);
		FDateTime startTime = DateTimeUtils.getDateTimeBefore(endTime, queryDays);

		//查询历史的医嘱数据
		ICiOrdQryService ICiOrdQryService = ServiceFinder.find(ICiOrdQryService.class);
		IBlOutQryService oqService=ServiceFinder.find(IBlOutQryService.class);
		FArrayList2 ciOrderList = oqService.getRuleEffeData(ICiOrdQryService.getCiorderDTOs(id_pat, startTime, endTime));
		return ciOrderList;
	}
}
