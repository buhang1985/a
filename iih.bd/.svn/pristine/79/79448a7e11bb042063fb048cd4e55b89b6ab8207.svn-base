package iih.bd.srv.dataimpt;

import iih.bd.dataimport.BDBaseDataImport;
import iih.bd.srv.mrtplvt.d.MrtplVtItmDO;
import iih.bd.srv.mrtplvt.i.IMrtplVtItmDOCudService;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * @author 作者 :huang_junhao
 * @version 创建时间：2017年6月5日 下午2:10:07 类说明： Company: Copyright 2017 by PKU
 *          healthcare IT Co.,Ltd.
 */
public class BdMrtplVtItmDataImptServiceImpl extends BDBaseDataImport<MrtplVtItmDO> {

	@Override
	protected BaseDO getDoInstance() {
		return new MrtplVtItmDO();
	}

	@Override
	protected String[] getCheckNullProps() {
		return new String[] { MrtplVtItmDO.ID_MRTPLVTITM, MrtplVtItmDO.ID_MRTPLVT };
	}

	@Override
	protected void insertToDB(MrtplVtItmDO[] importDatas) throws BizException {
		ServiceFinder.find(IMrtplVtItmDOCudService.class).insert(importDatas);
	}

	@Override
	protected void updateToDB(MrtplVtItmDO[] importDatas) throws BizException {
		ServiceFinder.find(IMrtplVtItmDOCudService.class).update(importDatas);
	}
}
