package iih.ei.std.s.v1.bp.common;

import com.mysql.jdbc.StringUtils;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.ei.std.d.v1.utils.EiAppUtils;
import iih.ei.std.d.v1.utils.EiValidator;
import iih.pi.dic.patcatehp.d.PiPatCaHpDO;
import iih.pi.dic.patcatehp.i.IPatcatehpRService;
import iih.pi.dic.patientcategory.d.PiPatCaDO;
import iih.pi.dic.patientcategory.i.IPatientcategoryRService;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PatiAddrDO;
import iih.pi.reg.pat.d.desc.PatiAddrDODesc;
import iih.pi.reg.pat.i.IPatiAddrDORService;
import iih.pi.reg.pat.i.IPatiMDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class PatEP {

	/**
	 * 根据患者编码获取患者DO
	 * 
	 * @param code
	 * @return
	 * @throws BizException
	 */
	public PatDO getPatByCode(String code) throws BizException {
		if (StringUtil.isEmptyWithTrim(code))
			return null;
		IPatiMDORService patRService = ServiceFinder.find(IPatiMDORService.class);
		PatDO[] patdos = patRService.findByAttrValString(PatDO.CODE, code);
		if(!ArrayUtil.isEmpty(patdos)){
			for(PatDO pat : patdos){
				if(!FBoolean.TRUE.equals(pat.getFg_invd()))
					return pat;
			}
		}
		return null;
	}
	/**
	 * 获取HpId对应医保持卡患者分类
	 * 
	 * @param hpId
	 * @return
	 * @throws BizException
	 */
	public PiPatCaDO getOpPatCaByHpId(String hpId)throws BizException{
		if (StringUtil.isEmptyWithTrim(hpId))
			return null;
		IPatcatehpRService caHpServ = ServiceFinder.find(IPatcatehpRService.class);
		PiPatCaHpDO[] caHps = caHpServ.find(String.format("Id_hp = '%s' and Fg_hp_card = '%s'", hpId, FBoolean.TRUE), null, FBoolean.FALSE);
		if(ArrayUtil.isEmpty(caHps))
			return null;
		IPatientcategoryRService qryService = ServiceFinder.find(IPatientcategoryRService.class);
		PiPatCaDO[] cateDOs = qryService.findByIds(EiAppUtils.getKeyPropArrayFromDO(PiPatCaHpDO.ID_PATCA, caHps), FBoolean.FALSE);
		if (!ArrayUtil.isEmpty(cateDOs)) {
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
			String patCaIds = EiParamUtils.getAptSelfPayPatCaIds();
			if(!EiValidator.isEmpty(patCaIds) && patCaIds.contains(pat.getId_paticate()))
				return getPatCaById(pat.getId_paticate());
				
		}
		return getPatDefaultCate();
	}
	/**
	 * 获取患者分类
	 * 
	 * @return 患者分类
	 * @throws BizException
	 */
	public PiPatCaDO getPatCaById(String patCaId) throws BizException {
		if(StringUtil.isEmptyWithTrim(patCaId))
			return null;
		IPatientcategoryRService qryService = ServiceFinder.find(IPatientcategoryRService.class);
		return qryService.findById(patCaId);
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
		if (!ArrayUtil.isEmpty(cateDOs)) {
			return cateDOs[0];
		}
		throw new BizException("获取默认患者分类失败！");
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
		if(StringUtils.isNullOrEmpty(patCaId))
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
	 * 获取患者地址集合
	 * @param patId 患者ID
	 * @param addrTpCode 地址类型编码
	 * @return
	 * @throws BizException
	 */
	public PatiAddrDO getPatAddressDO(String patId,String addrTpCode) throws BizException{
		IPatiAddrDORService patAddrService = ServiceFinder.find(IPatiAddrDORService.class);
		String whereStr =String.format("%s.id_pat='%s' and %s.sd_addrtp='%s'",PatiAddrDODesc.TABLE_ALIAS_NAME,patId
				,PatiAddrDODesc.TABLE_ALIAS_NAME,addrTpCode);
		PatiAddrDO[] addrDOArray = patAddrService.find(whereStr, null, FBoolean.FALSE);
		if(ArrayUtil.isEmpty(addrDOArray))
			return null;
		
		return addrDOArray[0];
	}
	
	/**
	 * 获取主DO查询服务
	 * @return
	 */
	public IPatiMDORService getMRServ(){
		return ServiceFinder.find(IPatiMDORService.class);
	}
}
