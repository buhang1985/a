package iih.en.pv.s.bp.ip.qry;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.IBlDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.inpatient.dto.d.IpRegQrySchmDTO;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 查询住院出院列表信息信息
 * 
 * @author li.wm
 */
public class GetIpLeaveListBp extends GetIpOutDeptListBP {
	
	
	/***
	 * 获取出院查询基本sql
	 * @param qrySchm
	 * @param param
	 * @return
	 */
	@Override
	protected String getLeaveSql(IpRegQrySchmDTO qrySchm,SqlParam param) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT distinct ENT.ID_ENT, ");
		sql.append("DEP.NAME AS Name_dep_phy, " );
		sql.append("PAT.ID_PAT AS ID_PAT, " );
		sql.append("BED.NAME AS Name_bed, " );
		sql.append("IP.CODE_AMR_IP, " );
		sql.append("PAT.NAME AS Name_pat, " );
		sql.append("PAT.ID_CODE AS Id_code, " );
		sql.append("SEX.NAME AS Name_sex, " );
		sql.append("PAT.DT_BIRTH AS Dt_birth, " );
		sql.append("pat.dt_birth_hms as Dt_birth_hms,");
		sql.append("NVL(PAT.MOB,PAT.TEL) AS Telno_pat, " );
		sql.append("ENT.DT_ENTRY AS Dt_entry, " );
		sql.append("ENT.DT_ACPT AS DT_ACPT, " );//入科时间
		sql.append("ENT.DT_END, " );
		sql.append("NVL(acc.amt_uncg,0)  as Amt_uncg,");
		sql.append("NVL(acc.AMT_TOTAL,0) AS AMT, " );
		sql.append(" ca.name as Name_patca,");//renzhi 添加患者分类 2018年05月30
		sql.append("ENT.FG_IP AS Fg_ip, " );
		sql.append("ENT.FG_ST, " );
		sql.append("STIP.FG_PAY, " );
		sql.append("DOC.NAME AS Doc_resp, " );
		sql.append("AREA.FULLNAME || addr.street AS Addr_pat, " );
		sql.append("ENT.DT_END AS Dt_tran, ");
		//转入科室
		sql.append(" '' as Name_dep_trans, ");
		//转入病区
		sql.append(" '' as Name_nur_trans, ");
		sql.append(" IP.TIMES_IP, ");//住院次数
		sql.append(" DEPOUT.NAME AS NAME_DEP_OUT, ");//出院科室名称
		sql.append(" NUROUT.NAME AS NAME_DEP_NUR_OUT, ");//出院病区名称
		sql.append("STIP.ID_STIP as Id_stip, ");
		sql.append(" case when exists(select 1 from ci_order ord where   ord.ID_EN = ENT.ID_ENT AND ord.FG_CANC = 'N' AND ord.SD_SRVTP = '"+IBdSrvDictCodeConst.SD_SRVTP_PATIMAN_CLIDEATH+"') then 'Y' else 'N' end Fg_died ");
		//sql.append("CASE WHEN CI.SD_SRVTP = '"+IBdSrvDictCodeConst.SD_SRVTP_PATIMAN_CLIDEATH+"' THEN 'Y' ELSE 'N' END AS Fg_died ");
		sql.append("FROM EN_ENT ENT " );
		sql.append(" left join en_ent_acc acc on acc.id_ent = ent.id_ent ");
		if(FBoolean.TRUE.equals(qrySchm.getFg_shownb())){
			sql.append("INNER JOIN EN_ENT_IP IP ON IP.ID_ENT = ENT.ID_ENT " );
		}else{
			sql.append("INNER JOIN EN_ENT_IP IP ON IP.ID_ENT = ENT.ID_ENT AND IP.FG_NEWBORN = '"+FBoolean.FALSE+"' " );
		}
		sql.append("INNER JOIN BD_DEP DEP ON DEP.ID_DEP = ENT.ID_DEP_PHY " );
		sql.append("INNER JOIN BD_BED BED ON BED.ID_BED = IP.ID_BED " );
		sql.append("INNER JOIN PI_PAT PAT ON PAT.ID_PAT = ENT.ID_PAT " );
		sql.append(" left join pi_pat_ca ca ");//renzhi 添加患者分类 2018年05月30
		sql.append(" on ca.id_patca = ent.id_patca ");//renzhi 添加患者分类 2018年05月30
		sql.append("LEFT JOIN BD_UDIDOC SEX ON SEX.ID_UDIDOC = PAT.ID_SEX " );
		sql.append("LEFT JOIN BL_ST_IP STIP ON STIP.ID_ENT = ENT.ID_ENT AND STIP.FG_CANC = '"+FBoolean.FALSE+"' AND STIP.EU_DIRECT = "+IBlDictCodeConst.SD_DIRECT_CHARGE+" " );
		//sql.append("LEFT JOIN BL_PAY_PAT_IP PAY ON PAY.ID_STIP = STIP.ID_STIP " );
		sql.append("LEFT JOIN EN_ENT_EMP EMP ON EMP.ID_ENT = ENT.ID_ENT AND EMP.SD_EMPROLE = '"+IEnDictCodeConst.SD_EMPROLE_DOCTOR+"' AND EMP.DT_E = ENT.DT_END " );
		sql.append("LEFT JOIN BD_PSNDOC DOC ON DOC.ID_PSNDOC = EMP.ID_EMP " );
		sql.append("LEFT JOIN PI_PAT_ADDR ADDR ON ADDR.ID_PAT = PAT.ID_PAT AND ADDR.SD_ADDRTP = '"+IPiDictCodeConst.SD_ADDR_TYPE_NOW+"' " );
		sql.append("LEFT JOIN BD_ADMINAREA AREA ON AREA.ID_ADMINAREA = ADDR.ID_ADMDIV " );
		sql.append("LEFT JOIN BD_DEP DEPOUT ON DEPOUT.ID_DEP = IP.ID_DEP_PHYDISC " );
		sql.append("LEFT JOIN BD_DEP NUROUT ON NUROUT.ID_DEP = IP.ID_DEP_NURDISC " );
		//sql.append("LEFT JOIN CI_ORDER CI ON CI.ID_EN = ENT.ID_ENT AND CI.FG_CANC = '"+FBoolean.FALSE+"' ");
		//sql.append("AND CI.SD_SRVTP = '"+IBdSrvDictCodeConst.SD_SRVTP_PATIMAN_CLIDEATH+"' ");
		//sql.append("INNER JOIN BD_DEP BDEP ON BDEP.ID_DEP = IP.ID_DEP_PHYDISC " );
		sql.append("WHERE ENT.FG_CANC = ? " );
		param.addParam(FBoolean.FALSE);
		sql.append("AND IP.SD_STATUS = ? " );
		param.addParam(IEnDictCodeConst.SD_ENSTATUS_IN_HOSPITALOUT);
		//查询开始日期
		if(qrySchm.getD_begin() != null){
			sql.append("AND ENT.DT_END >= ? " );
			param.addParam(qrySchm.getD_begin());
		}
		//查询结束日期
		if(qrySchm.getD_end() != null){
			sql.append("AND ENT.DT_END <= ? " );
			param.addParam(qrySchm.getD_end());
		}
		//科室
		if(!EnValidator.isEmpty(qrySchm.getId_dep_phy())){
			sql.append("AND IP.ID_DEP_PHYDISC = ? " );
			param.addParam(qrySchm.getId_dep_phy());
		}
		//病区
		if(!EnValidator.isEmpty(qrySchm.getId_dep_nur())){
			sql.append("AND IP.ID_DEP_NURDISC = ? " );
			param.addParam(qrySchm.getId_dep_nur());
		}
		//患者姓名
		if(!EnValidator.isEmpty(qrySchm.getName_pat())){
			sql.append("AND PAT.NAME LIKE ? " );
			param.addParam("%"+qrySchm.getName_pat()+"%");
		}
		//患者分类
		if(!EnValidator.isEmpty(qrySchm.getName_patca())){
			sql.append("AND CA.NAME LIKE ? " );
			param.addParam("%"+qrySchm.getName_patca()+"%");
		}
		//住院号
		if(!EnValidator.isEmpty(qrySchm.getCode_amr_ip())){
			sql.append("AND IP.CODE_AMR_IP = ? " );
			param.addParam(qrySchm.getCode_amr_ip());
		}
		//死亡标志
		if(FBoolean.TRUE.equals(qrySchm.getFg_died())){
			sql.append("and exists(select 1 from ci_order ord where  ord.ID_EN = ENT.ID_ENT AND ord.FG_CANC = 'N' AND ord.SD_SRVTP = ?) ");
			param.addParam(IBdSrvDictCodeConst.SD_SRVTP_PATIMAN_CLIDEATH);
		}
		
