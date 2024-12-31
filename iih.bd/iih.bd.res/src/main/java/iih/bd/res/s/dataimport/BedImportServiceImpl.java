package iih.bd.res.s.dataimport;

import iih.bd.dataimport.BDBaseDataImport;
import iih.bd.res.bed.d.Bdbed;
import iih.bd.res.bed.i.IBedMDOCudService;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 床位--数据导入服务
 * 
 * @author yank
 *
 */
public class BedImportServiceImpl extends BDBaseDataImport<Bdbed> {

	@Override
	protected BaseDO getDoInstance() {
		return new Bdbed();
	}

	@Override
	protected String[] getCheckNullProps() {
		return new String[] { Bdbed.ID_BED, Bdbed.CODE, Bdbed.NAME, Bdbed.ID_GRP, Bdbed.ID_ORG };
	}

	@Override
	protected void insertToDB(Bdbed[] importDatas) throws BizException {
		ServiceFinder.find(IBedMDOCudService.class).insert(importDatas);
	}

	@Override
	protected void updateToDB(Bdbed[] importDatas) throws BizException {
		ServiceFinder.find(IBedMDOCudService.class).update(importDatas);
	}
}
