package iih.mi.itf2.service.bp.bdservice.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import iih.bd.pp.hp.d.HPDO;
import iih.bd.pp.hp.i.IHpMDORService;
import iih.mi.itf2.dto.dicompdto.d.DiCompDTO;
import iih.mi.itf2.dto.drugmanualcomp.d.DrugManualCompDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

public class ToolUtils {

	/**
	 * 查询方案生成条件语句
	 * 
	 * @param qryRootNodeDto
	 * @return
	 * @throws BizException
	 */
	public static String GetWherePart(QryRootNodeDTO qryRootNodeDto) throws BizException {
		StringBuilder wherePartBuilder = new StringBuilder("1 = 1");

		IQrySQLGeneratorService qrySQLGeneratorService = ServiceFinder.find(IQrySQLGeneratorService.class);
		String wherePart = qrySQLGeneratorService.getQueryStringWithoutDesc(qryRootNodeDto);
		if (!StringUtils.isEmpty(wherePart)) {
			wherePartBuilder.append(" AND ");
			wherePartBuilder.append(wherePart);
		}

		return wherePartBuilder.toString();
	}
	
	/**
	 * 获取医保计划主键
	 * 
	 * @param hpCode
	 * @return
	 * @throws BizException
	 */
	public static String GetHpId(String hpCode) throws BizException {
		if (StringUtils.isEmpty(hpCode)) {
			throw new BizException("医保计划编码为空。");
		}

		IHpMDORService hpMDORService = ServiceFinder.find(IHpMDORService.class);
		HPDO[] result = hpMDORService.findByAttrValString(HPDO.CODE, hpCode);
		if (result == null || result.length < 1) {
			String msg = String.format("获取医保计划失败，医保计划编码\"%s\"。", hpCode);
			throw new BizException(msg);
		}
		if (result.length > 1) {
			String msg = String.format("获取到多个医保计划，医保计划编码\"%s\"。", hpCode);
			throw new BizException(msg);
		}
		return result[0].getId_hp();
	}
	
	/**
	 * 药品DTO赋值
	 * @author zhang.hw
	 * @date 2019年5月24日
	 * @param source
	 * @param target
	 */
	public static DrugManualCompDTO copy(DrugManualCompDTO source,DrugManualCompDTO target){
		target.setId_hp(source.getId_hp());
		target.setId_srv(source.getId_srv());
		target.setSrv_code(source.getSrv_code());
		target.setSrv_name(source.getSrv_name());
		target.setSrv_unit(source.getSrv_unit());
		target.setSrv_route(source.getSrv_route());
		target.setSrv_freq(source.getSrv_freq());
		target.setId_mm(source.getId_mm());
		target.setMm_code(source.getMm_code());
		target.setMm_name(source.getMm_name());
		target.setMm_dosform(source.getMm_dosform());
		target.setMm_unit(source.getMm_unit());
		target.setMm_spec(source.getMm_spec());
		target.setMm_price(source.getMm_price());
		target.setMm_pycode(source.getMm_pycode());
		target.setMm_wbcode(source.getMm_wbcode());
		target.setMm_sup(source.getMm_sup());
		target.setMm_abrd(source.getMm_abrd());
		target.setMm_sd_abrd(source.getMm_sd_abrd());
		target.setMm_fg_otc(source.getMm_fg_otc());
		target.setMm_apprno(source.getMm_apprno());
		target.setMm_factor_sb(source.getMm_factor_sb());
		target.setMm_place(source.getMm_place());
		target.setId_hpsrvorca(source.getId_hpsrvorca());
		target.setEu_hpsrvtp(source.getEu_hpsrvtp());
		target.setEu_status(source.getEu_status());
		if (target.getStatus() == DOStatus.UNCHANGED) {
			target.setStatus(DOStatus.UPDATED);
		}
		return target;
	}
	
	/**
	 * FArrayList转List
	 * @author zhang.hw
	 * @date 2019年7月18日
	 * @param fArrayList
	 * @return
	 */
	public static <T> List<T> ToList(FArrayList fArrayList){
		List<T> list = new ArrayList<T>();
		Iterator<T> iterator = fArrayList.iterator();
		while(iterator.hasNext()){
			list.add(iterator.next());
		}
		
		return list;
	}

	/**
	 * 病种(诊断)DTO转换
	 * @author zhang.hw
	 * @date 2019年7月30日
	 * @param source
	 * @param target
	 * @return
	 */
	public static DiCompDTO copy(DiCompDTO source, DiCompDTO target) {
		target.setId_didef(source.getId_didef());
		target.setId_hp(source.getId_hp());
		target.setId_hpdivshis(source.getId_hpdivshis());
		target.setEu_status(source.getEu_status());
		target.setHis_didef_code(source.getHis_didef_code());
		target.setHis_didef_name(source.getHis_didef_name());
		if (target.getStatus() == DOStatus.UNCHANGED) {
			target.setStatus(DOStatus.UPDATED);
		}
		return target;
	}
	
}
