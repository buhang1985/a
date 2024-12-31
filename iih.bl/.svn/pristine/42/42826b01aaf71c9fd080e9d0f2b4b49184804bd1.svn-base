package iih.bl.vv.s.bp;

import java.util.ArrayList;
import java.util.List;

import iih.bl.vv.cpn.d.BlCpnDO;
import iih.bl.vv.cpnin.d.BlCpnInDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;

public class BlcpninAddBp {
	
	public BlCpnDO[] exec(BlCpnInDO bi,int BlCpnAddCodeLen) throws BizException{
		
		
		return assembleBlCpnDOs( bi,BlCpnAddCodeLen);
	}
	
	private BlCpnDO[] assembleBlCpnDOs(BlCpnInDO bi,int BlCpnAddCodeLen) throws BizException{
		
		List<BlCpnDO> list=new ArrayList<BlCpnDO>();
		int leg=0;
		int num_b =0;
        int num_e =0;
        num_b=bi.getNum_b();
        num_e=bi.getNum_e();
        leg= num_e-num_b+1;
        if (bi.getNum_b() == null && bi.getNum_e() == null)
        {
        	return  null;
        }
        String ruleValue=bi.getCoderule_cpn();
        ruleValue = ruleValue.replace("{分类编码}",bi.getCode_cpnca());
        String ruleStart = ruleValue.substring(0, ruleValue.indexOf("{"));
        String ruleEnd = ruleValue.substring(ruleValue.indexOf("}") + 1);
        
        //编码重复校验
        boolean checkNumber = this.checkNumber(ruleStart+setBlCpnCodeNumInfo(num_b+"",BlCpnAddCodeLen)+ruleEnd,ruleStart+setBlCpnCodeNumInfo(num_e+"",BlCpnAddCodeLen)+ruleEnd);
        if(checkNumber){
        	return null;
        }
        
      //新增num_b - num_e +1 个优惠券，构成子数据数组
        for (int i = 0; i < leg;i++ )
        {
           BlCpnDO  newCpnDO=new BlCpnDO();
           newCpnDO.setId_grp(Context.get().getGroupId());
           newCpnDO.setId_org(Context.get().getOrgId());
           newCpnDO.setId_cpnca(bi.getId_cpnca());
           newCpnDO.setFg_iss(FBoolean.FALSE);
           newCpnDO.setId_org(bi.getId_org());
           newCpnDO.setId_emp_iss(null);
           newCpnDO.setId_pat_own(null);
           newCpnDO.setFg_used(FBoolean.FALSE);
           StringBuilder sb = new StringBuilder();
            //每个优惠券的编码为   开始字符串+i+结束字符串
           sb.append(ruleStart).append(setBlCpnCodeNumInfo((i+num_b)+"",BlCpnAddCodeLen)).append(ruleEnd);
           newCpnDO.setCode(sb.toString());
           newCpnDO.setStatus(DOStatus.NEW);
           list.add(newCpnDO);
        }
        return list.toArray(new BlCpnDO[0]);

	}
	 /// <summary>
    /// 根据某个数字字符和长度生成对应长度的编码串，比如数字字符为1 长度为8位 则生成的8位编码串为“00000001”
    /// </summary>
    /// <param name="numStr"></param>
    /// <param name="count"></param>
    /// <returns></returns>
    private String setBlCpnCodeNumInfo(String numStr, int count)
    {
        if (numStr.length() < count)
        {
            numStr = "0" + numStr;
            numStr = setBlCpnCodeNumInfo(numStr, count);
        }
        return numStr;
    }
    
    private boolean checkNumber(String start,String end) throws BizException{
    	
    	StringBuilder str =new StringBuilder();
    	str.append(" select count(1) from bl_cpn where 1=1 ");
    	str.append(" and code>='").append(start).append("' ");
    	str.append(" and code<='").append(end).append("' ");
		@SuppressWarnings("unchecked")
		List<Integer> countList = (List<Integer>) new DAFacade().execQuery(str.toString(), new ColumnListHandler());	
		if(!ListUtil.isEmpty(countList)&&countList.get(0)>=1){
			return true;
		}
    	return false;
    }
}
