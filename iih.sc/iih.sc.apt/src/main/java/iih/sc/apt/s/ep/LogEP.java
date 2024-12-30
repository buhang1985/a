package iih.sc.apt.s.ep;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.en.pv.dto.d.EntStateDTO;
import iih.sc.comm.ScAppUtils;
import iih.sc.comm.ScContextUtils;
import iih.sc.scbd.log.d.EuOperTp;
import iih.sc.scbd.log.d.ScLogRecDO;
import iih.sc.scbd.log.i.ISclogrecCudService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * sc日志EP
 * @author fanlq
 *
 */
public class LogEP {

	/**
	 * 保存日志
	 * 
	 * @param pvDO
	 * @return
	 * @throws BizException
	 */
	public ScLogRecDO saveLog(ScLogRecDO logDO) throws BizException {
		ISclogrecCudService logCudService = ServiceFinder.find(ISclogrecCudService.class);
		ScLogRecDO[] logDOs = logCudService.save(new ScLogRecDO[] { logDO });
		return logDOs[0];
	}
	
	/**
	 * 增加日志
	 * 
	 * @param pvDO
	 * @return
	 * @throws BizException
	 */
	public ScLogRecDO insertLog(ScLogRecDO logDO) throws BizException {
		ISclogrecCudService logCudService = ServiceFinder.find(ISclogrecCudService.class);
		ScLogRecDO[] logDOs = logCudService.insert(new ScLogRecDO[] { logDO });
		return logDOs[0];
	}
	
