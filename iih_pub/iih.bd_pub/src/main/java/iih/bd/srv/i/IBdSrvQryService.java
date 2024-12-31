package iih.bd.srv.i;

import iih.bd.srv.d.BdSrvQryDTO;
import iih.bd.srv.d.DiagDicaDTO;
import iih.bd.srv.d.EmrTplTreeDTO;
import iih.bd.srv.d.FixedChargePKgDTO;
import iih.bd.srv.d.RefItemDTO;
import iih.bd.srv.d.RefSrvItemDTO;
import iih.bd.srv.diagdef.d.DiagDefDO;
import iih.bd.srv.dto.d.Emp2Dep2GroupDTO;
import iih.bd.srv.dto.d.EmsDynamicParamDTO;
import iih.bd.srv.dto.d.MedSrvPriDTO;
import iih.bd.srv.dto.d.SrvSetItemDTO;
import iih.bd.srv.emreditor.d.EmrEditorDO;
import iih.bd.srv.emrterm.d.EmrEvent4TermDO;
import iih.bd.srv.emrterm.d.EmrNormWordCaDO;
import iih.bd.srv.emrterm.d.EmrTermCaDO;
import iih.bd.srv.emrterm.d.EmrTermCompDO;
import iih.bd.srv.emrterm.d.EmrTermDO;
import iih.bd.srv.emrtpl.d.EmrtplAggDO;
import iih.bd.srv.ems.d.EmsDynamicIndexDTO;
import iih.bd.srv.ems.d.EmsMatchRstDTO;
import iih.bd.srv.ems.d.SrvMatchEmsParamDTO;
import iih.bd.srv.freqdef.d.FreqDefDTO;
import iih.bd.srv.medsrv.d.BdMmDto;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvRelMmDTO;
import iih.bd.srv.medvalidate.d.MedvalidateAggDO;
import iih.bd.srv.mutex.d.SrvReactDTO;
import iih.bd.srv.ortmplquerydto.d.OrTmplQueryDTO;
import iih.bd.srv.ortpl.d.OrTplCaDO;
import iih.bd.srv.ortpl.dto.OrTmplDTO;
import iih.bd.srv.srvreact.d.SrvReactDO;
import iih.bd.srv.srvreact.d.SrvReactItemDO;
import iih.bd.srv.srvreact.d.SrvReactSrv;
import iih.bd.srv.srvrtctl.d.SrvRtCtlDTO;
import iih.bd.srv.srvrtctl.d.SrvRtCtlParam;
import iih.bd.srv.srvrtempref.d.SrvRtEmpRefDO;
import xap.dp.bfdesigner.d.DpBillFormTDO;
import xap.dp.dmengine.d.EnumValueDO;
import xap.dp.dmengine.d.PropertyDO;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.orgfw.dept.d.DeptDO;

public interface IBdSrvQryService {
	/**
	 * 服务互斥树的构造
	 */
	public abstract BdSrvQryDTO[] getSrvReactTreeData() throws BizException;
	
	/**
	 * 诊断标准树
	 */
	public abstract BdSrvQryDTO[] getDiagstacaTree() throws BizException;
	
	/**
	 * 医嘱频次树的构造
	 */
	public abstract FreqDefDTO[] getFreqDefTreeData() throws BizException;
	/**
	 * 医嘱频次编码
	 * @return
	 * @throws BizException
	 */
	 public abstract String getFreqDefNoapplyform()throws BizException;
	/**
	 * 
	 * @param aggdos
	 * @return
	 * @throws BizException
	 */
	public abstract EmrtplAggDO[] setCopyEmrTpl(EmrtplAggDO aggdos)
			throws BizException;

	/**
	 * tcy:获得该类模板的最大版本号
	 * 
	 * @param code
	 *            模板号
	 * @return
	 * @throws BizException
	 */
	public abstract Integer getMaxVersion(String code) throws BizException;
	
	public abstract EmrEditorDO[] getNewCopyDO(String code) throws BizException;

	/**
	 * 
	 * @param code
	 * @return
	 * @throws BizException
	 */
	public abstract Integer getBdmredMaxVersion(String code)
			throws BizException;

	/**
	 * 生成编码内部使用
	 * 
	 * @return
	 * @throws BizException
	 */
	public abstract String getAutoCode() throws BizException;

	/**
	 * 
	 * @return
	 * @throws BizException
	 */
	public abstract SrvReactSrv[] findSrv() throws BizException;

	/**
	 * 
	 * @param own_id
	 * @throws BizException
	 */
	public abstract void getEmpTypeTree(String own_id) throws BizException;

	/**
	 * 
	 * @param dos
	 * @return
	 * @throws BizException
	 */
	EmrEditorDO[] setCopyEmreditor(EmrEditorDO dos) throws BizException;

	/**
	 * 
	 * @param emr
	 * @return
	 * @throws BizException
	 */
	EmrEditorDO[] setEnableCopyEmreditor(EmrEditorDO emr) throws BizException;

