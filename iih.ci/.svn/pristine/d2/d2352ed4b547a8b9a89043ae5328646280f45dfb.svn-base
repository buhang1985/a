package iih.ci.ord.s.ems.ip.ems.ris;

import java.util.HashMap;
import java.util.Map;

import iih.bd.base.database.DatabaseUtils;
import iih.bd.base.database.ListMapRecordSet;
import iih.bd.base.database.SqlConditionsParameter;
import iih.bd.srv.medsrv.d.MedSrvRisDO;
import iih.bd.srv.medsrv.d.MedSrvSetItemDO;
import iih.bd.srv.medsrv.d.MedsrvAggDO;
import iih.bd.srv.medsrv.i.IMedSrvSetItemDORService;
import iih.bd.srv.medsrv.i.IMedsrvRService;
import iih.ci.ord.cior.d.OrdApObsDO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.dws.ip.ems.d.EmsRisViewDTO;
import iih.ci.ord.dws.ip.ems.d.EmsRisViewItemDTO;
import iih.ci.ord.dws.ip.order.d.OrderListViewDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.EmsLoadDTO;
import iih.ci.ord.i.meta.EmsRstDTO;
import iih.ci.ord.ordsrvset.d.OrdSrvSetDO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.ip.base.BaseIpEmsLoadBP;
import iih.ci.ord.s.ems.meta.OrderPackageInfo;
import iih.ci.ord.s.ems.meta.OrderSrvSetList;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 检查医疗单加载逻辑
 * @author Young
 *
 */
public class EmsRisLoadBP extends BaseIpEmsLoadBP {

	@Override
	public EmsRstDTO[] load(CiEnContextDTO ctx, EmsLoadDTO[] args) 
			throws BizException {
		EmsLoadDTO arg = args[0];
		EmsRstDTO emsRstDTO = new EmsRstDTO();

		// 获取医疗单 DTO对象结构
		OrderPackageInfo[] szOrderPackageInfo = this.orderPakageInfoArrayFrom(new String[] { arg.getId_or() });
		if (CiOrdUtils.isEmpty(szOrderPackageInfo)) {
			FArrayList errorEmsList = new FArrayList();
			errorEmsList.append("获取医疗单信息失败！");
			emsRstDTO.setErrorEmsList(errorEmsList);
			return new EmsRstDTO[] { emsRstDTO };
		}

		EmsRisViewDTO emsRisViewDTO = this.getEmsRisViewDTO(ctx, szOrderPackageInfo[0]);
		if (null == emsRisViewDTO) {
			FArrayList errorEmsList = new FArrayList();
			errorEmsList.append("获取申请单信息失败！");
			emsRstDTO.setErrorEmsList(errorEmsList);
			return new EmsRstDTO[] { emsRstDTO };
		}
		if(!CiOrdUtils.isEmpty(arg.getDocument())){
			OrderListViewDTO srcdto=(OrderListViewDTO)arg.getDocument().get(0);
			this.mergeModelInfo(srcdto, emsRisViewDTO);			
		}
		
		emsRisViewDTO.setFg_selfpay(FBoolean.TRUE.equals(emsRisViewDTO.getFg_orhp())?FBoolean.FALSE:FBoolean.TRUE);
		//医疗单驱动
		emsRisViewDTO.setDriverInfo(arg.getDriverInfo());
		// 医疗单模型文档
		emsRstDTO.setDocument(handleReturnDocument(emsRisViewDTO));

		return new EmsRstDTO[] { emsRstDTO };
	}

