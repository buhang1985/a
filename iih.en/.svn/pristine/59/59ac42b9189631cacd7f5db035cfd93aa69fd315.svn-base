package iih.en.pv.s.bp.op.ws;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.en.comm.util.EnCodeUtils;
import iih.en.comm.util.EnLogUtil;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.outpatient.dto.d.SchInfoDTO;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDouble;
import xap.mw.log.logging.Logger;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取停诊信息
 * @author liubin
 *
 */
public class GetOpStopSchListBP {
	/**
	 * 获取停诊信息
	 * 
	 * @param beginDate 开始日期
	 * @param endDate 结束日期
	 * @return
	 * @throws BizException
	 */
	public SchInfoDTO[] exec(String beginDate, String endDate) throws BizException{
		//记录输入参数日志，fanlq-add
		EnLogUtil.getInstance().logInfo("方法：GetOpStopSchListBP参数为:beginDate:"+beginDate+";endDate:"+endDate);
				
		FDate bDate = this.string2FDate(beginDate);
		FDate eDate = this.string2FDate(endDate);
		if(bDate == null || eDate == null)
			return null;
		//获取停诊排班信息
		SchInfoDTO[] schInfos = this.getSchInfos(bDate, eDate);
		//对排班信息做处理
		this.process(schInfos);
		return schInfos;
	}
	/**
	 * 获取停诊排班信息
	 * 
	 * @param bDate 开始日期
	 * @param eDate 结束日期
	 * @return
	 * @throws BizException 
	 */
	private SchInfoDTO[] getSchInfos(FDate bDate, FDate eDate) throws BizException{
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT SC_SCH.ID_SCH AS ID_SCH,");
		sb.append("SC_SCH.D_SCH AS SCHDATE,");
		sb.append("BD_DEP.CODE AS DEPTCODE,");
		sb.append("BD_DEP.NAME AS DEPTNAME,");
		sb.append("SC_RES.CODE AS DOCTORCODE,");
		sb.append("SC_RES.NAME AS DOCTORNAME,");
		sb.append("SC_RES.CODE AS RESCODE,");
		sb.append("SC_RES.NAME AS RESNAME,");
		sb.append("SC_RES.DES AS SPECIALITY,");
		sb.append("BD_DAYSLOT.NAME AS DAYSLOTTYPE,  ");
		sb.append("BD_DAYSLOT.SD_DAYSLOTTP AS DAYSLOTTP,");
		sb.append("SC_SRV.ID_SCSRV AS SRVID,");
		sb.append("SC_SRV.CODE AS SRVCODE,");
		sb.append("SC_SRV.NAME AS SRVNAME,");
		sb.append("NVL(SC_SCH.QUAN_TOTAL_APPT,0) AS TOTAL,");
		sb.append("NVL(SC_SCH.QUAN_TOTAL_USED,0) AS USED,");
		sb.append("NVL(SC_SCH.QUAN_TOTAL_APPT,0) - NVL(SC_SCH.QUAN_TOTAL_USED,0) AS REMAIN,");
		sb.append("SC_SCH.FG_ACTIVE AS ISOPEN ");
		sb.append("FROM SC_SCH SC_SCH INNER JOIN SC_PL SC_PL ON SC_SCH.ID_SCPL = SC_PL.ID_SCPL ");
		sb.append("INNER JOIN SC_RES SC_RES ON SC_PL.ID_SCRES = SC_RES.ID_SCRES ");
		sb.append("INNER JOIN SC_SRV SC_SRV ON SC_PL.ID_SCSRV = SC_SRV.ID_SCSRV ");
		sb.append("INNER JOIN BD_DAYSLOT BD_DAYSLOT ON SC_SCH.ID_DAYSLOT = BD_DAYSLOT.ID_DAYSLOT ");
		sb.append("LEFT JOIN BD_DEP BD_DEP ON SC_PL.ID_DEP = BD_DEP.ID_DEP ");
		sb.append("WHERE SC_SCH.FG_ACTIVE = ? ");
		sb.append("AND SC_SCH.D_SCH >= ? ");
		sb.append("AND SC_SCH.D_SCH <= ? ");
		sb.append("AND SC_SCH.SD_SCTP = ? ");
		sb.append("ORDER BY SC_SCH.D_SCH,SC_PL.ID_DEP,BD_DAYSLOT.TIME_BEGIN,REMAIN DESC ");
		String sql = sb.toString();
		Logger.info(sql);
		SqlParam param = new SqlParam();
		param.addParam(FBoolean.FALSE);
		param.addParam(bDate);
		param.addParam(eDate);
		param.addParam(IScDictCodeConst.SD_SCTP_OP);
		@SuppressWarnings("unchecked")
		List<SchInfoDTO> list = (List<SchInfoDTO>) new DAFacade().execQuery(sql, param, new BeanListHandler(SchInfoDTO.class));
		if(!EnValidator.isEmpty(list)){
			return list.toArray(new SchInfoDTO[0]);
		}
		return null;
	}
	/**
	 * 对排班信息做处理
	 * 
	 * @param schInfos 排班信息集合
	 * @throws BizException 
	 */
	private void process(SchInfoDTO[] schInfos) throws BizException{
		if(EnValidator.isEmpty(schInfos))
			return;
		Set<String> set = new HashSet<String>();
		for(SchInfoDTO schInfo : schInfos){
			schInfo.setAmpm(EnCodeUtils.dayslotTpTOHisCode(schInfo.getDayslottp()));
			set.add(schInfo.getSrvId());
		}
		LoadSrvPriceBP loadPriceBp = new LoadSrvPriceBP();
		Map<String, FDouble> map = loadPriceBp.getPrice(set.toArray(new String[0]));
		if(map == null || map.size() <= 0)
			return;
		for(SchInfoDTO schInfo : schInfos){
			schInfo.setPrice(map.get(schInfo.getSrvId()).floatValue());
		}
	}
	
	/**
	 * 日期转换
	 * 
	 * @param str
	 * @return
	 */
	private FDate string2FDate(String str){
		try{
			return new FDate(str);
		} catch(Throwable t){
			Logger.error("日期转换出错", t);
		}
		return null;
	}
}
