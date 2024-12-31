package iih.bd.srv.srvcate.s;

import java.util.Arrays;

import iih.bd.srv.srvcate.d.SrvCateDO;
import iih.bd.srv.srvcate.d.desc.SrvCateDODesc;
import iih.bd.srv.srvcate.i.ISrvcateCudService;
import iih.bd.srv.srvcate.i.ISrvcateRService;
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
 * 医疗服务基本分类AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { ISrvcateCudService.class, ISrvcateRService.class }, binding = Binding.JSONRPC)
public class SrvcateCrudServiceImpl extends TreeBaseDOService<SrvCateDO>
		implements ISrvcateCudService, ISrvcateRService {

	public SrvcateCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(SrvCateDODesc.class), IAppFwTempTbl.tmp_iaw_08.name());
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { BDReferenceChecker.getInstance() };
	}

	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate(), NullValueValidator
				.createMDNullValueValidator(new SrvCateDO().getDODesc(), Arrays.asList(SrvCateDO.NAME, SrvCateDO.CODE))

		};

	}

	@Override
	protected Validator[] getUpdateValidator(SrvCateDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate(), NullValueValidator.createMDNullValueValidator(
				new SrvCateDO().getDODesc(), Arrays.asList(SrvCateDO.NAME, SrvCateDO.CODE)) };

	}
}
