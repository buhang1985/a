package iih.mm.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.mm.meterial.i.ds.IMeterialService;
import iih.mm.bl.stockbl.d.StockBlDO;
import iih.mm.bl.stockbl.i.IStockblCudService;
import iih.mm.bl.stockbl.i.IStockblRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.agg.voutils.DOUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.kernel.PersistMgr;
import xap.sys.jdbc.kernel.PersistSession;

public class UpdateMmStockBl {
	
	public static void setStock(List<StockBlDO> stockBlList) throws BizException {
		if(stockBlList == null || stockBlList.size() <= 0) {
			return;
		}
		//插入列表
		List<StockBlDO> insertList = new ArrayList<StockBlDO>();
		//更新列表
		List<StockBlDO> updateList = new ArrayList<StockBlDO>();
		FDateTime sysTime = new FDateTime();
		for(StockBlDO stockBlDO : stockBlList) {
			stockBlDO.setDt_lastupdate(sysTime);
			if(stockBlDO.getStatus() == DOStatus.NEW) {
				insertList.add(stockBlDO);
			} else {
				updateList.add(stockBlDO);
			}
		}
		
		//数据插入
		if(insertList != null && insertList.size() > 0) {
			IStockblCudService blCudSrv = ServiceFinder.find(IStockblCudService.class);
			blCudSrv.insert(insertList.toArray(new StockBlDO[0]));
		}
		
		//数据更新
		if(updateList != null && updateList.size() > 0) {
			StockBlDO[] blDOS = updateList.toArray(new StockBlDO[0]);
			DOUtil.sort(blDOS, new String[] { StockBlDO.ID_MM, StockBlDO.ID_BL }, new int[] { DOUtil.ASC, DOUtil.ASC });
			if(MMParams.MMBL0004().booleanValue()) {
				updateBlStock(Arrays.asList(blDOS));
			} else {
				new DAFacade().updateDOs(blDOS);
			}
		}
		
		//设置仓库物品关系停发标识
		AutoSetWhouseMmStopBp.exec(stockBlList.toArray(new StockBlDO[0]));
	}
	
	private static void updateBlStock(List<StockBlDO> updateList) throws BizException {
		//组装更新语句
		List<String> id_bls = new ArrayList<String>();
		String sql = null;
		PersistMgr persist = null;
		PersistSession session = null;
		FDateTime sysTime = new FDateTime();
		try {
			persist = (PersistMgr)PersistMgr.getInstance();
			session = persist.getPersistSession();
			for(StockBlDO stockBlDO : updateList) {
				if(stockBlDO.getReq_num() != null) {
					sql = String.format("update mm_bl set quan_stock = quan_stock + %s where id_bl = '%s';", stockBlDO.getReq_num(), stockBlDO.getId_bl());
					session.addBatch(sql);
					sql = String.format("update mm_bl set amt_cost = round(quan_stock * pri_act, 2) where id_bl = '%s';", stockBlDO.getId_bl());
					session.addBatch(sql);
				}
				if(stockBlDO.getReq_reserve_num() != null) {
					sql = String.format("update mm_bl set quan_reserve = case when quan_reserve + %s < 0 then 0 else quan_reserve + %s end where id_bl = '%s';",
							stockBlDO.getReq_reserve_num(), stockBlDO.getReq_reserve_num(), stockBlDO.getId_bl());
					session.addBatch(sql);
				}
				sql = String.format("update mm_bl set quan_usable = quan_stock - quan_reserve, Modifiedby = '%s', Modifiedtime = '%s', sv = '%s', Dt_lastupdate = '%s' where id_bl = '%s';",
						Context.get().getUserId(), sysTime, sysTime, sysTime, stockBlDO.getId_bl());
				session.addBatch(sql);
				id_bls.add(stockBlDO.getId_bl());
			}
			session.execBatch();
			
			//库存校验
			chkQuan(id_bls);
		} catch(Exception e) {
			if (session != null) {
				session.closeAll();
			}
			if (persist != null) {
				persist.release();
			}
			throw new BizException(e);
		}
	}

