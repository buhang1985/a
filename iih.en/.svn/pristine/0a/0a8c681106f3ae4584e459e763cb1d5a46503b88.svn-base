package iih.en.pv.s.bp.op;

import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.en.comm.util.EnAgeCalcUtil;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.outpatient.d.EuRegTp;
import iih.en.pv.outpatient.dto.d.RegListDTO;
import iih.en.pv.outpatient.dto.d.RegQryDTO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.sc.pub.ScGroupControlUtils;
import iih.sc.sch.sctick.d.EuAddTickMod;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.log.logging.Logger;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 检索门诊挂号信息
 * 
 * @author liubin
 *
 */
public class GetOpRegListByOperBP {
	
	private static final String ALL = "%";//所有
	private static final String TICKET_CANC = "CANC";//退号
	private static final String TICKET_ADD = "ADD";//加号
	/**
	 * 检索门诊挂号信息
	 * 
	 * @param regQry 查询条件
	 * @param pg 分页信息
	 * @return
	 * @throws BizException 
	 */
	public PagingRtnData<RegListDTO> exec(RegQryDTO regQry, PaginationInfo pg) throws BizException {
		if(regQry == null || pg == null)
			return new PagingRtnData<RegListDTO>();
		StringBuilder sb = new StringBuilder();
		SqlParam param = new SqlParam();
		this.initSql(regQry, sb, param);
		String sql = sb.toString();
		Logger.info(sql, this.getClass(), "exec");
		PagingServiceImpl<RegListDTO> pageQryService = new PagingServiceImpl<RegListDTO>();
		PagingRtnData<RegListDTO> result = pageQryService.findByPageInfo(new RegListDTO(), pg, sql, null, param);
		this.proccessResult(result);
		return result;
	}
	
