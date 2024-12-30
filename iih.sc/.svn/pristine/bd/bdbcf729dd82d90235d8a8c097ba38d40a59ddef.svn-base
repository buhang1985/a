package iih.sc.apt.s.bp;

import java.util.List;

import iih.sc.sch.i.IScSchOutQryService;
import iih.sc.sch.reg.dto.d.RegResDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FDate;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取已预约的门诊资源
 * 
 * @author yank
 *
 */
public class GetApptedResListBP {
	/**
	 * 获取已预约资源
	 * 
	 * @param patId 患者id
	 * @param dt_begin 起始日期
	 * @return 预约资源信息集合
	 * @throws BizException
	 */
	public RegResDTO[] exec(String patId, FDate dt_begin) throws BizException {
		// 1、获取已预约资源
		RegResDTO[] regResDTOs = this.getApptedResList(patId, dt_begin);
		// 2、加载价格
		IScSchOutQryService schService = ServiceFinder.find(IScSchOutQryService.class);
		schService.loadResPri(regResDTOs);

		return regResDTOs;
	}

	/**
	 * 获取已预约资源
	 * 
	 * @param patId 患者id
	 * @param dt_begin 起始日期
	 * @return 预约资源信息集合
	 * @throws BizException
	 */
	private RegResDTO[] getApptedResList(String patId, FDate dt_begin) throws BizException {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("SELECT APT.ID_APT,APT.ID_SCCHL,SCH.ID_SCH,PL.ID_SCPL,PL.SD_TICKMD,");
		sqlBuilder.append("SCH.D_SCH,SCH.ID_DAYSLOT,LOT.NAME AS NAME_DAYSLOT,");
		sqlBuilder.append("SRV.ID_SCSRV,SRV.NAME AS NAME_SCSRV,");
		sqlBuilder.append("RES.ID_SCRES,RES.NAME AS NAME_SCRES,RES.ID_DEP,DEP.NAME AS NAME_DEP, RES.ID_EMP,RES.PYCODE,");
		sqlBuilder.append("APT.SD_STATUS ");
		sqlBuilder.append("FROM SC_APT APT");
		sqlBuilder.append(" INNER JOIN SC_SCH SCH ON SCH.ID_SCH=APT.ID_SCH");
		sqlBuilder.append(" INNER JOIN SC_PL PL ON SCH.ID_SCPL = PL.ID_SCPL ");
		sqlBuilder.append(" INNER JOIN SC_SRV SRV ON PL.ID_SCSRV=SRV.ID_SCSRV ");
		sqlBuilder.append(" INNER JOIN SC_RES RES  ON PL.ID_SCRES=RES.ID_SCRES ");
		sqlBuilder.append(" LEFT JOIN BD_DEP DEP ON RES.ID_DEP=DEP.ID_DEP ");
		sqlBuilder.append(" LEFT JOIN  BD_DAYSLOT LOT ON LOT.ID_DAYSLOT=SCH.ID_DAYSLOT ");
		sqlBuilder.append(" WHERE 1=1 ");

		// 患者id
		SqlParam param = new SqlParam();
		sqlBuilder.append(" AND ID_PAT=? ");
		param.addParam(patId);
		if (dt_begin != null) {
			sqlBuilder.append(" AND SUBSTR(DT_B,0,10)>? ");
			param.addParam(dt_begin);
		}

		DAFacade daf = new DAFacade();
		List<RegResDTO> resList = (List<RegResDTO>) daf.execQuery(sqlBuilder.toString(), param,
				new BeanListHandler(RegResDTO.class));
		if (!ListUtil.isEmpty(resList)) {
			return resList.toArray(new RegResDTO[0]);
		}
		return null;
	}
}
