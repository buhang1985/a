package iih.bd.fc.dataimpt;

import iih.bd.dataimport.BDBaseDataImport;
import iih.bd.fc.orpltpmtpara.d.OrpltpmtParaDO;
import iih.bd.fc.orpltpmtpara.i.IOrpltpmtparaCudService;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * @author 作者 :huang_junhao
 * @version 创建时间：2017年5月24日 上午10:31:09 </br>
 *          类说明：医嘱执行闭环类型匹配参数导入数据 </br>
 *          Company: Copyright 2017 by PKU healthcare IT Co.,Ltd.
 */
public class BdOrpltpmtParaDataImptServiceImpl extends BDBaseDataImport<OrpltpmtParaDO> {

	@Override
	protected BaseDO getDoInstance() {
		return new OrpltpmtParaDO();
	}

	@Override
	protected String[] getCheckNullProps() {
		return new String[] { OrpltpmtParaDO.ID_ORPLTPMT_PARA, OrpltpmtParaDO.ID_ORPLTP };
	}

	@Override
	protected void insertToDB(OrpltpmtParaDO[] importDatas) throws BizException {
		ServiceFinder.find(IOrpltpmtparaCudService.class).insert(importDatas);
	}

	@Override
	protected void updateToDB(OrpltpmtParaDO[] importDatas) throws BizException {
		ServiceFinder.find(IOrpltpmtparaCudService.class).update(importDatas);
	}
}
