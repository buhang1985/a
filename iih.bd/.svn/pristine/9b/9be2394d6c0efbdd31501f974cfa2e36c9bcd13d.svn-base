package iih.bd.srv.mrctmca.s;
import iih.bd.srv.mrctmca.d.MrCtmCaDO;
import iih.bd.srv.mrctmca.d.MrctmcaAggDO;
import iih.bd.srv.mrctmca.d.desc.MrCtmCaDODesc;
import iih.bd.srv.mrctmca.i.IMrctmcaCudService;
import iih.bd.srv.mrctmca.i.IMrctmcaRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.AggBDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 医疗记录类型自定义分类AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { IMrctmcaCudService.class, IMrctmcaRService.class }, binding = Binding.JSONRPC)
public class MrctmcaCrudServiceImpl extends BaseAggService<MrctmcaAggDO, MrCtmCaDO>
		implements IMrctmcaCudService, IMrctmcaRService {
	public MrctmcaCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(MrCtmCaDODesc.class), IAppFwTempTbl.tmp_iaw_25.name());
	}

	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getUpdateValidator(MrctmcaAggDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { AggBDReferenceChecker.getInstance() };
	}
}
