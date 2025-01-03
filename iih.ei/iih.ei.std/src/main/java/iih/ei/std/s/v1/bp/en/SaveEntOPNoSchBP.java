package iih.ei.std.s.v1.bp.en;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import com.mysql.jdbc.StringUtils;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.bd.fc.que.d.QueDO;
import iih.bd.fc.que.i.IQueRService;
import iih.bd.fc.quesite.d.QueSiteDO;
import iih.bd.res.dayslot.d.DaysLotDO;
import iih.ei.std.d.v1.en.saveenopnoschdto.d.SaveEntOPNoSchParamDTO;
import iih.ei.std.d.v1.en.saveenopnoschdto.d.SaveEntOPNoSchResultDTO;
import iih.ei.std.s.v1.bp.IIHServiceBaseBP;
import iih.ei.std.s.v1.bp.common.DeptEP;
import iih.ei.std.s.v1.bp.common.EiParamUtils;
import iih.ei.std.s.v1.bp.common.PatEP;
import iih.ei.std.s.v1.bp.common.PsnDocEP;
import iih.ei.std.s.v1.bp.common.en.EnExtEP;
import iih.en.pv.enres.d.EnExtDO;
import iih.en.pv.outpatient.dto.d.OpRegPatDTO;
import iih.en.que.dto.d.ReceptionQueDTO;
import iih.en.que.i.IEnQueOutCmdService;
import iih.pi.dic.patientcategory.d.PiPatCaDO;
import iih.pi.reg.pat.d.PatDO;
import iih.sc.scbd.i.IScDaysLotService;
import iih.sc.scbd.scheduleres.d.ScheduleResDO;
import iih.sc.scbd.scheduleres.i.IScheduleresRService;
import iih.sc.scbd.schedulesrv.d.ScheduleSrvDO;
import iih.sc.scbd.schedulesrv.d.ScheduleSrvRelDO;
import iih.sc.scbd.schedulesrv.i.IScheduleSrvRelDORService;
import iih.sc.scbd.schedulesrv.i.ISchedulesrvMDORService;
import iih.sc.sch.reg.dto.d.EuRegSchTp;
import iih.sc.sch.reg.dto.d.RegResDTO;
import iih.sc.sch.reg.dto.d.RelSrvDTO;
import iih.sc.scp.scplan.d.ScPlanDO;
import iih.sc.scp.scplan.i.IScplanRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.core.service.time.TimeService;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.orgfw.dept.d.DeptDO;
/***
 * 无排班挂号
 * @author li.wm
 * @date: 2020年06月05日 
 */
public class SaveEntOPNoSchBP extends IIHServiceBaseBP<SaveEntOPNoSchParamDTO, SaveEntOPNoSchResultDTO> {
	
	
	
