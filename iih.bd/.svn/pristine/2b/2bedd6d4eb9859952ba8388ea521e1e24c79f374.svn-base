package iih.bd.srv.mrctmca.s;

import org.apache.commons.lang.StringUtils;

import iih.bd.base.utils.SqlUtils;
import iih.bd.srv.mrctmca.d.MrCaCtmItmDO;
import iih.bd.srv.mrctmca.d.MrCtmCaDO;
import iih.bd.srv.mrctmca.d.desc.MrCaCtmItmDODesc;
import iih.bd.srv.mrctmca.i.IMrCaCtmItmDOCudService;
import iih.bd.srv.mrctmca.i.IMrCaCtmItmDORService;
import iih.bd.utils.BdEnvContextUtil;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
import xap.sys.permfw.pub.BDReferenceChecker;

/**
 * 医疗记录类型自定义分类主实体CRUD服务实现
 */
@Service(serviceInterfaces = { IMrCaCtmItmDOCudService.class, IMrCaCtmItmDORService.class }, binding = Binding.JSONRPC)
public class MrCaCtmItmDOCrudServiceImpl extends BaseDOService<MrCaCtmItmDO>
		implements IMrCaCtmItmDOCudService, IMrCaCtmItmDORService {

	public MrCaCtmItmDOCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(MrCaCtmItmDODesc.class), IAppFwTempTbl.tmp_iaw_23.name());
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { BDReferenceChecker.getInstance() };
	}

	@Override
	public MrCaCtmItmDO[] find(String whereStr, String orderStr, FBoolean isLazy) throws BizException {
		String bdModeWherePart = getBdModeWherePart();
		if (StringUtils.isNotBlank(whereStr.trim())) {
			whereStr = String.format("%s and %s", whereStr, bdModeWherePart);
		} else {
			whereStr = bdModeWherePart;
		}
		return super.find(whereStr, orderStr, isLazy);
	}

	@Override
	public PagingRtnData<MrCaCtmItmDO> findByPageInfo(PaginationInfo pg, String whereStr, String orderStr)
			throws BizException {
		String bdModeWherePart = getBdModeWherePart();
		if (StringUtils.isNotBlank(whereStr.trim())) {
			whereStr = String.format("%s and %s", whereStr, bdModeWherePart);
		} else {
			whereStr = bdModeWherePart;
		}
		return super.findByPageInfo(pg, whereStr, orderStr);
	}

	@Override
	public MrCaCtmItmDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO, String orderStr, FBoolean isLazy)
			throws BizException {
		String wherePart = SqlUtils.getWherePartByQCond(qryRootNodeDTO, MrCaCtmItmDODesc.CLASS_FULLNAME);
		return this.find(wherePart, orderStr, isLazy);
	}

	@Override
	public PagingRtnData<MrCaCtmItmDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO, String orderStr,
			PaginationInfo pg) throws BizException {
		String wherePart = SqlUtils.getWherePartByQCond(qryRootNodeDTO, MrCaCtmItmDODesc.CLASS_FULLNAME);
		return this.findByPageInfo(pg, wherePart, orderStr);
	}

	@Override
	public MrCaCtmItmDO[] findByAttrValString(String attr, String value) throws BizException {
		String bdModeWherePart = getBdModeWherePart();
		String whereStr = String.format("%s = '%s' and %s", attr, value, bdModeWherePart);
		return this.find(whereStr, "", FBoolean.FALSE);
	}

	@Override
	public MrCaCtmItmDO[] findByAttrValStrings(String attr, String[] values) throws BizException {
		String bdModeWherePart = getBdModeWherePart();
		String whereStr = String.format("%s and %s", SqlUtils.getInSqlByIds(attr, values), bdModeWherePart);
		return this.find(whereStr, "", FBoolean.FALSE);
	}

	@Override
	public MrCaCtmItmDO[] findByAttrValList(String attr, FArrayList values) throws BizException {
		String bdModeWherePart = getBdModeWherePart();
		@SuppressWarnings("unchecked")
		String whereStr = String.format("%s and %s", SqlUtils.getInSqlByIds(attr, values), bdModeWherePart);
		return this.find(whereStr, "", FBoolean.FALSE);
	}

	/**
	 * 获取管控条件语句
	 * 
	 * @return
	 */
	private String getBdModeWherePart() {
		return String.format("Id_mrcactm in (select Id_mrcactm from bd_mrca_ctm where %s)",
				BdEnvContextUtil.processEnvContext(new MrCtmCaDO(), false));
	}
}
