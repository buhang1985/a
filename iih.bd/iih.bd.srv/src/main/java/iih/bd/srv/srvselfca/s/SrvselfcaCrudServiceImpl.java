package iih.bd.srv.srvselfca.s;

import java.util.Arrays;

import iih.bd.srv.srvselfca.d.SrvSlefCateDO;
import iih.bd.srv.srvselfca.d.desc.SrvSlefCateDODesc;
import iih.bd.srv.srvselfca.i.ISrvselfcaCudService;
import iih.bd.srv.srvselfca.i.ISrvselfcaRService;
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
 * 组件服务自定义分类AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { ISrvselfcaCudService.class, ISrvselfcaRService.class }, binding = Binding.JSONRPC)
public class SrvselfcaCrudServiceImpl extends BaseDOService<SrvSlefCateDO>
		implements ISrvselfcaCudService, ISrvselfcaRService {

	public SrvselfcaCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(SrvSlefCateDODesc.class), IAppFwTempTbl.tmp_iaw_21.name());
	}

	@Override
	protected Validator[] getInsertValidator() {
		// TODO Auto-generated method stub
		return new Validator[] { new BDUniqueRuleValidate(), NullValueValidator.createMDNullValueValidator(
				new SrvSlefCateDO().getDODesc(), Arrays.asList(SrvSlefCateDO.NAME, SrvSlefCateDO.CODE))

		};
	}

	@Override
	protected Validator[] getUpdateValidator(SrvSlefCateDO[] oldDOs) {
		// TODO Auto-generated method stub
		return new Validator[] { new BDUniqueRuleValidate(), NullValueValidator.createMDNullValueValidator(
				new SrvSlefCateDO().getDODesc(), Arrays.asList(SrvSlefCateDO.NAME, SrvSlefCateDO.CODE)) };
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { BDReferenceChecker.getInstance() };
	}
}
