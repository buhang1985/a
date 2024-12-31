package iih.ci.ord.s.ems.ip.ems.opr;

import iih.ci.ord.cior.d.CiorappsurgeryAggDO;
import iih.ci.ord.cior.d.OrdApSugViewItemDO;
import iih.ci.ord.cior.d.OrdOpEmpDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.dws.ip.ems.d.EmsOprEmpDTO;
import iih.ci.ord.dws.ip.ems.d.EmsOprViewDTO;
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
 * 手术医疗单加载逻辑
 * @author Young
 *
 */
public class EmsOprLoadBP extends BaseIpEmsLoadBP {

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

		EmsOprViewDTO emsOpsViewDTO = this.getEmsOpsViewDTO(ctx, szOrderPackageInfo[0]);
		if (null == emsOpsViewDTO) {
			FArrayList errorEmsList = new FArrayList();
			errorEmsList.append("获取申请单信息失败！");
			emsRstDTO.setErrorEmsList(errorEmsList);
			return new EmsRstDTO[] { emsRstDTO };
		}
		if(!CiOrdUtils.isEmpty(arg.getDocument())){
			OrderListViewDTO srcdto=(OrderListViewDTO)arg.getDocument().get(0);
			this.mergeModelInfo(srcdto, emsOpsViewDTO);
		}
		emsOpsViewDTO.setFg_selfpay(FBoolean.TRUE.equals(emsOpsViewDTO.getFg_orhp())?FBoolean.FALSE:FBoolean.TRUE);
		//医疗单驱动	
		emsOpsViewDTO.setDriverInfo(arg.getDriverInfo());
		// 医疗单模型文档
		emsRstDTO.setDocument(handleReturnDocument(emsOpsViewDTO));

