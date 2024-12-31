package iih.bd.srv.mrnurplan.s;
import java.util.Arrays;

import iih.bd.srv.mrnurplan.d.MrNurPlanDO;
import iih.bd.srv.mrnurplan.d.desc.MrNurPlanDODesc;
import iih.bd.srv.mrnurplan.i.IMrnurplanCudService;
import iih.bd.srv.mrnurplan.i.IMrnurplanRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.bdfw.validator.NullValueValidator;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;


/**
 * 护理计划内容模板AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IMrnurplanCudService.class,IMrnurplanRService.class}, binding=Binding.JSONRPC)
public class MrnurplanCrudServiceImpl extends BaseDOService<MrNurPlanDO> implements IMrnurplanCudService,IMrnurplanRService {
    public MrnurplanCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MrNurPlanDODesc.class),IAppFwTempTbl.tmp_iaw_06.name()); 
    }

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { BDReferenceChecker.getInstance() };
	}

	@Override
	protected Validator[] getInsertValidator() {

		return new Validator[] { new BDUniqueRuleValidate(), NullValueValidator.createMDNullValueValidator(new MrNurPlanDO().getDODesc(), Arrays.asList(MrNurPlanDO.NAME, MrNurPlanDO.CODE,MrNurPlanDO.ID_DIDEF)) };
	}

	@Override
	protected Validator[] getUpdateValidator(MrNurPlanDO[] oldDos) {

		return new Validator[] {new BDUniqueRuleValidate(), NullValueValidator.createMDNullValueValidator(new MrNurPlanDO().getDODesc(), Arrays.asList(MrNurPlanDO.NAME, MrNurPlanDO.CODE,MrNurPlanDO.ID_DIDEF)) };
	}
}
