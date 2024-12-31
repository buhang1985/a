package iih.ei.std.s.v1.bp.sc;

import java.util.List;

import iih.ei.std.d.v1.sc.mtaptnoterpt.d.MtAptNoteRptDTO;
import iih.ei.std.d.v1.sc.mtaptnoterpt.d.MtAptNoteRptParamDTO;
import iih.ei.std.d.v1.sc.mtaptnoterpt.d.MtAptNoteRptResultDTO;
import iih.ei.std.s.v1.bp.IIHServiceBaseBP;
import iih.sc.apt.dto.d.MtAppDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.StringUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class GetMtAptNoteRptBP extends IIHServiceBaseBP<MtAptNoteRptParamDTO, MtAptNoteRptResultDTO>{
	private String repUrl = "reportweb/rptexport?_action_type=export&as=pdf&file=";
	
	@Override
	protected void checkParam(MtAptNoteRptParamDTO param) throws BizException {
		if(StringUtil.isEmptyWithTrim(param.getId_apt())){
			throw new BizException("预约记录id不能为空!");
		}
	}

	@Override
	protected MtAptNoteRptResultDTO process(MtAptNoteRptParamDTO param) throws BizException {
		return exec(param.getId_apt());
	} 
	
	/**
	 * 获取医技停诊列表
	 * @param beginDate 开始时间
	 * @param endDate 结束时间
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private MtAptNoteRptResultDTO exec(String id_apt) throws BizException {
		String tmplPath = this.getTmplPath(id_apt);
		if(StringUtil.isEmpty(tmplPath)){
			throw new BizException("未获取到医技预约告知单模板数据!");
		}
		StringBuffer repUrl = new StringBuffer();
		repUrl.append(this.repUrl).append(tmplPath).append("&id_apt=").append(id_apt);
		MtAptNoteRptDTO bean = new MtAptNoteRptDTO();
		bean.setUrl(repUrl.toString());
		bean.setId_apt(id_apt);
		MtAptNoteRptResultDTO resultDTO = new MtAptNoteRptResultDTO();
		FArrayList fArrayList = new FArrayList();
		fArrayList.add(bean);
		resultDTO.setMtaptnoterptdto(fArrayList);
		return resultDTO;
	}
	
	/**
	 * 校验数据
	 * @param patCode
	 * @param eus_bbrtp
	 * @throws BizException
	 */
	private void validData(MtAppDTO appDTO) throws BizException
	{
		if(StringUtil.isEmpty(appDTO.getId_srv()))
		{
			throw new BizException("预约记录对应的信息不全,服务项目id_srv为空!");
		}
	}
	
	@SuppressWarnings("unchecked")
	private String getTmplPath(String id_apt) throws BizException{
		StringBuilder sql = new StringBuilder();
		SqlParam param = new SqlParam();
		sql.append(" select apt.id_scsrv, apt.id_scca, appl.id_dep_mp, appl.id_srv");
		sql.append(" from sc_apt apt");
		sql.append(" left join sc_apt_appl appl on apt.id_apt = appl.id_scapt");
		sql.append(" where apt.id_apt = ?");
		param.addParam(id_apt);
		List<MtAppDTO> list = (List<MtAppDTO>) new DAFacade().execQuery(sql.toString(),param,new BeanListHandler(MtAppDTO.class));
		if(list.size()>0)
		{
			MtAppDTO appDTO =  list.get(0);
			this.validData(appDTO);
			sql.delete(0, sql.length());
			param.clearParams();
			sql.append(" select tmpl.path");
			sql.append(" from sc_prt_cfg scg");
			sql.append(" inner join sc_prt_tmpl tmpl");
			sql.append(" on tmpl.id_prttmpl = scg.id_prttmpl");
			sql.append(" where (scg.id_dep = ? or scg.id_dep  = '~' or scg.id_dep  is null)");
			sql.append(" and (scg.id_scca = ? or scg.id_scca  = '~' or scg.id_scca  is null)");
			sql.append(" and (scg.id_scsrv = ? or scg.id_scsrv  = '~' or scg.id_scsrv  is null)");
			sql.append(" and (scg.ids_bdsrv like ? or scg.ids_bdsrv = '~' or scg.ids_bdsrv is null )");
			sql.append(" and scg.id_org = ? ");
			sql.append(" order by scg.level_pri desc");
			param.addParam(appDTO.getId_dep_mp());
			param.addParam(appDTO.getId_scca());
			param.addParam(appDTO.getId_scsrv());
			param.addParam("%"+appDTO.getId_srv()+"%");
			param.addParam(Context.get().getOrgId());
			List<String> result = (List<String>) new DAFacade().execQuery(sql.toString(),param,new ColumnListHandler());
			if(result.size()>0)
			{
				return result.get(0);
			}
			return null;
		}
		return null;
	}

}
