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
import iih.mi.itf2.service.bp.bdservice.SetOwnExpenseBP;
import iih.mi.itf2.service.bp.bdservice.di.CompInsurDiDataBP;
import iih.mi.itf2.service.bp.bdservice.di.FindDiCompDataListBP;
import iih.mi.itf2.service.bp.bdservice.di.FindDiCompedDataListBP;
import iih.mi.itf2.service.bp.bdservice.drug.CompInsurDrugDataBp;
import iih.mi.itf2.service.bp.bdservice.drug.FindDrugAllUploadDataBP;
import iih.mi.itf2.service.bp.bdservice.drug.FindDrugCompBp;
import iih.mi.itf2.service.bp.bdservice.drug.ReplaceDataBP;
import iih.mi.itf2.service.bp.bdservice.mi.AutoCompMiDirBP;
import iih.mi.itf2.service.bp.bdservice.mi.MiDelDirContrastBP;
import iih.mi.itf2.service.bp.bdservice.mi.MiSaveDirContrastBP;
import iih.mi.itf2.service.bp.bdservice.mi.RefreshCompBP;
import iih.mi.itf2.service.bp.bdservice.mi.SaveMiDirBP;
import iih.mi.itf2.service.bp.bdservice.treat.CompInsurTreatAndFwssDataBp;
import iih.mi.itf2.service.bp.bdservice.treat.FindAllTreatAndFwssCompBP;
import iih.mi.itf2.service.bp.bdservice.treat.FindTreatAndFwssCompBP;
import iih.mi.itf2.service.bp.bdservice.treat.ReplaceTreatDataBP;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 医保基础数据相关服务
 * @author ly 2019/05/29
 *
 */
@Service(serviceInterfaces = { IMiBdService.class }, binding = Binding.JSONRPC)
public class MiBdServiceImpl implements IMiBdService{
	
	/*******************************************************医保目录相关服务*******************************************/
	
	/**
	 * 医保目录保存
	 * @param miContext
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public MiDirSaveOutParam saveMiDir(MiContext miContext, MiDirSaveInParam param) throws BizException{
		SaveMiDirBP bp = new SaveMiDirBP();
		return bp.exec(miContext, param);
	}

	/**
	 * 医保目录自动对照
	 * @author zhang.hw
	 * @date 2019年6月2日
	 * @param miContext
	 * @param param
	 * @return
	 * @throws BizException
	 */
	@Override
	public MiResultOutParam<MiDirAutoCompOutParam> autoCompMiDir(MiContext miContext, MiDirAutoCompInParam param)
			throws BizException {
		AutoCompMiDirBP bp = new AutoCompMiDirBP();
		return bp.exec(miContext, param);
	}

	/**
	 * 医保目录刷新对照
	 * @author zhang.hw
	 * @date 2019年6月2日
	 * @param miContext
	 * @param param
	 * @return
	 * @throws BizException
	 */
	@Override
	public MiResultOutParam<MiDirRefreshCompOutParam> refreshCompMiDir(MiContext miContext,
			MiDirRefreshCompInParam param) throws BizException {
		RefreshCompBP bp = new RefreshCompBP();
		return bp.exec(miContext, param);
	}
	
	/**
	 * 目录保存对照
	 * @author zhang.hw
	 * @date 2019年7月15日
	 * @param inparam
	 * @return
	 * @throws BizException
	 */
	@Override
	public MiResultOutParam<MiSaveDirContrastOutParam> miSaveDirContrast(MiContext miContext, MiSaveDirContrastInParam inparam)
			throws BizException {
		MiSaveDirContrastBP bp = new MiSaveDirContrastBP();
		return bp.exec(miContext, inparam);
	}

	/**
	 * 目录删除对照
	 * @author zhang.hw
	 * @date 2019年7月15日
	 * @param miContext
	 * @param param
	 * @return
	 * @throws BizException
	 */
	@Override
	public MiResultOutParam<MiDelDirContrastOutParam> miDelDirContrast(MiContext miContext,
			MiDelDirContrastInParam param) throws BizException {
		MiDelDirContrastBP bp = new MiDelDirContrastBP();
		return bp.exec(miContext, param);
	}

	/**
	 * 设置自费
	 * @author zhang.hw
	 * @date 2019年7月15日
	 * @param drugManualCompDtos
	 * @return
	 * @throws BizException
	 */
	@Override
	public SetOwnExpenseOutParam setOwnExpense(SetOwnExpenseInParam inParam) throws BizException {
		SetOwnExpenseBP bp = new SetOwnExpenseBP();
		return bp.exec(inParam);
	}

	/***********************************************************药品相关服务**********************************************************/
	
