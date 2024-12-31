package iih.bd.srv.freqdef.s;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.srv.freqdef.d.FreqDefDO;
import iih.bd.srv.freqdef.d.FreqTimeDO;
import iih.bd.srv.freqdef.d.FreqdefAggDO;
import iih.bd.srv.freqdef.d.desc.FreqDefDODesc;
import iih.bd.srv.freqdef.i.IFreqdefCudService;
import iih.bd.srv.freqdef.i.IFreqdefRService;
import iih.bd.srv.freqdef.s.rule.FreqdefAggFiledValueChangCheckRule;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.i.IBaseDO;
import xap.mw.coreitf.i.IDODesc;
import xap.sys.appfw.bizrule.handler.CompareAroundProcesser;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.bdfw.validator.AggNullValueValidator;
import xap.sys.permfw.pub.AggBDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 组件AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { IFreqdefCudService.class, IFreqdefRService.class }, binding = Binding.JSONRPC)
public class FreqdefCrudServiceImpl extends BaseAggService<FreqdefAggDO, FreqDefDO>
		implements IFreqdefCudService, IFreqdefRService {

	public FreqdefCrudServiceImpl() {

		super(DescManager.getInstance().getDODesc(FreqDefDODesc.class), IAppFwTempTbl.tmp_iaw_14.name());
	}

	@Override
	protected Validator[] getInsertValidator() {
		Map<IDODesc, List<String>> m = new HashMap<>();
		m.put(new FreqDefDO().getDODesc(), Arrays.asList(FreqDefDO.NAME));
		return new Validator[] { new BDUniqueRuleValidate(),
				AggNullValueValidator.createMDNullValueValidator(new FreqdefAggDO().getAggDesc(), m) };
	}

	@Override
	protected Validator[] getUpdateValidator(FreqdefAggDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { AggBDReferenceChecker.getInstance(new String[] { "bd_freq_time" }, false, false) };
	}

	@Override
	public FreqdefAggDO findById(String id) throws BizException {
		FreqdefAggDO freqdefAggDO = super.findById(id);
		if (freqdefAggDO == null)
			return null;
		setupDOAfterSearch(freqdefAggDO);
		return freqdefAggDO;
	}

	@Override
	public FreqdefAggDO[] update(FreqdefAggDO[] aggs) throws BizException {
		for (FreqdefAggDO freqdefAggDO : aggs) {
			setupDOBeforSave(freqdefAggDO);
		}
		return super.update(aggs);
	}

	@Override
	public FreqdefAggDO[] insert(FreqdefAggDO[] arg0) throws BizException {
		for (FreqdefAggDO freqdefAggDO : arg0) {
			setupDOBeforSave(freqdefAggDO);
		}
		return super.insert(arg0);
	}

	/**
	 * 保存前设置子表（第几天，第几周）
	 * 
	 * @param freqdefAggDO
	 * @throws BizException
	 */
	private void setupDOBeforSave(FreqdefAggDO freqdefAggDO) throws BizException {
		FreqDefDO parentData = freqdefAggDO.getParentDO();
		if (parentData == null)
			return;
		IBaseDO[] freqTimeDOList = freqdefAggDO.getChildren(FreqTimeDO.class);
		if (freqTimeDOList == null)
			return;

		for (IBaseDO iBaseDO : freqTimeDOList) {

			FreqTimeDO freqTimeDO = (FreqTimeDO) iBaseDO;
			if (parentData.getSd_frequnitct().equals(IBdSrvDictCodeConst.SD_FREQNUNITCT_DAY)) {
				Integer day = freqTimeDO.getDay();
				if (day == null)
					throw new BizException("第几天不允许为空。");
				freqTimeDO.setWdno(day);
			} else if (parentData.getSd_frequnitct().equals(IBdSrvDictCodeConst.SD_FREQNUNITCT_WEEK)) {
				Integer week = freqTimeDO.getWeek();
				if (week == null)
					throw new BizException("第几周不允许为空。");
				freqTimeDO.setWdno(week);
			}
		}
	}

	/**
	 * 查询后设置计算字段 (第几天；第几周)
	 * 
	 * @param aggDo
	 */
	private void setupDOAfterSearch(FreqdefAggDO aggDo) {
		FreqDefDO parentData = aggDo.getParentDO();
		if (parentData == null)
			return;
		FreqTimeDO[] freqTimeDOList = (FreqTimeDO[]) aggDo.getChildren(FreqTimeDO.class);
		if (freqTimeDOList == null)
			return;

		for (FreqTimeDO freqTimeDO : freqTimeDOList) {
			if (parentData.getSd_frequnitct().equals(IBdSrvDictCodeConst.SD_FREQNUNITCT_DAY)) {
				freqTimeDO.setDay(freqTimeDO.getWdno());
			} else if (parentData.getSd_frequnitct().equals(IBdSrvDictCodeConst.SD_FREQNUNITCT_WEEK)) {
				freqTimeDO.setWeek(freqTimeDO.getWdno());
			}
		}
	}

	@Override
	protected void addUpdateBeforeRule(CompareAroundProcesser<FreqdefAggDO> processer, FreqdefAggDO[] originvos) {
		super.addUpdateBeforeRule(processer, originvos);
		processer.addAfterRule(new FreqdefAggFiledValueChangCheckRule());
	}
}
