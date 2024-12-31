package iih.pi.reg.pat.s.rule;

import iih.pi.reg.i.IPiPatConst;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PatiAggDO;
import iih.pi.reg.s.customer.guoji.util.PiPatCreateByChisUtil;
import iih.pi.utils.PiParamUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.bizrule.IRule;

/**
 * 创建患者到CHIS规则
 * 
 * @author hao_wu
 *
 */
public class InsertPatToChisRule implements IRule<PatiAggDO> {

	@Override
	public void process(PatiAggDO... patAggs) throws BizException {
		if (patAggs == null || patAggs.length <= 0) {
			return;
		}

		for (PatiAggDO patiAggDO : patAggs) {
			insertPatToChis(patiAggDO);
		}
	}

	/***
	 * 创建患者到CHIS
	 * 
	 * @param patAggDo
	 * @throws BizException
	 */
	private void insertPatToChis(PatiAggDO patAggDo) throws BizException {
		PatDO patDo = patAggDo.getParentDO();

		if (IPiPatConst.PAT_ORIGIN_CHIS.equals(patDo.getOrigin()) || !FBoolean.TRUE.equals(patDo.getFg_realname())) {
			// 来源为CHIS或未实名认证的的数据不在CHIS中创建患者
			return;
		}

		FBoolean createPatToChis = PiParamUtils.getCreatePatToChis();
		if (FBoolean.TRUE.equals(createPatToChis)) {
			// 需要在CHIS中创建患者时
			boolean chisHas = PiPatCreateByChisUtil.existsPatInChis(patDo);
			patDo.setFg_chisexist(new FBoolean(chisHas));

			if (!chisHas) {
				// CHIS中不存在该患者，则在CHIS中注册该患者
				PiPatCreateByChisUtil.createPat(patAggDo);
				if ("provide by chis".equals(patDo.getCode())) {
					throw new BizException("在CHIS中创建患者后，患者编码未生成。");
				}
				return;
			}
		}
	}
}
