package iih.ei.std.s.v1.bp.mp.pathgydata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.base.utils.ArrayListUtil;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBlDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.i.ICiorderMDORService;
import iih.ei.std.d.v1.mp.pathgydata.d.PathgyApplyInfo;
import iih.ei.std.d.v1.mp.pathgydata.d.PathgyApplyInfoResultDTO;
import iih.ei.std.d.v1.mp.pathgydata.d.PathgyApplyParamDTO;
import iih.ei.std.s.v1.bp.common.EiParamUtils;
import iih.ei.std.s.v1.bp.mp.pathgydata.qry.GetPathgySampInfoSql;
import iih.ei.std.s.v1.bp.mp.pathgydata.qry.QueryIPPathgySql;
import iih.ei.std.s.v1.bp.mp.pathgydata.qry.QueryOPPathgySql;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PiPatCardDO;
import iih.pi.reg.pat.d.PiPatHpDO;
import iih.pi.reg.pat.i.IPatiMDORService;
import iih.pi.reg.pat.i.IPiPatCardDORService;
import iih.pi.reg.pat.i.IPiPatHpDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FDate;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.MapListHandler;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;
/**
 * 
* @ClassName: QueryPathgyDataBp
* @Description: 查询病理申请单信息
* @author zhy
* @date 2019年9月27日
*
 */
public class QueryPathgyDataBp {
	
	/**
	 * 程序主入口
	 * @param param
	 * @return
	 * @throws BizException 
	 */
	public PathgyApplyInfoResultDTO exec(PathgyApplyParamDTO param) throws BizException {
		
		// 1.获取就诊类型
		String code_entp = param.getCode_entp();
		
		// 2.查询信息
		PathgyApplyInfo[] applyInfos = queryData(code_entp,param);
		
		//年龄赋值
		calAge(applyInfos);
		
		// 3.封装信息
		PathgyApplyInfoResultDTO resultDTO = new PathgyApplyInfoResultDTO();
		resultDTO.setPathgyapplyinfo(ArrayListUtil.ConvertToFArrayList(applyInfos));
		return resultDTO;
	}
	
	/**
	 * 设置年龄
	 * @param applyInfos
	 * @return
	 */
	private void calAge(PathgyApplyInfo[] applyInfos) {
		if(applyInfos == null || applyInfos.length<1){
			return;
		}
		for (PathgyApplyInfo pathgyApplyInfo : applyInfos) {
			pathgyApplyInfo.setAge(AgeCalcUtil.getAge(new FDate(pathgyApplyInfo.getAge())));
		}
	}

	/**
	 * 查询信息
	 * @param code_entp
	 * @param param
	 * @return
	 * @throws BizException 
	 */
	private PathgyApplyInfo[] queryData(String code_entp, PathgyApplyParamDTO param) throws BizException {
		//住院
    	if (IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(code_entp)) {	
    		String patId = getPatID(param.getCode(),param.getNo_applyform());
    		if (StringUtil.isEmptyWithTrim(patId)) {
				throw new BizException("获取病理申请单信息,无患者信息");
			}
    		QueryIPPathgySql sql = new QueryIPPathgySql(param, patId);
    		PathgyApplyInfo[] applyInfos = (PathgyApplyInfo[]) AppFwUtil.getDORstWithDao(sql, PathgyApplyInfo.class);
    		if(applyInfos == null || applyInfos.length<1){
    			return null;
    		}
    		List<String> no_applyforms = new ArrayList<>();
    		for (PathgyApplyInfo applyInfo : applyInfos) {
    			no_applyforms.add(applyInfo.getNo_applyform());
			}
    		
    		//查询相关病理申请子表（病理标本）数据
    		List<Map<String, Object>> list = queryApplySampDTOs(no_applyforms);
    		Map<String, List<Map<String, Object>>> bbmc = new HashMap<>();
    		for (Map<String, Object> maps : list) {
    			if(bbmc.get(maps.get("no_applyform")) == null){
        			List<Map<String, Object>> bbmcList = new ArrayList<>();
        			bbmcList.add(maps);
        			bbmc.put((String) maps.get("no_applyform"), bbmcList);
        		}else{
        			bbmc.get(maps.get("no_applyform")).add(maps);
        		}
			}
    		
    		for (PathgyApplyInfo apply : applyInfos) {
    			String name_lab = "";
        		List<Map<String, Object>> maps = bbmc.get(apply.getNo_applyform());
        		for (Map<String, Object> map : maps) {
        			name_lab += map.get("bbmc") == null ? "" : map.get("bbmc") + ";";					
        			apply.setName_lab(name_lab);
				}
			}
    		return applyInfos;
    	}
    	
    	//门诊
    	if (IBdFcDictCodeConst.SD_CODE_ENTP_OP.equals(code_entp)) {
    		PathgyApplyInfo[] applyInfos = queryOPData(param);
    		return applyInfos;
    	}
    	
    	return null;
	}
	



