package iih.en.ip.s;


import iih.en.ip.dto.d.EnHosRegInfoDTO;
import iih.en.ip.dto.d.EnIpDepInfoDTO;
import iih.en.ip.i.IEnIpCmdService2;
import iih.en.ip.s.bp.CancRentBedBP;
import iih.en.ip.s.bp.CancelRegisterBP2;
import iih.en.ip.s.bp.RentBedBP;
import iih.en.ip.s.bp.SaveEnIpDepInfoDTOBP;
import iih.en.ip.s.bp.ip.CancAptIpBP;
import iih.en.ip.s.bp.ip.RegAndPatRegBP2;
import iih.en.ip.s.bp.ip.SaveAptIpBP;
import iih.en.ip.s.bp.ip.ValidateCanRegInfoBP2;
import iih.en.ip.s.bp.ip.ValidateIPDataBP2;
import iih.en.pv.inpatient.d.InpatientDO;
import iih.pi.reg.pat.d.PatiAggDO;
import iih.sc.apt.dto.d.AptIpDTO;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;

/**
 * 住院增删改服务2
 * 
 * @author liubin
 *
 */
@Service(serviceInterfaces={IEnIpCmdService2.class}, binding=Binding.JSONRPC)
public class EnIpCmdService2Impl implements IEnIpCmdService2 {
	
	/**
	 * 保存入院通知单信息
	 * @param entipntDTO 入院通知单DTO
	 * @return
	 * @throws BizException
	 */                                                                           
	@Override
	public void saveAptIp(AptIpDTO aptIpDTO) throws BizException{
		SaveAptIpBP saveAptIpBP = new SaveAptIpBP();
		saveAptIpBP.exec(aptIpDTO);
	}
	/**
	 * 未挂号，保存入院通知单
	 * @param aptIpDTO
	 * @throws BizException
	 */
	@Override
	public void saveAptIpNoEnt(AptIpDTO aptIpDTO) throws BizException{
		SaveAptIpBP saveAptIpBP = new SaveAptIpBP();
		saveAptIpBP.saveAptIpNoEnt(aptIpDTO);
	} 
	/**
	 * 取消入院申请-删除
	 * @param entipntDTO
	 * @param entId
	 * @throws BizException
	 */
	@Override
	public void cancAptIp(AptIpDTO aptIpDTO) throws BizException{
		CancAptIpBP cancAptBp = new CancAptIpBP();
		cancAptBp.exec(aptIpDTO);
	}
	/**
	 * 取消入院申请-修改状态
	 * @param aptIpId
	 * @throws BizException
	 */
	@Override
	public void cancAptIpUpdate(String aptIpId) throws BizException{
		CancAptIpBP cancAptBp = new CancAptIpBP();
		cancAptBp.canc(aptIpId);
	}
	/***
	 * 入院登记（含患者注册）--先保存患者信息
	 * @param patDTO
	 * @param enHosRegInfoDTO
	 * @return
	 * @throws BizException
	 */
	@Override
	public PatiAggDO savePatInfo2(EnHosRegInfoDTO enHosRegInfoDTO) throws BizException{
		RegAndPatRegBP2 regBP = new RegAndPatRegBP2();
		return regBP.savePatInfo(enHosRegInfoDTO);
	}
	
	
	
	/**
	 * 入院登记保存前校验
	 * @param patDTO 患者信息
	 * @param enHosRegDTO 入院登记DTO
	 * @param isReg 
	 */
	@Override
	public InpatientDO validateIPData2(EnHosRegInfoDTO reginfoDTO,FBoolean isReg) throws BizException{
		ValidateIPDataBP2 val = new ValidateIPDataBP2();
		return val.exec(reginfoDTO, isReg);
	}
	/**
	 * 入科服务
	 * @param enIpDepInfoDTO 一条记录患者信息的入科DTO
	 * @return boolean 反应是否入科成功
	 * @throws BizException
	 */
	@Override
	public FBoolean saveEnIpDepInfoDTO(EnIpDepInfoDTO enIpDepInfoDTO) throws BizException{
		SaveEnIpDepInfoDTOBP bp  = new SaveEnIpDepInfoDTOBP();
		return FBoolean.TRUE;
	}
	
	/**
	 * 包床
	 * @param entId 就诊id
	 * @param mainBedId 主床位id
	 * @param bedId 床位id
	 * @throws BizException
	 */
	@Override
	public void rentBed(String entId,String mainBedId,String bedId) throws BizException{
		RentBedBP bp = new RentBedBP();
		bp.exec(entId, mainBedId, bedId);
	}
	/**
	 * 取消包床
	 * @param entId 就诊id
	 * @param bedId 床位id
	 * @throws BizException
	 */
	@Override
	public void cancRentBed(String entId,String bedId) throws BizException{
		CancRentBedBP bp = new CancRentBedBP();
		bp.exec(entId, bedId);
	}
	
	/**
	 * 取消入院登记
	 * @param entId
	 * @throws BizException
	 */
	@Override
	public void cancRegister2(EnHosRegInfoDTO enHosRegInfoDTO) throws BizException{
		CancelRegisterBP2 cancelBP = new CancelRegisterBP2();
		cancelBP.exec(enHosRegInfoDTO);
	}
	
	/**
	 * 取消入院登记前校验
	 * @param enHosRegDTO
	 * @throws BizException
	 */
	@Override
	public void validateBeforeCancel2(EnHosRegInfoDTO enHosRegInfoDTO) throws BizException{
		//1、 查找就诊数据
		CancelRegisterBP2 cancelRegisterBP = new CancelRegisterBP2();
		InpatientDO inpatientDO = cancelRegisterBP.getInpatient(enHosRegInfoDTO.getId_ent());
		//2.校验数据
		ValidateCanRegInfoBP2 vb = new ValidateCanRegInfoBP2();
		vb.exec(enHosRegInfoDTO, inpatientDO);
	}



	@Override
	public void regAndPatReg2(EnHosRegInfoDTO enHosRegInfoDTO,PatiAggDO patiAggDO) throws BizException {
		// TODO Auto-generated method stub
		RegAndPatRegBP2 bp = new RegAndPatRegBP2();
		bp.exec(enHosRegInfoDTO, patiAggDO);
		
	}
}
