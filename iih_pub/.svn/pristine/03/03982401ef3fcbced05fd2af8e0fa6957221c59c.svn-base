package iih.mp.dg.i;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 和第三方软件交互的服务
 * @author ly
 *
 */
public interface IMpDgInteractiveService {
	
//	/**
//	 * 中间表查询测试
//	 * @throws BizException
//	 */
//	public abstract void middleTableQueryTest() throws BizException;
//
//	/**
//	 * 患者处方签到分窗口
//	 * @return
//	 * @throws BizException
//	 */
//	public abstract OpPresQueSiteDTO[] patSigninWithPres(String code_pat) throws BizException;
//	
//	/**
//	 * 扫描患者处方后亮灯(门诊摆药机)
//	 * @param patientId 患者id
//	 * @param wicket 窗口号
//	 * @throws BizException
//	 */
//	public abstract void synMzPatient(String patientId,String wicket) throws BizException;
	
	/**
	 * 住院包药机包药
	 * 
	 * @param dgIpDeIds
	 * @return
	 */
	public abstract void collocateDrug(String[] dgIpDeIds, FBoolean fg_recollocate) throws BizException;
}
