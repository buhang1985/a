package iih.ci.ord.s.ems.ip.base;

import org.apache.commons.lang3.StringUtils;

import iih.bd.pp.primd.i.IBdPrimdCodeConst;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.HpIndicJudgeRstEnum;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.dws.ip.order.d.OrderListViewDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.defsave.DefaultSingleSrvCreateOrderInfo;
import iih.ci.ord.s.ems.ip.ems.base.CommonIpEmsSaveBP;
import iih.ci.ord.s.ems.meta.BdSrvInfoList;
import iih.ci.ord.s.ems.meta.BdSrvMmInfo;
import iih.ci.ord.s.ems.meta.OrderPackageInfo;
import iih.ci.ord.s.ems.meta.OrderSrvMmInfo;
import iih.ci.ord.s.ems.meta.OrderSrvMmList;
import iih.ci.ord.s.ems.utils.BdSrvInfoUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;

public class BaseIpEmsSingleSaveBP extends CommonIpEmsSaveBP{

	@Override
	protected BdSrvInfoList bdSrvInfoListFrom(CiOrderDO orderInfo, OrderSrvMmList ordSrvMmInfoList)
			throws BizException {
		
			MedSrvDO[] szMedSrvInfo = BdSrvInfoUtils.QueryBdSrvInfo(new String[]{orderInfo.getId_srv()});
			return (new BdSrvInfoList(szMedSrvInfo));
		
	}

	@Override
	protected OrderPackageInfo[] mergeOrderPakageInfo(CiEnContextDTO ctx, OrderPackageInfo[] szOrderPakageInfo)
			throws BizException {
		for (OrderPackageInfo pInfo : szOrderPakageInfo) {
			//组合计价编辑时重新算项目
			if(!pInfo.isNew() && IBdPrimdCodeConst.ID_PRI_SRV_COMP.equals(pInfo.getMainBdSrvInfo().getId_primd())){
				for (OrderSrvMmInfo srvMmInfo : pInfo.getAllOrderSrvMmList()) {
					if (!CiOrdUtils.isTrue(srvMmInfo.getOrderSrvInfo().getFg_or())) {
						srvMmInfo.getOrderSrvInfo().setStatus(DOStatus.DELETED);
					}
				}
				OrderSrvMmList ordSrvMmList=((DefaultSingleSrvCreateOrderInfo)getDefaultCreateOrderInfo()).CreateCompPrimdSrvInfo(ctx,pInfo,new BdSrvMmInfo(pInfo.getMainBdSrvInfo(),pInfo.getUiModel()));
				if(ordSrvMmList.size()>0){
					for(OrderSrvMmInfo srvMmInfo:ordSrvMmList){
						srvMmInfo.getOrderSrvInfo().setStatus(DOStatus.NEW);
					}
					pInfo.getOrderSrvMmList().addAll(ordSrvMmList);
				}
			}
		}
		OrderPackageInfo[] szOrderPackageInfo = super.mergeOrderPakageInfo(ctx, szOrderPakageInfo);
		
		for (OrderPackageInfo pInfo : szOrderPakageInfo) {
			//合并申请单信息
			if (!CiOrdUtils.isEmpty(pInfo.getOrderAppSheetList())){
				mergeOrderAppInfo(ctx,pInfo.getOrderAppSheetList().asArray(),pInfo.getExtInfoList().asArray(), pInfo.getUiModel());
			}
		}
		
		
		return szOrderPackageInfo;
	}
	/**
	 * 合并服务信息之后处理医嘱相关信息
	 * 
	 * @param ctx
	 * @param orderInfo
	 * @param srvInfo
	 * @param uiModel
	 * @throws BizException
	 */
	protected void afterMergeOrderPakageInfo(CiEnContextDTO ctx, CiOrderDO orderInfo, OrdSrvDO[] srvInfos,
			Object uiModel) throws BizException {
		super.afterMergeOrderPakageInfo(ctx, orderInfo, srvInfos, uiModel);
	}
	
