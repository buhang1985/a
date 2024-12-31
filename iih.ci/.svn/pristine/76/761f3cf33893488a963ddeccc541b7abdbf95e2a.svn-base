package iih.ci.ord.s.utils;

import java.util.List;

import iih.bd.mm.meterial.d.MMPackageUnitDO;
import iih.bd.mm.meterial.d.MeterialAggDO;
import iih.ci.ord.pub.CiOrdAppUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDouble;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class GetDrugSaleFactor {
	/**
	 * 获取物品总量单位的换算系数
	 * @param meterial
	 * @param id_unit_sale
	 * @return
	 * @throws BizException 
	 */
	public FDouble exec(String id_mm ,String id_unit_sale) throws BizException{
		//MeterialAggDO meterial = CiOrdAppUtils.getIMeterialRService().findById(id_mm);
		 //有多条记录，怎么区分 TODO
		 DAFacade dafacade = new  DAFacade();
		 String sql =" select Factor,Id_unit_pkg from   BD_MM_PKGU  where id_mm= ? and id_unit_pkg= ? ";
		 SqlParam sqlParam = new SqlParam();
		 sqlParam.addParam(id_mm);
		 sqlParam.addParam(id_unit_sale);
		 List<MMPackageUnitDO> MMPackageUnitDOS= (List<MMPackageUnitDO>)dafacade.execQuery(sql, sqlParam, new BeanListHandler(MMPackageUnitDO.class));
		 if(MMPackageUnitDOS != null && id_unit_sale != null)
		{
			for (MMPackageUnitDO item : MMPackageUnitDOS){
				if(item.getId_unit_pkg().equals(id_unit_sale)){
					return item.getFactor();
				}
			}
		}
		return FDouble.ONE_DBL;
	}
}
