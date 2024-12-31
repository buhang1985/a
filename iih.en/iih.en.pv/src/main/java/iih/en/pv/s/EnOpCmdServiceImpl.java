package iih.en.pv.s;

import iih.en.pv.i.IEnOpCmdService;
import iih.en.pv.outpatient.dto.d.EuDrawTickMod;
import iih.en.pv.outpatient.dto.d.OpBasic4EditDTO;
import iih.en.pv.outpatient.dto.d.OpRegPatDTO;
import iih.en.pv.outpatient.dto.d.PayInfoDTO;
import iih.en.pv.outpatient.dto.d.RegInfoDTO;
import iih.en.pv.outpatient.dto.d.RegListDTO;
import iih.en.pv.s.bp.op.CancOpRegByEntIdBP;
import iih.en.pv.s.bp.op.CancOpRegNewBp;
import iih.en.pv.s.bp.op.CancOpRegWithCostBP;
import iih.en.pv.s.bp.op.CancVipBP;
import iih.en.pv.s.bp.op.ChangeOpRegHpBP;
import iih.en.pv.s.bp.op.DiagEndBP;
import iih.en.pv.s.bp.op.EnPrnPrinterBP;
import iih.en.pv.s.bp.op.LockSchOpBP;
import iih.en.pv.s.bp.op.OpRegMutiBP;
import iih.en.pv.s.bp.op.PriceAndRegistBP;
import iih.en.pv.s.bp.op.RegPatAndOpBP;
import iih.en.pv.s.bp.op.RegPatBP;
import iih.en.pv.s.bp.op.SaveOpAgentBP;
import iih.en.pv.s.bp.op.SaveOpBasicInfoBP;
import iih.en.pv.s.bp.op.SetUpVipBP;
import iih.en.pv.s.bp.op.st.AccountBP;
import iih.en.pv.s.bp.op.st.PricingBP;
import iih.en.pv.s.bp.op.st.ResettleBP;
import iih.sc.sch.dto.d.LockResultDTO;
import iih.sc.sch.i.IScSchOutCmdService;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;

/**
 * 门诊服务
 * @author yank
 *
 */
