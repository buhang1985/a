package iih.ci.ord.s.ems.defsave;

import java.util.HashMap;
import java.util.Map;

import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.pp.dto.d.PriStdSrvDTO;
import iih.bd.pp.primd.i.IBdPrimdCodeConst;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrSrvSourceFromEnum;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.itf.ICalcPriModeProxy;
import iih.ci.ord.s.ems.meta.BdSrvMmInfo;
import iih.ci.ord.s.ems.meta.BdSrvMmInfoList;
import iih.ci.ord.s.ems.meta.DefaultCreateParam;
import iih.ci.ord.s.ems.meta.OrderPackageInfo;
import iih.ci.ord.s.ems.meta.OrderSrvExtPackage;
import iih.ci.ord.s.ems.meta.OrderSrvMmInfo;
import iih.ci.ord.s.ems.meta.OrderSrvMmList;
import iih.ci.ord.s.ems.op.ems.calcpri.CompCalcPriModeProxy;
import iih.ci.ord.s.ems.utils.BdSrvInfoUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 单服务默认创建方法
 * 
 * @author wangqingzhu
 *
 */
public class DefaultSingleSrvCreateOrderInfo extends DefaultBaseCreateOrderInfo {

	@Override
	public OrderPackageInfo[] createOrderPakageInfo(CiEnContextDTO ctx, DefaultCreateParam[] szParam)
			throws BizException {
		// TODO Auto-generated method stub
		return super.createOrderPakageInfo(ctx, szParam);
	}

	@Override
	protected DefaultBaseCreateOrderInfo createOrderSrvAExtInfo( OrderPackageInfo orderPakageInfo,
			BdSrvMmInfoList bdSrvMmInfoList) throws BizException {
		// 组装服务信息列表并设置到Agg结构的服务列表中
		
		OrderSrvMmList orderSrvMmInfoList = new OrderSrvMmList();
		for (int index = 0; index < bdSrvMmInfoList.size(); ++index){
			BdSrvMmInfo bdSrvMmInfo = bdSrvMmInfoList.get(index);
			// 创建服务信息
			OrderSrvMmInfo ordSrvMmInfo = new OrderSrvMmInfo(assembleOrderSrvInfo(this.getEnContextInfo(),
					orderPakageInfo.getOrderInfo(), bdSrvMmInfo), bdSrvMmInfo.getUiModel());
			// 服务来源
			ordSrvMmInfo.getOrderSrvInfo().setEu_sourcemd(OrSrvSourceFromEnum.PHYSIAN);
			orderSrvMmInfoList.add(ordSrvMmInfo);
			if (IBdPrimdCodeConst.ID_PRI_SRV_COMP.equals(bdSrvMmInfo.getBdSrvInfo().getId_primd())) {
				// 非套服务 - 组合定价服务信息（费用项目）计算
				OrderSrvMmList srvMmList = CreateCompPrimdSrvInfo(this.getEnContextInfo(), orderPakageInfo, bdSrvMmInfo);
				if (srvMmList.size() > 0) {
					orderSrvMmInfoList.addAll(srvMmList);
				}
			} else {
				MeterialDO meterialDO = bdSrvMmInfo.getMmInfo();
				handleMpWhDeptInfo(this.getEnContextInfo(), orderPakageInfo.getOrderInfo().getId_dep_mp(),
						ordSrvMmInfo.getOrderSrvInfo(), meterialDO != null ? meterialDO.getId_mm() : null);
				// 判断是否为物品服务
				if (bdSrvMmInfo.isMm()) {
					ordSrvMmInfo.setOrderSrvMmInfo(assembleSrvMmInfo(this.getEnContextInfo(),
							ordSrvMmInfo.getOrderSrvInfo(), bdSrvMmInfo.getMmInfo(), bdSrvMmInfo.getSrvDrugInfo()));
				}
			}
		}
	
		orderPakageInfo.setOrderSrvMmList(orderSrvMmInfoList);
		return this;
	}
	
