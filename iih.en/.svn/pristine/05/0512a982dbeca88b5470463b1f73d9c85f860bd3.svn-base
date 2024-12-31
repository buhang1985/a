package iih.en.pv.s.bp.op;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.bd.res.dayslot.d.DaysLotDO;
import iih.bd.res.dayslot.i.IDayslotMDORService;
import iih.en.comm.bp.GetBannerDefBP;
import iih.en.comm.ep.DayslotEP;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnParamUtils;
import iih.en.comm.util.EnSqlUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.Ent4BannerDTO;
import iih.en.pv.dto.d.OpRegDTO;
import iih.en.pv.i.IEnOutQryService;
import iih.en.pv.outpatient.d.OutpatientDO;
import iih.en.que.dto.d.TriageBenInfoDTO;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 分诊台Banner查询患者挂号信息
 * 
 * @author liubin
 *
 */
public class GetOpRegForBannerBP {
	
	/**
	 * 分诊台Banner查询患者挂号信息
	 * 
	 * @param sqlStr
	 * @param whereStr
	 * @param selectConditions
	 * @param inputValue
	 * @param triageInfo
	 * @return
	 * @throws BizException
	 */
	public OpRegDTO[] exec(String sqlStr,String whereStr, String[] selectConditions, String inputValue, TriageBenInfoDTO triageInfo) throws BizException{
		//查询挂号信息
		List<OpRegDTO> list = new LinkedList<>();
		OpRegDTO[] opregs = exec(sqlStr, whereStr, triageInfo, FBoolean.FALSE);
		if(!EnValidator.isEmpty(opregs)){
			list.addAll(Arrays.asList(opregs));
		}
		if(!IBdFcDictCodeConst.SD_CODE_ENTP_ET.equals(triageInfo.getCode_entp()) 
				&& EnParamUtils.isUseNoRegTriage()){
			//使用未挂号分诊，查询预约数据
			OpRegDTO[] opAptRegs = getApts(selectConditions, inputValue, triageInfo);
			if(!EnValidator.isEmpty(opAptRegs)){
				list.addAll(Arrays.asList(opAptRegs));
			}
		}
		return EnValidator.isEmpty(list) ? null : list.toArray(new OpRegDTO[0]);
	}
	
	/**
	 * 分诊台Banner查询患者挂号信息
	 * 
	 * @param sqlStr banner的sql查询语句
	 * @param whereStr Banner的where语句
	 * @param benId 分诊台id
	 * @return
	 * @throws BizException
	 */
	private OpRegDTO[] exec(String sqlStr,String whereStr, TriageBenInfoDTO triageInfo, FBoolean containFreeNoTickRegTp) throws BizException{
		if (EnValidator.isEmpty(sqlStr))
			return null;
		FDateTime curTime = EnAppUtils.getAcptQryDateTime(triageInfo.getDate(), triageInfo.getId_dayslot());
		//1.调用Banner服务查询患者就诊信息
		Ent4BannerDTO[] ent4Banners = getEnt4BannerDtos(sqlStr, whereStr, curTime, triageInfo, containFreeNoTickRegTp);
				
		//2.查询患者挂号信息
		OpRegDTO[] opregs = getOpRegs(ent4Banners, triageInfo.getId_queben(), containFreeNoTickRegTp);
		return opregs;
	}

