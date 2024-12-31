package iih.mi.itf.facade;

import java.util.List;

import iih.bd.pp.anhuisrvorca.d.DrugCompDTO;
import iih.bd.pp.anhuisrvorca.d.TreatCompDTO;
import iih.bd.pp.hpsrvorca.d.HPSrvorcaDO;
import iih.bd.pp.hpsrvorcadto.d.HpsrvorcaDTO;
import iih.mi.itf.bizgrpitf.HpInnerService;
import iih.mi.itf.bizgrpitf.param.ResultOutParamDTO;
import iih.mi.itf.context.InsureContext;
import xap.mw.core.data.FArrayList;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 医保服务门面
 * 
 * @author hao_wu
 *
 */
public class InsureServiceFacade extends InsureFacade {

	public InsureServiceFacade(InsureContext insureContext) {
		super(insureContext);
	}

	/**
	 * 保存医保目录
	 * 
	 * @param miSrvTp
	 *            医保项目类型</br>
	 *            枚举：iih.mi.biz.dto.d.MiSrvTp
	 * @param fileKey
	 *            文件Key
	 * @return
	 */
	public ResultOutParamDTO<String> saveMedInsurDir(String miSrvTp, String fileKey) {
		HpInnerService hpInnerService = this.insureInstanceFactory.createHpInnerServiceInstance();
		ResultOutParamDTO<String> result = hpInnerService.saveMedInsurDir(miSrvTp, fileKey);
		return result;
	}

	/**
	 * 刷新医保目录对照</br>
	 * 将不在对照表中的数据生成到对照表中
	 * 
	 * @param insureContext
	 *            医保上下文
	 * @param miSrvTp
	 *            医保项目类型</br>
	 *            枚举：iih.mi.biz.dto.d.MiSrvTp
	 * @return
	 */
	public ResultOutParamDTO<String> refreshMiDirComp(String miSrvTp) {
		HpInnerService hpInnerService = this.insureInstanceFactory.createHpInnerServiceInstance();
		ResultOutParamDTO<String> result = hpInnerService.refreshMiDirComp(miSrvTp);
		return result;
	}

	/**
	 * 医保目录自动对照
	 * 
	 * @param insureContext
	 *            医保上下文
	 * @param miSrvTp
	 *            医保项目类型</br>
	 *            枚举：iih.mi.biz.dto.d.MiSrvTp
	 * @return
	 */
	public ResultOutParamDTO<String> miDirAutoComp(String miSrvTp) {
		HpInnerService hpInnerService = this.insureInstanceFactory.createHpInnerServiceInstance();
		ResultOutParamDTO<String> result = hpInnerService.miDirAutoComp(miSrvTp);
		return result;
	}

	/**
	 * 保存药品对照
	 * 
	 * @param insureContext
	 *            医保上下文
	 * @param drugCompDTOs
	 *            药品对照DTO集合
	 * @return
	 */
	public ResultOutParamDTO<List<DrugCompDTO>> saveDrugComp(List<DrugCompDTO> drugCompDTOs) {
		HpInnerService hpInnerService = this.insureInstanceFactory.createHpInnerServiceInstance();
		ResultOutParamDTO<List<DrugCompDTO>> result = hpInnerService.saveDrugComp(drugCompDTOs);
		return result;
	}
	
	/**
	 * 保存药品诊疗对照
	 * 
	 * @param insureContext
	 *            医保上下文
	 * @param drugCompDTOs
	 *            药品对照DTO集合
	 * @return
	 */
	public ResultOutParamDTO<List<DrugCompDTO>> saveDrugTreatComp(List<DrugCompDTO> drugCompDTOs) {
		HpInnerService hpInnerService = this.insureInstanceFactory.createHpInnerServiceInstance();
		ResultOutParamDTO<List<DrugCompDTO>> result = hpInnerService.saveDrugTreatComp(drugCompDTOs);
		return result;
	}

	/**
	 * 保存诊疗对照
	 * 
	 * @param insureContext
	 *            医保上下文
	 * @param treatCompDTOs
	 *            诊疗对照DTO集合
	 * @return
	 */
	public ResultOutParamDTO<List<TreatCompDTO>> saveTreatComp(List<TreatCompDTO> treatCompDTOs) {
		HpInnerService hpInnerService = this.insureInstanceFactory.createHpInnerServiceInstance();
		ResultOutParamDTO<List<TreatCompDTO>> result = hpInnerService.saveTreatComp(treatCompDTOs);
		return result;
	}

