package iih.mc.pl.mcstockplan.i.ds;

import iih.bd.mm.meterial.d.MeterialDO;
import iih.mc.pl.deprequestap.d.McDepReqApOrderDO;
import iih.mc.pl.mcstockplan.d.McStockPlanDO;
import iih.mc.pl.mcstockplan.d.McStockPlanItmDO;
import iih.mc.pl.mcstockplan.d.McstockplanAggDO;
import xap.mw.core.data.BizException;


public interface IMcStockplanExtService {

	/**
	 * 新增一条明细或修改一条明细时，查询计算该物品信息
	 */
	public abstract McStockPlanItmDO getItem(McStockPlanItmDO mcStockPlanItmDO, String id_wh) throws BizException;
	/**
	 * 提交采购计划
	 */
	public McstockplanAggDO[] submitStockPlan(String[] ids) throws BizException;
	/**
	 * 采购计划审核通过
	 */
	public McstockplanAggDO accept(McstockplanAggDO mcStockplanAggDo) throws BizException;
	
	/**
	 * 采购计划审核驳回
	 */
	public McstockplanAggDO reject(McstockplanAggDO mcStockplanAggDo) throws BizException;
	
	/**
	 * 快速新增界面根据分类和仓库查询物品信息
	 * @param categoryId
	 * @param id_wh
	 * @return
	 * @throws BizException 
	 */
	public abstract MeterialDO[] findMCByMmca(String categoryId, String id_wh, Boolean zero) throws BizException;
	
	/**
	 * 通过批量添加选择完后填充明细数据
	 * @param mcStockPlanDO
	 * @param id_mms
	 * @return
	 * @throws BizException
	 */
	public abstract McStockPlanItmDO[] initMcstockplanAggByBatchAdd(McStockPlanDO mcStockPlanDO,String[] id_mms) throws BizException;
	
	/**
	 * 通过申领计划生成采购计划do数组
	 */
	public abstract McStockPlanDO[] createStPlanByReqAp(McDepReqApOrderDO[] reqAps) throws BizException;
	/**
	 * 通过申领计划生成采购计划Aggdo
	 */
	public McstockplanAggDO createStPlanAggByReqAp(McDepReqApOrderDO[] reqAps) throws BizException;
	 /**
		 * 申领计划明细合单
		 * @throws BizException
		 */
	  public McStockPlanItmDO[] Combinedorder(McDepReqApOrderDO[] mcdepredo) throws BizException;
	  /**
		 * 采购计划保存回写申领计划
		 * @throws BizException
		 */
	  public McstockplanAggDO UpDatedepreq(McstockplanAggDO aggDO) throws BizException;
	  /**
		 * 采购计划删除回写申领计划
		 * @throws BizException
		 */
	  public McStockPlanDO UpDatedepreqde(McStockPlanDO[] aPlanDO) throws BizException;
	  
}
