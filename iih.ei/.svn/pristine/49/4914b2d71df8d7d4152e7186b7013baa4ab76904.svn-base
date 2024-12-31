package iih.ei.std.s.v1.bp.en;

import java.util.List;

import iih.bd.base.utils.ArrayListUtil;
import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.ei.std.d.v1.commdto.d.PageInfoDTO;
import iih.ei.std.d.v1.en.oepdeplist.d.OEPDepListDTO;
import iih.ei.std.d.v1.en.oepdeplist.d.OEPDepListParamDTO;
import iih.ei.std.d.v1.en.oepdeplist.d.OEPDepListResultDTO;
import iih.ei.std.s.v1.bp.IIHServiceBaseBP;
import iih.ei.std.s.v1.bp.common.EiContextUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.kernel.SqlParam;
/***
 * 门急诊出诊科室列表
 * @author li.wm
 * @date: 2019年12月17日 
 */
public class GetOEPDepListBP extends IIHServiceBaseBP<OEPDepListParamDTO, OEPDepListResultDTO> {
	
	/***
	 * 参数校验
	 */
	@Override
	protected void checkParam(OEPDepListParamDTO param) throws BizException {
		if (param.getPageinfo() == null || param.getPageinfo().size() <= 0) {
			throw new BizException("未传入分页信息！");
		}
	}

	/***
	 * 核心处理
	 */
	@Override
	protected OEPDepListResultDTO process(OEPDepListParamDTO param) throws BizException {
		OEPDepListResultDTO resultDto = new OEPDepListResultDTO();
		SqlParam sqlParam = new SqlParam();
		// 获取sql
		String sql = getSql(sqlParam);
		//获取分页信息执行SQl
		PageInfoDTO pageInfoDto = (PageInfoDTO) param.getPageinfo().get(0);
		List<OEPDepListDTO> list = findPagingData(pageInfoDto,sql, sqlParam, OEPDepListDTO.class);
		if(ListUtil.isEmpty(list)){
			throw new BizException("未查询到出诊科室记录！");
		}
		//返回值设置分页信息
		this.setPageInfo(pageInfoDto,resultDto);
		resultDto.setOepdeplist(ArrayListUtil.ConvertToFArrayList(list));
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
		builder.append("select distinct dep.code code_dep, ");
		builder.append("dep.name name_dep ");
		builder.append("from sc_pl pl ");
		builder.append("inner join bd_dep dep on pl.id_dep = dep.id_dep ");
		builder.append("where pl.sd_sctp in (?, ?) ");
		builder.append("and pl.id_org = ? ");		
		builder.append("and pl.fg_active = ? ");
		param.addParam(IScDictCodeConst.SD_SCTP_OP);// 门诊
		param.addParam(IScDictCodeConst.SD_SCTP_JZ);// 急诊
		param.addParam(EiContextUtils.getOrgId());// 进行组织过滤
		param.addParam(FBoolean.TRUE);
		builder.append("order by dep.code, dep.name ");
		return builder.toString();
	}
	/***
	 * @Description:设置分页信息
	 * @param pageInfoDto
	 * @param resultDto
	 */
	@SuppressWarnings("unchecked")
	private void setPageInfo(PageInfoDTO pageInfoDto,OEPDepListResultDTO resultDto){
		FArrayList pageInfoList = new FArrayList();
		pageInfoList.add(pageInfoDto);
		resultDto.setPageinfo(pageInfoList);
	}
}
