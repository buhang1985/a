package iih.sc.apt.s.bp;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.sc.apt.dto.d.AptQryDTO;
import iih.sc.comm.ProcResBP;
import iih.sc.sch.reg.dto.d.RegResDTO;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取科室预约资源
 * @author yank
 *
 */
//TODO DELETE
public class GetDepsApptResListBP {
	/**
	 * 获取本科室可预约资源
	 * 本科室使用0号源池，不走诊间渠道
	 * @param qryScheme 查询模板
	 * @return 可预约资源信息集合
	 * @throws BizException
	 */
	public RegResDTO[] exec(AptQryDTO qryScheme) throws BizException{
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("SELECT SCH.ID_SCH,0 AS POLCN,SCH.D_SCH,SCH.T_E_REG,");
		sqlBuilder.append("PL.ID_SCPL,PL.NAME AS NAME_SCPL,PL.SD_TICKMD,PL.ID_DEP,DEP.NAME AS NAME_DEP,PL.PYCODE,");
		sqlBuilder.append("SCH.ID_DAYSLOT,LOT.NAME AS NAME_DAYSLOT,");
		sqlBuilder.append("SRV.ID_SCSRV,SRV.NAME AS NAME_SCSRV,");
		sqlBuilder.append("RES.ID_SCRES,RES.NAME AS NAME_SCRES,RES.ID_EMP,");
		sqlBuilder.append("NVL(SCH.QUAN0_APPT,0) AS TOTAL,");//本科室默认0号源池
		sqlBuilder.append("NVL(SCH.QUAN0_USED,0) AS USED,");//本科室默认0号源池
		sqlBuilder.append("ISNULL(SCH.FG_ACTIVE,'N') AS FG_ACTIVE ");
		sqlBuilder.append("FROM SC_SCH SCH ");
		sqlBuilder.append("INNER JOIN SC_PL PL ON SCH.ID_SCPL=PL.ID_SCPL ");
		sqlBuilder.append("INNER JOIN SC_SRV SRV ON PL.ID_SCSRV=SRV.ID_SCSRV ");
		sqlBuilder.append("INNER JOIN SC_RES RES  ON PL.ID_SCRES=RES.ID_SCRES ");
		sqlBuilder.append("LEFT JOIN BD_DEP DEP ON PL.ID_DEP=DEP.ID_DEP ");
		sqlBuilder.append("LEFT JOIN  BD_DAYSLOT LOT ON LOT.ID_DAYSLOT=SCH.ID_DAYSLOT ");
		sqlBuilder.append(" WHERE 1=1 ");
		SqlParam param = new SqlParam();
		if(StringUtils.isNotEmpty(qryScheme.getId_dept())){
			sqlBuilder.append(" AND PL.ID_DEP=?");
			param.addParam(qryScheme.getId_dept());
		}
		if(qryScheme.getDate()!=null){
			sqlBuilder.append(" AND SCH.D_SCH=?");
			param.addParam(qryScheme.getDate());
		}else{
			//TODO 后期根据时间段过滤
			sqlBuilder.append(" AND  SCH.D_SCH >=? ");
			sqlBuilder.append(" AND  SCH.D_SCH <=? ");
//			FDate nowFdate = ScAppUtils.getServerDateTime().getDate();//取服务端时间
			param.addParam(qryScheme.getD_begin());		
//			IScSchOutQryService schService = ServiceFinder.find(IScSchOutQryService.class);
//			FDate maxRegDate = schService.getMaxAvlRegDate(IScDictCodeConst.SD_SCCHLTP_HOSPITAL_ROOM);//诊间渠道
			param.addParam(qryScheme.getD_end());//从排班渠道中获取最大挂号日期
		}
		if(StringUtils.isNotEmpty(qryScheme.getId_doc())){
			sqlBuilder.append(" AND RES.ID_EMP=?");
			param.addParam(qryScheme.getId_doc());
		}
		if(StringUtils.isNotEmpty(qryScheme.getId_scsrv())){
			sqlBuilder.append(" AND PL.ID_SCSRV=?");
			param.addParam(qryScheme.getId_scsrv());
		}
		
		//排班类型
		sqlBuilder.append(" AND SCH.SD_SCTP=? ");
		String scTp = StringUtil.isEmpty(qryScheme.getSd_sctp()) ? IScDictCodeConst.SD_SCTP_OP : qryScheme.getSd_sctp();//默认为门诊
		param.addParam(scTp);
		
		List<RegResDTO> resDTOList = (List<RegResDTO>) new DAFacade().execQuery(sqlBuilder.toString(), 
									param,new BeanListHandler(RegResDTO.class));
		ProcResBP procBP = new ProcResBP();
		return procBP.exec(resDTOList, true);
	}	
}
