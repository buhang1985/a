package iih.ei.std.s.v1.bp.en;

import java.util.List;

import iih.bd.base.utils.ArrayListUtil;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.ei.std.d.v1.commdto.d.PageInfoDTO;
import iih.ei.std.d.v1.en.bedinfo.d.BedInfoDTO;
import iih.ei.std.d.v1.en.cancipinfos.d.CancIpInfosDTO;
import iih.ei.std.d.v1.en.cancipinfos.d.CancIpInfosParamDTO;
import iih.ei.std.d.v1.en.cancipinfos.d.CancIpInfosResultDTO;
import iih.ei.std.s.v1.bp.IIHServiceBaseBP;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取退院患者列表
 * @author lilei
 *
 */
public class GetCancIpInfoBP extends IIHServiceBaseBP<CancIpInfosParamDTO, CancIpInfosResultDTO> {

	@Override
	protected void checkParam(CancIpInfosParamDTO param) throws BizException {
	}

	@Override
	protected CancIpInfosResultDTO process(CancIpInfosParamDTO param) throws BizException {
		CancIpInfosDTO[] queryData = getQueryData(param);
		CancIpInfosResultDTO resultDTO = new CancIpInfosResultDTO();
		resultDTO.setCancipinfosdto(ArrayListUtil.ConvertToFArrayList(queryData));
		return resultDTO;
	}

	/**
	 * 执行sql 查询数据
	 * 
	 * @param dt
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private CancIpInfosDTO[] getQueryData(CancIpInfosParamDTO param) throws BizException {
		SqlParam sqlParam = new SqlParam();
		String sql = this.getSql(sqlParam, param.getDt_begin_canc());
		PageInfoDTO pageInfoDto = (PageInfoDTO) param.getPageinfo().get(0);
		List<CancIpInfosDTO> results = this.findPagingData(pageInfoDto,sql, sqlParam, CancIpInfosDTO.class);
		return ListUtil.isEmpty(results) ? null : results.toArray(new CancIpInfosDTO[0]);
	}

	/**
	 * 获取sql 封装查询条件
	 * 
	 * @param param
	 * @param dt
	 * @return
	 */
	private String getSql(SqlParam param, FDateTime dtime) {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT");
		sql.append(" IP.CODE_AMR_IP AS CODE_AMR_IP,");
		sql.append(" IP.TIMES_IP,");
		sql.append(" ENT.DT_CANC,");
		sql.append(" CASE WHEN ENT.SV > IP.SV THEN ENT.SV ELSE IP.SV END UPDATE_TIME, ");//更新时间
		sql.append(" PAT.CODE AS CODE_PAT");
		sql.append(" FROM EN_ENT ENT");
		sql.append(" INNER JOIN EN_ENT_IP IP ON IP.ID_ENT = ENT.ID_ENT");
		sql.append(" INNER JOIN PI_PAT PAT ON PAT.ID_PAT = ENT.ID_PAT");
		sql.append(" WHERE ENT.CODE_ENTP = ?");
		param.addParam(IEnDictCodeConst.SD_ENTP_INPATIENT);// 就诊类型为10
		sql.append(" AND ENT.FG_CANC = ?");
		param.addParam(FBoolean.TRUE);
		if (dtime != null) {
			sql.append(" AND ENT.DT_CANC >= ?");
			param.addParam(dtime);
		}
		return sql.toString();
	}
}
