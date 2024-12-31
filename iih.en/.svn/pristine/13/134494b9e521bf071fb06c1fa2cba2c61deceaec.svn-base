package iih.en.comm.ep;

import iih.en.comm.util.EnCodeUtils;
import iih.en.comm.util.EnLogUtil;
import iih.en.comm.validator.EnValidator;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.patamrcode.d.PiPatAmrCodeDO;
import iih.pi.reg.patamrcode.i.IPatamrcodeRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/***
 * 基础数据-住院病案号EP
 * @author zhangpp
 *
 */
public class EnCodeAmrIpEP {

	/**
	 * 生成住院病案编号
	 * @return
	 * @throws BizException
	 */
	public String createIpAmrCode() throws BizException{
		String entIpAmrCode = EnCodeUtils.createIpAmrCode();
		return entIpAmrCode;
	}
	/**
	 * 生成特定类型住院病案编号
	 * @param fullName
	 * @return
	 * @throws BizException
	 */
	public String createIpSpecTypeAmrCode(String fullName) throws BizException{
		String entIpSpecTypeAmrCode = EnCodeUtils.createIpSpecTypeAmrCode(fullName);
		return entIpSpecTypeAmrCode;
	}
	
	/**
	 * 回滚住院病案编号
	 * @param codeAmrIp
	 * @throws BizException
	 */
	public void rollBackCodeAmrIp(String codeAmrIp) throws BizException{
		EnCodeUtils.rollBackCodeAmrIp(codeAmrIp);
	}
	/**
	 * 回滚特定类型住院病案编号
	 * @param fullName
	 * @param codeAmrIp
	 * @throws BizException
	 */
	public void rollBackCodeAmrIpSpecType(String fullName, String codeAmrIp) throws BizException{
		EnCodeUtils.rollBackCodeAmrIpSpecType(fullName, codeAmrIp);
	}
	
	/**
	 * 回滚住院病案编号并删除患者表中住院病案编号
	 * @param codeAmrIp
	 * @param patId
	 * @throws BizException
	 */
	public void rollBackAndDelPatDOCodeAmrIp(String codeAmrIp, String patId) throws BizException{
		//回滚住院号之前先判断住院号是否已经保存到数据库，若已存入，不回滚
		if(!isRollBackAmrIp(codeAmrIp)) return;
		rollBackCodeAmrIp(codeAmrIp);
		EnLogUtil.getInstance().logInfo("回滾新生成的住院号：患者id"+patId+ " 回滾的住院号:"+codeAmrIp);
	 	PiPatEP patEP = new PiPatEP();
		PatDO patDO = patEP.getPatById(patId);
		if (patDO == null) {
			return;
		}
		patDO.setCode_amr_ip(null);
		patDO.setStatus(DOStatus.UPDATED);
		patEP.save(new PatDO[]{patDO});
	}
	/**
	 * 回滚特定类型的住院病案编号并删除患者病案编码表中数据
	 * @param fullName
	 * @param codeAmrIp
	 * @param patId
	 * @param sdPatamrtp
	 * @throws BizException
	 */
	public void rollBackAndDelPatAmrCodeDOCodeAmrIp(String fullName, String codeAmrIp, String patId, String sdPatamrtp) throws BizException{
		//是否回滚特定类型的住院号
		if(!isRollBackAmrIpSdParam(codeAmrIp,sdPatamrtp)) return;
		rollBackCodeAmrIpSpecType(fullName, codeAmrIp);
		EnLogUtil.getInstance().logInfo("回滾特定类型的住院号：患者id"+patId+ " 回滾的特定类型住院号为:"+codeAmrIp);
		PiPatAmrCodeEP piPatAmrCodeEP = new PiPatAmrCodeEP();
		PiPatAmrCodeDO pAmrCodeDO = piPatAmrCodeEP.getpiPatAmrCodeByWherestr(patId, sdPatamrtp);
		if (pAmrCodeDO == null) {
			return;
		}
		pAmrCodeDO.setStatus(DOStatus.DELETED);
		piPatAmrCodeEP.savePiPatAmrCodeDO(new PiPatAmrCodeDO[]{pAmrCodeDO});
	}
	/***
	 * @Description:是否回滚住院号
	 * @param codeAmrIp
	 * @return
	 * @throws BizException
	 */
	private boolean isRollBackAmrIp(String codeAmrIp) throws BizException{
		if(EnValidator.isEmpty(codeAmrIp)) return false;
		PiPatEP patEP = new PiPatEP();
		PatDO[] patDOs = patEP.getMRServ().find("CODE_AMR_IP = '"+codeAmrIp+"'", null, FBoolean.FALSE);
		return EnValidator.isEmpty(patDOs);
	}
	
	/***
	 * @Description:是否回滚特定类型住院号
	 * @param codeAmrIp
	 * @return
	 * @throws BizException
	 */
	private boolean isRollBackAmrIpSdParam(String codeAmrIp,String sdPatamrtp) throws BizException{
		if(EnValidator.isEmpty(codeAmrIp)) return false;
		IPatamrcodeRService iRService = ServiceFinder.find(IPatamrcodeRService.class);
		PiPatAmrCodeDO[] piPatAmrCodeDOs = iRService.find("CODE = '"+codeAmrIp+"' AND SD_PATAMRTP = '"+sdPatamrtp+"' ", "", FBoolean.FALSE);
		return EnValidator.isEmpty(piPatAmrCodeDOs);
	}
}
