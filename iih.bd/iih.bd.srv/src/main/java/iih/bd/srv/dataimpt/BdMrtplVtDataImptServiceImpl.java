package iih.bd.srv.dataimpt;

import iih.bd.dataimport.BDBaseDataImport;
import iih.bd.srv.mrtplvt.d.MrtplVtDO;
import iih.bd.srv.mrtplvt.i.IMrtplvtMDOCudService;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * @author 作者 :huang_junhao
 * @version 创建时间：2017年6月5日 下午2:01:04 类说明： Company: Copyright 2017 by PKU
 *          healthcare IT Co.,Ltd.
 */
public class BdMrtplVtDataImptServiceImpl extends BDBaseDataImport<MrtplVtDO> {

	@Override
	protected BaseDO getDoInstance() {
		return new MrtplVtDO();
	}

	@Override
	protected String[] getCheckNullProps() {
		return new String[] { MrtplVtDO.ID_MRTPLVT, MrtplVtDO.NAME, MrtplVtDO.CODE };
	}

	@Override
	protected void insertToDB(MrtplVtDO[] importDatas) throws BizException {
		ServiceFinder.find(IMrtplvtMDOCudService.class).insert(importDatas);
	}

	@Override
	protected void updateToDB(MrtplVtDO[] importDatas) throws BizException {
		ServiceFinder.find(IMrtplvtMDOCudService.class).insert(importDatas);
	}

}
