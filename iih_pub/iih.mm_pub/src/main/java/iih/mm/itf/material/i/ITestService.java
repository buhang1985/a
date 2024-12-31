package iih.mm.itf.material.i;

import xap.mw.core.data.BizException;

public interface ITestService {

	public void testAll() throws BizException;
	
	public void testReserveMaterials(String type) throws BizException;
	
	public void testGetMaterialStocks() throws BizException;
	
	public void testReserveDeliver() throws BizException;
	
	public void testDirectDeliver() throws BizException;
	
	public void testReturnMaterial() throws BizException;
}
