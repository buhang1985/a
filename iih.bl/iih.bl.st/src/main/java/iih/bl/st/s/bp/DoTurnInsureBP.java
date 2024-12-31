package iih.bl.st.s.bp;

import iih.bl.params.BlParams;
import iih.en.pv.entplan.d.EntHpDO;
import iih.en.pv.entplan.i.IEnthpRService;
import iih.en.pv.i.IEnOutCmdService;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

public class DoTurnInsureBP {
	/**
	 * 自费转医保功能
	 * 
	 * @param idEns
	 *            就诊编号集合
	 * @param noHp
	 *            医保卡号
	 * @throws BizException
	 * @author liwenqiang
	 */
	public void exec(String[] idEns, String noHp, String idHp) throws BizException {

		if (StringUtil.isEmpty(noHp) || idEns == null || idEns.length == 0) {
			return;
		}

		StringBuilder idenStr = new StringBuilder();
		for (int i = 0; i < idEns.length; i++) {
			idenStr.append("'" + idEns[i] + "'");
			if (i != idEns.length - 1) {
				idenStr.append(",");
			}
		}

		// 2判断是否有就诊信息信息
		IPativisitRService pativisitRService = ServiceFinder.find(IPativisitRService.class);
		PatiVisitDO[] patiVisitDOS = pativisitRService.find(" id_ent in (" + idenStr + ") and ds =0 ", null, FBoolean.FALSE);
		if (patiVisitDOS == null || patiVisitDOS.length <= 0) {
			throw new BizException("没有就诊信息,无法转换医保！");// 没有就诊信息
		}

		IEnthpRService enthpRService = ServiceFinder.find(IEnthpRService.class);
		// 3转医保患者
		IEnOutCmdService enOutCmdService = ServiceFinder.find(IEnOutCmdService.class);
		// 3.1查询该医保号的主医保计划
		StringBuilder mainStr = new StringBuilder();
		mainStr.append("id_hp='" + idHp + "' ");
		mainStr.append(" and no_hp='" + noHp + "'");
		mainStr.append(" and fg_maj='Y' ");
		EntHpDO[] mainEntHpDos = enthpRService.find(mainStr.toString(), null, FBoolean.FALSE);
		// 查询医保病人分类id
		BlParams params = new BlParams();
		String id_pripat = params.BLSTOEP0017();
		if (StringUtil.isEmpty(id_pripat)) {
			throw new BizException("参数BLSTOEP0017未维护");
		}
		// 3.2对该次结算的每一次就诊进行转换医保患者
		for (String idEn : idEns) {
			if (mainEntHpDos == null || mainEntHpDos.length <= 0) {// 无医保计划,默认转换为北京医保
				EntHpDO entHpDo = new EntHpDO();
				entHpDo.setId_enthp(null);
				entHpDo.setId_ent(idEn);
				entHpDo.setFg_fundpay(FBoolean.TRUE);
				entHpDo.setFg_hp_card(FBoolean.FALSE);
				entHpDo.setStatus(DOStatus.NEW);
				entHpDo.setId_hp(idHp);// 北京医保
				entHpDo.setFg_maj(FBoolean.TRUE);
				entHpDo.setNo_hp(noHp);
				enOutCmdService.entChangePatCa(idEn, patiVisitDOS[0].getId_patca(), patiVisitDOS[0].getId_pripat(), patiVisitDOS[0].getId_hp(), id_pripat, patiVisitDOS[0].getId_pripat(), entHpDo);
			} else {// 转化为主医保计划
				EntHpDO entHpDo = new EntHpDO();
				entHpDo = mainEntHpDos[0];
				entHpDo.setId_enthp(null);
				entHpDo.setId_ent(idEn);
				entHpDo.setFg_fundpay(FBoolean.TRUE);
				entHpDo.setFg_hp_card(FBoolean.FALSE);
				entHpDo.setStatus(DOStatus.UPDATED);
				enOutCmdService.entChangePatCa(idEn, patiVisitDOS[0].getId_patca(), patiVisitDOS[0].getId_pripat(), patiVisitDOS[0].getId_hp(), id_pripat, patiVisitDOS[0].getId_pripat(), entHpDo);

			}
		}

	}
}
