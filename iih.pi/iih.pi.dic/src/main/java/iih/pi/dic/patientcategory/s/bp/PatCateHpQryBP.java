package iih.pi.dic.patientcategory.s.bp;

import java.util.HashMap;
import java.util.Map;

import iih.pi.dic.patcatehp.d.PiPatCaHpDO;
import iih.pi.dic.patcatehp.i.IPatcatehpRService;
import iih.pi.dic.patientcategory.d.PiPatCaDO;
import iih.pi.dic.patientcategory.d.desc.PiPatCaDODesc;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 患者分类检索时补充患者分类医保计划
 * @author ly 2017/06/25
 *
 */
public class PatCateHpQryBP {

	/**
	 * 患者分类检索时补充患者分类医保计划
	 * @param patCaDos
	 * @throws BizException
	 */
	public void exec(PiPatCaDO[] patCaDos) throws BizException{
		
		if(ArrayUtil.isEmpty(patCaDos))
			return;
		
		String inSql = "(";
		for (PiPatCaDO patCaDo : patCaDos) {
			inSql += "'" + patCaDo.getId_patca() + "',";
		}
		inSql = inSql.substring(0, inSql.length() - 1);
		inSql += ")";
		
		IPatcatehpRService rService = ServiceFinder.find(IPatcatehpRService.class);
		String whereSql = PiPatCaDODesc.TABLE_ALIAS_NAME + ".id_patca in " + inSql;
		PiPatCaHpDO[] caHpDos = rService.find(whereSql, "", FBoolean.FALSE);
		
		if(ArrayUtil.isEmpty(caHpDos))
			return;
		
		Map<String,PiPatCaHpDO> caHpMap = new HashMap<String,PiPatCaHpDO>();
		for (PiPatCaHpDO caHpDo : caHpDos) {
			caHpMap.put(caHpDo.getId_patca(), caHpDo);
		}
		
		//对入参补充患者分类医保计划相关字段
		for (PiPatCaDO patCaDo : patCaDos) {
			
			PiPatCaHpDO hpDo = caHpMap.get(patCaDo.getId_patca());
			if(hpDo == null)
				continue;
			
			patCaDo.setId_patcahp(hpDo.getId_patcahp());
			patCaDo.setId_hp(hpDo.getId_hp());
			patCaDo.setName_hp(hpDo.getName_hp());
			patCaDo.setId_hpkind(hpDo.getId_hpkind());
			patCaDo.setName_hpkind(hpDo.getName_hpkind());
			patCaDo.setFg_fundpay(hpDo.getFg_fundpay());
			patCaDo.setFg_hp_card(hpDo.getFg_hp_card());
		}
	}
}
