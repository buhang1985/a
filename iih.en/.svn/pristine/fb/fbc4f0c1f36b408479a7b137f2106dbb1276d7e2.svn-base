package iih.en.pv.s.out.bp;

import iih.bd.bc.udi.pub.IPiDictCodeTypeConst;
import iih.bd.res.params.BdResParams;
import iih.en.comm.ep.PatEP;
import iih.en.comm.util.EnLogUtil;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.inpatient.dto.d.EnHosPatDTO;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PiPatContDO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.AdminAreaDO;
import xap.sys.bdfw.bbd.d.CountryZoneDO;
import xap.sys.bdfw.bbd.i.IAdminareaRService;
import xap.sys.bdfw.bbd.i.ICountryzoneRService;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.PersistMgr;
import xap.sys.jdbc.kernel.PersistSession;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.xbd.udi.d.UdidocDO;

/**
 * 入院登记查询chis住院号和住院次数
 * 
 * @author liubin
 *
 */
public class GetTimesIpFromChisBP {

	/**
	 * 
	 * 
	 * @param enHosPatDTO
	 * @param pat
	 * @param isRegInHos
	 * @return 
	 * @throws BizException
	 */
	public void exec(EnHosPatDTO enHosPatDTO, PatDO pat, FBoolean isRegInHos) throws BizException {
		if (pat == null) 
			throw new BizException("查询CHIS入院次数失败,原因:IIH中未查询到患者信息！");
		String dataSource = new BdResParams().CHISDB();
		if (EnValidator.isEmpty(dataSource)) {
			throw new BizException("CHIS数据源未定义，请定义数据源或关闭chis功能");
		}
		PersistMgr persistence = null;
		
		try {
			persistence = (PersistMgr) PersistMgr.getInstance(dataSource);
			PersistSession session = persistence.getPersistSession();

			Connection conn = session.getConnection();
			CallableStatement ps = null;
			try {
				ps = conn.prepareCall(getProcName());
				this.setParam(ps, pat);
				boolean hasResult =  ps.execute();
				ResultSet rs = null;
				while(true){
					if(hasResult){
						rs = ps.getResultSet();
						break;
					}else{
						int updateCount = ps.getUpdateCount();
						if(updateCount == -1)
							break;
					}
					hasResult = ps.getMoreResults();
				}
				//chis更新患者返回值日志
				this.logChisUpdateRlt(ps, rs);
				//处理返回值
				this.dealCallBack(ps, rs, enHosPatDTO, isRegInHos);
			} finally {
				try {
					if (ps != null){
						ps.close();
					}
				} catch (SQLException e) {
					EnLogUtil.getInstance().logInfo(e.getMessage());
				} finally {
					if (conn != null){
						conn.close();
					}
				}
			}
		} catch (Exception e) {
			EnLogUtil.getInstance().logError("查询CHIS入院次数失败,原因："+e.getMessage(), e);
			throw new BizException("查询CHIS入院次数失败,原因:" + e.getMessage(), e, 4410);
		} finally {
			if (persistence != null) {
				try {
					persistence.release();
				} catch (Exception e) {
				}
			}
		}
		
	}
	
	/**
	 * 获取存储过程调用名
	 * @return
	 */
	private String getProcName() {
		return "{call IIH_to_zy_his(?,?,?,?,?)}";
	}
	
	
	/**
	 * 设置参数
	 * @param ps
	 * @param aptIpDTO
	 * @throws SQLException 
	 * @throws BizException 
	 */
	private void setParam(CallableStatement ps, PatDO patDo) throws SQLException, BizException{
		ps.setString(1, patDo.getBarcode_chis()); //患者条码号
		ps.setString(2, patDo.getIdtp_code()); //证件类型
		ps.setString(3, patDo.getId_code()); //证件号
		ps.setString(4, patDo.getName()); //姓名
		ps.registerOutParameter(5, java.sql.Types.VARCHAR);//患者在院时抛出提示
	}

