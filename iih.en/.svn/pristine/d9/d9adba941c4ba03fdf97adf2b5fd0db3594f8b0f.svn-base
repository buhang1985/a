package iih.en.pv.s.bp.op;

import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.en.comm.ep.EntHpEP;
import iih.en.comm.ep.OpEP;
import iih.en.comm.ep.OpRegEP;
import iih.en.comm.ep.PvEP;
import iih.en.comm.util.EnParamUtils;
import iih.en.pv.outpatient.d.OutpatientDO;
import iih.en.pv.outpatient.dto.d.RegInfoDTO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.pi.reg.pat.d.PatDO;
import iih.sc.apt.dto.d.OpAptDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 预约创建就诊信息
 * 
 * @author yank
 */
public class AptCreateEntBP {
	/**
	 * 预约创建就诊信息
	 * 
	 * @param patDO 患者DO
	 * @param aptDTO 门诊预约信息
	 * @param isTakeAptNo 是否是预约取号
	 * @return
	 * @throws BizException
	 */
	public String exec(PatDO patDO, OpAptDTO aptDTO, FBoolean isTakeAptNo) throws BizException {
		RegInfoDTO regInfo = AptParser.aptToRegDTO(aptDTO);
		return this.exec(patDO, regInfo, isTakeAptNo);
	}
	/**
	 * 预约创建就诊信息
	 * 
	 * @param patDO 患者DO
	 * @param aptDTO 门诊预约信息
	 * @param isTakeAptNo 是否是预约取号
	 * @return
	 * @throws BizException
	 */
	public String exec(PatDO patDO, RegInfoDTO regInfo, FBoolean isTakeAptNo) throws BizException {
		// 1、保存ent
		PvEP pvEP = new PvEP();
		PatiVisitDO pvDO = pvEP.savePv(patDO, regInfo, null);
		regInfo.setId_ent(pvDO.getId_ent());// 赋值id_ent
		
		// 2、保存op
		OpEP opEP = new OpEP();
		if(isTakeAptNo!=null && isTakeAptNo.booleanValue()){
			regInfo.setSd_status(IEnDictCodeConst.SD_ENSTATUS_OP_REGISTER);
		}else{
			regInfo.setSd_status(IEnDictCodeConst.SD_ENSTATUS_OP_ORDER);
		}
		OutpatientDO opDO = opEP.createOpDO(regInfo);
		opEP.save(opDO);
		
		// 3、保存hp
		EntHpEP entHpBP = new EntHpEP();
		entHpBP.deleteByEntId(pvDO.getId_ent());//删除原来的医保
		entHpBP.saveEntHp(regInfo);

		// 4、保存entque,是预约取号 或 读取参数sc_op_aptNeedCfm，如果为FALSE,则插入队列
		if (FBoolean.TRUE.equals(isTakeAptNo) || !EnParamUtils.getAptNeedCfm()) {
			JoinOpQueBP joinQueBP = new JoinOpQueBP();
			joinQueBP.exec(pvDO, regInfo);
		}
		//5.保存en_ent_op_reg
		new OpRegEP().saveOpReg(regInfo);

		return pvDO.getId_ent();
	}
}
