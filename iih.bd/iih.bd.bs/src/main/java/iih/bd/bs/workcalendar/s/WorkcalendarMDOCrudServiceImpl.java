package iih.bd.bs.workcalendar.s;

import iih.bd.bs.workcalendar.d.WorkCalendarDO;
import iih.bd.bs.workcalendar.d.desc.WorkCalendDateDODesc;
import iih.bd.bs.workcalendar.d.desc.WorkCalendYearDODesc;
import iih.bd.bs.workcalendar.d.desc.WorkCalendarDODesc;
import iih.bd.bs.workcalendar.i.IWorkcalendarMDOCudService;
import iih.bd.bs.workcalendar.i.IWorkcalendarMDORService;
import iih.bd.bs.workcalendar.s.rule.DeleteYearAndDateRule;
import iih.bd.bs.workcalendar.s.rule.GenerateWorkCalendarYearAndDateRule;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.handler.AroundProcesser;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;

/**
 * 工作日历主实体CRUD服务实现
 */
@Service(serviceInterfaces = { IWorkcalendarMDOCudService.class,
		IWorkcalendarMDORService.class }, binding = Binding.JSONRPC)
public class WorkcalendarMDOCrudServiceImpl extends BaseDOService<WorkCalendarDO>
		implements IWorkcalendarMDOCudService, IWorkcalendarMDORService {

	public WorkcalendarMDOCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(WorkCalendarDODesc.class), IAppFwTempTbl.tmp_iaw_02.name());
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { BDReferenceChecker
				.getInstance(new String[] { WorkCalendYearDODesc.TABLE_NAME, WorkCalendDateDODesc.TABLE_NAME }) };
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void addInsertAfterRule(AroundProcesser<WorkCalendarDO> processor) {
		super.addInsertAfterRule(processor);
		processor.addAfterRule(new GenerateWorkCalendarYearAndDateRule());
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void addRealDeleteBeforeRule(AroundProcesser<WorkCalendarDO> processer, int versionValidateType) {
		super.addRealDeleteBeforeRule(processer, versionValidateType);
		processer.addBeforeRule(new DeleteYearAndDateRule());
	}
}
