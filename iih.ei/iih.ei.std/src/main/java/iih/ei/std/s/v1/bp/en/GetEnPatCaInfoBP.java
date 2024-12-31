package iih.ei.std.s.v1.bp.en;

import java.util.List;

import iih.bd.base.utils.ArrayListUtil;
import iih.ei.std.d.v1.commdto.d.PageInfoDTO;
import iih.ei.std.d.v1.en.enpatcainfo.d.EnPatCaInfoDTO;
import iih.ei.std.d.v1.en.enpatcainfo.d.EnPatCaInfoParamDTO;
import iih.ei.std.d.v1.en.enpatcainfo.d.EnPatCaInfoResultDTO;
import iih.ei.std.s.v1.bp.IIHServiceBaseBP;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ListUtil;
import xap.sys.jdbc.kernel.SqlParam;
/***
 * 获取本次就诊患者分类  BP
 * 
 * @author li.wm
 */
public class GetEnPatCaInfoBP extends IIHServiceBaseBP<EnPatCaInfoParamDTO, EnPatCaInfoResultDTO>{
	/**
	 * 入参检查
	 * */
	@Override
	protected void checkParam(EnPatCaInfoParamDTO param) throws BizException {
		
		if (param.getCode_pat() == null) {
			throw new BizException("患者编码不能为空！");
		}
		if (param.getTimes_op() == null) {
			throw new BizException("就诊次数不能为空！");
		}
		if (param.getPageinfo() == null && param.getPageinfo().size() <= 0) {
			throw new BizException("未传入分页信息！");
		}
	}

	@Override
	protected EnPatCaInfoResultDTO process(EnPatCaInfoParamDTO param) throws BizException {
		EnPatCaInfoResultDTO resultDTO = new EnPatCaInfoResultDTO();
		
		//获取SQL
		SqlParam sqlParam = new SqlParam();
		String sql = getSql(param,sqlParam);
		//获取分页信息执行SQl
		PageInfoDTO pageInfoDto = (PageInfoDTO) param.getPageinfo().get(0);
		List<EnPatCaInfoDTO> list = this.findPagingData(pageInfoDto, sql, sqlParam, EnPatCaInfoDTO.class);
		if(ListUtil.isEmpty(list)){
			return resultDTO;
		}
		//返回值设置分页信息
		setPageInfo(pageInfoDto,resultDTO);
		resultDTO.setEnpatcainfo(ArrayListUtil.ConvertToFArrayList(list));
		return resultDTO;
	}
	
	/***
	 * @Description:获取sql
	 * @param param
	 * @param sqlParam
	 * @return
	 * @throws BizException 
	 */
	private String getSql(EnPatCaInfoParamDTO param,SqlParam sqlParam){
		StringBuilder sb = new StringBuilder();	
		sb.append(" SELECT ENT.CODE AS CODE_ENT ,");
		sb.append(" PAT.CODE AS CODE_PAT  ,");
		sb.append(" PAT.NAME AS NAME_PAT  ,");
		sb.append(" CA.CODE AS CODE_PATCA ,");
		sb.append(" CA.NAME AS NAME_PATCA ,");
		sb.append(" OP.TIMES_OP AS TIMES_OP ");
		sb.append(" FROM EN_ENT ENT ");
		sb.append(" INNER JOIN PI_PAT PAT ON PAT.ID_PAT = ENT.ID_PAT  ");
		sb.append(" INNER JOIN EN_ENT_OP OP ON OP.ID_ENT  = ENT.ID_ENT ");
		sb.append(" LEFT JOIN PI_PAT_CA CA ON CA.ID_PATCA = ENT.ID_PATCA ");
		sb.append(" WHERE PAT.CODE = ? ");
		sb.append(" AND OP.TIMES_OP  = ? ");
		sqlParam.addParam(param.getCode_pat());
		sqlParam.addParam(param.getTimes_op());
		
		
		return sb.toString();
	}
	
	/***
	 * @Description:设置分页信息
	 * @param pageInfoDto
	 * @param resultDto
	 */
	@SuppressWarnings("unchecked")
	private void setPageInfo(PageInfoDTO pageInfoDto,EnPatCaInfoResultDTO resultDto){
		FArrayList pageInfoList = new FArrayList();
		pageInfoList.add(pageInfoDto);
		resultDto.setPageinfo(pageInfoList);
	}
}
