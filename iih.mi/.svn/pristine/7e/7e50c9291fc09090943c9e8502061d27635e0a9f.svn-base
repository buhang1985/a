package iih.mi.mc.s.bp;

import iih.bd.base.utils.SqlUtils;
import iih.bd.pp.hp.d.HpDosageDO;
import iih.bd.pp.hp.i.IHpDosageDORService;
import iih.mi.itf2.util.MiParamUtil;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;
import org.springframework.util.StringUtils;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 获取医保对应的重复开药排斥剂型
 * @author LIM
 * @return
 */
public class MiGetControlHpDosage {
	/**
	 * 获取医保对应的重复开药排斥剂型
	 * @param id_hp 医保计划id
	 * @return
	 * @throws BizException 
	 */
	public String[] exec(String id_hp) throws BizException{
		List<String> dosageList= new ArrayList<String>();
		//1、获取参数设置的重复开药排斥剂型
		String id_doas=MiParamUtil.MI3002(id_hp);
		String[] doasArr= new String[]{};
		if(!StringUtils.isEmpty(id_doas)){
			doasArr=id_doas.split(",");
		}else{
			return null;
		}
		//2.查询医保对应的剂型
		String whereStr = SqlUtils.getInSqlByIds("id_dosage", doasArr);
		 whereStr +=" and id_hp='"+ id_hp +"'";
		IHpDosageDORService ser = ServiceFinder.find(IHpDosageDORService.class);
		HpDosageDO[] hpDosageDOArr= ser.find(whereStr, "", FBoolean.FALSE);
		if(ArrayUtils.isNotEmpty(hpDosageDOArr)){
			for(HpDosageDO hpDosageDO:hpDosageDOArr){
				if(!StringUtils.isEmpty(hpDosageDO.getCode_hp())){
					dosageList.add(hpDosageDO.getCode_hp());
				}
			}
		}
		return dosageList.toArray(new String[]{});
	}
}
