package iih.bd.srv.srvpricetable.s.bp.h_bd_price_rp;

import iih.bd.srv.srvpricetable.i.IBdSrvPriceTableUpdateService;
import iih.bd.srv.srvpricetable.s.bp.BdSrvPriceTableUpdateBaseBp;
import iih.bd.srv.srvpricetable.s.bp.h_bd_price_rp.qry.DeleteBdPriceRpQuery;
import iih.bd.srv.srvpricetable.s.bp.h_bd_price_rp.qry.InsertBdPriceRpQuery;
import xap.sys.appfw.orm.utils.ITransQry;

/**
 * 
 * 刷新表BD_PRICE_RP</br>
 * 8.BD_PRICE_RP
 * 
 * @author hao_wu
 * @date 2020年4月23日
 *
 */
public class RefreshBdPriceRpBp extends BdSrvPriceTableUpdateBaseBp {

//	@Override
//	public void update(String condType, String[] condValues) throws BizException {
//		BdSrvPriceTableUpdateLogUtils.info("开始准备更新BD_PRICE_RP,condType:%s,condValues:%s。", condType,
//				JSON.toJSONString(condValues));
//		StopWatch stopWatch = new StopWatch();
//		stopWatch.start();
//
//		if (IBdSrvPriceTableUpdateService.SrvPriceUpdateCondType_Srv.equals(condType)) {
//			String sql = String.format("SELECT DISTINCT ID_SRV FROM BD_PRICE_RP_ITM WHERE %s",
//					SqlUtils.getInSqlByIds("ID_SRV_ITM", condValues));
//			DAFacade daFacade = new DAFacade();
//			@SuppressWarnings("unchecked")
//			List<String> srvIdList = (List<String>) daFacade.execQuery(sql, new ColumnListHandler());
//			if (srvIdList != null && srvIdList.size() > 0) {
//				condValues = srvIdList.toArray(new String[0]);
//			}
//		} else if (IBdSrvPriceTableUpdateService.SrvPriceUpdateCondType_Mm.equals(condType)) {
//			String sql = String.format("SELECT DISTINCT ID_SRV FROM BD_PRICE_RP_ITM WHERE %s",
//					SqlUtils.getInSqlByIds("ID_MM", condValues));
//			DAFacade daFacade = new DAFacade();
//			@SuppressWarnings("unchecked")
//			List<String> srvIdList = (List<String>) daFacade.execQuery(sql, new ColumnListHandler());
//			if (srvIdList != null && srvIdList.size() > 0) {
//				condType = IBdSrvPriceTableUpdateService.SrvPriceUpdateCondType_Srv;
//				condValues = srvIdList.toArray(new String[0]);
//			}
//		}
//
//		stopWatch.stop();
//		BdSrvPriceTableUpdateLogUtils.info("更新BD_PRICE_RP,准备数据完成,耗时:%s,condType:%sms,condValues:%s。",
//				stopWatch.getTime(), condType, JSON.toJSONString(condValues));
//
//		super.update(condType, condValues);
//	}

	@Override
	public String getUpdateTable() {
		return "BD_PRICE_RP";
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
		return null;
	}

	@Override
	public ITransQry getInsertQry(String condType, String[] condValues) {
		return new InsertBdPriceRpQuery(condType, condValues);
	}