	/**
	 * 查询药品对照信息(新)
	 * 
	 * @param qryRootNodeDto
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	@Override
	public PagingRtnData<DrugManualCompDTO> FindDrugCompDataList(QryRootNodeDTO qryRootNodeDto, String hpId, PaginationInfo pg)
			throws BizException {
		FindDrugCompBp bpb = new FindDrugCompBp();
		return bpb.exec(qryRootNodeDto, hpId, pg);
	}

	/**
	 * 补全医保药品信息(新)</br>
	 * 选择医保药品参照后进行补全
	 * 
	 * @param drugCompDTOs
	 * @return
	 * @throws BizException
	 */
	@Override
	public DrugManualCompDTO[] CompInsurDrugDataNew(DrugManualCompDTO[] drugCompDTOs) throws BizException {
		CompInsurDrugDataBp bp = new CompInsurDrugDataBp();
		bp.exec(drugCompDTOs);
		return drugCompDTOs;
	}

	/**
	 * 查询已上传的药品数据
	 * @author zhang.hw
	 * @date 2019年7月11日
	 * @param hpid
	 * @return
	 * @throws BizException
	 */
	@Override
	public DrugManualCompDTO[] FindDrugAllUploadData(String hpid) throws BizException {
		FindDrugAllUploadDataBP bp = new FindDrugAllUploadDataBP();
		return bp.exec(hpid);
	}

	/**
	 * 更新目录审批状态
	 * @author zhang.hw
	 * @date 2019年7月12日
	 * @param drugManualCompList
	 * @return
	 * @throws BizException
	 */
	@Override
	public DrugManualCompDTO[] replaceData(DrugManualCompDTO[] drugManualCompList) throws BizException {
		ReplaceDataBP bp = new ReplaceDataBP();
		return bp.exec(drugManualCompList);
	}

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
	public PagingRtnData<TreatAndFwssCompDTO> FindTreatAndFwssCompDataList(QryRootNodeDTO qryRootNodeDto,String hpId,PaginationInfo pg) throws BizException{
		FindTreatAndFwssCompBP bp = new FindTreatAndFwssCompBP();
		return bp.exec(qryRootNodeDto, hpId, pg);
	}

	/**
	 * 补全医保诊疗和服务设施信息(新)
	 * @author zhang.hw
	 * @date 2019年7月18日
	 * @param treatAndFwssComp
	 * @return
	 * @throws BizException
	 */
	@Override
	public TreatAndFwssCompDTO[] CompInsurTreatAndFwssData(TreatAndFwssCompDTO[] treatAndFwssComp) throws BizException {
		CompInsurTreatAndFwssDataBp bp = new CompInsurTreatAndFwssDataBp();
		return bp.exec(treatAndFwssComp);
	}

	/**
	 * 更新目录审批状态
	 * @author zhang.hw
	 * @date 2019年7月19日
	 * @param treatAndFwssCompDTOs
	 * @return
	 * @throws BizException
	 */
	@Override
	public TreatAndFwssCompDTO[] replaceTreatData(TreatAndFwssCompDTO[] treatAndFwssCompDTOs) throws BizException {
		ReplaceTreatDataBP bp = new ReplaceTreatDataBP();
		return bp.exec(treatAndFwssCompDTOs);
	}

	/**
	 * 查询已上传的诊疗、服务设施、材料数据
	 * @author zhang.hw
	 * @date 2019年7月19日
	 * @param idHp
	 * @return
	 * @throws BizException
	 */
	@Override
	public TreatAndFwssCompDTO[] FindAllTreatComp(String hpcode) throws BizException {
		FindAllTreatAndFwssCompBP bp = new FindAllTreatAndFwssCompBP();
		return bp.exec(hpcode);
	}

	/***********************************************************病种(诊断)目录相关服务*************************************************/
	
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
	@Override
	public PagingRtnData<DiCompDTO> FindDiCompDataList(QryRootNodeDTO qryRootNodeDto, String hpId, PaginationInfo pg)
			throws BizException {
		FindDiCompDataListBP bp = new FindDiCompDataListBP();
		return bp.exec(qryRootNodeDto, hpId, pg);
	}

	/**
	 * 补全医保诊断信息
	 * @author zhang.hw
	 * @date 2019年7月30日
	 * @param diCompDTOs
	 * @return
	 * @throws BizException
	 */
	@Override
	public DiCompDTO[] CompInsurDiData(DiCompDTO[] diCompDTOs) throws BizException {
		CompInsurDiDataBP bp = new CompInsurDiDataBP();
		return bp.exec(diCompDTOs);
	}

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
	@Override
	public PagingRtnData<DiCompDTO> FindDiCompedDataList(QryRootNodeDTO qryRootNodeDto, String hpId, PaginationInfo pg)
			throws BizException {
		FindDiCompedDataListBP bp = new FindDiCompedDataListBP();
		return bp.exec(qryRootNodeDto, hpId, pg);
	}
	
}
