package iih.en.pv.i;

import iih.en.pv.outpatient.dto.d.OpBasic4EditDTO;
import iih.en.pv.outpatient.dto.d.OpRegPatDTO;
import iih.en.pv.outpatient.dto.d.PayInfoDTO;
import iih.en.pv.outpatient.dto.d.RegInfoDTO;
import iih.en.pv.outpatient.dto.d.RegListDTO;
import iih.sc.sch.dto.d.LockResultDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;

/**
 * 门诊服务
 * @author yank
 *
 */
public interface IEnOpCmdService {
	/**
	 * 划价
	 * @param regInfo 挂号信息
	 * @param fgAcc 只记账标志
	 * @param fgPrint 是否打印发票
	 * @return
	 * @throws BizException
	 */	
	RegInfoDTO pricing(RegInfoDTO regInfo,FBoolean fgAcc,FBoolean fgPrint) throws BizException;
	/**
	 * 挂号
	 * @param patId 患者id
	 * @param regInfos 挂号信息
	 * @param payInfoDTO 支付信息
	 * @return
	 * @throws BizException
	 */
	RegInfoDTO[] regist(String patId,RegInfoDTO[] regInfos,PayInfoDTO payInfoDTO) throws BizException;	
	/**
	 * 患者注册+挂号
	 * @param patDTO 患者信息
	 * @param regInfos 挂号信息
	 * @param payInfoDTO 支付信息
	 * @return
	 * @throws BizException
	 */
	RegInfoDTO[] regPatAndOp(OpRegPatDTO patDTO,RegInfoDTO[] regInfos,PayInfoDTO payInfoDTO) throws BizException;	
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
	RegInfoDTO[] priceAndRegist(String patId,RegInfoDTO[] regInfos,String chlTpCode,String regTp,
			PayInfoDTO payInfoDTO) throws BizException;	
	/**
	 * 患者注册
	 * @param patDTO 患者信息
	 * @param isSyncPatCa 是否同步患者分类
	 * @return
	 * @throws BizException
	 */
	OpRegPatDTO regPat(OpRegPatDTO patDTO, FBoolean isSyncPatCa) throws BizException;
	/**
	 * 修改挂号的医保
	 * @param regInfo 挂号信息
	 * @param payInfo 支付信息
	 * @throws BizException
	 */
	RegInfoDTO changeOpRegHp(RegInfoDTO regInfo,PayInfoDTO payInfo) throws BizException;
	/**
	 * 取消挂号
	 * @param regInfo 挂号信息
	 * @throws BizException
	 */
	@Deprecated
	FArrayList cancReg(RegInfoDTO regInfo) throws BizException;
	/**
	 * 退号
	 * @param regInfo 挂号信息
	 * @param payInfo 退费信息
	 * @throws BizException
	 */
	FArrayList cancOpReg(RegInfoDTO regInfo,PayInfoDTO payInfo) throws BizException;
	/**
	 * 根据就诊ID进行退号
	 * @param entId 就诊ID
	 * @throws BizException
	 * @author yank
	 */
	void cancRegByEntId(String entId) throws BizException;
	/**
	 * 重新结算（退费+结算）
	 * @param regInfo 挂号信息
	 * @throws BizException
	 */
	RegInfoDTO resettle(RegInfoDTO regInfo) throws BizException;
	/**
	 * 诊毕
	 * @param entId 就诊id
	 * @param gowhereId 去向id
	 * @param gowhereSd 去向编码
	 * @throws BizException
	 */
	void diagnoseFinish(String entId, String gowhereId, String gowhereSd) throws BizException;
	/**
	 * 待续诊
	 * @param entId 就诊id
	 * @param empId 操作人员
	 * @throws BizException
	 */
	void diagnoseContinue(String entId) throws BizException;
	/**
	 * 保存门诊基本信息
	 * @param opBasicDTO 门诊基本信息
	 * @throws BizException
	 */
	void saveOpBasicInfo(OpBasic4EditDTO opBasicDTO) throws BizException;	
	/**
	 * 保存代办人信息
	 * @param opBasicDTO 门诊基本信息
	 * @throws BizException
	 */
	void saveOpAgent(OpBasic4EditDTO opBasicDTO) throws BizException;
	/**
	 * 后台挂号记账
	 * 
	 * @param regInfo
	 * @return
	 * @throws BizException
	 */
	String registAccount(RegInfoDTO regInfo)throws BizException;
	/***
	 * 保存打印机设置，2018-06-25
	 * @param printerName
	 * @return
	 * @throws BizException
	 */
	FBoolean saveReportPrinter(String printerName) throws BizException;
	/***
	 * @Description:门诊排班锁号
	 * @param reginfo
	 * @return
	 * @throws BizException
	 */
	LockResultDTO lockSchOp(RegInfoDTO reginfo) throws BizException;
	/***
	 * @Description:门诊排班释放锁
	 * @param id_schlock
	 * @return
	 * @throws BizException
	 */
	String releaseLockSchOp(String id_schlock) throws BizException;
	
	 /**
     * 设置VIP
     * 
     * @param entId
     */
	RegListDTO setUpVip(String entId, String reason) throws BizException;
    /**
     * 取消VIP
     * 
     * @param entId
     */
	RegListDTO cancVip(String entId) throws BizException;
	
}
