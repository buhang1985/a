package iih.pi.reg.esoe.bp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.bd.bc.udi.pub.IPiDictCodeTypeConst;
import iih.pi.reg.esoe.d.PiEsoePatDTO;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PatiAddrDO;
import iih.pi.reg.pat.d.PatiAggDO;
import iih.pi.reg.pat.d.PiPatContDO;
import iih.pi.reg.pat.d.desc.PatDODesc;
import iih.pi.reg.pat.i.IPatiCudService;
import iih.pi.reg.s.bp.util.GetUdidocDOUtil;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.AdminAreaDO;
import xap.sys.bdfw.bbd.d.desc.AdminAreaDODesc;
import xap.sys.bdfw.bbd.i.IAdminareaRService;
import xap.sys.custcfg.billcode.i.IBillcodeManage;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.xbd.udi.d.UdidocDO;

/**
 * 应急系统同步患者信息
 * @author ly 2019/09/30
 *
 */
public class PiEsoeSyncDataBP {

	/**
	 * 应急系统同步患者信息
	 * @param patDtos
	 * @throws BizException
	 */
	public void exec(PiEsoePatDTO[] patDtos) throws BizException {
	
		this.validate(patDtos);
		
		List<PiEsoePatDTO> newList = new ArrayList<PiEsoePatDTO>();
		for (PiEsoePatDTO patDto : patDtos) {
			if(this.checkExist(patDto.getId_pat()))
				continue;
			newList.add(patDto);
		}
		
		for (PiEsoePatDTO patDto : newList) {
			this.insertPatData(patDto);
		}
	}
	
	/**
	 * 校验
	 * @param patDtos
	 * @throws BizException
	 */
	private void validate(PiEsoePatDTO[] patDtos) throws BizException {
		
		Set<String> keySet = new HashSet<String>();
		
		for (PiEsoePatDTO patDto : patDtos) {
			
			if(StringUtil.isEmpty(patDto.getId_pat())){
				throw new BizException("入参患者id为空");
			}
			
			if(keySet.contains(patDto.getId_pat())){
				throw new BizException("传入数据主键重复,id:" + patDto.getId_pat());
			}
			
			if(StringUtil.isEmpty(patDto.getName())){
				throw new BizException("入参患者姓名为空");
			}
			
			keySet.add(patDto.getId_pat());
		}
	}

	/**
	 * 查询
	 * @param patId
	 * @return
	 * @throws BizException
	 */
	private boolean checkExist(String patId) throws BizException {
		
		DAFacade daf = new DAFacade();
		String sql = "select count(1) from pi_pat where id_pat = ? ";
		SqlParam param = new SqlParam();
		param.addParam(patId);
		
		Integer cnt = (Integer)daf.execQuery(sql, param, new ColumnHandler());
		return cnt > 0;
	}
	
