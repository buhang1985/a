package iih.en.pv.s.listener.bp;

import iih.bd.bc.udi.pub.IBdResDictCodeTypeConst;
import iih.bd.bc.udi.pub.IPiDictCodeTypeConst;
import iih.en.comm.IEnConst;
import iih.en.comm.IEnMsgConst;
import iih.en.comm.ep.OpEP;
import iih.en.comm.ep.PatEP;
import iih.en.comm.ep.PvEP;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.OpReg4EsDTO;
import iih.en.pv.dto.d.Reg4IpDTO;
import iih.en.pv.outpatient.d.OutpatientDO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.pi.reg.pat.d.PatDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.util.AgeCalcUtil;
import xap.sys.xbd.udi.d.UdidocDO;
import xap.sys.xbd.udi.i.IUdidocServiceExt;

/**
 * 门诊挂号集成平台BP
 * 
 * 通过OpReg4EsDTO构造Reg4IpDTO
 * 
 * @author yank
 * @author liubin
 */
public class GetOpReg4IpBP {
	/**
	 * 通过OpReg4EsDTO构造Reg4IpDTO
	 * @param opRegEsDTO 门诊挂号事件源DTO
	 * @throws BizException
	 */
	public Reg4IpDTO createReg4IpDTO(OpReg4EsDTO opRegEsDTO) throws BizException{
		//验证OpReg4EsDTO
		this.validate(opRegEsDTO);
		Reg4IpDTO reg4IpDTO = new Reg4IpDTO();
		//1、设置患者信息
		this.setPatInfo(reg4IpDTO, opRegEsDTO.getId_pat());
		//2、设置就诊信息		
		this.setEntInfo(reg4IpDTO, opRegEsDTO.getId_ent());
		return reg4IpDTO;
	}
	/**
	 * 设置患者信息
	 * @param reg4IpDTO
	 * @param patId
	 * @throws BizException
	 */
	private void setPatInfo(Reg4IpDTO reg4IpDTO,String patId) throws BizException{
		PatEP patEP = new PatEP();
		PatDO patDO = patEP.getPatById(patId);
		if(patDO == null)
			throw new BizException(IEnMsgConst.ERROR_PAT_NOT_EXIST);
		reg4IpDTO.setId_pat(patDO.getId_pat());//患者ID
		reg4IpDTO.setCode_pat(patDO.getCode());
		reg4IpDTO.setName_pat(patDO.getName());//姓名
		
		if(!EnValidator.isEmpty(patDO.getSd_sex())){
			reg4IpDTO.setSd_sex(patDO.getSd_sex());//性别
			UdidocDO udiSex = this.getUdidoc(IPiDictCodeTypeConst.SD_SEX_CODE, patDO.getSd_sex());
			if(udiSex != null){
				if(!EnValidator.isEmpty(udiSex.getCode_ie()))
					reg4IpDTO.setSd_sex(udiSex.getCode_ie());
			}
		}
		reg4IpDTO.setDt_birth(EnAppUtils.toStringFDateFormat(patDO.getDt_birth()));//出生日期
		reg4IpDTO.setAge(AgeCalcUtil.getAge(patDO.getDt_birth()));//年龄		
		reg4IpDTO.setBarcode_chis(patDO.getBarcode_chis());//健康卡号
	}
	/**
	 * 设置就诊信息
	 * @param reg4IpDTO
	 * @param entId
	 * @throws BizException
	 */
	private void setEntInfo(Reg4IpDTO reg4IpDTO,String entId) throws BizException{
		PvEP pvEP = new PvEP();
		PatiVisitDO pvDO =pvEP.getPvById(entId);
		if(pvDO == null)
			throw new BizException(IEnMsgConst.ERROR_OP_PVINFO_NOT_EXISTS);
		reg4IpDTO.setCode_org(pvDO.getOrgcode());
		reg4IpDTO.setName_org(pvDO.getName_org());
		reg4IpDTO.setId_ent(entId);//就诊ID
		reg4IpDTO.setCode_ent(pvDO.getCode());//就诊编码
		reg4IpDTO.setCode_ent_serial(pvDO.getCode());
		reg4IpDTO.setDt_reg(EnAppUtils.toStringFDateTimeFormat(pvDO.getDt_insert()));//挂号时间
		reg4IpDTO.setDt_entry(EnAppUtils.toStringFDateTimeFormat(pvDO.getDt_entry()));//就诊时间
		reg4IpDTO.setCode_entp(IEnConst.OPENTTP);//就诊类型编码
		reg4IpDTO.setName_entp(pvDO.getName_entp());//就诊类型名称
		reg4IpDTO.setCode_feetype(pvDO.getSd_patca());//费用类别编码
		reg4IpDTO.setName_feetype(pvDO.getName_patca());//费用类别名称

		OpEP opEP = new OpEP();
		OutpatientDO opDO = opEP.getOpByEntId(entId);
		if(opDO == null)
			throw new BizException(IEnMsgConst.ERROR_OP_OPINFO_NOT_EXISTS);
		reg4IpDTO.setTickno(opDO.getTicketno());//就诊序号
		reg4IpDTO.setTimes_en(opDO.getTimes_op());//就诊次数
		reg4IpDTO.setCode_dept(opDO.getDep_reg_code());//挂号科室编码
		reg4IpDTO.setName_dept(opDO.getDep_reg_name());//挂号科室名称
		reg4IpDTO.setCode_doc(opDO.getEmp_reg_code());//挂号医生编码
		reg4IpDTO.setName_doc(opDO.getEmp_reg_name());//挂号医生名称
		
		reg4IpDTO.setName_period(opDO.getDayslot_name());//就诊时段名称
		if(!EnValidator.isEmpty(opDO.getSd_dayslottp())){
			reg4IpDTO.setCode_period(opDO.getSd_dayslottp());//就诊时段编码
			UdidocDO udiSlotTp = this.getUdidoc(IBdResDictCodeTypeConst.SD_DAYSLOTTP, opDO.getSd_dayslottp());
			if(udiSlotTp!=null){
				if(!EnValidator.isEmpty(udiSlotTp.getCode_ie()))
					reg4IpDTO.setCode_period(udiSlotTp.getCode_ie());
			}
		}
		reg4IpDTO.setName_srvtp(opDO.getScsrv_name());//号别名称
		reg4IpDTO.setSd_srvtp(opDO.getScsrv_code());//号别编码
		reg4IpDTO.setEntp(reg4IpDTO.getCode_entp());//门诊
		reg4IpDTO.setId_domain(IEnConst.HISAREA);//域ID
		reg4IpDTO.setCode_regmode(reg4IpDTO.getCode_entp());//挂号方式编码
		reg4IpDTO.setName_regmode(reg4IpDTO.getName_entp());//挂号方式名称
	}
	/**
	 * 验证OpReg4EsDTO
	 * 
	 * @param opRegEsDTO
	 * @throws BizException
	 */
	private void validate(OpReg4EsDTO opRegEsDTO) throws BizException {
		if(opRegEsDTO==null)
			throw new BizException(IEnMsgConst.ERROR_LISTENER_NO_SOURCE);
		if(EnValidator.isEmpty(opRegEsDTO.getId_ent()))
			throw new BizException(IEnMsgConst.ERROR_OP_PVINFO_NOT_EXISTS);
		if(EnValidator.isEmpty(opRegEsDTO.getId_pat()))
			throw new BizException(IEnMsgConst.ERROR_PAT_NOT_EXIST);
	}
	/**
	 * 获取自定义档案
	 * 
	 * @param codeType
	 * @param code
	 * @return
	 * @throws BizException
	 */
	private UdidocDO getUdidoc(String codeType, String code) throws BizException{
		IUdidocServiceExt udiExtServ = ServiceFinder.find(IUdidocServiceExt.class);
		return udiExtServ.findByCode(codeType, code);
	}
}
