package iih.ei.std.s.v1.bp.sc;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.ei.std.d.v1.sc.cancmtapt.d.CancMtAptDTO;
import iih.ei.std.d.v1.sc.cancmtapt.d.CancMtAptParamDTO;
import iih.ei.std.d.v1.sc.cancmtapt.d.CancMtAptResultDTO;
import iih.ei.std.s.v1.bp.IIHServiceBaseBP;
import iih.sc.apt.dto.d.MtAppDTO;
import iih.sc.apt.i.IScAptCmdService;
import iih.sc.apt.scapt.d.ScAptDO;
import iih.sc.apt.scapt.i.IScaptMDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class CancMtAptBP extends IIHServiceBaseBP<CancMtAptParamDTO, CancMtAptResultDTO> {

	private static final String String = null;

	@Override
	protected void checkParam(CancMtAptParamDTO param) throws BizException {
		validData(param.getId_apt(), param.getCode_pat(), param.getType_chl(), param.getCode_opr());
	}

	@SuppressWarnings("unchecked")
	@Override
	protected CancMtAptResultDTO process(CancMtAptParamDTO param) throws BizException {
		CancMtAptResultDTO resultDTO = new CancMtAptResultDTO();
		CancMtAptDTO aptDTO = new CancMtAptDTO();
		FArrayList fArrayList = new FArrayList();
		try {
			getResult(param.getId_apt(), param.getCode_pat(), param.getType_chl(), param.getCode_opr());
			aptDTO.setCode("0");
		} catch (Exception e) {
			aptDTO.setCode("1");
			aptDTO.setMsg(e.getMessage());
		}
		fArrayList.add(aptDTO);
		resultDTO.setCancmtaptdto(fArrayList);
		return resultDTO;
	}

	/**
	 * 取消预约
	 * 
	 * @param idApt
	 * @param patCode
	 * @param chlType
	 * @param oprCode
	 * @throws BizException
	 */
	private void getResult(String idApt, String patCode, String chlType, String oprCode) throws BizException {
		// 查询预约记录 并校验预约数据
		ScAptDO aptDO = this.getScApt(idApt, patCode, chlType);

		// 取消预约
		IScAptCmdService cmdService = ServiceFinder.find(IScAptCmdService.class);
		MtAppDTO appdto = new MtAppDTO();
		appdto.setId_apt(aptDO.getId_apt());
		StringBuilder sqlQry = new StringBuilder();
		sqlQry.append("select id_aptappl from sc_apt_appl where id_scapt =?");
		SqlParam param = new SqlParam();
		param.addParam(aptDO.getId_apt());
		String id_apt_appl = (String) new DAFacade().execQuery(sqlQry.toString(), param, new ColumnHandler());
		appdto.setId_apt_appl(id_apt_appl);
		cmdService.cancelMtApt(appdto);
	}

	/**
	 * 查询预约记录
	 * 
	 * @param idApt
	 * @return
	 * @throws BizException
	 */
	private ScAptDO getScApt(String idApt, String patCode, String chlType) throws BizException {
		IScaptMDORService aptRService = ServiceFinder.find(IScaptMDORService.class);
		ScAptDO aptDO = aptRService.findById(idApt);
		if (aptDO == null) {
			throw new BizException("取消预约失败:没找到对应预约记录!idApt=" + idApt + ",patCode=" + patCode + ",chlType=" + chlType);
		}
		if (FBoolean.TRUE.equals(aptDO.getFg_canc())) {
			throw new BizException("取消预约失败:预约记录已经取消,不能多次取消!");
		}
		if (IScDictCodeConst.SD_APTSTATUS_FINISH.equals(aptDO.getSd_status())) {
			throw new BizException("取消预约失败:预约已经完成,不能取消预约!");
		}
		// 校验 患者编码
		StringBuilder sql1 = new StringBuilder();
		sql1.append("select code from pi_pat where id_pat = ?");
		SqlParam param1 = new SqlParam();
		param1.addParam(aptDO.getId_pat());
		String code_pat = (String) new DAFacade().execQuery(sql1.toString(), param1, new ColumnHandler());
		if (StringUtil.isEmpty(code_pat)) {
			throw new BizException("取消预约失败:未找到患者信息!");
		}
		if (!code_pat.equals(patCode)) {
			throw new BizException("取消预约失败:患者同预约记录不一致!");
		}
		// 校验渠道
		StringBuilder sql2 = new StringBuilder();
		SqlParam param2 = new SqlParam();
		sql2.append("select chl.sd_scchltp from sc_chl chl where chl.id_scchl = ?");
		param2.addParam(aptDO.getId_scchl());
		String code_chl = (String) new DAFacade().execQuery(sql2.toString(), param2, new ColumnHandler());
		if (StringUtil.isEmpty(code_chl)) {
			throw new BizException("取消预约失败:未找到渠道信息!");
		}
		if (!code_chl.equals(chlType)) {
			throw new BizException("取消预约失败:只能取消预约本渠道预约的申请，原预约渠道：" + code_chl);
		}
		return aptDO;
	}

	/**
	 * 校验数据
	 * 
	 * @param idApt
	 * @param patCode
	 * @param chlType
	 * @param oprCode
	 * @throws BizException
	 */
	private void validData(String idApt, String patCode, String chlType, String oprCode) throws BizException {
		if (StringUtil.isEmpty(idApt)) {
			throw new BizException("取消预约失败:预约记录id为空!");
		}
		if (StringUtil.isEmpty(patCode)) {
			throw new BizException("取消预约失败:患者编码为空!");
		}
		if (StringUtil.isEmpty(chlType)) {
			throw new BizException("取消预约失败:渠道类型为空!");
		}
		if (StringUtil.isEmpty(oprCode)) {
			throw new BizException("取消预约失败:操作员为空!");
		}
	}

}
