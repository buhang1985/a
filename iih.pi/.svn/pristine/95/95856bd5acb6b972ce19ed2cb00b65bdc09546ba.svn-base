package iih.pi.reg.s.bp;

import java.util.ArrayList;
import java.util.List;

import iih.pi.reg.dto.adminarea.d.PiAdminAreaQryCondDTO;
import iih.pi.reg.dto.adminarea.d.PiAdminAreaQryRltDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 查询区县
 * @author ly 2019/05/18
 *
 */
public class PiFindAdminAreaBP {

	private static String[] firstSpecilLevel;//地址一级特殊常量
	private static String[] secondLevel;//地址二级常量
	private static String[] thirdLevel;//地址三级常量
	
	static{
		firstSpecilLevel = new String[]{"内蒙古","新疆","西藏","广西","宁夏"};
		secondLevel = new String[]{"市","盟"};
		thirdLevel = new String[]{"县","区"};
	}
	
	/**
	 * 查询区县
	 * @param cond 查询条件
	 * @return 区县DO
	 * @throws BizException
	 */
	public PiAdminAreaQryRltDTO exec(PiAdminAreaQryCondDTO cond) throws BizException{
		
		if(cond == null || (StringUtil.isEmpty(cond.getCode()) && 
				StringUtil.isEmpty(cond.getAddress()))){
			throw new BizException("查询区县:入参为空");
		}
		
		//截取行政地址
		String[] areas = this.cutArea(cond.getAddress());
		
		PiAdminAreaQryRltDTO rlt = this.simpleQry(cond);
		if(rlt == null){
			rlt = this.qryByArea(cond.getCode(), areas);
		}
		
		if(rlt == null){
			return null;
		}

		//设置截取地址
		String cutName = this.getCutName(areas, cond.getAddress());
		if(StringUtil.isEmpty(cutName)){
			rlt.setNamecut(rlt.getFullname());
		}else{
			rlt.setNamecut(cutName);
		}
		
		return rlt;
	}
	
	/**
	 * 截取末级行政地址
	 * --简单处理--
	 * @param address
	 * @return
	 * @throws BizException
	 */
	private String[] cutArea(String address) throws BizException{
		
		if(StringUtil.isEmpty(address))
			return null;
		
		String[] rlt = new String[3];
		
		//寻找第一个三级地址位置
		int index = 0;
		String splitChar =  "";
		for (int i = 0; i < address.length(); i++) {
			
			boolean hit = false;
			for (String str : thirdLevel) {
				if(str.equals(String.valueOf(address.charAt(i)))){
					hit = true;
					splitChar = str;
					break;
				}
			}
			
			if(hit){
				index = i;
				break;
			}
		}
		
		String[] values = null;
		String headvalue = null;
		if(!StringUtil.isEmpty(splitChar)){
			values = address.split(splitChar, index);
			headvalue = values[0] + splitChar;
		}else{
			headvalue = address;
		}
		 
		
		//寻找第二级地址位置
		index = 0;
		splitChar =  "";
		for (int i = 0; i < headvalue.length(); i++) {
			
			boolean hit = false;
			for (String str : secondLevel) {
				if(str.equals(String.valueOf(headvalue.charAt(i)))){
					hit = true;
					splitChar = str;
					break;
				}
			}
			
			if(hit){
				index = i;
				break;
			}
		}
		
		if(!StringUtil.isEmpty(splitChar)){
			values = headvalue.split(splitChar, index);
			headvalue = values[0] + splitChar;
			rlt[2] = values[1];
		}
		
		//寻找第一级地址位置
		//特殊处理
		String specilP = "";
		for (String str : firstSpecilLevel) {
			if(headvalue.contains(str)){
				specilP = str;
				break;
			}
		}
		
		if(!StringUtil.isEmpty(specilP)){
			rlt[0] = specilP;
			if(StringUtil.isEmpty(rlt[2])){
				rlt[2] = headvalue.replace(specilP, "");
			}else{
				rlt[1] = headvalue.replace(specilP, "");
			}
		}else{
			index = 0;
			splitChar =  "";
			for (int i = 0; i < headvalue.length(); i++) {
				if("省".equals(String.valueOf(headvalue.charAt(i)))){
					splitChar = "省";
					index = i;
					break;
				}
			}
			
			values = headvalue.split(splitChar, index);
			if(values.length > 1){
				
				if(StringUtil.isEmpty(rlt[2])){
					rlt[2] = values[1];
				}else{
					rlt[1] = values[1];
				}
				rlt[0] = values[0] + "省";
			}
		}
		
		return rlt;
	}
	
	
	/**
	 * 设置截取地址
	 * @param lastArea
	 * @param address
	 * @return
	 * @throws BizException
	 */
	private String getCutName(String[] areas,String address) throws BizException{
		
		String[] value = address.split(areas[2]);
		return value[0] + areas[2];
	}
	
