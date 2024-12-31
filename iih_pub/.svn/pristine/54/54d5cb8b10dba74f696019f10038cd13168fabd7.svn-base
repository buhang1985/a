package iih.ci.mrm.i.insidecommontree;

import xap.mw.core.data.BizException;
import iih.bd.srv.mrmtype.d.MrmTypeDO;
import iih.ci.mrm.cimrmfileinfo.d.CiMrmFileInfoDO;

public interface IMrmInsideCommonTreeService {

	/**
	 * 根据科室及就诊类型获取病案分类
	 * @param id_org
	 * @return
	 */
	public abstract MrmTypeDO[] getMrmTypeDOs(String id_dept,String code_entp)  throws BizException;
	
	/**
	 * 根据病案主键获取所有病案文件
	 * @param id_org
	 * @return
	 * @throws BizException 
	 */
	public abstract CiMrmFileInfoDO[] getCiMrmFileInfoDOs(String id_amr) throws BizException;
	
	/**
	 * 病历查看扫描文件
	 * @param id_ent
	 * @param id_mr
	 * @return
	 * @throws BizException
	 */
	public abstract CiMrmFileInfoDO[] getCiMrmFileInfoDOsForMr(String id_ent,String id_mr) throws BizException;
	
	/**
	 * 调整顺序
	 * @param ciMrmFileInfoDo1
	 * @param ciMrmFileInfoDo2
	 * @return
	 * @throws BizException
	 */
	public abstract Boolean changeIndex(CiMrmFileInfoDO ciMrmFileInfoDo1,CiMrmFileInfoDO ciMrmFileInfoDo2) throws BizException;
	
	/**
	 * 重命名
	 * @param id_amr
	 * @param id_bd_mrm_tp
	 * @param prefix
	 * @param hacNum
	 * @param numLength
	 * @return
	 * @throws BizException
	 */
	public abstract Boolean rename(String id_amr,String id_bd_mrm_tp, String prefix,Boolean hacNum,int numLength) throws BizException;
	
	/**
	 * 根据病案号重新整理文件名称
	 * @param id_amr
	 * @param code_amr
	 * @return
	 * @throws BizException
	 */
	public abstract Boolean sequenceArrange(String id_amr,String code_amr) throws BizException;
}
