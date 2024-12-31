package iih.ei.std.s.v1.bp.en;

import java.util.List;

import iih.bd.base.utils.ArrayListUtil;
import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.ei.std.d.v1.commdto.d.PageInfoDTO;
import iih.ei.std.d.v1.en.oepempdepmatch.d.OEPEmpDepMatchDTO;
import iih.ei.std.d.v1.en.oepempdepmatch.d.OEPEmpDepMatchParamDTO;
import iih.ei.std.d.v1.en.oepempdepmatch.d.OEPEmpDepMatchResultDTO;
import iih.ei.std.s.v1.bp.IIHServiceBaseBP;
import iih.ei.std.s.v1.bp.common.EiContextUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.kernel.SqlParam;
/***
 * 门急诊医生出诊科室列表
 * @author li.wm
 * @date: 2019年12月17日 
 */
public class GetOEPEmpDepMatchBP extends IIHServiceBaseBP<OEPEmpDepMatchParamDTO, OEPEmpDepMatchResultDTO> {
	
	/***
	 * 参数校验
	 */
	@Override
	protected void checkParam(OEPEmpDepMatchParamDTO param) throws BizException {
		if (param.getPageinfo() == null || param.getPageinfo().size() <= 0) {
			throw new BizException("未传入分页信息！");
		}
	}

	/***
	 * 核心处理
	 */
	@Override
	protected OEPEmpDepMatchResultDTO process(OEPEmpDepMatchParamDTO param) throws BizException {
		OEPEmpDepMatchResultDTO resultDto = new OEPEmpDepMatchResultDTO();
		SqlParam sqlParam = new SqlParam();
		// 获取sql
		String sql = getSql(sqlParam);
		//获取分页信息执行SQl
		PageInfoDTO pageInfoDto = (PageInfoDTO) param.getPageinfo().get(0);
		List<OEPEmpDepMatchDTO> list = findPagingData(pageInfoDto,sql, sqlParam, OEPEmpDepMatchDTO.class);
		if(ListUtil.isEmpty(list)){
			throw new BizException("未查询到医生出诊科室记录！");
		}
		//返回值设置分页信息
		this.setPageInfo(pageInfoDto,resultDto);
		resultDto.setOepempdepmatch(ArrayListUtil.ConvertToFArrayList(list));
		return resultDto;
	}
	/***
	 * @Description:
	 * @param param
	 * @param sqlParam
	 * @return
	 */
	private String getSql(SqlParam param) throws BizException {
		StringBuilder builder = new StringBuilder();
		builder.append("select distinct psn.code code_emp,");
		builder.append("psn.name name_emp,");
		builder.append("dep.code code_dep,");
		builder.append("dep.name name_dep, ");
		builder.append("psn.des doc_special ");
		builder.append("from sc_pl pl ");
		builder.append("inner join bd_dep dep on pl.id_dep = dep.id_dep ");
		builder.append("inner join sc_res res on pl.id_scres = res.id_scres ");
		builder.append("inner join bd_psndoc psn on res.id_emp = psn.id_psndoc ");
		builder.append("where pl.sd_sctp in (?, ?) ");
		builder.append("and pl.id_org = ? ");
		builder.append("and pl.fg_active = ? ");
		param.addParam(IScDictCodeConst.SD_SCTP_OP);// 门诊
		param.addParam(IScDictCodeConst.SD_SCTP_JZ);// 急诊
		param.addParam(EiContextUtils.getOrgId());// 进行组织过滤
		param.addParam(FBoolean.TRUE);
		builder.append("order by psn.code,dep.code, dep.name ");
		
		
		return builder.toString();
	}
	/***
	 * @Description:设置分页信息
	 * @param pageInfoDto
	 * @param resultDto
	 */
	@SuppressWarnings("unchecked")
	private void setPageInfo(PageInfoDTO pageInfoDto,OEPEmpDepMatchResultDTO resultDto){
		FArrayList pageInfoList = new FArrayList();
		pageInfoList.add(pageInfoDto);
		resultDto.setPageinfo(pageInfoList);
	}
}
