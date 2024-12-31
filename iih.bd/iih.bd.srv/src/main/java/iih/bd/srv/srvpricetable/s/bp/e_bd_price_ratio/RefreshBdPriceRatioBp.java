package iih.bd.srv.srvpricetable.s.bp.e_bd_price_ratio;

import iih.bd.srv.srvpricetable.i.IBdSrvPriceTableUpdateService;
import iih.bd.srv.srvpricetable.s.bp.BdSrvPriceTableUpdateBaseBp;
import iih.bd.srv.srvpricetable.s.bp.e_bd_price_ratio.qry.DeleteBdPriceRatioQuery;
import iih.bd.srv.srvpricetable.s.bp.e_bd_price_ratio.qry.InsertBdPriceRatioQuery;
import iih.bd.srv.srvpricetable.s.bp.f_bd_price_comp_ratio_itm.RefreshBdPriceCompRatioItmBp;
import xap.sys.appfw.orm.utils.ITransQry;

/**
 * 
 * 刷新表BD_PRICE_RATIO</br>
 * 5.BD_PRICE_RATIO
 * 
 * @author hao_wu
 * @date 2020年4月23日
 *
 */
public class RefreshBdPriceRatioBp extends BdSrvPriceTableUpdateBaseBp {

	@Override
	public String getUpdateTable() {
		return "BD_PRICE_RATIO";
	}

	@Override
	public String[] getAllowCondTypes() {
		return new String[] { IBdSrvPriceTableUpdateService.SrvPriceUpdateCondType_ReBuild,
				IBdSrvPriceTableUpdateService.SrvPriceUpdateCondType_Srv,
				IBdSrvPriceTableUpdateService.SrvPriceUpdateCondType_Mm,
				IBdSrvPriceTableUpdateService.SrvPriceUpdateCondType_PriPat };
	}

	@Override
	public BdSrvPriceTableUpdateBaseBp getNextBp() {
		return new RefreshBdPriceCompRatioItmBp();
	}

	@Override
	public ITransQry getInsertQry(String condType, String[] condValues) {
		return new InsertBdPriceRatioQuery(condType, condValues);
	}

	@Override
	public ITransQry getDeleteQry(String condType, String[] condValues) {
		return new DeleteBdPriceRatioQuery(condType, condValues);
	}

//	public void exec(String condType, String[] condValues) throws BizException {
//		if (IBdSrvPriceTableUpdateService.SrvPriceUpdateCondType_ReBuild.equals(condType)
//				|| IBdSrvPriceTableUpdateService.SrvPriceUpdateCondType_Srv.equals(condType)
//				|| IBdSrvPriceTableUpdateService.SrvPriceUpdateCondType_Mm.equals(condType)
//				|| IBdSrvPriceTableUpdateService.SrvPriceUpdateCondType_PriPat.equals(condType)) {
//			refresh(condType, condValues);
//		}
//		refreshNext(condType, condValues);
//	}
//
//	private void refresh(String condType, String[] condValues) throws BizException {
//		BdSrvPriceTableUpdateLogUtils.info("开始更新BD_PRICE_RATIO,condType:%s,condValues:%s。", condType,
//				JSON.toJSONString(condValues));
//		StopWatch stopWatch = new StopWatch();
//		stopWatch.start();
//
//		delete(condType, condValues);
//
//		insert(condType, condValues);
//
//		stopWatch.split();
//		BdSrvPriceTableUpdateLogUtils.info("更新BD_PRICE_RATIO完成,condType:%s,condValues:%s,耗时:%sms。", condType,
//				JSON.toJSONString(condValues), stopWatch.getSplitTime());
//	}
//
//	private void delete(String condType, String[] condValues) throws BizException {
//		BdSrvPriceTableUpdateLogUtils.info("开始删除BD_PRICE_RATIO,condType:%s,condValues:%s。", condType,
//				JSON.toJSONString(condValues));
//		StopWatch stopWatch = new StopWatch();
//		stopWatch.start();
//
//		DeleteBdPriceRatioQuery qry = new DeleteBdPriceRatioQuery(condType, condValues);
//
//		DAFacade daFacade = new DAFacade();
//		int rowCount = daFacade.execUpdate(qry.getQrySQLStr(), qry.getQryParameter(null));
//
//		stopWatch.split();
//		BdSrvPriceTableUpdateLogUtils.info("删除BD_PRICE_RATIO完成,condType:%s,condValues:%s,条数:%s,耗时:%sms。", condType,
//				JSON.toJSONString(condValues), rowCount, stopWatch.getSplitTime());
//	}
//
//	private void insert(String condType, String[] condValues) throws BizException {
//		BdSrvPriceTableUpdateLogUtils.info("开始生成BD_PRICE_RATIO,condType:%s,condValues:%s。", condType,
//				JSON.toJSONString(condValues));
//		StopWatch stopWatch = new StopWatch();
//		stopWatch.start();
//
//		InsertBdPriceRatioQuery qry = new InsertBdPriceRatioQuery(condType, condValues);
//
//		DAFacade daFacade = new DAFacade();
//		int rowCount = daFacade.execUpdate(qry.getQrySQLStr(), qry.getQryParameter(null));
//
//		stopWatch.split();
//		BdSrvPriceTableUpdateLogUtils.info("生成BD_PRICE_RATIO完成,condType:%s,condValues:%s,条数:%s,耗时:%sms。", condType,
//				JSON.toJSONString(condValues), rowCount, stopWatch.getSplitTime());
//	}
//
//	private void refreshNext(String condType, String[] condValues) throws BizException {
//		RefreshBdPriceCompRatioItmBp bp = new RefreshBdPriceCompRatioItmBp();
//		bp.exec(condType, condValues);
//	}
}
