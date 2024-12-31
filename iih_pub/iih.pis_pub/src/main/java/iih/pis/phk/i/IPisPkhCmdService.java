package iih.pis.phk.i;

import java.lang.reflect.InvocationTargetException;

import iih.pis.phk.dto.d.PisPhkMtAppDTO;
import iih.pis.phk.dto.d.PisPhkMtResDTO;
import iih.pis.phk.dto.d.PisPhkRegResultDTO;
import iih.pis.phk.phk.d.PisPhkDO;
import iih.pis.phk.render.patientdata.d.PatientData;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

public interface IPisPkhCmdService {
	/**
	 * 新郑患者接待
	 * @param patient
	 * @return
	 */
	PisPhkDO addPisPhkDO(PatientData patient) throws BizException ;
	/**
	 * 就诊签到
	 * @param code_pat
	 * @param schtype
	 * @param id_apt
	 * @param id_psndoc
	 * @return
	 * @throws BizException
	 */
    String cfmPaidApt(String code_pat,String schtype,String id_apt, String id_psndoc)throws BizException;
    /**
     * 取消预约
     * @param aptId
     * @return
     * @throws BizException
     */
    String cancAptAndRefund(String aptId, String id_psndoc) throws BizException;
	/**
	 * 患者出院
	 * @param patId
	 * @throws BizException
	 */
	void leaveHosFrom(PatientData data) throws BizException;
	
	/**
	 * 更换管家
	 * @param patientData
	 * @param id_phkemp
	 * @throws BizException 
	 */
	void changeStewardForm(PatientData patientData,String id_phkemp) throws BizException;
	/**
	 * 预约门诊号
	 * @param id_sch
	 * @param chltype
	 * @param code_pat
	 * @param code_emp
	 * @return
	 * @throws BizException
	 */
	PisPhkRegResultDTO makeAptNew(String id_sch,String chltype,String code_pat,String code_emp) throws BizException;
	/**
	 * 呼叫患者
	 * @param id_psndoc
	 * @param code_dep
	 * @return
	 * @throws BizException
	 */
    FBoolean callPat(String id_psndoc, String code_dep) throws BizException;
    /**
     * 呼叫患者并通知医生
     * @param id_ent
     * @param id_pat
     * @param id_doctor
     * @param id_quesite
     * @return
     * @throws BizException
     */
    String nursCallPatNoticeDoctor(String id_ent, String id_pat,String id_doctor,String id_quesite) throws BizException;
    /**
     * 呼叫管家
     * @param id_pat
     * @return
     * @throws BizException
     */
    String callPisPhk(String id_pat) throws BizException;
    /**
     * 管家医技预约
     * @param phkMtResDTO
     * @param phkMtAppDTO
     * @return
     * @throws BizException 
     * @throws InvocationTargetException 
     * @throws IllegalAccessException 
     */
    PisPhkMtResDTO saveMtApt(PisPhkMtResDTO phkMtResDTO,PisPhkMtAppDTO phkMtAppDTO) throws IllegalAccessException, InvocationTargetException, BizException;
    /**
     * 管家取消预约
     * @param phkMtAppDTO
     * @throws BizException 
     */
    void cancelMtApt(PisPhkMtAppDTO phkMtAppDTO) throws BizException;
    /**
     * 到检签到
     * @param id_or
     * @return
     * @throws BizException
     */
    String signInMt(String id_or) throws BizException;
}
