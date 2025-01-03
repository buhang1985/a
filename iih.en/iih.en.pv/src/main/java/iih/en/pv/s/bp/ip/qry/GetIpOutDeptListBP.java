package iih.en.pv.s.bp.ip.qry;

import iih.bd.base.utils.SqlUtils;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.IBlDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.en.comm.ep.DeptEP;
import iih.en.comm.util.EnAgeCalcUtil;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.inpatient.dto.d.IpRegInfoDTO;
import iih.en.pv.inpatient.dto.d.IpRegQrySchmDTO;
import iih.en.pv.s.bp.ip.CalculateHosDaysBP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.orgfw.dept.d.DeptDO;

/**
 * 查询住院出科列表信息信息
 * 
 * @author liubin
 */
public class GetIpOutDeptListBP {
	/**
	 * 查询住院出科列表信息信息
	 * @param qrySchm 查询模板
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<IpRegInfoDTO> exec(IpRegQrySchmDTO qrySchm, PaginationInfo pageInfo) throws BizException{
		PagingRtnData<IpRegInfoDTO> pageBedDTO = new PagingRtnData<IpRegInfoDTO>();
		//0.获取基本数据
		pageBedDTO = this.getBaseList(qrySchm, pageInfo);
		//1.批量查询年龄
		this.getAge(pageBedDTO);
		//2.查询住院天数，fanlq-2018-10-27
		this.getInHosDays(pageBedDTO);
		//3.批量查询诊断
		this.getPatMainDi(pageBedDTO);
		//3.获取入院诊断和出院诊断 - zhangpp
		this.getPatDi(pageBedDTO);
		//4.获取患者医保信息
		this.getPatHp(pageBedDTO);
		return pageBedDTO;
	}
	/***
	 * 获取基本数据
	 * 
	 * @param qrySchm
	 * @param pageInfo
	 * @return
	 * @throws BizException
	 */
	private PagingRtnData<IpRegInfoDTO> getBaseList(IpRegQrySchmDTO qrySchm, PaginationInfo pageInfo) throws BizException{
		@SuppressWarnings({ "unchecked", "rawtypes" })
		PagingServiceImpl<IpRegInfoDTO> service =new PagingServiceImpl();
		SqlParam param = new SqlParam();
		SqlParam tranparam = new SqlParam();
		String sql = getLeaveSql(qrySchm,param);
		String transql = null;
		if(FBoolean.TRUE.equals(qrySchm.getFg_tran()) && FBoolean.FALSE.equals(qrySchm.getFg_leave())){
			sql = this.getTranSql(qrySchm, tranparam);
			param = tranparam;
		}else if(FBoolean.TRUE.equals(qrySchm.getFg_tran()) && FBoolean.TRUE.equals(qrySchm.getFg_leave())){
			transql = this.getTranSql(qrySchm, param);
			sql = sql+" union "+transql;
		}
		PagingRtnData<IpRegInfoDTO> datas = service.findByPageInfo(new IpRegInfoDTO(), pageInfo, sql, "", param);
		assemly(datas);
		return datas;
	}
	/**
	 * 进行数据处理
	 * @param datas
	 * @throws BizException 
	 * @Author ltf
	 */
	@SuppressWarnings({ "unchecked", "null", "unused" })
	private void assemly(PagingRtnData<IpRegInfoDTO> datas) throws BizException {
		FArrayList lists = datas.getPageData();
		if(EnValidator.isEmpty(lists))
			return;
		Set<String> depIds = new HashSet<String>();
		for (Object o : lists) {
			IpRegInfoDTO ipRegInfoDTO = (IpRegInfoDTO)o;
			//当前科室
			if(ipRegInfoDTO.getId_dep_phy()!=null && ipRegInfoDTO.getId_dep_phy().length()>0){
				depIds.add(ipRegInfoDTO.getId_dep_phy());
			}
			//当前病区
			if(ipRegInfoDTO.getId_dep_nur()!=null && ipRegInfoDTO.getId_dep_nur().length()>0){
				depIds.add(ipRegInfoDTO.getId_dep_nur());
			}
			//转出科室
			if(ipRegInfoDTO.getId_dep_from()!=null && ipRegInfoDTO.getId_dep_from().length()>0){
				depIds.add(ipRegInfoDTO.getId_dep_from());
			}
			//转出病区
			if(ipRegInfoDTO.getId_nur_from()!=null && ipRegInfoDTO.getId_nur_from().length()>0){
				depIds.add(ipRegInfoDTO.getId_nur_from());
			}
			//转入科室
			if(ipRegInfoDTO.getId_dep_trans()!=null && ipRegInfoDTO.getId_dep_trans().length()>0){
				depIds.add(ipRegInfoDTO.getId_dep_trans());
			}
			//转入病区
			if(ipRegInfoDTO.getId_nur_trans()!=null && ipRegInfoDTO.getId_nur_trans().length()>0){
				depIds.add(ipRegInfoDTO.getId_nur_trans());
			}
			//出院科室
			if(ipRegInfoDTO.getId_dep_out()!=null && ipRegInfoDTO.getId_dep_out().length()>0){
				depIds.add(ipRegInfoDTO.getId_dep_out());
			}
			//出院病区
			if(ipRegInfoDTO.getId_dep_nur_out()!=null && ipRegInfoDTO.getId_dep_nur_out().length()>0){
				depIds.add(ipRegInfoDTO.getId_dep_nur_out());
			}
		}
		if(depIds==null && depIds.size()==0){
			return;
		}
			//查询结果返回map
		DeptEP ep = new DeptEP();
		Map<String,DeptDO> map= ep.getDeptMapSet(depIds);
		if(map==null && map.size()==0){
			return;
		}
		for ( Object obj : lists) {
			IpRegInfoDTO dto = (IpRegInfoDTO)obj;
			//当前科室
			if(map.containsKey(dto.getId_dep_phy()) && map.get(dto.getId_dep_phy())!=null){
				dto.setName_dep_phy(map.get(dto.getId_dep_phy()).getName());
			}
			//当前病区
			if(map.containsKey(dto.getId_dep_nur()) && map.get(dto.getId_dep_nur())!=null){
				dto.setName_dep_nur(map.get(dto.getId_dep_nur()).getName());
			}
			//转出科室
			if(map.containsKey(dto.getId_dep_from()) && map.get(dto.getId_dep_from()).getName()!=null){
				dto.setName_dep_from(map.get(dto.getId_dep_from()).getName());
			}
			//转出病区
			if(map.containsKey(dto.getId_nur_from()) && map.get(dto.getId_nur_from()).getName()!=null){
				dto.setName_nur_from(map.get(dto.getId_nur_from()).getName());
			}
			//转入科室
			if(map.containsKey(dto.getId_dep_trans()) && map.get(dto.getId_dep_trans()).getName()!=null){
				dto.setName_dep_trans(map.get(dto.getId_dep_trans()).getName());
			}
			//转入病区
			if(map.containsKey(dto.getId_nur_trans()) && map.get(dto.getId_nur_trans()).getName()!=null){
				dto.setName_nur_trans(map.get(dto.getId_nur_trans()).getName());
			}
			//出院科室
			if(map.containsKey(dto.getId_dep_out()) && map.get(dto.getId_dep_out()).getName()!=null){
				dto.setName_dep_out(map.get(dto.getId_dep_out()).getName());
			}
			//出院病区
			if(map.containsKey(dto.getId_dep_nur_out()) && map.get(dto.getId_dep_nur_out()).getName()!=null){
				dto.setName_dep_nur_out(map.get(dto.getId_dep_nur_out()).getName());
			}
		}
		datas.setPageData(lists);
	}
	/***
	 * 获取出院查询基本sql
	 * @param qrySchm
	 * @param param
	 * @return
	 */
	protected String getLeaveSql(IpRegQrySchmDTO qrySchm,SqlParam param){
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT distinct ENT.ID_ENT, ");
		sql.append("CA.NAME AS NAME_PATCA,");
		sql.append(" '' AS ID_DEP_FROM, " ); //转出科室ID
		sql.append(" '' AS ID_NUR_FROM, " ); //转出病区ID
		sql.append(" ENT.ID_DEP_PHY AS ID_DEP_PHY, "); //当前科室ID
		sql.append(" ENT.ID_DEP_NUR AS ID_DEP_NUR, "); //当前病区ID
		sql.append(" '' AS ID_DEP_TRANS, "); //转入科室ID
		sql.append(" '' AS ID_NUR_TRANS, "); //转入病区ID
		sql.append(" IP.ID_DEP_PHYDISC ID_DEP_OUT, ");//出院科室
		sql.append(" Ip.ID_DEP_NURDISC ID_DEP_NUR_OUT, ");//出院病区
		sql.append("PAT.ID_PAT AS ID_PAT, " );
		sql.append("BED.NAME AS Name_bed, " );
		sql.append("IP.CODE_AMR_IP, " );
		sql.append("NVL(acc.amt_uncg,0)  as Amt_uncg,");
		sql.append("NVL(acc.AMT_TOTAL,0) AS AMT, " );
		sql.append("PAT.NAME AS Name_pat, " );
		sql.append("PAT.ID_CODE AS Id_code, " );
		sql.append("SEX.NAME AS Name_sex, " );
		sql.append("PAT.DT_BIRTH AS Dt_birth, " );
		sql.append("pat.dt_birth_hms as Dt_birth_hms,");
		sql.append("NVL(PAT.MOB,PAT.TEL) AS Telno_pat, " );
		sql.append("ENT.DT_ENTRY AS Dt_entry, " );
		sql.append("ENT.DT_ACPT AS DT_ACPT, " );//入科时间
		sql.append("ENT.DT_END, " );
		sql.append("ENT.FG_IP AS Fg_ip, " );
		sql.append("ENT.FG_ST, " );
		sql.append("NVL(STIP.FG_PAY,'N') as FG_PAY, " );
		sql.append("DOC.NAME AS Doc_resp, " );
		sql.append("AREA.FULLNAME || addr.street AS Addr_pat, " );
		sql.append("ENT.DT_END AS Dt_tran, ");
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
		sql.append("INNER JOIN PI_PAT_CA CA ON ENT.ID_PATCA = CA.ID_PATCA ");
		sql.append("INNER JOIN BD_DEP DEP ON DEP.ID_DEP = ENT.ID_DEP_PHY " );
		sql.append("INNER JOIN BD_BED BED ON BED.ID_BED = IP.ID_BED " );
		sql.append("INNER JOIN PI_PAT PAT ON PAT.ID_PAT = ENT.ID_PAT " );
		sql.append("LEFT JOIN BD_UDIDOC SEX ON SEX.ID_UDIDOC = PAT.ID_SEX " );
		sql.append("LEFT JOIN BL_ST_IP STIP ON STIP.ID_ENT = ENT.ID_ENT AND STIP.FG_CANC = '"+FBoolean.FALSE+"' AND STIP.EU_DIRECT = "+IBlDictCodeConst.SD_DIRECT_CHARGE+" " );
		sql.append(" AND STIP.eu_sttp = '10' ");//结算类型：出院结算
		//sql.append("LEFT JOIN BL_PAY_PAT_IP PAY ON PAY.ID_STIP = STIP.ID_STIP " );
		//sql.append("LEFT JOIN EN_ENT_EMP EMP ON EMP.ID_ENT = ENT.ID_ENT AND EMP.SD_EMPROLE = '"+IEnDictCodeConst.SD_EMPROLE_DOCTOR+"' AND EMP.DT_E = ENT.DT_END " );
		sql.append("LEFT JOIN BD_PSNDOC DOC ON DOC.ID_PSNDOC = ENT.ID_EMP_PHY " );
		sql.append("LEFT JOIN PI_PAT_ADDR ADDR ON ADDR.ID_PAT = PAT.ID_PAT AND ADDR.SD_ADDRTP = '"+IPiDictCodeConst.SD_ADDR_TYPE_NOW+"' " );
		sql.append("LEFT JOIN BD_ADMINAREA AREA ON AREA.ID_ADMINAREA = ADDR.ID_ADMDIV " );
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
		//住院号
		if(!EnValidator.isEmpty(qrySchm.getCode_amr_ip())){
			sql.append("AND IP.CODE_AMR_IP = ? " );
			param.addParam(qrySchm.getCode_amr_ip());
		}
		//患者分类
		if(!EnValidator.isEmpty(qrySchm.getId_patca())){
			sql.append("AND ENT.ID_PATCA = ? " );
			param.addParam(qrySchm.getId_patca());
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
        	sql.append(" EXISTS ( SELECT * FROM BL_ST_IP STIP WHERE STIP.ID_ENT = ENT.ID_ENT AND STIP.EU_DIRECT = '1' AND STIP.FG_CANC = 'N' AND STIP.FG_PAY = 'Y' AND STIP.eu_sttp = '10' ) ");
        }
        if(FBoolean.TRUE.equals(qrySchm.getFg_tran())){
        	sql.append(" ");
        }else{
        	sql.append(" ORDER BY ENT.DT_END desc  ");
        }
        return sql.toString();
	}
	/***
	 * 获取转科查询基本sql
	 * @param qrySchm
	 * @param param
	 * @return
	 */
	private String getTranSql(IpRegQrySchmDTO qrySchm,SqlParam param){
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT distinct ENT.ID_ENT, ");
		sql.append("CA.NAME AS NAME_PATCA,");
		sql.append("DEPTRANS.ID_DEP_FROM AS ID_DEP_FROM, " ); //转出科室ID
		sql.append("DEPTRANS.ID_DEP_NUR_FROM AS ID_NUR_FROM, "); //转出病区ID
		sql.append("DEPTRANS.ID_DEP_TO AS ID_DEP_TRANS, "); //转入科室ID
		sql.append("DEPTRANS.ID_DEP_NUR_TO AS ID_NUR_TRANS, "); //转入病区ID
		sql.append("ENT.ID_DEP_PHY AS ID_DEP_PHY, "); //当前科室ID
		sql.append("ENT.ID_DEP_NUR AS ID_DEP_NUR, "); //当前病区ID
		sql.append(" IP.ID_DEP_PHYDISC ID_DEP_OUT, ");//出院科室
		sql.append(" Ip.ID_DEP_NURDISC ID_DEP_NUR_OUT, ");//出院病区
		sql.append("PAT.ID_PAT Id_pat, " );
		sql.append("BED.NAME AS Name_bed, " );
		sql.append("IP.CODE_AMR_IP, " );
		sql.append("NVL(acc.amt_uncg,0)  as Amt_uncg,");
		sql.append("NVL(acc.AMT_TOTAL,0) AS AMT, " );
		sql.append("PAT.NAME AS Name_pat, " );
		sql.append("PAT.ID_CODE AS Id_code, " );
		sql.append("SEX.NAME AS Name_sex, " );
		sql.append("PAT.DT_BIRTH AS Dt_birth, " );
		sql.append("pat.dt_birth_hms as Dt_birth_hms,");
		sql.append("NVL(PAT.MOB,PAT.TEL) AS Telno_pat, " );
		sql.append("ENT.DT_ENTRY AS Dt_entry, " );
		sql.append("ENT.DT_ACPT AS DT_ACPT, " );//入科时间
		sql.append("ENT.DT_END, " );
		sql.append("ENT.FG_IP AS Fg_ip, " );
		sql.append("ENT.FG_ST, " );
		sql.append("NVL(STIP.FG_PAY,'N') as FG_PAY, " );
		sql.append("DOC.NAME AS Doc_resp, " );
		sql.append("AREA.FULLNAME || addr.street AS Addr_pat, " );
		sql.append("DEPTRANS.DT_ACPT AS Dt_tran, ");
		sql.append("STIP.ID_STIP as Id_stip, ");
		sql.append(" case when exists(select 1 from ci_order ord where   ord.ID_EN = ENT.ID_ENT AND ord.FG_CANC = 'N' AND ord.SD_SRVTP = '"+IBdSrvDictCodeConst.SD_SRVTP_PATIMAN_CLIDEATH+"') then 'Y' else 'N' end Fg_died ");
		//sql.append("CASE WHEN CI.SD_SRVTP = '"+IBdSrvDictCodeConst.SD_SRVTP_PATIMAN_CLIDEATH+"' THEN 'Y' ELSE 'N' END AS fg_died ");
		sql.append("FROM EN_ENT ENT " );
		sql.append(" left join en_ent_acc acc on acc.id_ent = ent.id_ent ");
		if(FBoolean.TRUE.equals(qrySchm.getFg_shownb())){
			sql.append("INNER JOIN EN_ENT_IP IP ON IP.ID_ENT = ENT.ID_ENT " );
		}else{
			sql.append("INNER JOIN EN_ENT_IP IP ON IP.ID_ENT = ENT.ID_ENT AND IP.FG_NEWBORN = '"+FBoolean.FALSE+"' " );
		}
		sql.append("INNER JOIN PI_PAT_CA CA ON ENT.ID_PATCA = CA.ID_PATCA ");
		sql.append("INNER JOIN BD_DEP DEP ON DEP.ID_DEP = ENT.ID_DEP_PHY " );
		sql.append("INNER JOIN BD_BED BED ON BED.ID_BED = IP.ID_BED " );
		sql.append("INNER JOIN PI_PAT PAT ON PAT.ID_PAT = ENT.ID_PAT " );
		sql.append("LEFT JOIN BD_UDIDOC SEX ON SEX.ID_UDIDOC = PAT.ID_SEX " );
		sql.append("LEFT JOIN BL_ST_IP STIP ON STIP.ID_ENT = ENT.ID_ENT AND STIP.FG_CANC = '"+FBoolean.FALSE+"' AND STIP.EU_DIRECT = "+IBlDictCodeConst.SD_DIRECT_CHARGE+" " );
		sql.append(" AND STIP.eu_sttp = '10' ");//结算类型：出院结算
		//sql.append("LEFT JOIN BL_PAY_PAT_IP PAY ON PAY.ID_STIP = STIP.ID_STIP " );
		//sql.append("LEFT JOIN EN_ENT_EMP EMP ON EMP.ID_ENT = ENT.ID_ENT AND EMP.SD_EMPROLE = '"+IEnDictCodeConst.SD_EMPROLE_DOCTOR+"' AND EMP.DT_E = ENT.DT_END " );
		sql.append("LEFT JOIN BD_PSNDOC DOC ON DOC.ID_PSNDOC = ENT.ID_EMP_PHY " );
		sql.append("LEFT JOIN PI_PAT_ADDR ADDR ON ADDR.ID_PAT = PAT.ID_PAT AND ADDR.SD_ADDRTP = '"+IPiDictCodeConst.SD_ADDR_TYPE_NOW+"' " );
		sql.append("LEFT JOIN BD_ADMINAREA AREA ON AREA.ID_ADMINAREA = ADDR.ID_ADMDIV " );
		//sql.append("LEFT JOIN CI_ORDER CI ON CI.ID_EN = ENT.ID_ENT AND CI.FG_CANC = '"+FBoolean.FALSE+"' ");
		//sql.append("AND CI.SD_SRVTP = '"+IBdSrvDictCodeConst.SD_SRVTP_PATIMAN_CLIDEATH+"' ");
		sql.append("INNER JOIN EN_DEP_TRANS DEPTRANS ON DEPTRANS.ID_ENT = ENT.ID_ENT AND DEPTRANS.EU_TRANS = '1' ");
		sql.append("WHERE ENT.FG_CANC = ? " );
		param.addParam(FBoolean.FALSE);
		sql.append("AND IP.SD_STATUS <> ? " );
		param.addParam(IEnDictCodeConst.SD_ENSTATUS_IN_HOSPITALQUIT);
		//查询开始日期
		if(qrySchm.getD_begin() != null){
			sql.append("AND DEPTRANS.DT_ACPT >= ? " );
			param.addParam(qrySchm.getD_begin());
		}
		//查询结束日期
		if(qrySchm.getD_end() != null){
			sql.append("AND DEPTRANS.DT_ACPT <= ? " );
			param.addParam(qrySchm.getD_end());
		}
		//科室
		if(!EnValidator.isEmpty(qrySchm.getId_dep_phy())){
			sql.append("AND DEPTRANS.ID_DEP_FROM = ? " );
			param.addParam(qrySchm.getId_dep_phy());
		}
		//病区
		if(!EnValidator.isEmpty(qrySchm.getId_dep_nur())){
			sql.append("AND DEPTRANS.ID_DEP_NUR_FROM = ? " );
			param.addParam(qrySchm.getId_dep_nur());
		}
		//患者姓名
		if(!EnValidator.isEmpty(qrySchm.getName_pat())){
			sql.append("AND PAT.NAME LIKE ? " );
			param.addParam("%"+qrySchm.getName_pat()+"%");
		}
		//住院号
		if(!EnValidator.isEmpty(qrySchm.getCode_amr_ip())){
			sql.append("AND IP.CODE_AMR_IP = ? " );
			param.addParam(qrySchm.getCode_amr_ip());
		}
		//患者分类
				if(!EnValidator.isEmpty(qrySchm.getId_patca())){
					sql.append("AND ENT.ID_PATCA = ? " );
					param.addParam(qrySchm.getId_patca());
				}
		
		//转入科室和转入病区
		if(!EnValidator.isEmpty(qrySchm.getId_dep_phytrans())){
			sql.append("AND DEPTRANS.id_dep_to = ? " );
			param.addParam(qrySchm.getId_dep_phytrans());
		}
		if(!EnValidator.isEmpty(qrySchm.getId_dep_nurtrans())){
			sql.append("AND DEPTRANS.id_dep_nur_to = ? " );
			param.addParam(qrySchm.getId_dep_nurtrans());
		}
		//付款标志
		//if(FBoolean.TRUE.equals(qrySchm.getFg_payed())){
		//	sql.append("AND STIP.FG_PAY = ? ");
		//	param.addParam(FBoolean.TRUE);
		//}
		//死亡标志
		if(FBoolean.TRUE.equals(qrySchm.getFg_died())){
			sql.append("and exists(select 1 from ci_order ord where  ord.ID_EN = ENT.ID_ENT AND ord.FG_CANC = 'N' AND ord.SD_SRVTP = ?) ");
			//sql.append("AND CI.SD_SRVTP = ? ");
			param.addParam(IBdSrvDictCodeConst.SD_SRVTP_PATIMAN_CLIDEATH);
		}
		sql.append(" ORDER BY dt_tran desc ");
		return sql.toString();
	}
	/**
	 * 查找年龄
	 * @param pageBedDTO
	 * @throws BizException 
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void getAge( PagingRtnData pageBedDTO ) throws BizException{
		FArrayList list = pageBedDTO.getPageData();
		if(EnValidator.isEmpty(list))
			return;
		/*for(Object obj: list){
			IpRegInfoDTO regdto = (IpRegInfoDTO) obj;
			//regdto.setAge(AgeCalcUtil.getAge(regdto.getDt_birth()));
			if(regdto.getDt_birth_hms()== null)
				continue;
			//regdto.setAge(AgeCalcUtil.getAge(regdto.getDt_birth_hms()));
		}*/
		EnAgeCalcUtil.setDoAges((IpRegInfoDTO[])list.toArray(new IpRegInfoDTO[]{}), "Id_ent", "Age");
	}
	/****
	 * 显示住院天数，fanlq-2018-10-27
	 * @param pageBedDTO
	 * @throws BizException 
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void getInHosDays(PagingRtnData pageBedDTO) throws BizException {
		CalculateHosDaysBP daysBp  = new CalculateHosDaysBP();
		FArrayList list = pageBedDTO.getPageData();
		if(EnValidator.isEmpty(list))
			return;
		for(Object obj: list){
			IpRegInfoDTO regdto = (IpRegInfoDTO) obj;
			regdto.setDays_ip(daysBp.calculate(regdto.getDt_acpt(), regdto.getDt_end(), regdto.getFg_ip())+"天");
		}
	}
	/***
	 * 获取主诊断
	 * 
	 * @param pageBedDTO
	 * @throws BizException 
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void getPatMainDi(PagingRtnData pageBedDTO) throws BizException{
		FArrayList list = pageBedDTO.getPageData();
		if(EnValidator.isEmpty(list))
			return;
		List<String> entids = new ArrayList<String>();
		for(Object obj: list){
			IpRegInfoDTO regdto = (IpRegInfoDTO) obj;
			entids.add(regdto.getId_ent());
		}
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT distinct ENT.ID_ENT,ITM.ID_DIDEF_NAME AS Name_didef_dis ");
		sql.append("FROM EN_ENT ENT ");
		sql.append("LEFT JOIN (SELECT C.ID_DI,C.ID_EN,ROW_NUMBER() OVER(PARTITION BY C.ID_EN ORDER BY C.DT_SIGN DESC)RN FROM CI_DI C) DI ON DI.ID_EN = ENT.ID_ENT AND DI.RN = 1 " );
		sql.append("LEFT JOIN CI_DI_ITM ITM ON ITM.ID_DI = DI.ID_DI AND ITM.FG_MAJDI = '"+FBoolean.TRUE+"' " );
		sql.append("WHERE "+SqlUtils.getInSqlByIds("ENT.ID_ENT", entids)+" ");
		List<IpRegInfoDTO> reList = (List<IpRegInfoDTO>) new DAFacade()
				.execQuery(sql.toString(), new BeanListHandler(
						IpRegInfoDTO.class));
		if(reList != null && reList.size() > 0){
			Map<String,String> map = new HashMap<String,String>();
			for(IpRegInfoDTO regInfo : reList){
				if(!map.containsKey(regInfo.getId_ent())){
					map.put(regInfo.getId_ent(), regInfo.getName_didef_dis());
				}
			}
			for(Object obj: list){
				IpRegInfoDTO regdto = (IpRegInfoDTO) obj;
				regdto.setName_didef_dis(map.get(regdto.getId_ent()));
			}
		}
	}
	/**
	 * 获取入院诊断和出院诊断 - zhangpp 2019.2.26
	 * @param pageBedDTO
	 * @throws BizException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void getPatDi(PagingRtnData pageBedDTO) throws BizException{
		FArrayList list = pageBedDTO.getPageData();
		if(EnValidator.isEmpty(list))
			return;
		List<String> entids = new ArrayList<String>();
		for(Object obj: list){
			IpRegInfoDTO regdto = (IpRegInfoDTO) obj;
			entids.add(regdto.getId_ent());
		}
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT ");
		sql.append(" ent.id_ent, ");
		sql.append(" itm1.id_didef_name as name_diag_in, ");
		sql.append(" itm2.id_didef_name as name_diag_out ");
		sql.append(" from en_ent ent ");
		sql.append(" left join ci_di ci on ent.id_ent = ci.id_en and ci.sd_ditp = '12' ");//入院诊断
		sql.append(" left join ci_di_itm itm1 on ci.id_di = itm1.id_di and itm1.fg_majdi = '"+FBoolean.TRUE+"' ");
		sql.append(" left join ci_di di on ent.id_ent = di.id_en and di.sd_ditp = '15' ");//出院诊断
		sql.append(" left join ci_di_itm itm2 on di.id_di = itm2.id_di and itm2.fg_majdi = '"+FBoolean.TRUE+"' ");
		sql.append(" WHERE "+SqlUtils.getInSqlByIds("ENT.ID_ENT", entids)+" ");
		List<IpRegInfoDTO> reList = (List<IpRegInfoDTO>) new DAFacade()
				.execQuery(sql.toString(), new BeanListHandler(
						IpRegInfoDTO.class));
		if(reList != null && reList.size() > 0){
			for(Object obj: list){
				IpRegInfoDTO regdto = (IpRegInfoDTO) obj;
				for(IpRegInfoDTO regInfo : reList){
					if (regInfo.getId_ent().equals(regdto.getId_ent())) {
						regdto.setName_diag_in(regInfo.getName_diag_in());
						regdto.setName_diag_out(regInfo.getName_diag_out());
					}
				}
			}
		}
	}
	/****
	 * 获取患者医保id，fanlq-2019-03-01
	 * @param pageBedDTO
	 * @throws BizException 
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void getPatHp(PagingRtnData pageBedDTO) throws BizException {
		FArrayList list = pageBedDTO.getPageData();
		if(EnValidator.isEmpty(list))
			return;
		List<String> entids = new ArrayList<String>();
		for(Object obj: list){
			IpRegInfoDTO regdto = (IpRegInfoDTO) obj;
			entids.add(regdto.getId_ent());
		}
		if(entids == null || entids.size() <= 0)
			return;
		StringBuffer sql = new StringBuffer();
		sql.append("select ent.id_ent,hp.id_hp from en_ent ent ");
		sql.append("inner join en_ent_hp hp on hp.id_ent = ent.id_ent " );
		sql.append(" WHERE "+SqlUtils.getInSqlByIds("ENT.ID_ENT", entids)+" ");
		List<IpRegInfoDTO> reList = (List<IpRegInfoDTO>) new DAFacade()
				.execQuery(sql.toString(), new BeanListHandler(
						IpRegInfoDTO.class));
		if(reList != null && reList.size() > 0){
			for(Object obj: list){
				IpRegInfoDTO regdto = (IpRegInfoDTO) obj;
				for(IpRegInfoDTO regInfo : reList){
					if (regInfo.getId_ent().equals(regdto.getId_ent())) {
						regdto.setId_hp(regInfo.getId_hp());
					}
				}
			}
		}
	}
}