	/**
	 * 初始化查询条件
	 * 
	 * @param regQry
	 * @param sb
	 * @param param
	 */
	private void initSql(RegQryDTO regQry, StringBuilder sb, SqlParam param){
		sb.append("SELECT EN.ID_ENT AS ID_ENT,");
		sb.append("EN.ID_PAT AS ID_PAT,");
		sb.append("EN.NAME_PAT AS NAME_PAT,");
		sb.append("PAT.CODE AS CODE_PAT,");
		sb.append("SEX.ID_UDIDOC AS ID_SEX,");
		sb.append("SEX.CODE AS SD_SEX,");
		sb.append("SEX.NAME AS NAME_SEX,");
		sb.append("EN.CODE AS CODE_ENT,");
		sb.append("EN.DT_BIRTH_PAT AS DT_BIRTH_PAT,");
		sb.append("CASE WHEN PAT.MOB IS NULL AND PAT.TEL IS NOT NULL THEN PAT.TEL ELSE PAT.MOB END AS Mob,");//手机号，fanlq-2018-04-28
		sb.append("AREA.FULLNAME||PATADDR.STREET AS ADDR_PAT,");//地址
		sb.append("IDTP.NAME AS NAME_IDTP,");//证件类型姓名
		sb.append("IDTP.ID_UDIDOC AS ID_IDTP,");//证件类型ID
		sb.append("IDTP.CODE AS SD_IDTP,");//证件类型编码
		sb.append("PAT.ID_CODE AS ID,");//证件号
		sb.append("DEP.NAME AS NAME_DEP_PHY,");
		sb.append("SCSRV.NAME  AS NAME_SCSRV,");
		sb.append("SCRES.NAME AS NAME_SCRES,");
		sb.append("PATCA.NAME AS NAME_PATCA,");
		sb.append("PRIPAT.NAME AS NAME_PRIPAT,");
		sb.append("OP.TICKETNO AS TICKETNO,");
		sb.append("OP.TIMES_OP AS TIMES_OP,");
		sb.append("OP.ID_CG AS ID_CG,");
		sb.append("DAYS.NAME AS NAME_DAYSLOT,");
		sb.append("OP.SD_STATUS AS SD_STATUS,");
		sb.append("case when upper(OPER.NAME) like 'TOKEN%' and chl.name is not null then chl.name else OPER.NAME end as NAME_EMP_OPERATOR,");
		sb.append("case when upper(CANC.NAME) like 'TOKEN%' and chl.name is not null then chl.name else CANC.NAME end as NAME_EMP_CANC,");
		sb.append("EN.DT_CANC AS DT_CANC,");
		sb.append("OP.FG_NEEDRTN AS FG_NEEDRTN, ");
		sb.append("EN.FG_CANC AS FG_CANC,");
		sb.append("EN.DT_INSERT AS DT_INSERT,");
		sb.append("HP.NAME AS NAME_HP,");
		sb.append("EN.DT_ACPT AS DT_ENTRY, ");
		sb.append(" CASE  WHEN EN.FG_CANC = ? THEN '退号'  ");
		param.addParam(FBoolean.TRUE);
		sb.append(" WHEN (EN.FG_CANC = ?  AND  OP.EU_REGTP != ? AND (TK.EU_ADD IS NULL OR TK.EU_ADD = ?))  THEN '' ");
		param.addParam(FBoolean.FALSE);
		param.addParam(EuRegTp.FREENOSCH);
		param.addParam(EuAddTickMod.ZCH);
		sb.append(" WHEN  (EN.FG_CANC = ?  AND  OP.EU_REGTP = ?) THEN '0元非排班' ");
		param.addParam(FBoolean.FALSE);
		param.addParam(EuRegTp.FREENOSCH);
		sb.append(" WHEN ( EN.FG_CANC = ?   AND  TK.EU_ADD IN (?,?,?) )  THEN '加号' ");
		param.addParam(FBoolean.FALSE);
		param.addParam(EuAddTickMod.JH);
		param.addParam(EuAddTickMod.BH);
		param.addParam(EuAddTickMod.WPB);
		sb.append(" END AS TICKET_STATUS ");
		sb.append("FROM EN_ENT EN ");
		sb.append("INNER JOIN EN_ENT_OP OP ON EN.ID_ENT = OP.ID_ENT ");
		sb.append("INNER JOIN PI_PAT PAT ON EN.ID_PAT = PAT.ID_PAT ");
		sb.append("LEFT JOIN BD_UDIDOC IDTP ON IDTP.ID_UDIDOC = PAT.ID_IDTP ");
		sb.append("LEFT JOIN BD_UDIDOC SEX ON SEX.ID_UDIDOC = PAT.ID_SEX ");
		
		//加号
		sb.append("LEFT JOIN SC_TICK TK ON OP.ID_TICK = TK.ID_TICK  ");
		sb.append("LEFT JOIN BD_DEP DEP ON EN.ID_DEP_PHY = DEP.ID_DEP ");
		sb.append("LEFT JOIN SC_SRV SCSRV ON OP.ID_SCSRV = SCSRV.ID_SCSRV ");
		sb.append("LEFT JOIN SC_RES SCRES ON OP.ID_SCRES = SCRES.ID_SCRES ");
		sb.append("LEFT JOIN PI_PAT_CA PATCA ON EN.ID_PATCA = PATCA.ID_PATCA ");
		sb.append("LEFT JOIN BD_PRI_PAT PRIPAT ON EN.ID_PRIPAT = PRIPAT.ID_PRIPAT ");  
		sb.append("LEFT JOIN BD_DAYSLOT DAYS ON OP.ID_DATESLOT = DAYS.ID_DAYSLOT ");
		sb.append("LEFT JOIN BD_PSNDOC OPER ON OP.ID_EMP_OPERATOR = OPER.ID_PSNDOC "); 
		sb.append("LEFT JOIN BD_PSNDOC CANC ON EN.ID_EMP_CANC = CANC.ID_PSNDOC ");
		sb.append("left join en_ent_hp enthp on en.id_ent = enthp.id_ent and enthp.fg_maj='Y' ");
		sb.append("LEFT JOIN PI_PAT_ADDR PATADDR ON PATADDR.ID_PAT = PAT.ID_PAT and PATADDR.sd_addrtp = '"+IPiDictCodeConst.SD_ADDR_TYPE_NOW+"' ");//患者现居地
		sb.append("LEFT JOIN BD_ADMINAREA AREA ON EN.ID_ADMDIV_ADDR = AREA.ID_ADMINAREA  ");//患者现居住街道详情
		sb.append("left join bd_hp hp on enthp.id_hp = hp.id_hp ");
		sb.append("left join sc_apt apt on apt.id_apt = op.id_schapt ");
		sb.append("left join sc_chl chl on chl.id_scchl = apt.id_scchl ");
		sb.append("WHERE 1=1   ");
		sb.append(" AND " + ScGroupControlUtils.getGroupControlFitler(new PatiVisitDO(), "EN") + " ");
		//挂号日期
		if(FBoolean.TRUE.equals(regQry.getFg_check_insert())){
			//结束日期不加1，fanlq-2018-05-14
			sb.append("AND EN.DT_INSERT >= ? ");
			param.addParam(regQry.getDt_insert_b());
			sb.append("AND EN.DT_INSERT < ? ");
			param.addParam(regQry.getDt_insert_e().getDateAfter(1));
		}
		//就诊日期
		if(FBoolean.TRUE.equals(regQry.getFg_check_entry())){

			sb.append("AND EN.DT_ACPT >= ? ");
			param.addParam(regQry.getDt_entry_b());
			sb.append("AND EN.DT_ACPT < ? ");
			param.addParam(regQry.getDt_entry_e().getDateAfter(1));
		}
		//科室
		if(!EnValidator.isEmpty(regQry.getId_dep_phy())){
			sb.append("AND EN.ID_DEP_PHY = ? ");
			param.addParam(regQry.getId_dep_phy());
		}
		//挂号资源
		if(!EnValidator.isEmpty(regQry.getId_scres())){
			sb.append("AND OP.ID_SCRES = ? ");
			param.addParam(regQry.getId_scres());
		}
		//午别
		if(!EnValidator.isEmpty(regQry.getId_dayslot())){
			sb.append("AND OP.ID_DATESLOT = ? ");
			param.addParam(regQry.getId_dayslot());
		}
		//号别
		if(!EnValidator.isEmpty(regQry.getId_scsrv())){
			sb.append("AND OP.ID_SCSRV = ? ");
			param.addParam(regQry.getId_scsrv());
		}
		//就诊状态
		if(!EnValidator.isEmpty(regQry.getSd_status()) && !ALL.equals(regQry.getSd_status())){
			sb.append("AND OP.SD_STATUS = ? ");
			param.addParam(regQry.getSd_status());
		}
		//发票号
		if(!EnValidator.isEmpty(regQry.getInvoice())){
			sb.append("AND exists (select distinct oep.id_ent from bl_st_oep st inner join bl_inc_oep inc on inc.id_stoep = st.id_stoep ");
			sb.append("inner join bl_cg_itm_oep oep on oep.id_stoep = st.id_stoep where inc.incno = ?  and EN.ID_ENT=oep.id_ent)");
			param.addParam(regQry.getInvoice());
		}
		//患者姓名
		if(!EnValidator.isEmpty(regQry.getName_pat())){
			sb.append("AND (EN.NAME_PAT = ? ");
			param.addParam(regQry.getName_pat());
			
			sb.append("OR PAT.PYCODE =  ?) ");
			param.addParam(regQry.getName_pat().toUpperCase()+".");
		}
		//患者编码
		if(!EnValidator.isEmpty(regQry.getCode_pat())){
			sb.append("AND PAT.CODE = ? ");
			param.addParam(regQry.getCode_pat());
		}
		//挂号员
		if(!EnValidator.isEmpty(regQry.getId_emp_operator())){
			sb.append("AND OP.ID_EMP_OPERATOR = ? ");
			param.addParam(regQry.getId_emp_operator());
		}
		// 新增患者分类和医保名称筛选条件，fanlq-2017-09-11
		// 患者分类
		if (!EnValidator.isEmpty(regQry.getId_pat_ca())) {
			sb.append("AND PATCA.ID_PATCA = ? ");
			param.addParam(regQry.getId_pat_ca());
		}
		// 医保名称
		if (!EnValidator.isEmpty(regQry.getId_hp())) {
			sb.append("AND HP.ID_HP = ? ");
			param.addParam(regQry.getId_hp());
		}
		//手机号,fanlq-2018-04-28
		if(!EnValidator.isEmpty(regQry.getMob())){
			sb.append(" AND (PAT.MOB = ? OR PAT.TEL = ? )");
			param.addParam(regQry.getMob());
			param.addParam(regQry.getMob());
		}
		//复选框过滤条件，fanlq-2109-08-02
		this.getCheckBoxValue(regQry, sb, param);
		sb.append(" ORDER BY NAME_DEP_PHY, DT_ACPT,DAYS.SORTNO, TICKETNO ");
	}
	
