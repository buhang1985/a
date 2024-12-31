package iih.ci.ord.s.ems.ip.ems.treat;

import java.util.ArrayList;
import java.util.List;

import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvSetItemDO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.dws.ip.ems.d.EmsTreatViewDTO;
import iih.ci.ord.dws.ip.order.d.OrderListViewDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.EmsLoadDTO;
import iih.ci.ord.i.meta.EmsRstDTO;
import iih.ci.ord.ordsrvset.d.OrdSrvSetDO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.ip.base.BaseIpEmsLoadBP;
import iih.ci.ord.s.ems.meta.OrderPackageInfo;
import iih.ci.ord.s.ems.meta.OrderSrvSetList;
import iih.ci.ord.s.ems.utils.BdSrvInfoUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;


public class EmsTreatLoadBP extends BaseIpEmsLoadBP {

	@Override
	public EmsRstDTO[] load(CiEnContextDTO ctx, EmsLoadDTO[] args) throws BizException {
		EmsRstDTO[] rsts = super.load(ctx,args);
		EmsLoadDTO arg = args[0];
		EmsRstDTO rst = rsts[0];
		// 获取医疗单 DTO对象结构
		OrderPackageInfo[] szOrderPackageInfo = this.orderPakageInfoArrayFrom(new String[] { arg.getId_or() });
		if (CiOrdUtils.isEmpty(szOrderPackageInfo)) {
			FArrayList errorEmsList = new FArrayList();
			errorEmsList.append("获取医疗单信息失败！");
			rst.setErrorEmsList(errorEmsList);
			return new EmsRstDTO[] { rst };
		}
		OrderPackageInfo opInfo = szOrderPackageInfo[0];
		EmsTreatViewDTO ems = modelFrom(ctx, opInfo);
		if(!CiOrdUtils.isEmpty(arg.getDocument())){
			OrderListViewDTO srcdto=(OrderListViewDTO)arg.getDocument().get(0);
			this.mergeModelInfo(srcdto, ems);
		}
		ems.setFg_selfpay(FBoolean.TRUE.equals(ems.getFg_orhp())?FBoolean.FALSE:FBoolean.TRUE);
		//医疗单驱动
		ems.setDriverInfo(arg.getDriverInfo());
		// 医疗单模型文档
		rst.setDocument(handleReturnDocument(ems));
		// 医疗单类型
		// rst.setEmsDriver(EmsType.COMMON.toString());
		return rsts;
	}

	public EmsTreatViewDTO modelFrom(CiEnContextDTO ctx, OrderPackageInfo opInfo) throws BizException {
		EmsTreatViewDTO emsTreatDto = new EmsTreatViewDTO();
		emsTreatDto.setStatus(DOStatus.UPDATED);
		this.orderListViewInfoFrom(ctx, opInfo.getMainBdSrvInfo(), opInfo.getOrderInfo(), this.mainSrvInfoFrom(opInfo), emsTreatDto);
		//如果治疗是套需要设置套内明细项目
		//setSrvSetInfo4EmsTreat(ctx,opInfo.getOrderSrvSetList(),emsTreatDto);
		return emsTreatDto;
	}
	
	@Override
	protected void orderListViewInfoFrom(CiEnContextDTO ctx, MedSrvDO medSrv, CiOrderDO orderInfo, OrdSrvDO srvDo,
			OrderListViewDTO emsViewInfo) throws BizException {
		super.orderListViewInfoFrom(ctx, medSrv, orderInfo, srvDo, emsViewInfo);
		EmsTreatViewDTO emsTreatDto = (EmsTreatViewDTO)emsViewInfo;
		emsTreatDto.setDes_or(orderInfo.getDes_or());
	}

	/**
	 * 设置套内项目
	 * @param ctx
	 * @param emsDTO
	 * @param emsRisViewDTO
	 * @throws BizException
	 */
	private void setSrvSetInfo4EmsTreat(CiEnContextDTO ctx, OrderSrvSetList srvSetItemList, EmsTreatViewDTO emsTreatViewDTO) 
			throws BizException {
		// 治疗套内项目列表数据源模型
		FArrayList emsLisViewItemDTOs = new FArrayList();
		if (CiOrdUtils.isTrue(emsTreatViewDTO.getFg_set())) {
			if (srvSetItemList == null || srvSetItemList.size() == 0) {
				return;
			}
			List<String> srvSetIdSrvs = new ArrayList<String>();
			for(OrdSrvSetDO ordSrvSetDO : srvSetItemList){
				srvSetIdSrvs.add(ordSrvSetDO.getId_srvset());
			}
			MedSrvSetItemDO[] medSrvSetItemDOs = BdSrvInfoUtils.QueryMedSrvSetItemBy(emsTreatViewDTO.getId_srv(), srvSetIdSrvs.toArray(new String[0]));
			for (MedSrvSetItemDO setItem : medSrvSetItemDOs) {
				emsLisViewItemDTOs.append(setItem);
			}
			emsTreatViewDTO.setExtInfoList(emsLisViewItemDTOs);
		}
	}
}
