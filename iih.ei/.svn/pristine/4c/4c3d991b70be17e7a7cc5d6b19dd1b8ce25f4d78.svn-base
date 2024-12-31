package iih.ei.std.s.v1.bp.sc;

import java.util.List;

import iih.bd.base.utils.ArrayListUtil;
import iih.ei.std.d.v1.commdto.d.PageInfoDTO;
import iih.ei.std.d.v1.sc.mtscdbsrv.d.MtScDbSrvDTO;
import iih.ei.std.d.v1.sc.mtscdbsrv.d.MtScDbSrvParamDTO;
import iih.ei.std.d.v1.sc.mtscdbsrv.d.MtScDbSrvResultDTO;
import iih.ei.std.s.v1.bp.IIHServiceBaseBP;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class GetMtScDbSrvListBP extends IIHServiceBaseBP<MtScDbSrvParamDTO, MtScDbSrvResultDTO> {

	@Override
	protected void checkParam(MtScDbSrvParamDTO param) throws BizException {
	}

	@Override
	protected MtScDbSrvResultDTO process(MtScDbSrvParamDTO param) throws BizException {
		return getResult(param);
	}

	
	/**
	 * 获取医技项目分类字典
	 * 
	 * @author yzh
	 * @param idScca
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private MtScDbSrvResultDTO getResult(MtScDbSrvParamDTO inparam) throws BizException {
		String orgId = Context.get().getOrgId();
		SqlParam param = new SqlParam();
		StringBuilder sqlBuilder = new StringBuilder();
		String pripatCode = this.getPatPriCode(orgId);
		sqlBuilder.append(" select rel.id_mdsrv as id_srv,srv.code as code_srv,")
		.append(" srv.name as name_srv,srv.pycode,srv.wbcode,scsrv.id_scca as id_scca,ca.name as name_scca,")
		.append(" price.price_std as price")
		.append(" from sc_srv_rel rel")
		.append(" inner join sc_srv scsrv on scsrv.id_scsrv = rel.id_scsrv")
		.append(" inner join bd_srv srv on rel.id_mdsrv = srv.id_srv")
		.append(" inner join view_price_rp price on rel.id_mdsrv = price.id_srv")
		.append(" inner join bd_pri_pat pripat on pripat.id_pripat = price.id_pripat")
		.append(" inner join sc_ca ca on scsrv.id_scca = ca.id_scca")
		.append(" and pripat.code = ? and pripat.id_org = ?");
		param.addParam(pripatCode);
		param.addParam(orgId);
		if (!StringUtil.isEmpty(inparam.getId_scca())) {
			sqlBuilder.append(" and scsrv.id_scca = ? ");
			param.addParam(inparam.getId_scca());
		}
		sqlBuilder.append(" inner join sc_ca scca on scca.id_scca = scsrv.id_scca");
		PageInfoDTO pageInfoDto = (PageInfoDTO) inparam.getPageinfo().get(0);
		List<MtScDbSrvDTO> list = this.findPagingData(pageInfoDto,sqlBuilder.toString(), param, MtScDbSrvDTO.class);
		MtScDbSrvResultDTO mtScDbSrvResultDTO = new MtScDbSrvResultDTO();
		mtScDbSrvResultDTO.setMtscdbsrvdto(ArrayListUtil.ConvertToFArrayList(list));
		return mtScDbSrvResultDTO;
	}

	/**
	 * 查询当前组织下默认的患者加个分类
	 * @param orgId
	 * @return
	 * @throws DAException
	 */
	@SuppressWarnings("unchecked")
	private String getPatPriCode(String orgId) throws DAException{
		SqlParam param = new SqlParam();
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("select pripat.code from pi_pat_ca ca left join bd_pri_pat pripat on ca.id_patpritp = pripat.id_pripat ")
		.append("where ca.fg_def = 'Y' and ca.id_org =?");
		param.addParam(orgId);
		DAFacade dafacade = new DAFacade();
		List<String> list = (List<String>) dafacade.execQuery(sqlBuilder.toString(), param, new ColumnListHandler());
		if(ListUtil.isEmpty(list)){
			return null;
		}else{
			return list.get(0);
		}
	}
}
