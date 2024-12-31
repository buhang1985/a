package iih.ci.ord.s.ems.ip.ems.pathgy;

import iih.ci.ord.cior.d.CiorapppathgyAggDO;
import iih.ci.ord.cior.d.OrdApPathgySampDO;
import iih.ci.ord.dws.ip.ems.d.EmsPathgyItemViewDTO;
import iih.ci.ord.dws.ip.ems.d.EmsPathgyViewDTO;
import iih.ci.ord.dws.ip.order.d.OrderListViewDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.EmsLoadDTO;
import iih.ci.ord.i.meta.EmsRstDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.ip.base.BaseIpEmsLoadBP;
import iih.ci.ord.s.ems.meta.OrderPackageInfo;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;

/**
 * 病理医疗单加载逻辑
 * @author Young
 *
 */
public class EmsPathgyLoadBP extends BaseIpEmsLoadBP {
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

		EmsPathgyViewDTO emsPathgyViewDTO = this.getEmsPathgyViewDTO(ctx, szOrderPackageInfo[0]);
		if (null == emsPathgyViewDTO) {
			FArrayList errorEmsList = new FArrayList();
			errorEmsList.append("获取申请单信息失败！");
			emsRstDTO.setErrorEmsList(errorEmsList);
			return new EmsRstDTO[] { emsRstDTO };
		}
		if(!CiOrdUtils.isEmpty(arg.getDocument())){
			OrderListViewDTO srcdto = (OrderListViewDTO)arg.getDocument().get(0);
			this.mergeModelInfo(srcdto, emsPathgyViewDTO);
		}
		emsPathgyViewDTO.setFg_selfpay(FBoolean.TRUE.equals(emsPathgyViewDTO.getFg_orhp())?FBoolean.FALSE:FBoolean.TRUE);
		//医疗单驱动
		emsPathgyViewDTO.setDriverInfo(arg.getDriverInfo());
		// 医疗单模型文档
		emsRstDTO.setDocument(handleReturnDocument(emsPathgyViewDTO));

		return new EmsRstDTO[] { emsRstDTO };
	}

	/**
	 * 加载主模型对象
	 * @param ctx
	 * @param emsDTO
	 * @return
	 * @throws BizException
	 */
	private EmsPathgyViewDTO getEmsPathgyViewDTO(CiEnContextDTO ctx, OrderPackageInfo opInfo) 
			throws BizException {
		EmsPathgyViewDTO emsPathgyViewDTO = new EmsPathgyViewDTO();
		emsPathgyViewDTO.setStatus(DOStatus.UPDATED);
		this.orderListViewInfoFrom(ctx, opInfo.getMainBdSrvInfo(), opInfo.getOrderInfo(), this.mainSrvInfoFrom(opInfo), emsPathgyViewDTO);

		CiorapppathgyAggDO pathgyAggDO = (CiorapppathgyAggDO)opInfo.getOrderAppSheetList().get(0);
		if (pathgyAggDO == null) {
			return null;
		}

		emsPathgyViewDTO.setId_samptp(pathgyAggDO.getParentDO().getId_samptp());//标本类型ID
		emsPathgyViewDTO.setSd_samptp(pathgyAggDO.getParentDO().getSd_samptp());//标本类型编码
		emsPathgyViewDTO.setName_samptp(pathgyAggDO.getParentDO().getName_samptp());//标本类型
		emsPathgyViewDTO.setId_di(pathgyAggDO.getParentDO().getId_di());//
		emsPathgyViewDTO.setId_diitm(pathgyAggDO.getParentDO().getId_diitm());//
		emsPathgyViewDTO.setName_diitm(pathgyAggDO.getParentDO().getName_diag());//
		emsPathgyViewDTO.setNo_applyform(pathgyAggDO.getParentDO().getNo_applyform());//申请单号
		emsPathgyViewDTO.setDes_sympsign(pathgyAggDO.getParentDO().getDes_sympsign());//病情描述
		emsPathgyViewDTO.setAnnouncements(pathgyAggDO.getParentDO().getAnnouncements());//检查要求
		emsPathgyViewDTO.setFg_outer(pathgyAggDO.getParentDO().getFg_outer());//是否外院
		emsPathgyViewDTO.setOrg_pathgy_old(pathgyAggDO.getParentDO().getOrg_pathgy_old());//既往医院
		emsPathgyViewDTO.setNo_pathgy_old(pathgyAggDO.getParentDO().getNo_pathgy_old());//既往病理号
		emsPathgyViewDTO.setDt_pathgy_old(pathgyAggDO.getParentDO().getDt_pathgy_old());//既往病理日期
		emsPathgyViewDTO.setDi_pathgy_old(pathgyAggDO.getParentDO().getDi_pathgy_old());//既往病理诊断
		emsPathgyViewDTO.setCollectdes(pathgyAggDO.getParentDO().getCollectdes());//采集所见
		emsPathgyViewDTO.setId_emp(pathgyAggDO.getParentDO().getId_emp());//采集者ID
		emsPathgyViewDTO.setName_emp(pathgyAggDO.getParentDO().getName_coll_emp());//采集者
		emsPathgyViewDTO.setDt_coll(pathgyAggDO.getParentDO().getDt_coll());//采集时间

		//病理标本集合
		OrdApPathgySampDO[] ordApPathgySampDOs = pathgyAggDO.getOrdApPathgySampDO();
		FArrayList emsPathgyItemViewDTOs = new FArrayList();
		if (ordApPathgySampDOs != null && ordApPathgySampDOs.length > 0) {
			for (OrdApPathgySampDO ordApPathgySampDO : ordApPathgySampDOs) {
				EmsPathgyItemViewDTO emsPathgyItemViewDTO = new EmsPathgyItemViewDTO();
				//				emsPathgyItemViewDTO.setId_lagsamp(ordApPathgySampDO.getId_appathgysamp());
				emsPathgyItemViewDTO.setName_labsamp(ordApPathgySampDO.getName_labsamp());//标本名称
				emsPathgyItemViewDTO.setId_body_coll(ordApPathgySampDO.getId_body_coll());//采集部位ID
				emsPathgyItemViewDTO.setSd_body_coll(ordApPathgySampDO.getSd_body_coll());//采集部位编码
				emsPathgyItemViewDTO.setName_body_coll(ordApPathgySampDO.getBody_coll());//采集部位
				emsPathgyItemViewDTO.setQuan_coll(ordApPathgySampDO.getQuan_coll());//标本数量
				emsPathgyItemViewDTO.setId_fixative(ordApPathgySampDO.getId_fixative());//固定液ID
				emsPathgyItemViewDTO.setSd_fixative(ordApPathgySampDO.getSd_fixative());//固定液编码
				emsPathgyItemViewDTO.setName_fixative(ordApPathgySampDO.getName_fixative());//固定液
				emsPathgyItemViewDTO.setSortno(ordApPathgySampDO.getSortno());//序号
				emsPathgyItemViewDTO.setId_appathgysamp(ordApPathgySampDO.getId_appathgysamp());//病理标本ID
				emsPathgyItemViewDTOs.append(emsPathgyItemViewDTO);
			}
		}
		emsPathgyViewDTO.setExtInfoList(emsPathgyItemViewDTOs);//病理标本集合
		return emsPathgyViewDTO;
	}
}
