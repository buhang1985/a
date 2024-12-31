package iih.en.pv.s.bp.op;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.en.comm.IEnMsgConst;
import iih.en.comm.bp.PatQryBP;
import iih.en.comm.ep.PatEP;
import iih.en.comm.ep.PiPatEP;
import iih.en.comm.util.EnParamUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.outpatient.dto.d.OpRegPatDTO;
import iih.pi.dic.patientcategory.d.PiPatCaDO;
import iih.pi.dic.patientcategory.i.IPatientcategoryRService;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PatiAddrDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.log.logging.Logger;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;

/**
 * 获取门诊挂号患者注册信息
 * 
 * @author liubin
 *
 */
public class GetOpRegPatBP {
	/**
	 * 获取门诊挂号患者注册信息
	 * 
	 * @param patId  患者Id
	 * @param isSwingHpCad  是否是刷医保卡
	 * @return
	 * @throws BizException
	 */
	public OpRegPatDTO exec(String patId, FBoolean isSwingHpCad)
			throws BizException {
		//获取患者信息
		OpRegPatDTO opRegPat =setPatInfo(patId);
		if(opRegPat == null)
			throw new BizException(IEnMsgConst.ERROR_PAT_NOT_EXIST);
		//设置医保刷卡患者分类
		setHpPatcaInfo(opRegPat, patId, isSwingHpCad);
		//设置默认患者分类
		setDefPatCaInfo(opRegPat);
		//设置现地址
		setPatNowAddr(opRegPat, patId);
		
		return opRegPat;
	}
	/**
	 * 设置患者信息
	 * 
	 * @param patId
	 * @return
	 * @throws BizException
	 */
	private OpRegPatDTO setPatInfo(String patId) throws BizException{
		PatEP patEP = new PatEP();
		PatDO pat = patEP.getPatById(patId);
		if(pat == null)
			return null;
		OpRegPatDTO opRegPat = new OpRegPatDTO();
		opRegPat.setId_pat(pat.getId_pat());
		opRegPat.setCode_pat(pat.getCode());
		opRegPat.setName_pat(pat.getName());
		opRegPat.setFg_realname(pat.getFg_realname());
		opRegPat.setPycode(pat.getPycode());
		opRegPat.setWbcode(pat.getWbcode());
		opRegPat.setBarcode_chis(pat.getBarcode_chis());
		opRegPat.setId_sex(pat.getId_sex());
		opRegPat.setSd_sex(pat.getSd_sex());
		opRegPat.setName_sex(pat.getName_sex());
		opRegPat.setDt_birth(pat.getDt_birth());
		opRegPat.setAge(AgeCalcUtil.getAge(opRegPat.getDt_birth()));
		opRegPat.setId_marry(pat.getId_marry());
		opRegPat.setSd_marry(pat.getSd_marry());
		opRegPat.setName_marry(pat.getMarry_name());
		opRegPat.setId_idtp(pat.getId_idtp());
		opRegPat.setSd_idtp(pat.getSd_idtp());
		opRegPat.setName_idtp(pat.getIdtp_name());
		opRegPat.setId(pat.getId_code());
		opRegPat.setPhoto(pat.getPhoto());
		opRegPat.setId_patca(pat.getId_paticate());
		opRegPat.setName_patca(pat.getPaticate_name());
		opRegPat.setId_pripat(pat.getId_patpritp());
		opRegPat.setName_pripat(pat.getPatpritp_name());
		opRegPat.setId_patcredtp(pat.getId_patcrettp());
		opRegPat.setName_patcredtp(pat.getPatcrettp_name());
		opRegPat.setMob(!EnValidator.isEmpty(pat.getMob()) ? 
				pat.getMob() : pat.getTel());
		opRegPat.setFg_hp_card(FBoolean.FALSE);
		opRegPat.setFg_hpsettle(FBoolean.FALSE);
		opRegPat.setFg_settlebycard(FBoolean.FALSE);
        // 户籍类型
		opRegPat.setId_srcregiontp(pat.getId_srcregiontp());
		opRegPat.setSd_srcregiontp(pat.getSd_srcregiontp());
		opRegPat.setName_srcregiontp(pat.getName_srcregiontp());

        //职业
		opRegPat.setId_occu(pat.getId_occu());
		opRegPat.setSd_occu(pat.getSd_occu());
        opRegPat.setName_occu(pat.getOccu_name());
        //民族
        opRegPat.setId_nation(pat.getId_nation());
        opRegPat.setSd_nation(pat.getSd_nation());
        opRegPat.setName_nation(pat.getNation_name());
		return opRegPat;
	}
	/**
	 * 设置医保刷卡患者分类
	 * 
	 * @param opRegPat
	 * @param patId
	 * @param isSwingHpCad
	 * @throws BizException
	 */
	private void setHpPatcaInfo(OpRegPatDTO opRegPat, String patId, FBoolean isSwingHpCad) throws BizException{
		if(!FBoolean.TRUE.equals(isSwingHpCad))
			return;
		String hpDefPatca = EnParamUtils.getHpDefPatcaId();
		if(EnValidator.isEmpty(hpDefPatca)){
			Logger.warn("刷医保卡默认患者分类参数【ENOP0170】未赋值...");
			return;
		}
		IPatientcategoryRService serv =ServiceFinder.find(IPatientcategoryRService.class);
		PiPatCaDO piPatCa = serv.findById(hpDefPatca);
		if(piPatCa == null)
			return;
		opRegPat.setId_patca(piPatCa.getId_patca());
		opRegPat.setName_patca(piPatCa.getName());
		opRegPat.setId_pripat(piPatCa.getId_patpritp());
		opRegPat.setName_pripat(piPatCa.getPatpritp_name());
		opRegPat.setId_patcredtp(piPatCa.getId_patcrettp());
		opRegPat.setName_patcredtp(piPatCa.getPatcrettp_name());
	}
	/**
	 * 如果患者的患者分类不适用于门诊，设置默认患者分类
	 * 
	 * @param opRegPat
	 * @throws BizException
	 */
	private void setDefPatCaInfo(OpRegPatDTO opRegPat) throws BizException{
		PiPatEP ep = new PiPatEP();
		//该患者的患者分类是否适用于门诊
		if(FBoolean.TRUE.equals(ep.isMatchPatca(opRegPat.getId_patca(), IBdFcDictCodeConst.SD_CODE_ENTP_OP)))
			return;
		PiPatCaDO defPatCa = ep.getPatDefaultCate();
		if(defPatCa != null){
			opRegPat.setId_patca(defPatCa.getId_patca());
			opRegPat.setName_patca(defPatCa.getName());
			opRegPat.setId_pripat(defPatCa.getId_patpritp());
			opRegPat.setName_pripat(defPatCa.getPatpritp_name());
			opRegPat.setId_patcredtp(defPatCa.getId_patcrettp());
			opRegPat.setName_patcredtp(defPatCa.getPatcrettp_name());
		}else{
			opRegPat.setId_patca(null);
			opRegPat.setName_patca(null);
			opRegPat.setId_pripat(null);
			opRegPat.setName_pripat(null);
			opRegPat.setId_patcredtp(null);
			opRegPat.setName_patcredtp(null);
		}
	}
	/**
	 * 设置患者现住址信息
	 * 
	 * @param opRegPat
	 * @param patId
	 * @throws BizException
	 */
	private void setPatNowAddr(OpRegPatDTO opRegPat, String patId) throws BizException{
		PatQryBP patQryBp = new PatQryBP();
		PatiAddrDO addr = patQryBp.getPatAddressDO(patId, IPiDictCodeConst.SD_ADDR_TYPE_NOW);
		if (addr == null) 
			return;
		opRegPat.setAddr_pat(addr.getStreet());
		opRegPat.setId_admdiv(addr.getId_admdiv());
		opRegPat.setSd_admdiv(addr.getSd_admdiv());
		opRegPat.setName_admdiv(addr.getAdmdiv_fullname());
	}
}
