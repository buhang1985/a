package iih.en.ip.s;

import iih.en.ip.dto.d.EnHosRegInfoDTO;
import iih.en.ip.dto.d.EnIpDepInfoDTO;
import iih.en.ip.dto.d.RentInfoDTO;
import iih.en.ip.i.IEnIpQryService2;
import iih.en.ip.s.bp.GetEnHpInfoDTOBP;
import iih.en.ip.s.bp.qry.EntBedEP;
import iih.en.ip.s.bp.qry.GetAptIpByEntIdBP;
import iih.en.ip.s.bp.qry.GetAptIpByPatIdBP;
import iih.en.ip.s.bp.qry.GetEnIpDepInfoDTOBP2;
import iih.en.ip.s.bp.qry.GetRentEntInfoBP;
import iih.en.ip.s.qry.GetEnHosRegInfoBP2;
import iih.en.ip2.dto.d.EnHpInfoDTO;
import iih.en.pv.enres.d.EnBedDO;
import iih.sc.apt.dto.d.AptIpDTO;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;

/**
 * 住院查询服务2
 * 
 * @author liubin
 *
 */
@Service(serviceInterfaces={IEnIpQryService2.class}, binding=Binding.JSONRPC)
public class EnIpQryService2Impl implements IEnIpQryService2 {
	/**
	 * EntipntDTO[] getIpntByEntId(String entId)
	 * 获取本次就诊的入院申请单
	 * @param entId 就诊id
	 * @return
	 * @throws BizException
	 */
	@Override
	public AptIpDTO getAptIpByEntId( String entId) throws BizException {
		GetAptIpByEntIdBP enipntBP = new GetAptIpByEntIdBP();
		return enipntBP.exec(entId);
	}
	/**
	 * getEntInfo4IpApt getEntInfo4IpApt(String entId)
	 * 获取本次就诊的就诊信息
	 * @param entId 就诊id
	 * @return
	 * @throws BizException
	 */
	@Override
	public AptIpDTO getEntInfo4AptIp( String entId) throws BizException {
		GetAptIpByEntIdBP enipntBP = new GetAptIpByEntIdBP();
		return enipntBP.getEntInfo(entId);
	}
	/**
	 * 未挂号，获取申请单患者信息
	 * @param patId
	 * @return
	 * @throws BizException
	 */
	@Override
	public AptIpDTO getAptPatByPatId(String patId) throws BizException {
		GetAptIpByEntIdBP bp = new GetAptIpByEntIdBP();
		return bp.getPatInfo(patId);
	}
	/**
	 * 未挂号，获取入院申请单
	 * @param aptIpId
	 * @return
	 * @throws BizException
	 */
	@Override
	public AptIpDTO getAptIpNoEnt(String aptIpId) throws BizException {
		GetAptIpByEntIdBP bp = new GetAptIpByEntIdBP();
		return bp.getAptIpNoEnt(aptIpId);
	}
	/**
	 * 获取患者的入院申请单
	 * @param patId
	 * @return
	 * @throws BizException
	 */
	@Override
	public AptIpDTO[] getAptIpByPatId(String patId) throws BizException {
		GetAptIpByPatIdBP bp = new GetAptIpByPatIdBP();
		return bp.exec(patId);
	}
	/**
	 * 入院登记(含注册)信息查询（2.0）
	 * @author tang.ht
	 * @param patId
	 * @throws BizException
	 */
	@Override
	public EnHosRegInfoDTO getEnHosRegInfoDTO(String patId) throws BizException {
		// TODO Auto-generated method stub
		GetEnHosRegInfoBP2 bp = new GetEnHosRegInfoBP2();
		return bp.exec(patId);
		
	}

	/**
	 * 根据病区获取病区申请入科列表
	 * @param nurId 当前登录病区
	 * @throws BizException
	 */
	@Override
	public EnIpDepInfoDTO[] getEnDepList(String nurId) throws BizException {
		GetEnIpDepInfoDTOBP2 bp = new GetEnIpDepInfoDTOBP2();
		return bp.exec(nurId);
	}
	
	/**
	 * 获取包床列表
	 * 
	 * @param entId 就诊id
	 * @return
	 * @throws BizException
	 */
	@Override
	public EnBedDO[] getRentBedList(String entId) throws BizException {
		EntBedEP enBedEP = new EntBedEP();
		return enBedEP.getRentBedList(entId);
	}
	
	/**
	 * 获取包床患者信息
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	@Override
	public RentInfoDTO getRentEntInfo(String entId) throws BizException {
		GetRentEntInfoBP bp = new GetRentEntInfoBP();
		return bp.exec(entId);
	}
	/***
	 * 查询医保交易记录 - li.wm
	 * @param patId
	 * @return
	 * @throws BizException
	 */
	@Override
	public  PagingRtnData<EnHpInfoDTO> getEnHpInfo(String wherestr,PaginationInfo pg) throws BizException{
		GetEnHpInfoDTOBP bp = new GetEnHpInfoDTOBP();
		return bp.exec(wherestr, pg);
	}

	
}
