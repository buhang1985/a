package iih.ems.eass.emcard.i;

import iih.ems.eass.emcard.d.EmCardDO;
import iih.ems.einv.emin.d.EminAggDO;
import iih.ems.embd.eminfo.d.EmsInfoDO;
import xap.mw.core.data.BizException;

public interface IEmcardExtService {

	/**
	*  资产卡初始化
	 * @throws BizException 
	*/
	public abstract EmCardDO initEmcard(EmsInfoDO infoDO) throws BizException;
	/**
	*  资产卡入库及资产卡片数据保存
	 * @throws BizException 
	*/
	 public abstract  EmCardDO[] SaveEmcard(EminAggDO eminAggDO,EmCardDO emCardDO) throws BizException;
	 
	 /**
		*  资产卡入库及资产卡片数据提交
		 * @throws BizException 
		*/
	 public abstract  EmCardDO[] SubmitEmcard(EmCardDO[] emcardDos) throws BizException;
	 
	 /**
		*  资产卡入库及资产卡片数据审核
		 * @throws BizException 
		*/
	 public abstract  EmCardDO[] CheckEmcard(EmCardDO[] emcardDos) throws BizException;
}
