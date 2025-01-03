package iih.sc.scbd.s.bp;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import iih.bd.base.utils.AppUtils;
import iih.sc.scbd.dto.d.ScPrtCfgQryDTO;
import iih.sc.scbd.dto.d.ScPrtTmplDTO;
import iih.sc.scbd.scprtcfg.d.ScPrtCfgDO;
import iih.sc.scbd.scprtcfg.i.IScprtcfgRService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.FDateUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.core.xstream.FDateConverter;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 打印模板相关
 * @author lilei
 *
 */
public class GetScPrtTmplBp {

	private static String EU_DEP = "1";
	private static String EU_ALLDEP = "0";
	/**
	 * 根据打印模板项目配置信息查询 打印模板
	 * @param qryDTO
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public ScPrtTmplDTO getScPrtTmplDTOByCfg(ScPrtCfgQryDTO qryDTO) throws BizException{
		//校验数据
		this.checkParam(qryDTO);
		//查就诊打印配置
		IScprtcfgRService iScprtcfgRService = ServiceFinder.find(IScprtcfgRService.class);
		ScPrtCfgDO[] list = iScprtcfgRService.find(String.format(" fg_active = 'Y' and sd_rpttp = '%S' ", qryDTO.getSd_rpttp()), "", FBoolean.FALSE);
		if(ArrayUtil.isEmpty(list)){
			throw new BizException("就诊打印配置为空，请设置");
		}
		//筛选数据
		List<ScPrtCfgDO> result = new ArrayList<ScPrtCfgDO>();
		for (ScPrtCfgDO dto : list) {
			if(screenData(dto, qryDTO)){
				if(ListUtil.isEmpty(result) || dto.getLevel_pri() == result.get(0).getLevel_pri()){
					result.add(dto);
				}else if(dto.getLevel_pri() > result.get(0).getLevel_pri()){
					result.clear();
					result.add(dto);
				}
			}
		}
		//结果为空提示
		checkResult(result);
		//查模板
		ScPrtTmplDTO scPrtTmplDTO = findTmpl(result.get(0).getId_prttmpl());
		if(scPrtTmplDTO == null ){
			throw new BizException("id为"+result.get(0).getId_prttmpl()+"的打印模板找不到，请设置打印模板");
		}
		return scPrtTmplDTO;
	}
	
	private void checkParam(ScPrtCfgQryDTO qryDTO) throws BizException{
		if(qryDTO == null) throw new BizException("打印模板请求参数为空！");
		if(StringUtil.isEmpty(qryDTO.getSd_rpttp())) throw new BizException("预约打印类型编码不能为空！");
		if(StringUtil.isEmpty(qryDTO.getId_dep_phy())) throw new BizException("科室id不能为空！");
		if(StringUtil.isEmpty(qryDTO.getId_dep_nur())) throw new BizException("病区id不能为空！");
		if(StringUtil.isEmpty(qryDTO.getSd_rpttp())) throw new BizException("就诊打印类型编码不能为空");
	}
	
	private void checkResult(List<ScPrtCfgDO> result) throws BizException{
		if(ListUtil.isEmpty(result)){
			throw new BizException("找不到可匹配的打印配置，请设置就诊打印配置");
		}
		if(result.size()>1){
			throw new BizException("匹配到"+result.size()+"条优先级相等的打印配置，请检查相关打印配置");
		}
		if(StringUtil.isEmpty(result.get(0).getId_prttmpl())){
			throw new BizException("打印配置里的打印模板id为空，请检查就诊打印配置");
		}
	}
	/**
	 * 筛选
	 * @return
	 */
	private boolean screenData(ScPrtCfgDO cfgDo, ScPrtCfgQryDTO qryDTO){
		//是科室，且id不等于科室，不等于病区   false
		if(EU_DEP.equals(cfgDo.getEu_rang_dep()) && !cfgDo.getId_dep().equals(qryDTO.getId_dep_phy()) 
				&& !cfgDo.getId_dep().equals(qryDTO.getId_dep_nur())){
			return false;
		}
		//功能编码
		if(!StringUtil.isEmpty(cfgDo.getFun_code()) && !cfgDo.getFun_code().equals(qryDTO.getFun_code())){
			return false;
		}
		//性别
		if(!StringUtil.isEmpty(cfgDo.getId_sex()) && !StringUtil.isEmpty(qryDTO.getId_sex()) && !cfgDo.getId_sex().equals(qryDTO.getId_sex())){
			return false;
		}
		if(!StringUtil.isEmpty(cfgDo.getSd_sex()) && !StringUtil.isEmpty(qryDTO.getSd_sex()) && !cfgDo.getId_sex().equals(qryDTO.getSd_sex())){
			return false;
		}
		//是否是新生儿
		int eunewborn = 0;
		if(qryDTO.getFg_newborn() != null){
			if(qryDTO.getFg_newborn().booleanValue()){
				eunewborn = 1;
			}else{
				eunewborn = 2;
			}
		}
		if(cfgDo.getEu_newborn() != null && !(cfgDo.getEu_newborn() == eunewborn)){
			return false;
		}
		
		//当前日期是否在设定日期之前
		if(qryDTO.getDt_birth() != null){
			FDate today = AppUtils.getServerDate();
			if(cfgDo.getAge_min() != null){
				Date minDate = addMonth(qryDTO.getDt_birth().toDate(),cfgDo.getAge_min());
				//minDate>today || minDate = today  不匹配
				if(minDate.compareTo(today.toDate()) > 0)return false;
			}
			if(cfgDo.getAge_max() != null){
				Date maxDate = addMonth(qryDTO.getDt_birth().toDate(),cfgDo.getAge_max());
				if(maxDate.compareTo(today.toDate()) < 0 || maxDate.compareTo(today.toDate()) == 0) return false;
			}
		}

		if(!StringUtil.isEmpty(cfgDo.getEu_rang_scca()) && !cfgDo.getEu_rang_scca().equals(qryDTO.getEu_rang_scca())){
			return false;
		}
		if(!StringUtil.isEmpty(cfgDo.getId_scca()) && !cfgDo.getId_scca().equals(qryDTO.getId_scca())){
			return false;
		}
		if(!StringUtil.isEmpty(cfgDo.getId_scsrv()) && !cfgDo.getId_scsrv().equals(qryDTO.getId_scsrv())){
			return false;
		}
		if(!StringUtil.isEmpty(cfgDo.getIds_bdsrv()) && !cfgDo.getIds_bdsrv().equals(qryDTO.getIds_bdsrv())){
			return false;
		}
		return true;
	}
	
	@SuppressWarnings("unchecked")
	private ScPrtTmplDTO findTmpl(String id_prttmpl) throws BizException{
		StringBuilder sbsql = new StringBuilder();
		SqlParam sqlParam = new SqlParam();
		sbsql.append("select t.id_prttmpl, t.code, t.name, t.path, t.id_scca, t.id_rpttp, t.sd_rpttp from SC_PRT_TMPL t where t.id_prttmpl = ?");
		sqlParam.addParam(id_prttmpl);
		List<ScPrtTmplDTO> list = (List<ScPrtTmplDTO>)new DAFacade().execQuery(sbsql.toString(), sqlParam, new BeanListHandler(ScPrtTmplDTO.class));
		if(ListUtil.isEmpty(list)) return null;
		return list.get(0);
	}
	
	private Date addMonth(Date date, int i){
		Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, i);
        return calendar.getTime();
	}
	
}
