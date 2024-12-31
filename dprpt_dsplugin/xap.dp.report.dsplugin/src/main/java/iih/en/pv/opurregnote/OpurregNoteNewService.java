package iih.en.pv.opurregnote;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mysql.jdbc.StringUtils;

import xap.dp.report.data.reader.sql.SqlReader;
import xap.mw.core.data.BizException;
import xap.mw.core.service.time.TimeService;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanHandler;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class OpurregNoteNewService {
	/**
	 * 
	 * 
	 * @param entId
	 * @param idCg
	 * @param periodFlag 时间段或时间点标志 1：时间段，2：时间点
	 * @return
	 * @throws Exception
	 */
	public OpurregNoteDTO fillBeanInfo(String entId, String idCg, String periodFlag) throws Exception {
		//获取打印信息
		//String[] strList = this.getAmt(idCg);
		OpurregNoteDTO printInfo = this.getPrintInfo(entId);
		this.setPeriodInfo(printInfo, periodFlag);
		
		//患者分类截取前8位，fanlq-2018-01-06
		if(printInfo.getNamePatCa() != null && printInfo.getNamePatCa().length() > 8){
			printInfo.setNamePatCa(printInfo.getNamePatCa().substring(0, 8));
		}
				
		// 增加挂号渠道显示，fanlq-2017-09-01
		switch (printInfo.getChl_name()) {
		case "0":
			printInfo.setChl_name("普通挂号");
			break;
		case "1":
			printInfo.setChl_name("分诊台挂号");
			break;
		case "2":
			printInfo.setChl_name("先诊疗后付费方式挂号");
			break;
		case "3":
			printInfo.setChl_name("医生诊间挂号");
			break;
		case "9":
			printInfo.setChl_name("预约");
			break;
		}
		
		//增加加号标识，fanlq-2017-09-11
		if (printInfo.getEu_add() == null || printInfo.getEu_add() == 0) {
			printInfo.setNo(printInfo.getNo());
		} else {
			printInfo.setNo(printInfo.getNo() + "(加号)");
		}
		
		//没有医生职业证号的医生不打印医生姓名，fanlq-2017-10-09
		if (printInfo.getId_emp() != null) {
			if (printInfo.getDrid() == "~" || printInfo.getDrid() == null) {
				printInfo.setDoctorNm("");
			}
		}
		
		// 建议提前到诊时间为-1时不打印具体时间，fanlq-2017-10-30
		if (printInfo.getSuggestExmint() != null && printInfo.getSuggestExmint().equals(-1)) {
			printInfo.setPeriod("");
		}
		
		//获取支付金额信息
		OpurregNoteDTO opuAmt = this.getAmt(entId, idCg);
		printInfo.setAmt(opuAmt.getAmt());
		printInfo.setAmt_hp(opuAmt.getAmt_hp());
		printInfo.setAmt_ct(opuAmt.getAmt_ct());
		printInfo.setAmt_sb(opuAmt.getAmt_sb());
		printInfo.setAmt_pat(opuAmt.getAmt_pat());
		printInfo.setName_pm(opuAmt.getName_pm());
		//获取个人账户余额
		OpurregNoteDTO patBalance = this.getPatBalance(entId);
		printInfo.setPat_balance(patBalance.getPat_balance());
		
		//获取分诊台des
		OpurregNoteDTO oBenDes = this.getQueBenDes(entId);
		printInfo.setBenDes(oBenDes.getBenDes());
		//null情况的校验及处理
		this.TransNullToStr(printInfo);
		//设置预计等候人数,fanlq-2018-07-11
		this.setWaitNum(printInfo);
		//设置年龄  lilei 2019-2-14
		this.setAge(printInfo);
		return printInfo;
	}
	
	/**
	 * 获取医保支付、个人支付金额信息
	 * @param idEnt
	 * @param idCg
	 * @return
	 * @throws Exception
	 */
	private OpurregNoteDTO getAmt(String idEnt, String idCg) throws Exception{
		StringBuilder str_buf = new StringBuilder();
		str_buf.append("SELECT PAY.SD_PM, PAY.AMT ,PAY.EU_DIRECT,PM.NAME as name_pm ");
		str_buf.append("FROM BL_CG_ITM_OEP CG ");
		str_buf.append("INNER JOIN BL_ST_OEP ST ON CG.ID_STOEP = ST.ID_STOEP ");
		str_buf.append("INNER JOIN BL_PAY_ITM_PAT_OEP PAY ON ST.ID_PAYPATOEP = PAY.ID_PAYPATOEP ");
		str_buf.append("INNER JOIN BD_PRI_PM PM ON  PAY.SD_PM=PM.CODE ");
		str_buf.append("WHERE CG.ID_CGOEP = '" + idCg + "' ");
		str_buf.append("AND CG.ID_ENT = '" + idEnt + "' ");
		str_buf.append("GROUP BY ST.ID_PAYPATOEP,PAY.SD_PM, PAY.AMT, PAY.EU_DIRECT,PM.NAME");
		SqlReader sql = new SqlReader(null, str_buf.toString());
		sql.runSql(null, true);
		com.sun.rowset.CachedRowSetImpl cached_rs = sql.getCacheRowSet();
		
		BeanListHandler beanlist_handler = new BeanListHandler(OpurregNoteDTO.class);
		List<OpurregNoteDTO> result = (List<OpurregNoteDTO>)beanlist_handler.processRs(cached_rs);
		
		double amt = 0;
		double amt_hp = 0;
		double amt_ct = 0;
		double amt_sb = 0;
		double amt_pat = 0;
		String name_pm = "";
		if (result != null && result.size() > 0) {
			Map<String,OpurregNoteDTO> map1 = new HashMap<String,OpurregNoteDTO>();
			for (OpurregNoteDTO temp : result) {
				double a = temp.getAmt() * temp.getEu_direct();
				amt += a;
				if(map1.containsKey(temp.getSd_pm())){
					OpurregNoteDTO value = map1.get(temp.getSd_pm());
					value.setAmt(value.getAmt() + a);
				}else{
					temp.setAmt(a);
					temp.setEu_direct(1);
					map1.put(temp.getSd_pm(), temp);
				}
			}
			OpurregNoteDTO[] dtos = map1.values().toArray(new OpurregNoteDTO[0]);
			for (OpurregNoteDTO temp : dtos) {
				double a = temp.getAmt();
				if ("13".equals(temp.getSd_pm())) {
					amt_ct += a;
				}else if("14".equals(temp.getSd_pm())){
					amt_hp += a;
				}else if("17".equals(temp.getSd_pm())){
					amt_sb += a;
				}else{
					amt_pat += a;
				}
			}
			OpurregNoteDTO noteDTO = null;
			Map<String,Integer> map =  this.getPmStyleMap();
			for (OpurregNoteDTO temp : dtos) {
				if(temp.getAmt() <= 0){
					continue;
				}
				if(!map.containsKey(temp.getSd_pm())){
					noteDTO = temp;
					break;
				}
				if(noteDTO == null)
					noteDTO = temp;
				else{
					if(map.get(temp.getSd_pm())>map.get(noteDTO.getSd_pm())){
						noteDTO = temp;
					}
				}
			}
			if(noteDTO !=null){
				name_pm = noteDTO.getName_pm();
			}
		}
		OpurregNoteDTO opurreg = new OpurregNoteDTO();
		opurreg.setAmt(amt);
		opurreg.setAmt_hp(amt_hp);
		opurreg.setAmt_ct(amt_ct);
		opurreg.setAmt_sb(amt_sb);
		opurreg.setAmt_pat(amt_pat);	
		opurreg.setName_pm(name_pm);
		return opurreg;
	}
	
	/**
	 * 获取就诊信息
	 * @param entId
	 * @return
	 * @throws Exception
	 */
	private OpurregNoteDTO getPrintInfo(String entId) throws Exception{
		StringBuilder str_buf = new StringBuilder();
		str_buf.append("select ENT.NAME_PAT AS namePat,");
		str_buf.append("org.name as name_org,");
		str_buf.append("PAT.BARCODE_CHIS AS codeEnt,");
		str_buf.append("ENT.CODE AS entNo,");
		str_buf.append("ENT.ID_ENT AS entId,");
		str_buf.append("RES.ID_EMP AS id_emp,");
		str_buf.append("EMP_PHY.DRID AS drid,");
		str_buf.append("(CASE WHEN ENT.SD_SEX_PAT='1' THEN '男' ELSE '女' END) AS sex,");
		str_buf.append("SUBSTR(ENT.DT_ENTRY, 0, 10) AS dateReg,");
		str_buf.append("LOT.NAME AS dayslot,");
		str_buf.append("OP.ID_TICKS AS ticksId,");
		str_buf.append("OP.TICKETNO AS tickNo,");
		str_buf.append("OP.ID_SCRES AS scresId,");
		str_buf.append("SRV.NAME AS scsrvName,");
		str_buf.append("SRVTP.NAME AS nameSrvTp,");
		str_buf.append("TCKS.ID_TICKS AS ticksId,");
		str_buf.append("(SUBSTR(TCK.T_B, 0, 5) || '-' || SUBSTR(TCK.T_E, 0, 5)) AS timeInterval,");
		str_buf.append("TCK.T_B AS period,");
		str_buf.append("TCK.EU_ADD AS eu_add,");
		str_buf.append("SCH.SUGEST_EXMINT as suggestExmint,");
		str_buf.append("OP.ID_DEP_REG deptId,");
		str_buf.append("DEP.NAME AS deptName,");
		str_buf.append("PSN2.NAME AS doctorNm,");
		str_buf.append("PSN.CODE AS OPRATOR,");
		str_buf.append("PAT.CODE AS codePat,");
		str_buf.append("(CASE WHEN SC_APT.Id_Apt is null THEN OP.Eu_Regtp ELSE CHL.NAME END) AS chl_name,");
		str_buf.append("PSN.CODE AS oprator,");
		str_buf.append("PATCA.NAME AS namePatCa, ");
		str_buf.append("PAT.dt_birth as birthday, ");
		str_buf.append("card.code as card_num ");
		str_buf.append("FROM EN_ENT ENT ");
		str_buf.append("left join bd_org org on org.id_org = ent.id_org ");//显示组织名称，fanlq-2018-05-16
		str_buf.append("LEFT JOIN EN_ENT_OP OP ON OP.ID_ENT = ENT.ID_ENT ");
		str_buf.append("LEFT JOIN SC_SCH SCH ON OP.ID_SCH = SCH.ID_SCH ");
		str_buf.append("LEFT JOIN BD_DAYSLOT LOT ON OP.ID_DATESLOT = LOT.ID_DAYSLOT ");
		str_buf.append("LEFT JOIN SC_SRV SRV ON OP.ID_SCSRV = SRV.ID_SCSRV ");
		str_buf.append("LEFT JOIN SC_TICKS TCKS ON OP.ID_TICKS = TCKS.ID_TICKS ");
		str_buf.append("LEFT JOIN SC_TICK TCK ON OP.ID_TICK = TCK.ID_TICK ");
		str_buf.append("LEFT JOIN BD_DEP DEP ON OP.ID_DEP_REG = DEP.ID_DEP ");
		str_buf.append("LEFT JOIN BD_PSNDOC PSN ON ENT.ID_EMP_ENTRY = PSN.ID_PSNDOC ");
		str_buf.append("LEFT JOIN BD_PSNDOC PSN2 ON OP.ID_EMP_REG = PSN2.ID_PSNDOC ");
		str_buf.append("LEFT JOIN PI_PAT PAT ON ENT.ID_PAT = PAT.ID_PAT ");
		str_buf.append("LEFT JOIN PI_PAT_CA PATCA ON ENT.ID_PATCA = PATCA.ID_PATCA ");
		str_buf.append("LEFT JOIN BD_UDIDOC SRVTP ON SRV.ID_SRVTP = SRVTP.ID_UDIDOC ");
		str_buf.append("left join sc_apt_op opapt on opapt.id_en = ent.id_ent ");
		str_buf.append("LEFT JOIN SC_APT SC_APT ON sc_apt.id_apt = opapt.id_apt ");
		str_buf.append("LEFT JOIN SC_CHL CHL ON SC_APT.ID_SCCHL = CHL.ID_SCCHL ");
		str_buf.append("LEFT JOIN SC_RES RES ON RES.ID_EMP =  OP.ID_EMP_REG ");
		str_buf.append("LEFT JOIN BD_EMP_PHY EMP_PHY ON EMP_PHY.ID_PSNDOC = RES.ID_EMP ");
		str_buf.append("left join (select * from pi_pat_card where fg_act = 'Y') card on card.id_pat = pat.id_pat ");
		str_buf.append("WHERE ENT.ID_ENT='"+ entId +"' ");
		
		String str_sql = str_buf.toString().trim();
		str_buf.setLength(0);	
		str_buf.trimToSize();
		
		
		// 执行sql查询数据记录(SqlReader中自带宏定义的替换功能)
		SqlReader sql_rdr = new SqlReader(null, str_sql);
		sql_rdr.runSql(null, true);
		com.sun.rowset.CachedRowSetImpl cached_rs = sql_rdr.getCacheRowSet();
		
		// 转换成对应 DTO 对象
		BeanHandler beanlist_handler = new BeanHandler(OpurregNoteDTO.class);
		OpurregNoteDTO bean_info =
				(OpurregNoteDTO) beanlist_handler.processRs(cached_rs);
		sql_rdr.destroy();
		if(bean_info == null){
			return new OpurregNoteDTO();
		}
		
		return bean_info;
	}
	
	/**
	 * 计算年龄
	 * @param birthDate 出生日期
	 * @return
	 */
	public void setAge(OpurregNoteDTO printInfo){
		FDate birthDate = printInfo.getBirthday();
		if(birthDate==null)
			return;
		TimeService ts = ServiceFinder.find(TimeService.class);
		FDateTime currentTime = ts.getUFDateTime();
		int days = currentTime.getDate().getDaysAfter(birthDate);
		int age = days/365;
		printInfo.setAge_num(age);;		
	}

	/**
	 * 获取分诊台描述信息
	 * @param deptId
	 * @param scresId
	 * @return
	 * @throws Exception
	 */
	private OpurregNoteDTO getQueBenDes(String entId) throws Exception{
		StringBuilder str_buf = new StringBuilder();
		str_buf.append("SELECT BEN.DES AS benDes ");
		str_buf.append("FROM BD_QUE_BEN BEN ");
		str_buf.append("WHERE BEN.ID_QUEBEN IN (");
		str_buf.append("SELECT QUE.ID_QUEBEN ");
		str_buf.append("FROM BD_QUE QUE ");
		str_buf.append("WHERE QUE.ID_QUE IN (");	
		str_buf.append("SELECT ENQUE.ID_QUE ");
		str_buf.append("FROM EN_ENT_QUE ENQUE ");
		str_buf.append("WHERE ENQUE.ID_ENT='"+entId+"' ");
		str_buf.append(")");
		str_buf.append(")");
		String str_sql = str_buf.toString().trim();
		str_buf.setLength(0);	
		str_buf.trimToSize();
		
		// 执行sql查询数据记录(SqlReader中自带宏定义的替换功能)
		SqlReader sql_rdr = new SqlReader(null, str_sql);
		sql_rdr.runSql(null, true);
		com.sun.rowset.CachedRowSetImpl cached_rs = sql_rdr.getCacheRowSet();
		
		// 转换成对应 DTO 对象
		BeanHandler beanlist_handler = new BeanHandler(OpurregNoteDTO.class);
		OpurregNoteDTO bean_info =
				(OpurregNoteDTO) beanlist_handler.processRs(cached_rs);
		sql_rdr.destroy();
		if(bean_info == null){
			return new OpurregNoteDTO();
		}
		return bean_info;
	}
	
	/**
	 * 获取个人账户余额
	 * @param entId
	 * @return
	 * @throws Exception
	 */
	private OpurregNoteDTO getPatBalance(String entId) throws Exception{
		StringBuilder str_buf = new StringBuilder();
		str_buf.append("SELECT (ACC.PREPAY - ACC.ACC_LOCK) AS PAT_BALANCE ");
		str_buf.append("FROM PI_PAT_ACC ACC ");
		str_buf.append("WHERE ACC.ID_PAT IN(");
		str_buf.append("SELECT ENT.ID_PAT FROM EN_ENT ENT ");
		str_buf.append("WHERE ENT.ID_ENT='").append(entId).append("')");
		
		
		String str_sql = str_buf.toString().trim();
		str_buf.setLength(0);	
		str_buf.trimToSize();
		
		// 执行sql查询数据记录(SqlReader中自带宏定义的替换功能)
		SqlReader sql_rdr = new SqlReader(null, str_sql);
		sql_rdr.runSql(null, true);
		com.sun.rowset.CachedRowSetImpl cached_rs = sql_rdr.getCacheRowSet();
		
		// 转换成对应 DTO 对象
		BeanHandler beanlist_handler = new BeanHandler(OpurregNoteDTO.class);
		OpurregNoteDTO bean_info =
				(OpurregNoteDTO) beanlist_handler.processRs(cached_rs);
		sql_rdr.destroy();
		if(bean_info == null){
			return new OpurregNoteDTO();
		}
		return bean_info;
	}
	
	/**
	 * 设置预计就诊时间
	 * @param printInfo
	 */
	private void setPeriodInfo(OpurregNoteDTO printInfo, String periodFlag){
		Integer suggestExmin = new Integer(0);
		if(printInfo.getSuggestExmint() != null){
			suggestExmin = printInfo.getSuggestExmint();
		}
		FDateTime suggestTime = null;
		if(printInfo.getPeriod() != null){
			String tempFd = printInfo.getDateReg() + " " + printInfo.getPeriod();
			FDateTime fd = new FDateTime(tempFd);
			suggestTime = fd.subSeconds(suggestExmin * 60);
			//获取当前服务器时间
			FDateTime dt = new FDateTime();
			if(suggestTime.compareTo(dt) <= 0){
				//预计就诊时间小于当前时间
				printInfo.setPeriod("-");
				printInfo.setNo(printInfo.getTickNo());
			}else{
				if("2".equals(periodFlag)){
					printInfo.setPeriod(suggestTime.toString().substring(11, 16));
					printInfo.setNo(printInfo.getTickNo());
				}else{
					printInfo.setPeriod(printInfo.getTimeInterval());
					printInfo.setNo(printInfo.getTickNo());
				}
			}
		}else{
			printInfo.setPeriod("-");
			printInfo.setNo(printInfo.getTickNo());
		}
	}
	
	/**
	 * NULL情况替换为""
	 * @param printInfo
	 */
	private void TransNullToStr(OpurregNoteDTO printInfo){
		//科室
		if(printInfo.getDeptName() == null)
			printInfo.setDeptName("");
		//号别
		if(printInfo.getScsrvName() == null)
			printInfo.setScsrvName("");
		//就诊code
		if(printInfo.getCodeEnt() == null)
			printInfo.setCodeEnt("");
		//分诊台地址
		if(printInfo.getBenDes() == null)
			printInfo.setBenDes("");
		//医生
		if(printInfo.getDoctorNm() == null)
			printInfo.setDoctorNm("");
		//日期
		if(printInfo.getDateReg() == null)
			printInfo.setDateReg("");
		//no
		if(printInfo.getNo() == null)
			printInfo.setNo("");
		
		if(printInfo.getNamePatCa() == null)
			printInfo.setNamePatCa("");
		
		if(printInfo.getNameSrvTp() == null)
			printInfo.setNameSrvTp("");
	}
	
	/***
	 * 设置支付方式排序
	 * @author fanlq 2018年1月6日
	 * @param sd_pm
	 * @return
	 */
	private Map<String,Integer> getPmStyleMap(){
		Map<String,Integer> map = new HashMap<>();
		map.put("17",3);
		map.put("13",2);
		map.put("14",1);
		return map;
	}
	
	/**
	 * 设置候诊人数
	 * 
	 * @param disp
	 * @param es
	 * @throws BizException
	 */
	private void setWaitNum(OpurregNoteDTO printInfo) throws BizException {
		if(printInfo == null || StringUtils.isNullOrEmpty(printInfo.getEntId())){
			return;
		}
		SqlParam param = new SqlParam();
		StringBuilder sb = new StringBuilder();
		sb.append("select que.id_que as queId,que.id_que_site as quesiteId,que.id_dateslot as dateslotId,bq.sd_mode as sd_mode ");
		sb.append("from en_ent_que que ");
		sb.append("left join bd_que bq on bq.id_que = que.id_que ");
		sb.append("where 1=1 ");
		sb.append("and que.id_ent = ? ");
		param.addParam(printInfo.getEntId());
		@SuppressWarnings("unchecked")
		List<OpurregNoteDTO> list = (List<OpurregNoteDTO>) new DAFacade().execQuery(sb.toString(), param, new BeanListHandler(OpurregNoteDTO.class));
		if(list == null || list.size() <= 0)
			return;
		OpurregNoteDTO regInfo = list.get(0); 
		SqlParam param1 = new SqlParam();
		StringBuilder sb1 = new StringBuilder();
		sb1.append(getBaseSQL());//候诊
		sb1.append("AND EQ.DT_REGIST = ? ");
		sb1.append("AND EQ.ID_DATESLOT = ? ");
		param1.addParam("0");
		param1.addParam(FBoolean.TRUE);
		param1.addParam(printInfo.getDateReg());
		param1.addParam(regInfo.getDateslotId());
		/* 工作站叫号分诊 */
		if ("00".equals(regInfo.getSd_mode())) {
			sb1.append("AND EQ.ID_QUE = ? ");
			sb1.append("AND EQ.SD_STATUS_ACPT IN (?,?) ");
			param1.addParam(regInfo.getQueId());
			param1.addParam("0");
			param1.addParam("1");
		}
		/* 分诊台分诊 */
		else {
			sb1.append("AND EQ.ID_QUE=? ");
			sb1.append("AND EQ.SD_STATUS_ACPT IN (?,?,?) ");
			param1.addParam(regInfo.getQueId());
			param1.addParam("1");
			param1.addParam("2");
			param1.addParam("0");
		}
		Integer res = (Integer) new DAFacade().execQuery(sb1.toString(), param1, new ColumnHandler());
		if(res>=1){
			res = res-1;
		}
		printInfo.setWait_num(res);
	}
	private String getBaseSQL(){
		return "SELECT COUNT(EQ.ID_ENT_QUE) FROM EN_ENT_QUE EQ WHERE EQ.SD_ENTQUE_TP = ? AND EQ.FG_ACTIVE = ? "; 
	}
}