	/**
	 * 获取患者id
	 * @param code_user
	 * @param no_applyform
	 * @return
	 * @throws BizException 
	 */
	private String getPatID(String code, String no_applyform) throws BizException {
		
		if(!StringUtil.isEmptyWithTrim(no_applyform)){
			CiOrderDO[] ords = ServiceFinder.find(ICiorderMDORService.class).findByAttrValString(CiOrderDO.APPLYNO, no_applyform);
			if (ords != null && ords.length > 0) {
				return ords[0].getId_pat();
			}
		}
		
		if (!StringUtil.isEmptyWithTrim(code)) {
			// 按使用频次查询
			// 1.申请单号
			CiOrderDO[] ords = ServiceFinder.find(ICiorderMDORService.class).findByAttrValString(CiOrderDO.APPLYNO, code);
			if (ords != null && ords.length > 0) {
				return ords[0].getId_pat();
			}
			
			// 2.卡号
			PiPatCardDO[] patcardDOs = ServiceFinder.find(IPiPatCardDORService.class).findByAttrValString(PiPatCardDO.CODE, code);
			if (patcardDOs != null && patcardDOs.length > 0) {
				return patcardDOs[0].getId_pat();
			}
			// 3.医保卡号
			PiPatHpDO[] hpDOs = ServiceFinder.find(IPiPatHpDORService.class).findByAttrValString(PiPatHpDO.NO_HP, code);
			if (hpDOs != null && hpDOs.length > 0) {
				return hpDOs[0].getId_pat();
			}
			
			
			// 4.身份证号
			PatDO[] patDOS = ServiceFinder.find(IPatiMDORService.class).findByAttrValString(PatDO.ID_CODE, code);
			if (patDOS != null && patDOS.length > 0) {
				return patDOS[0].getId_pat();
			}
			
			// 5.患者编码
			PatDO[] patDObycode = ServiceFinder.find(IPatiMDORService.class).findByAttrValString(PatDO.CODE, code);
			if (patDObycode != null && patDObycode.length > 0) {
				return patDObycode[0].getId_pat();
			}
			
			// 6.身份证号
			PatDO[] patDObyBar = ServiceFinder.find(IPatiMDORService.class).findByAttrValString(PatDO.BARCODE_CHIS, code);
			if (patDObyBar != null && patDObyBar.length > 0) {
				return patDObyBar[0].getId_pat();
			}
		}

		return null;
	}

	/**
	 * 查询相关病理申请子表（病理标本）数据
	 * @param no_applyforms
	 * @return
	 * @throws DAException 
	 */
	private List<Map<String, Object>> queryApplySampDTOs(List<String> no_applyforms) throws DAException {
		GetPathgySampInfoSql sql = new GetPathgySampInfoSql(no_applyforms);
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> applySamp = (List<Map<String, Object>>) new DAFacade().execQuery(sql.getQrySQLStr(), sql.getQryParameter(null), new MapListHandler());
		return applySamp;
	}
	
	
	/**
	 * 查询门诊病理数据
	 * @param param
	 * @return
	 * @throws BizException 
	 */
	private PathgyApplyInfo[] queryOPData(PathgyApplyParamDTO param) throws BizException {
		
		// 获取患者id
		String patID = getPatID(param.getCode(), param.getNo_applyform());
		if (StringUtil.isEmptyWithTrim(patID)) {
			throw new BizException("没有找到对应患者信息!");
		}
		
		QueryOPPathgySql sql = new QueryOPPathgySql(param, patID);
		List<String> no_applyform = new ArrayList<String>();
		PathgyApplyInfo[] applyInfos = (PathgyApplyInfo[]) AppFwUtil.getDORstWithDao(sql, PathgyApplyInfo.class);
		for (PathgyApplyInfo applyInfo : applyInfos) {
			no_applyform.add(applyInfo.getNo_applyform());
		}
		List<Map<String, Object>> list = queryApplySampDTOs(no_applyform);
		Map<String, List<Map<String, Object>>> bbmc = new HashMap<>();
		for(Map<String, Object> maps : list){
			if (bbmc.get(maps.get("no_applyform")) == null) {
				List<Map<String, Object>> bbmcList = new ArrayList<>();
				bbmcList.add(maps);
				bbmc.put((String) maps.get("no_applyform"), bbmcList);	
			}else{
			    bbmc.get(maps.get("no_applyform")).add(maps);
			}
		}
		for(PathgyApplyInfo rtnDto : applyInfos){
			String name_lab = "";
			List<Map<String, Object>> map = bbmc.get(rtnDto.getNo_applyform());
			for(Map<String, Object> data : map){
				name_lab += data.get("bbmc") ==null ? "" : data.get("bbmc") + ";";
				rtnDto.setName_lab(name_lab);
			}
		}
		
		// 预交金收费流程模式是执行计费不过滤计费状态
		if (IBlDictCodeConst.PARAM_VALUE_EXECACCOUNT.equals(EiParamUtils.BLCG0002())) {
			return applyInfos;
		}
		
		// 过滤返回结果
		PathgyApplyInfo[] rtnDtos = filterRst(applyInfos);
		if (null == rtnDtos || rtnDtos.length < 1) {
			return null;
		}
		return rtnDtos;
	}

	/**
	 * 过滤返回结果
	 * @param applyInfos
	 * @return
	 */
	private PathgyApplyInfo[] filterRst(PathgyApplyInfo[] applyInfos) {
		List<PathgyApplyInfo> reList = new ArrayList<PathgyApplyInfo>();
		if (applyInfos != null && applyInfos.length > 0) {
			for (PathgyApplyInfo rtn : applyInfos) {
				if (rtn.getNum_bl() == 0) {
					// 无需计费的医嘱
					reList.add(rtn);
				} else {
					// 需要计费的医嘱
					if (ICiDictCodeConst.SD_SU_BL_ACCOUNT.equals(rtn.getSd_su_bl())) {
						reList.add(rtn);
					}
				}
			}
		}
		return reList.toArray(new PathgyApplyInfo[reList.size()]);
	}
}