	/***
	 * 参数校验
	 * @param param
	 */
	@Override
	protected void checkParam(SaveEntOPNoSchParamDTO param) throws BizException {
		if(StringUtils.isNullOrEmpty(param.getName_pat())){
			throw new BizException("患者姓名不能为空！");
		}
		
		if(StringUtils.isNullOrEmpty(param.getCode_pat())){
			throw new BizException("患者编码不能为空！");
		}
		
		if (StringUtils.isNullOrEmpty(param.getSd_sex())){
			throw new BizException("患者性别不能为空！");
		}
		
		if(StringUtils.isNullOrEmpty(param.getCode_dep_phy())){
			throw new BizException("就诊科室不能为空！");
		}
		
		
		if (StringUtils.isNullOrEmpty(param.getDt_entry())){
			throw new BizException("就诊日期不能为空！");
		}
		
		if (StringUtils.isNullOrEmpty(param.getCode_emp_entry())){
			throw new BizException("登记人不能为空！");
		}
		if (StringUtils.isNullOrEmpty(param.getDt_valid_b())){
			throw new BizException("就诊开始有效时间不能为空！");
		}
		// 判断就诊日期格式
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	    try {
	        formatter.parse(param.getDt_entry());
	    } catch (Exception e) {
	        throw new BizException("就诊日期格式错误");
	    }
		// 判断就诊开始有效时间日期格式
	    DateFormat fromat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    try {
	    	fromat.parse(param.getDt_valid_b());
	    } catch (Exception e) {
	        throw new BizException("就诊开始有效时间s格式错误");
	    }
	}
	/***
	 * 判断患者在当前时段是否有就诊记录
	 * @param param
	 */
	@SuppressWarnings("unchecked")
	private String checkParameter(SaveEntOPNoSchParamDTO param) throws BizException {
		StringBuffer sql = new StringBuffer();
		SqlParam sqlParam = new SqlParam();
		sql.append("SELECT DISTINCT ID_ENT FROM ( ");
		sql.append("SELECT ENT.ID_ENT AS ID_ENT FROM EN_ENT ENT  ");
		sql.append("INNER JOIN EN_ENT_OP OP ON OP.ID_ENT = ENT.ID_ENT  " );
		sql.append("INNER JOIN BD_DEP DEP ON DEP.ID_DEP = ENT.ID_DEP_PHY  " );
		sql.append("INNER JOIN  EN_ENT_EXT EXT ON EXT.ID_ENT = ENT.ID_ENT " );
		sql.append("INNER JOIN  PI_PAT PAT ON PAT.ID_PAT = ENT.ID_PAT " );
		sql.append("WHERE 1=1  " );
		sql.append(" AND ENT.FG_CANC = ? " );
		sqlParam.addParam(FBoolean.FALSE);
		sql.append(" AND DEP.CODE = ? " );
		sqlParam.addParam(param.getCode_dep_phy());
		sql.append(" AND PAT.CODE = ? " );
		sqlParam.addParam(param.getCode_pat());
		sql.append(" AND OP.DT_VALID_B  <= ? " );
		sqlParam.addParam(param.getDt_valid_b());
		sql.append(" AND OP.DT_VALID_E  >= ? " );
		sqlParam.addParam(param.getDt_valid_b());
		if(!StringUtils.isNullOrEmpty(param.getSd_regextp())){
			sql.append(" AND EXT.SD_REGEXTP = ? " );
			sqlParam.addParam(param.getSd_regextp());
		}
		if(!StringUtils.isNullOrEmpty(param.getNote_ex())){
			sql.append(" AND EXT.NOTE_EX = ? " );
			sqlParam.addParam(param.getNote_ex());
		}
		sql.append(" ORDER BY OP.TIMES_OP DESC ) " );
		List<String> resutl  = (List<String>)new DAFacade().execQuery(sql.toString(),sqlParam,new ColumnListHandler());
		if(ListUtil.isEmpty(resutl)){
			 return null;
		}
		
		return resutl.get(0);
	}
	
