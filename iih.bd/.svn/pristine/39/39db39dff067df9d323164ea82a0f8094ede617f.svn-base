package iih.bd.srv.srvpricetable.s.bp.g_bd_price_rp_itm;

import java.util.List;

import org.apache.commons.lang.ArrayUtils;

import iih.bd.base.utils.SqlUtils;
import iih.bd.srv.srvpricetable.i.IBdSrvPriceTableUpdateService;
import iih.bd.srv.srvpricetable.s.bp.BdSrvPriceTableUpdateBaseBp;
import iih.bd.srv.srvpricetable.s.bp.g_bd_price_rp_itm.qry.DeleteBdPriceRpItmQuery;
import iih.bd.srv.srvpricetable.s.bp.g_bd_price_rp_itm.qry.InsertBdPriceRpItmQuery;
import iih.bd.srv.srvpricetable.s.bp.h_bd_price_rp.RefreshBdPriceRpBp;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.handler.ColumnListHandler;

/**
 * 
 * 刷新表BD_PRICE_RP_ITM</br>
 * 7.BD_PRICE_RP_ITM
 * 
 * @author hao_wu
 * @date 2020年4月23日
 *
 */
public class RefreshBdPriceRpItmBp extends BdSrvPriceTableUpdateBaseBp {

	@Override
	public String getUpdateTable() {
		return "BD_PRICE_RP_ITM";
	}

	@Override
	public String[] getAllowCondTypes() {
		return new String[] { IBdSrvPriceTableUpdateService.SrvPriceUpdateCondType_ReBuild,
				IBdSrvPriceTableUpdateService.SrvPriceUpdateCondType_Srv,
				IBdSrvPriceTableUpdateService.SrvPriceUpdateCondType_Mm,
				IBdSrvPriceTableUpdateService.SrvPriceUpdateCondType_PriPat };
	}

	@SuppressWarnings("unchecked")
	@Override
	public void update(String condType, String[] condValues) throws BizException {
		if (IBdSrvPriceTableUpdateService.SrvPriceUpdateCondType_Srv.equals(condType)) {
			StringBuilder sqlBuilder = new StringBuilder();

			String sql = String.format("SELECT ID_SRVSET as ID_SRV FROM BD_PRI_SRV_SETFIX WHERE %s",
					SqlUtils.getInSqlByIds("ID_SRVADD", condValues));
			sqlBuilder.append(sql);

			sqlBuilder.append(" UNION ALL ");

			sql = String.format("SELECT ID_SRVSET as ID_SRV FROM BD_PRI_SRV_SETMU WHERE %s",
					SqlUtils.getInSqlByIds("ID_SRVADD", condValues));
			sqlBuilder.append(sql);

			sqlBuilder.append(" UNION ALL ");

			sql = String.format("SELECT ID_SRV FROM BD_SRVSET_DEF WHERE %s",
					SqlUtils.getInSqlByIds("ID_SRV_ITM", condValues));
			sqlBuilder.append(sql);

			List<String> setSrvIdList = (List<String>) daFacade.execQuery(sql, new ColumnListHandler());

			if (setSrvIdList != null && setSrvIdList.size() > 0) {
				condValues = (String[]) ArrayUtils.addAll(condValues, setSrvIdList.toArray(new String[0]));
			}
		}

		super.update(condType, condValues);
	}

	@Override
	public BdSrvPriceTableUpdateBaseBp getNextBp() {
		return new RefreshBdPriceRpBp();
	}

	@Override
	public ITransQry getInsertQry(String condType, String[] condValues) {
		return new InsertBdPriceRpItmQuery(condType, condValues);
	}

	@Override
	public ITransQry getDeleteQry(String condType, String[] condValues) {
		return new DeleteBdPriceRpItmQuery(condType, condValues);
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
//		BdSrvPriceTableUpdateLogUtils.info("开始更新BD_PRICE_RP_ITM,condType:%s,condValues:%s。", condType,
//				JSON.toJSONString(condValues));
//		StopWatch stopWatch = new StopWatch();
//		stopWatch.start();
//
//		delete(condType, condValues);
//
//		insert(condType, condValues);
//
//		stopWatch.split();
//		BdSrvPriceTableUpdateLogUtils.info("更新BD_PRICE_RP_ITM完成,condType:%s,condValues:%s,耗时:%sms。", condType,
//				JSON.toJSONString(condValues), stopWatch.getSplitTime());
//	}
//
//	private void delete(String condType, String[] condValues) throws BizException {
//		BdSrvPriceTableUpdateLogUtils.info("开始删除BD_PRICE_RP_ITM,condType:%s,condValues:%s。", condType,
//				JSON.toJSONString(condValues));
//		StopWatch stopWatch = new StopWatch();
//		stopWatch.start();
//
//		DeleteBdPriceRpItmQuery qry = new DeleteBdPriceRpItmQuery(condType, condValues);
//
//		DAFacade daFacade = new DAFacade();
//		int rowCount = daFacade.execUpdate(qry.getQrySQLStr(), qry.getQryParameter(null));
//
//		stopWatch.split();
//		BdSrvPriceTableUpdateLogUtils.info("删除BD_PRICE_RP_ITM完成,condType:%s,condValues:%s,条数:%s,耗时:%sms。", condType,
//				JSON.toJSONString(condValues), rowCount, stopWatch.getSplitTime());
//	}
//
//	private void insert(String condType, String[] condValues) throws BizException {
//		BdSrvPriceTableUpdateLogUtils.info("开始生成BD_PRICE_RP_ITM,condType:%s,condValues:%s。", condType,
//				JSON.toJSONString(condValues));
//		StopWatch stopWatch = new StopWatch();
//		stopWatch.start();
//
//		InsertBdPriceRpItmQuery qry = new InsertBdPriceRpItmQuery(condType, condValues);
//
//		DAFacade daFacade = new DAFacade();
//		int rowCount = daFacade.execUpdate(qry.getQrySQLStr(), qry.getQryParameter(null));
//
//		stopWatch.split();
//		BdSrvPriceTableUpdateLogUtils.info("生成BD_PRICE_RP_ITM完成,condType:%s,condValues:%s,条数:%s,耗时:%sms。", condType,
//				JSON.toJSONString(condValues), rowCount, stopWatch.getSplitTime());
//	}
//
//	private void refreshNext(String condType, String[] condValues) throws BizException {
//		RefreshBdPriceRpBp bp = new RefreshBdPriceRpBp();
//		bp.exec(condType, condValues);
//	}
}