	/***
	 * 换患者保存日志
	 * @param patId -换患者前的患者id
	 * @param newPatId - 换患者后的患者id
	 * @param entId -就诊id
	 * @return
	 * @throws BizException
	 */
	public ScLogRecDO changePatSaveLog(String patId,String newPatId,String entId) throws BizException{
		if (StringUtil.isEmptyWithTrim(patId)) {
			return null;
		}
		if (StringUtil.isEmptyWithTrim(newPatId)) {
			return null;
		}
		if (StringUtil.isEmptyWithTrim(entId)) {
			return null;
		}
		ScLogRecDO logDO = new ScLogRecDO();
		logDO.setName_table("en_ent");
		logDO.setId_data(entId);
		logDO.setId_parent_data(entId);
		logDO.setDt_log(ScAppUtils.getServerDateTime());
		logDO.setId_emp(ScContextUtils.getPsnId());
		logDO.setEu_operate(EuOperTp.OTHERS);
		logDO.setContent("患者id ：\n "+patId+"\t—>\t"+newPatId);
		logDO.setCode_bp("EN_CHG_PAT");
		logDO.setName_rec("就诊取号换患者");
		return this.insertLog(logDO);
	}
	/**
	 * 就诊换号  - 日志记录
	 * @author fanlq 2017年11月20日
	 * @param entId - 就诊id
	 * @param id_patca_old - 原患者分类
	 * @param id_patca_new - 新患者分类
	 * @param id_pripat_old - 原价格分类
	 * @param id_pripat_new - 新价格分类
	 * @param id_hp_old - 原医保id
	 * @param id_hp_new -新医保id
	 * @param id_emp_change - 修改人
	 * @return
	 * @throws BizException
	 */
	public ScLogRecDO entChangPatSaveLog(String entId,String id_patca_old,String id_patca_new,String id_pripat_old,String id_pripat_new,
			String id_hp_old,String id_hp_new,String id_emp_change) throws BizException{
		if (StringUtil.isEmptyWithTrim(entId)) {
			return null;
		}
		if (StringUtil.isEmptyWithTrim(id_emp_change)) {
			return null;
		}
		ScLogRecDO logDO = new ScLogRecDO();
		logDO.setName_table("en_ent");
		logDO.setId_data(entId);
		logDO.setId_parent_data(entId);
		logDO.setDt_log(ScAppUtils.getServerDateTime());
		logDO.setId_emp(id_emp_change);
		logDO.setEu_operate(EuOperTp.OTHERS);
		logDO.setContent(" 患者patca ： "+id_patca_old+"\t = \t"+id_patca_new+
				         "\n 患者id_pripat ："+id_pripat_old+"\t -> \t "+id_pripat_new+
				         "\n 患者id_hp ："+id_hp_old+"\t -> \t "+id_hp_new);
		logDO.setCode_bp("EN_CHG_PATCA");
		logDO.setName_rec("就诊更改患者分类");
		return this.insertLog(logDO);
	}
	/**
	 * 就诊患者状况维护-日志记录
	 * @author fanlq 2017年11月20日
	 * @param entId
	 * @param name_leve_nur -护理等级
	 * @param name_level_dise - 病情等级
	 * @param name_level_nutr - 饮食类型
	 * @param entStateDTO -就诊状况DTO
	 * @return
	 * @throws BizException
	 */
	public ScLogRecDO entStateSaveLog(String entId,String code_leve_nur,String code_level_dise,String code_level_nutr,EntStateDTO entStateDTO) throws BizException{
		if (StringUtil.isEmptyWithTrim(entId)) {
			return null;
		}
		ScLogRecDO logDO = new ScLogRecDO();
		logDO.setName_table("en_ent_state");
		logDO.setId_data(entId);
		logDO.setId_parent_data(entId);
		logDO.setDt_log(ScAppUtils.getServerDateTime());
		logDO.setId_emp(ScContextUtils.getPsnId());
		logDO.setEu_operate(EuOperTp.OTHERS);
		logDO.setContent(this.getNameNursignStatus(code_leve_nur)+"、"+this.getNameDradeStatus(code_level_dise)+"、"+this.getNameEnStatus(code_level_nutr)+";"+
						this.getEnStateTp(entStateDTO.getId_enstatetp())+"\t"+this.getEnStateDef(entStateDTO.getId_entstatedef())+"\t"+entStateDTO.getDt_occ());
		logDO.setCode_bp("EN_CHG_ENTSTATE");
		logDO.setName_rec("修改患者就诊状况");
		return this.insertLog(logDO);
	}
	/***
	 * 获取护理等级名称
	 * @author fanlq 2017年11月20日
	 * @param code_leve_nur - 护理等级code
	 * @return
	 */
	public String getNameNursignStatus(String code_leve_nur){
		String name_leve_nur = null;
		if (StringUtil.isEmptyWithTrim(code_leve_nur)) {
			return null;
		}
		switch(code_leve_nur){
		case IBdFcDictCodeConst.NURSING_STATUS_SERIOUS:
			name_leve_nur = IBdFcDictCodeConst.NAME_NURSING_STATUS_SERIOUS;
			break;
		case IBdFcDictCodeConst.NURSING_STATUS_FIRST:
			name_leve_nur = IBdFcDictCodeConst.NAME_NURSING_STATUS_FIRST;
			break;
		case IBdFcDictCodeConst.NURSING_STATUS_SECOND:
			name_leve_nur = IBdFcDictCodeConst.NAME_NURSING_STATUS_SECOND;
			break;
		case IBdFcDictCodeConst.NURSING_STATUS_THIRD:
			name_leve_nur = IBdFcDictCodeConst.NAME_NURSING_STATUS_THIRD;
			break;
		}
		return name_leve_nur;
	}
	/**
	 * 获取病情等级名称
	 * @author fanlq 2017年11月20日
	 * @param code_drade - 病情等级code
	 * @return
	 */
	public String getNameDradeStatus(String code_drade){
		String name_drade = null;
		if (StringUtil.isEmptyWithTrim(code_drade)) {
			return null;
		}
		switch(code_drade){
		case IBdFcDictCodeConst.CONDITION_GRADE_DYING:
			name_drade = IBdFcDictCodeConst.NAME_CONDITION_GRADE_DYING;
			break;
		case IBdFcDictCodeConst.CONDITION_GRADE_SEVERITY:
			name_drade = IBdFcDictCodeConst.NAME_CONDITION_GRADE_SEVERITY;
			break;
		case IBdFcDictCodeConst.CONDITION_GRADE_ORDINARY:
			name_drade = IBdFcDictCodeConst.NAME_CONDITION_GRADE_ORDINARY;
			break;
		}
		return name_drade;
	}
	/**
	 * 获取饮食状态名称
	 * @author fanlq 2017年11月20日
	 * @param code_en_state -饮食等级code
	 * @return
	 */
	public String getNameEnStatus(String code_en_state){
		String name_en_state = null;
		if (StringUtil.isEmptyWithTrim(code_en_state)) {
			return null;
		}
		switch(code_en_state){
		case IBdFcDictCodeConst.EN_STATE_ORDINARY:
			name_en_state = IBdFcDictCodeConst.NAME_EN_STATE_ORDINARY;
			break;
		case IBdFcDictCodeConst.EN_STATE_LIQUIDIET:
			name_en_state = IBdFcDictCodeConst.NAME_EN_STATE_LIQUIDIET;
			break;
		case IBdFcDictCodeConst.EN_STATE_HALFLIQUIDIET:
			name_en_state = IBdFcDictCodeConst.NAME_EN_STATE_HALFLIQUIDIET;
			break;
		case IBdFcDictCodeConst.EN_STATE_FASTING:
			name_en_state = IBdFcDictCodeConst.NAME_EN_STATE_FASTING;
			break;
		}
		return name_en_state;
	}
	/***
	 * 获取就诊状况类型名称-自定义档案
	 * @author fanlq 2017年11月20日
	 * @param id_enstatetp - 就诊状况类型id
	 * @return
	 * @throws BizException
	 */
	public String getEnStateTp(String id_enstatetp) throws BizException{
		StringBuilder builder = new StringBuilder();
		SqlParam param = new SqlParam();
		builder.append("SELECT BD.NAME ");
		builder.append("FROM BD_UDIDOC BD ");
		builder.append("WHERE BD.ID_UDIDOC = ? ");
		param.addParam(id_enstatetp);
		String name_enstatetp = (String) new DAFacade().execQuery(builder.toString(), param, new ColumnHandler());
		return name_enstatetp;
	}
	/***
	 * 就诊状况名称
	 * @author fanlq 2017年11月20日
	 * @param id_entstatedef - 就诊状况id
	 * @return
	 * @throws BizException
	 */
	public String getEnStateDef(String id_entstatedef) throws BizException{
		StringBuilder builder = new StringBuilder();
		SqlParam param = new SqlParam();
		builder.append("SELECT BD.NAME ");
		builder.append("FROM BD_ENSTATE BD ");
		builder.append("WHERE BD.ID_ENSTATE = ? ");
		param.addParam(id_entstatedef);
		String name_val = (String) new DAFacade().execQuery(builder.toString(), param, new ColumnHandler());
		return name_val;
	}
}