	/**
	 * 查询单个全排斥医疗服务项目
	 */
	public abstract SrvReactSrv[] findById(String id) throws BizException;

	/**
	 * 查询选中服务项目所在的所有排斥组
	 */
	public abstract SrvReactDO[] findGroup(String id) throws BizException;

	/**
	 * emrTp tree
	 * 
	 * @param Id_own
	 * @return
	 * @throws BizException
	 */
	public abstract EmrTplTreeDTO[] getEmrTpTreeList(String Id_own)
			throws BizException;

	/**
	 * FixedChargePKgDO tree
	 * 
	 * @param
	 * @return
	 * @throws BizException
	 */
	public abstract FixedChargePKgDTO[] getFCPKgTreeList(String Id_own)
			throws BizException;

	/**
	 * 根据诊断查询分类状态
	 * 
	 * @param Id_di
	 * @return
	 * @throws BizException
	 * */
	public abstract DiagDicaDTO[] getDiagDicaDOList(String Id_di)
			throws BizException;

	/**
	 * 根据定价模式ID获得医疗服务定价信息集合
	 * 
	 * @param id_primd
	 *            服务定价模式id
	 * @return
	 * @throws BizException
	 */
	public MedSrvPriDTO[] getSrvPriMdInfo(String id_primd) throws BizException;

	/**
	 * 根据服务基本分类ID获得医疗服务定价信息集合
	 * 
	 * @param id_srvca
	 *            服务基本分类id
	 * @return
	 * @throws BizException
	 */
	public MedSrvPriDTO[] getSrvPriMdInfoByCa(String id_srvca)
			throws BizException;

	/**
	 * 根据服务套ID获得套内成员服务信息集合
	 * @param id_srv_set
	 * @return
	 * @throws BizException
	 */
	public SrvSetItemDTO[] getSrvSetSrvItemsInfo(String id_srv_set)  throws BizException ;
	
	/**
	 * 
	 * @param Id_mrtpl
	 * @return
	 * @throws BizException
	 */
	public DiagDefDO[] GetDiagDefDo(String Id_mrtpl)throws BizException;
	
	/**
	 * 
	 * @return
	 * @throws BizException
	 */
	public RefItemDTO[] getRefItemDTO(String id,String type)throws BizException;
	
	/**
	 * 
	 * @return
	 * @throws BizException
	 */
	public DiagDicaDTO[] getDistinctDicaList() throws BizException;
	
	/**
	 * 
	 * @return
	 * @throws BizException
	 */
	public BdSrvQryDTO[] findMedu()  throws BizException;
	
	/**
	 * 
	 * @param id
	 * @return
	 * @throws BizCeption
	 */
	public  DiagDefDO[] getSrvOrTplDiagDef(String id)throws BizException;
	
	/**
	 * 辅助录入检索  拼音码 五笔码 关键词 
	 * @param keyWord
	 * @return RefItemDTO[]
	 * @throws BizException
	 */
	public abstract RefSrvItemDTO[] getSrvListItem(String keyWord)throws BizException;
	
	/**
	 * 根据服务条件串获得服务互斥信息数据集合
	 * @param srvcondstr
	 * @return
	 * @throws BizException
	 */
	public abstract SrvReactDTO[] getSrvReactInfos(String srvcondstr) throws BizException;
	
	/**
	 *  医嘱开立时，获得医嘱未授权服务项目列表数据信息
	 * @param rtctlparam
	 * @return
	 * @throws BizException
	 */
	public abstract SrvRtCtlDTO[] getUnAuthorizedSrvRtCtlInfo(SrvRtCtlParam rtctlparam) throws BizException;
	/**
	 * 开立权限查找医生的类别和职称
	 * @param id
	 * @return
	 * @throws BizException
	 */
	public abstract SrvRtEmpRefDO getPsnMsgInfo(String id) throws BizException;
	
	public abstract String getUdidocExtent(String code) throws BizException;
	/**
	 *  草药方剂获取医嘱模板分类
	 */
	public abstract OrTplCaDO[] getSrvortplCate(String sd_ortpltp) throws BizException;
	/**
	 *  获取医嘱模板分类
	 */
	public abstract OrTplCaDO[] getSrvortplCateDO(String sd_ortpltp,Emp2Dep2GroupDTO edg) throws BizException;
	/**
	 * 查询科室服务限制的部门列表
	 * @return DeptDO[]
	 * @throws BizException
	 */
	public abstract DeptDO[] getDeptsrvlimitDeptTree() throws BizException;
	/**
	 * 获得医疗单对应的动态指标数据信息集合
	 * @return
	 * @throws BizException
	 */
	public abstract EmsDynamicIndexDTO[] getEmsDynamicIndexInfos(EmsDynamicParamDTO paramDto) throws BizException;	
	/**
	 * 获得医疗服务关联的物品集合信息
	 * （所有关联物品）
	 * @param id_srv
	 * @return
	 * @throws BizException
	 */
	public MedSrvRelMmDTO[] getMedSrvRelMmList(String id_srv) throws BizException;
	/**
	 * 获得医疗服务关联的物品集合信息
	 * （全院可用物品）
	 * @param id_srv
	 * @return
	 * @throws BizException
	 */
	public MedSrvRelMmDTO[] getMedSrvRelMmOrg(String id_srv) throws BizException;
	/**
	 * 获得医疗服务关联的物品集合信息
	 * （部门可用物品）
	 * @param id_srv
	 * @param id_dep
	 * @return
	 * @throws BizException
	 */
	public MedSrvRelMmDTO[] getMedSrvRelMmDept(String id_srv,String id_dep) throws BizException;
	