	@Override
	public ITransQry getDeleteQry(String condType, String[] condValues) {
		return new DeleteBdPriceRpQuery(condType, condValues);
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
//	
//
//	@SuppressWarnings("unchecked")
//	private void refresh(String condType, String[] condValues) throws BizException {
//		BdSrvPriceTableUpdateLogUtils.info("开始更新BD_PRICE_RP,condType:%s,condValues:%s。", condType,
//				JSON.toJSONString(condValues));
//		StopWatch stopWatch = new StopWatch();
//		stopWatch.start();
//
//		if (IBdSrvPriceTableUpdateService.SrvPriceUpdateCondType_Srv.equals(condType)) {
//			String sql = String.format("SELECT DISTINCT ID_SRV FROM BD_PRICE_RP_ITM WHERE %s",
//					SqlUtils.getInSqlByIds("ID_SRV_ITM", condValues));
//			DAFacade daFacade = new DAFacade();
//			List<String> srvIdList = (List<String>) daFacade.execQuery(sql, new ColumnListHandler());
//			if (srvIdList != null && srvIdList.size() > 0) {
//				condValues = srvIdList.toArray(new String[0]);
//			}
//		} else if (IBdSrvPriceTableUpdateService.SrvPriceUpdateCondType_Mm.equals(condType)) {
//			String sql = String.format("SELECT DISTINCT ID_SRV FROM BD_PRICE_RP_ITM WHERE %s",
//					SqlUtils.getInSqlByIds("ID_MM", condValues));
//			DAFacade daFacade = new DAFacade();
//			List<String> srvIdList = (List<String>) daFacade.execQuery(sql, new ColumnListHandler());
//			if (srvIdList != null && srvIdList.size() > 0) {
//				condType = IBdSrvPriceTableUpdateService.SrvPriceUpdateCondType_Srv;
//				condValues = srvIdList.toArray(new String[0]);
//			}
//		}
//
//		stopWatch.split();
//		BdSrvPriceTableUpdateLogUtils.info("更新BD_PRICE_RP,准备数据完成,耗时:%s,condType:%sms,condValues:%s。",
//				stopWatch.getSplitTime(), condType, JSON.toJSONString(condValues));
//
//		delete(condType, condValues);
//
//		insert(condType, condValues);
//
//		stopWatch.split();
//		BdSrvPriceTableUpdateLogUtils.info("更新BD_PRICE_RP完成,condType:%s,condValues:%s,耗时:%sms。", condType,
//				JSON.toJSONString(condValues), stopWatch.getSplitTime());
//	}
//
//	private void delete(String condType, String[] condValues) throws BizException {
//		BdSrvPriceTableUpdateLogUtils.info("开始删除BD_PRICE_RP,condType:%s,condValues:%s。", condType,
//				JSON.toJSONString(condValues));
//		StopWatch stopWatch = new StopWatch();
//		stopWatch.start();
//
//		DeleteBdPriceRpQuery qry = new DeleteBdPriceRpQuery(condType, condValues);
//
//		DAFacade daFacade = new DAFacade();
//		int rowCount = daFacade.execUpdate(qry.getQrySQLStr(), qry.getQryParameter(null));
//
//		stopWatch.split();
//		BdSrvPriceTableUpdateLogUtils.info("删除BD_PRICE_RP完成,condType:%s,condValues:%s,条数:%s,耗时:%sms。", condType,
//				JSON.toJSONString(condValues), rowCount, stopWatch.getSplitTime());
//	}
//
//	private void insert(String condType, String[] condValues) throws BizException {
//		BdSrvPriceTableUpdateLogUtils.info("开始生成BD_PRICE_RP,condType:%s,condValues:%s。", condType,
//				JSON.toJSONString(condValues));
//		StopWatch stopWatch = new StopWatch();
//		stopWatch.start();
//
//		InsertBdPriceRpQuery qry = new InsertBdPriceRpQuery(condType, condValues);
//
//		DAFacade daFacade = new DAFacade();
//		int rowCount = daFacade.execUpdate(qry.getQrySQLStr(), qry.getQryParameter(null));
//
//		stopWatch.split();
//		BdSrvPriceTableUpdateLogUtils.info("生成BD_PRICE_RP完成,condType:%s,condValues:%s,条数:%s,耗时:%sms。", condType,
//				JSON.toJSONString(condValues), rowCount, stopWatch.getSplitTime());
//	}
//
//	private void refreshNext(String condType, String[] condValues) throws BizException {
//
//	}

}
