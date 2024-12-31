package iih.en.er.bp.rescue.qry;

import java.util.List;

import iih.sc.scbd.dto.d.PrtQry4EnDTO;
import iih.sc.scbd.dto.d.ScPrtCfgQryDTO;
import iih.sc.scbd.dto.d.ScPrtTmplDTO;
import iih.sc.scbd.i.IScBdOutQryService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class GetRescuePrtTmplBp {

	/**
	 * 查打印模板
	 * @param qryDTO
	 * @return
	 * @throws BizException
	 */
	public ScPrtTmplDTO exec(PrtQry4EnDTO qryDTO) throws BizException{
		checkParam(qryDTO);
		//组装dto
		ScPrtCfgQryDTO cfgQryDTO = structureDto(qryDTO);
		if(cfgQryDTO == null) throw new BizException("没有查到id_ent为"+qryDTO.getId_ent()+"的就诊信息");
		IScBdOutQryService scBdOutQryService = ServiceFinder.find(IScBdOutQryService.class);
		return scBdOutQryService.getScPrtTmplDTO(cfgQryDTO);
	}

	private void checkParam(PrtQry4EnDTO qryDTO) throws BizException{
		if(qryDTO == null) throw new BizException("入参不能为空");
		if(StringUtil.isEmpty(qryDTO.getId_ent())) throw new BizException("id_ent不能为空");
		if(StringUtil.isEmpty(qryDTO.getFun_code())) throw new BizException("功能节点编码不能为空");
		if(StringUtil.isEmpty(qryDTO.getSd_rpttp())) throw new BizException("打印类型编码不能为空");
	}
	
	@SuppressWarnings("unchecked")
	private ScPrtCfgQryDTO structureDto(PrtQry4EnDTO qryDTO) throws BizException{
		StringBuilder sbsql = new StringBuilder();
		SqlParam sqlParam = new SqlParam();
		sbsql.append(" select ent.id_dep_phy, ");
		sbsql.append(" ent.id_dep_nur, ");
		sbsql.append(" ent.id_dep_nur, ");
		sbsql.append(" ent.id_sex_pat   as id_sex, ");
		sbsql.append(" 'N' as fg_newborn, ");
		sbsql.append(" ent.dt_birth_pat as dt_birth ");
		sbsql.append(" from en_ent ent ");
		//sbsql.append(" inner join en_ent_op op on ent.id_ent = op.id_ent ");
		sbsql.append(" where ent.id_ent = ? ");
		sqlParam.addParam(qryDTO.getId_ent());
		List<ScPrtCfgQryDTO> list = (List<ScPrtCfgQryDTO>)new DAFacade().execQuery(sbsql.toString(), sqlParam, new BeanListHandler(ScPrtCfgQryDTO.class));
		if(ListUtil.isEmpty(list)) return null;
		ScPrtCfgQryDTO dto = list.get(0);
		dto.setFun_code(qryDTO.getFun_code());
		dto.setSd_rpttp(qryDTO.getSd_rpttp());
		return dto;
	}
}
