package iih.ei.std.s.v1;

import iih.ei.std.d.v1.commdto.d.NoParamDTO;
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
import iih.ei.std.i.v1.IScApiService;
import iih.ei.std.s.v1.bp.sc.CancMtAptBP;
import iih.ei.std.s.v1.bp.sc.GetMtAptNoteRptBP;
import iih.ei.std.s.v1.bp.sc.GetMtBrokenAptListBP;
import iih.ei.std.s.v1.bp.sc.GetMtPatAptByIdAptBP;
import iih.ei.std.s.v1.bp.sc.GetMtPatAptListBP;
import iih.ei.std.s.v1.bp.sc.GetMtScCaListBP;
import iih.ei.std.s.v1.bp.sc.GetMtScDbSrvListBP;
import iih.ei.std.s.v1.bp.sc.GetMtSchListBP;
import iih.ei.std.s.v1.bp.sc.GetMtStopSchListBP;
import iih.ei.std.s.v1.bp.sc.MakeAptNonOrdBP;
import xap.mw.core.data.BizException;

public class ScApiServiceImpl implements IScApiService {

	/**
	 * 取医技项目分类字典
	 * @throws BizException 
	 */
	@Override
	public MtScCaResultDTO getMtScCa(MtScCaParamDTO mtScCaParamDTO) throws BizException {
		return new GetMtScCaListBP().exec(mtScCaParamDTO);
	}

	/**
	 * 取医技诊疗项目字典
	 */
	@Override
	public MtScDbSrvResultDTO getMtScDbSrv(MtScDbSrvParamDTO param) throws BizException {
		return new GetMtScDbSrvListBP().exec(param);
	}

	/**
	 * 获取医技排班列表
	 */
	@Override
	public MtSchListResultDTO getMtSchList(MtSchListParamDTO param) throws BizException {
		return new GetMtSchListBP().exec(param);
	}

	/**
	 * 医技预约(无申请单)
	 */
	@Override
	public MtAptNonOrdResultDTO makeMtAptNonOrd(MtAptNonOrdParamDTO param) throws BizException {
		return new MakeAptNonOrdBP().exec(param);
	}

	/**
	 * 取消预约
	 */
	@Override
	public CancMtAptResultDTO cancMtApt(CancMtAptParamDTO param) throws BizException {
		return new CancMtAptBP().exec(param);
	}

	/**
	 * 获取患者医技预约记录
	 */
	@Override
	public MtPatAptListResultDTO getMtPatAptList(MtPatAptListParamDTO param) throws BizException {
		return new GetMtPatAptListBP().exec(param);
	}

	/**
	 * 获取患者医技预约记录
	 */
	@Override
	public MtPatAptByIdAptResultDTO getMtPatAptByIdApt(MtPatAptByIdAptParamDTO param) throws BizException {
		return new GetMtPatAptByIdAptBP().exec(param);
	}

	/**
	 * 获取患者爽约记录
	 */
	@Override
	public MtBrokenAptResultDTO getMtBrokenAptList(MtBrokenAptParamDTO param) throws BizException {
		return new GetMtBrokenAptListBP().exec(param);
	}

	/**
	 * 获取医技停诊列表
	 */
	@Override
	public MtStopSchResultDTO getMtStopSchList(MtStopSchParamDTO param) throws BizException {
		return new GetMtStopSchListBP().exec(param);
	}

	/**
	 * 取医技预约告知单
	 */
	@Override
	public MtAptNoteRptResultDTO getMtAptNoteRpt(MtAptNoteRptParamDTO param) throws BizException {
		return new GetMtAptNoteRptBP().exec(param);
	}
	
	
	
}