		return new EmsRstDTO[] { emsRstDTO };
	}

	/**
	 * 加载主模型对象
	 * @param ctx
	 * @param emsDTO
	 * @return
	 * @throws BizException
	 */
	private EmsOprViewDTO getEmsOpsViewDTO(CiEnContextDTO ctx, OrderPackageInfo opInfo) 
			throws BizException {
		EmsOprViewDTO emsOpsViewDTO = new EmsOprViewDTO();
		emsOpsViewDTO.setStatus(DOStatus.UPDATED);
		this.orderListViewInfoFrom(ctx, opInfo.getMainBdSrvInfo(), opInfo.getOrderInfo(), this.mainSrvInfoFrom(opInfo), emsOpsViewDTO);

		CiorappsurgeryAggDO ciorappsurgeryAggDO = (CiorappsurgeryAggDO)opInfo.getOrderAppSheetList().get(0);
		if (ciorappsurgeryAggDO == null) {
			return null;
		}
		
		emsOpsViewDTO.setId_anestp(ciorappsurgeryAggDO.getParentDO().getId_anestp());//麻醉方式ID
		emsOpsViewDTO.setSd_anestp(ciorappsurgeryAggDO.getParentDO().getSd_anestp());//麻醉方式编码
		emsOpsViewDTO.setName_anestp(ciorappsurgeryAggDO.getParentDO().getName_anestp());//麻醉方式
		emsOpsViewDTO.setId_datelimittype(ciorappsurgeryAggDO.getParentDO().getId_datelimittype());;//手术时限
		emsOpsViewDTO.setSd_datelimittype(ciorappsurgeryAggDO.getParentDO().getSd_datelimittype());//手术时限
		emsOpsViewDTO.setName_datelimittype(ciorappsurgeryAggDO.getParentDO().getName_datelimittp());//手术时限
		emsOpsViewDTO.setDt_plan(ciorappsurgeryAggDO.getParentDO().getDt_plan());//计划手术时间

		emsOpsViewDTO.setNo_applyform(ciorappsurgeryAggDO.getParentDO().getNo_applyform());//手术单号
		//		emsOpsViewDTO.setId_opex_srvs(ciorappsurgeryAggDO.getParentDO().getId_opex_srvs());//附加手术ID
		//		emsOpsViewDTO.setCode_opex_srvs(ciorappsurgeryAggDO.getParentDO().Code_opex_srvs);//附加手术编码
		//		emsOpsViewDTO.setName_opex_srvs(ciorappsurgeryAggDO.getParentDO().Name_opex_srvs);//附加手术
		emsOpsViewDTO.setId_lvlsug(ciorappsurgeryAggDO.getParentDO().getId_lvlsug());//手术级别ID
		emsOpsViewDTO.setSd_lvlsug(ciorappsurgeryAggDO.getParentDO().getSd_lvlsug());//手术级别编码
		emsOpsViewDTO.setName_lvlsug(ciorappsurgeryAggDO.getParentDO().getName_lvlsug());//手术级别
		emsOpsViewDTO.setId_emp_operator(ciorappsurgeryAggDO.getParentDO().getId_emp_operate());//主刀医师ID
		emsOpsViewDTO.setName_emp_operator(ciorappsurgeryAggDO.getParentDO().getName_operate());//主刀医师
		emsOpsViewDTO.setId_emp_helper(ciorappsurgeryAggDO.getParentDO().getId_emp_helper());//第一助手ID
		emsOpsViewDTO.setName_emp_helper(ciorappsurgeryAggDO.getParentDO().getName_helper());//第一助手
		emsOpsViewDTO.setFg_patho(ciorappsurgeryAggDO.getParentDO().getFg_patho());//冰冻处理标识
		emsOpsViewDTO.setFg_allergy(ciorappsurgeryAggDO.getParentDO().getFg_allergy());//药物过敏标识
		emsOpsViewDTO.setQuan_bt_paln(ciorappsurgeryAggDO.getParentDO().getQuan_bt_paln());//预期输血量
		emsOpsViewDTO.setAnnouncements(ciorappsurgeryAggDO.getParentDO().getAnnouncements());//注意事项
		emsOpsViewDTO.setDes_or(opInfo.getOrderInfo().getDes_or());//描述
		emsOpsViewDTO.setEu_anseca(Integer.parseInt(ciorappsurgeryAggDO.getParentDO().getEu_anesca()));//麻醉分类

		emsOpsViewDTO.setExtInfoList(this.getEmsOpsEmpDTOs(ciorappsurgeryAggDO));//手术人员信息
		emsOpsViewDTO.setExtInfoList(this.getOpViewItem(ciorappsurgeryAggDO));//动态指标信息
		this.setOpex4EmsOpsEmpDTO(emsOpsViewDTO, opInfo);//附加手术信息

		return emsOpsViewDTO;
	}

	/**
	 * 查询手术人员信息
	 * @param ciorappsurgeryAggDO
	 * @return
	 */
	private FArrayList getEmsOpsEmpDTOs(CiorappsurgeryAggDO ciorappsurgeryAggDO) {
		FArrayList emsOpsEmpDTOs = new FArrayList();
		OrdOpEmpDO[] ordOpEmpDOs = ciorappsurgeryAggDO.getOrdOpEmpDO();
		for (OrdOpEmpDO ordOpEmpDO : ordOpEmpDOs) {
			EmsOprEmpDTO emsOpsEmpDTO = new EmsOprEmpDTO();
			emsOpsEmpDTO.setId_apopemp(ordOpEmpDO.getId_apopemp());
			emsOpsEmpDTO.setId_emp(ordOpEmpDO.getId_emp());
			emsOpsEmpDTO.setName_emp(ordOpEmpDO.getName_emp());
			emsOpsEmpDTO.setId_role(ordOpEmpDO.getId_role());
			emsOpsEmpDTO.setSd_role(ordOpEmpDO.getSd_role());
			emsOpsEmpDTO.setName_role(ordOpEmpDO.getName_role());
			emsOpsEmpDTO.setSortno(ordOpEmpDO.getSortno());
			emsOpsEmpDTO.setStatus(DOStatus.UNCHANGED);

			emsOpsEmpDTOs.append(emsOpsEmpDTO);
		}
		return emsOpsEmpDTOs;
	}

	/**
	 * 设置附加手术信息
	 * @param emsOpsViewDTO
	 * @param emsDTO
	 */
	private void setOpex4EmsOpsEmpDTO(EmsOprViewDTO emsOpsViewDTO, OrderPackageInfo opInfo) {
		String idsrvs = "";
		String codesrvs = "";
		String namesrvs = "";
		for (OrdSrvDO objInfo : opInfo.getOrderSrvList()) {
			OrdSrvDO srvInfo = (OrdSrvDO) objInfo;
			if (!srvInfo.getId_srv().equals(emsOpsViewDTO.getId_srv())
					&& CiOrdUtils.isTrue(srvInfo.getFg_or())) {
				idsrvs += "," + srvInfo.getId_srv();
				codesrvs += "," + srvInfo.getCode_srv();
				namesrvs += "," + srvInfo.getName_srv();
			}
		}
		if (idsrvs.length() > 0) {
			emsOpsViewDTO.setId_opex_srvs(idsrvs.substring(1));// 附加手术ID
			emsOpsViewDTO.setCode_opex_srvs(codesrvs.substring(1));// 附加手术编码
			emsOpsViewDTO.setName_opex_srvs(namesrvs.substring(1));// 附加手术
		}
	}

	/**
	 * 查询动态指标信息
	 * @param aggDO
	 * @return
	 */
	private FArrayList getOpViewItem(CiorappsurgeryAggDO aggDO) {
		OrdApSugViewItemDO[] itemDOs = aggDO.getOrdApSugViewItemDO();
		FArrayList opViewItems = new FArrayList();
		for (OrdApSugViewItemDO itemDO : itemDOs) {
			itemDO.setVal_restrptlab(itemDO.getVal_restrptlab() == null ? "" : itemDO.getVal_restrptlab().replace(',', '|'));
			opViewItems.append(itemDO);
		}
		return opViewItems;
	}
}
