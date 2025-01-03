package iih.mi.mc.mimcpatspec.s.bp;

import iih.mi.mc.mimcpatspec.d.MiMcPatSpecDO;
import iih.mi.mc.mimcpatspec.d.MimcpatspecdiAggDO;
import iih.mi.mc.mimcpatspec.i.IMimcpatspecdiMDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
/**
 * 医保特殊病患者诊断保存前校验
 * @author liming06
 *
 */
public class MiMcSpecPatCuBeforeBp {
	public void exec(MimcpatspecdiAggDO mimcpatspecdiAggDO) throws BizException {
		
		if(mimcpatspecdiAggDO == null || mimcpatspecdiAggDO.getParentDO()==null) {
			throw new BizException("入参为空。");
		}
		validaPara(mimcpatspecdiAggDO.getParentDO());
	}
	
	private void validaPara(MiMcPatSpecDO miMcPatSpecDO) throws BizException {
		if(StringUtil.isEmptyWithTrim(miMcPatSpecDO.getId_hp())){
			throw new BizException("医保计划不能为空");
		}
		if(StringUtil.isEmptyWithTrim(miMcPatSpecDO.getId_pat()) && StringUtil.isEmptyWithTrim(miMcPatSpecDO.getNo_hp())){
			throw new BizException("手工录入特殊病患者医保卡号不能为空");
		}
		String whereStr=" Id_hp='"+ miMcPatSpecDO.getId_hp() +"'";
		if(!StringUtil.isEmptyWithTrim(miMcPatSpecDO.getId_pat())){
			whereStr += " and id_pat='"+  miMcPatSpecDO.getId_pat() +"'";
		}else{
			whereStr += " and no_hp='"+  miMcPatSpecDO.getNo_hp() +"'";
		}

		if(!StringUtil.isEmpty(miMcPatSpecDO.getId_mimcpatspec())){
			whereStr+=" and Id_mimcpatspec<>'"+ miMcPatSpecDO.getId_mimcpatspec() +"'";
		}
		IMimcpatspecdiMDORService ser= ServiceFinder.find(IMimcpatspecdiMDORService.class);
		MiMcPatSpecDO[] miMcPatSpecDOArr=ser.find(whereStr, "", FBoolean.FALSE);
		if(!ArrayUtil.isEmpty(miMcPatSpecDOArr)){
			throw new BizException("已存在相同记录");
		}
	}
}
