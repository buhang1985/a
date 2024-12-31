package iih.bd.fc.s.bp;

import iih.bd.fc.pub.BdFcAppUtils;
import iih.bd.fc.pub.BdFcUtils;
import iih.bd.srv.srvcate.d.SrvCateDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
/*
 * 获得服务基本分类路径匹配串操作BP
 */
public class GetBdSrvcaMatchStrBP {
	/**
	 * 获得服务基本分类路径匹配串
	 * @param id_srvcas
	 * @return
	 * @throws BizException
	 */
	public String[] exec(String[] id_srvcas) throws BizException {
		if(BdFcUtils.isEmpty(id_srvcas))return null;
		SrvCateDO[] srvcas=BdFcAppUtils.getBdSrvCaQryService().findByBIds(id_srvcas, FBoolean.FALSE);
		if(srvcas==null)return null;
		return getPathStr(srvcas);
	}
	
	private String[] getPathStr(SrvCateDO[] srvcas){
		String[] rtns=new String[srvcas.length];
		for(int i=0;i<srvcas.length;i++){
			rtns[i]=srvcas[i].getCode();  //getInnercode()实际上应该为此
		}
		return rtns;
	}

}
