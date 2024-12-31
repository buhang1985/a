package iih.bd.mm.iemsg;

import java.util.ArrayList;

import iih.bd.mm.iemsg.d.SuppliersDTO;
import iih.bd.mm.iemsg.qry.SuppliEventSql;
import iih.bd.mm.supplier.d.SupplierDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 获取生产商和供应商修改后数据。
 * @author shao_yuan
 *
 */

public class SuppliEventBp {

	public SuppliersDTO[] setSupliDTO(SupplierDO[] suplist,String eventtype) throws BizException {		
		
		//获得生产商和供应商数据信息
		SuppliEventSql sql = new SuppliEventSql();
		SuppliersDTO[] ors=sql.setByStatu(suplist,eventtype);
		return ors;
	}

	public SupplierDO[] getSupList(SupplierDO[] ors) {
		
		ArrayList<SupplierDO> rtn=new ArrayList<SupplierDO>();
		for(SupplierDO supdo : ors){
			
			if(supdo.getFg_sup() == FBoolean.TRUE){
				
				rtn.add(supdo);											
			}									
		}				
		return rtn.toArray(new SupplierDO[0]);
	}
	
	
	
public SupplierDO[] getFacList(SupplierDO[] ors) {
		
		ArrayList<SupplierDO> rtn=new ArrayList<SupplierDO>();
		for(SupplierDO supdo : ors){
			
			if(supdo.getFg_fac() == FBoolean.TRUE){
				
				rtn.add(supdo);											
			}									
		}				
		return rtn.toArray(new SupplierDO[0]);
	}

}
