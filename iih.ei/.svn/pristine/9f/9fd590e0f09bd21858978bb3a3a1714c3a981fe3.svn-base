package iih.ei.std.s.v1.bp.sc;

import java.util.List;

import iih.bd.base.utils.ArrayListUtil;
import iih.ei.std.d.v1.sc.mtbrokenapt.d.MtBrokenAptDTO;
import iih.ei.std.d.v1.sc.mtbrokenapt.d.MtBrokenAptParamDTO;
import iih.ei.std.d.v1.sc.mtbrokenapt.d.MtBrokenAptResultDTO;
import iih.ei.std.s.v1.bp.IIHServiceBaseBP;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class GetMtBrokenAptListBP extends IIHServiceBaseBP<MtBrokenAptParamDTO, MtBrokenAptResultDTO> {

	@Override
	protected void checkParam(MtBrokenAptParamDTO param) throws BizException {
		validData(param.getCode_pat(), param.getEus_bbrtp());
	}

	@Override
	protected MtBrokenAptResultDTO process(MtBrokenAptParamDTO param) throws BizException {
		return getResult(param.getCode_pat(), param.getEus_bbrtp());
	}

	/**
	 * 获取患者爽约记录
	 * 
	 * @param 患者编码
	 * @param 爽约类型编码
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public MtBrokenAptResultDTO getResult(String patCode, String sd_bbrtp) throws BizException {

		this.validData(patCode, sd_bbrtp);

		StringBuilder sql = new StringBuilder();
		sql.append(" select ");
		sql.append(" bbr.id_patlock as id_key,");
		sql.append(" pat.code as code_pat,");
		sql.append(" pat.name as name_pat,");
		sql.append(" sex.name as sd_sex,");
		sql.append(" srv.code as code_scsrv,");
		sql.append(" srv.name as name_scsrv,");
		sql.append(" pat.mob as mobile,");
		sql.append(" bbr.dt_act,");
		sql.append(" bbr.sd_bbrtp");
		sql.append(" from pi_pat_bbr bbr ");
		sql.append(" inner join pi_pat pat on pat.id_pat = bbr.id_pat");
		sql.append(" inner join bd_udidoc sex on sex.id_udidoc = pat.id_sex");
		sql.append(" inner join sc_apt apt on apt.id_pat = bbr.id_pat");
		sql.append(" inner join sc_srv srv on srv.id_scsrv = apt.id_scsrv");
		sql.append(" where pat.code = ?");
		SqlParam param = new SqlParam();
		param.addParam(patCode);
		if (!StringUtil.isEmpty(sd_bbrtp)) {
			sql.append(" and bbr.sd_bbrtp in (");
			String[] list = sd_bbrtp.split(",");
			for (String sd : list) {
				sql.append("?,");
				param.addParam(sd);
			}
			sql = sql.deleteCharAt(sql.length() - 1);
			sql.append(" )");
		}
		List<MtBrokenAptDTO> list = (List<MtBrokenAptDTO>) new DAFacade().execQuery(sql.toString(), param,
				new BeanListHandler(MtBrokenAptDTO.class));
		MtBrokenAptResultDTO resultDTO = new MtBrokenAptResultDTO();
		resultDTO.setMtbrokenaptdto(ArrayListUtil.ConvertToFArrayList(list));
		return resultDTO;
	}

	/**
	 * 校验数据
	 * 
	 * @param patCode
	 * @param eus_bbrtp
	 * @throws BizException
	 */
	private void validData(String patCode, String sd_bbrtp) throws BizException {
		if (StringUtil.isEmpty(patCode)) {
			throw new BizException("获取患者爽约记录失败:患者编码传入为空!");
		}
		if (StringUtil.isEmpty(sd_bbrtp)) {
			throw new BizException("获取患者爽约记录失败:爽约类型编码传入为空!");
		}
		patCode = patCode.replaceAll(".*([';]+|(--)+).*", "");
		sd_bbrtp = sd_bbrtp.replaceAll(".*([';]+|(--)+).*", "");
		if (StringUtil.isEmpty(patCode.trim())) {
			throw new BizException("获取患者爽约记录失败:患者编码是非法字符!");
		}
		if (StringUtil.isEmpty(sd_bbrtp.trim())) {
			throw new BizException("获取患者爽约记录失败:爽约类型编码是非法字符!");
		}
	}

}
