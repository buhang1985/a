package iih.sc.sch.reg.refs;

import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.sc.scbd.scheduleca.d.ScheduleCADO;
import iih.sc.scbd.scheduleca.i.ISchedulecaRService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.log.logging.Logger;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.refinfo.RefGridModel;

/**
 * 可挂号资源
 * @author yankan
 *
 */
public class Res4RegRefModel extends RefGridModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6473484965819412554L;
	private static final String DAYSLOT_ALL = "99999999999999999999";

	/**
	 * 显示字段名称
	 */
	@Override
	public String[] getShowFieldName() {		
		return new String[] { "计划名称", "科室", "午别", "余号", "总号","输入码"};
	}
	/**
	 * 显示字段
	 */
	@Override
	public String[] getShowFieldCode() {
		return new String[] { "Name_scpl","Name_dep","Name_dayslot","Remain", "Total", "Pycode"};
	}
	
	/**
	 * 参照标题
	 */
	@Override
	public String getRefTitle() {
		return "挂号资源";
	}

	@Override
	public String[] getHiddenFieldCode() {		
		return new String[] { "Id_sch", "Id_scpl", "Sd_tickmd","Id_dep","Id_dayslot","Id_scsrv", "Name_scsrv","Id_scres", 
				   "Id_emp" };
	}

	@Override
	public String getPkFieldCode() {		
		return "Id_sch";
	}

	@Override
	public String getRefCodeField() {		
		return "Pycode";
	}

	@Override
	public String getRefNameField() {		
		return "Name_scpl";
	}

	@Override
	public String[] getBlurFields() {		
		return new String[]{"Pycode","Name_scpl"};
	}

	@Override
	public String getTableName() {		
		return "REGRES";
	}
	
	@Override
	public String getRefSql() {			
		String register_date = (String)this.getExtendAttributeValue("registed_date");
		String dayslotId = (String) this.getExtendAttributeValue("dayslotId"); //可用午别拼sql，带单引号，只有当前午别为全部时有值
		String currDayslotId = (String) this.getExtendAttributeValue("dayslot"); //当前选择的午别，包含"全部"
		String sctp = (String)this.getExtendAttributeValue("sctp");
		String pcMgedDepIds = (String)this.getExtendAttributeValue("depIds");//PC管理的科室列表
		String canRegDepIDs = (String) this.getExtendAttributeValue("canRegDepIDs");//PC管理的科室列表
		String scchltp = (String) this.getExtendAttributeValue("scchltp");//渠道类型编码
		
		StringBuilder sqlBuilder = new StringBuilder();	
		sqlBuilder.append("SELECT * FROM (");
		sqlBuilder.append("SELECT CASE WHEN ISNULL(SCH.FG_ACTIVE,'N')='N' THEN '(停)'||PL.NAME  ELSE PL.NAME END AS NAME_SCPL,");
		sqlBuilder.append("DEP.NAME AS NAME_DEP,LOT.NAME AS NAME_DAYSLOT,");
		sqlBuilder.append("CASE WHEN ISNULL(SCH.FG_ACTIVE,'N')='N' THEN 0 ELSE SCH.QUAN0_APPT- NVL(SCH.QUAN0_USED,0) END AS REMAIN,");
		sqlBuilder.append("SCH.QUAN0_APPT AS TOTAL,");
		sqlBuilder.append("PL.PYCODE,");
		sqlBuilder.append("SCH.ID_SCH,PL.ID_SCPL,PL.SD_TICKMD,PL.ID_DEP,SCH.ID_DAYSLOT,");
		sqlBuilder.append("SRV.ID_SCSRV,SRV.NAME AS NAME_SCSRV,RES.ID_SCRES,RES.ID_EMP,LOT.TIME_BEGIN");		
		sqlBuilder.append(" FROM SC_SCH SCH ");
		sqlBuilder.append(" INNER JOIN SC_PL PL ON SCH.ID_SCPL = PL.ID_SCPL ");
		sqlBuilder.append(" INNER JOIN SC_SRV SRV ON PL.ID_SCSRV=SRV.ID_SCSRV ");
		sqlBuilder.append(" INNER JOIN SC_RES RES  ON PL.ID_SCRES=RES.ID_SCRES ");
		sqlBuilder.append(" INNER JOIN SC_SCH_CHL SCHCHL ON SCH.ID_SCH = SCHCHL.ID_SCH ");
		sqlBuilder.append(" INNER JOIN SC_CHL CHL ON SCHCHL.ID_SCCHL = CHL.ID_SCCHL ");
		sqlBuilder.append(" LEFT JOIN BD_DEP DEP ON PL.ID_DEP=DEP.ID_DEP ");
		sqlBuilder.append(" LEFT JOIN  BD_DAYSLOT LOT ON LOT.ID_DAYSLOT=SCH.ID_DAYSLOT ");
		sqlBuilder.append(" WHERE 1=1 ");
		
		//排班类型，默认为门诊
		String scTp = StringUtil.isEmpty(sctp) ? IScDictCodeConst.SD_SCTP_OP : sctp;
		
		//查询日期分组分类
		String dayslotCaId = getDayslotCaId(scTp);
		
		sqlBuilder.append(String.format(" AND PL.SD_SCTP='%s' ",scTp));
		if(!StringUtil.isEmpty(pcMgedDepIds)){
			//sqlBuilder.append(String.format(" AND PL.ID_DEP='%s' ",scTp));
		}
		if(StringUtil.isEmptyWithTrim(scchltp))
			scchltp = IScDictCodeConst.SD_SCCHLTP_HOSPITAL_WINDOW;
		sqlBuilder.append(String.format(" AND CHL.SD_SCCHLTP ='%s' ",scchltp));
		if(!StringUtil.isEmpty(canRegDepIDs)){
			if(canRegDepIDs.equals("%")){
				
			}else if(canRegDepIDs.equals("NO_ANY_DEPT")){
				sqlBuilder.append("AND PL.ID_DEP IN ('')");
			}
			else{
				sqlBuilder.append("AND PL.ID_DEP IN ("+canRegDepIDs+")");
			}
		}else{
			//sqlBuilder.append("AND PL.ID_DEP='%' ");
		}
		if (!StringUtils.isEmpty(register_date)){
			sqlBuilder.append(String.format(" AND SCH.D_SCH='%s'",register_date));//挂号日期
		}		
		sqlBuilder.append(String.format(" AND LOT.ID_DAYSLOTCA='%s'",dayslotCaId));//日期分组类别
		//午别
		if (!StringUtils.isEmpty(currDayslotId)){
			String tempDayslotId = null;
			if(!StringUtil.isEmpty(dayslotId)){
				tempDayslotId = dayslotId;
			}else if(!DAYSLOT_ALL.equals(currDayslotId)){
				tempDayslotId = "'" + currDayslotId + "'";
			}
			if(!StringUtil.isEmptyWithTrim(tempDayslotId))
				sqlBuilder.append(" AND SCH.ID_DAYSLOT IN (" + tempDayslotId + ")");
		}
		sqlBuilder.append(") REGRES ");

		List<String> whereList = this.getWherePart();
		if (whereList.size() > 0) {	
			sqlBuilder.append(" WHERE 1=1 ");
			for (String where : this.getWherePart()) {
				sqlBuilder.append(" And (").append(where).append(") ");
			}
		}
		sqlBuilder.append(" ORDER BY NAME_DEP,TIME_BEGIN ASC,REMAIN DESC");//按科室名称、开始时间、剩余号源倒叙
		return sqlBuilder.toString();
	}
	/**
	 * 获取日期分组分类id
	 * @return
	 */
	private String getDayslotCaId(String scTp){
		ISchedulecaRService schCaService = ServiceFinder.find(ISchedulecaRService.class);
		String whereStr = String.format("sd_sctp='%s'",scTp);
		ScheduleCADO[] schCaDOs=null;
		try {
			schCaDOs = schCaService.find(whereStr, null, FBoolean.FALSE);
		} catch (BizException e) {
			e.printStackTrace();
		}
		if(ArrayUtils.isEmpty(schCaDOs)){
			Logger.error("排班分类中，没有定义门诊的日期分组");
			return null;
		}		
		String dayslotCaId = schCaDOs[0].getId_dayslottp();
		return dayslotCaId;
	}
}