	/***
	 * 判断患者在当前时段是是否有挂号记录
	 * @param param
	 */
	@SuppressWarnings("unchecked")
	private String checkRegist(SaveEntOPNoSchParamDTO param) throws BizException {
		StringBuffer sql = new StringBuffer();
		SqlParam sqlParam = new SqlParam();
		sql.append("SELECT DISTINCT ID_ENT FROM ( ");
		sql.append("SELECT ENT.ID_ENT AS ID_ENT FROM EN_ENT ENT  ");
		sql.append("INNER JOIN EN_ENT_OP OP ON OP.ID_ENT = ENT.ID_ENT  " );
		sql.append("INNER JOIN BD_DEP DEP ON DEP.ID_DEP = ENT.ID_DEP_PHY  " );
		sql.append("INNER JOIN  PI_PAT PAT ON PAT.ID_PAT = ENT.ID_PAT " );
		sql.append("WHERE 1=1  " );
		sql.append(" AND ENT.FG_CANC = ? " );
		sqlParam.addParam(FBoolean.FALSE);
		sql.append(" AND DEP.CODE = ? " );
		sqlParam.addParam(param.getCode_dep_phy());
		sql.append(" AND PAT.CODE = ? " );
		sqlParam.addParam(param.getCode_pat());
		sql.append(" AND OP.DT_VALID_B  <= ? " );
		sqlParam.addParam(param.getDt_valid_b());
		sql.append(" AND OP.DT_VALID_E  >= ? " );
		sqlParam.addParam(param.getDt_valid_b());
		sql.append(" ORDER BY OP.TIMES_OP DESC ) " );
		List<String> resutl  = (List<String>)new DAFacade().execQuery(sql.toString(),sqlParam,new ColumnListHandler());
		if(ListUtil.isEmpty(resutl)){
			 return null;
		}
		
		return resutl.get(0);
	}
	/***
	 * 过程
	 * @param param
	 */
	@Override
	protected SaveEntOPNoSchResultDTO process(SaveEntOPNoSchParamDTO param) throws BizException {
		//获取出参
		SaveEntOPNoSchResultDTO result= new SaveEntOPNoSchResultDTO();
		//判断是否有就诊记录
		String value = this.checkParameter(param);
		
		if(StringUtil.isEmpty(value)){
			IEnQueOutCmdService outQue = ServiceFinder.find(IEnQueOutCmdService.class);
			// 组装挂号资源信息
			RegResDTO regresDTO = assembleRegresDTO(param);
			// 组装站点信息
			QueSiteDO queSiteDO = assembleQueSiteDO(param,regresDTO);
			// 组装 门诊登记患者DTO
			OpRegPatDTO opRegPatDTO = assembleOpRegPatDTO(param);
			// 查询患者挂号记录
			String entId =  this.checkRegist(param);
			if(StringUtil.isEmpty(entId)){
				
				ReceptionQueDTO regAndAcpt = outQue.regAndAcpt(opRegPatDTO, queSiteDO, regresDTO, param.getNote_ex(),null,new FDateTime(param.getDt_valid_b()));
				
				// 设置En_ent_ext 
				EnExtEP enExtEP = new EnExtEP();
				EnExtDO[] enExtDOs = enExtEP.getByEntIds(new String[]{regAndAcpt.getId_ent()});
				enExtDOs[0].setSd_regextp(param.getSd_regextp());
				enExtDOs[0].setNote_ex(param.getNote_ex());
				enExtDOs[0].setStatus(DOStatus.UPDATED);
				enExtEP.save(enExtDOs);
				// 设置返回结果
				result.setCode_ent(regAndAcpt.getCode_ent());
				result.setCode_pat(regAndAcpt.getCode_pat());
				result.setTimes_op(regAndAcpt.getTimes_op());
			}else{
				FBoolean receive = outQue.receive(entId, queSiteDO, regresDTO.getId_dayslot(), regresDTO, param.getNote_ex());
				if(receive.booleanValue()){
					result = getResultInfo(entId);
				}
			}
			
		}else{
			result = getResultInfo(value);
		}
		
		
		return result;
	}
	
	
	/**
	 * 设置返回结果
	 * @param resultBean
	 * @param enHosPat
	 * @param enHosReg
	 */
	@SuppressWarnings("unchecked")
	private SaveEntOPNoSchResultDTO getResultInfo(String id_ent) throws BizException{
		StringBuffer sql = new StringBuffer();
		SqlParam sqlparam = new SqlParam(); 
		sql.append(" SELECT PAT.CODE AS CODE_PAT, ");
		sql.append(" ENT.CODE AS CODE_ENT,  " );
		sql.append(" OP.TIMES_OP " );
		sql.append(" FROM EN_ENT ENT " );
		sql.append(" INNER JOIN EN_ENT_OP OP ON OP.ID_ENT = ENT.ID_ENT  " );
		sql.append(" INNER JOIN PI_PAT PAT ON PAT.ID_PAT = ENT.ID_PAT " );
		sql.append(" WHERE ENT.ID_ENT = ? " );
		sqlparam.addParam(id_ent);
		
		List<SaveEntOPNoSchResultDTO> list = (List<SaveEntOPNoSchResultDTO>) new DAFacade().execQuery(sql.toString(),sqlparam,new BeanListHandler(SaveEntOPNoSchResultDTO.class));
		if(ListUtil.isEmpty(list)){
			return null;
		}
		return list.get(0);
		
	}
	
	
	/**
	 * 组装QueSiteDO
	 * @param param
	 * @return QueSiteDO
	 */
	private QueSiteDO assembleQueSiteDO(SaveEntOPNoSchParamDTO param,RegResDTO regResDTO) throws BizException {
		QueSiteDO queSiteDO = new QueSiteDO();
		
		queSiteDO.setId_dep(regResDTO.getId_dep());
		queSiteDO.setDep_name(regResDTO.getName_dep());
		
		PsnDocDO psnDocDO = new PsnDocEP().getPsnByCode(param.getCode_emp_entry());
		if(psnDocDO == null){
			throw new BizException("没有查到对应的登记人。");
		}
		queSiteDO.setId_emp(psnDocDO.getId_psndoc());
		queSiteDO.setEmp_name(psnDocDO.getName());
		
		if(!StringUtils.isNullOrEmpty(regResDTO.getId_que())){
			queSiteDO.setId_que(regResDTO.getId_que());
		}
		return queSiteDO;
	}
	