	private static void chkQuan(List<String> id_bls) throws BizException {
		IStockblRService stockblRSrv = ServiceFinder.find(IStockblRService.class);
		StockBlDO[] stockblDOS = stockblRSrv.findByBIds(id_bls.toArray(new String[0]), FBoolean.TRUE);
		if(stockblDOS == null || stockblDOS.length <= 0) {
			return;
		}
		IMeterialService materialSrv = ServiceFinder.find(IMeterialService.class);
		for(StockBlDO stockblDO : stockblDOS) {
			MeterialDO mmDO = materialSrv.findMaterialByID(stockblDO.getId_mm());
			if(stockblDO.getQuan_stock().multiply(-1).compareTo(new FDouble(MMParams.MISTAKE_BL_QUAN)) > 0 || stockblDO.getQuan_usable().multiply(-1).compareTo(new FDouble(MMParams.MISTAKE_BL_QUAN)) > 0) {
				String error = String.format("物品【%s：%s，%s，%s】库存不足。物品详细信息：\n唯一码：%s\n批次：%s\n失效期：%s\n入库单价：%f", 
						mmDO.getCode(), mmDO.getName(), mmDO.getSpec(), mmDO.getSup_name(), stockblDO.getOnlycode(), 
						stockblDO.getBatch(), stockblDO.getDate_expi(), stockblDO.getPri_act().toDouble());
				throw new BizException(error);
			}
		}
	}
	
	public static void setReserve(List<StockBlDO> updateList) throws BizException {
		if(updateList == null || updateList.size() <= 0) {
			return;
		}
		StockBlDO[] blDOS = updateList.toArray(new StockBlDO[0]);
		DOUtil.sort(blDOS, new String[] { StockBlDO.ID_MM, StockBlDO.ID_BL }, new int[] { DOUtil.ASC, DOUtil.ASC });
		if(MMParams.MMBL0004().booleanValue()) {
			updateBlReserve(Arrays.asList(blDOS));
		} else {
			new DAFacade().updateDOs(blDOS);
		}
		
		//设置仓库物品关系停发标识
		AutoSetWhouseMmStopBp.exec(updateList.toArray(new StockBlDO[0]));
	}
	
	private static void updateBlReserve(List<StockBlDO> updateList) throws BizException {
		//组装更新语句
		List<String> id_bls = new ArrayList<String>();
		String sql = null;
		PersistMgr persist = null;
		PersistSession session = null;
		FDateTime sysTime = new FDateTime();
		try {
			persist = (PersistMgr)PersistMgr.getInstance();
			session = persist.getPersistSession();
			for(StockBlDO stockBlDO : updateList) {
				if(stockBlDO.getReq_reserve_num() != null) {
					sql = String.format("update mm_bl set quan_reserve = case when quan_reserve + %s < 0 then 0 else quan_reserve + %s end where id_bl = '%s';",
							stockBlDO.getReq_reserve_num(), stockBlDO.getReq_reserve_num(), stockBlDO.getId_bl());
					session.addBatch(sql);
				}
				sql = String.format("update mm_bl set quan_usable = quan_stock - quan_reserve, Modifiedby = '%s', Modifiedtime = '%s', sv = '%s', Dt_lastupdate = '%s' where id_bl = '%s';",
						Context.get().getUserId(), sysTime, sysTime, sysTime, stockBlDO.getId_bl());
				session.addBatch(sql);
				id_bls.add(stockBlDO.getId_bl());
			}
			session.execBatch();
			
			//库存校验
			chkQuan(id_bls);
		} catch(Exception e) {
			if (session != null) {
				session.closeAll();
			}
			if (persist != null) {
				persist.release();
			}
			throw new BizException(e);
		}
	}
}
