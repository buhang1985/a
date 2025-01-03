package iih.bd.srv.medsrv.s;
import iih.bd.srv.medsrv.d.MedSrvDrugDO;
import iih.bd.srv.medsrv.d.desc.MedSrvDrugDODesc;
import iih.bd.srv.medsrv.i.IMedSrvDrugDOCudService;
import iih.bd.srv.medsrv.i.IMedSrvDrugDORService;
import iih.bd.srv.medsrv.s.rule.MedSrvDrugInsertOrUpdateBeforeRule;
import iih.bd.srv.medsrv.s.rule.MedSrvDrugPropChangCheckRule;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.handler.AroundProcesser;
import xap.sys.appfw.bizrule.handler.CompareAroundProcesser;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;

/**
 * 医疗服务主实体CRUD服务实现
 */
@Service(serviceInterfaces={IMedSrvDrugDOCudService.class,IMedSrvDrugDORService.class}, binding=Binding.JSONRPC)
public class MedSrvDrugDOCrudServiceImpl extends BaseDOService<MedSrvDrugDO> implements IMedSrvDrugDOCudService,IMedSrvDrugDORService {

    public MedSrvDrugDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MedSrvDrugDODesc.class),IAppFwTempTbl.tmp_iaw_29.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
    
    @SuppressWarnings("unchecked")
	@Override
	protected void addInsertBeforeRule(AroundProcesser<MedSrvDrugDO> processer) {
		super.addInsertBeforeRule(processer);
		processer.addBeforeRule(new MedSrvDrugInsertOrUpdateBeforeRule());
	}

	@Override
	protected void addUpdateBeforeRule(CompareAroundProcesser<MedSrvDrugDO> processer, MedSrvDrugDO[] originvos) {
		super.addUpdateBeforeRule(processer, originvos);
		processer.addBeforeRule(new MedSrvDrugInsertOrUpdateBeforeRule());
		processer.addBeforeRule(new MedSrvDrugPropChangCheckRule());
	}
}

