package iih.pi.reg.pat.s.rule;

import iih.pi.reg.i.IPiPatConst;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PatiAggDO;
import iih.pi.reg.s.customer.guoji.PiPatUpdateChisBP;
import iih.pi.reg.s.customer.guoji.util.PiPatCreateByChisUtil;
import iih.pi.utils.PiParamUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.bizrule.ICompareRule;

/**
 * 更新CHIS患者规则
 * 
 * @author hao_wu
 *
 */
public class UpdateChisPatRule implements ICompareRule<PatiAggDO> {

	@Override
	public void process(PatiAggDO[] newPatAggs, PatiAggDO[] oldPatAggs) throws BizException {
		if (newPatAggs == null || newPatAggs.length <= 0) {
			return;
		}

		for (int i = 0; i < newPatAggs.length; i++) {
			updateChisPat(newPatAggs[i], oldPatAggs[i]);
		}
	}

	/**
	 * 更新CHIS患者数据
	 * 
	 * @param patAggDo
	 * @param oldPatAggDo
	 * @throws BizException
	 */
	private void updateChisPat(PatiAggDO patAggDo, PatiAggDO oldPatAggDo) throws BizException {
		PatDO patDo = patAggDo.getParentDO();
		PatDO oldPatDo = oldPatAggDo.getParentDO();

		if (FBoolean.TRUE.equals(patDo.getFg_ignorechis()) || IPiPatConst.PAT_ORIGIN_CHIS.equals(patDo.getOrigin())) {
			// 忽略本次CHIS调用或来源为CHIS的数据不更新CHIS患者信息
			return;
		}

		FBoolean syncPatToChis = PiParamUtils.getSyncPatToChis();
		FBoolean createPatToChis = PiParamUtils.getCreatePatToChis();
		if (FBoolean.FALSE.equals(createPatToChis) && FBoolean.FALSE.equals(syncPatToChis)) {
			// 提前检查参数，如不需要同步和创建，则返回
			return;
		}

		boolean chisHas = PiPatCreateByChisUtil.existsPatInChis(patDo.getCode());
		patDo.setFg_chisexist(new FBoolean(chisHas));

		if (chisHas && FBoolean.TRUE.equals(syncPatToChis)) {
			// CHIS中存在且需要同步患者信息到CHIS，则使用IIH数据更新CHIS数据
			PiPatUpdateChisBP chisUBp = new PiPatUpdateChisBP();
			chisUBp.exec(patAggDo, oldPatAggDo);
		}

		if (!FBoolean.TRUE.equals(oldPatDo.getFg_realname()) && FBoolean.TRUE.equals(patDo.getFg_realname()) && !chisHas
				&& FBoolean.TRUE.equals(createPatToChis)) {
			// 患者进行实名认证且CHIS中不存在且需要在CHIS中创建患者时，在CHIS创建患者
			PiPatCreateByChisUtil.createPat(patAggDo);
		}
	}
}