	@Override
	protected OrderPackageInfo repairHpOrderPackageInfo(CiEnContextDTO ctx, OrderPackageInfo orderPackageInfo) {

		OrderListViewDTO orderListView = (OrderListViewDTO) orderPackageInfo.getUiModel();
		CiOrderDO orderInfo = orderPackageInfo.getOrderInfo();
		orderInfo.setFg_orhp(orderListView.getFg_orhp());
		orderInfo.setEu_hpindicjudge(orderListView.getEu_hpindicjudge());

		OrderSrvMmInfo[] orderSrvMmInfos = orderPackageInfo.getAllOrderSrvMmList().asArray();
		for (OrderSrvMmInfo orderSrvMmInfo : orderSrvMmInfos) {

			OrdSrvDO ordSrv = orderSrvMmInfo.getOrderSrvInfo();

			if (DOStatus.DELETED == ordSrv.getStatus()) {
				continue;
			}

			// 只有费用项才有医保目录
			if (!FBoolean.TRUE.equals(ordSrv.getFg_bl())) {
				continue;
			}

			// 如果费用项是不判断的，但是不满足不判断项目的限制条件，如果是自费，改为医生判断自费，否则改为待判断
			if (HpIndicJudgeRstEnum.NEVER_JUDGE.equals(ordSrv.getEu_hpindicjudge())) {
				if (!(StringUtils.isNotEmpty(ordSrv.getSd_nodispense()) || FBoolean.TRUE.equals(ordSrv.getFg_research()))) {

					if (FBoolean.TRUE.equals(ordSrv.getFg_selfpay())) {
						ordSrv.setEu_hpindicjudge(HpIndicJudgeRstEnum.DOCTOR_JUDGE);
						ordSrv.setDes_hplimit("医生选择自费开立医嘱");
					} else {
						ordSrv.setEu_hpindicjudge(HpIndicJudgeRstEnum.WAITING_JUDGE);
						ordSrv.setDes_hplimit("");
					}
				}
			}

			// 不摆药类型为空时设置为不判断
			if (StringUtils.isNotEmpty(ordSrv.getSd_nodispense())) {
				ordSrv.setEu_hpindicjudge(HpIndicJudgeRstEnum.NEVER_JUDGE);
				ordSrv.setFg_selfpay(FBoolean.TRUE);
				ordSrv.setFg_indic(FBoolean.FALSE);
				ordSrv.setDes_hplimit("不计费类型限制【" + ordSrv.getSd_nodispense() + "】：限制服务项目不进行医保判断");
			}

			// 科研项目不进行适应症判断
			if (FBoolean.TRUE.equals(ordSrv.getFg_research())) {
				ordSrv.setEu_hpindicjudge(HpIndicJudgeRstEnum.NEVER_JUDGE);
				ordSrv.setFg_selfpay(FBoolean.TRUE);
				ordSrv.setFg_indic(null);
				ordSrv.setDes_hplimit("科研项目不判断医保！");
			}

			// 如果判断，返回判断下一条
			if (ordSrv.getEu_hpindicjudge() != null && !HpIndicJudgeRstEnum.WAITING_JUDGE.equals(ordSrv.getEu_hpindicjudge())) {
				continue;
			}

			// 医生判断自费
			if (HpIndicJudgeRstEnum.DOCTOR_JUDGE.equals(orderInfo.getEu_hpindicjudge())) {

				if (HpIndicJudgeRstEnum.WAITING_JUDGE.equals(ordSrv.getEu_hpindicjudge()) || ordSrv.getEu_hpindicjudge() == null) {

					if (FBoolean.TRUE.equals(orderInfo.getFg_orhp())) {
						ordSrv.setEu_hpindicjudge(HpIndicJudgeRstEnum.WAITING_JUDGE);
						ordSrv.setFg_selfpay(null);
					} else {
						ordSrv.setEu_hpindicjudge(HpIndicJudgeRstEnum.DOCTOR_JUDGE);
						ordSrv.setFg_selfpay(FBoolean.TRUE);
						ordSrv.setEu_hpindicjudge(HpIndicJudgeRstEnum.DOCTOR_JUDGE);
						ordSrv.setDes_hplimit("医生选择自费开立医嘱");
					}
				}

			} else if (HpIndicJudgeRstEnum.WAITING_JUDGE.equals(orderInfo.getEu_hpindicjudge()) || orderInfo.getEu_hpindicjudge() == null) {

				if (HpIndicJudgeRstEnum.WAITING_JUDGE.equals(ordSrv.getEu_hpindicjudge()) || ordSrv.getEu_hpindicjudge() == null) {
					ordSrv.setEu_hpindicjudge(HpIndicJudgeRstEnum.WAITING_JUDGE);
					ordSrv.setFg_selfpay(null);
				}

			}
		}

		return orderPackageInfo;
	}
	
	@Override
	protected void mergeOrderSrvInfo(CiEnContextDTO ctx, OrdSrvDO srvInfo, Object uiModel) throws BizException {
		if(!CiOrdUtils.isTrue(srvInfo.getFg_or()))return;//非临床项目不需要信息对照
		
		super.mergeOrderSrvInfo(ctx, srvInfo, uiModel);
	}
	
}
