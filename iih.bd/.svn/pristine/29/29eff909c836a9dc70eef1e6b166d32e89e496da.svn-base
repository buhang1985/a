package iih.bd.pp.bdbltpl.s;

import org.apache.commons.lang.StringUtils;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.dataimport.BDBaseDataImport;
import iih.bd.pp.bdbltpl.d.BdBlTplDO;
import iih.bd.pp.bdbltpl.i.IBdbltplMDOCudService;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

public class TplImportServiceImpl extends BDBaseDataImport<BdBlTplDO> {

	@Override
	protected BaseDO getDoInstance() {
		return new BdBlTplDO();
	}

	@Override
	protected String[] getCheckNullProps() {
		return new String[] { BdBlTplDO.ID_BLTPL, BdBlTplDO.ID_BLTPLTP, BdBlTplDO.SD_BLTPLTP, BdBlTplDO.ID_OWTP,
				BdBlTplDO.SD_OWTP, BdBlTplDO.NAME, BdBlTplDO.CODE, BdBlTplDO.ID_GRP, BdBlTplDO.ID_ORG };
	}

	@Override
	protected void insertToDB(BdBlTplDO[] importDatas) throws BizException {
		ServiceFinder.find(IBdbltplMDOCudService.class).insert(importDatas);
	}

	@Override
	protected void updateToDB(BdBlTplDO[] importDatas) throws BizException {
		ServiceFinder.find(IBdbltplMDOCudService.class).update(importDatas);
	}

	@Override
	protected void checkNotNullProp(BdBlTplDO[] importData) throws BizException {
		super.checkNotNullProp(importData);

		for (BdBlTplDO bdBlTplDO : importData) {
			if (IBdSrvDictCodeConst.SD_OWTP_DEPARTMENT.equals(bdBlTplDO.getSd_owtp())
					&& StringUtils.isEmpty(bdBlTplDO.getId_dep())) {
				String msg = String.format("自定义费用模板\"%s\"适用范围为科室，科室信息不允许为空。", bdBlTplDO.getName());
				throw new BizException(msg);
			} else if (IBdSrvDictCodeConst.SD_OWTP_PERSONAL.equals(bdBlTplDO.getSd_owtp())
					&& StringUtils.isEmpty(bdBlTplDO.getId_emp())) {
				String msg = String.format("自定义费用模板\"%s\"适用范围为个人，个人信息不允许为空。", bdBlTplDO.getName());
				throw new BizException(msg);
			}
		}
	}
}