	/**
	 * 调用Banner服务查询患者就诊信息
	 * 
	 * @param sqlStr
	 * @param whereStr
	 * @return
	 * @throws BizException
	 */
	private Ent4BannerDTO[] getEnt4BannerDtos(String sqlStr,String whereStr, FDateTime curTime, TriageBenInfoDTO triageInfo, FBoolean containFreeNoTickRegTp) throws BizException{
		StringBuilder sb = new StringBuilder(whereStr);
		sb.append(String.format(" and %s <= '%s' ",
				OutpatientDO.DT_VALID_B,
				FBoolean.TRUE.equals(containFreeNoTickRegTp) ? EnAppUtils.getAdvanceAcptTime(curTime) : curTime));
		sb.append(String.format(" and %s >= '%s' ", OutpatientDO.DT_VALID_E, curTime));
		sb.append(" and ").append(EnSqlUtils.getOpOrErTpSql(null, triageInfo.getCode_entp()));
		whereStr = sb.toString();
		IEnOutQryService serv = ServiceFinder.find(IEnOutQryService.class);
		return serv.getEntInfo4Banner(sqlStr, whereStr, null);
	}
	/**
	 * 查询患者挂号信息
	 * 
	 * @param ent4Banners
	 * @param benId
	 * @return
	 * @throws BizException 
	 */
	private OpRegDTO[] getOpRegs(Ent4BannerDTO[] ent4Banners, String benId, FBoolean containFreeNoTickRegTp) throws BizException{
		if(EnValidator.isEmpty(ent4Banners))
			return null;
		String[] entIds = EnAppUtils.getKeyPropArrayFromDO("Id_ent", ent4Banners);
		GetOpRegListByPatBP bp = new GetOpRegListByPatBP();
		OpRegDTO[] opregs = bp.getOpRegByEntIds(entIds, containFreeNoTickRegTp);
		this.reSetDayslot(opregs, entIds);
		return opregs;
	}
	/***
	 * @Description:重新设置午别
	 * @param opregs
	 * @param entIds
	 * @throws BizException
	 */
	private void reSetDayslot(OpRegDTO[] opregs,String[] entIds) throws BizException{
		Map<String,OpRegDTO> map = new DayslotEP().getDayslotMapByEntId(entIds);
		if(opregs != null && opregs.length > 0 && map.size() > 0){
			for(OpRegDTO opreg : opregs){
				OpRegDTO dto = map.get(opreg.getId_ent());
				if(dto != null){
					opreg.setId_dateslot(dto.getId_dateslot());
					opreg.setName_dateslot(dto.getName_dateslot());
				}
			}
		}
	}
	/**
	 * 获取预约数据
	 * 
	 * @param selectConditions
	 * @param inputValue
	 * @param benId
	 * @param dayslotId
	 * @return
	 * @throws BizException
	 */
	private OpRegDTO[] getApts(String[] selectConditions, String inputValue, TriageBenInfoDTO triageInfo) throws BizException{
		if(EnValidator.isEmpty(inputValue) 
				|| EnValidator.isEmpty(triageInfo.getId_queben()) 
				|| EnValidator.isEmpty(triageInfo.getId_dayslot()))
			return null;
		String[] patIds = new GetBannerDefBP().getPatIdFromEntBanner(selectConditions, inputValue);
		if(EnValidator.isEmpty(patIds))
			return null;
		return getAptRegs(patIds, triageInfo);
		
	}
	/**
	 * 查询预约数据
	 * 
	 * @param patIds
	 * @param triageInfo
	 * @return
	 * @throws BizException
	 */
	private OpRegDTO[] getAptRegs(String[] patIds, TriageBenInfoDTO triageInfo) throws BizException{
		StringBuilder sqlBuilder = new StringBuilder();
		SqlParam param = new SqlParam();
		sqlBuilder.append(" SELECT APT.ID_APT, ");
		sqlBuilder.append(" APT.ID_PAT, ");
		sqlBuilder.append(" SUBSTR(APT.DT_B, 0, 10) AS DT_ENTRY, ");
		sqlBuilder.append(" APT.DT_APPT  AS DT_INSERT, ");
		sqlBuilder.append(" LOT.ID_DAYSLOT AS ID_DATESLOT, ");
		sqlBuilder.append(" APT.ID_SCRES AS ID_SCRES, ");
		sqlBuilder.append(" APT.ID_SCSRV AS ID_SCSRV, ");
		sqlBuilder.append(" APT.ID_DEP_APPT AS ID_DEP_REG, ");
		sqlBuilder.append(" APT.QUENO AS SORTNO,");
		sqlBuilder.append(" LOT.NAME AS NAME_DATESLOT, ");
		sqlBuilder.append(" SCRES.NAME AS NAME_SCRES, ");
		sqlBuilder.append(" SCSRV.NAME AS NAME_SCSRV, ");
		sqlBuilder.append(" DEP.NAME AS NAME_DEP_REG ");
		sqlBuilder.append(" FROM SC_APT APT ");
		sqlBuilder.append(" INNER JOIN SC_APT_OP OP ON APT.ID_APT = OP.ID_APT ");
		sqlBuilder.append(" INNER JOIN BD_DAYSLOT LOT ON APT.ID_DATESLOT = LOT.ID_DAYSLOT ");
		sqlBuilder.append(" INNER JOIN SC_RES SCRES ON APT.ID_SCRES = SCRES.ID_SCRES ");
		sqlBuilder.append(" INNER JOIN SC_SRV SCSRV ON APT.ID_SCSRV = SCSRV.ID_SCSRV ");
		sqlBuilder.append(" INNER JOIN SC_SCH SCH ON APT.ID_SCH = SCH.ID_SCH AND SCH.FG_ACTIVE = 'Y' ");
		sqlBuilder.append(" INNER JOIN SC_PL SCPL ON SCH.ID_SCPL = SCPL.ID_SCPL AND SCPL.FG_ACTIVE = 'Y' ");
		sqlBuilder.append(" LEFT JOIN BD_DEP DEP ON APT.ID_DEP_APPT = DEP.ID_DEP ");
		sqlBuilder.append(" WHERE APT.SD_STATUS = ? ");
		param.addParam(IScDictCodeConst.SD_APTSTATUS_ORDER);
		sqlBuilder.append(" AND APT.ID_DATESLOT = ? "); 
		param.addParam(triageInfo.getId_dayslot());
		sqlBuilder.append(" AND SCPL.ID_QUEBEN = ? ");
		param.addParam(triageInfo.getId_queben());
		sqlBuilder.append(" AND SCH.D_SCH = ? ");
		param.addParam(triageInfo.getDate());
		sqlBuilder.append(" AND ").append(EnSqlUtils.getInSqlByIds(" APT.ID_PAT ", patIds));
		String sql = sqlBuilder.toString();
		List<OpRegDTO> list = (List<OpRegDTO>) new DAFacade().execQuery(sql, param, new BeanListHandler(OpRegDTO.class));
		return EnValidator.isEmpty(list) ? null : list.toArray(new OpRegDTO[0]);
	}
	/**
	 * 获取日期分组
	 * 
	 * @param dayslotId
	 * @return
	 * @throws BizException
	 */
	private DaysLotDO getDayslot(String dayslotId) throws BizException{
		IDayslotMDORService serv = ServiceFinder.find(IDayslotMDORService.class);
		return serv.findById(dayslotId);
	}
}
