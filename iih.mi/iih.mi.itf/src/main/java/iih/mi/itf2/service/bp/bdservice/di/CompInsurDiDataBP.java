package iih.mi.itf2.service.bp.bdservice.di;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import iih.bd.pp.hpdivshisdto.d.HpDiVsHisDTO;
import iih.mi.itf2.dto.MiContext;
import iih.mi.itf2.dto.MiResultOutParam;
import iih.mi.itf2.dto.dicompdto.d.DiCompDTO;
import iih.mi.itf2.dto.drugmanualcomp.d.LoadOrginalDataInParam;
import iih.mi.itf2.dto.drugmanualcomp.d.LoadOrginalDataOutParam;
import iih.mi.itf2.dto.midirdownload.d.MiDirEnum;
import iih.mi.itf2.facade.MiFacade;
import iih.mi.itf2.service.bp.bdservice.util.ToolUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;

public class CompInsurDiDataBP {
	
	public DiCompDTO[] exec(DiCompDTO[] sourceDTO) throws BizException{
		if (sourceDTO == null) {
			return null;
		}
		MiContext miContext = new MiContext();
		miContext.setIdHp(sourceDTO[0].getId_hp());
		MiFacade miFacade = new MiFacade(miContext);
		String[] strId = getCodes(sourceDTO);
		if (strId==null) {
			return sourceDTO;
		}
		DiCompDTO[] retentionDTO = null;
		if (strId.length<sourceDTO.length) {
			//滞留为空数据
			retentionDTO = getRetentionDTO(sourceDTO,sourceDTO.length-strId.length);
		}
		LoadOrginalDataInParam inParam = new LoadOrginalDataInParam();
		inParam.setDirtype(MiDirEnum.MIDIRDI);
		inParam.setId_hp(sourceDTO[0].getId_hp());
		FArrayList list = new FArrayList();
		Collections.addAll(list,strId);
		inParam.setCodes(list);
		MiResultOutParam<LoadOrginalDataOutParam> outParam = miFacade.selectOrginalData(inParam);
		if (!outParam.getFg_deal().booleanValue()||!(outParam.getFg_HpSuccess()!=null&&outParam.getFg_HpSuccess().booleanValue())) {
			new BizException(outParam.getErrorMsg());
		}
		LoadOrginalDataOutParam orginalDataOutParam = outParam.getData();
		if (!MiDirEnum.MIDIRDI.equals(orginalDataOutParam.getDirtype())) {
			new BizException("查询已对照原始目录信息出错，请联系工程师！出错信息——his目录类型："+inParam.getDirtype()+"；客开返回目录类型："+orginalDataOutParam.getDirtype());
		}
		DiCompDTO[] targetDTO = ToolUtils.ToList(orginalDataOutParam.getDetail()).toArray(new DiCompDTO[orginalDataOutParam.getDetail().size()]);
		targetDTO = copys(sourceDTO, targetDTO);
		return targetDTO;
	}
	
	/**
	 * 补全参数
	 * @author zhang.hw
	 * @date 2019年7月30日
	 * @param sourceDTO
	 * @param targetDTO
	 * @return
	 */
	private DiCompDTO[] copys(DiCompDTO[] sourceDTO, DiCompDTO[] targetDTO) {
		for (DiCompDTO target : targetDTO) {
			for (DiCompDTO source : sourceDTO) {
				if (target.getMi_hpdidict_code().equals(source.getMi_hpdidict_code())) {
					// DTO之间赋值
					target = ToolUtils.copy(source, target);
					break;
				}
			}
		}
		return targetDTO;
	}

	/**
	 * 滞留为空数据
	 * @author zhang.hw
	 * @date 2019年7月30日
	 * @param sourceDTO
	 * @param i
	 * @return
	 */
	private DiCompDTO[] getRetentionDTO(DiCompDTO[] sourceDTO, int lengths) {
		DiCompDTO[] retentionDTO = new DiCompDTO[lengths];
		int i = 0;
		for (DiCompDTO diCompDTO:sourceDTO){
			if (diCompDTO.getMi_hpdidict_code() == null) {
				retentionDTO[i] = diCompDTO;
				i++;
			}
		}
		return retentionDTO;
	}

	/**
	 * 获取医保编码
	 * @author zhang.hw
	 * @date 2019年7月30日
	 * @param sourceDTO
	 * @return
	 */
	private String[] getCodes(DiCompDTO[] sourceDTO) {
		int valuenum = 0;
		List<DiCompDTO> list = new ArrayList<DiCompDTO>();
		for(int i = 0; i < sourceDTO.length; i++){
			if (sourceDTO[i]!=null && sourceDTO[i].getMi_hpdidict_code() != null) {
				valuenum++;
				list.add(sourceDTO[i]);
			}
		}
		if (valuenum==0) {
			return null;
		}
		String[] idStrings = new String[valuenum];
		for (int i = 0; i < list.size(); i++) {
			idStrings[i] = list.get(i).getMi_hpdidict_code();
		}
		return idStrings;
	}
}
