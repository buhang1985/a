package iih.pi.reg.s.ws;

import iih.bd.base.utils.AppUtils;
import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.pi.params.PiParams;
import iih.pi.reg.i.IPiPatConst;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PatiAggDO;
import iih.pi.reg.pat.d.PiPatHpDO;
import iih.pi.reg.pat.i.IPatiCudService;
import iih.pi.reg.s.ws.base.PatInfoUpdateBaseWSBP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 患者自费转北京医保
 * 
 * @author ly 2018/01/06
 * @author hao_wu 2018-5-18 已注册医保卡不进行重复
 *
 */
public class PatBindBJHPWSBP extends PatInfoUpdateBaseWSBP {

	/**
	 * 患者自费转北京医保
	 * 
	 * @param patCode
	 *            患者编码
	 * @param cardNo
	 *            卡号
	 * @return 0:成功</br>
	 *         -1:失败,参数为空 </br>
	 *         -2:失败,医保卡号不符合规则 </br>
	 *         -3:患者不存在</br>
	 * @throws BizException
	 */
	public Integer exec(String patCode, String cardNo) throws BizException {

		if (StringUtil.isEmpty(patCode) || StringUtil.isEmpty(cardNo))
			return -1;

		if (cardNo.length() != 12)
			return -2;

		PatiAggDO agg = super.getPatAgg(patCode);
		if (agg == null)
			return -3;

		IPatiCudService cudService = ServiceFinder.find(IPatiCudService.class);

		PatDO patDo = agg.getParentDO();
		String defaultPatCaId = new PiParams().ENOP0170();
		patDo.setStatus(DOStatus.UPDATED);
		patDo.setId_paticate(defaultPatCaId);

		// boolean hasBjHp = false;
		// if (!ArrayUtil.isEmpty(hpDos)) {
		// for (PiPatHpDO hpDo : hpDos) {
		// if (!IPiPatConst.BJ_ID_HP.equals(hpDo.getId_hp()))
		// continue;
		//
		// if (!cardNo.equals(hpDo.getNo_hp())) {
		// // 更新医保卡号
		// hpDo.setNo_hp(cardNo);
		// hpDo.setStatus(DOStatus.UPDATED);
		// }
		//
		// hasBjHp = true;
		// break;
		// }
		// }

		// if (hasBjHp) {
		// cudService.update(new PatiAggDO[] { agg });
		// return 0;
		// }

		// 新增医保计划
		PiPatHpDO[] hpDos = agg.getPiPatHpDO();
		boolean hpNoRegistered = hpNoRegistered(hpDos, cardNo);
		if (!hpNoRegistered) {
			addNewHpCard(agg, cardNo);
		}

		cudService.update(new PatiAggDO[] { agg });
		return 0;
	}

	/**
	 * 判断医保卡是否已注册
	 * 
	 * @param hpDos
	 * @param cardNo
	 * @return
	 */
	private boolean hpNoRegistered(PiPatHpDO[] hpDos, String cardNo) {
		if (hpDos == null || hpDos.length < 0) {
			return false;
		}

		for (PiPatHpDO piPatHpDO : hpDos) {
			if (IPiPatConst.BJ_ID_HP.equals(piPatHpDO.getId_hp()) && cardNo.equals(piPatHpDO.getNo_hp())
					&& ((IPiDictCodeConst.ID_HP_MODE_ACTIVE_ENABLE.equals(piPatHpDO.getMode_hp())
							&& FBoolean.TRUE.equals(piPatHpDO.getFg_act()))
							|| (IPiDictCodeConst.ID_HP_MODE_ACTIVE_TIMEREGION.equals(piPatHpDO.getMode_hp())
									&& (piPatHpDO.getDt_e() == null
											|| piPatHpDO.getDt_e().after(AppUtils.getServerDateTime()))))) {
				// 北京医保且医保号相同且有效的医保信息，则认为已注册
				return true;
			}
		}
		return false;
	}

	/***
	 * 添加新医保卡
	 * 
	 * @param agg
	 * @param cardNo
	 */
	private void addNewHpCard(PatiAggDO agg, String cardNo) {
		PatDO patDo = agg.getParentDO();
		PiPatHpDO[] hpDos = agg.getPiPatHpDO();

		List<PiPatHpDO> hpList = new ArrayList<PiPatHpDO>();
		if (!ArrayUtil.isEmpty(hpDos)) {
			hpList.addAll(Arrays.asList(hpDos));
		}

		PiPatHpDO hpDo = new PiPatHpDO();
		hpDo.setId_pat(patDo.getId_pat());
		hpDo.setSortno(hpList.size() + 1);
		hpDo.setNo_hp(cardNo);
		hpDo.setId_hp(IPiPatConst.BJ_ID_HP);
		hpDo.setFg_deft(hpList.size() == 0 ? FBoolean.TRUE : FBoolean.FALSE);
		hpDo.setMode_hp(IPiDictCodeConst.ID_HP_MODE_ACTIVE_ENABLE);
		hpDo.setDt_b(new FDateTime());
		hpDo.setFg_act(FBoolean.TRUE);
		hpDo.setStatus(DOStatus.NEW);
		hpList.add(hpDo);
		agg.setPiPatHpDO(hpList.toArray(new PiPatHpDO[0]));

		// 新增医保时修改患者条码
		patDo.setBarcode_chis(cardNo.substring(0, 9));
	}
}