	/**
	 * 按照编码查询
	 * @param cond
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private PiAdminAreaQryRltDTO simpleQry(PiAdminAreaQryCondDTO cond) throws BizException{
		
		StringBuilder sqlSb = new StringBuilder(this.getSql());
		SqlParam param = new SqlParam();
		
		if(!StringUtil.isEmpty(cond.getCode()) && !StringUtil.isEmpty(cond.getAddress())){
			sqlSb.append("and (code = ? or instr(?,fullname) = 1) ");
			param.addParam(cond.getCode());
			param.addParam(cond.getAddress());
		}else if(!StringUtil.isEmpty(cond.getCode())){
			sqlSb.append("and code = ? ");
			param.addParam(cond.getCode());
		}else if(!StringUtil.isEmpty(cond.getAddress())){
			sqlSb.append("and instr(?,fullname) = 1 ");
			param.addParam(cond.getAddress());
		}

		sqlSb.append("order by code desc ");
		DAFacade daf = new DAFacade();
		List<PiAdminAreaQryRltDTO> rltList = (List<PiAdminAreaQryRltDTO>)daf.execQuery(sqlSb.toString(), param, new BeanListHandler(PiAdminAreaQryRltDTO.class));
		
		if(!ListUtil.isEmpty(rltList)){
			return rltList.get(0);
		}
		
		return null;
	}

	/**
	 * 按照末级行政地址查询
	 * @param last-Area
	 * @return
	 * @throws BizException
	 */
	private PiAdminAreaQryRltDTO qryByArea(String code, String[] areas) throws BizException{
		
		if(ArrayUtil.isEmpty(areas))
			return null;
		
		StringBuilder sqlSb = new StringBuilder(this.getSql());
		SqlParam param = new SqlParam();
		
		sqlSb.append("and name = ? ");
		param.addParam(areas[2]);
		
		DAFacade daf = new DAFacade();
		@SuppressWarnings("unchecked")
		List<PiAdminAreaQryRltDTO> rltList = (List<PiAdminAreaQryRltDTO>)daf.execQuery(sqlSb.toString(), param, new BeanListHandler(PiAdminAreaQryRltDTO.class));
		
		if(ListUtil.isEmpty(rltList)){
			return null;
		}
		
		if(rltList.size() == 1)
			return rltList.get(0);
		
		//匹配省
		List<PiAdminAreaQryRltDTO> hintList = new ArrayList<PiAdminAreaQryRltDTO>();
		if(!StringUtil.isEmpty(code)){
			String provinceCode = code.substring(0,2);
			for (PiAdminAreaQryRltDTO rlt : rltList) {
				if(rlt.getCode().indexOf(provinceCode) == 0){
					hintList.add(rlt);
				}
			}
		}else{
			for (PiAdminAreaQryRltDTO rlt : rltList) {
				if(rlt.getFullname().indexOf(areas[0]) == 0){
					hintList.add(rlt);
				}
			}
		}
		
		if(hintList.size() == 1)
			return hintList.get(0);
		
		if(hintList.size() == 0){
			hintList.addAll(rltList);
		}
		
		//匹配市
		PiAdminAreaQryRltDTO cityRlt = null;
		for (PiAdminAreaQryRltDTO rlt : hintList) {
			if(rlt.getFullname().contains(areas[1])){
				cityRlt = rlt;
				break;
			}
		}
		
		if(cityRlt == null){
			return hintList.get(0);
		}
		
		return cityRlt;
	}
	
	/**
	 * 主查询sql
	 * @return
	 */
	private String getSql(){
		return "select id_adminarea,code,name,fullname,zipcode from bd_adminarea where activestate = 2 ";
	}
}
