package iih.bd.srv.srvpricetable.s.bp.a_bd_srv_pripat_cross;

import iih.bd.srv.srvpricetable.i.IBdSrvPriceTableUpdateService;
import iih.bd.srv.srvpricetable.s.bp.BdSrvPriceTableUpdateBaseBp;
import iih.bd.srv.srvpricetable.s.bp.a_bd_srv_pripat_cross.qry.DeleteBdSrvPriPatCrossQuery;
import iih.bd.srv.srvpricetable.s.bp.a_bd_srv_pripat_cross.qry.InsertBdSrvPriPatCrossQuery;
import iih.bd.srv.srvpricetable.s.bp.b_bd_price_ratio_tmp.RefreshBdPriceRatioTmpBp;
import xap.sys.appfw.orm.utils.ITransQry;

/**
 * 
 * 刷新表BD_SRV_PRIPAT_CROSS</br>
 * 1.BD_SRV_PRIPAT_CROSS
 * 
 * @author hao_wu
 * @date 2020年4月23日
 *
 */
public class RefreshBdSrvPriPatCrossBp extends BdSrvPriceTableUpdateBaseBp {

	@Override
	public String getUpdateTable() {
		return "BD_SRV_PRIPAT_CROSS";
	}

	@Override
	public String[] getAllowCondTypes() {
		return new String[] { IBdSrvPriceTableUpdateService.SrvPriceUpdateCondType_ReBuild,
				IBdSrvPriceTableUpdateService.SrvPriceUpdateCondType_PriPat,
				IBdSrvPriceTableUpdateService.SrvPriceUpdateCondType_Srv };
	}

	@Override
	public BdSrvPriceTableUpdateBaseBp getNextBp() {
		return new RefreshBdPriceRatioTmpBp();
	}

	@Override
	public ITransQry getInsertQry(String condType, String[] condValues) {
		return new InsertBdSrvPriPatCrossQuery(condType, condValues);
	}

	@Override
	public ITransQry getDeleteQry(String condType, String[] condValues) {
		return new DeleteBdSrvPriPatCrossQuery(condType, condValues);
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
//		BdSrvPriceTableUpdateLogUtils.info("开始更新BD_SRV_PRIPAT_CROSS,condType:%s,condValues:%s。", condType,
//				JSON.toJSONString(condValues));
//		StopWatch stopWatch = new StopWatch();
//		stopWatch.start();
//
//		delete(condType, condValues);
//
//		insert(condType, condValues);
//
//		stopWatch.split();
//		BdSrvPriceTableUpdateLogUtils.info("更新BD_SRV_PRIPAT_CROSS完成,condType:%s,condValues:%s,耗时:%sms。", condType,
//				JSON.toJSONString(condValues), stopWatch.getSplitTime());
//	}
//
//	private void delete(String condType, String[] condValues) throws BizException {
//		BdSrvPriceTableUpdateLogUtils.info("开始删除BD_SRV_PRIPAT_CROSS,condType:%s,condValues:%s。", condType,
//				JSON.toJSONString(condValues));
//		StopWatch stopWatch = new StopWatch();
//		stopWatch.start();
//
//		DeleteBdSrvPriPatCrossQuery qry = new DeleteBdSrvPriPatCrossQuery(condType, condValues);
//
//		DAFacade daFacade = new DAFacade();
//		int rowCount = daFacade.execUpdate(qry.getQrySQLStr(), qry.getQryParameter(null));
//
//		stopWatch.split();
//		BdSrvPriceTableUpdateLogUtils.info("删除BD_SRV_PRIPAT_CROSS完成,condType:%s,condValues:%s,条数:%s,耗时:%sms。", condType,
//				JSON.toJSONString(condValues), rowCount, stopWatch.getSplitTime());
//	}
//
//	private void insert(String condType, String[] condValues) throws BizException {
//		BdSrvPriceTableUpdateLogUtils.info("开始生成BD_SRV_PRIPAT_CROSS,condType:%s,condValues:%s。", condType,
//				JSON.toJSONString(condValues));
//		StopWatch stopWatch = new StopWatch();
//		stopWatch.start();
//
//		InsertBdSrvPriPatCrossQuery qry = new InsertBdSrvPriPatCrossQuery(condType, condValues);
//
//		DAFacade daFacade = new DAFacade();
//		int rowCount = daFacade.execUpdate(qry.getQrySQLStr(), qry.getQryParameter(null));
//
//		stopWatch.split();
//		BdSrvPriceTableUpdateLogUtils.info("生成BD_SRV_PRIPAT_CROSS完成,condType:%s,condValues:%s,条数:%s,耗时:%sms。", condType,
//				JSON.toJSONString(condValues), rowCount, stopWatch.getSplitTime());
//	}
//
//	private void refreshNext(String condType, String[] condValues) throws BizException {
//		if (IBdSrvPriceTableUpdateService.SrvPriceUpdateCondType_Measdoc.equals(condType)) {
//			UpdateMeasdocBp bp = new UpdateMeasdocBp();
//			bp.exec(condType, condValues);
//		} else {
//			RefreshBdPriceRatioTmpBp bp = new RefreshBdPriceRatioTmpBp();
//			bp.exec(condType, condValues);
//		}
//	}
}
