package iih.bd.fc.entp.s;

import iih.bd.fc.entp.d.EnTypeDO;
import iih.bd.fc.entp.d.desc.EnTypeDODesc;
import iih.bd.fc.entp.i.IEntpCudService;
import iih.bd.fc.entp.i.IEntpRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.handle.mapping.DORsReferMap;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 流程配置_就诊类型AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { IEntpCudService.class, IEntpRService.class }, binding = Binding.JSONRPC)
public class EntpCrudServiceImpl extends BaseDOService<EnTypeDO> implements
		IEntpCudService, IEntpRService {
	public EntpCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(EnTypeDODesc.class),
				IAppFwTempTbl.tmp_iaw_25.name());
	}

	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getUpdateValidator(EnTypeDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}
	
	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { BDReferenceChecker.getInstance() };
	}

	@Override
	public EnTypeDO[] insert(EnTypeDO... arg0) throws BizException {
		EnTypeDO[] result = super.insert(arg0);
		EnTypeDO[] dos = new DORsReferMap<EnTypeDO>(EnTypeDO.class)
				.convert(result);
		return dos;
	}

	@Override
	public EnTypeDO[] update(EnTypeDO... dos) throws BizException {
		EnTypeDO[] result = super.update(dos);
		EnTypeDO[] filledData = new DORsReferMap<EnTypeDO>(EnTypeDO.class)
				.convert(result);
		return filledData;
	}

	@Override
	public EnTypeDO[] save(EnTypeDO... dos) throws BizException {
		EnTypeDO[] result = super.save(dos);
		EnTypeDO[] filledData = new DORsReferMap<EnTypeDO>(EnTypeDO.class)
				.convert(result);
		return filledData;
	}
}