	/**
	 * 加载主模型对象
	 * @param ctx
	 * @param emsDTO
	 * @return
	 * @throws BizException
	 */
	private EmsRisViewDTO getEmsRisViewDTO(CiEnContextDTO ctx, OrderPackageInfo opInfo) 
			throws BizException {
		EmsRisViewDTO emsRisViewDTO = new EmsRisViewDTO();
		emsRisViewDTO.setStatus(DOStatus.UPDATED);
		this.orderListViewInfoFrom(ctx, opInfo.getMainBdSrvInfo(), opInfo.getOrderInfo(), this.mainSrvInfoFrom(opInfo), emsRisViewDTO);
		CiOrderDO orderInfo = opInfo.getOrderInfo();
		emsRisViewDTO.setFg_orhp(orderInfo.getFg_orhp());
		emsRisViewDTO.setFg_self(FBoolean.TRUE.equals(orderInfo.getFg_orhp())?FBoolean.FALSE:FBoolean.TRUE);
		
		OrdApObsDO ordApObsDO = (OrdApObsDO)opInfo.getOrderAppSheetList().get(0);
		if (ordApObsDO == null) {
			return emsRisViewDTO;
		}

		emsRisViewDTO.setId_pps(ordApObsDO.getId_pps());//检查目的ID
		emsRisViewDTO.setSd_pps(ordApObsDO.getSd_pps());//检查目的编码
		emsRisViewDTO.setName_pps(ordApObsDO.getName_pps());//检查目的
		emsRisViewDTO.setId_di(ordApObsDO.getId_di());//临床诊断ID
		emsRisViewDTO.setId_diitm(ordApObsDO.getId_diitm());//诊断子项ID
		emsRisViewDTO.setName_diitm(ordApObsDO.getName_diag());//临床诊断
		emsRisViewDTO.setNo_applyform(ordApObsDO.getNo_applyform());//申请单号
		emsRisViewDTO.setFg_set(opInfo.getOrderInfo().getFg_set());//服务套标识
		//		emsRisViewDTO.setFg_radio(medSrv.getFg_setradio());//服务套单选标识
		emsRisViewDTO.setClinicalzztz(ordApObsDO.getClinicalzztz());//临床症状体征
		//emsRisViewDTO.setStatus(DOStatus.UPDATED);

		emsRisViewDTO.setDef1(ordApObsDO.getDef1());
		emsRisViewDTO.setDef2(ordApObsDO.getDef2());
		emsRisViewDTO.setDef3(ordApObsDO.getDef3());
		emsRisViewDTO.setDef4(ordApObsDO.getDef4());
		emsRisViewDTO.setDef5(ordApObsDO.getDef5());
		emsRisViewDTO.setDef6(ordApObsDO.getDef6());
		emsRisViewDTO.setDef7(ordApObsDO.getDef7());
		emsRisViewDTO.setDef8(ordApObsDO.getDef8());
		emsRisViewDTO.setDef9(ordApObsDO.getDef9());
		emsRisViewDTO.setDef10(ordApObsDO.getDef10());
		emsRisViewDTO.setDef11(ordApObsDO.getDef11());
		emsRisViewDTO.setDef12(ordApObsDO.getDef12());
		emsRisViewDTO.setDef13(ordApObsDO.getDef13());
		emsRisViewDTO.setDef14(ordApObsDO.getDef14());
		emsRisViewDTO.setDef15(ordApObsDO.getDef15());
		emsRisViewDTO.setDef16(ordApObsDO.getDef16());
		emsRisViewDTO.setDef17(ordApObsDO.getDef17());
		emsRisViewDTO.setDef18(ordApObsDO.getDef18());
		emsRisViewDTO.setDef19(ordApObsDO.getDef19());
		emsRisViewDTO.setDef20(ordApObsDO.getDef20());
		emsRisViewDTO.setDef21(ordApObsDO.getDef21());
		emsRisViewDTO.setDef22(ordApObsDO.getDef22());
		emsRisViewDTO.setDef23(ordApObsDO.getDef23());
		emsRisViewDTO.setDef24(ordApObsDO.getDef24());
		emsRisViewDTO.setDef25(ordApObsDO.getDef25());
		emsRisViewDTO.setDef26(ordApObsDO.getDef26());
		emsRisViewDTO.setDef27(ordApObsDO.getDef27());
		emsRisViewDTO.setDef28(ordApObsDO.getDef28());
		emsRisViewDTO.setDef29(ordApObsDO.getDef29());
		emsRisViewDTO.setDef30(ordApObsDO.getDef30());
		emsRisViewDTO.setDef31(ordApObsDO.getDef31());
		emsRisViewDTO.setDef32(ordApObsDO.getDef32());
		emsRisViewDTO.setDef33(ordApObsDO.getDef33());
		emsRisViewDTO.setDef34(ordApObsDO.getDef34());
		emsRisViewDTO.setDef35(ordApObsDO.getDef35());
		emsRisViewDTO.setDef36(ordApObsDO.getDef36());
		emsRisViewDTO.setDef37(ordApObsDO.getDef37());
		emsRisViewDTO.setDef38(ordApObsDO.getDef38());
		emsRisViewDTO.setDef39(ordApObsDO.getDef39());
		emsRisViewDTO.setDef40(ordApObsDO.getDef40());
		emsRisViewDTO.setDef41(ordApObsDO.getDef41());
		emsRisViewDTO.setDef42(ordApObsDO.getDef42());
		emsRisViewDTO.setDef43(ordApObsDO.getDef43());
		emsRisViewDTO.setDef44(ordApObsDO.getDef44());
		emsRisViewDTO.setDef45(ordApObsDO.getDef45());
		emsRisViewDTO.setDef46(ordApObsDO.getDef46());
		emsRisViewDTO.setDef47(ordApObsDO.getDef47());
		emsRisViewDTO.setDef48(ordApObsDO.getDef48());
		emsRisViewDTO.setDef49(ordApObsDO.getDef49());
		emsRisViewDTO.setDef50(ordApObsDO.getDef50());
		
		//设置检查套内项目
		this.setSrvSetInfo4EmsRis(ctx, opInfo, emsRisViewDTO);

		return emsRisViewDTO;
	}

