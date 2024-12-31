package iih.mi.itf2.service.bp.bdservice.treat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


import iih.mi.itf2.dto.MiContext;
import iih.mi.itf2.dto.MiResultOutParam;
import iih.mi.itf2.dto.drugmanualcomp.d.LoadOrginalDataInParam;
import iih.mi.itf2.dto.drugmanualcomp.d.LoadOrginalDataOutParam;
import iih.mi.itf2.dto.midirdownload.d.MiDirEnum;
import iih.mi.itf2.dto.treatandfwsscomp.d.TreatAndFwssCompDTO;
import iih.mi.itf2.facade.MiFacade;
import iih.mi.itf2.service.bp.bdservice.treat.sql.FindTreatAndFwssCompSql;
import iih.mi.itf2.service.bp.bdservice.util.ToolUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

public class FindTreatAndFwssCompBP {
	public PagingRtnData<TreatAndFwssCompDTO> exec(QryRootNodeDTO qryRootNodeDto,String hpId,PaginationInfo pg) throws BizException{
		String wherePart = ToolUtils.GetWherePart(qryRootNodeDto);
		FindTreatAndFwssCompSql sql = new FindTreatAndFwssCompSql(hpId, wherePart);
		PagingServiceImpl<TreatAndFwssCompDTO> pagingServiceImpl = new PagingServiceImpl<TreatAndFwssCompDTO>();
		PagingRtnData<TreatAndFwssCompDTO> pagingRtnData = pagingServiceImpl.findByPageInfo(new TreatAndFwssCompDTO(),pg,
				sql.getQrySQLStr(), "SRV_NAME,EU_HPSRVTP,SRV_CODE", sql.getQryParameter(null));
		//补全诊疗信息
		pagingRtnData = completionData(pagingRtnData, hpId);
		return pagingRtnData;
	}
	
	/**
	 * 补全诊疗信息
	 * @author zhang.hw
	 * @date 2019年5月27日
	 * @param pagingRtnData
	 * @param id_hp
	 * @return
	 */
	private PagingRtnData<TreatAndFwssCompDTO> completionData(PagingRtnData<TreatAndFwssCompDTO> pagingRtnData,String id_hp) throws BizException {
		
		TreatAndFwssCompDTO[] sourceDTO = (TreatAndFwssCompDTO[]) pagingRtnData.getPageData()
				.toArray(new TreatAndFwssCompDTO[pagingRtnData.getPageData().size()]);
		//区分诊疗、服务设施、材料
		List<TreatAndFwssCompDTO> listTreat = new ArrayList<TreatAndFwssCompDTO>();
		List<TreatAndFwssCompDTO> listFwss = new ArrayList<TreatAndFwssCompDTO>();
		List<TreatAndFwssCompDTO> listMaterial = new ArrayList<TreatAndFwssCompDTO>();
		for(int i=0;i<sourceDTO.length;i++){
			if (MiDirEnum.MIDIRSRV.equals(sourceDTO[i].getEu_hpsrvtp())) {
				listTreat.add(sourceDTO[i]);
			}else if (MiDirEnum.MIDIRFACILITY.equals(sourceDTO[i].getEu_hpsrvtp())) {
				listFwss.add(sourceDTO[i]);
			}else if (MiDirEnum.MIDIRMC.equals(sourceDTO[i].getEu_hpsrvtp())) {
				listMaterial.add(sourceDTO[i]);
			}
		}
		FArrayList fArrayList = new FArrayList(sourceDTO.length);
		if (listTreat!=null&&listTreat.size()>0) {
			TreatAndFwssCompDTO[] targetTreatDTO = getCustomData(listTreat.toArray(new TreatAndFwssCompDTO[listTreat.size()]),MiDirEnum.MIDIRSRV,id_hp);
			Collections.addAll(fArrayList, targetTreatDTO);
		}
		if (listFwss!=null&&listFwss.size()>0) {
			TreatAndFwssCompDTO[] targetFwssDTO = getCustomData(listFwss.toArray(new TreatAndFwssCompDTO[listFwss.size()]),MiDirEnum.MIDIRFACILITY,id_hp);
			Collections.addAll(fArrayList, targetFwssDTO);
		}
		if (listMaterial!=null&&listMaterial.size()>0) {
			TreatAndFwssCompDTO[] targetMCDTO = getCustomData(listMaterial.toArray(new TreatAndFwssCompDTO[listMaterial.size()]),MiDirEnum.MIDIRMC,id_hp);
			Collections.addAll(fArrayList, targetMCDTO);
		}
		pagingRtnData.setPageData(fArrayList);
		
		return pagingRtnData;
	}
	
