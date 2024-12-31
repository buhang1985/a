package iih.ei.std.s.v1.bp.en;

import java.util.List;

import iih.bd.base.utils.ArrayListUtil;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.ei.std.d.v1.en.visittimesstat.d.VisitTimesStatDTO;
import iih.ei.std.d.v1.en.visittimesstat.d.VisitTimesStatParamDTO;
import iih.ei.std.d.v1.en.visittimesstat.d.VisitTimesStatResultDTO;
import iih.ei.std.s.v1.bp.IIHServiceBaseBP;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.jdbc.kernel.SqlParam;
/***
 * 获取本次就诊患者分类  BP
 * 
 * @author li.wm
 */
public class GetVisitTimesStatBP extends IIHServiceBaseBP<VisitTimesStatParamDTO, VisitTimesStatResultDTO>{
	/**
	 * 入参检查
	 * */
	@Override
	protected void checkParam(VisitTimesStatParamDTO param) throws BizException {

		if (param == null) {
			throw new BizException("日期不能为空！");
		}
		param.setDate(param.getDate().substring(0, 10) + " 00:00:00");
	}

	@Override
	protected VisitTimesStatResultDTO process(VisitTimesStatParamDTO param) throws BizException {
		VisitTimesStatResultDTO resultDTO = new VisitTimesStatResultDTO();
		
		//获取SQL
		SqlParam sqlParam = new SqlParam();
		String sql = getSql(param,sqlParam);
		
		List<VisitTimesStatDTO> list = this.findDataList(sql, sqlParam, VisitTimesStatDTO.class);
		if(ListUtil.isEmpty(list)){
			return resultDTO;
		}
		
		for(VisitTimesStatDTO opVisitTimesStat : list){
			opVisitTimesStat.setDate(new FDateTime(param.getDate()).toStdString());
		}	

		resultDTO.setVisittimesstat(ArrayListUtil.ConvertToFArrayList(list));
		return resultDTO;
	}
	
	/***
	 * @Description:获取sql
	 * @param param
	 * @param sqlParam
	 * @return
	 * @throws BizException 
	 */
	private String getSql(VisitTimesStatParamDTO param,SqlParam sqlParam){
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("SELECT STAT.*, DEP.CODE AS CODE_DEPT,DEP.NAME AS NAME_DEPT ");
		sqlBuilder.append("FROM ( ");
		sqlBuilder.append("SELECT OP.ID_DEP_REG AS ID_STAT_DEP, ");
		sqlBuilder.append("SUM(CASE EN.CODE_ENTP WHEN ? THEN 1 ELSE 0 END) AS TIMES_OP, ");
		sqlBuilder.append("SUM(CASE EN.CODE_ENTP WHEN ? THEN 1 ELSE 0 END) AS TIMES_EMG, ");
		sqlBuilder.append("SUM(CASE OP.SD_SVRTP WHEN ? THEN 1  WHEN ? THEN 1 ELSE 0 END) AS TIMES_PROF, ");
		sqlBuilder.append("SUM(CASE OP.SD_SVRTP WHEN ? THEN 1  ELSE 0 END) AS TIMES_COMM, ");
		sqlBuilder.append("COUNT(DISTINCT CASE OP.SD_SVRTP WHEN ? THEN OP.ID_SCH  WHEN ? THEN OP.ID_SCH ELSE NULL END)*0.5 AS PHYPROF_DAYS, ");
		sqlBuilder.append("COUNT(DISTINCT CASE OP.SD_SVRTP WHEN ? THEN OP.ID_SCH  ELSE NULL END)*0.5 AS PHYCOMM_DAYS  ");
		sqlBuilder.append("FROM EN_ENT EN ");
		sqlBuilder.append("INNER JOIN EN_ENT_OP OP ON EN.ID_ENT = OP.ID_ENT ");
		sqlBuilder.append("WHERE EN.FG_CANC = ? ");
		sqlBuilder.append("AND EN.DT_ENTRY = ? ");
		sqlBuilder.append("GROUP BY OP.ID_DEP_REG ");
		sqlBuilder.append(") STAT ");
		sqlBuilder.append("INNER JOIN BD_DEP DEP ON STAT.ID_STAT_DEP = DEP.ID_DEP ");
		sqlParam.addParam(IBdFcDictCodeConst.SD_CODE_ENTP_OP);
		sqlParam.addParam(IBdFcDictCodeConst.SD_CODE_ENTP_ET);
		sqlParam.addParam(IBdSrvDictCodeConst.SD_SRVTP_DIAGTREAT_OP_EXP);
		sqlParam.addParam(IBdSrvDictCodeConst.SD_SRVTP_DIAGTREAT_OP_SPECIAL);
		sqlParam.addParam(IBdSrvDictCodeConst.SD_SRVTP_DIAGTREAT_OP_NORM);
		sqlParam.addParam(IBdSrvDictCodeConst.SD_SRVTP_DIAGTREAT_OP_EXP);
		sqlParam.addParam(IBdSrvDictCodeConst.SD_SRVTP_DIAGTREAT_OP_SPECIAL);
		sqlParam.addParam(IBdSrvDictCodeConst.SD_SRVTP_DIAGTREAT_OP_NORM);
		sqlParam.addParam(FBoolean.FALSE);
		sqlParam.addParam(param.getDate());
		
		
		return sqlBuilder.toString();
	}
	
	
}