	/**
	 * 设置检查套内项目
	 * @param ctx
	 * @param emsDTO
	 * @param emsRisViewDTO
	 * @throws BizException
	 */
	private void setSrvSetInfo4EmsRis(CiEnContextDTO ctx, OrderPackageInfo opInfo, EmsRisViewDTO emsRisViewDTO) 
			throws BizException {
		// 构建检查套内项目列表数据源模型
		FArrayList emsRisViewItemDTOs = new FArrayList();
		if (CiOrdUtils.isTrue(emsRisViewDTO.getFg_set())) {
			// 服务套项目
			MedSrvSetItemDO[] medSrvSetItemDOs = ServiceFinder.find(IMedSrvSetItemDORService.class)
					.find(String.format("a8.id_srv='%s' and a8.fg_clinical='Y' and a8.fg_active='Y'", emsRisViewDTO.getId_srv()), "", FBoolean.FALSE);
			if (null == medSrvSetItemDOs || medSrvSetItemDOs.length == 0) {
				return;
			}
			String[] idsrvs = new String[medSrvSetItemDOs.length];
			int i = 0;
			for (MedSrvSetItemDO item : medSrvSetItemDOs) {
				idsrvs[i] = item.getId_srv_itm();
				i++;
			}
			// 获取套内项目的基础服务定义信息
			MedsrvAggDO[] medsrvAggDOs = ServiceFinder.find(IMedsrvRService.class).findByIds(idsrvs, FBoolean.FALSE);
			// 字典化-套内基础服务项目
			Map<String, MedsrvAggDO> mapMedsrvAggDOs = new HashMap<String, MedsrvAggDO>();
			for (MedsrvAggDO agg : medsrvAggDOs) {
				mapMedsrvAggDOs.put(agg.getParentDO().getId_srv(), agg);
			}

			// 获取医疗单中的套内项目, 如果服务套医嘱没有套内项目信息，报错处理
			OrderSrvSetList srvSetItemList = opInfo.getOrderSrvSetList();
			if (srvSetItemList == null || srvSetItemList.size() == 0) {
				return;
			}

			Map<String, OrdSrvSetDO> mapOrdSrvSetDOs = new HashMap<String, OrdSrvSetDO>();
			for (Object item : srvSetItemList) {
				OrdSrvSetDO ordSrvSetDO = (OrdSrvSetDO)item;
				mapOrdSrvSetDOs.put(ordSrvSetDO.getId_srvset(), ordSrvSetDO);
			}

			// 字典化-服务项目
			Map<String, String> mapCiEmsSrvDTOs = new HashMap<String, String>();
			for (OrdSrvDO srv : opInfo.getOrderSrvList()) {
				mapCiEmsSrvDTOs.put(srv.getId_srv(), srv.getId_orsrv());
			}

			for (MedSrvSetItemDO setItem : medSrvSetItemDOs) {
				EmsRisViewItemDTO emsRisViewItemDTO = new EmsRisViewItemDTO();
				emsRisViewItemDTO.setFg_edit(setItem.getFg_edit());//可编辑标识
				emsRisViewItemDTO.setFg_check(new FBoolean((mapOrdSrvSetDOs.containsKey(setItem.getId_srv_itm()))));//选中标识
				if (mapMedsrvAggDOs.containsKey(setItem.getId_srv_itm())) {
					MedsrvAggDO agg = mapMedsrvAggDOs.get(setItem.getId_srv_itm());
					emsRisViewItemDTO.setId_srv(agg.getParentDO().getId_srv());//服务ID
					emsRisViewItemDTO.setName_srv(agg.getParentDO().getName());//服务
					if (agg.getMedSrvRisDO() != null && agg.getMedSrvRisDO().length > 0) {
						MedSrvRisDO medSrvRis = agg.getMedSrvRisDO()[0];
						emsRisViewItemDTO.setId_body(medSrvRis.getId_body());//部位ID
						emsRisViewItemDTO.setSd_body(medSrvRis.getSd_body());//部位编码
						emsRisViewItemDTO.setName_body(medSrvRis.getName_body());//部位
						emsRisViewItemDTO.setId_pos(medSrvRis.getId_pos());//方位ID
						emsRisViewItemDTO.setSd_pos(medSrvRis.getSd_pos());//方位编码
						emsRisViewItemDTO.setName_pos(medSrvRis.getName_pos());//方位
					}
					if (mapCiEmsSrvDTOs.containsKey(emsRisViewItemDTO.getId_srv())) {
						emsRisViewItemDTO.setId_or_srv(mapCiEmsSrvDTOs.get(emsRisViewItemDTO.getId_srv()));//医嘱服务ID
					}
				}
				emsRisViewItemDTOs.append(emsRisViewItemDTO);
			}
		} else {
			OrdSrvDO ciEmsSrvDTO = this.mainSrvInfoFrom(opInfo);
			if (null != ciEmsSrvDTO) {
				EmsRisViewItemDTO emsRisViewItemDTO = new EmsRisViewItemDTO();
				//				emsRisViewItemDTO.setFg_edit(Fg_edit);//可编辑标识
				//				emsRisViewItemDTO.setFg_check(Fg_check);//选中标识
				emsRisViewItemDTO.setId_srv(ciEmsSrvDTO.getId_srv());//服务ID
				emsRisViewItemDTO.setName_srv(ciEmsSrvDTO.getName_srv());//服务
				emsRisViewItemDTO.setId_or_srv(ciEmsSrvDTO.getId_orsrv());//医嘱服务ID

				String strsql="select OBS.id_body,OBS.sd_body,BODY.name as name_body,OBS.id_pos,OBS.sd_pos,POS.name as name_pos from ci_ap_obs OBS "
						+ "left join bd_udidoc BODY on BODY.id_udidoc=OBS.id_body "
						+ "left join bd_udidoc POS on POS.id_udidoc=OBS.id_pos";
				SqlConditionsParameter sqlCondParameter = new SqlConditionsParameter();
				sqlCondParameter.setSql(strsql);
				sqlCondParameter.sqlInParam(" where OBS.id_or ", new String[] { emsRisViewItemDTO.getId_or() });
				ListMapRecordSet recordSet = DatabaseUtils.Q(sqlCondParameter);
				if (recordSet != null && recordSet.size() > 0){
					emsRisViewItemDTO.setId_body(recordSet.get(0).get("id_body").toString());//部位ID
					emsRisViewItemDTO.setSd_body(recordSet.get(0).get("sd_body").toString());//部位编码
					emsRisViewItemDTO.setName_body(recordSet.get(0).get("name_body").toString());//部位
					emsRisViewItemDTO.setId_pos(recordSet.get(0).get("id_pos").toString());//方位ID
					emsRisViewItemDTO.setSd_pos(recordSet.get(0).get("sd_pos").toString());//方位编码
					emsRisViewItemDTO.setName_pos(recordSet.get(0).get("name_pos").toString());//方位
				}
				emsRisViewItemDTOs.append(emsRisViewItemDTO);
			}
		}
		emsRisViewDTO.setExtInfoList(emsRisViewItemDTOs);
	}
}
