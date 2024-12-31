package iih.mi.itf2.service;

import iih.mi.itf2.dto.MiContext;
import iih.mi.itf2.dto.MiResultOutParam;
import iih.mi.itf2.dto.dicompdto.d.DiCompDTO;
import iih.mi.itf2.dto.drugmanualcomp.d.DrugManualCompDTO;
import iih.mi.itf2.dto.mideldircontrast.d.MiDelDirContrastInParam;
import iih.mi.itf2.dto.mideldircontrast.d.MiDelDirContrastOutParam;
import iih.mi.itf2.dto.midirautocomp.d.MiDirAutoCompInParam;
import iih.mi.itf2.dto.midirautocomp.d.MiDirAutoCompOutParam;
import iih.mi.itf2.dto.midirsave.d.MiDirSaveInParam;
import iih.mi.itf2.dto.midirsave.d.MiDirSaveOutParam;
import iih.mi.itf2.dto.misavedircontrast.d.MiSaveDirContrastInParam;
import iih.mi.itf2.dto.misavedircontrast.d.MiSaveDirContrastOutParam;
import iih.mi.itf2.dto.refreshcomp.d.MiDirRefreshCompInParam;
import iih.mi.itf2.dto.refreshcomp.d.MiDirRefreshCompOutParam;
import iih.mi.itf2.dto.setownexpense.d.SetOwnExpenseInParam;
import iih.mi.itf2.dto.setownexpense.d.SetOwnExpenseOutParam;
import iih.mi.itf2.dto.treatandfwsscomp.d.TreatAndFwssCompDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 医保基础数据相关服务
 * @author ly 2019/05/29
 *
 */
public interface IMiBdService {

	/*******************************************************医保目录相关服务*******************************************/
	
	/**
	 * 医保目录保存
	 * @param miContext
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public abstract MiDirSaveOutParam saveMiDir(MiContext miContext, MiDirSaveInParam param) throws BizException;
	
	/**
	 * 医保目录自动对照
	 * @author zhang.hw
	 * @date 2019年6月2日
	 * @param miContext
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public abstract MiResultOutParam<MiDirAutoCompOutParam> autoCompMiDir(MiContext miContext, MiDirAutoCompInParam param) throws BizException;
	
	/**
	 * 医保目录刷新对照
	 * @author zhang.hw
	 * @date 2019年6月2日
	 * @param miContext
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public abstract MiResultOutParam<MiDirRefreshCompOutParam> refreshCompMiDir(MiContext miContext, MiDirRefreshCompInParam param) throws BizException;
	
	/**
	 * 目录保存对照
	 * @author zhang.hw
	 * @date 2019年7月15日
	 * @param inparam
	 * @return
	 * @throws BizException
	 */
	public abstract MiResultOutParam<MiSaveDirContrastOutParam> miSaveDirContrast(MiContext miContext, MiSaveDirContrastInParam inparam) throws BizException;
	
	/**
	 * 目录删除对照
	 * @author zhang.hw
	 * @date 2019年7月15日
	 * @param miContext
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public abstract MiResultOutParam<MiDelDirContrastOutParam> miDelDirContrast(MiContext miContext, MiDelDirContrastInParam param) throws BizException;
	
	/**
	 * 设置自费
	 * @author zhang.hw
	 * @date 2019年7月15日
	 * @param drugManualCompDtos
	 * @return
	 * @throws BizException
	 */
	public abstract SetOwnExpenseOutParam setOwnExpense(SetOwnExpenseInParam inParam) throws BizException;
	
	/***********************************************************药品相关服务**********************************************************/
	
	/**
	 * 查询药品对照信息(新)
	 * 
	 * @param qryRootNodeDto
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	public abstract PagingRtnData<DrugManualCompDTO> FindDrugCompDataList(QryRootNodeDTO qryRootNodeDto, String hpId,
			PaginationInfo pg) throws BizException;
	
	/**
	 * 补全医保药品信息(新)</br>
	 * 选择医保药品参照后进行补全
	 * 
	 * @param drugCompDTOs
	 * @return
	 * @throws BizException
	 */
	public abstract DrugManualCompDTO[] CompInsurDrugDataNew(DrugManualCompDTO[] drugCompDTOs) throws BizException;
	
	/**
	 * 查询已上传的药品数据
	 * @author zhang.hw
	 * @date 2019年7月11日
	 * @param hpid
	 * @return
	 * @throws BizException
	 */
	public abstract DrugManualCompDTO[] FindDrugAllUploadData(String hpid) throws BizException;
	
	/**
	 * 更新目录审批状态
	 * @author zhang.hw
	 * @date 2019年7月12日
	 * @param drugManualCompList
	 * @return
	 * @throws BizException
	 */
	public abstract DrugManualCompDTO[] replaceData(DrugManualCompDTO[] drugManualCompList) throws BizException;
	
	/***********************************************************诊疗相关服务**********************************************************/
	
	/**
	 * 查询诊疗和服务设施对照信息（新）
	 * @author zhang.hw
	 * @date 2019年7月18日
	 * @param qryRootNodeDto
	 * @param hpId
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	public abstract PagingRtnData<TreatAndFwssCompDTO> FindTreatAndFwssCompDataList(QryRootNodeDTO qryRootNodeDto,String hpId,PaginationInfo pg) throws BizException;
	
	/**
	 * 补全医保诊疗和服务设施信息(新)
	 * @author zhang.hw
	 * @date 2019年7月18日
	 * @param treatAndFwssComp
	 * @return
	 * @throws BizException
	 */
	public abstract TreatAndFwssCompDTO[] CompInsurTreatAndFwssData(TreatAndFwssCompDTO[] treatAndFwssComp) throws BizException;
	
	/**
	 * 更新目录审批状态
	 * @author zhang.hw
	 * @date 2019年7月19日
	 * @param treatAndFwssCompDTOs
	 * @return
	 * @throws BizException
	 */
	public abstract TreatAndFwssCompDTO[] replaceTreatData(TreatAndFwssCompDTO[] treatAndFwssCompDTOs) throws BizException;
	
	/**
	 * 查询已上传的诊疗、服务设施、材料数据
	 * @author zhang.hw
	 * @date 2019年7月19日
	 * @param idHp
	 * @return
	 * @throws BizException
	 */
	public abstract TreatAndFwssCompDTO[] FindAllTreatComp(String hpcode) throws BizException;
	
	/************************************************************病种(诊断)目录相关服务*************************************************/
	
	/**
	 * 查询 病种(诊断)对照信息（新）
	 * @author zhang.hw
	 * @date 2019年7月30日
	 * @param qryRootNodeDto
	 * @param hpId
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	public abstract PagingRtnData<DiCompDTO> FindDiCompDataList(QryRootNodeDTO qryRootNodeDto,String hpId,PaginationInfo pg) throws BizException;
	
	/**
	 * 补全医保诊断信息
	 * @author zhang.hw
	 * @date 2019年7月30日
	 * @param diCompDTOs
	 * @return
	 * @throws BizException
	 */
	public abstract DiCompDTO[] CompInsurDiData(DiCompDTO[] diCompDTOs) throws BizException;
	
	/**
	 * 查询 病种(诊断)已对照信息（新）
	 * @author zhang.hw
	 * @date 2019年7月31日
	 * @param qryRootNodeDto
	 * @param hpId
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	public abstract PagingRtnData<DiCompDTO> FindDiCompedDataList(QryRootNodeDTO qryRootNodeDto,String hpId,PaginationInfo pg) throws BizException;
	
}
