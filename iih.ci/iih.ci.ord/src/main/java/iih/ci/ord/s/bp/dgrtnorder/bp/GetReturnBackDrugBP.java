package iih.ci.ord.s.bp.dgrtnorder.bp;

import java.util.ArrayList;
import java.util.List;

import iih.ci.ord.dto.dgrtnorderdto.d.DgRtnOrderDTO;
import iih.ci.ord.s.ems.log.OrdBizLogger;
import iih.mp.dg.i.external.provide.IMpDgCIService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.sf.core.util.ServiceFinder;

public class GetReturnBackDrugBP {
	/**
	 * 退药
	 * @param id_en
	 * @param strs={ emsOrDrug.Id_mm, emsOrDrug.Id_dep_wh,id_or_src, emsOrDrug.Id_unit_med };
	 * @return
	 * @throws BizException
	 */
	public DgRtnOrderDTO[] getReturnBackdrugList(String id_en, String[]strs)
			throws BizException {
		// 1、条件合法性校验
		if (StringUtil.isEmpty(id_en))
			return null;
		if (ArrayUtil.isEmpty(strs))
			return null;
		if (StringUtil.isEmpty(strs[0]) || StringUtil.isEmpty(strs[1]) || StringUtil.isEmpty(strs[3])) {
			return null;
		}

		// 2.返回结果集
		DgRtnOrderDTO[] dgRtnOrderDTOS = getReturnDTOS(id_en, strs);

		return dgRtnOrderDTOS;
		
	}

	

	private DgRtnOrderDTO[] getReturnDTOS(String id_en, String[] strs)
			throws BizException {

		iih.mp.dg.dto.dgrtnorderdto.d.DgRtnOrderDTO[] dtos = new iih.mp.dg.dto.dgrtnorderdto.d.DgRtnOrderDTO[1];
		iih.mp.dg.dto.dgrtnorderdto.d.DgRtnOrderDTO dgorderDTO = new iih.mp.dg.dto.dgrtnorderdto.d.DgRtnOrderDTO();
		dgorderDTO.setId_mm(strs[0]);//物品ID
		dgorderDTO.setId_dep_wh(strs[1]);//物资科室
		dgorderDTO.setId_or_src(strs[2]);//原发药医嘱ID
		dtos[0] = dgorderDTO;

		List<iih.ci.ord.dto.dgrtnorderdto.d.DgRtnOrderDTO> CIRtnOrderDTOList = new ArrayList<iih.ci.ord.dto.dgrtnorderdto.d.DgRtnOrderDTO>();
		
		long tBeginTime = System.currentTimeMillis();
		iih.mp.dg.dto.dgrtnorderdto.d.DgRtnOrderDTO[] DgRtnOrderDTOList = ServiceFinder.find(IMpDgCIService.class).findIpDrugUseList(id_en, dtos);
		OrdBizLogger.info(null,String.format("退药调用药品执行域：IMpDgCIService.findIpDrugUseList,耗时:%s(ms)",System.currentTimeMillis()-tBeginTime));
		
		if (DgRtnOrderDTOList == null || DgRtnOrderDTOList.length == 0) {OrdBizLogger.info(null, "调用执行域接口：IMpDgCIService.findIpDrugUseList,未查询到退药信息！");}
		if (DgRtnOrderDTOList == null || DgRtnOrderDTOList.length == 0){
			return null;
		}
		for (int i = 0; i < DgRtnOrderDTOList.length; i++) {
			iih.ci.ord.dto.dgrtnorderdto.d.DgRtnOrderDTO dto = new iih.ci.ord.dto.dgrtnorderdto.d.DgRtnOrderDTO();
			if(strs[3].equals(DgRtnOrderDTOList[i].getId_pkgu_cur())&&strs[1].equals(DgRtnOrderDTOList[i].getId_dep_wh())){//包装单位和物资仓库匹配返回的结果集
			dto.setId_ent(DgRtnOrderDTOList[i].getId_ent());// 就诊ID
			dto.setId_pat(DgRtnOrderDTOList[i].getId_pat());// 患者ID
			dto.setCode_entp(DgRtnOrderDTOList[i].getCode_entp());// 就诊类型
			dto.setName_pat(DgRtnOrderDTOList[i].getName_pat());// 患者名称
			dto.setId_srv(DgRtnOrderDTOList[i].getId_srv());// 服务ID
			dto.setSd_srvtp(DgRtnOrderDTOList[i].getSd_srvtp());// 服务类型
			dto.setName_srv(DgRtnOrderDTOList[i].getName_srv());// 服务名称
			dto.setId_mm(DgRtnOrderDTOList[i].getId_mm());// 物品
			dto.setName_mm(DgRtnOrderDTOList[i].getName_mm());// 物品名称
			dto.setId_pkgu_cur(DgRtnOrderDTOList[i].getId_pkgu_cur());// 包装单位
			dto.setName_pkgu_cur(DgRtnOrderDTOList[i].getName_pkgu_cur());// 单位名称
			dto.setName_dep_or(DgRtnOrderDTOList[i].getName_dep_or());// 开单科室
			dto.setName_dep_mp(DgRtnOrderDTOList[i].getName_dep_mp());// 执行科室
			dto.setId_dep_wh(DgRtnOrderDTOList[i].getId_dep_wh());// 物资科室
			dto.setQuan_bk_max(DgRtnOrderDTOList[i].getQuan_bk_max());// 可退最大数量
			dto.setCode_or(DgRtnOrderDTOList[i].getCode_or());// 医嘱编码
			dto.setDt_effe(DgRtnOrderDTOList[i].getDt_effe());// 生效时间
			dto.setDt_end(DgRtnOrderDTOList[i].getDt_end());// 结束时间
			dto.setId_or(DgRtnOrderDTOList[i].getId_or());// 医嘱ID
			CIRtnOrderDTOList.add(dto);
			}
		}
		if (CIRtnOrderDTOList != null && CIRtnOrderDTOList.size() > 0) {
			return CIRtnOrderDTOList.toArray(new iih.ci.ord.dto.dgrtnorderdto.d.DgRtnOrderDTO[CIRtnOrderDTOList.size()]);
		}
		return null;
	}
}
