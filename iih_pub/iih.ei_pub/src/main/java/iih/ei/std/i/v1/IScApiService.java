package iih.ei.std.i.v1;

import iih.ei.std.d.v1.sc.cancmtapt.d.CancMtAptParamDTO;
import iih.ei.std.d.v1.sc.cancmtapt.d.CancMtAptResultDTO;
import iih.ei.std.d.v1.sc.mtaptnonord.d.MtAptNonOrdParamDTO;
import iih.ei.std.d.v1.sc.mtaptnonord.d.MtAptNonOrdResultDTO;
import iih.ei.std.d.v1.sc.mtaptnoterpt.d.MtAptNoteRptParamDTO;
import iih.ei.std.d.v1.sc.mtaptnoterpt.d.MtAptNoteRptResultDTO;
import iih.ei.std.d.v1.sc.mtbrokenapt.d.MtBrokenAptParamDTO;
import iih.ei.std.d.v1.sc.mtbrokenapt.d.MtBrokenAptResultDTO;
import iih.ei.std.d.v1.sc.mtpataptbyidapt.d.MtPatAptByIdAptParamDTO;
import iih.ei.std.d.v1.sc.mtpataptbyidapt.d.MtPatAptByIdAptResultDTO;
import iih.ei.std.d.v1.sc.mtpataptlist.d.MtPatAptListParamDTO;
import iih.ei.std.d.v1.sc.mtpataptlist.d.MtPatAptListResultDTO;
import iih.ei.std.d.v1.sc.mtscca.d.MtScCaParamDTO;
import iih.ei.std.d.v1.sc.mtscca.d.MtScCaResultDTO;
import iih.ei.std.d.v1.sc.mtscdbsrv.d.MtScDbSrvParamDTO;
import iih.ei.std.d.v1.sc.mtscdbsrv.d.MtScDbSrvResultDTO;
import iih.ei.std.d.v1.sc.mtschlist.d.MtSchListParamDTO;
import iih.ei.std.d.v1.sc.mtschlist.d.MtSchListResultDTO;
import iih.ei.std.d.v1.sc.mtstopsch.d.MtStopSchParamDTO;
import iih.ei.std.d.v1.sc.mtstopsch.d.MtStopSchResultDTO;
import xap.mw.core.data.BizException;

/**
 * 预约标准对外接口
 * @author lilei
 *
 */
public interface IScApiService {
	
	/**
	 * 取医技项目分类字典
	 * @param param
	 * @return
	 * @throws BizException 
	 */
	public MtScCaResultDTO getMtScCa(MtScCaParamDTO mtScCaParamDTO) throws BizException;
	
	/**
	 * 取医技诊疗项目字典
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public MtScDbSrvResultDTO getMtScDbSrv(MtScDbSrvParamDTO param) throws BizException;
	
	/**
	 * 获取医技排班列表
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public MtSchListResultDTO getMtSchList(MtSchListParamDTO param) throws BizException;
	
	/**
	 * 医技预约(无申请单)
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public MtAptNonOrdResultDTO makeMtAptNonOrd(MtAptNonOrdParamDTO param) throws BizException;
	
	/**
	 * 取消预约
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public CancMtAptResultDTO cancMtApt(CancMtAptParamDTO param) throws BizException;
	
	/**
	 * 获取患者医技预约记录
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public MtPatAptListResultDTO getMtPatAptList(MtPatAptListParamDTO param) throws BizException;
	
	/**
	 * 获取患者医技预约记录
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public MtPatAptByIdAptResultDTO getMtPatAptByIdApt(MtPatAptByIdAptParamDTO param) throws BizException;
	
	/**
	 * 获取患者爽约记录
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public MtBrokenAptResultDTO getMtBrokenAptList(MtBrokenAptParamDTO param) throws BizException;
	/**
	 * 获取医技停诊列表
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public MtStopSchResultDTO getMtStopSchList(MtStopSchParamDTO param) throws BizException;
	
	/**
	 * 取医技预约告知单
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public MtAptNoteRptResultDTO getMtAptNoteRpt(MtAptNoteRptParamDTO param) throws BizException;
	
}
