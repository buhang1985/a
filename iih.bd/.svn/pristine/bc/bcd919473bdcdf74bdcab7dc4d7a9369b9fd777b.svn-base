package iih.bd.srv.dataimpt;

import iih.bd.dataimport.BDBaseDataImport;
import iih.bd.fc.entp.d.EnTypeDO;
import iih.bd.fc.entp.i.IEntpCudService;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 就诊类型数据导入服务实现
 * 
 * @author Administrator
 *
 */
public class EntpDataImptServiceImpl extends BDBaseDataImport<EnTypeDO> {

	@Override
	protected BaseDO getDoInstance() {
		return new EnTypeDO();
	}

	@Override
	protected String[] getCheckNullProps() {
		return new String[] { EnTypeDO.ID_ENTP, EnTypeDO.NAME, EnTypeDO.CODE };
	}

	@Override
	protected void insertToDB(EnTypeDO[] importDatas) throws BizException {
		ServiceFinder.find(IEntpCudService.class).insert(importDatas);
	}

	@Override
	protected void updateToDB(EnTypeDO[] importDatas) throws BizException {
		ServiceFinder.find(IEntpCudService.class).update(importDatas);
	}

	@Override
	public boolean cleanData() throws BizException {
		DAFacade daFacade = new DAFacade();
		daFacade.execUpdate("delete from bd_entp where issys<>'Y'");
		return true;
	}
}
