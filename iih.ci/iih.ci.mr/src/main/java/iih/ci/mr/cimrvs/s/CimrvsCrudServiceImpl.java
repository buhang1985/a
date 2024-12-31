package iih.ci.mr.cimrvs.s;

import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.handler.AroundProcesser;
import xap.sys.appfw.bizrule.handler.CompareAroundProcesser;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import iih.ci.mr.cimrvs.d.CiMrVsDO;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import iih.ci.mr.cimrvs.d.desc.CiMrVsDODesc;
import iih.ci.mr.cimrvs.d.CimrvsAggDO;
import iih.ci.mr.cimrvs.i.ICimrvsCudService;
import iih.ci.mr.cimrvs.i.ICimrvsRService;
import iih.ci.mr.cimrvs.rule.MrVsDeleteRule;
import iih.ci.mr.cimrvs.rule.MrVsInsertRule;
import iih.ci.mr.cimrvs.rule.MrVsUpdateRule;

/**
 * 临床生命体征测量AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { ICimrvsCudService.class, ICimrvsRService.class }, binding = Binding.JSONRPC)
public class CimrvsCrudServiceImpl extends BaseAggService<CimrvsAggDO, CiMrVsDO> implements ICimrvsCudService, ICimrvsRService {
	public CimrvsCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(CiMrVsDODesc.class), IAppFwTempTbl.tmp_iaw_05.name());
	}

	/**
	 * 体征信息新增 ；1、新增时记录文书采集记录；2、数据完整性校验
	 */
	@SuppressWarnings("unchecked")
	@Override
	protected void addInsertAfterRule(AroundProcesser<CimrvsAggDO> processor) {
		super.addInsertAfterRule(processor);
		processor.addAfterRule(new MrVsInsertRule<CimrvsAggDO>());
	}

	/**
	 * 体征信息编辑；1、数据完整性校验
	 * 
	 */
	@Override
	protected void addUpdateAfterRule(CompareAroundProcesser<CimrvsAggDO> processor, CimrvsAggDO[] originvos) {
		super.addUpdateAfterRule(processor, originvos);
		processor.addAfterRule(new MrVsUpdateRule<CimrvsAggDO>());
	}

	/**
	 * 体征删除时；1、系统事件不允许删除校验；2、文书采集记录同步更新
	 */
	@SuppressWarnings("unchecked")
	@Override
	protected void addRealDeleteBeforeRule(AroundProcesser<CimrvsAggDO> processer, int versionValidateType) {
		super.addRealDeleteBeforeRule(processer, versionValidateType);
		processer.addBeforeRule(new MrVsDeleteRule<CimrvsAggDO>());
	}
}