	/**
	 * 查询服务关联物品
	 */
	public abstract BdMmDto[] getBdMmData(String id_srv) throws BizException;
	/**
	 * 回填服务互斥关系中服务类型名称
	 * @param ids
	 * @return
	 * @throws BizException
	 */
	public SrvReactItemDO[] getSrvReactItemDO(String ids) throws BizException;
	/**
	 * 回填服务互斥关系中服务类型名称
	 * @param vo
	 * @return
	 * @throws BizException
	 */
	public Boolean getisReferenced(BaseDO vo) throws BizException;
	
	/**
	 * 根据表单id和服务分类获取最大的排序号
	 * @param formId 表单id
	 * @param srvcaCode 服务分类
	 * @return 最大的seq
	 * @throws BizException
	 */
	public int getDescCfgMaxSeq(String formId, String srvcaCode) throws BizException;
	
	/**
	 * 获取领域模型属性（DTO）
	 * @param classId 领域实体id
	 * @return
	 */
	public PropertyDO[] getPropertyDO(String classname) throws BizException;
	
	/**
	 * 获取领域模型属性(枚举)
	 * @param classId
	 * @return
	 * @throws BizException
	 */
	public EnumValueDO[] getEnumValueDO(String classId) throws BizException;
	
	/**
	 * 获取表单定义信息
	 * @param metadataclass
	 * @return
	 * @throws BizException
	 */
	public DpBillFormTDO[] getFormDO(String metadataclass) throws BizException;
	
	/**
	 * 根据条件获取术语分类信息
	 * @param emrTermCaDO 术语分类
	 * @return 术语分类集合
	 * @throws BizException
	 */
	public EmrTermCaDO[] getEmrTermCaTreeData(EmrTermCaDO emrTermCaDO) throws BizException;
	
	/**
	 * 根据条件获取术语信息
	 * @param emrTermCaDO 术语查询条件<br>
	 * 包含术语体系、术语分类、术语分组
	 * @param inputStr 界面输入的查询条件<br>
	 * 匹配术语编码、名称
	 * @return 术语集合
	 * @throws BizException
	 */
	public EmrTermDO[] getEmrTermData(EmrTermDO emrTermDO, String inputStr) throws BizException;
	
	/**
	 * 根据术语事件获取相关联的组件
	 * 
	 * @param emrEvent4Term 事件信息
	 * @return 事件关联的组件
	 * @throws BizException
	 */
	public EmrTermCompDO[] getEmrTermComps(EmrEvent4TermDO emrEvent4Term) throws BizException;
	
	/**
	 * 医生站医疗服务选择时，医疗服务匹配医疗单
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public EmsMatchRstDTO medSrvMatchEms(SrvMatchEmsParamDTO param) throws BizException;
	public EmrNormWordCaDO[] getNormWordCate(String type,String stype) throws BizException;
	public String getNormWordCateCode() throws BizException ;
	public EmrTermCaDO[] getEmrTermCate(String type, String stype,String sys) throws BizException;
	public String getEmrTermCateCode() throws BizException;
	public String getInputCompCode() throws BizException;
	/**
	 * 获取医嘱模板树数据
	 * 
	 */
	public OrTmplDTO[] getOrTmplCaDataTree(String code_entp, String id_grp,String id_org,String id_srvorrt,String id_dep,String id_emp,String id_ortmplca, FBoolean bFgactive) throws BizException;

	
	/**
	 * 获取医嘱模板最大序号
	 * @return
	 * @throws BizException
	 */
	public String getMaxSeqNO4OrTmpl(String id_ortmplca) throws Exception;
	
	/**
	 * 服务启用校验
	 * @param meds
	 * @return
	 */
	public abstract MedvalidateAggDO[] checkValidate(MedSrvDO[] meds);
	
	public abstract MedSrvDO GetMedSrvDO8Id(String id_srv)throws BizException;
	
	public abstract MedSrvDO[] GetMedSrvDOs8Ids(String[] id_srvs)throws BizException;
	/**
	 * 获取医嘱模板树数据
	 * 
	 */
	public OrTmplDTO[] getOrTmplData(OrTmplQueryDTO querydto) throws BizException;
}
