package iih.sc.apt.s.bp;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.sc.apt.dto.d.ScAptMtDto;
import iih.sc.comm.ScAppUtils;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.util.CollectionUtils;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取病人预约安排dto
 * @author ccj
 *
 */
public class GetAptMtPatInfoBp {
	/**
	 * 获取病人预约安排dto
	 * @param id_ent 就诊id
	 * @return
	 * @throws BizException
	 */
	public ScAptMtDto[] exec(String id_ent) throws BizException {
		if (StringUtils.isBlank(id_ent))
			return null;
		StringBuffer sb = new StringBuffer();
		SqlParam param = new SqlParam();
		sb.append("SELECT APT.DT_B AS T_B ,APT.DT_E AS T_E,APT.ID_APT,APT.SD_STATUS,APT.ID_SCCHL,");
		sb.append("APT.QUENO,APT.SD_STATUS,MT.CONTENT_OR,MT.ID_DEP_MP AS ID_DEP,MT.FG_URGENT,MT.ID_OR,DEP.NAME AS ID_DEP_MP_NAME, ");
		sb.append("SRV.NAME AS SRV_NAME,PAT.NAME AS ID_PAT_NAME,PAT.DT_BIRTH AS AGE ,BD_SEX.NAME AS SEX_NAME,");
		sb.append("OBS.NO_APPLYFORM,SCH.SUGEST_EXMINT,PL.NOTE ");
		sb.append("FROM SC_APT APT ");
		sb.append("INNER JOIN SC_APT_MT MT ON APT.ID_APT = MT.ID_APT AND MT.ID_ENT = ? ");
		sb.append("AND APT.SD_STATUS IN (?, ?, ?) AND APT.DT_B >= ? ");
		sb.append("INNER JOIN SC_SCH SCH ON SCH.ID_SCH = APT.ID_SCH ");
		sb.append("INNER JOIN SC_PL PL ON PL.ID_SCPL = SCH.ID_SCPL ");
		sb.append("INNER JOIN CI_AP_OBS OBS ON OBS.ID_OR = MT.ID_OR ");
		sb.append("INNER JOIN BD_DEP DEP ON DEP.ID_DEP = MT.ID_DEP_MP ");
		sb.append("INNER JOIN SC_SRV SRV ON APT.ID_SCSRV = SRV.ID_SCSRV ");
		sb.append("INNER JOIN PI_PAT PAT ON APT.ID_PAT = PAT.ID_PAT ");
		sb.append("INNER JOIN BD_UDIDOC BD_SEX ON BD_SEX.ID_UDIDOC = PAT.ID_SEX ");
		param.addParam(id_ent);
		param.addParam(IScDictCodeConst.SD_APTSTATUS_ORDER);
		param.addParam(IScDictCodeConst.SD_APTSTATUS_PAY);
		param.addParam(IScDictCodeConst.SD_APTSTATUS_FINISH);
		param.addParam(new FDate().toString());
		List<ScAptMtDto> reList = (List<ScAptMtDto>)new DAFacade().execQuery(sb.toString(), param, new BeanListHandler(ScAptMtDto.class));
		if (CollectionUtils.isEmpty(reList))
			return null;
		for (ScAptMtDto scAptMtDto : reList) {
			FDateTime date_begin = scAptMtDto.getT_b();
			String month = ScAppUtils.getMonth(date_begin.toString());// 月
			String week = ScAppUtils.getWeek(date_begin.toString());// 周
			String time_slot = getTimeSlot(date_begin.toString(), scAptMtDto.getT_e().toString());// 获取时间段
			scAptMtDto.setMonth(month);// 月
			scAptMtDto.setWeek(week);// 周
			scAptMtDto.setTime_slot(time_slot);// 时间段
			scAptMtDto.setAge(AgeCalcUtil.getAge(new FDate(scAptMtDto.getAge())));
			FDateTime newFDateTime = scAptMtDto.getT_b().subSeconds( Integer.parseInt(scAptMtDto.getSugest_exmint()) * 60  );
			scAptMtDto.setSugest_exmint(newFDateTime.getTime());
		}
		return reList.toArray(new ScAptMtDto[reList.size()]);
	}

	/**
	 * 获取时间段
	 * @param begTime  预约开始时间
	 * @param endTime	预约结束时间
	 * @return
	 * @throws BizException 
	 */
	private String getTimeSlot(String begTime, String endTime) throws BizException {
		String[] begTimes = begTime.split(" ");
		String[] endTimes = endTime.split(" ");
		begTime = begTimes[1].substring(0, 5);
		endTime = endTimes[1].substring(0, 5);
		return begTime + "-" + endTime;
	}
}