	/**
	 * 处理数据
	 * 
	 * @param result
	 * @throws BizException 
	 */
	private void proccessResult(PagingRtnData<RegListDTO> result) throws BizException{
		if(result==null || result.getPageData() == null)
			return;
		//设置年龄
		EnAgeCalcUtil.setDoAges((RegListDTO[])result.getPageData().toArray(new RegListDTO[]{}), "Id_ent", "Age");
		for(Object obj : result.getPageData()){
			RegListDTO regList = (RegListDTO)obj;
			if(FBoolean.TRUE.equals(regList.getFg_canc()))
			{
				regList.setName_status("退号");
				continue;
			}
			switch(regList.getSd_status()){
			case IEnDictCodeConst.SD_ENSTATUS_OP_ORDER:
				regList.setName_status("预约");
				break;
			case IEnDictCodeConst.SD_ENSTATUS_OP_REGISTER:
				regList.setName_status("挂号");
				break;
			case IEnDictCodeConst.SD_ENSTATUS_OP_ENCOUNTER:
				regList.setName_status("就诊");
				break;
			case IEnDictCodeConst.SD_ENSTATUS_OP_FINISH:
				regList.setName_status("诊毕");
				break;
			case IEnDictCodeConst.SD_ENSTATUS_APT_ORDER:
				regList.setName_status("预约未缴费");
				break;
			}
		}
	}
	/***
	 * 获取复选框过滤条件
	 * @param regQry
	 * @param sb
	 * @param param
	 */
	private void getCheckBoxValue(RegQryDTO regQry,StringBuilder sb, SqlParam param){
		StringBuilder sWhere= new StringBuilder();
		//普通号
		if(FBoolean.TRUE.equals(regQry.getFg_common()))
		{
			sWhere.append(" (TK.EU_ADD =? or  TK.EU_ADD  is null)");
			param.addParam(EuAddTickMod.ZCH);
		}
		//加号
		if(FBoolean.TRUE.equals(regQry.getFg_add())){
			if(EnValidator.isEmpty(sWhere.toString())){
				sWhere.append(" TK.EU_ADD in (? ,?,?)");
			}else{
				sWhere.append(" or TK.EU_ADD in (? ,?,?)");
			}
			param.addParam(EuAddTickMod.JH);
			param.addParam(EuAddTickMod.BH);
			param.addParam(EuAddTickMod.WPB);
		}
		//0元排班号
		if(FBoolean.TRUE.equals(regQry.getFg_freenosch())){
			if(EnValidator.isEmpty(sWhere.toString())){
				sWhere.append(" OP.EU_REGTP = ? ");
			}else{
				sWhere.append("or OP.EU_REGTP = ? ");
			}
			param.addParam(EuRegTp.FREENOSCH);
		}
		//退号
		if(FBoolean.TRUE.equals(regQry.getFg_canc()))
		{
			if(EnValidator.isEmpty(sWhere.toString())){
				sWhere.append(" EN.FG_CANC = ?");
			}else{
				sWhere.append(" or  EN.FG_CANC = ?");
			}	
			param.addParam(FBoolean.TRUE);
		}
		if(!EnValidator.isEmpty(sWhere.toString())){
			sb.append(" AND (");
			sb.append(sWhere.toString());
			sb.append(" )");
		}
		//都不选的话不拼，全选和全不选查询效果一样
		if(!EnValidator.isEmpty(sWhere.toString())){
			//如果不选中退号，则默认查非退号信息
			if(FBoolean.FALSE.equals(regQry.getFg_canc()))
			{
				sb.append(" and EN.FG_CANC = ?");
				param.addParam(FBoolean.FALSE);
			}
			//如果不选中0元排班号
			if(FBoolean.FALSE.equals(regQry.getFg_freenosch()))
			{
				sb.append(" and OP.EU_REGTP <> ?");
				param.addParam(EuRegTp.FREENOSCH);
			}
		}
	}
}
