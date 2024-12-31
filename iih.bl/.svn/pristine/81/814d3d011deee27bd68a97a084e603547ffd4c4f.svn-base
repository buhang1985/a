package iih.bl.cg.api.s.bp;

import org.apache.commons.lang.ArrayUtils;

import iih.bd.pp.hp.d.HPDO;
import iih.bd.pp.hp.i.IHpMDORService;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitRService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 判断就诊是否存在医保计划
 * 
 * @author LIM
 *
 */
public class GetEntExistsHpBP {
	/**
	 * 手机app，自助机判断缴费信息是否存在医保计划
	 * 
	 * @param id_ent
	 * @param applyNos
	 * @param bjHpNo
	 *            北京医保id 手机app传空
	 * @return
	 * @throws BizException
	 */
	public String exec(String id_ent, String[] applyNos, String bjHpNo) throws BizException {
		String msg = "";
		IPativisitRService ent = ServiceFinder.find(IPativisitRService.class);
		PatiVisitDO entDO = ent.findById(id_ent);
		if (entDO != null) {
			// 如果医保计划字段不为空，则返回提示信息
			if (!StringUtil.isEmpty(entDO.getId_hp())&&!("~").equals(entDO.getId_hp()) && !("").equals(entDO.getId_hp()) && !(bjHpNo).equals(entDO.getId_hp())) {
				if (!ArrayUtils.isEmpty(applyNos)) {
					msg = "处方号：";
					for (String applyno : applyNos) {
						msg += applyno + ",";
					}
				}
				// 查询医保计划名称
				IHpMDORService hpDORService = ServiceFinder.find(IHpMDORService.class);
				HPDO hpDo = hpDORService.findById(entDO.getId_hp());
				if (hpDo != null) {
					msg += "医保计划：" +hpDo.getName() + ",";
				}
				msg += "您需要到窗口缴费!";
			}
		}
		return msg;
	}
}
