package iih.mi.itf.bizgrpitf;

import java.util.List;

import iih.bd.pp.anhuisrvorca.d.DrugCompDTO;
import iih.bd.pp.anhuisrvorca.d.TreatCompDTO;
import iih.bd.pp.hpsrvorca.d.HPSrvorcaDO;
import iih.bd.pp.hpsrvorcadto.d.HpsrvorcaDTO;
import iih.mi.itf.bizgrpitf.param.ResultOutParamDTO;
import xap.mw.core.data.FArrayList;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 医保内部接口集
 * 
 * @author hao_wu
 *
 */
public interface HpInnerService {

	/***
	 * 保存医保目录
	 * 
	 * @param miSrvTp
	 *            医保服务类型
	 * @param fileKey
	 *            文件KEY
	 * @return
	 */
	public ResultOutParamDTO<String> saveMedInsurDir(String miSrvTp, String fileKey);

	/**
	 * 刷新医保目录对照</br>
	 * 将不在对照表中的数据生成到对照表中
	 * 
	 * @param miSrvTp
	 *            医保项目类型</br>
	 *            枚举：iih.mi.biz.dto.d.MiSrvTp
	 * @return
	 */
	public ResultOutParamDTO<String> refreshMiDirComp(String miSrvTp);

	/**
	 * 医保目录自动对照
	 * 
	 * @param miSrvTp
	 *            医保项目类型</br>
	 *            枚举：iih.mi.biz.dto.d.MiSrvTp
	 * @return
	 */
	public ResultOutParamDTO<String> miDirAutoComp(String miSrvTp);

	/**
	 * 保存药品对照
	 * 
	 * @param insureContext
	 *            医保上下文
	 * @param drugCompDTOs
	 *            药品对照DTO集合
	 * @return
	 */
	public ResultOutParamDTO<List<DrugCompDTO>> saveDrugComp(List<DrugCompDTO> drugCompDTOs);
	
	/**
	 * 保存药品诊疗对照
	 * 
	 * @param insureContext
	 *            医保上下文
	 * @param drugCompDTOs
	 *            药品对照DTO集合
	 * @return
	 */
	public ResultOutParamDTO<List<DrugCompDTO>> saveDrugTreatComp(List<DrugCompDTO> drugCompDTOs);

	/**
	 * 保存诊疗对照
	 * 
	 * @param insureContext
	 *            医保上下文
	 * @param treatCompDTOs
	 *            诊疗对照DTO集合
	 * @return
	 */
	public ResultOutParamDTO<List<TreatCompDTO>> saveTreatComp(List<TreatCompDTO> treatCompDTOs);

	/**
	 * 删除药品对照
	 * 
	 * @param insureContext
	 *            医保上下文
	 * @param drugCompDTOs
	 *            药品对照DTO集合
	 * @return
	 */
	public ResultOutParamDTO<List<DrugCompDTO>> deleteDrugComp(List<DrugCompDTO> drugCompDTOs);

	/**
	 * 删除诊疗对照
	 * 
	 * @param insureContext
	 *            医保上下文
	 * @param treatCompDTOs
	 *            诊疗对照DTO集合
	 * @return
	 */
	public ResultOutParamDTO<List<TreatCompDTO>> deleteTreatComp(List<TreatCompDTO> treatCompDTOs);

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
	public ResultOutParamDTO<PagingRtnData<HPSrvorcaDO>> findByQCondAndPageInfo(String id_hp,
			QryRootNodeDTO qryRootNodeDto, String orderStr, PaginationInfo pg);

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
	public ResultOutParamDTO<FArrayList> exportHpDirList(String id_hp, QryRootNodeDTO qryRootNodeDto, String orderStr,
			PaginationInfo pg, String miSrvTp);

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
	public ResultOutParamDTO<PagingRtnData<HpsrvorcaDTO>> findPagingDataByQCondAndMisrvTp(String id_hp,
			QryRootNodeDTO qryRootNodeDTO, String orderStr, PaginationInfo pg, String miSrvTp);

	/**
	 * 保存未审批通过数据
	 * 
	 * @param fileKey
	 *            文件KEY
	 * @return
	 */
	public ResultOutParamDTO<String> saveUnPassData(String fileKey);
}