	/**
	 * 根据费用对照出来的价表信息构造医嘱服务集合
	 * 
	 * @param ctx
	 *            就诊上下文
	 * @param setSrvInfo
	 *            套服务对象
	 * @param szPriStdSrvDTO
	 *            价表集合
	 * @return 医嘱服务对象集合
	 * @throws BizException
	 */
	protected OrderSrvExtPackage CalcPriStdSrvOfOrdSrvList(CiEnContextDTO ctx, CiOrderDO orderInfo, MedSrvDO setSrvInfo,
			ICalcPriModeProxy iCalcPriModeProxy,Object uiModel) throws BizException {

		PriStdSrvDTO[] szPriStdSrvDTO = iCalcPriModeProxy.Calc();
		if (CiOrdUtils.isEmpty(szPriStdSrvDTO)){
			throw new BizException(iCalcPriModeProxy.toDesction() + "，费用接口没有返回数据");
		}
		Map<String,PriStdSrvDTO> priStdMap=new HashMap<String,PriStdSrvDTO>();
		
//		// 获取基础数据服务集合
//		StringList idSrvList = new StringList();
		for (PriStdSrvDTO pssd : szPriStdSrvDTO) {
//			idSrvList.add(pssd.getId_srv());
			priStdMap.put(pssd.getId_srv(), pssd);
		}
		MedSrvDO[] szMedSrvInfo = BdSrvInfoUtils.QueryBdSrvInfo(priStdMap.keySet().toArray(new String[priStdMap.keySet().size()])) ;
		if (CiOrdUtils.isEmpty(szMedSrvInfo)) {
			throw new BizException(String.format("服务[%s]获取套内项目的基础数据失败，请服务基础数据", setSrvInfo.getName()));
		}
		OrderSrvMmList ordSrvMmList=createOrderSrvMmList(ctx,orderInfo,szMedSrvInfo,iCalcPriModeProxy.getEuSource());
		for(OrderSrvMmInfo srvMmInfo:ordSrvMmList){
			OrdSrvDO srvDO=srvMmInfo.getOrderSrvInfo();
			srvDO.setFg_or(FBoolean.FALSE);//费用对照数据默认fg_or=N
			if(priStdMap.containsKey(srvDO.getId_srv())){
				if(!CiOrdUtils.isEmpty(priStdMap.get(srvDO.getId_srv()).getQuan())){
					srvDO.setQuan_medu(priStdMap.get(srvDO.getId_srv()).getQuan());
				}
				srvDO.setPri(priStdMap.get(srvDO.getId_srv()).getPrice());
			}
			if(!CiOrdUtils.isEmpty(uiModel)){
				srvMmInfo.setUiModel(uiModel);
			}
		}

		return new OrderSrvExtPackage(setSrvInfo.getId_srv(),ordSrvMmList);
	}
	/**
	 * 非套组合计价创建服务
	 * @param orderPakageInfo
	 * @param bdSrvMmInfo
	 * @param index
	 * @return
	 * @throws BizException
	 */
	public OrderSrvMmList CreateCompPrimdSrvInfo(CiEnContextDTO ctx,OrderPackageInfo orderPakageInfo,BdSrvMmInfo bdSrvMmInfo) throws BizException{
		OrderSrvMmList orderSrvMmInfoList = new OrderSrvMmList();
		//组合计价费用项
		OrderSrvExtPackage ordSrvExtPackage = CalcPriStdSrvOfOrdSrvList(
				ctx, 
				orderPakageInfo.getOrderInfo(), 
				bdSrvMmInfo.getBdSrvInfo(), new CompCalcPriModeProxy(
				bdSrvMmInfo.getBdSrvInfo().getId_srv(), 
				bdSrvMmInfo.getBdSrvInfo().getName(), 
				0),bdSrvMmInfo.getUiModel());
		// 非套服务 - 组合定价服务信息（费用项目）计算
		if (!CiOrdUtils.isEmpty(ordSrvExtPackage.getOrderSrvMmList())){
			
			orderSrvMmInfoList.addAll(ordSrvExtPackage.getOrderSrvMmList());
		}
		return orderSrvMmInfoList;
	}
	
	
}
