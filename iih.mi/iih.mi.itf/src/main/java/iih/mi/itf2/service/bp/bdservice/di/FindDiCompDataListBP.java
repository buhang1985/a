package iih.mi.itf2.service.bp.bdservice.di;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import iih.bd.pp.hp.d.HPDO;
import iih.bd.pp.hp.i.IHpMDORService;
import iih.mi.itf2.dto.MiContext;
import iih.mi.itf2.dto.MiResultOutParam;
import iih.mi.itf2.dto.dicompdto.d.DiCompDTO;
import iih.mi.itf2.dto.drugmanualcomp.d.LoadOrginalDataInParam;
import iih.mi.itf2.dto.drugmanualcomp.d.LoadOrginalDataOutParam;
import iih.mi.itf2.dto.midirdownload.d.MiDirEnum;
import iih.mi.itf2.facade.MiFacade;
import iih.mi.itf2.service.bp.bdservice.di.qry.FindDiCompDataListSql;
import iih.mi.itf2.service.bp.bdservice.util.ToolUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

public class FindDiCompDataListBP {
	public PagingRtnData<DiCompDTO> exec(QryRootNodeDTO qryRootNodeDto, String hpId, PaginationInfo pg) throws BizException{
		String wherePart = ToolUtils.GetWherePart(qryRootNodeDto);
		String idRef = getIdRef(hpId);
		FindDiCompDataListSql sql = new FindDiCompDataListSql(wherePart, hpId, idRef);
		PagingServiceImpl<DiCompDTO> pagingServiceImpl = new PagingServiceImpl<DiCompDTO>();
		PagingRtnData<DiCompDTO> result = pagingServiceImpl.findByPageInfo(new DiCompDTO(), pg,
				sql.getQrySQLStr(), "DI_DEF.CODE", sql.getQryParameter(null));
		result = completionData(result,idRef!=null?idRef:hpId);
		return result;
	}
	
	/**
	 * 补全医保信息
	 * @author zhang.hw
	 * @date 2019年7月30日
	 * @param result
	 * @param string
	 * @return
	 */
	private PagingRtnData<DiCompDTO> completionData(PagingRtnData<DiCompDTO> result, String hpId) throws BizException {
		MiContext miContext = new MiContext();
		miContext.setIdHp(hpId);
		MiFacade miFacade = new MiFacade(miContext);
		DiCompDTO[] sourceDTO = (DiCompDTO[])result.getPageData().toArray(new DiCompDTO[result.getPageData().size()]);
		String[] strId = getCodes(sourceDTO);
		if (strId==null) {
			return result;
		}
		DiCompDTO[] retentionDTO = null;
		if (strId.length<sourceDTO.length) {
			//滞留为空数据
			retentionDTO = getRetentionDTO(sourceDTO,sourceDTO.length-strId.length);
		}
		LoadOrginalDataInParam inParam = new LoadOrginalDataInParam();
		inParam.setDirtype(MiDirEnum.MIDIRDI);
		inParam.setId_hp(hpId);
		FArrayList list = new FArrayList();
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
				if (!MiDirEnum.MIDIRDI.equals(orginalDataOutParam.getDirtype())) {
					new BizException("查询已对照原始目录信息出错，请联系工程师！出错信息——his目录类型："+inParam.getDirtype()+"；客开返回目录类型："+orginalDataOutParam.getDirtype());
				}
				DiCompDTO[] targetDTO = ToolUtils.ToList(orginalDataOutParam.getDetail()).toArray(new DiCompDTO[orginalDataOutParam.getDetail().size()]);
				targetDTO = copys(sourceDTO, targetDTO);
				
				Collections.addAll(fArrayList, targetDTO);
			}else{
				Collections.addAll(fArrayList, sourceDTO);
			}
			
			if (retentionDTO!=null) {
				Collections.addAll(fArrayList, retentionDTO);
			}
			result.setPageData(fArrayList);
		}
		
		return result;
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

	/**
	 * 获取idRef
	 * @author zhang.hw
	 * @date 2019年7月30日
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
