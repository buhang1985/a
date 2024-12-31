package iih.en.que.s.bp;

import iih.en.comm.IEnMsgConst;
import iih.en.comm.ep.OpEP;
import iih.en.comm.ep.PvEP;
import iih.en.comm.util.EnParamUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.outpatient.d.OutpatientDO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.bdfw.bbd.i.IPsndocMDORService;

/**
 * 判断是否可刷卡接诊该患者
 * 
 * @author liubin
 *
 */
public class CheckAcptByCardBP {
	/*
	 * 可被别的科跨科接诊
	 */
	private static final String EN_OP_DEPCTRL_FG_RECED = "1";

	/*
	 * 可跨科接诊别的科的病人
	 */
	private static final String EN_OP_DEPCTRL_FG_RECDEP = "2";
	/**
	 * 是否可刷卡接诊该患者
	 * @param entId 
	 * 		就诊ID
	 * @param deptId 
	 * 		当前科室ID
	 * @param empId 
	 * 		当前医生ID
	 * @return
	 * @throws BizException
	 * @author liubin
	 */
	public FBoolean exec(String entId, String deptId, String empId) throws BizException {
		if(EnValidator.isEmpty(entId)||EnValidator.isEmpty(deptId)){
			return FBoolean.FALSE;
		}
		OpEP opEP = new OpEP();
		OutpatientDO outpatient = opEP.getOpByEntId(entId);
		if(outpatient == null)
			throw new BizException(IEnMsgConst.ERROR_OP_OPINFO_NOT_EXISTS);
		if(deptId.equals(outpatient.getId_dep_reg())){
			//(1) 如果EN_ENT_op.id_dep_reg = 当前科室
			if(EnValidator.isEmpty(outpatient.getId_emp_reg())){
				//(1.1)如果EN_ENT_op.id_emp_reg = null, 直接接诊处理
				return FBoolean.TRUE;
			}else if(outpatient.getId_emp_reg().equals(empId)){
				//(1.2)EN_ENT_op.id_emp_reg = @当前医生, 直接接诊处理。
				return FBoolean.TRUE;
			}else{
				PvEP enBP = new PvEP();
				PatiVisitDO patiVisit = enBP.getPvById(entId);
				if(patiVisit==null){
					throw new BizException(IEnMsgConst.ERROR_OP_PVINFO_NOT_EXISTS);
				}
				if(FBoolean.TRUE.equals(patiVisit.getFg_acptvalid())){
					//(1.3)EN_ENT.fg_acptvalid = true  直接接诊处理。 （当回诊处理）
					return FBoolean.TRUE;
				}else{
					//(1.4)EN_ENT.fg_acptvalid = false . 提示患者的挂号医生是xxx，不允许直接接诊。
					PsnDocDO psndoc = ServiceFinder.find(IPsndocMDORService.class).findById(outpatient.getId_emp_reg());
					throw new BizException(String.format("该患者挂号医生是%s医生,不允许直接接诊！",psndoc.getName()));
				}
			}
		}else{
			//(2)  如果EN_ENT_op.id_dep_reg !=当前科室
			//患者挂号科室参数
			String crossDeptAcptFlagOfReg = EnParamUtils.getCrossDepAcpt(outpatient.getId_dep_reg());
			//患者接诊科室参数
			String crossDeptAcptFlagOfDep = EnParamUtils.getCrossDepAcpt(deptId);
			if (EN_OP_DEPCTRL_FG_RECED.equals(crossDeptAcptFlagOfReg)) {
				return FBoolean.TRUE;
			} else if (EN_OP_DEPCTRL_FG_RECDEP.equals(crossDeptAcptFlagOfDep)) {
				return FBoolean.TRUE;
			} else {
				return FBoolean.FALSE;
			}
		}
	}
}
