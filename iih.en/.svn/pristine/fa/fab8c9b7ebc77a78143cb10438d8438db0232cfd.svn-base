package iih.en.pv.s.bp.op;

import iih.bd.bc.udi.pub.IEnDictCodeTypeConst;
import iih.en.comm.IEnMsgConst;
import iih.en.comm.ep.EntHpEP;
import iih.en.comm.ep.OpEP;
import iih.en.comm.ep.PvEP;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.OpReg4EsDTO;
import iih.en.pv.entplan.d.EntHpDO;
import iih.en.pv.outpatient.d.OutpatientDO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.xbd.udi.d.UdidocDO;
import xap.sys.xbd.udi.i.IUdidocServiceExt;

/**
 * 获取OpReg4EsDTO
 * 
 * @author liubin
 *
 */
public class GetOpReg4EsBP {
	/**
	 * 获取OpReg4EsDTO
	 * 
	 * @param patId
	 * @param entId
	 * @return
	 * @throws BizException 
	 */
	public OpReg4EsDTO createOpReg4EsDTO(String entId) throws BizException {
		//验证
		this.validate(entId);
		OpReg4EsDTO opReg4Es = new OpReg4EsDTO();
		//设置就诊信息
		this.setEntInfo(opReg4Es, entId);
		//设置门诊信息
		this.setOpInfo(opReg4Es, entId);
		//设置医保信息
		this.setHpInfo(opReg4Es, entId, opReg4Es.getId_hp());
		return opReg4Es;
	}
	/**
	 * 设置就诊信息
	 * @param reg4IpDTO
	 * @param entId
	 * @throws BizException
	 */
	private void setEntInfo(OpReg4EsDTO opReg4Es,String entId) throws BizException{
		PvEP pvEP = new PvEP();
		PatiVisitDO pvDO =pvEP.getPvByPK(entId);
		if(pvDO == null)
			throw new BizException(IEnMsgConst.ERROR_OP_PVINFO_NOT_EXISTS);
		opReg4Es.setId_ent(entId);//就诊ID
		opReg4Es.setCode_entp(pvDO.getCode_entp());//就诊类型编码
		opReg4Es.setId_pat(pvDO.getId_pat());//患者ID
		opReg4Es.setName_pat(pvDO.getName_pat());//患者姓名
		opReg4Es.setId_hp(pvDO.getId_hp());//医保计划ID
		opReg4Es.setDt_insert(pvDO.getDt_insert());//挂号登记时间
		opReg4Es.setDt_entry(pvDO.getDt_entry());//就诊时间	
	}
	/**
	 * 设置门诊信息
	 * 
	 * @param opReg4Es
	 * @param entId
	 * @throws BizException
	 */
	private void setOpInfo(OpReg4EsDTO opReg4Es,String entId) throws BizException{
		OpEP opEP = new OpEP();
		OutpatientDO opDO = opEP.getOpByEntId(entId);
		if(opDO == null)
			throw new BizException(IEnMsgConst.ERROR_OP_OPINFO_NOT_EXISTS);
		opReg4Es.setId_scres(opDO.getId_scres());//挂号资源ID
		opReg4Es.setName_scres(opDO.getScres_name());//挂号资源
		opReg4Es.setId_scsrv(opDO.getId_scsrv());//挂号服务ID
		opReg4Es.setName_scsrv(opDO.getScsrv_name());//挂号服务
		opReg4Es.setId_dep_reg(opDO.getId_dep_reg());//挂号科室ID
		opReg4Es.setName_dep_reg(opDO.getDep_reg_name());//挂号科室
		opReg4Es.setId_dateslot(opDO.getId_dateslot());//挂号日期分组ID
		opReg4Es.setName_dateslot(opDO.getDayslot_name());//挂号日期分组
		opReg4Es.setId_doc(opDO.getId_emp_reg());//挂号医生ID
		opReg4Es.setName_doc(opDO.getEmp_reg_name());//挂号医生
		opReg4Es.setSd_status(opDO.getSd_status());//就诊状态编码
		
		IUdidocServiceExt udiExtServ = ServiceFinder.find(IUdidocServiceExt.class);
		UdidocDO udiStatus = udiExtServ.findByCode(IEnDictCodeTypeConst.SD_EN_STATUS, opDO.getSd_status());
		if(udiStatus!=null){
			opReg4Es.setName_status(udiStatus.getName());//就诊状态名称
		}
	}
	/**
	 * 设置医保计划
	 * 
	 * @param opReg4Es
	 * @param entId
	 * @param hpId
	 * @throws BizException
	 */
	private void setHpInfo(OpReg4EsDTO opReg4Es,String entId, String hpId) throws BizException{
		if(EnValidator.isEmpty(entId) || EnValidator.isEmpty(hpId))
			return;
		EntHpEP hpEp = new EntHpEP();
		EntHpDO entHp = hpEp.getEntHpById(entId, hpId);
		if(entHp != null)
			opReg4Es.setNo_hp(entHp.getNo_hp());//医保卡号
	}
	/**
	 * 验证entId
	 * 
	 * @param entId
	 * @throws BizException
	 */
	private void validate(String entId) throws BizException {
		if(EnValidator.isEmpty(entId))
			throw new BizException(IEnMsgConst.ERROR_OP_PVINFO_NOT_EXISTS);
	}
}
