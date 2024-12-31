package iih.en.comm.ep;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnParamUtils;
import iih.en.comm.validator.EnValidator;
import iih.pi.dic.patcatehp.d.PiPatCaHpDO;
import iih.pi.dic.patcatehp.i.IPatcatehpRService;
import iih.pi.dic.patientcategory.d.PiPatCaDO;
import iih.pi.dic.patientcategory.i.IPatientcategoryRService;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PatiAddrDO;
import iih.pi.reg.pat.d.desc.PatiAddrDODesc;
import iih.pi.reg.pat.i.IPatiAddrDORService;
import iih.pi.reg.pat.i.IPatiCudService;
import iih.pi.reg.pat.i.IPatiMDOCudService;
import iih.pi.reg.pat.i.IPatiMDORService;
import iih.pi.reg.pat.i.IPatiRService;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 患者相关操作
 * 
 * @author liubin
 *
 */
public class PiPatEP {
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
		return getMRServ().findById(patId);
	}
	/**
	 * 根据患者ID获取患者DO
	 * 
	 * @param patId 患者ID
	 * @return
	 * @throws BizException
	 */
	public PatDO getPatByPK(String patId) throws BizException {
		if (EnValidator.isEmpty(patId))
			return null;
		return (PatDO) new DAFacade().findByPK(PatDO.class, patId);
	}
	/**
	 * 根据患者ID获取患者DO
	 * 
	 * @param patId 患者ID
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public PatDO[] getPatByPKs(String[] patIds) throws BizException {
		if (EnValidator.isEmpty(patIds))
			return null;
		List<PatDO> list = (List<PatDO>) new DAFacade().findByPKs(PatDO.class, patIds);
		return EnValidator.isEmpty(list) ? null : list.toArray(new PatDO[list.size()]);
	}
	/**
	 * 获取患者默认分类
	 * 
	 * @return 患者分类（默认）
	 * @throws BizException
	 */
	public PiPatCaDO getPatDefaultCate() throws BizException {
		IPatientcategoryRService qryService = ServiceFinder.find(IPatientcategoryRService.class);
		PiPatCaDO[] cateDOs = qryService.findByAttrValString(PiPatCaDO.FG_DEF, "Y");
		if (!EnValidator.isEmpty(cateDOs)) {
			return cateDOs[0];
		}
		throw new BizException("获取默认患者分类失败！");
	}
	/**
	 * 获取患者分类
	 * 
	 * @return 患者分类
	 * @throws BizException
	 */
	public PiPatCaDO getPatCaById(String patCaId) throws BizException {
		if(EnValidator.isEmpty(patCaId))
			return null;
		IPatientcategoryRService qryService = ServiceFinder.find(IPatientcategoryRService.class);
		return qryService.findById(patCaId);
	}
	/**
	 * 患者分类是否适用此就诊类型
	 * 
	 * @param patCaId
	 * @param entp
	 * @return
	 * @throws BizException
	 */
	public FBoolean isMatchPatca(String patCaId, String entp) throws BizException {
		if(EnValidator.isEmpty(patCaId))
			return FBoolean.FALSE;
		SqlParam param = new SqlParam();
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append(" SELECT COUNT(1) FROM PI_PAT_CA WHERE ID_PATCA = ? ");
		param.addParam(patCaId);
		if(IBdFcDictCodeConst.SD_CODE_ENTP_OP.equals(entp)){
			sqlBuilder.append(" AND FG_OP = ? ");
			param.addParam(FBoolean.TRUE);
		}
		else if(IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(entp)){
			sqlBuilder.append(" AND FG_IP = ? ");
			param.addParam(FBoolean.TRUE);
		}
		else if(IBdFcDictCodeConst.SD_CODE_ENTP_ET.equals(entp)){
			sqlBuilder.append(" AND FG_ER = ? ");
			param.addParam(FBoolean.TRUE);
		}else{
			return FBoolean.FALSE;
		}
		Integer count = (Integer) new DAFacade().execQuery(sqlBuilder.toString(), param, new ColumnHandler());
		return  new FBoolean(count != null && count > 0);
	}
	/**
	 * 获取现住址信息
	 * 
	 * @param patId
	 * @return
	 * @throws BizException
	 */
	public PatiAddrDO getNowPatAddr(String patId) throws BizException{
		if (EnValidator.isEmpty(patId))
			return null;
		IPatiAddrDORService serv = ServiceFinder.find(IPatiAddrDORService.class);
		String whereStr = String.format("id_pat = '%s' and Sd_addrtp = '%s'", patId,
				IPiDictCodeConst.SD_ADDR_TYPE_NOW);
		PatiAddrDO[] patiAddrDOs = serv.find(whereStr, null, FBoolean.FALSE);
		if(EnValidator.isEmpty(patiAddrDOs))
			return null;
		return patiAddrDOs[0];
	}
	/**
	 * 获取患者地址DO，并设置状态 zhangpp 2019.10.21
	 * @param addrTypeSd 地址类型编码
	 * @param patId 患者id
	 * @param isDel 是否删除
	 * @return
	 * @throws BizException
	 */
	public PatiAddrDO getAndSetAddrDoStatus(String addrTypeSd, String patId , boolean isDel) throws BizException{
		PatiAddrDO patAddrDO = null;
		IPatiAddrDORService addRService = ServiceFinder.find(IPatiAddrDORService.class);
		PatiAddrDO[] patAddrDOArr = addRService.find(PatiAddrDODesc.TABLE_ALIAS_NAME + ".id_pat ='" + patId + "' and " + PatiAddrDODesc.TABLE_ALIAS_NAME + ".sd_addrtp = '" + addrTypeSd + "'", "", FBoolean.FALSE);
		if (EnValidator.isEmpty(patAddrDOArr)  ) {
			if(isDel) return null;
			patAddrDO = new PatiAddrDO();
			patAddrDO.setStatus(DOStatus.NEW);
			return patAddrDO;
		}
		patAddrDO = patAddrDOArr[0];
		if(isDel){
			patAddrDO.setStatus(DOStatus.DELETED);
			return patAddrDO;
		}
		patAddrDO.setStatus(DOStatus.UPDATED);
		return patAddrDO;
	}
	/**
	 * 获取HpId对应医保持卡患者分类
	 * 
	 * @param hpId
	 * @return
	 * @throws BizException
	 */
	public PiPatCaDO getOpPatCaByHpId(String hpId)throws BizException{
		if (EnValidator.isEmpty(hpId))
			return null;
		IPatcatehpRService caHpServ = ServiceFinder.find(IPatcatehpRService.class);
		PiPatCaHpDO[] caHps = caHpServ.find(String.format("Id_hp = '%s' and Fg_hp_card = '%s'", hpId, FBoolean.TRUE), null, FBoolean.FALSE);
		if(EnValidator.isEmpty(caHps))
			return null;
		IPatientcategoryRService qryService = ServiceFinder.find(IPatientcategoryRService.class);
		PiPatCaDO[] cateDOs = qryService.findByIds(EnAppUtils.getKeyPropArrayFromDO(PiPatCaHpDO.ID_PATCA, caHps), FBoolean.FALSE);
		if (!EnValidator.isEmpty(cateDOs)) {
			for(PiPatCaDO cateDO : cateDOs){
				if(FBoolean.TRUE.equals(cateDO.getFg_op()))
					return cateDO;
			}
		}
		return null;
	}
	/**
	 * 获取预约自费付费患者分类
	 * 
	 * @param patId
	 * @return
	 * @throws BizException
	 */
	public PiPatCaDO getAptSelfPayPatca(String patId) throws BizException{
		return getAptSelfPayPatca(getPatById(patId));
	}
	/**
	 * 获取预约自费付费患者分类
	 * 
	 * @param pat
	 * @return
	 * @throws BizException
	 */
	public PiPatCaDO getAptSelfPayPatca(PatDO pat) throws BizException{
		if(pat == null)
			return null;
		//患者自身患者分类为门诊
		if(FBoolean.TRUE.equals(isMatchPatca(pat.getId_paticate(), IBdFcDictCodeConst.SD_CODE_ENTP_OP))){
			//获取在门诊预约中直接使用的患者分类
			String patCaIds = EnParamUtils.getAptSelfPayPatCaIds();
			if(!EnValidator.isEmpty(patCaIds) && patCaIds.contains(pat.getId_paticate()))
				return getPatCaById(pat.getId_paticate());
				
		}
		return getPatDefaultCate();
	}
	/**
	 * 保存患者
	 * 
	 * @param pats
	 * @return
	 * @throws BizException
	 */
	public PatDO[] save(PatDO[] pats) throws BizException{
		if(EnValidator.isEmpty(pats))
			return null;
		return getMCudServ().save(pats);
	}
	/**
	 * 获取主DO查询服务
	 * @return
	 */
	public IPatiMDORService getMRServ(){
		return ServiceFinder.find(IPatiMDORService.class);
	}
	/**
	 * 获取主DO修改服务
	 * @return
	 */
	public IPatiMDOCudService getMCudServ(){
		return ServiceFinder.find(IPatiMDOCudService.class);
	}
	/**
	 * 获取PatAggDO查询服务
	 * @return
	 */
	public IPatiRService getPatAggRServ(){
		return ServiceFinder.find(IPatiRService.class);
	}
	/**
	 * 获取PatAggDO修改服务
	 * @return
	 */
	public IPatiCudService getPatAggCudServ(){
		return ServiceFinder.find(IPatiCudService.class);
	}
}