	/**
	 * chis更新患者返回值日志
	 * @param rs
	 * @throws SQLException
	 */
	private void logChisUpdateRlt(CallableStatement ps, ResultSet rs){
		try {
			if (rs != null) {
				ResultSetMetaData md = rs.getMetaData();//获取键名
				String log = "执行查询CHIS入院次数存储过程  proc IIH_to_zy_his 返回值: ";
				while (rs.next()) {
					for (int i = 1; i <= md.getColumnCount(); i++) {
						log += String.format("-[%s = %s]", md.getColumnName(i), rs.getObject(md.getColumnName(i)));
					}
					break;
				}
				EnLogUtil.getInstance().logInfo(log);
			} else {
				String log = String.format("执行查询CHIS入院次数存储过程  proc IIH_to_zy_his 返回值: %s ", ps.getString(5));
				EnLogUtil.getInstance().logError("查询CHIS入院次数失败!原因：" + log);
			}
		} catch (Exception e) {
			e.printStackTrace();
			EnLogUtil.getInstance().logError(e.getMessage(), e);
		}
	}

	/**
	 * 处理返回值
	 * @param ps
	 * @throws SQLException 
	 */
	private void dealCallBack(CallableStatement ps, ResultSet rs, EnHosPatDTO enHosPatDTO, FBoolean isRegInHos) throws BizException, SQLException{
		if(rs == null)
			throw new BizException(ps.getString(5));
		String code_amr_ip = getTrimString(rs.getString("inpatient_no"));
		String times_ip = getTrimString(rs.getString("lastadmiss_times"));
		if (EnValidator.isEmpty(code_amr_ip)) 
			throw new BizException("CHIS返回的住院号为空！");
		if (EnValidator.isEmpty(times_ip)) 
			throw new BizException("CHIS返回的住院次数为空！");
		enHosPatDTO.setCode_amr_ip(code_amr_ip);
		enHosPatDTO.setTimes_ip(Integer.parseInt(times_ip));
		if(FBoolean.TRUE.equals(isRegInHos))
			return;//已经在本系统住过院，不需要再同步其他患者信息
		//同步婚姻状况
		syncMarray(rs, enHosPatDTO);
		//同步国籍
		syncCountry(rs, enHosPatDTO);
		//同步民族
		syncNation(rs, enHosPatDTO);
		//同步职业
		syncOccupation(rs, enHosPatDTO);
		//同步地址
		syncAddr(rs, enHosPatDTO);
		//同步联系人
		syncPatCont(rs, enHosPatDTO);
	}
	/**
	 * 同步婚姻状况
	 * 
	 * @param rs
	 * @param enHosPatDTO
	 * @throws SQLException 
	 * @throws BizException 
	 */
	private void syncMarray(ResultSet rs, EnHosPatDTO enHosPatDTO) throws SQLException, BizException{
		String marry_code = getTrimString(rs.getString("marry_code"));//婚姻状况
		//婚姻状况同步
		if(EnValidator.isEmpty(enHosPatDTO.getId_marry())
				&& !EnValidator.isEmpty(marry_code)){
			UdidocDO marry = getUdidoc(IPiDictCodeTypeConst.SD_MARRY, marry_code);
			if(marry != null){
				enHosPatDTO.setId_marry(marry.getId_udidoc());
				enHosPatDTO.setSd_marry(marry.getCode());
				enHosPatDTO.setName_marry(marry.getName());
			}
		}
	}
	/**
	 * 同步国籍
	 * 
	 * @param rs
	 * @param enHosPatDTO
	 * @throws SQLException
	 * @throws BizException
	 */
	private void syncCountry(ResultSet rs, EnHosPatDTO enHosPatDTO) throws SQLException, BizException{
		String country = getTrimString(rs.getString("country"));//国籍
		if(EnValidator.isEmpty(enHosPatDTO.getId_country())
				&& !EnValidator.isEmpty(country)){
			CountryZoneDO countryDo = getCountry(country);
			if(countryDo != null){
				enHosPatDTO.setId_country(countryDo.getId_countryzone());//国籍
				enHosPatDTO.setName_country(countryDo.getName());
			}
		}
	}
	/**
	 * 同步民族
	 * 
	 * @param rs
	 * @param enHosPatDTO
	 * @throws SQLException
	 * @throws BizException
	 */
	private void syncNation(ResultSet rs, EnHosPatDTO enHosPatDTO) throws SQLException, BizException{
		String nation_code = getTrimString(rs.getString("nation_code"));//民族
		if(EnValidator.isEmpty(enHosPatDTO.getId_nation())
				&& !EnValidator.isEmpty(nation_code)){
			UdidocDO nation = getUdidoc(IPiDictCodeTypeConst.SD_NATION, nation_code);
			if(nation != null){
				enHosPatDTO.setId_nation(nation.getId_udidoc()); 
		        enHosPatDTO.setName_nation(nation.getName());
			}
		}
	}
	/**
	 * 同步职业
	 * 
	 * @param rs
	 * @param enHosPatDTO
	 * @throws SQLException
	 * @throws BizException
	 */
	private void syncOccupation(ResultSet rs, EnHosPatDTO enHosPatDTO) throws SQLException, BizException{
		String occupation_code = getTrimString(rs.getString("occupation_code"));//职业
		if(EnValidator.isEmpty(enHosPatDTO.getId_job())
				&& !EnValidator.isEmpty(occupation_code)){
			UdidocDO occupation = getUdidoc(IPiDictCodeTypeConst.SD_OCCU, occupation_code);
			if(occupation != null){
				enHosPatDTO.setId_job(occupation.getId_udidoc()); 
		        enHosPatDTO.setName_job(occupation.getName());
			}
		}
	}
	/**
	 * 同步地址
	 * 
	 * @param rs
	 * @param enHosPatDTO
	 * @throws SQLException
	 * @throws BizException
	 */
	private void syncAddr(ResultSet rs, EnHosPatDTO enHosPatDTO) throws SQLException, BizException{
		String native_code = getTrimString(rs.getString("native"));//籍贯
		String birth_place = getTrimString(rs.getString("birth_place"));//出生地
		
		String temp_district = getTrimString(rs.getString("temp_district"));//现住址
		String temp_street = getTrimString(rs.getString("temp_street"));//现住址街道
		String temp_tel = getTrimString(rs.getString("temp_tel"));//现住址电话
		String temp_zipcode = getTrimString(rs.getString("temp_zipcode"));//现住址邮编
		
		String employer_name = getTrimString(rs.getString("employer_name"));//工作单位名称
		String employer_district = getTrimString(rs.getString("employer_district"));//工作单位地址
		String employer_street = getTrimString(rs.getString("employer_street"));//工作单位街道
		String employer_tel = getTrimString(rs.getString("employer_tel"));//单位电话
		String employer_zipcode = getTrimString(rs.getString("employer_zipcode"));//单位邮编
		
		String home_district = getTrimString(rs.getString("home_district"));//户口地址
		String home_street = getTrimString(rs.getString("home_street"));//街道地址
		String home_zipcode = getTrimString(rs.getString("home_zipcode"));//邮编
		
		Set<String> areaCodes = new HashSet<>();
		if(!EnValidator.isEmpty(native_code))
			areaCodes.add(native_code);
		if(!EnValidator.isEmpty(birth_place))
			areaCodes.add(birth_place);
		if(!EnValidator.isEmpty(temp_district))
			areaCodes.add(temp_district);
		if(!EnValidator.isEmpty(employer_district))
			areaCodes.add(employer_district);
		if(!EnValidator.isEmpty(home_district))
			areaCodes.add(home_district);
		Map<String, AdminAreaDO> areaMap = getAreaMap(areaCodes.toArray(new String[0]));
		if(EnValidator.isEmpty(enHosPatDTO.getId_nativeaddr())
				&& !EnValidator.isEmpty(native_code)){
			//籍贯
			if(areaMap.containsKey(native_code)){
				AdminAreaDO nativeArea = areaMap.get(native_code);
            	enHosPatDTO.setId_nativeaddr(nativeArea.getId_adminarea());
            	enHosPatDTO.setName_nativeaddr(nativeArea.getFullname());
            	enHosPatDTO.setSd_nativeaddr(nativeArea.getCode());
			}
		}
		if(EnValidator.isEmpty(enHosPatDTO.getId_birth_addr())
				&& !EnValidator.isEmpty(birth_place)){
			//出生地
			if(areaMap.containsKey(birth_place)){
				AdminAreaDO birthArea = areaMap.get(birth_place);
            	enHosPatDTO.setId_birth_addr(birthArea.getId_adminarea());
            	enHosPatDTO.setName_birth_addr(birthArea.getFullname());
            	enHosPatDTO.setSd_birth_addr(birthArea.getCode());
			}
		}
		if(EnValidator.isEmpty(enHosPatDTO.getId_admdiv())
				&& !EnValidator.isEmpty(temp_district)){
			//现住址
			if(areaMap.containsKey(temp_district)){
				AdminAreaDO tempArea = areaMap.get(temp_district);
            	enHosPatDTO.setId_admdiv(tempArea.getId_adminarea());
            	enHosPatDTO.setName_admdiv(tempArea.getFullname());
            	enHosPatDTO.setSd_admdiv(tempArea.getCode());
			}
		}
		if(EnValidator.isEmpty(enHosPatDTO.getAddr_pat())
				&& !EnValidator.isEmpty(temp_street))
			enHosPatDTO.setAddr_pat(temp_street);
		if(EnValidator.isEmpty(enHosPatDTO.getPostcode_addr())
				&& !EnValidator.isEmpty(temp_zipcode))
			enHosPatDTO.setPostcode_addr(temp_zipcode);
		if(EnValidator.isEmpty(enHosPatDTO.getTel_admdiv())
				&& !EnValidator.isEmpty(temp_tel))
			enHosPatDTO.setTel_admdiv(temp_tel);
		
		if(EnValidator.isEmpty(enHosPatDTO.getId_admdiv_work())
				&& !EnValidator.isEmpty(employer_district)){
			//工作单位地址
			if(areaMap.containsKey(employer_district)){
				AdminAreaDO employerArea = areaMap.get(employer_district);
            	enHosPatDTO.setId_admdiv_work(employerArea.getId_adminarea());
            	enHosPatDTO.setName_admdiv_work(employerArea.getFullname());
            	enHosPatDTO.setSd_admdiv_work(employerArea.getCode());
			}
		}
		if(EnValidator.isEmpty(enHosPatDTO.getDetail_addr_work())
				&& !EnValidator.isEmpty(employer_street))
			enHosPatDTO.setDetail_addr_work(employer_street);
		if(EnValidator.isEmpty(enHosPatDTO.getPostcode_work())
				&& !EnValidator.isEmpty(employer_zipcode))
			enHosPatDTO.setPostcode_work(employer_zipcode);
		if(EnValidator.isEmpty(enHosPatDTO.getTel_work())
				&& !EnValidator.isEmpty(employer_tel))
			enHosPatDTO.setTel_work(employer_tel);
		if(EnValidator.isEmpty(enHosPatDTO.getWorkplace())
				&& !EnValidator.isEmpty(employer_name))
			enHosPatDTO.setWorkplace(employer_name);//工作单位
		
		if(EnValidator.isEmpty(enHosPatDTO.getId_admdiv_resi())
				&& !EnValidator.isEmpty(home_district)){
			//户口地址
			if(areaMap.containsKey(home_district)){
				AdminAreaDO homeArea = areaMap.get(home_district);
            	enHosPatDTO.setId_admdiv_resi(homeArea.getId_adminarea());
            	enHosPatDTO.setName_admdiv_resi(homeArea.getFullname());
            	enHosPatDTO.setSd_admdiv_resi(homeArea.getCode());
			}
		}
		if(EnValidator.isEmpty(enHosPatDTO.getDetail_addr_resi())
				&& !EnValidator.isEmpty(home_street))
			enHosPatDTO.setDetail_addr_resi(home_street);
		if(EnValidator.isEmpty(enHosPatDTO.getPostcode_resi())
				&& !EnValidator.isEmpty(home_zipcode))
			enHosPatDTO.setPostcode_resi(home_zipcode);
	}
	
