package iih.ei.std.s.v1.bp.sc;

import java.util.List;

import iih.bd.base.utils.ArrayListUtil;
import iih.ei.std.d.v1.sc.mtpataptbyidapt.d.MtPatAptByIdAptParamDTO;
import iih.ei.std.d.v1.sc.mtpataptbyidapt.d.MtPatAptByIdAptResultDTO;
import iih.ei.std.d.v1.sc.mtpataptlist.d.MtPatAptListDTO;
import iih.ei.std.s.v1.bp.IIHServiceBaseBP;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class GetMtPatAptByIdAptBP extends IIHServiceBaseBP<MtPatAptByIdAptParamDTO, MtPatAptByIdAptResultDTO> {
	
	@Override
	protected void checkParam(MtPatAptByIdAptParamDTO param) throws BizException {
		validData(param.getId_apt());
	}
	@Override
	protected MtPatAptByIdAptResultDTO process(MtPatAptByIdAptParamDTO param) throws BizException {
		return getResult(param.getId_apt());
	}
	
	@SuppressWarnings("unchecked")
	private MtPatAptByIdAptResultDTO getResult(String idApt) throws BizException{
		this.validData(idApt);
		SqlParam param = new SqlParam();
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("  select apt.id_apt as id_apt,")
		.append(" pat.code as code_pat,")
		.append(" pat.name as name_pat,")
		.append(" appl.code_entp as code_entp,")
		.append(" ca.name as patca,")
		.append(" dep.code as code_dept,")
		.append(" dep.name as name_dept,")
		.append(" srv.code as code_srv,")
		.append(" srv.name as name_srv,")
		.append(" res.code as code_res,")
		.append(" res.name as name_res,")
		.append(" substr(apt.dt_b,0,10) as time_ent,")
		.append(" apt.dt_appt as time_opr,")
		.append(" dayslot.sd_dayslottp as dayslottp,")
		.append("  apt.queno as seqno,")
		.append(" (case  appl.fg_bl when 'Y' then 1 when 'N' then 0 else null end) as fee_status ,")
		.append(" apt.sd_status as sd_status,")
		.append(" apt.code as code_apt,")
		.append(" ben.des as address,")
		.append("  (case pat.mob when null then pat.tel else pat.mob end) as mobile,")
		.append(" chl.name as name_chl_type,chl.code as code_chl_type")
		.append(" from sc_apt apt")
		.append(" inner join pi_pat pat on apt.id_pat = pat.id_pat")
		.append(" inner join pi_pat_ca ca on pat.id_paticate = ca.id_patca")
		.append(" left join bd_dep dep on dep.id_dep = apt.id_dep_appt ")
		.append(" inner join sc_srv srv on apt.id_scsrv = srv.id_scsrv")
		.append(" inner join sc_res  res on apt.id_scres = res.id_scres")
		.append(" inner join bd_dayslot dayslot on dayslot.id_dayslot  = apt.id_dateslot")
		.append(" inner join sc_chl chl on apt.id_scchl  = chl.id_scchl")
		.append(" inner join sc_apt_appl appl on apt.id_apt = appl.id_scapt")
		.append(" inner join sc_sch sch on apt.id_sch = sch.id_sch")
		.append(" inner join sc_pl pl on pl.id_scpl = sch.id_scpl")
		.append(" inner join bd_que_ben ben on pl.id_queben = ben.id_queben")
		.append(" where appl.fg_canc = 'N' and apt.id_apt = ?");
		param.addParam(idApt);
		
		List<MtPatAptListDTO> list = (List<MtPatAptListDTO>) new DAFacade().execQuery(sqlBuilder.toString(),param,new BeanListHandler(MtPatAptListDTO.class));
		MtPatAptByIdAptResultDTO resultDTO = new MtPatAptByIdAptResultDTO();
		resultDTO.setMtpataptlistdto(ArrayListUtil.ConvertToFArrayList(list));
		return resultDTO;
	}
	/**
	 * 校验数据
	 * @param beginDate
	 * @param endDate
	 * @throws BizException
	 * @auther yaohl
	 * @date 2018年10月30日
	 */
	private void validData (String idApt) throws BizException{
		if(StringUtil.isEmpty(idApt)){
			throw new BizException("查询患者医技预约记录失败：预约ID不能未空");
		}
	}
}
