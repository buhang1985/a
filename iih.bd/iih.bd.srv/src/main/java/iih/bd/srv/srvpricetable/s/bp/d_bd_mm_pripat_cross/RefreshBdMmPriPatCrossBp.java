package iih.bd.srv.srvpricetable.s.bp.d_bd_mm_pripat_cross;

import iih.bd.srv.srvpricetable.i.IBdSrvPriceTableUpdateService;
import iih.bd.srv.srvpricetable.s.bp.BdSrvPriceTableUpdateBaseBp;
import iih.bd.srv.srvpricetable.s.bp.d_bd_mm_pripat_cross.qry.DeleteBdMmPriPatCrossQuery;
import iih.bd.srv.srvpricetable.s.bp.d_bd_mm_pripat_cross.qry.InsertBdMmPriPatCrossQuery;
import iih.bd.srv.srvpricetable.s.bp.e_bd_price_ratio.RefreshBdPriceRatioBp;
import xap.sys.appfw.orm.utils.ITransQry;

/**
 * 
 * 刷新表BD_MM_PRIPAT_CROSS</br>
 * 4.BD_MM_PRIPAT_CROSS
 * 
 * @author hao_wu
 * @date 2020年4月23日
 *
 */
public class RefreshBdMmPriPatCrossBp extends BdSrvPriceTableUpdateBaseBp {

	@Override
	public String getUpdateTable() {
		return "BD_MM_PRIPAT_CROSS";
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
		return new RefreshBdPriceRatioBp();
	}

	@Override
	public ITransQry getInsertQry(String condType, String[] condValues) {
		return new InsertBdMmPriPatCrossQuery(condType, condValues);
	}

	@Override
	public ITransQry getDeleteQry(String condType, String[] condValues) {
		return new DeleteBdMmPriPatCrossQuery(condType, condValues);
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
//		BdSrvPriceTableUpdateLogUtils.info("开始更新BD_MM_PRIPAT_CROSS,condType:%s,condValues:%s。", condType,
//				JSON.toJSONString(condValues));
//		StopWatch stopWatch = new StopWatch();
//		stopWatch.start();
//
//		delete(condType, condValues);
//
//		insert(condType, condValues);
//
//		stopWatch.split();
//		BdSrvPriceTableUpdateLogUtils.info("更新BD_MM_PRIPAT_CROSS完成,condType:%s,condValues:%s,耗时:%sms。", condType,
//				JSON.toJSONString(condValues), stopWatch.getSplitTime());
//	}
//
//	private void delete(String condType, String[] condValues) throws BizException {
//		BdSrvPriceTableUpdateLogUtils.info("开始删除BD_MM_PRIPAT_CROSS,condType:%s,condValues:%s。", condType,
//				JSON.toJSONString(condValues));
//		StopWatch stopWatch = new StopWatch();
//		stopWatch.start();
//
//		DeleteBdMmPriPatCrossQuery qry = new DeleteBdMmPriPatCrossQuery(condType, condValues);
//
//		DAFacade daFacade = new DAFacade();
//		int rowCount = daFacade.execUpdate(qry.getQrySQLStr(), qry.getQryParameter(null));
//
//		stopWatch.split();
//		BdSrvPriceTableUpdateLogUtils.info("删除BD_MM_PRIPAT_CROSS完成,condType:%s,condValues:%s,条数:%s,耗时:%sms。", condType,
//				JSON.toJSONString(condValues), rowCount, stopWatch.getSplitTime());
//	}
//
//	private void insert(String condType, String[] condValues) throws BizException {
//		BdSrvPriceTableUpdateLogUtils.info("开始生成BD_MM_PRIPAT_CROSS,condType:%s,condValues:%s。", condType,
//				JSON.toJSONString(condValues));
//		StopWatch stopWatch = new StopWatch();
//		stopWatch.start();
//
//		InsertBdMmPriPatCrossQuery qry = new InsertBdMmPriPatCrossQuery(condType, condValues);
//
//		DAFacade daFacade = new DAFacade();
//		int rowCount = daFacade.execUpdate(qry.getQrySQLStr(), qry.getQryParameter(null));
//
//		stopWatch.split();
//		BdSrvPriceTableUpdateLogUtils.info("生成BD_MM_PRIPAT_CROSS完成,condType:%s,condValues:%s,条数:%s,耗时:%sms。", condType,
//				JSON.toJSONString(condValues), rowCount, stopWatch.getSplitTime());
//	}
//
//	private void refreshNext(String condType, String[] condValues) throws BizException {
//		RefreshBdPriceRatioBp bp = new RefreshBdPriceRatioBp();
//		bp.exec(condType, condValues);
//	}
}