	/**
	 * 删除药品对照
	 * 
	 * @param insureContext
	 *            医保上下文
	 * @param drugCompDTOs
	 *            药品对照DTO集合
	 * @return
	 */
	public ResultOutParamDTO<List<DrugCompDTO>> deleteDrugComp(List<DrugCompDTO> drugCompDTOs) {
		HpInnerService hpInnerService = this.insureInstanceFactory.createHpInnerServiceInstance();
		ResultOutParamDTO<List<DrugCompDTO>> result = hpInnerService.deleteDrugComp(drugCompDTOs);
		return result;
	}

	/**
	 * 删除诊疗对照
	 * 
	 * @param insureContext
	 *            医保上下文
	 * @param treatCompDTOs
	 *            诊疗对照DTO集合
	 * @return
	 */
	public ResultOutParamDTO<List<TreatCompDTO>> deleteTreatComp(List<TreatCompDTO> treatCompDTOs) {
		HpInnerService hpInnerService = this.insureInstanceFactory.createHpInnerServiceInstance();
		ResultOutParamDTO<List<TreatCompDTO>> result = hpInnerService.deleteTreatComp(treatCompDTOs);
		return result;
	}

	/**
	 * @param insureContext
	 *            医保上下文
	 * @param qryRootNodeDto
	 *            查询方案
	 * @param orderStr
	 *            排序字段
	 * @param pg
	 *            分页信息
	 * @return
	 */
	public ResultOutParamDTO<PagingRtnData<HPSrvorcaDO>> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDto,
			String orderStr, PaginationInfo pg) {
		HpInnerService hpInnerService = this.insureInstanceFactory.createHpInnerServiceInstance();
		ResultOutParamDTO<PagingRtnData<HPSrvorcaDO>> result = hpInnerService.findByQCondAndPageInfo(super.getId_hp(),
				qryRootNodeDto, orderStr, pg);
		return result;
	}

	/**
	 * @param insureContext
	 *            医保上下文
	 * @param qryRootNodeDto
	 *            查询方案
	 * @param orderStr
	 *            排序字段
	 * @param pg
	 *            分页信息
	 * @param miSrvTp
	 *            服务类型
	 * @return
	 */
	public ResultOutParamDTO<FArrayList> exportHpDirList(QryRootNodeDTO qryRootNodeDto, String orderStr,
			PaginationInfo pg, String miSrvTp) {
		HpInnerService hpInnerService = this.insureInstanceFactory.createHpInnerServiceInstance();
		ResultOutParamDTO<FArrayList> result = hpInnerService.exportHpDirList(super.getId_hp(), qryRootNodeDto,
				orderStr, pg, miSrvTp);
		return result;
	}

	/**
	 * @param hpDo
	 *            医保上下文
	 * @param qryRootNodeDTO
	 *            查询方案
	 * @param orderStr
	 *            排序字段
	 * @param pg
	 *            分页信息
	 * @param miSrvTp
	 *            服务类型
	 * @return
	 */
	public ResultOutParamDTO<PagingRtnData<HpsrvorcaDTO>> findPagingDataByQCondAndMisrvTp(QryRootNodeDTO qryRootNodeDTO,
			String orderStr, PaginationInfo pg, String miSrvTp) {
		HpInnerService hpInnerService = this.insureInstanceFactory.createHpInnerServiceInstance();
		ResultOutParamDTO<PagingRtnData<HpsrvorcaDTO>> result = hpInnerService
				.findPagingDataByQCondAndMisrvTp(super.getId_hp(), qryRootNodeDTO, orderStr, pg, miSrvTp);
		return result;
	}

	/**
	 * @param fileKey
	 * @return
	 */
	public ResultOutParamDTO<String> saveUnPassData(String fileKey) {
		HpInnerService hpInnerService = this.insureInstanceFactory.createHpInnerServiceInstance();
		ResultOutParamDTO<String> result = hpInnerService.saveUnPassData(fileKey);
		return result;
	}
}
