package iih.mi.mc.s.bp;

import iih.bd.base.utils.SqlUtils;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.pp.hp.d.HpFreqDO;
import iih.bd.pp.hp.i.IHpFreqDORService;
import iih.bd.srv.freqdef.d.FreqDefDO;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
/**
 * 获取医保对应的单次执行频次
 * @author LIM
 * @return
 */
public class MiGetControlHpFreq {
	/**
	 * 获取医保对应的单次执行频次
	 * @param id_hp 医保计划id
	 * @return
	 */
	public String[] exec(String id_hp)throws BizException{
		List<String> freqList= new ArrayList<String>();
		//1.获取单频次数据id
		List<String> idFreqList=this.getOnceFreqMap();
		if (!ListUtil.isEmpty(idFreqList)) {
		//2.查询对应医保频次	
			String whereStr = SqlUtils.getInSqlByIds("id_freq", idFreqList);
			 whereStr +=" and id_hp='"+ id_hp +"'";
			IHpFreqDORService ser=ServiceFinder.find(IHpFreqDORService.class);
			HpFreqDO[] hpFreqDOArr=ser.find(whereStr, "", FBoolean.FALSE);
			if(!ArrayUtils.isEmpty(hpFreqDOArr)){
				for(HpFreqDO hpFreqDO:hpFreqDOArr){
					freqList.add(hpFreqDO.getCode_hp());
				}			
			}	
		}
		return freqList.toArray(new String[]{});
	}
	
	/**
	 * 获取单次频次数据
	 * 
	 * @return
	 * @throws BizException
	 */
	public List<String> getOnceFreqMap() throws BizException {
		List<String> idFreqList= new ArrayList<String>();
		String[] fields = new String[] { FreqDefDO.ID_FREQ, FreqDefDO.CODE };
		@SuppressWarnings("unchecked")
		List<FreqDefDO> freqDOLst = (List<FreqDefDO>) new DAFacade().findByAttrValString(FreqDefDO.class, FreqDefDO.SD_FREQUNITCT,
				IBdSrvDictCodeConst.SD_FREQNUNITCT_ONCE, fields);
		if (!ListUtil.isEmpty(freqDOLst)) {
			for (FreqDefDO freqDefDO : freqDOLst) {
				idFreqList.add(freqDefDO.getId_freq());
			}
		}
		return idFreqList;
	}
}
