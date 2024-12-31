package iih.ei.std.s.v1.bp.en;

import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.StringUtils;

import iih.bd.base.utils.ArrayListUtil;
import iih.bd.base.utils.SqlUtils;
import iih.ei.std.d.v1.commdto.d.PageInfoDTO;
import iih.ei.std.d.v1.en.getticksinfo.d.TicksInfo;
import iih.ei.std.d.v1.en.getticksinfo.d.TicksParamDTO;
import iih.ei.std.d.v1.en.getticksinfo.d.TicksResultDTO;
import iih.ei.std.s.v1.bp.IIHServiceBaseBP;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.kernel.SqlParam;
/***
 * 获取排班对应的号段信息
 * @author fanlq
 * @date: 2019年12月4日 下午1:40:05
 */
public class GetSchTicksInfoBP extends IIHServiceBaseBP<TicksParamDTO, TicksResultDTO>{

	/***
	 * 入参检查
	 */
	@Override
	protected void checkParam(TicksParamDTO param) throws BizException {
		if (StringUtils.isNullOrEmpty(param.getId_schs())) {
			throw new BizException("排班ID不能为空！");
		}
	}

	/***
	 * 核心处理
	 */
	@Override
	protected TicksResultDTO process(TicksParamDTO param) throws BizException {
		TicksResultDTO resultDto = new TicksResultDTO();
		List<TicksInfo> ticksInfoList = new ArrayList<TicksInfo>();
		PageInfoDTO pageInfoDto = (PageInfoDTO) param.getPageinfo();
		SqlParam sqlParam = new SqlParam();
		String sql = getSql(param,sqlParam);
		ticksInfoList = findPagingData(pageInfoDto, sql, sqlParam, TicksInfo.class);
		resultDto.setTicksinfo(ArrayListUtil.ConvertToFArrayList(ticksInfoList));
		resultDto.setPageinfo(pageInfoDto);
		return resultDto;
	}
	 /**
     * 查询排班对应的号段数据
     * @param schIds
     * @return
     * @throws BizException
     */
    private String getSql(TicksParamDTO param,SqlParam sqlParam) throws BizException{
    	StringBuffer sql = new StringBuffer();
    	sql.append("SELECT SCH.ID_SCH,TICKS.ID_TICKS,TICKS.T_B AS T_B_TICKS,TICKS.T_E AS T_E_TICKS,TICKS.FG_USED, ");
    	sql.append("TICKS.QUENO_B AS TICK_B,TICKS.QUECN AS TICK_NUM, " );
    	sql.append("TICKS.QUECN_USED AS USED_NUM, " );
    	sql.append("TICKS.QUECN_APPT - TICKS.QUECN_USED AS UNUSED_NUM FROM SC_TICKS TICKS " );
    	sql.append("INNER JOIN SC_SCH SCH ON SCH.ID_SCH = TICKS.ID_SCH " );
    	sql.append("WHERE "+SqlUtils.getInSqlByIdsSplit("TICKS.ID_SCH", param.getId_schs()));
    	if(param.getFg_used() != null){
    		sql.append(" AND TICKS.FG_USED = ? ");
    		sqlParam.addParam(param.getFg_used());
    	}
    	sql.append("AND TICKS.FG_ACTIVE = 'Y' ORDER BY SCH.ID_SCH,SCH.ID_DAYSLOT,TO_NUMBER(TICKS.CODE),TICKS.T_B ");
        return sql.toString();  
    }
}
