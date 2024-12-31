package iih.bd.res.s.dataimport;

import iih.bd.dataimport.BDBaseDataImport;
import iih.bd.res.bed.d.BedAttrDefDO;
import iih.bd.res.bed.i.IBedattrdefCudService;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 床位特征定义--数据导入服务
 * 
 * @author yank
 *
 */
public class BedAttrDefImportServiceImpl extends BDBaseDataImport<BedAttrDefDO> {

	@Override
	protected BaseDO getDoInstance() {
		return new BedAttrDefDO();
	}

	@Override
	protected String[] getCheckNullProps() {
		return new String[] { BedAttrDefDO.ID_BEDATTRDEF, BedAttrDefDO.ID_BEDATTR_TP, BedAttrDefDO.SD_BEDATTR_TP,
				BedAttrDefDO.NAME, BedAttrDefDO.VAL, BedAttrDefDO.ID_GRP, BedAttrDefDO.ID_ORG };
	}

	@Override
	protected void insertToDB(BedAttrDefDO[] importDatas) throws BizException {
		ServiceFinder.find(IBedattrdefCudService.class).insert(importDatas);
	}

	@Override
	protected void updateToDB(BedAttrDefDO[] importDatas) throws BizException {
		ServiceFinder.find(IBedattrdefCudService.class).update(importDatas);
	}

}
