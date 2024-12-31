package iih.mi.itf2.service.bp.bdservice.treat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import iih.bd.pp.hpsrvorca.d.HpSrvTpEnum;
import iih.mi.itf.context.InsureContext;
import iih.mi.itf.facade.InsureFacade;
import iih.mi.itf2.dto.MiContext;
import iih.mi.itf2.dto.MiResultOutParam;
import iih.mi.itf2.dto.drugmanualcomp.d.LoadOrginalDataInParam;
import iih.mi.itf2.dto.drugmanualcomp.d.LoadOrginalDataOutParam;
import iih.mi.itf2.dto.midirdownload.d.MiDirEnum;
import iih.mi.itf2.dto.treatandfwsscomp.d.TreatAndFwssCompDTO;
import iih.mi.itf2.facade.MiFacade;
import iih.mi.itf2.service.bp.bdservice.util.ToolUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;

/**
 * 补全医保和服务设施数据业务逻辑 Title: CompInsurTreatAndFwssDataNewBp.java
 * 
 * @author zhang.hw
 * @date 2019年5月27日
 * @version 1.0
 */
public class CompInsurTreatAndFwssDataBp {

	public TreatAndFwssCompDTO[] exec(TreatAndFwssCompDTO[] treatCompDTOs) throws BizException {
		if (treatCompDTOs == null || treatCompDTOs.length <= 0) {
			return treatCompDTOs;
		}
		List<TreatAndFwssCompDTO> list = new ArrayList<TreatAndFwssCompDTO>();
		for (TreatAndFwssCompDTO treatCompDTO : treatCompDTOs) {
			if (MiDirEnum.MIDIRSRV.equals(treatCompDTO.getEu_hpsrvtp())) {
				list.add(CompInsurTreatData(treatCompDTO, MiDirEnum.MIDIRSRV));
			} else if (MiDirEnum.MIDIRFACILITY.equals(treatCompDTO.getEu_hpsrvtp())) {
				list.add(CompInsurTreatData(treatCompDTO, MiDirEnum.MIDIRFACILITY));
			} else if (MiDirEnum.MIDIRMC.equals(treatCompDTO.getEu_hpsrvtp())) {
				list.add(CompInsurTreatData(treatCompDTO, MiDirEnum.MIDIRMC));
			}
		}
		return list.toArray(new TreatAndFwssCompDTO[list.size()]);
	}

	/**
	 * 补全医保数据
	 * 
	 * @param treatCompDTO
	 * @throws BizException
	 */
	private TreatAndFwssCompDTO CompInsurTreatData(TreatAndFwssCompDTO treatCompDTO, String miDirType)
			throws BizException {
		if (treatCompDTO == null) {
			return treatCompDTO;
		}
		if (StringUtils.isBlank(treatCompDTO.getMi_code())) {
			ClearMiTreatAndFwssDataBp bp = new ClearMiTreatAndFwssDataBp();
			return bp.exec(treatCompDTO);
		}
		TreatAndFwssCompDTO bdHpZlOrginalDO = GetInsurZlByCode(treatCompDTO.getMi_code(), treatCompDTO.getId_hp(),
				miDirType);
		return CompInsurTreatData(treatCompDTO, bdHpZlOrginalDO);
	}

	/**
	 * 使用医保编码查询医保信息
	 * 
	 * @param hpdidict_code
	 * @return
	 * @throws BizException
	 */
	private TreatAndFwssCompDTO GetInsurZlByCode(String mi_code, String id_hp, String miDirType) throws BizException {
		MiContext miContext = new MiContext();
		miContext.setIdHp(id_hp);
		MiFacade miFacade = new MiFacade(miContext);
		LoadOrginalDataInParam inParam = new LoadOrginalDataInParam();
		inParam.setDirtype(miDirType);
		inParam.setId_hp(id_hp);
		FArrayList list = new FArrayList();
		Collections.addAll(list, mi_code);
		inParam.setCodes(list);
		MiResultOutParam<LoadOrginalDataOutParam> outParam = miFacade.selectOrginalData(inParam);
		if (!outParam.getFg_deal().booleanValue()||!(outParam.getFg_HpSuccess()!=null&&outParam.getFg_HpSuccess().booleanValue())) {
			new BizException(outParam.getErrorMsg());
		}
		LoadOrginalDataOutParam orginalDataOutParam = outParam.getData();
		if (!miDirType.equals(orginalDataOutParam.getDirtype())) {
			new BizException("查询已对照原始目录信息出错，请联系工程师！出错信息——his目录类型：" + inParam.getDirtype() + "；客开返回目录类型："
					+ orginalDataOutParam.getDirtype());
		}
		TreatAndFwssCompDTO[] result = ToolUtils.ToList(orginalDataOutParam.getDetail())
				.toArray(new TreatAndFwssCompDTO[orginalDataOutParam.getDetail().size()]);
		if (result == null || result.length <= 0) {
			String type = miDirType.equals(MiDirEnum.MIDIRSRV) ? "诊疗"
					: miDirType.equals(MiDirEnum.MIDIRFACILITY) ? "服务设施" : "材料";
			String msg = String.format("获取医保信息失败，医保\"%s\"目录编码：\"%s\"。", type, mi_code);
			throw new BizException(msg);
		}
		return result[0];
	}

	/**
	 * 补全医保项目信息
	 * 
	 * @param treatCompDTO
	 * @param bdHpZlOrginalDO
	 */
	private TreatAndFwssCompDTO CompInsurTreatData(TreatAndFwssCompDTO treatCompDTO,
			TreatAndFwssCompDTO bdHpZlOrginalDO) {
		if (treatCompDTO == null || bdHpZlOrginalDO == null) {
			return treatCompDTO;
		}
		bdHpZlOrginalDO.setSrv_code(treatCompDTO.getSrv_code());
		bdHpZlOrginalDO.setSrv_freq(treatCompDTO.getSrv_freq());
		bdHpZlOrginalDO.setSrv_name(treatCompDTO.getSrv_name());
		bdHpZlOrginalDO.setSrv_price(treatCompDTO.getSrv_price());
		bdHpZlOrginalDO.setSrv_pycode(treatCompDTO.getSrv_pycode());
		bdHpZlOrginalDO.setSrv_quan(treatCompDTO.getSrv_quan());
		bdHpZlOrginalDO.setSrv_route(treatCompDTO.getSrv_route());
		bdHpZlOrginalDO.setSrv_unit(treatCompDTO.getSrv_unit());
		bdHpZlOrginalDO.setSrv_wbcode(treatCompDTO.getSrv_wbcode());
		bdHpZlOrginalDO.setId(treatCompDTO.getId());
		bdHpZlOrginalDO.setId_hp(treatCompDTO.getId_hp());
		bdHpZlOrginalDO.setId_hpsrvorca(treatCompDTO.getId_hpsrvorca());
		bdHpZlOrginalDO.setId_srv(treatCompDTO.getId_srv());
		bdHpZlOrginalDO.setEu_status(treatCompDTO.getEu_status());
		bdHpZlOrginalDO.setEu_hpsrvtp(treatCompDTO.getEu_hpsrvtp());
		if (treatCompDTO.getStatus() == DOStatus.UNCHANGED) {
			bdHpZlOrginalDO.setStatus(DOStatus.UPDATED);
		}
		return bdHpZlOrginalDO;
	}
}
