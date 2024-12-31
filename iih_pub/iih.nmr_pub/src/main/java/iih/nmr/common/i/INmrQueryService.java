package iih.nmr.common.i;

import iih.bd.srv.nurmrtpl.d.NurMrConTplDO;
import iih.nmr.common.dto.d.CiMrVsItmDTO;
import iih.nmr.pkuf.nmrdocitmrcd.d.NmrCollRecordDO;
import iih.nmr.pkuf.regformfordeliver.d.RegformfordeliverAggDO;

import java.util.Map;
import java.util.List;

import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.sys.xbd.udi.d.UdidocDO;
import iih.mkr.std.commonde.d.DataElementDO;

public interface INmrQueryService {

	/**
	 * 实例化护理文书实体，赋初始值
	 * 
	 * @return
	 * @throws BizException
	 */
	public abstract FArrayList initData(String id_ent, String fullClassName) throws BizException;

	/**
	 * 实例化护理文书实体，赋初始值
	 * 
	 * @return
	 * @throws BizException
	 */
	public abstract FArrayList initDatas(String id_ent, String id_set,String fullClassName) throws BizException;
	
	
	/**
	 * 初始化患者基本信息
	 * 
	 * @return
	 * @throws BizException
	 */
	public abstract Map<String, Object> initPatInfo(String id_ent, String id_set,Boolean isRefresh) throws BizException;

	/**
	 * 根据节气名称返回字典信息
	 * 
	 * @param name
	 * @return
	 * @throws BizException
	 */
	public abstract UdidocDO getSolarTermsInfo(String name) throws BizException;

	/**
	 * 获取护理护理内容模板内容
	 * 
	 * @return
	 * @throws BizException
	 */
	public abstract NurMrConTplDO[] getMrContpls() throws BizException;

	/**
	 * 刷新和编辑时刷新患者的数据
	 * 
	 * @param baseDO
	 * @return
	 * @throws BizException
	 */
	public FArrayList refreshData(BaseDO baseDO) throws BizException;

	/**
	 * 评分结果匹配
	 * 
	 * @param id_ent
	 * @param fullClassName
	 * @return
	 * @throws BizException
	 */
	public UdidocDO calculateResult(FDouble score, String code_udidoc, FBoolean fg_left_close, FBoolean fg_right_close) throws BizException;

	/***
	 * 根据主键获取AggDO信息
	 * @param id_regform
	 * @return
	 * @throws BizException
	 */
	public RegformfordeliverAggDO getRegformAggDO(String id_regform) throws BizException;
	
	/**
	 * 获取文书审核记录
	 * @param id_nu
	 * @return
	 */
	public NmrCollRecordDO[] getNmrCheckList(String id_nu)  throws BizException;
	
	/**
	 * 获取NewObject信息
	 * @param basenmrDO
	 * @param id_ent
	 * @param func_code
	 * @return
	 * @throws BizException
	 */
	public abstract Map<String, Object> getNewObjectInfo(String fullClassName,String id_ent,String func_code) throws BizException;
	
	/**
	 * 获取患者就诊信息
	 * @param basenmrDO
	 * @param id_ent
	 * @param func_code
	 * @return
	 * @throws BizException
	 */
	public abstract Map<String, Object> GetPatEntInfo(String id_ent) throws BizException;
	
	/**
	 * 获取患者体征信息
	 * @return
	 * @throws BizException
	 */
	public abstract CiMrVsItmDTO[] getNmrVsDatas(String id_ent)throws BizException;
		
	/**
	 * 获取数据元字段英文字符
	 * @return Map<String, String>
	 * @throws BizException
	 */
	public DataElementDO[] getTransCloum(String appId,String appKey,DataElementDO[] plist) throws BizException;
	
}
