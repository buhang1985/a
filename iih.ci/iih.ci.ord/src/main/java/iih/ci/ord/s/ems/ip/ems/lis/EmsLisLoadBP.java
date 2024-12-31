package iih.ci.ord.s.ems.ip.ems.lis;

import java.util.HashMap;
import java.util.Map;

import iih.bd.srv.medsrv.d.MedSrvSetItemDO;
import iih.bd.srv.medsrv.d.MedsrvAggDO;
import iih.bd.srv.medsrv.i.IMedSrvSetItemDORService;
import iih.bd.srv.medsrv.i.IMedsrvRService;
import iih.ci.ord.cior.d.OrdApLabDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.dws.ip.ems.d.EmsLisViewDTO;
import iih.ci.ord.dws.ip.ems.d.EmsLisViewItemDTO;
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
 * 检验医疗单加载逻辑
 * @author Young
 *
 */
public class EmsLisLoadBP extends BaseIpEmsLoadBP {

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

		EmsLisViewDTO emsLisViewDTO = this.getEmsLisViewDTO(ctx, szOrderPackageInfo[0]);
		if (null == emsLisViewDTO) {
			FArrayList errorEmsList = new FArrayList();
			errorEmsList.append("获取申请单信息失败！");
			emsRstDTO.setErrorEmsList(errorEmsList);
			return new EmsRstDTO[] { emsRstDTO };
		}
		if(!CiOrdUtils.isEmpty(arg.getDocument())){
			OrderListViewDTO srcdto=(OrderListViewDTO)arg.getDocument().get(0);
			this.mergeModelInfo(srcdto, emsLisViewDTO);
		}
		
		emsLisViewDTO.setFg_selfpay(FBoolean.TRUE.equals(emsLisViewDTO.getFg_orhp())?FBoolean.FALSE:FBoolean.TRUE);
		//医疗单驱动
		emsLisViewDTO.setDriverInfo(arg.getDriverInfo());
		// 医疗单模型文档
		emsRstDTO.setDocument(handleReturnDocument(emsLisViewDTO));

