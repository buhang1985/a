package iih.bd.res.s.dataimport;

import iih.bd.dataimport.BDBaseDataImport;
import iih.bd.res.bed.d.BedAttrDO;
import iih.bd.res.bed.i.IBedAttrDOCudService;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 床位特征--数据导入服务
 * 
 * @author yank
 * @author hao_wu 2018-5-28 国际住院正式使用该导入类进行数据导入
 *
 */
public class BedAttrImportServiceImpl extends BDBaseDataImport<BedAttrDO> {

	@Override
	protected BaseDO getDoInstance() {
		return new BedAttrDO();
	}

	@Override
	protected String[] getCheckNullProps() {
		return new String[] { BedAttrDO.ID_BEDATTR, BedAttrDO.ID_BED, BedAttrDO.ID_ATTRDEF, BedAttrDO.ID_BEDATTR_TP,
				BedAttrDO.SD_BEDATTR_TP, BedAttrDO.VAL };
	}

	@Override
	protected void insertToDB(BedAttrDO[] importDatas) throws BizException {
		ServiceFinder.find(IBedAttrDOCudService.class).insert(importDatas);
	}

	@Override
	protected void updateToDB(BedAttrDO[] importDatas) throws BizException {
		ServiceFinder.find(IBedAttrDOCudService.class).update(importDatas);
	}
}
