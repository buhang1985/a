package iih.sc.sch.s.bp;

import org.apache.commons.lang.StringUtils;

import iih.sc.scbd.i.IScBdQryService;
import iih.sc.scbd.schedulechl.d.SchedulechlDO;
import iih.sc.scbd.schedulechl.d.desc.SchedulechlDODesc;
import iih.sc.scbd.schedulechl.i.ISchedulechlMDORService;
import iih.sc.sch.scsch.d.ScSchChlDO;
import iih.sc.sch.scsch.d.desc.ScSchChlDODesc;
import iih.sc.sch.scsch.i.IScSchChlDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 获取排班渠道BP
 * 
 * @author yank
 */
public class GetSchChlBP {
	/**
	 * 获取排班渠道
	 * 
	 * @param schId 排班ID
	 * @param chlTp 渠道类型
	 * @return
	 * @throws BizException
	 * @author yank
	 */
	public ScSchChlDO exec(String schId, String chlTp) throws BizException {
		if (StringUtils.isBlank(schId) || StringUtils.isBlank(chlTp))
			return null;
		// 1、根据渠道类型查询预约渠道
		IScBdQryService chlRService = ServiceFinder.find(IScBdQryService.class);
		SchedulechlDO[] chlDOs = chlRService.getChlByTp(chlTp);
		if (ArrayUtil.isEmpty(chlDOs))
			return null;

		// 2、根据排班和渠道ID，查询排班渠道
		StringBuilder whereBuilder = new StringBuilder();
		whereBuilder.append(String.format("%s.id_scchl='%s'", ScSchChlDODesc.TABLE_ALIAS_NAME, chlDOs[0].getId_scchl()));
		whereBuilder.append(String.format(" and %s.id_sch='%s'", ScSchChlDODesc.TABLE_ALIAS_NAME, schId));
		IScSchChlDORService chlDORService = ServiceFinder.find(IScSchChlDORService.class);
		ScSchChlDO[] schChlDOs = chlDORService.find(whereBuilder.toString(), null, FBoolean.TRUE);
		return ArrayUtil.isEmpty(schChlDOs) ? null : schChlDOs[0];
	}
}