		return new EmsRstDTO[] { emsRstDTO };
	}

	/**
	 * 加载主模型对象
	 * @param ctx
	 * @param emsDTO
	 * @return
	 * @throws BizException
	 */
	private EmsLisViewDTO getEmsLisViewDTO(CiEnContextDTO ctx, OrderPackageInfo opInfo) 
			throws BizException {
		EmsLisViewDTO emsLisViewDTO = new EmsLisViewDTO();
		emsLisViewDTO.setStatus(DOStatus.UPDATED);
		this.orderListViewInfoFrom(ctx, opInfo.getMainBdSrvInfo(), opInfo.getOrderInfo(), this.mainSrvInfoFrom(opInfo), emsLisViewDTO);

		OrdApLabDO ordApLabDO = (OrdApLabDO)opInfo.getOrderAppSheetList().get(0);
		if (ordApLabDO == null) {
			return emsLisViewDTO;
		}

		emsLisViewDTO.setId_samptp(ordApLabDO.getId_samptp());//标本类型ID
		emsLisViewDTO.setSd_samptp(ordApLabDO.getSd_samptp());//标本类型编码
		emsLisViewDTO.setName_samptp(ordApLabDO.getName_samptp());//标本类型
		emsLisViewDTO.setId_sampcoltime(ordApLabDO.getId_sampcoltime()); //标本采集时间ID
		emsLisViewDTO.setName_sampcoltime(ordApLabDO.getName_sampcoltime()); //标本采集时间
		emsLisViewDTO.setId_sampcollecttimetp(ordApLabDO.getId_sampcollecttimetp()); //标本采集时间类型ID
		emsLisViewDTO.setSd_sampcollecttimetp(ordApLabDO.getSd_sampcollecttimetp()); //标本采集时间类型编码
		emsLisViewDTO.setLen_sampcoltime(ordApLabDO.getLen_sampcoltime()); //标本采集时长
		emsLisViewDTO.setId_unit_sampcoltime(ordApLabDO.getId_unit_sampcoltime()); //标本采集时长单位
		emsLisViewDTO.setId_di(ordApLabDO.getId_di());//临床诊断ID
		emsLisViewDTO.setId_diitm(ordApLabDO.getId_diitm());//诊断子项ID
		emsLisViewDTO.setName_diitm(ordApLabDO.getName_diag());//临床诊断
		emsLisViewDTO.setNo_applyform(ordApLabDO.getNo_applyform());//申请单号
		emsLisViewDTO.setDes_or(opInfo.getOrderInfo().getDes_or());//备注
		emsLisViewDTO.setFg_set(opInfo.getOrderInfo().getFg_set());//服务套标识
		//		emsRisViewDTO.setFg_radio(medSrv.getFg_setradio());//服务套单选标识
//		emsLisViewDTO.setDes_or(ordApLabDO.getdes);//临床症状体征
		emsLisViewDTO.setStatus(DOStatus.UPDATED);

		//设置检查套内项目
		this.setSrvSetInfo4EmsLis(ctx, opInfo, emsLisViewDTO);

		return emsLisViewDTO;
	}

	/**
	 * 设置检验套内项目
	 * @param ctx
	 * @param emsDTO
	 * @param emsRisViewDTO
	 * @throws BizException
	 */
	private void setSrvSetInfo4EmsLis(CiEnContextDTO ctx, OrderPackageInfo opInfo, EmsLisViewDTO emsRisViewDTO) 
			throws BizException {
		// 构建检查套内项目列表数据源模型
		FArrayList emsLisViewItemDTOs = new FArrayList();
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
				EmsLisViewItemDTO emsLisViewItemDTO = new EmsLisViewItemDTO();
				emsLisViewItemDTO.setFg_edit(setItem.getFg_edit());//可编辑标识
				emsLisViewItemDTO.setFg_check(new FBoolean((mapOrdSrvSetDOs.containsKey(setItem.getId_srv_itm()))));//选中标识
				if (mapMedsrvAggDOs.containsKey(setItem.getId_srv_itm())) {
					MedsrvAggDO agg = mapMedsrvAggDOs.get(setItem.getId_srv_itm());
					emsLisViewItemDTO.setId_srv(agg.getParentDO().getId_srv());//服务ID
					emsLisViewItemDTO.setName_srv(agg.getParentDO().getName());//服务
					emsLisViewItemDTO.setId_primd(agg.getParentDO().getId_primd());//定价模式
					if (mapCiEmsSrvDTOs.containsKey(emsLisViewItemDTO.getId_srv())) {
						emsLisViewItemDTO.setId_or_srv(mapCiEmsSrvDTOs.get(emsLisViewItemDTO.getId_srv()));//医嘱服务ID
					}
				}
				emsLisViewItemDTOs.append(emsLisViewItemDTO);
			}
		} else {
			OrdSrvDO ciEmsSrvDTO = this.mainSrvInfoFrom(opInfo);
			if (null != ciEmsSrvDTO) {
				EmsLisViewItemDTO emsLisViewItemDTO = new EmsLisViewItemDTO();
				//				emsRisViewItemDTO.setFg_edit(Fg_edit);//可编辑标识
				//				emsRisViewItemDTO.setFg_check(Fg_check);//选中标识
				emsLisViewItemDTO.setId_srv(ciEmsSrvDTO.getId_srv());//服务ID
				emsLisViewItemDTO.setName_srv(ciEmsSrvDTO.getName_srv());//服务
				emsLisViewItemDTO.setId_primd(ciEmsSrvDTO.getId_primd());
				emsLisViewItemDTO.setId_or_srv(ciEmsSrvDTO.getId_orsrv());//医嘱服务ID
				
				emsLisViewItemDTOs.append(emsLisViewItemDTO);
			}
		}
		emsRisViewDTO.setExtInfoList(emsLisViewItemDTOs);
	}
}
