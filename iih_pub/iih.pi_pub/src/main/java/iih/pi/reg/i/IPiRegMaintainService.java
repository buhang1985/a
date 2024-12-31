package iih.pi.reg.i;

import iih.pi.reg.d.PiPatHpDTO;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PatiAggDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 患者维护服务
 * @author ly
 */
public interface IPiRegMaintainService {

	/**
	 * 登录患者医保数据
	 * 如果主医保不存在，则不处理
	 * @param piPatHpDto 医保数据
	 * @throws BizException
	 */
	public void savePatiHpData(PiPatHpDTO piPatHpDto) throws BizException;
	
	/**
	 * 患者合并
	 * @param mainDo 主要患者do
	 * @param oldDo 就患者do
	 * @return 成功标识
	 * @throws BizException
	 */
	public void combinePatient(PatDO mainDo, PatDO oldDo) throws BizException;
	
	/**
	 * 写入患者门诊病案编号
	 * @param patId 患者id
	 * @param oepAmrCode 门诊病案编号
	 * @return true:成功 false:失败
	 * @throws BizException
	 */
	public abstract FBoolean insertPatCodeAmrOep(String patId,String oepAmrCode) throws BizException;
	
	/**
	 * 写入患者住院病案编号
	 * @param patId 患者id
	 * @param ipAmrCode 住院病案编号
	 * @return true:成功 false:失败
	 * @throws BizException
	 */
	public abstract FBoolean insertPatCodeAmrIp(String patId,String ipAmrCode) throws BizException;
	
	/**
	 * 通过患者编码取得患者信息
	 * 本地库不存在时，会通过empi取得患者信息并同步到本地库中
	 * @param code 患者编码（对应empi的患者id）
	 * @return 患者aggdo （返回值为null时，表示empi及本地都查询不到该编码对应的数据）
	 * @throws BizException 患者已经失效
	 */
	public abstract PatiAggDO getPatInfoByCodeFromEmpi(String code) throws BizException;
	
	/**
	 * 入院登记专用患者信息保存
	 * @param aggDo 患者aggdo
	 * @return 患者aggdo
	 * @throws BizException
	 */
	public abstract PatiAggDO savePatForHosReg(PatiAggDO aggDo) throws BizException;
	
	/**
	 * 删除患者
	 * @param patID 患者id
	 * @throws BizException
	 */
	public abstract void deletePatient(String patID) throws BizException;
	
	/**
	 * 重置患者密码
	 * @param patId
	 * @param pwd
	 * @throws BizException
	 */
	public abstract void resetPatPassword(String patId,String pwd) throws BizException;
	
	/**
	 * 从chis同步患者数据
	 * @param codePat 患者编码
	 * @return 
	 * @throws BizException
	 */
	public abstract PatiAggDO syncFromChis(String codePat) throws BizException;

	/**
	 * 还原患者卡
	 * 用于发卡未收费的场景，把卡还原到空白状态
	 * @param patCardIds 患者卡id
	 * @throws BizException
	 * @author ly 2018/08/22
	 */
	public abstract void restorePatCard(String[] patCardIds) throws BizException;
}