	private TreatAndFwssCompDTO[] getCustomData(TreatAndFwssCompDTO[] sourceDTO, String midirsrv,String id_hp) throws BizException{
		MiContext miContext = new MiContext();
		miContext.setIdHp(id_hp);
		MiFacade miFacade = new MiFacade(miContext);
		String[] strId = getCodes(sourceDTO);
		if (strId==null) {
			return sourceDTO;
		}
		TreatAndFwssCompDTO[] retentionDTO = null;
		if (strId.length<sourceDTO.length) {
			//滞留为空数据
			retentionDTO = getRetentionDTO(sourceDTO,sourceDTO.length-strId.length);
		}
		LoadOrginalDataInParam inParam = new LoadOrginalDataInParam();
		inParam.setDirtype(midirsrv);
		inParam.setId_hp(id_hp);
		FArrayList list = new FArrayList();
		Collections.addAll(list,strId);
		inParam.setCodes(list);
		MiResultOutParam<LoadOrginalDataOutParam> outParam = miFacade.selectOrginalData(inParam);
		List<TreatAndFwssCompDTO> fArrayList = new ArrayList<TreatAndFwssCompDTO>();
		try{
			if (!outParam.getFg_deal().booleanValue()||!(outParam.getFg_HpSuccess()!=null&&outParam.getFg_HpSuccess().booleanValue())) {
				throw new BizException(outParam.getErrorMsg());
			}
		}catch(BizException exception){
			exception.printStackTrace();
		}finally {
			if (outParam.getFg_deal().booleanValue()||(outParam.getFg_HpSuccess()!=null&&outParam.getFg_HpSuccess().booleanValue())) {
				LoadOrginalDataOutParam orginalDataOutParam = outParam.getData();
				if (!midirsrv.equals(orginalDataOutParam.getDirtype())) {
					new BizException("查询已对照原始目录信息出错，请联系工程师！出错信息——his目录类型："+inParam.getDirtype()+"；客开返回目录类型："+orginalDataOutParam.getDirtype());
				}
				TreatAndFwssCompDTO[] targetDTO = ToolUtils.ToList(orginalDataOutParam.getDetail()).toArray(new TreatAndFwssCompDTO[orginalDataOutParam.getDetail().size()]);
				targetDTO = copys(sourceDTO, targetDTO);
				
				Collections.addAll(fArrayList, targetDTO);
				
			}else{
				Collections.addAll(fArrayList, sourceDTO);
			}
			if (retentionDTO!=null) {
				Collections.addAll(fArrayList, retentionDTO);
			}
			
		}
		return fArrayList.toArray(new TreatAndFwssCompDTO[fArrayList.size()]);
	}

	/**
	 * 数组赋值
	 * 
	 * @author zhang.hw
	 * @date 2019年5月24日
	 * @param sourceDTO
	 * @param targetDTO
	 */
	private TreatAndFwssCompDTO[] copys(TreatAndFwssCompDTO[] sourceDTO, TreatAndFwssCompDTO[] targetDTO) {
		for (TreatAndFwssCompDTO target : targetDTO) {
			for (TreatAndFwssCompDTO source : sourceDTO) {
				if (target==null||source==null) {
					continue;
				}
				if (target.getMi_code().equals(source.getMi_code())&&target.getEu_hpsrvtp().equals(source.getEu_hpsrvtp())) {
					// DTO之间赋值
					target = copy(source, target);
					break;
				}
			}
		}
		return targetDTO;
	}
	
	/**
	 * 给DTO补全值
	 * @author zhang.hw
	 * @date 2019年7月18日
	 * @param source
	 * @param target
	 * @return
	 */
	private TreatAndFwssCompDTO copy(TreatAndFwssCompDTO source,TreatAndFwssCompDTO target){
		target.setId_hp(source.getId_hp());
		target.setId_srv(source.getId_srv());
		target.setSrv_code(source.getSrv_code());
		target.setSrv_name(source.getSrv_name());
		target.setSrv_price(source.getSrv_price());
		target.setSrv_pycode(source.getSrv_pycode());
		target.setSrv_wbcode(source.getSrv_wbcode());
		target.setSrv_unit(source.getSrv_unit());
		target.setSrv_route(source.getSrv_route());
		target.setSrv_quan(source.getSrv_quan());
		target.setSrv_freq(source.getSrv_freq());
		target.setId_hpsrvorca(source.getId_hpsrvorca());
		target.setEu_hpsrvtp(source.getEu_hpsrvtp());
		target.setEu_status(source.getEu_status());
		if (target.getStatus() == DOStatus.UNCHANGED) {
			target.setStatus(DOStatus.UPDATED);
		}
		return target;
	}
	
	/**
	 * 滞留为空数据
	 * @author zhang.hw
	 * @date 2019年5月27日
	 * @param sourceDTO
	 * @param lengths
	 * @return
	 */
	private TreatAndFwssCompDTO[] getRetentionDTO(TreatAndFwssCompDTO[] sourceDTO,int lengths){
		TreatAndFwssCompDTO[] retentionDTO = new TreatAndFwssCompDTO[lengths];
		int i = 0;
		for (TreatAndFwssCompDTO treatCompDTO:sourceDTO){
			if (treatCompDTO.getMi_code() == null) {
				retentionDTO[i] = treatCompDTO;
				i++;
			}
		}
		return retentionDTO;
	}
	
	/**
	 * 获取code字段
	 * @author zhang.hw
	 * @date 2019年5月24日
	 * @param treatCompDTOs
	 * @return
	 */
	private String[] getCodes(TreatAndFwssCompDTO[] treatCompDTOs) {
		int valuenum = 0;
		List<TreatAndFwssCompDTO> list = new ArrayList<TreatAndFwssCompDTO>();
		for(int i = 0; i < treatCompDTOs.length; i++){
			if (treatCompDTOs[i]!=null && treatCompDTOs[i].getMi_code() != null) {
				valuenum++;
				list.add(treatCompDTOs[i]);
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
