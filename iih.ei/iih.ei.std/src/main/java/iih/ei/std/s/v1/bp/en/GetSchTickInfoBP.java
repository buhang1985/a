package iih.ei.std.s.v1.bp.en;

import java.util.ArrayList;
import java.util.List;

import iih.bd.base.utils.ArrayListUtil;
import iih.bd.base.utils.SqlUtils;
import iih.ei.std.d.v1.commdto.d.PageInfoDTO;
import iih.ei.std.d.v1.en.schtickinfo.d.SchIdDTO;
import iih.ei.std.d.v1.en.schtickinfo.d.SchTickInfoDTO;
import iih.ei.std.d.v1.en.schtickinfo.d.SchTickInfoParamDTO;
import iih.ei.std.d.v1.en.schtickinfo.d.SchTickInfoResultDTO;
import iih.ei.std.s.v1.bp.IIHServiceBaseBP;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.utils.ListToArrayUtil;
import xap.sys.jdbc.kernel.SqlParam;
/***
 * 获取患者预约列表BP
 * 
 * @author li.wm
 */
public class GetSchTickInfoBP extends IIHServiceBaseBP<SchTickInfoParamDTO, SchTickInfoResultDTO>{
	
	/**
	 * 入参检查
	 * */
	@SuppressWarnings("unchecked")
	@Override
	protected void checkParam(SchTickInfoParamDTO param) throws BizException {
		
		if (ListUtil.isEmpty(param.getIds_sch())) {
			throw new BizException("排班ID不能为空！");
		}
		if (param.getPageinfo() == null || param.getPageinfo().size() <= 0) {
			throw new BizException("未传入分页信息！");
		}
	}

	@Override	
	protected SchTickInfoResultDTO process(SchTickInfoParamDTO param) throws BizException {
		SchTickInfoResultDTO resultDTO = new SchTickInfoResultDTO();
		//获取SQL
		SqlParam sqlParam = new SqlParam();
		String sql = getSql(param,sqlParam);
		
		//获取分页信息执行SQl
		PageInfoDTO pageInfoDto = (PageInfoDTO) param.getPageinfo().get(0);
		List<SchTickInfoDTO> list = this.findPagingData(pageInfoDto,sql, sqlParam,SchTickInfoDTO.class);
		if(ListUtil.isEmpty(list)){
			return resultDTO;
		}
		//返回值设置分页信息
		setPageInfo(pageInfoDto,resultDTO);
		resultDTO.setSchtickinfo(ArrayListUtil.ConvertToFArrayList(list));
		return resultDTO;
	}
	/***
	 * @Description:获取患者预约信息sql
	 * @param param
	 * @param sqlParam
	 * @return
	 * @throws BizException 
	 */
	private String getSql(SchTickInfoParamDTO param,SqlParam sqlParam) throws BizException {
		StringBuilder sqlSb = new StringBuilder();
        sqlSb.append(" SELECT TICK.ID_TICK,TICK.T_B,TICK.T_E,TICK.QUENO CODE,TICK.IDS_SCCHL, TICK.ID_SCH SCHID,");
        sqlSb.append(" CASE WHEN  TICK.EU_USED = '0' AND TICK.EU_USESCOPE  = '1' THEN 'Y'  ELSE 'N' END AS FG_APPTABLE ");
        sqlSb.append(" FROM SC_TICK TICK");
        sqlSb.append(" WHERE  ");
		String str = SqlUtils.getInSqlByIds("TICK.ID_SCH", ObjectChangreString(param.getIds_sch().toArray()));
        sqlSb.append(str);
        sqlSb.append(" AND TICK.FG_ACTIVE = ? ORDER BY TICK.QUENO");
        sqlParam.addParam(FBoolean.TRUE);
		return sqlSb.toString();
	}
	/***
	 * @Description:把入参获取的FArrayList转化成String数组
	 * @param Array
	 * @return
	 * @throws BizException 
	 */
	private String[] ObjectChangreString(Object[] array) throws BizException {
		List<String> result = new ArrayList<>();
		ListToArrayUtil<String> util = new ListToArrayUtil<>();
		
		for (Object object : array) {
			SchIdDTO schId = (SchIdDTO)object;
			result.add(schId.getId_sch());
		}
		
		return util.convertToArray(result);
	}
	
	/***
	 * @Description:设置分页信息
	 * @param pageInfoDto
	 * @param resultDto
	 */
	@SuppressWarnings("unchecked")
	private void setPageInfo(PageInfoDTO pageInfoDto,SchTickInfoResultDTO resultDto){
		FArrayList pageInfoList = new FArrayList();
		pageInfoList.add(pageInfoDto);
		resultDto.setPageinfo(pageInfoList);
	}
}