		//增加出院未结算，结算未付款过滤按钮 ,zhangpp - 2018-11-13
		 //结算标志
        if(FBoolean.TRUE.equals(qrySchm.getFg_st()) || FBoolean.FALSE.equals(qrySchm.getFg_st())){
        	sql.append(" and ent.fg_st = ? ");
        	param.addParam(qrySchm.getFg_st());
        }
        //支付标志
        if(FBoolean.TRUE.equals(qrySchm.getFg_payed()) || FBoolean.FALSE.equals(qrySchm.getFg_payed())){
        	if (FBoolean.TRUE.equals(qrySchm.getFg_payed())) {
				sql.append(" AND ");
			}
        	if (FBoolean.FALSE.equals(qrySchm.getFg_payed())) {
				sql.append(" AND NOT ");
			}
        	sql.append(" EXISTS ( SELECT * FROM BL_ST_IP STIP WHERE STIP.ID_ENT = ENT.ID_ENT AND STIP.EU_DIRECT = '1' AND STIP.FG_CANC = 'N' AND STIP.FG_PAY = 'Y' ) ");
        }
        if(FBoolean.TRUE.equals(qrySchm.getFg_tran())){
        	sql.append(" ");
        }else{
        	sql.append(" ORDER BY IP.CODE_AMR_IP desc  ");
        }
        return sql.toString();
	}
	
}
