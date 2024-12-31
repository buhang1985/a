package iih.bd.srv.ems.s;

import java.util.Arrays;

import iih.bd.srv.ems.d.EmsCateDO;
import iih.bd.srv.ems.d.desc.EmsCateDODesc;
import iih.bd.srv.ems.i.IEmscateCudService;
import iih.bd.srv.ems.i.IEmscateRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.TreeBaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.bdfw.validator.NullValueValidator;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 医疗单分类AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { IEmscateCudService.class, IEmscateRService.class }, binding = Binding.JSONRPC)
public class EmscateCrudServiceImpl extends TreeBaseDOService<EmsCateDO>
		implements IEmscateCudService, IEmscateRService {

	public EmscateCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(EmsCateDODesc.class), IAppFwTempTbl.tmp_iaw_21.name());
	}

	@Override
	protected Validator[] getInsertValidator() {
		// TODO Auto-generated method stub
		return new Validator[] { new BDUniqueRuleValidate(), NullValueValidator
				.createMDNullValueValidator(new EmsCateDO().getDODesc(), Arrays.asList(EmsCateDO.NAME, EmsCateDO.CODE))

		};
	}

	@Override
	protected Validator[] getUpdateValidator(EmsCateDO[] oldDOs) {
		// TODO Auto-generated method stub
		return new Validator[] { new BDUniqueRuleValidate(), NullValueValidator.createMDNullValueValidator(
				new EmsCateDO().getDODesc(), Arrays.asList(EmsCateDO.NAME, EmsCateDO.CODE)) };
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { BDReferenceChecker.getInstance() };
	}
}
