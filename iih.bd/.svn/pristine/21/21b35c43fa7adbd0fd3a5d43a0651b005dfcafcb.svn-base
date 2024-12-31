package iih.bd.srv.srvpricetable.s.bp.b_bd_price_ratio_tmp;

import iih.bd.srv.srvpricetable.i.IBdSrvPriceTableUpdateService;
import iih.bd.srv.srvpricetable.s.bp.BdSrvPriceTableUpdateBaseBp;
import iih.bd.srv.srvpricetable.s.bp.b_bd_price_ratio_tmp.qry.DeleteBdPriceRatioTmpQuery;
import iih.bd.srv.srvpricetable.s.bp.b_bd_price_ratio_tmp.qry.InsertBdPriceRatioTmpQuery;
import iih.bd.srv.srvpricetable.s.bp.c_bd_mm_price_pkg.RefreshBdMmPricePkgBp;
import xap.sys.appfw.orm.utils.ITransQry;

/**
 * 
 * 刷新表BD_PRICE_RATIO_TMP</br>
 * 2.BD_PRICE_RATIO_TMP
 * 
 * @author hao_wu
 * @date 2020年4月23日
 *
 */
public class RefreshBdPriceRatioTmpBp extends BdSrvPriceTableUpdateBaseBp {

	@Override
	public String getUpdateTable() {
		return "BD_PRICE_RATIO_TMP";
	}

	@Override
	public String[] getAllowCondTypes() {
		return new String[] { IBdSrvPriceTableUpdateService.SrvPriceUpdateCondType_ReBuild,
				IBdSrvPriceTableUpdateService.SrvPriceUpdateCondType_PriPat,
				IBdSrvPriceTableUpdateService.SrvPriceUpdateCondType_Srv };
	}

	@Override
	public BdSrvPriceTableUpdateBaseBp getNextBp() {
		return new RefreshBdMmPricePkgBp();
	}

	@Override
	public ITransQry getInsertQry(String condType, String[] condValues) {
		return new InsertBdPriceRatioTmpQuery(condType, condValues);
	}

	@Override
	public ITransQry getDeleteQry(String condType, String[] condValues) {
		return new DeleteBdPriceRatioTmpQuery(condType, condValues);
	}

//	public void exec(String condType, String[] condValues) throws BizException {
//		if (IBdSrvPriceTableUpdateService.SrvPriceUpdateCondType_ReBuild.equals(condType)
//				|| IBdSrvPriceTableUpdateService.SrvPriceUpdateCondType_PriPat.equals(condType)
//				|| IBdSrvPriceTableUpdateService.SrvPriceUpdateCondType_Srv.equals(condType)) {
//			refresh(condType, condValues);
//		}
//		refreshNext(condType, condValues);
//	}
//
//	private void refresh(String condType, String[] condValues) throws BizException {
//		BdSrvPriceTableUpdateLogUtils.info("开始更新BD_PRICE_RATIO_TMP,condType:%s,condValues:%s。", condType,
//				JSON.toJSONString(condValues));
//		StopWatch stopWatch = new StopWatch();
//		stopWatch.start();
//
//		delete(condType, condValues);
//
//		insert(condType, condValues);
//
//		stopWatch.split();
//		BdSrvPriceTableUpdateLogUtils.info("更新BD_PRICE_RATIO_TMP完成,condType:%s,condValues:%s,耗时:%sms。", condType,
//				JSON.toJSONString(condValues), stopWatch.getSplitTime());
//	}
//
//	private void delete(String condType, String[] condValues) throws BizException {
//		BdSrvPriceTableUpdateLogUtils.info("开始删除BD_PRICE_RATIO_TMP,condType:%s,condValues:%s。", condType,
//				JSON.toJSONString(condValues));
//		StopWatch stopWatch = new StopWatch();
//		stopWatch.start();
//
//		DeleteBdPriceRatioTmpQuery qry = new DeleteBdPriceRatioTmpQuery(condType, condValues);
//
//		DAFacade daFacade = new DAFacade();
//		int rowCount = daFacade.execUpdate(qry.getQrySQLStr(), qry.getQryParameter(null));
//
//		stopWatch.split();
//		BdSrvPriceTableUpdateLogUtils.info("删除BD_PRICE_RATIO_TMP完成,condType:%s,condValues:%s,条数:%s,耗时:%sms。", condType,
//				JSON.toJSONString(condValues), rowCount, stopWatch.getSplitTime());
//	}
//
//	private void insert(String condType, String[] condValues) throws BizException {
//		BdSrvPriceTableUpdateLogUtils.info("开始生成BD_PRICE_RATIO_TMP,condType:%s,condValues:%s。", condType,
//				JSON.toJSONString(condValues));
//		StopWatch stopWatch = new StopWatch();
//		stopWatch.start();
//
//		InsertBdPriceRatioTmpQuery qry = new InsertBdPriceRatioTmpQuery(condType, condValues);
//
//		DAFacade daFacade = new DAFacade();
//		int rowCount = daFacade.execUpdate(qry.getQrySQLStr(), qry.getQryParameter(null));
//
//		stopWatch.split();
//		BdSrvPriceTableUpdateLogUtils.info("生成BD_PRICE_RATIO_TMP完成,condType:%s,condValues:%s,条数:%s,耗时:%sms。", condType,
//				JSON.toJSONString(condValues), rowCount, stopWatch.getSplitTime());
//	}
//
//	private void refreshNext(String condType, String[] condValues) throws BizException {
//		RefreshBdMmPricePkgBp bp = new RefreshBdMmPricePkgBp();
//		bp.exec(condType, condValues);
//	}
}
