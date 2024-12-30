package iih.sc.sch.s.bp;

import java.util.ArrayList;
import java.util.List;

import org.apache.cxf.wsdl11.SchemaUtil;

import iih.sc.comm.ScAppUtils;
import iih.sc.comm.ScSqlUtils;
import iih.sc.sch.s.ep.SchChlEP;
import iih.sc.sch.s.ep.SchEP;
import iih.sc.sch.s.ep.TickEP;
import iih.sc.sch.s.ep.TicksEP;
import iih.sc.sch.scsch.d.ScSchDO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;

/**
 * 根据排班ID批量删除排班相关数据
 * @author yankan，renying
 *
 */
public class DeleteSchBP {
	/**
	 * 删除排班
	 * @param schIdList 排班ID集合
	 * @throws BizException
	 */
	public boolean exec(List<String> schIdList) throws BizException{
		if(ListUtil.isEmpty(schIdList)){
			return false;
		}
		//0.校验数据
		this.validateSchDO(schIdList);
		
		//1、删除号位
		new TickEP().deleteTickBySchIds(schIdList);
		
		//2、删除号段
		new TicksEP().deleteTicksBySchIds(schIdList);
		
		//3、删除排班人员			
		new SchChlEP().deleteByEmpIds(schIdList);
		
		//4、删除排班就诊
		new SchChlEP().deleteByEnIds(schIdList);
		
		//5、删除排班渠道
		new SchChlEP().deleteBySchIds(schIdList);
		
		//6、删除排班
		SchEP schep = new SchEP();
		ScSchDO[] schs = schep.getByPKs(schIdList.toArray(new String[0]));
		schep.delete(schs);
		
		return true;
	}
	/**
	 * 校验排班是不是被使用
	 * @param schIdList
	 * @throws BizException
	 */
	private void validateSchDO(List<String> schIdList) throws BizException{
		//0.校验数据
		SchEP ep = new SchEP();
		ScSchDO[] schDOs = ep.getByIds(schIdList.toArray(new String[]{}));
		if(ArrayUtil.isEmpty(schDOs)){
			throw new BizException("未检索到排班");
		}
		for(ScSchDO schDO :schDOs){
			if(schDO.getQuan_total_used() !=null && schDO.getQuan_total_used()!= 0)
				throw new BizException("排班已经被使用，请刷新数据重新选择");
			if(schDO.getD_sch().before(ScAppUtils.getServerDate())){
				throw new BizException("排班已经过期，请重新选择");
			}
		}
	}
}
