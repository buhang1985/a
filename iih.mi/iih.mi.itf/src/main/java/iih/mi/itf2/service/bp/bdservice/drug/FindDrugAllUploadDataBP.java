package iih.mi.itf2.service.bp.bdservice.drug;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import iih.bd.pp.hpsrvorca.d.HpStatusEnum;
import iih.mi.biz.dto.d.MiSrvTp;
import iih.mi.itf2.dto.MiContext;
import iih.mi.itf2.dto.MiResultOutParam;
import iih.mi.itf2.dto.drugmanualcomp.d.DrugManualCompDTO;
import iih.mi.itf2.dto.drugmanualcomp.d.LoadOrginalDataInParam;
import iih.mi.itf2.dto.drugmanualcomp.d.LoadOrginalDataOutParam;
import iih.mi.itf2.dto.midirdownload.d.MiDirEnum;
import iih.mi.itf2.facade.MiFacade;
import iih.mi.itf2.service.bp.bdservice.drug.qry.FindDrugCompSql;
import iih.mi.itf2.service.bp.bdservice.util.ToolUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

public class FindDrugAllUploadDataBP {
	public DrugManualCompDTO[] exec(String hpCode) throws BizException {
		String hpId = ToolUtils.GetHpId(hpCode);

		String wherePart = String.format("SRVORCA.EU_STATUS IN ('%s','%s')", HpStatusEnum.UPLOAD,
				HpStatusEnum.REVIEW);
		FindDrugCompSql sql = new FindDrugCompSql(hpId, wherePart);

		DAFacade daFacade = new DAFacade();
		DrugManualCompDTO[] result = ((ArrayList<DrugManualCompDTO>) daFacade.execQuery(sql.getQrySQLStr(),
				sql.getQryParameter(null), new BeanListHandler(DrugManualCompDTO.class))).toArray(new DrugManualCompDTO[0]);
		//补全数据
		result = completionData(result,hpId);
		return result;
	}
	/**
	 * 补全药品数据
	 * @author zhang.hw
	 * @date 2019年7月11日
	 * @param result
	 * @param hpCode
	 * @return
	 * @throws BizException 
	 */
	private DrugManualCompDTO[] completionData(DrugManualCompDTO[] sourceDTO, String hpCode) throws BizException {
		MiContext miContext = new MiContext();
		miContext.setIdHp(hpCode);
		MiFacade miFacade = new MiFacade(miContext);
		String[] strId = getCodes(sourceDTO);
		if (strId==null) {
			return sourceDTO;
		}
		DrugManualCompDTO[] retentionDTO = null;
		if (strId.length<sourceDTO.length) {
			//滞留为空数据
			retentionDTO = getRetentionDTO(sourceDTO,sourceDTO.length-strId.length);
		}
		LoadOrginalDataInParam inParam = new LoadOrginalDataInParam();
		inParam.setDirtype(MiDirEnum.MIDIRDRUG);
		inParam.setId_hp(hpCode);
		FArrayList list = new FArrayList();
		Collections.addAll(list,strId);
		inParam.setCodes(list);
		MiResultOutParam<LoadOrginalDataOutParam> outParam = miFacade.selectOrginalData(inParam);
		if (!outParam.getFg_deal().booleanValue()||!(outParam.getFg_HpSuccess()!=null&&outParam.getFg_HpSuccess().booleanValue())) {
			new BizException(outParam.getErrorMsg());
		}
		LoadOrginalDataOutParam orginalDataOutParam = outParam.getData();
		if (!MiDirEnum.MIDIRDRUG.equals(orginalDataOutParam.getDirtype())) {
			new BizException("查询已对照原始目录信息出错，请联系工程师！出错信息——his目录类型："+inParam.getDirtype()+"；客开返回目录类型："+orginalDataOutParam.getDirtype());
		}
		DrugManualCompDTO[] targetDTO = ToolUtils.ToList(orginalDataOutParam.getDetail()).toArray(new DrugManualCompDTO[orginalDataOutParam.getDetail().size()]);
		targetDTO = copys(sourceDTO, targetDTO);
		
		return targetDTO;
	}
	
	
	/**
	 * 数组赋值
	 * 
	 * @author zhang.hw
	 * @date 2019年5月24日
	 * @param sourceDTO
	 * @param targetDTO
	 */
	private DrugManualCompDTO[] copys(DrugManualCompDTO[] sourceDTO, DrugManualCompDTO[] targetDTO) {
		for (DrugManualCompDTO target : targetDTO) {
			for (DrugManualCompDTO source : sourceDTO) {
				if (target.getMi_code().equals(source.getMi_code())) {
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
	 * @date 2019年7月18日
	 * @param sourceDTO
	 * @param lengths
	 * @return
	 */
	private DrugManualCompDTO[] getRetentionDTO(DrugManualCompDTO[] sourceDTO,int lengths){
		DrugManualCompDTO[] retentionDTO = new DrugManualCompDTO[lengths];
		int i = 0;
		for (DrugManualCompDTO drugCompDTO:sourceDTO){
			if (drugCompDTO.getMi_code() == null) {
				retentionDTO[i] = drugCompDTO;
				i++;
			}
		}
		return retentionDTO;
	}
	
	/**
	 * 获取code字段
	 * @author zhang.hw
	 * @date 2019年5月24日
	 * @param drugCompDTOs
	 * @return
	 */
	private String[] getCodes(DrugManualCompDTO[] drugCompDTOs) {
		int valuenum = 0;
		List<DrugManualCompDTO> list = new ArrayList<DrugManualCompDTO>();
		for(int i = 0; i < drugCompDTOs.length; i++){
			if (drugCompDTOs[i]!=null && drugCompDTOs[i].getMi_code() != null) {
				valuenum++;
				list.add(drugCompDTOs[i]);
			}
		}
		if (valuenum==0) {
			return null;
		}
		String[] idStrings = new String[valuenum];
		for (int i = 0; i < list.size(); i++) {
			idStrings[i] = list.get(i).getMi_code();
		}
		return idStrings;
	}
	
}