@Service(serviceInterfaces={IEnOpCmdService.class}, binding=Binding.JSONRPC)
public class EnOpCmdServiceImpl implements IEnOpCmdService {
	/**
	 * 划价
	 * @param regInfo 挂号信息
	 * @param fgAcc 只记账标志
	 * @param fgPrint 是否打印发票
	 * @return
	 * @throws BizException
	 */
	@Override
	public RegInfoDTO pricing(RegInfoDTO regInfo,FBoolean fgAcc,FBoolean fgPrint) throws BizException{
		PricingBP pricingBP = new PricingBP();
		return pricingBP.exec(regInfo,fgAcc,fgPrint);
	}
	/**
	 * 挂号
	 * @param patId 患者id
	 * @param regInfos 挂号信息
	 * @param payInfoDTO 支付信息
	 * @return
	 * @throws BizException
	 */
	@Override
	public RegInfoDTO[] regist(String patId,RegInfoDTO[] regInfos,PayInfoDTO payInfoDTO) throws BizException{
		OpRegMutiBP opRegBP = new OpRegMutiBP();
		return opRegBP.exec(patId, regInfos, payInfoDTO);
	}
	/**
	 * 患者注册+挂号
	 * @param patDTO 患者信息
	 * @param regInfos 挂号信息
	 * @param payInfoDTO 支付信息
	 * @return
	 * @throws BizException
	 */
	@Override
	public RegInfoDTO[] regPatAndOp(OpRegPatDTO patDTO,RegInfoDTO[] regInfos,PayInfoDTO payInfoDTO) throws BizException{
		RegPatAndOpBP regBP = new RegPatAndOpBP();
		return regBP.exec(patDTO, regInfos, payInfoDTO);
	}
	/**
	 * 划价+挂号
	 * @param patId 患者id
	 * @param regInfos 挂号信息
	 * @param chlTpCode 渠道编码
	 * @param regTp 挂号类型,枚举：EuRegTp
	 * @param payInfoDTO 支付信息
	 * @return
	 * @throws BizException
	 */
	@Override
	public RegInfoDTO[] priceAndRegist(String patId,RegInfoDTO[] regInfos,String chlTpCode,String regTp,
			PayInfoDTO payInfoDTO) throws BizException{
		PriceAndRegistBP registBP = new PriceAndRegistBP();
		return registBP.exec(patId, regInfos, chlTpCode, regTp, payInfoDTO);
	}
	/**
	 * 患者注册
	 * @param patDTO 患者信息
	 * @param isSyncPatCa 是否同步患者分类
	 * @return
	 * @throws BizException
	 */
	@Override
	public OpRegPatDTO regPat(OpRegPatDTO patDTO, FBoolean isSyncPatCa) throws BizException{
		RegPatBP regBP = new RegPatBP();
		return regBP.regPat(patDTO, isSyncPatCa);
	}
	/**
	 * 修改挂号的医保
	 * @param regInfo 挂号信息
	 * @param payInfo 支付信息
	 * @throws BizException
	 */
	@Override
	public RegInfoDTO changeOpRegHp(RegInfoDTO regInfo,PayInfoDTO payInfo) throws BizException{
		ChangeOpRegHpBP changeBP = new ChangeOpRegHpBP();
		return changeBP.exec(regInfo, payInfo);
	}
	/**
	 * 取消挂号
	 * @param regInfo 
	 * @throws BizException
	 */
	@Override
	public FArrayList cancReg(RegInfoDTO regInfo) throws BizException{
//		CancOpRegBP cancRegBP = new CancOpRegBP();
//		cancRegBP.exec(regInfo.getId_ent(),regInfo.getId_apt(),EuDrawTickMod.REVOKE);	
		CancOpRegNewBp cancRegHpBp = new CancOpRegNewBp();
		return cancRegHpBp.exec(regInfo, EuDrawTickMod.REVOKE);
	}
	/**
	 * 退号
	 * @param regInfo 挂号信息
	 * @param payInfo 退费信息
	 * @throws BizException
	 */
	@Override
	public FArrayList cancOpReg(RegInfoDTO regInfo,PayInfoDTO payInfo) throws BizException{
		CancOpRegWithCostBP cancRegBP = new CancOpRegWithCostBP();
		return cancRegBP.exec(regInfo, payInfo);
	}
	/**
	 * 根据就诊ID进行退号
	 * @param entId 就诊ID
	 * @throws BizException
	 * @author yank
	 */
	@Override
	public void cancRegByEntId(String entId) throws BizException{
		CancOpRegByEntIdBP cancRegBP = new CancOpRegByEntIdBP();
		cancRegBP.exec(entId);
	}
	/**
	 * 重新结算（退费+结算）
	 * @param regInfo 挂号信息
	 * @throws BizException
	 */
	@Override
	public RegInfoDTO resettle(RegInfoDTO regInfo) throws BizException{
		ResettleBP resettleBP = new ResettleBP();
		return resettleBP.exec(regInfo);
	}
	/**
	 * 诊毕
	 * @param entId 就诊id
	 * @param gowhereId 去向id
	 * @param gowhereSd 去向编码
	 * @throws BizException
	 */
	@Override
	public void diagnoseFinish(String entId, String gowhereId, String gowhereSd) throws BizException {		
		DiagEndBP diagEndBP = new DiagEndBP();
		diagEndBP.exec(entId, gowhereId, gowhereSd,FBoolean.FALSE);
	}
	/**
	 * 待回诊
	 * @param entId 就诊id
	 * @throws BizException
	 */
	@Override
	public void diagnoseContinue(String entId) throws BizException {
		DiagEndBP diagEndBP = new DiagEndBP();
		diagEndBP.exec(entId, null, null,FBoolean.TRUE);;
	}
	/**
	 * 保存门诊基本信息
	 * @param opBasicDTO 门诊基本信息
	 * @throws BizException
	 */
	@Override
	public void saveOpBasicInfo(OpBasic4EditDTO opBasicDTO) throws BizException{
		SaveOpBasicInfoBP saveBP = new SaveOpBasicInfoBP();
		saveBP.exec(opBasicDTO);
	}
	/**
	 * 保存代办人信息
	 * @param opBasicDTO 门诊基本信息
	 * @throws BizException
	 */
	@Override
	public void saveOpAgent(OpBasic4EditDTO opBasicDTO) throws BizException{
		SaveOpAgentBP saveBP = new SaveOpAgentBP();
		saveBP.exec(opBasicDTO);
	}
	/**
	 * 后台挂号记账
	 * 
	 * @param regInfo
	 * @return
	 * @throws BizException
	 */
	@Override
	public String registAccount(RegInfoDTO regInfo)
			throws BizException {
		AccountBP bp = new AccountBP();
		return bp.exec(regInfo);
	}
	/**
	 * 保存号条打印机
	 * @param printerName
	 * @return
	 */
	@Override
	public FBoolean saveReportPrinter(String printerName) throws BizException {
		EnPrnPrinterBP bp = new EnPrnPrinterBP();
		return bp.SaveReportPrinter(printerName);
	}
	/***
	 * @Description:门诊排班锁号
	 * @param reginfo
	 * @return
	 * @throws BizException
	 */
	@Override
	public LockResultDTO lockSchOp(RegInfoDTO reginfo) throws BizException{
		return new LockSchOpBP().exec(reginfo);
	}
	/***
	 * @Description:门诊排班锁号
	 * @param reginfo
	 * @return
	 * @throws BizException
	 */
	@Override
	public String releaseLockSchOp(String id_schlock) throws BizException{
		return ServiceFinder.find(IScSchOutCmdService.class).unlockSchOp(id_schlock);
	}
	
	/**
     * 设置VIP
     * 
     * @param entId
     */
	@Override
	public RegListDTO setUpVip(String entId, String reason) throws BizException {
		SetUpVipBP bp = new SetUpVipBP();
		RegListDTO result = bp.exec(entId, reason);
		return result;
	}
    /**
     * 取消VIP
     * 
     * @param entId
     */
	@Override
	public RegListDTO cancVip(String entId) throws BizException {
		CancVipBP bp = new CancVipBP();
		RegListDTO result = bp.exec(entId);
		return result;
	}
	
}
