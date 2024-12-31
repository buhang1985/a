package iih.bd.pp.hpsrvorca.s;

import iih.bd.pp.hpsrvorca.d.HPSrvorcaDO;
import iih.bd.pp.hpsrvorca.d.desc.HPSrvorcaDODesc;
import iih.bd.pp.hpsrvorca.i.IHpsrvorcaCudService;
import iih.bd.pp.hpsrvorca.i.IHpsrvorcaRService;
import iih.bd.pp.hpsrvorca.s.bp.SetDosageInfoBp;
import iih.bd.pp.hpsrvorca.s.rule.HpsrvcaAddRule;
import iih.bd.pp.hpsrvorca.s.rule.HpsrvcaUpdateRule;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.handler.AroundProcesser;
import xap.sys.appfw.bizrule.handler.CompareAroundProcesser;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 医保目录对照AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { IHpsrvorcaCudService.class, IHpsrvorcaRService.class }, binding = Binding.JSONRPC)
public class HpsrvorcaCrudServiceImpl extends BaseDOService<HPSrvorcaDO>
		implements IHpsrvorcaCudService, IHpsrvorcaRService {
	public HpsrvorcaCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(HPSrvorcaDODesc.class), IAppFwTempTbl.tmp_iaw_24.name());
	}

	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getUpdateValidator(HPSrvorcaDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void addInsertAfterRule(AroundProcesser<HPSrvorcaDO> processor) {
		super.addInsertAfterRule(processor);
		processor.addAfterRule(new HpsrvcaAddRule());
	}

	@Override
	protected void addUpdateAfterRule(CompareAroundProcesser<HPSrvorcaDO> processor, HPSrvorcaDO[] originvos) {
		super.addUpdateAfterRule(processor, originvos);
		processor.addAfterRule(new HpsrvcaUpdateRule());
	}

	@Override
	public PagingRtnData<HPSrvorcaDO> findByPageInfo(PaginationInfo pg, String whereStr, String orderStr)
			throws BizException {

		PagingRtnData<HPSrvorcaDO> findByPageInfo = super.findByPageInfo(pg, whereStr, orderStr);
		SetDosageInfoBp bp = new SetDosageInfoBp();
		PagingRtnData<HPSrvorcaDO> afterSetDosagePageInfo = bp.exec(findByPageInfo);
		return afterSetDosagePageInfo;
	}

	// @SuppressWarnings("unchecked")
	// @Override
	// protected void addRealDeleteAfterRule(AroundProcesser<HPSrvorcaDO> processor)
	// {
	// super.addRealDeleteAfterRule(processor);
	// processor.addAfterRule(new HpsrvcaDeleteRule());
	// }
}
