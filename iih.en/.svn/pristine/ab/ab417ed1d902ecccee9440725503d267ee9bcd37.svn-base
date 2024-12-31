package iih.en.comm.ep;

import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.en.comm.validator.EnValidator;
import iih.pi.dic.creditcategory.d.PiPatCretDO;
import iih.pi.dic.creditcategory.i.ICreditcategoryRService;
import iih.pi.dic.patientcategory.d.PiPatCaDO;
import iih.pi.dic.patientcategory.i.IPatientcategoryRService;
import iih.pi.reg.dto.d.PiPatFuzyyQueryCondDTO;
import iih.pi.reg.i.IPiRegQryService;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PatiAggDO;
import iih.pi.reg.pat.d.PiPatContDO;
import iih.pi.reg.pat.d.desc.PiPatContDODesc;
import iih.pi.reg.pat.i.IPatiMDOCudService;
import iih.pi.reg.pat.i.IPatiMDORService;
import iih.pi.reg.pat.i.IPiPatContDOCudService;
import iih.pi.reg.pat.i.IPiPatContDORService;
import iih.pi.reg.pattag.d.PatTagDO;
import iih.pi.reg.pattag.i.IPattagRService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 患者扩展方法 将患者信息查询相关封装到这里
 * 
 * @author yank
 *
 */
public class PatEP {
	/**
	 * 根据患者ID获取患者DO
	 * 
	 * @param patId 患者ID
	 * @return
	 * @throws BizException
	 */
	public PatDO getPatById(String patId) throws BizException {
		if (EnValidator.isEmpty(patId))
			return null;
		IPatiMDORService patRService = ServiceFinder.find(IPatiMDORService.class);
		PatDO patdo = patRService.findById(patId);
		return patdo;
	}
	/**
	 * 根据患者编码获取患者DO
	 * 
	 * @param code
	 * @return
	 * @throws BizException
	 */
	public PatDO getPatByCode(String code) throws BizException {
		if (EnValidator.isEmpty(code))
			return null;
		IPatiMDORService patRService = ServiceFinder.find(IPatiMDORService.class);
		PatDO[] patdos = patRService.findByAttrValString(PatDO.CODE, code);
		if(!EnValidator.isEmpty(patdos)){
			for(PatDO pat : patdos){
				if(!FBoolean.TRUE.equals(pat.getFg_invd()))
					return pat;
			}
		}
		return null;
	}
	/**
	 * 查找患者信息
	 * @param cond
	 * @return
	 * @throws BizException
	 */
	public PatiAggDO getPatAggDo(PiPatFuzyyQueryCondDTO cond) throws BizException{
		IPiRegQryService rService = ServiceFinder.find(IPiRegQryService.class);
		PatiAggDO[] patiAggDOs = rService.fuzzyQueryPati(cond);
		if (EnValidator.isEmpty(patiAggDOs)) {
			return null;
		}
		return patiAggDOs[0];
	}

	/**
	 * 查找所有联系人
	 * 
	 * @param patId
	 * @return
	 * @throws BizException
	 */
	public PiPatContDO[] getContDO(String patId) throws BizException {
		IPiPatContDORService rservice = ServiceFinder.find(IPiPatContDORService.class);
		PiPatContDO[] patConts = rservice.find(PiPatContDODesc.TABLE_ALIAS_NAME + ".id_pat = '"
				+ patId + "'", "sortno", FBoolean.FALSE);
		return patConts;
	}

	/**
	 * 查找儿童的父母
	 * 
	 * @param patId
	 * @return
	 * @throws BizException
	 */
	public PiPatContDO[] getParentContDO(String patId) throws BizException {
		IPiPatContDORService rservice = ServiceFinder.find(IPiPatContDORService.class);
		PiPatContDO[] patConts = rservice.find(PiPatContDODesc.TABLE_ALIAS_NAME + ".id_pat = '"
				+ patId + "' and  (isnull(sd_fmrole,'~')='~' or sd_fmrole in ('" + IPiDictCodeConst.SD_PARENT_FATHER + "','"
				+ IPiDictCodeConst.SD_PARENT_MOTHER + "'))"+ "and sd_conttp = '"+ IPiDictCodeConst.SD_CONT_TYPE_PARENT+"'" , "", FBoolean.FALSE);
		return patConts;
	}

	/**
	 * 获取患者默认分类
	 * 
	 * @author zhengcm
	 * @return 患者分类（默认）
	 * @throws BizException
	 */
	public PiPatCaDO getPatDefaultCate() throws BizException {
		IPatientcategoryRService qryService = ServiceFinder.find(IPatientcategoryRService.class);
		PiPatCaDO[] cateDOs = qryService.findByAttrValString(PiPatCaDO.FG_DEF, "Y");
		if (!EnValidator.isEmpty(cateDOs)) {
			return cateDOs[0];
		}
		return null;
	}

	/**
	 * 删除患者联系人
	 * 
	 * @author zhengcm
	 * @param patId 患者ID
	 * @throws BizException
	 */
	public void deletePatContByPatId(String patId) throws BizException {
		if (EnValidator.isEmpty(patId)) {
			return;
		}
		PiPatContDO[] patContDOs = this.getContDO(patId);
		if (EnValidator.isEmpty(patContDOs)) {
			return;
		}
		// 患者联系人维护服务
		IPiPatContDOCudService cmdService = ServiceFinder.find(IPiPatContDOCudService.class);
		cmdService.delete(patContDOs);
	}

	/**
	 * 更新患者信息
	 * 
	 * @author zhengcm
	 * @param patDOs 患者信息DO数组
	 * @throws BizException
	 */
	public PatDO[] updatePatDOs(PatDO[] patDOs) throws BizException {
		if (EnValidator.isEmpty(patDOs)) {
			return null;
		}
		// 患者基本信息维护服务
		IPatiMDOCudService cmdService = ServiceFinder.find(IPatiMDOCudService.class);
		return cmdService.update(patDOs);
	}

