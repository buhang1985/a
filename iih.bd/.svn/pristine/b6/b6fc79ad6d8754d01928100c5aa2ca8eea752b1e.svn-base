package iih.bd.mm.dataimpt;

import iih.bd.dataimport.BDBaseDataImport;
import iih.bd.mm.stockdealtype.d.StockDealTypeDO;
import iih.bd.mm.stockdealtype.i.IStockdealtypeCudService;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 库存交易分类数据导入服务实现
 * 
 * @author Administrator
 *
 */
public class MmStcaDataImptServiceImpl extends BDBaseDataImport<StockDealTypeDO> {

	@Override
	protected BaseDO getDoInstance() {
		return new StockDealTypeDO();
	}

	@Override
	protected String[] getCheckNullProps() {
		return new String[] { StockDealTypeDO.ID_MMSTCA, StockDealTypeDO.NAME, StockDealTypeDO.CODE,
				StockDealTypeDO.ID_STTP, StockDealTypeDO.SD_STTP, StockDealTypeDO.ID_DIRECT, StockDealTypeDO.SD_DIRECT,
				StockDealTypeDO.ID_MMTP, StockDealTypeDO.SD_MMTP, StockDealTypeDO.FLAG_SYS };
	}

	@Override
	protected void insertToDB(StockDealTypeDO[] importDatas) throws BizException {
		ServiceFinder.find(IStockdealtypeCudService.class).insert(importDatas);
	}

	@Override
	protected void updateToDB(StockDealTypeDO[] importDatas) throws BizException {
		ServiceFinder.find(IStockdealtypeCudService.class).update(importDatas);
	}

	@Override
	public boolean cleanData() throws BizException {
		DAFacade daFacade = new DAFacade();
		daFacade.execUpdate("delete from BD_MM_STCA where id_mmstca not like '@@@@%' and flag_sys <> 'Y'");
		return true;
	}
}