	/**
	 * 同步患者联系人
	 * 
	 * @param rs
	 * @param enHosPatDTO
	 * @throws SQLException
	 * @throws BizException
	 */
	private void syncPatCont(ResultSet rs, EnHosPatDTO enHosPatDTO) throws SQLException, BizException{
		String relation_name = getTrimString(rs.getString("relation_name"));//联系人
		String relation_code = getTrimString(rs.getString("relation_code"));//联系人类型
		String relation_tel = getTrimString(rs.getString("relation_tel"));//联系人电话
		String relation_street = getTrimString(rs.getString("relation_street"));//联系人地址
		if(!EnValidator.isEmpty(enHosPatDTO.getId_patcont()))
			return;
		//获取联系人类型
		UdidocDO patContTp = getUdidoc(IPiDictCodeTypeConst.SD_CONTTP, relation_code);
		PiPatContDO piPatContDO = null;
		//获取所有患者联系人
		PiPatContDO[] piPatContDOs = new PatEP().getContDO(enHosPatDTO.getId_pat());
		if(patContTp != null && !EnValidator.isEmpty(piPatContDOs)){
			for(PiPatContDO piPatCont : piPatContDOs){
				if(patContTp.getCode().equals(piPatCont.getSd_conttp())){
					piPatContDO = piPatCont;
					break;
				}
			}
		}
		if(piPatContDO != null){
			enHosPatDTO.setId_patcont(piPatContDO.getId_patcont());
			enHosPatDTO.setName_patcont(piPatContDO.getName());
			enHosPatDTO.setName_patcontref(piPatContDO.getName());
			enHosPatDTO.setId_conttp(piPatContDO.getId_conttp());
            enHosPatDTO.setName_conttp(piPatContDO.getConttp_name());
            enHosPatDTO.setConttel(EnValidator.isEmpty(piPatContDO.getConttel()) ? relation_tel : piPatContDO.getConttel());
            enHosPatDTO.setContaddr(EnValidator.isEmpty(piPatContDO.getContaddr()) ? relation_street : piPatContDO.getContaddr());
		}else{
			enHosPatDTO.setName_patcont(relation_name);
			enHosPatDTO.setName_patcontref(relation_name);
			enHosPatDTO.setId_conttp(patContTp == null ? null : patContTp.getId_udidoc());
            enHosPatDTO.setName_conttp(patContTp == null ? null : patContTp.getName());
            enHosPatDTO.setConttel(relation_tel);
            enHosPatDTO.setContaddr(relation_street);
		}
	}
	