	/**
	 * 新增患者基本信息
	 * 
	 * @author zhengcm
	 * @param patDOs 患者基本信息DO数组
	 * @return 更新后的患者基本信息数组
	 * @throws BizException
	 */
	public PatDO[] insertPatDOs(PatDO[] patDOs) throws BizException {
		if (EnValidator.isEmpty(patDOs)) {
			return null;
		}
		// 患者基本信息维护服务
		IPatiMDOCudService cmdService = ServiceFinder.find(IPatiMDOCudService.class);
		return cmdService.insert(patDOs);
	}

	/**
	 * 根据患者ID批量查询患者基本信息
	 *
	 * @param patIds 患者id数组
	 * @return 患者基本信息DO数组
	 * @throws BizException
	 * @author zhengcm
	 */
	public PatDO[] getPatByPatIds(String[] patIds) throws BizException {
		if (EnValidator.isEmpty(patIds)) {
			return null;
		}
		// 患者基本信息查询服务
		IPatiMDORService patRService = ServiceFinder.find(IPatiMDORService.class);
		return patRService.findByIds(patIds, FBoolean.FALSE);
	}
	/**
	 * 根据患者ID批量查询患者基本信息
	 *
	 * @param patIds 患者id数组
	 * @return 患者基本信息DO数组
	 * @throws BizException
	 * @author zhengcm
	 */
	public Map getPatMpaByPatIds(String[] patIds) throws BizException {
		if (EnValidator.isEmpty(patIds)) {
			return null;
		}
		// 患者基本信息查询服务
		IPatiMDORService patRService = ServiceFinder.find(IPatiMDORService.class);
		PatDO[] patDOs=  patRService.findByIds(patIds,FBoolean.FALSE);
		if (EnValidator.isEmpty(patDOs)) {
			return null;
		}	
		Map map = new HashMap();
		for(PatDO patDO:patDOs){
			map.put(patDO.getId_pat(), patDO);
		} 
		return  map;
	}
	/**
	 * 保存患者联系人
	 *
	 * @param patContDO 患者联系人DO
	 * @return 保存后的患者联系人DO
	 * @throws BizException
	 * @author zhengcm
	 */
	public PiPatContDO savePatCont(PiPatContDO patContDO) throws BizException {
		if (null == patContDO) {
			return null;
		}
		// 患者联系人服务
		IPiPatContDOCudService service = ServiceFinder.find(IPiPatContDOCudService.class);
		return service.save(new PiPatContDO[] { patContDO })[0];
	}

	/**
	 * 根据患者联系人ID查询患者联系人
	 *
	 * @param id_patcont 患者联系人ID
	 * @return 患者联系人DO
	 * @throws BizException
	 * @author zhengcm
	 */
	public PiPatContDO getPatContById(String id_patcont) throws BizException {
		if (EnValidator.isEmpty(id_patcont)) {
			return null;
		}
		// 患者联系人查询服务
		IPiPatContDORService rservice = ServiceFinder.find(IPiPatContDORService.class);
		return rservice.findById(id_patcont);
	}
	/**
	 * 获取患者信用分类
	 * 
	 * @param patCretID 信用分类ID
	 * @return
	 * @throws BizException
	 */
	public PiPatCretDO getPatCret(String patCretID) throws BizException {
		if (EnValidator.isEmpty(patCretID)) {
			return null;
		}
		ICreditcategoryRService credService = ServiceFinder.find(ICreditcategoryRService.class);
		return credService.findById(patCretID);
	}
	/**
	 * 把相同证件号的其他患者证件类型改为其他
	 * 
	 * @param patId
	 * @param idCode
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public void updateSdCodeTp2Others(String patId, String sdIdtp, String idCode) throws BizException{
		if(EnValidator.isEmpty(idCode) || EnValidator.isEmpty(sdIdtp))
			return;
		
		if(IPiDictCodeConst.SD_IDTP_QTFDZ.equals(sdIdtp))
			return;
		
		String whereStr = "id_code = ? and sd_idtp = ? ";
		SqlParam param = new SqlParam();
		param.addParam(idCode);
		param.addParam(sdIdtp);
		if(!EnValidator.isEmpty(patId)){
			whereStr += " and id_pat <> ? ";
			param.addParam(patId);
		}
		DAFacade df = new DAFacade();
		List<PatDO> list = (List<PatDO>)df.findByCond(PatDO.class, whereStr, param);;
		if(EnValidator.isEmpty(list))
			return;
		for(PatDO pat : list){
			pat.setStatus(DOStatus.UPDATED);
			pat.setSd_idtp(IPiDictCodeConst.SD_IDTP_QTFDZ);
			pat.setId_idtp(IPiDictCodeConst.ID_IDTP_QTFDZ);
		}
		df.updateDOList(list);
	}
	
	
	
	/**
	 * 获取患者的标签
	 * @param patId
	 * @throws BizException 
	 */
	public String getPatTagTp(String patId) throws BizException{
		IPattagRService  rservice = ServiceFinder.find(IPattagRService.class);
		PatTagDO[] patTagDOs =	rservice.findByAttrValString(PatTagDO.ID_PAT, patId);
		if(EnValidator.isEmpty(patTagDOs)){
			return  null;
		}
		String tagIDs = "";		
		for(int i=0;i<=patTagDOs.length-1;i++){
			if(i==patTagDOs.length-1){
				tagIDs+=patTagDOs[i].getId_pattagtp();
			}else{
				tagIDs+=patTagDOs[i].getId_pattagtp()+",";
			}
		}

			return tagIDs;
	}
}