	/**
	 * 组装患者数据
	 * @param patDto
	 * @return
	 * @throws BizException
	 */
	private void insertPatData(PiEsoePatDTO patDto) throws BizException {
		
		PatiAggDO patAggDO = new PatiAggDO();
		
		PatDO patDO = new PatDO();
		patDO.setId_pat(patDto.getId_pat());
		patDO.setId_grp(Context.get().getGroupId());
		patDO.setId_org(Context.get().getOrgId());
		patDO.setName(patDto.getName());
		
		IBillcodeManage billcodeManage = ServiceFinder.find(IBillcodeManage.class);
		String code = billcodeManage.getPreBillCode_RequiresNew(PatDODesc.CLASS_FULLNAME);
		patDO.setCode(code);
		patDO.setMnecode(code);
		patDO.setPycode(patDto.getPycode());
		patDO.setWbcode(patDto.getWbcode());
		patDO.setBarcode_chis(patDto.getBarcode_chis());
		
		UdidocDO idtpDoc = GetUdidocDOUtil.getDoc(
				IPiDictCodeTypeConst.SD_IDTP, patDto.getSd_idtp());
		if(idtpDoc != null){
			patDO.setId_idtp(idtpDoc.getId_udidoc());
		}
		patDO.setSd_idtp(patDto.getSd_idtp());
		patDO.setId_code(patDto.getId_code());
		patDO.setId_paticate(patDto.getId_patca());
		patDO.setId_patpritp(patDto.getId_patpritp());
		patDO.setId_patcrettp(patDto.getId_patcrettp());
		UdidocDO sexDoc = GetUdidocDOUtil.getDoc(
				IPiDictCodeTypeConst.SD_SEX_CODE, patDto.getSd_sex());
		if(sexDoc != null){
			patDO.setId_sex(sexDoc.getId_udidoc());
		}
		patDO.setSd_sex(patDto.getSd_sex());
		if(!StringUtil.isEmpty(patDto.getDt_birth())){
			patDO.setDt_birth(new FDate(patDto.getDt_birth()));
		}
		patDO.setMob(patDto.getMob());
		
		UdidocDO nationDoc = GetUdidocDOUtil.getDoc(
				IPiDictCodeTypeConst.SD_NATION, patDto.getSd_nation());
		if(nationDoc != null){
			patDO.setId_nation(nationDoc.getId_udidoc());
		}
		patDO.setSd_nation(patDto.getSd_nation());
		
		UdidocDO marryDoc = GetUdidocDOUtil.getDoc(
				IPiDictCodeTypeConst.SD_MARRY, patDto.getSd_marry());
		if(marryDoc != null){
			patDO.setId_marry(marryDoc.getId_udidoc());
		}
		patDO.setSd_marry(patDto.getSd_marry());
		
		UdidocDO occuDoc = GetUdidocDOUtil.getDoc(
				IPiDictCodeTypeConst.SD_OCCU, patDto.getSd_marry());
		if(occuDoc != null){
			patDO.setId_occu(occuDoc.getId_udidoc());
		}
		patDO.setSd_occu(patDto.getSd_occu());
		
		UdidocDO educDoc = GetUdidocDOUtil.getDoc(
				IPiDictCodeTypeConst.SD_EDUC, patDto.getSd_occu());
		if(educDoc != null){
			patDO.setId_educ(patDto.getSd_educ());
		}
		patDO.setSd_educ(patDto.getSd_educ());
		patDO.setWorkunit(patDto.getWorkunit());
		patDO.setId_patsrctp(IPiDictCodeConst.ID_PATSRCTP_WINDOW);
		patDO.setSd_patsrctp(IPiDictCodeConst.SD_PATSRCTP_WINDOW);
		patDO.setCode_amr_oep(patDto.getCode_amr_oep());
		patDO.setCode_amr_ip(patDto.getCode_amr_ip());
		
		patDO.setId_emp_create(patDto.getId_emp_create());
		patDO.setDef1("应急系统同步");
		patDO.setStatus(DOStatus.NEW);
		patAggDO.setParentDO(patDO);
		
		if(!StringUtil.isEmpty(patDto.getSd_admdiv_cur()) || 
				!StringUtil.isEmpty(patDto.getStr_cur())){
		
			PatiAddrDO patAddrDO = new PatiAddrDO();
			patAddrDO.setSortno(1);
			patAddrDO.setId_pat(patDto.getId_pat());
			patAddrDO.setId_addrtp(IPiDictCodeConst.ID_ADDR_TYPE_NOW);
			patAddrDO.setSd_addrtp(IPiDictCodeConst.SD_ADDR_TYPE_NOW);
			if(!StringUtil.isEmpty(patDto.getSd_admdiv_cur())){
				AdminAreaDO areaDO = this.getAddress(patDto.getSd_admdiv_cur());
				if(areaDO != null){
					patAddrDO.setId_admdiv(areaDO.getId_adminarea());
					patAddrDO.setSd_admdiv(areaDO.getCode());
				}
			}
			patAddrDO.setStreet(patDto.getStr_cur());
			patAddrDO.setStatus(DOStatus.NEW);
			
			patAggDO.setPatiAddrDO(new PatiAddrDO[] { patAddrDO });
		}
		
		if(!StringUtil.isEmpty(patDto.getName_grd())){
			PiPatContDO contDO = new PiPatContDO();
			contDO.setSortno(1);
			contDO.setId_pat(patDto.getId_pat());
			contDO.setId_conttp(patDto.getId_rel_grd());
			contDO.setContaddr(patDto.getAddr_grd());
			contDO.setConttel(patDto.getPhone_grd());
			contDO.setContname(patDto.getName_grd());
			contDO.setStatus(DOStatus.NEW);
			
			patAggDO.setPiPatContDO(new PiPatContDO[] { contDO });
		}
		
		IPatiCudService patService = ServiceFinder.find(IPatiCudService.class);
		patService.insert(new PatiAggDO[] { patAggDO });
	}
	
	/**
	 * 取得区县对应的
	 * 
	 * @param regionCode
	 * @return
	 * @throws BizException
	 */
	private AdminAreaDO getAddress(String regionCode) throws BizException {

		IAdminareaRService areaService = ServiceFinder.find(IAdminareaRService.class);
		String whereSql = AdminAreaDODesc.TABLE_ALIAS_NAME + ".code = '" + regionCode + "'";
		AdminAreaDO[] areas = areaService.find(whereSql, "", FBoolean.FALSE);

		if (ArrayUtil.isEmpty(areas))
			return null;

		return areas[0];
	}
}
