package iih.en.ip.i;


import iih.en.ip.dto.d.EnHosRegInfoDTO;
import iih.en.ip.dto.d.EnIpDepInfoDTO;
import iih.en.pv.inpatient.d.InpatientDO;
import iih.pi.reg.pat.d.PatiAggDO;
import iih.sc.apt.dto.d.AptIpDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;


/**
 * 住院增删改服务2
 * 
 * @author liubin
 *
 */
public interface IEnIpCmdService2 {
	/**
	 * 保存入院通知单信息
	 * @param entipntDTO 入院通知单DTO
	 * @return
	 * @throws BizException
	 */                                                                           
	public void saveAptIp(AptIpDTO aptIpDTO) throws BizException;
	/**
	 * 未挂号，保存入院通知单
	 * @author zhangpp
	 * @param aptIpDTO
	 * @throws BizException
	 */
	void saveAptIpNoEnt(AptIpDTO aptIpDTO) throws BizException;
	/**
	 * 取消入院申请-删除
	 * @param aptIpDTO
	 * @param entId
	 * @throws BizException
	 */
	public void cancAptIp(AptIpDTO aptIpDTO) throws BizException;
	/**
	 * 取消入院申请-修改状态
	 * @author zhangpp
	 * @param aptIpId
	 * @throws BizException
	 */
	void cancAptIpUpdate(String aptIpId) throws BizException;
	/***
	 * 入院登记（含患者注册）--先保存患者信息
	 * @param patDTO
	 * @param enHosRegDTO
	 * @return
	 * @throws BizException
	 */
	PatiAggDO savePatInfo2(EnHosRegInfoDTO enHosRegInfoDTO) throws BizException;

	/**
	 * 入科服务
	 * @param enIpDepInfoDTO 一条记录患者信息的入科DTO
	 * @return boolean 反应是否入科成功
	 * @throws BizException
	 */
	FBoolean saveEnIpDepInfoDTO(EnIpDepInfoDTO enIpDepInfoDTO) throws BizException;

	/**
	 * 包床
	 * @param entId 就诊id
	 * @param mainBedId 主床位id
	 * @param bedId 床位id
	 * @throws BizException
	 */
	void rentBed(String entId,String mainBedId,String bedId) throws BizException;
	/**
	 * 取消包床
	 * @param entId 就诊id
	 * @param bedId 床位id
	 * @throws BizException
	 */
	void cancRentBed(String entId,String bedId) throws BizException;
	
	/**
	 * 入院登记保存前校验
	 * @param reginfoDTO 入院登记信息信息
	 * @param isReg 是否是入院登记（含注册）节点
	 */
	InpatientDO validateIPData2(EnHosRegInfoDTO reginfoDTO,FBoolean isReg) throws BizException;
	
	/**
	 * 取消入院登记
	 * @param entId
	 * @throws BizException
	 */
	void cancRegister2(EnHosRegInfoDTO enHosRegInfoDTO) throws BizException;
	
	/**
	 * 取消入院登记前校验
	 * @param enHosRegDTO
	 * @throws BizException
	 */
	void validateBeforeCancel2(EnHosRegInfoDTO enHosRegInfoDTO) throws BizException;
	
	void regAndPatReg2(EnHosRegInfoDTO enHosRegInfoDTO,PatiAggDO patiAggDO)throws BizException;
}
