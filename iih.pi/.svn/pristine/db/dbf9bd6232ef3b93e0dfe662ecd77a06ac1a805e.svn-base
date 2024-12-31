package iih.pi.reg.s;

import iih.pi.reg.d.PiPatHpDTO;
import iih.pi.reg.i.IPiRegMaintainService;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PatiAggDO;
import iih.pi.reg.s.bp.CombinePatientBp;
import iih.pi.reg.s.bp.GetPatInfoByCodeFromEmpiBP;
import iih.pi.reg.s.bp.PiDeletePatientBp;
import iih.pi.reg.s.bp.PiPatInsertAmrCodeBP;
import iih.pi.reg.s.bp.PiPatRestoreCardBP;
import iih.pi.reg.s.bp.PiSavePatForHosRegBp;
import iih.pi.reg.s.bp.PiSavePatiHpBP;
import iih.pi.reg.s.bp.psw.PiPswResetBP;
import iih.pi.reg.s.customer.guoji.SyncPatiInfoFromChisByIdBP;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 患者维护服务
 * @author ly
 *
 */
public class PiRegMaintainServiceImpl implements IPiRegMaintainService {

	/**
	 * 登录患者医保数据
	 * 如果主医保不存在，则不处理
	 * @param piPatHpDto 医保数据
	 * @throws BizException
	 */
	@Override
	public void savePatiHpData(PiPatHpDTO piPatHpDto) throws BizException {
		PiSavePatiHpBP bp = new PiSavePatiHpBP();
		bp.exec(piPatHpDto);
	}

	/**
	 * 患者合并
	 * @param mainAggDo 主要患者do
	 * @param oldAggDo 被合并患者do
	 * @return 成功标识
	 * @throws BizException
	 */
	@Override
	public void combinePatient(PatDO mainDo, PatDO oldDo) throws BizException {
		CombinePatientBp bp =new CombinePatientBp();
		bp.exec(mainDo, oldDo);
	}
	
	/**
	 * 写入患者门诊病案编号
	 * @param patId 患者id
	 * @param oepAmrCode 门诊病案编号
	 * @return true:成功 false:失败
	 * @throws BizException
	 */
	@Override
	public FBoolean insertPatCodeAmrOep(String patId,String oepAmrCode) throws BizException{
		PiPatInsertAmrCodeBP bp = new PiPatInsertAmrCodeBP();
		return bp.exec(patId, oepAmrCode, true);
	}
	
	/**
	 * 写入患者住院病案编号
	 * @param patId 患者id
	 * @param ipAmrCode 住院病案编号
	 * @return true:成功 false:失败
	 * @throws BizException
	 */
	@Override
	public FBoolean insertPatCodeAmrIp(String patId,String ipAmrCode) throws BizException{
		PiPatInsertAmrCodeBP bp = new PiPatInsertAmrCodeBP();
		return bp.exec(patId, ipAmrCode, false);
	}
	
	/**
	 * 通过患者编码取得患者信息
	 * 本地库不存在时，会通过empi取得患者信息并同步到本地库中
	 * @param code 患者编码（对应empi的患者id）
	 * @return 患者aggdo （返回值为null时，表示empi及本地都查询不到该编码对应的数据）
	 * @throws BizException
	 */
	@Override
	public PatiAggDO getPatInfoByCodeFromEmpi(String code) throws BizException {
		GetPatInfoByCodeFromEmpiBP bp = new GetPatInfoByCodeFromEmpiBP();
		return bp.exec(code);
	}
	
	/**
	 * 入院登记专用患者信息保存
	 * @param aggDo 患者aggdo
	 * @return 患者aggdo
	 * @throws BizException
	 */
	@Override
	public PatiAggDO savePatForHosReg(PatiAggDO aggDo) throws BizException{
		PiSavePatForHosRegBp bp = new PiSavePatForHosRegBp();
		return bp.exec(aggDo);
	}
	
	/**
	 * 删除患者
	 * @param patID 患者id
	 * @throws BizException
	 */
	@Override
	public void deletePatient(String patID) throws BizException{
		PiDeletePatientBp bp = new PiDeletePatientBp();
		bp.exec(patID);
	}
	
	/**
	 * 重置患者密码
	 * @param patId
	 * @param pwd
	 * @throws BizException
	 */
	@Override
	public void resetPatPassword(String patId,String pwd) throws BizException{
		PiPswResetBP bp = new PiPswResetBP();
		bp.exec(patId, pwd);
	}
	
	/**
	 * 从chis同步患者数据
	 * @param codePat 患者编码
	 * @return 
	 * @throws BizException
	 */
	@Override
	public PatiAggDO syncFromChis(String codePat) throws BizException{
		SyncPatiInfoFromChisByIdBP bp = new SyncPatiInfoFromChisByIdBP();
		return bp.exec(codePat);
	}
	
	/**
	 * 还原患者卡
	 * 用于发卡未收费的场景，把卡还原到空白状态
	 * @param patCardIds 患者卡id
	 * @throws BizException
	 * @author ly 2018/08/22
	 */
	@Override
	public void restorePatCard(String[] patCardIds) throws BizException{
		PiPatRestoreCardBP bp = new PiPatRestoreCardBP();
		bp.exec(patCardIds);
	}
}
