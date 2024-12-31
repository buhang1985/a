package iih.mi.itf2.service.bp.bdservice.drug;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;


import iih.bd.pp.hp.d.HPDO;
import iih.bd.pp.hp.i.IHpMDORService;
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
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 医保药品目录查询（新）
 * Title: FindDrugCompNewBp.java
 * @author zhang.hw
 * @date 2019年5月27日  
 * @version 1.0
 */
public class FindDrugCompBp {

	/**
	 * @param qryRootNodeDto
	 * @param hpId
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<DrugManualCompDTO> exec(QryRootNodeDTO qryRootNodeDto, String hpId, PaginationInfo pg)
			throws BizException {
		String wherePart = ToolUtils.GetWherePart(qryRootNodeDto);
		String idRef = getIdRef(hpId);
		FindDrugCompSql sql = new FindDrugCompSql(idRef, hpId, wherePart);
		PagingServiceImpl<DrugManualCompDTO> pagingServiceImpl = new PagingServiceImpl<DrugManualCompDTO>();
		PagingRtnData<DrugManualCompDTO> pagingRtnData = pagingServiceImpl.findByPageInfo(new DrugManualCompDTO(), pg,
				sql.getQrySQLStr(), "SRV.NAME,UDIDOC_DOSAGE.NAME DESC", sql.getQryParameter(null));

		// 补全医保药品参数
		pagingRtnData = completionData(pagingRtnData, hpId);

		return pagingRtnData;
	}

	/**
	 * 补全医保药品参数
	 * 
	 * @author zhang.hw
	 * @date 2019年5月23日
	 * @param pagingRtnData
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private PagingRtnData<DrugManualCompDTO> completionData(PagingRtnData<DrugManualCompDTO> pagingRtnData, String hpId)
			throws BizException {
		MiContext miContext = new MiContext();
		miContext.setIdHp(hpId);
		MiFacade miFacade = new MiFacade(miContext);
		DrugManualCompDTO[] sourceDTO = (DrugManualCompDTO[]) pagingRtnData.getPageData()
				.toArray(new DrugManualCompDTO[pagingRtnData.getPageData().size()]);
		String[] strId = getCodes(sourceDTO);
		if (strId==null) {
			return pagingRtnData;
		}
		DrugManualCompDTO[] retentionDTO = null;
		if (strId.length<sourceDTO.length) {
			//滞留为空数据
			retentionDTO = getRetentionDTO(sourceDTO,sourceDTO.length-strId.length);
		}
		LoadOrginalDataInParam inParam = new LoadOrginalDataInParam();
		inParam.setDirtype(MiDirEnum.MIDIRDRUG);
		inParam.setId_hp(hpId);
		FArrayList list = new FArrayList(strId.length);
		Collections.addAll(list,strId);
		inParam.setCodes(list);
		MiResultOutParam<LoadOrginalDataOutParam> outParam = miFacade.selectOrginalData(inParam);
		try{
			if (!outParam.getFg_deal().booleanValue()||!(outParam.getFg_HpSuccess()!=null&&outParam.getFg_HpSuccess().booleanValue())) {
				throw new BizException(outParam.getErrorMsg());
			}
		}catch(BizException exception){
			exception.printStackTrace();
		}finally {
			FArrayList fArrayList = new FArrayList(sourceDTO.length);
			if (outParam.getFg_deal().booleanValue()||(outParam.getFg_HpSuccess()!=null&&outParam.getFg_HpSuccess().booleanValue())) {
				LoadOrginalDataOutParam orginalDataOutParam = outParam.getData();
				if (!MiDirEnum.MIDIRDRUG.equals(orginalDataOutParam.getDirtype())) {
					new BizException("查询已对照原始目录信息出错，请联系工程师！出错信息——his目录类型："+inParam.getDirtype()+"；客开返回目录类型："+orginalDataOutParam.getDirtype());
				}
				DrugManualCompDTO[] targetDTO = ToolUtils.ToList(orginalDataOutParam.getDetail()).toArray(new DrugManualCompDTO[orginalDataOutParam.getDetail().size()]);
				targetDTO = copys(sourceDTO, targetDTO);
				
				Collections.addAll(fArrayList, targetDTO);
			}else{
				Collections.addAll(fArrayList,sourceDTO);
			}
			
			if (retentionDTO!=null) {
				Collections.addAll(fArrayList, retentionDTO);
			}
			pagingRtnData.setPageData(fArrayList);
		}
		return pagingRtnData;
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

	/**
	 * @param hpId
	 * @return
	 * @throws BizException
	 */
	private String getIdRef(String hpId) throws BizException {
		IHpMDORService iHpMDORService = ServiceFinder.find(IHpMDORService.class);
		HPDO hpdo = iHpMDORService.findById(hpId);
		return hpdo.getId_refhp();
	}
}