	/**
	 * 获取自定义档案
	 * 
	 * @param udiTypeCode 自定义档案类型编码
	 * @param code 编码
	 * @return
	 * @throws BizException
	 */
	private UdidocDO getUdidoc(String udiTypeCode, String code) throws BizException{
		if(EnValidator.isEmpty(code))
			return null;
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append(" SELECT UDI.* FROM BD_UDIDOC UDI ");
		sqlBuilder.append(" INNER JOIN BD_UDIDOCLIST UDILIDT ON UDI.ID_UDIDOCLIST = UDILIDT.ID_UDIDOCLIST ");
		sqlBuilder.append(" WHERE UDILIDT.CODE = ? ");
		sqlBuilder.append(" AND (UDI.CODE = ? OR UDI.CODE_IE = ?) ");
		String sql = sqlBuilder.toString();
		SqlParam param = new SqlParam(); 
		param.addParam(udiTypeCode);
		param.addParam(code);
		param.addParam(code);
		@SuppressWarnings("unchecked")
		List<UdidocDO> list = (List<UdidocDO>) new DAFacade().execQuery(sql, param, new BeanListHandler(UdidocDO.class));
		return EnValidator.isEmpty(list) ? null : list.get(0);
	} 
	/**
	 * 获取国籍信息
	 * 
	 * @param code
	 * @return
	 * @throws BizException
	 */
	private CountryZoneDO getCountry(String code) throws BizException{
		ICountryzoneRService serv = ServiceFinder.find(ICountryzoneRService.class);
		CountryZoneDO[] countries = serv.findByAttrValString(CountryZoneDO.CODE, code);
		return EnValidator.isEmpty(countries) ? null : countries[0];
	}
	/**
	 * 获取地区字典
	 * 
	 * @param codes
	 * @return
	 * @throws BizException
	 */
	private Map<String, AdminAreaDO> getAreaMap(String[] codes) throws BizException{
		Map<String, AdminAreaDO> map = new HashMap<>();
		if(!EnValidator.isEmpty(codes)){
			IAdminareaRService serv = ServiceFinder.find(IAdminareaRService.class);
			AdminAreaDO[] areas = serv.findByAttrValStrings(AdminAreaDO.CODE, codes);
			if(!EnValidator.isEmpty(areas)){
				for(AdminAreaDO area : areas){
					map.put(area.getCode(), area);
				}
			}
		}
		return map;
	}
	/**
	 * 去除str两边空格
	 * 
	 * @param str
	 * @return
	 */
	private String getTrimString(String str){
		return str == null ? null : str.trim();
	}
}