	/**
	 * 组装RegresDTO
	 * @param paramDTO
	 * @return RegresDTO
	 */
	@SuppressWarnings({ "static-access", "unchecked" })
	private RegResDTO assembleRegresDTO(SaveEntOPNoSchParamDTO paramDTO) throws BizException{
		RegResDTO regResDTO = new RegResDTO();
		// 设置科室数据
		DeptDO deptByCode = new DeptEP().getDeptByCode(paramDTO.getCode_dep_phy());
		if(deptByCode == null){
			throw new BizException("科室编码查不到对应的数据。");
		}
		regResDTO.setId_dep(deptByCode.getId_dep());
		regResDTO.setName_dep(deptByCode.getName());
		
		// 判断 当前时间 是不是在 就诊有效开始时间和就诊有时间
		int hour = EiParamUtils.getOpValidHours(deptByCode.getId_dep());
		FDateTime nowDate = ServiceFinder.find(TimeService.class).getUFDateTime();// 当前时间
		FDateTime dt_valid_b = new FDateTime(paramDTO.getDt_valid_b());// 就诊有效开始时间
		FDateTime dt_valid_e = dt_valid_b.addSeconds(hour * 3600 );//就诊有效结束时间
		if(hour == 0){
			FDate date = dt_valid_b.getBeginDate();
			if(!date.isSameDate(new FDate())){
				throw new BizException("参数ENOP0001设置0，当天接诊有效。");
			}
		}else {
			if(dt_valid_b.after(nowDate) || dt_valid_e.before(nowDate)){
				throw new BizException("当前时间不在就诊有效期内。");
			}
		}
		
		
		// 设置日期分组数据
		DaysLotDO nowDaysLotCross = ServiceFinder.find(IScDaysLotService.class).getNowDaysLotCross(IScDictCodeConst.SD_SCTP_OP, FBoolean.TRUE);
		if(nowDaysLotCross == null){
			throw new BizException("当前时间不在日期分组中。");
		}
		regResDTO.setId_dayslot(nowDaysLotCross.getId_dayslot());
		regResDTO.setName_dayslot(nowDaysLotCross.getName());
		// 获取系统设置的排班服务
		EiParamUtils eiParamUtils = new EiParamUtils();
		String id_scsrv = eiParamUtils.geNoSchScSrv();
		if(StringUtil.isEmpty(id_scsrv)){
			throw new BizException("参数 SC0112 必须设置排班服务。");
		}
		ISchedulesrvMDORService  srv= ServiceFinder.find(ISchedulesrvMDORService.class);
		ScheduleSrvDO scsrv = srv.findById(id_scsrv);
		if(scsrv == null){
			throw new BizException("排班服务ID查不到对应的数据。");
		}
		if(!(scsrv.getFg_active().booleanValue())){
			throw new BizException("排版服务必须是可用的");
		}
		regResDTO.setId_scsrv(scsrv.getId_scsrv());
		regResDTO.setName_scsrv(scsrv.getName());
		
		// 获取服务对应的医疗服务列表（只有一个是主要的）
		IScheduleSrvRelDORService scsrvrel = ServiceFinder.find(IScheduleSrvRelDORService.class);
		ScheduleSrvRelDO[] scheduleSrvRelDOs = scsrvrel.find(" a1.id_scsrv = '"+ scsrv.getId_scsrv() +"'   and   a1.fg_maj = 'Y' ", "", FBoolean.FALSE);
		if(ArrayUtil.isEmpty(scheduleSrvRelDOs)){
			throw new BizException("排班服务对应的医疗服务没有设置");
		}
		FArrayList list = new FArrayList();
		RelSrvDTO relSrvDTO = new RelSrvDTO();
		relSrvDTO.setId_srv(scheduleSrvRelDOs[0].getId_mdsrv());
		relSrvDTO.setId_scsrv(scheduleSrvRelDOs[0].getId_scsrv());
		relSrvDTO.setId_srvtp(scheduleSrvRelDOs[0].getId_srvtp());
		relSrvDTO.setSd_srvtp(scheduleSrvRelDOs[0].getSd_srvtp());
		relSrvDTO.setName_srv(scheduleSrvRelDOs[0].getName_scsrv());
		list.add(relSrvDTO);
		regResDTO.setSrvarray(list);
		
		// 获取排班资源
		IQueRService que = ServiceFinder.find(IQueRService.class);
		IScheduleresRService res = ServiceFinder.find(IScheduleresRService.class);
		String resWhere = " a0.sd_screstp = '"+IScDictCodeConst.SD_SCRESTP_DEP+"' and a0.id_dep = '"+deptByCode.getId_dep()+"' and  a0.fg_active = 'Y' ";
		ScheduleResDO[] scres = res.find(resWhere,"", FBoolean.FALSE);
		if(scres == null || scres.length == 0){
			throw new BizException("该科室没有对应的部门资源，请设置资源。");
		}
		regResDTO.setId_scres(scres[0].getId_scres());
		regResDTO.setName_scres(scres[0].getName());
		
		// 获取人员信息
		PsnDocDO psnDO = new PsnDocEP().getPsnByCode(paramDTO.getCode_emp_entry());
		if(psnDO == null){
			throw new BizException("没有查到对应的登记人。");
		}
		regResDTO.setId_emp(psnDO.getId_psndoc());
		
		// 获取对应的排班
		IScplanRService scPlanService = ServiceFinder.find(IScplanRService.class);
		String whereStr = " a0.id_scres = '"+scres[0].getId_scres()+"'  and  a0.id_scsrv =  '" + scsrv.getId_scsrv()+ "'  and a0.id_dep = '"+deptByCode.getId_dep()+"'  and a0.fg_active = 'Y' and a0.fg_stopsch = 'N'";
		ScPlanDO[] scPlanDOs = scPlanService.find(whereStr, "", FBoolean.FALSE);
		if(scPlanDOs == null || scPlanDOs.length == 0){
			throw new BizException("没有对应的排班计划。");
		}
		
		if(!(scPlanDOs.length ==1)){
			throw new BizException("科室(资源对应的部门)的分诊台必须是一个。");
		}
		String whereQue = " a0.id_scres = '"+scres[0].getId_scres()+"' and a0.id_dep = '"+deptByCode.getId_dep()+"'  and a0.id_queben = '"+scPlanDOs[0].getId_queben()+"'  and a0.fg_active = 'Y' ";
		QueDO[] queDOs = que.find(whereQue,"", FBoolean.FALSE);
		if(ArrayUtil.isEmpty(scheduleSrvRelDOs)){
			throw new BizException("部门对应的队列没有查到，请生成排班计划（生成排班计划的时候同时也就生成了队列）");
		}
		regResDTO.setId_que(queDOs[0].getId_que());
		regResDTO.setD_sch(new FDate(paramDTO.getDt_entry()));
		regResDTO.setEu_regrestp(EuRegSchTp.REGNOSCH);
		return regResDTO;
	}
	
	
	/**
	 * 组装OpRegPatDTO
	 * @param param
	 * @return OpRegPatDTO
	 */
	private OpRegPatDTO assembleOpRegPatDTO(SaveEntOPNoSchParamDTO param) throws BizException {
		PatEP patEP = new PatEP();
		OpRegPatDTO opRegPatDTO = new OpRegPatDTO();
		PatDO patDO = patEP.getPatByCode(param.getCode_pat());
		if(patDO == null){
			throw new BizException("没有查到对应的患者，请注册患者。");
		}
		opRegPatDTO.setId_pat(patDO.getId_pat());
		opRegPatDTO.setCode_pat(patDO.getCode());
		opRegPatDTO.setId_patca(patDO.getId_paticate());
		opRegPatDTO.setId_pripat(patDO.getId_patpritp());
		PiPatCaDO patCaById = patEP.getPatCaById(patDO.getId_paticate());
		if(patCaById == null){
			throw new BizException("没有查到对应的患者分类。");
		}
		opRegPatDTO.setName_patca(patCaById.getName());
		if(!(param.getName_pat().equals(patDO.getName()))){
			throw new BizException("注册的姓名和输入的姓名不一致。");
		}
		opRegPatDTO.setName_pat(patDO.getName());
		return opRegPatDTO;
	}
	
}
