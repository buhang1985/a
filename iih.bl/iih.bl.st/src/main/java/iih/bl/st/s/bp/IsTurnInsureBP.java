package iih.bl.st.s.bp;

import iih.en.pv.entplan.d.EntHpDO;
import iih.en.pv.entplan.i.IEnthpRService;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitRService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

public class IsTurnInsureBP {
	/**
	 * 是否已经是医保患者 如果是报出异常
	 * 
	 * @param idEns
	 * @throws BizException
	 */
	public void exec(String[] idEns) throws BizException {

		if (idEns == null || idEns.length == 0) {
			return;
		}

		StringBuilder idenStr = new StringBuilder();
		for (int i = 0; i < idEns.length; i++) {
			idenStr.append("'" + idEns[i] + "'");
			if (i != idEns.length - 1) {
				idenStr.append(",");
			}
		}
		// 1.判断是否已经是医保患者
		IEnthpRService enthpRService = ServiceFinder.find(IEnthpRService.class);
		StringBuilder whereStr = new StringBuilder();
		whereStr.append("id_hp='0001AA1000000001871V' and fg_maj='Y' and id_ent in ( ");
		whereStr.append(idenStr);
		whereStr.append(" )  and fg_fundpay='Y' and fg_hp_card='N' ");
		EntHpDO[] entHpDos = enthpRService.find(whereStr.toString(), null, FBoolean.FALSE);
		if (entHpDos != null && entHpDos.length > 0) {
			throw new BizException("该患者已转为了医保患者！");// 已是医保患者
		}

		// 2判断是否有就诊信息信息
		IPativisitRService pativisitRService = ServiceFinder.find(IPativisitRService.class);
		PatiVisitDO[] patiVisitDOS = pativisitRService.find(" id_ent in (" + idenStr + ") and ds =0 ", null, FBoolean.FALSE);
		if (patiVisitDOS == null || patiVisitDOS.length <= 0) {
			throw new BizException("没有就诊信息,无法转换医保！");// 没有就诊信息
		}
	}
}
