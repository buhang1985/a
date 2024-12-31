package iih.en.ip.i;

import iih.en.ip.dto.d.EnHosRegInfoDTO;
import iih.en.ip.dto.d.EnIpDepInfoDTO;
import iih.en.ip.dto.d.RentInfoDTO;
import iih.en.ip2.dto.d.EnHpInfoDTO;
import iih.en.pv.enres.d.EnBedDO;
import iih.sc.apt.dto.d.AptIpDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;

/**
 * 住院查询服务2
 * 
 * @author liubin
 *
 */
public interface IEnIpQryService2 {
	/**
	 * EntipntDTO[] getIpntByEntId(String entId)
	 * 获取本次就诊的入院申请单
	 * @param entId 就诊id
	 * @return
	 * @throws BizException
	 */
    AptIpDTO getAptIpByEntId( String entId) throws BizException;
    
	/**
	 * getEntInfo4IpApt getEntInfo4IpApt(String entId)
	 * 没有申请单的时候获取本次就诊的就诊信息
	 * @param entId 就诊id
	 * @return
	 * @throws BizException
	 */
	 AptIpDTO getEntInfo4AptIp( String entId) throws BizException ;
	 
	 /**
	  * 未挂号，获取申请单患者信息
      * @author zhangpp
	  * @param patId
	  * @return
	  * @throws BizException
	  */
	 AptIpDTO getAptPatByPatId(String patId) throws BizException; 
	 
	 /**
	  * 未挂号，获取入院申请单
      * @author zhangpp
	  * @param aptIpId
	  * @return
	  * @throws BizException
	  */
	 AptIpDTO getAptIpNoEnt(String aptIpId) throws BizException;
	 
	 /**
	  * 获取患者的入院申请单
      * @author zhangpp
	  * @param patId
	  * @return
	  * @throws BizException
	  */
	 AptIpDTO[] getAptIpByPatId(String patId) throws BizException;
	 
	/**
	 * 入院登记(含注册)信息查询（新标）
	 * @param patId 患者ID
	 * @return
	 * @throws BizException
	 */
	EnHosRegInfoDTO getEnHosRegInfoDTO(String patId) throws BizException;

	/**
	 * 根据病区获取病区申请入科列表
	 * @param nurId 当前登录病区
	 * @throws BizException
	 */
	EnIpDepInfoDTO[] getEnDepList(String nurId) throws BizException;

	/**
	 * 获取包床列表
	 * @param entId 就诊id
	 * @return
	 * @throws BizException
	 */
	EnBedDO[] getRentBedList(String entId) throws BizException;
	
	/**
	 * 获取包床患者信息
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	RentInfoDTO getRentEntInfo(String entId) throws BizException;
	
	/***
	 * 查询医保交易记录 - li.wm
	 * @param patId
	 * @return
	 * @throws BizException
	 */
	PagingRtnData<EnHpInfoDTO> getEnHpInfo(String wherestr,PaginationInfo pg) throws BizException;	
}
