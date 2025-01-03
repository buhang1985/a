package iih.pis.ivx.ent.i;

import java.util.Map;

import iih.en.pv.appoint.bean.EntListByPatcodeParam;
import iih.en.pv.appoint.result.EntListByPatcodeResult;
import iih.pis.ivx.pisivxent.d.PisivxEntDO;
import xap.mw.core.data.BizException;

/**
 * 功能说明:微信就诊记录服务
 * @author admin
 *
 */
public interface IEntService {
	
	/**
	 * 查询就诊记录
	 * @param patCode
	 * @param dtBegin
	 * @param dtEnd
	 * @param entpCode
	 * @return
	 * @throws BizException
	 */
	public EntListByPatcodeResult[] searchEnt(EntListByPatcodeParam entListByPatcodeParam) throws BizException;
	
	/**
	 * 功能描述:通过微信就诊人id获取就诊人记录
	 * @param id_pisivxmember
	 * @return
	 */
	public Map<String, Object> searchPisIvxEntByMember(String id_pisivxmember) throws BizException;
	
	/**
	 * 对比向pis_ivx_ent表插入不重复的数据
	 * @param id_pisivxaccount
	 * @param id_pisivxmember
	 * @param entListByPatcodeResults
	 * @throws BizException
	 */
	public PisivxEntDO[] contrastAndInsert(String id_pisivxaccount,String id_pisivxmember,EntListByPatcodeResult[] entListByPatcodeResults) throws BizException;

}
